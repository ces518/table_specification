package me.june.table.specification.entity;

/**
 * Created by IntelliJ IDEA.
 * User: june
 * Date: 2019-08-20
 * Time: 22:15
 **/
public class ColumnMetaData {
    private String columnName;
    private String columnSize;
    private String autoIncrement;
    private String type;
    private String isNullable;
    private String remarks;

    public String getColumnName() {
        return columnName;
    }

    public void setColumnName(String columnName) {
        this.columnName = columnName;
    }

    public String getColumnSize() {
        return columnSize;
    }

    public void setColumnSize(String columnSize) {
        this.columnSize = columnSize;
    }

    public String getAutoIncrement() {
        return autoIncrement;
    }

    public void setAutoIncrement(String autoIncrement) {
        this.autoIncrement = autoIncrement;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getIsNullable() {
        return isNullable;
    }

    public void setIsNullable(String isNullable) {
        this.isNullable = isNullable;
    }

    public String getRemarks() {
        return remarks;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }

    @Override
    public String toString() {
        return "ColumnMetaData{" +
                "columnName='" + columnName + '\'' +
                ", columnSize='" + columnSize + '\'' +
                ", autoIncrement='" + autoIncrement + '\'' +
                ", type='" + type + '\'' +
                ", isNullable='" + isNullable + '\'' +
                ", remarks='" + remarks + '\'' +
                '}';
    }
}
