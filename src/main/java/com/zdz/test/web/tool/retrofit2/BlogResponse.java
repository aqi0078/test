package com.zdz.test.web.tool.retrofit2;

import com.alibaba.fastjson.annotation.JSONField;
import lombok.Data;
import lombok.ToString;

@Data
@ToString
public class BlogResponse {
    @JSONField(name = "merchantno")
    private String merchantno;
    @JSONField(name = "errorcode")
    private String errorCode;

    @JSONField(name = "errormsg")
    private String errorMsg;


}
