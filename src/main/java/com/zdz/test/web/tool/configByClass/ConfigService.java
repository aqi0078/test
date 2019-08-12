package com.zdz.test.web.tool.configByClass;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public interface ConfigService {
    class Tes{
        private static final Map<String, String> BANK_CODE = new ConcurrentHashMap<>();
        static {
            System.out.println("--------");
            BANK_CODE.put("1","1");
            System.out.println("=========");
        }
        public static void putData(String key,String value){
            BANK_CODE.put(key,value);
        }

        public static Map<String, String> getBank(){
            return BANK_CODE;
        }
    }
}
