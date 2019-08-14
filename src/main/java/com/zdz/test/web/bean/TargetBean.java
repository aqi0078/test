package com.zdz.test.web.bean;

import com.zdz.test.web.tool.target.FieldTarget;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class TargetBean {

    @FieldTarget("啦啦啦")
    private String data;
    private  Long id;
}
