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
    private String remarks;
    private List columns;

    public String getTableName() {
        return tableName;
    }

    public void setTableName(String tableName) {
        this.tableName = tableName;
    }

    public String getRemarks() {
        return remarks;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }

    public List getColumns() {
        return columns;
    }

    public void setColumns(List columns) {
        this.columns = columns;
    }

    @Override
    public String toString() {
        return "TableMetaData{" +
                "tableName='" + tableName + '\'' +
                ", remarks='" + remarks + '\'' +
                ", columns=" + columns +
                '}';
    }
}
