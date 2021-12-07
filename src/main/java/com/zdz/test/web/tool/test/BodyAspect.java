package com.zdz.test.web.tool.test;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.List;

/**
 * @Description:
 * @Date: 2021/4/21
 */
public class BodyAspect {



    /**
     * List<HashMap> 结构处理
     *
     * @param fieldNames 字段名称集合
     * @param value      需要更改数据
     * @return List<HashMap>
     */
    private List<HashMap> getHashMapsValue(String[] fieldNames, String value,
                                           BigDecimal multiple) {
        List<HashMap> dataList = JacksonUtil
                .jsonToList(value, List.class, HashMap.class);
        for (String fieldName : fieldNames) {
            dataList.forEach(data -> {
                if (null == data.get(fieldName)) {
                    return;
                }
                BigDecimal oldData = new BigDecimal(data.get(fieldName).toString());
                if (oldData.compareTo(BigDecimal.ZERO) != 0) {
                    BigDecimal newData = oldData.multiply(multiple);
                    data.put(fieldName, newData.stripTrailingZeros().toPlainString());
                }
            });
        }
        return dataList;
    }


    private List<HashMap> getHashMapsValue(String fieldName, String value,
                                           BigDecimal multiple) {
        List<HashMap> dataList = JacksonUtil
                .jsonToList(value, List.class, HashMap.class);
        dataList.forEach(data -> {
            if (null == data.get(fieldName)) {
                return;
            }
            BigDecimal oldData = new BigDecimal(data.get(fieldName).toString());
            if (oldData.compareTo(BigDecimal.ZERO) != 0) {
                BigDecimal newData = oldData.multiply(multiple);
                data.put(fieldName, newData.stripTrailingZeros().toPlainString());
            }
        });
        return dataList;
    }



}
