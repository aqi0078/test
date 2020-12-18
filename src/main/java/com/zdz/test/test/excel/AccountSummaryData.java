package com.zdz.test.test.excel;

import com.alibaba.excel.annotation.ExcelProperty;
import com.alibaba.excel.annotation.write.style.ColumnWidth;
import lombok.Data;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 * @Description:
 * @Date: 2020/12/10
 */
@Data
@ColumnWidth(20)
public class AccountSummaryData implements Serializable {

    private static final long serialVersionUID = 1595980289807533814L;
    @ExcelProperty("日期")
    private String date;
    @ExcelProperty("币种")
    private String currency;
    @ExcelProperty("用户金额")
    private BigDecimal userBalance = BigDecimal.ZERO;
    @ExcelProperty("系统金额")
    private BigDecimal sysBalance = BigDecimal.ZERO;

}
