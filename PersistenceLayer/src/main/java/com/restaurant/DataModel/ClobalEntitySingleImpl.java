package com.restaurant.DataModel;

/**
 * Created by Martha on 2/28/2017.
 */
public class ClobalEntitySingleImpl<T> implements GlobalEntity{

    private String entityName;
    private T entity;

    public ClobalEntitySingleImpl(String entityName, T entity) {
        this.entityName = entityName;
        this.entity = entity;
    }

    @Override
    public GlobalEntity getPackage() {
        return this;
    }
}
