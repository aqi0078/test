package com.zdz.test.algorithm.priorityQueue;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class PriorityBean implements Comparable<PriorityBean>{

    private String name;
    private Integer priority;

    @Override
    public int compareTo(PriorityBean priorityBean) {
        return this.getPriority()-priorityBean.getPriority();
    }
}
