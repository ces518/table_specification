package me.june.table.specification.entity;

import java.util.List;

/**
 * Created by IntelliJ IDEA.
 * User: june
 * Date: 2019-08-20
 * Time: 22:14
 **/
public class TableMetaData {
    private String tableName;
    private List columns;

    public String getTableName() {
        return tableName;
    }

    public void setTableName(String tableName) {
        this.tableName = tableName;
    }

    public List getColumns() {
        return columns;
    }

    public void setColumns(List columns) {
        this.columns = columns;
    }
}
