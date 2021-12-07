package com.zdz.test.test.testThread;


public enum UpdateKLineTypeEnum {
    MIN1(1),
    MIN5(5),
    MIN15(15),
    MIN30(30),
    HOUR1(60),
    HOUR4(240),
    HOUR8(480),
    HOUR12(720),
    DAY(1440),
    MONTH(10080);
    public int time;
    UpdateKLineTypeEnum(Integer time){
        this.time = time;
    }

    public int getTime() {
        return time;
    }

}
