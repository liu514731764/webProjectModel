package com.liuping.util;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * Created by liuping on 15/12/26.
 */
public class HibernateResultToBeanListUtil {

    public static List<?> convertMapToBeanList(List list, Class<?> cls) {
        List<Object> listResult = new ArrayList<Object>();
        try {

            for (Object obj : list
                    ) {
                Map<String, Object> map = (Map<String, Object>) obj;
                Object object = cls.newInstance();
                for (String key : map.keySet()
                        ) {
                    String propertyName = clomunNameToPropertyName(key);
                    try {
                        Field field = cls.getDeclaredField(propertyName);
                        if (field != null) {
                            field.setAccessible(true);
                            field.set(object, map.get(key));
                        }
                    } catch (NoSuchFieldException e) {
                        e.printStackTrace();
                    }

                }
                listResult.add(object);
            }
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }

        return listResult;
    }


    private static String clomunNameToPropertyName(String key) {
        String temp = key.toLowerCase();

        String[] splitWord = temp.split("_");

        String propertyName = "";
        if (splitWord.length > 0) {
            propertyName = splitWord[0];
        }
        for (int i = 1; i < splitWord.length; i++) {
            if (splitWord[i].length() > 0) {
                propertyName += splitWord[i].substring(0, 1).toUpperCase() + splitWord[i].substring(1);
            }
        }
        return propertyName;
    }
}
