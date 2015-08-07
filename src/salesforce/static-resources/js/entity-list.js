$(function ()
{
    init();

    var input = $('.input').first();
    var times = 0;
    input.focus(function ()
    {
        input.blur();
        times++;
        if (times === 2) //don't ask why
        {
            input.off('focus');
        }
    });

    EntityListController.isGenerateButtonVisible
    (
        function (result, event)
        {
            setGenerateButtonVisibility(result);
        }
    );
});

function init()
{
    $('[data-toggle="popover"]').popover();
}

function resolveChanges(entityId)
{
    callResolveChanges(entityId);
}

function setGenerateButtonVisibility(isVisible)
{
    var buttonBlock  =  $('.generate-block');

    console.log(buttonBlock);
    console.log(isVisible);
    if (isVisible)
    {
        buttonBlock.show();
    }
    else
    {
        buttonBlock.hide();
    }
}

function generateTableName(context)
{
    var name = null;

    $(context)
        .parent()
        .parent()
        .prev()
        .children()
        .children('input')
        .each(function (index, element)
        {
            name = element.value;
        });

    if (!context.value)
    {
        context.value = name
            .replace(/ /g, '_')
            .replace(/\d+/g, '')
            .replace(/\W/g, '')
            .toUpperCase();
    }
}

function fillForReset()
{
    $('.input')
        .filter(function (index, element)
        {
            return !element.value;
        })
        .each(function (index, element)
        {
            element.value = 'resetting...';
        });
}

function initAndDeleteErrors()
{
    init();
    $('.errorMsg').remove();
}

function deleteEntity(tableName)
{
    $("#dialog-confirm").dialog(
        {
            resizable: false,
            height: 'auto',
            width: 500,
            modal: true,
            dialogClass: 'confirmation-dialog',
            buttons: {
                "Delete": function ()
                {
                    callDeleteEntity(tableName);
                    $(this).dialog("close");
                },
                Cancel: function ()
                {
                    $(this).dialog("close");
                }
            }
        });
}

function generateTables()
{
    EntityListController.generateTables
    (
        function (result, event)
        {
            console.log(result);
}
    );
}
