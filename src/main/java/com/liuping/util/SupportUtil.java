package com.liuping.util;

import java.util.List;

/**
 * Created by liuping on 15/12/24.
 */
public class SupportUtil {

    private static final String PERCENT_SYMBOL = "%";
    public enum EnumDatePeriodResult{

        EMPTY_PERIOD(0,"没有日期范围"),
        ONLY_LEFT(1, "只有起始日期"),
        ONLY_RIGHT(2,"只有结束日期"),
        BOTH_DATE(3,"有明确的日期时间段");

        private int code;
        private String name;


        private EnumDatePeriodResult(int code, String name) {
            this.code = code;
            this.name = name;
        }
        /**
         * @return the code
         */
        public int getCode() {
            return code;
        }
        /**
         * @return the name
         */
        public String getName() {
            return name;
        }

        public static EnumDatePeriodResult typeOf(int code){
            EnumDatePeriodResult result = null;
            for(EnumDatePeriodResult datePeriodResult :  EnumDatePeriodResult.values()){
                if(datePeriodResult.getCode() == code){
                    result = datePeriodResult;
                    break;
                }
            }
            return result;

        }

        /**
         * 判断对象相等，目前使用CODE做判断
         * @param datePeriodResult
         * @return
         */
        public boolean equals(EnumDatePeriodResult datePeriodResult){
            return this.getCode() == datePeriodResult.getCode();
        }
    }
    /**
     * 确认时间范围的共有方法
     *     用户在界面上选取时间范围作为查询条件时的确认方法
     *     确认情况如下：
     *     	如果没有开始日期和结束日期
     *     	如果只有开始日期
     *    	如果只有结束日期
     *     	两个日期都有
     * @param startDate
     * @param endDate
     */
    public static EnumDatePeriodResult checkDatePeriod(String startDate, String endDate){
        EnumDatePeriodResult result = null;
        if(StringUtils.isEmpty(startDate)){
            if(StringUtils.isEmpty(endDate)){
                result = EnumDatePeriodResult.EMPTY_PERIOD;
            }else{
                result = EnumDatePeriodResult.ONLY_RIGHT;
            }
        }else{
            if(StringUtils.isEmpty(endDate)){
                result = EnumDatePeriodResult.ONLY_LEFT;
            }else{
                result = EnumDatePeriodResult.BOTH_DATE;
            }
        }

        return result;
    }

    /**
     * 构造模糊查询的关键字信息
     * @param word
     * @return %关键字%
     */
    public static String buildKeyWordInSearch(String word){
        return PERCENT_SYMBOL+word+PERCENT_SYMBOL;
    }

    /**
     * 构造成百分比数字
     * @param number
     * @return
     */
    public static String buildPercentNumber(String number){
        return number+PERCENT_SYMBOL;
    }
    /**
     * 将整形对象LIST转换成基本类型数组
     * @param typeList
     * @return
     */
    public static int[] convertIntegerListToIntArray(List<Integer> typeList) {
        int[] types = new int[typeList.size()];
        for (int i = 0; i < typeList.size(); i++) {
            types[i] = typeList.get(i);
        }
        return types;
    }
}
