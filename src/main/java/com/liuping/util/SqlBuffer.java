package com.liuping.util;

/**
 * Created by liuping on 15/12/24.
 */
public class SqlBuffer {

    private StringBuilder stringBuffer = new StringBuilder();

    public SqlBuffer(){

    }

    public SqlBuffer(String sqlFragment){
        stringBuffer.append(sqlFragment + " ");
    }

    public SqlBuffer append(String sqlFragment){
        stringBuffer.append(sqlFragment + " ");
        return this;
    }

    public String toString(){
        return stringBuffer.toString();
    }

    /**
     * "helloWorld" = "HELLO_WORLD"
     * @param columnName
     * @return
     */
    public static final String getColumnName(String columnName){
        return columnName.replaceAll("[A-Z]", "_$0").toUpperCase();
    }
}
