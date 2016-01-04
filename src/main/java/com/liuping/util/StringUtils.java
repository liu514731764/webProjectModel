package com.liuping.util;

import net.sf.json.JSONObject;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;

/**
 * Created by liuping on 15/12/24.
 */
public class StringUtils extends org.apache.commons.lang.StringUtils{
    public static String DATE_PATTERN = "yyyy-MM-dd HH:mm:ss";
    public static String DATETIME_PATTERN="yyyyMMddHHmm";
    public static String VALIDATETIME_PATTERN="yyyy-MM-dd HH:mm";
    public static Date getDate() throws ParseException {
        SimpleDateFormat sdf = new SimpleDateFormat(StringUtils.DATE_PATTERN);
        return sdf.parse(getCurrentDateString());
    }
    public static Date getNowDate() throws ParseException {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        return sdf.parse(getCurrentDateString());
    }

    public static String getCurrentDateString() {
        Date d = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat(StringUtils.DATE_PATTERN);
        return sdf.format(d);
    }
    public static String getDateString() {
        Date d = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmss");
        return sdf.format(d);
    }

    public static String getDateString(Date date){
        SimpleDateFormat sdf = new SimpleDateFormat(StringUtils.DATE_PATTERN);
        return sdf.format(date);
    }

    public static String getNowDateString() {
        Date d = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat(StringUtils.DATETIME_PATTERN);
        return sdf.format(d);
    }

