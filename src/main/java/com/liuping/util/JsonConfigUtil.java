package com.liuping.util;


import net.sf.json.JsonConfig;
import net.sf.json.processors.JsonValueProcessor;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by liuping on 15/12/10.
 */
public class JsonConfigUtil {

    public static JsonConfig formatDateTime() {
        JsonConfig jsonConfig = new JsonConfig();
        jsonConfig.registerJsonValueProcessor(Date.class, new JsonValueProcessor() {
            public Object processArrayValue(Object o, JsonConfig jsonConfig) {
                return null;
            }

            private final String format = "yyyy-MM-dd HH:mm:ss";

            public Object processObjectValue(String name, Object value, JsonConfig jsonConfig) {
                if (value == null) {
                    return "";
                }

                if (value instanceof Date) {
                    String string = new SimpleDateFormat(format).format(value);
                    return string;
                }
                return value;
            }
        });

        return jsonConfig;
    }

    public static JsonConfig formatDate() {
        JsonConfig jsonConfig = new JsonConfig();
        jsonConfig.registerJsonValueProcessor(Date.class, new JsonValueProcessor() {
            public Object processArrayValue(Object o, JsonConfig jsonConfig) {
                return null;
            }

            private final String format = "yyyy-MM-dd";

            public Object processObjectValue(String name, Object value, JsonConfig jsonConfig) {
                if (value == null) {
                    return "";
                }

                if (value instanceof Date) {
                    String string = new SimpleDateFormat(format).format(value);
                    return string;
                }
                return value;
            }
        });

        return jsonConfig;
    }

}
