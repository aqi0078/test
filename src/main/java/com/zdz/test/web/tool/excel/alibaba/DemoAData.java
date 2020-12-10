package com.zdz.test.web.tool.excel.alibaba;

import com.alibaba.excel.annotation.ExcelProperty;
import lombok.Data;

import java.util.Date;
import java.util.List;

/**
 * @Description:
 * @Date: 2020/12/10
 */
@Data
public class DemoAData {
    @ExcelProperty("字符串标题111")
    private String string;
    @ExcelProperty("日期标题111")
    private Date date;
    @ExcelProperty("数字标题11")
    private Double doubleData;
}
