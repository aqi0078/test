package com.zdz.test.test.tmp;

import lombok.Data;

/**
 * @author zhangdezhi
 * @date 2019-11-21
 */
@Data
public class AA {
    private  int a;
    private  int b;

    public AA add(int i){
        this.a=this.a+i;
        this.b=this.b+i;
        return this;
    }
    public AA jian(int i){
        this.a=this.a-i;
        this.b=this.b-i;
        return this;
    }
}
