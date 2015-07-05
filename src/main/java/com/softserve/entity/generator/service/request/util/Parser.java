package com.softserve.entity.generator.service.request.util;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Parser
{

    public String parseSObjectJson(String sObjectJson, Class fieldName) {
        String removeRecords = "\"records\" : \\[ \\{.*? \\},";
        sObjectJson = Pattern.compile(removeRecords, Pattern.DOTALL).matcher(sObjectJson).replaceAll("");

        String removeAttributes = "\"attributes\" : \\{.*?\\},";
        sObjectJson = Pattern.compile(removeAttributes, Pattern.DOTALL).matcher(sObjectJson).replaceAll("");

        String remove = " \"totalSize\" : .,.*?,";
        sObjectJson = Pattern.compile(remove, Pattern.DOTALL).matcher(sObjectJson).replaceAll("");

            sObjectJson = sObjectJson
                                        .replaceAll("\\]","] }")
                                        .replaceAll("\\}\\n.*} \\] \\}\\n.*\\}","")
                                        .replaceAll("\"[A-Z].*__r\" : \\{", "\"fields\" : \\[ \\{")
                                        .replaceAll("__c","")
                                        .replaceAll("ColumnName","columnName")
                                        .replaceAll("\"EntityId\"","{ \"entityId\"")
                                        .replaceAll("TableName","tableName")
                                        .replaceAll("Name","name")
                                        .replaceAll("Type","type")
                                        .replaceAll("FieldId","fieldId")
                                        .replaceAll("\"Entity\" : .*?,","");




        StringBuilder stringBuilder = new StringBuilder(sObjectJson);



        System.out.println("-----------------");
        System.out.println(stringBuilder);
        System.out.println("-----------------");

        return sObjectJson;
    }
}
