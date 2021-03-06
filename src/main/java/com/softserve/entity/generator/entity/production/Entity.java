package com.softserve.entity.generator.entity.production;

import com.softserve.entity.generator.entity.DatabaseObject;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;

import javax.persistence.*;
import java.util.*;

@javax.persistence.Entity
@Table(name = "ENTITY")
public class Entity extends DatabaseObject
{
    @Id
    @Column(name = "Entity_Id")
    private String entityId;

    @Column(name = "Table_Name")
    private String tableName;

    @Column(name = "Name")
    private String name;

    @OneToMany(mappedBy = "entity", cascade = {CascadeType.ALL}, orphanRemoval = true)
    private Set<Field> fields = new HashSet<Field>();

    @Column(name = "Is_Processing_Needed")
    private Boolean isProcessingNeeded;

    protected Entity() {}

    public Entity(String entityId, String name, String tableName)
    {
        this.entityId = entityId;
        this.name = name;
        this.tableName = tableName;
    }

    public Boolean getIsProcessingNeeded()
    {
        return isProcessingNeeded;
    }

    public void setIsProcessingNeeded(Boolean isProcessingNeeded)
    {
        this.isProcessingNeeded = isProcessingNeeded;
    }

    public String getEntityId()
    {
        return entityId;
    }

    private void setEntityId(String entityId)
    {
        this.entityId = entityId;
    }

    public String getName()
    {
        return name;
    }

    private void setName(String name)
    {
        this.name = name;
    }

    public String getTableName()
    {
        return tableName;
    }

    private void setTableName(String tableName)
    {
        this.tableName = tableName;
    }

    public Set<Field> getFields()
    {
        return fields;
    }

    public void setFields(Set<Field> fields)
    {
        this.fields = fields;
    }

    @Override
    public boolean equals(Object o)
    {
        if (this == o) { return true; }

        if (o == null || getClass() != o.getClass()) { return false; }

        Entity entity = (Entity) o;

        return new EqualsBuilder()
                .append(entityId, entity.entityId)
                .isEquals();
    }

    @Override
    public String toString()
    {
        return "Entity{" +
                "entityId='" + entityId + '\'' +
                ", tableName='" + tableName + '\'' +
                ", name='" + name + '\'' +
                ", fields=" + fields +
                ", isProcessingNeeded=" + isProcessingNeeded +
                '}';
    }

    @Override
    public int hashCode()
    {
        return new HashCodeBuilder(17, 37)
                .append(entityId)
                .toHashCode();
    }
}