    public static Date getValidateTime(String validateTime){
        try {
            SimpleDateFormat sdf = new SimpleDateFormat(StringUtils.VALIDATETIME_PATTERN);
            return sdf.parse(validateTime);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return null;
    }
    public static Date getValidateDate(String validateTime){
        try {
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
            return sdf.parse(validateTime);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return null;
    }
    /**
     * 得到逗号分隔的字符串
     * 将String[]数组转换成"a$b$c"的字符串
     * @param strs[]
     * @return String
     * EditBy: dyb
     */
    public static String getCommaString(String[] strs){
        StringBuffer dest=new StringBuffer();
        if(strs==null || strs.length==0){
            return "";
        }else{
            for(int i=0;i<strs.length;i++){
                dest.append(strs[i]).append("$");
            }
            return dest.deleteCharAt(dest.length()-1).toString();
        }
    }
    public static boolean isNullOrEmpty(String source) {
        return source == null || source.isEmpty();
    }

    /***
     * 得到通过以逗号分隔的数组
     * Method:getStringByComma
     * @param strs
     * @return
     * Return: String
     * @since  1.0.0
     * EditBy: dyb
     */
    public static String getStringByComma(String[] strs){
        StringBuffer dest=new StringBuffer();
        if(strs==null || strs.length==0){
            return "";
        }else{
            for(int i=0;i<strs.length;i++){
                dest.append(strs[i]).append(",");
            }
            return dest.deleteCharAt(dest.length()-1).toString();
        }
    }
    /***
     * 将a,b,c转换为'a','b','c'
     * Method:getQuoteString
     * @param srcString
     * @return
     * Return: String
     * @since  1.0.0
     * EditBy: dyb
     */
    public static String getQuoteString(String srcString){
        String[] strs=srcString.split(",");
        String newStr="";
        for(String str:strs){
            newStr+="'"+str+"',";
        }
        newStr=newStr.substring(0,newStr.length()-1);
        return newStr;
    }

    /***
     * 转换String，将空或者空字符串转换为""，其它不变
     * Method:getString
     * @param str
     * @return
     * Return: String
     * @since  1.0.0
     * EditBy: dyb
     */
    public static String getString(String str) {
        if (str==null || str.trim().length()==0 || "null".equals(str.trim())) {
            return "";
        }
        return str.trim();
    }

    public static String getString(Object obj){
        if(obj==null){
            return "";
        }else if(obj instanceof String ||
                obj instanceof Integer ||
                obj instanceof Float ||
                obj instanceof Boolean ||
                obj instanceof Short ||
                obj instanceof Double ||
                obj instanceof Long ||
                obj instanceof BigDecimal ||
                obj instanceof BigInteger ||
                obj instanceof Byte) {
            return obj.toString();
        }
        return "";
    }

    /****
     * 将a,b,c这样的结构转为“信息化工程部,财务部,创新业务部"这样的结构
     * Method:getLinkedString
     * @param linkStr(a,b,c)
     * @param separate
     * @param linkedMap[a=信息化工程部,b=财务部，c=创新业务部]
     * @return
     * Return: String
     * @since  1.0.0
     * EditBy: dyb
     */
    public static String getLinkedString(String linkStr,String separate,LinkedHashMap<String, String> linkedMap){
        Set<Map.Entry<String,String>> entrySet=linkedMap.entrySet();
        String[] strs=linkStr.split(separate);
        String newStr="";
        for(Map.Entry<String,String> entry:entrySet){
            for(String str:strs){
                if(str.trim().equals((String)entry.getKey().trim())){
                    newStr+=entry.getValue().trim()+",";
                }
            }
        }
        newStr=newStr.substring(0,newStr.length()-1);
        return newStr;
    }

    /****
     * 将a,b,c这样的结构转为“信息化工程部,财务部,创新业务部"这样的结构
     * Method:getLinkedString
     * @param linkStr(a,b,c)
     * @param separate
     * @param mDept{[a=1],[b=2],[c=3]}
     * @return
     * Return: String
     * @since  1.0.0
     * EditBy: dyb
     */
    public static String getLinkedString(String linkStr,String separate,String[][] mDept){
        String[] strs=linkStr.split(separate);
        String newStr="";
        for (int i = 0; i < mDept.length; i++) {
            for(String str:strs){
                if(mDept[i][0].trim().equals(str.trim())){
                    newStr+=mDept[i][1]+",";
                }
            }
        }
        newStr=newStr.substring(0,newStr.length()-1);
        return newStr;
    }



    /***全角转半角*/
    public static String toDBC(String input) {
        char[] c = input.toCharArray();
        for (int i = 0; i < c.length; i++) {
            if (c[i] == 12288) {
                c[i] = (char)32;
                continue;
            }
            if (c[i] > 65280 && c[i] < 65375)
                c[i] = (char) (c[i] - 65248);
        }
        return new String(c);
    }


    /***
     * 中文转码
     * Method:transferStr
     * @param str
     * @return
     * Return: String
     * @throws
     * @since  1.0.0
     * EditBy: dyb
     */
    public static String transferStr(String str){
        String aString="";
        if(str.trim().length()>0){
            try{
                aString=new String(str.getBytes("UTF-8"),"ISO8859-1");
            }catch(Exception exception){

            }
            return aString;
        }else{
            return str;
        }
    }

    public static String convertISO8859_1ToGBK(String str){
        String aString="";
        if(str.trim().length()>0){
            try{
                aString=new String(str.getBytes("ISO8859-1"),"UTF-8");
            }catch(Exception exception){

            }
            return aString;
        }else{
            return str;
        }
    }

    public static PrintWriter getJSONString(HttpServletResponse response, String jsonString) throws IOException {
        response.setContentType("text/html");
        response.setCharacterEncoding("UTF-8");
        response.setHeader("Pragma", "no-cache");
        PrintWriter out = response.getWriter();
        out.write(jsonString);
        out.flush();
        out.close();
        return out;
    }
    public static Long getOptStatus(){
        return Long.valueOf("0");
    }

    /**
     * 替换字符串中的null
     * @param sourceString 需要替换的字符串
     * @return
     */
    public static JSONObject replaceStringNUll(String sourceString) {
        String temp = sourceString.replace("null", "\"\"");
        temp = temp.replace("<null>", "\"\"");
        return JSONObject.fromObject(temp);
    }
    /**
     * 判断字符串是否为空
     * @param str
     * @return
     */
    public static boolean isEmpty(String str) {
        if (str != null) {
            str = str.trim();
        }
        return org.apache.commons.lang.StringUtils.isEmpty(str);
    }

    /**
     * 判断字符串是否非空
     * @param str
     * @return
     */
    public static boolean isNotEmpty(String str) {
        return !isEmpty(str);
    }

}
