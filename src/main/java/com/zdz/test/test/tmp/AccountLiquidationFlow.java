package com.zdz.test.test.tmp;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class AccountLiquidationFlow implements Cloneable{
    private Long id;

    private Long accountId;

    private Long userId;

    private Integer contractId;

    private Long positionId;

    private boolean isolated;

    private BigDecimal leverage;

    private BigDecimal pnl= BigDecimal.ZERO;

    private BigDecimal maintMargin;

    private BigDecimal markPrice;

    private BigDecimal positionMargin = BigDecimal.ZERO;
    private BigDecimal positionCost = BigDecimal.ZERO;

    private BigDecimal insurance = BigDecimal.ZERO.stripTrailingZeros();

    private BigDecimal size = BigDecimal.ZERO;

    private BigDecimal residueSize = BigDecimal.ZERO;

    private String type;

    private Long ts;

    private String seq;

    @Override
    public AccountLiquidationFlow clone(){
        AccountLiquidationFlow flow = null;
        try {
            flow = (AccountLiquidationFlow) super.clone();
        } catch (CloneNotSupportedException e) {

        }
        return flow;
    }
}