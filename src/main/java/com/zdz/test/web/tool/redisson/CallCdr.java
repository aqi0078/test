package com.zdz.test.web.tool.redisson;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
@Getter
@Setter
public class CallCdr {
    private String name;
    private int age;
    private String wife;
    private Double salary;
    private String putTime;

    public CallCdr() {
    }

    public CallCdr(Double salary) {
        this.salary = salary;
    }
}
