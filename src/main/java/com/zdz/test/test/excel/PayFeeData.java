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
public class PayFeeData  implements Serializable {

    private static final long serialVersionUID = 6166495476379128392L;
    @ExcelProperty("日期")
    private String date;
    @ExcelProperty("币种")
    private String currency;
    @ExcelProperty("金额")
    private BigDecimal balance = BigDecimal.ZERO;

}
