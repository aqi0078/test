package com.zdz.test.web.tool.retrofit;

import com.alibaba.fastjson.annotation.JSONField;
import lombok.Data;

@Data
public class RetrofitRequset {

    @JSONField(name = "merchantno")
    private String merchantno;


    @JSONField(name = "sign")
    private String sign;

}
