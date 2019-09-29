package com.zdz.test.web.tool.excel.alibaba;

import com.alibaba.excel.annotation.ExcelProperty;

import java.util.Date;

/**
 * @Author: ZhangDeZhi
 * @Date: 2019-09-29
 */
public class ComplexHeadData {
    @ExcelProperty({"主标题", "字符串标题"})
    private String string;
    @ExcelProperty({"主标题", "日期标题"})
    private Date date;
    @ExcelProperty({"主标题", "数字标题"})
    private Double doubleData;
}
