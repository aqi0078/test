package com.zdz.test.web.tool.retrofit;

import com.alibaba.fastjson.annotation.JSONField;
import lombok.Data;

@Data
public class AARetrofitRequest extends RetrofitRequset {


    @JSONField(name = "name")
    private String name;
}
