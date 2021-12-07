package com.zdz.test.test.tmp.test1;

import lombok.Data;

import java.math.BigDecimal;
import java.util.List;

/**
 * @Description:
 * @Date: 2021/11/4
 */
@Data
public class RebateData {
    public Long ts;
    List<Rebate> inviteRecord;
    @Data
    public static class Rebate{
        public BigDecimal rebate;
        public Long uid;
    }
}
