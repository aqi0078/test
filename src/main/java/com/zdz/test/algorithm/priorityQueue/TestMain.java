package com.zdz.test.algorithm.priorityQueue;

import java.util.PriorityQueue;
import java.util.Queue;

public class TestMain {
    public static void main(String[] args) {
        PriorityBean priorityBean=new PriorityBean();
        priorityBean.setName("A");
        priorityBean.setPriority(1);
        PriorityBean priorityBean1=new PriorityBean();
        priorityBean1.setName("B");
        priorityBean1.setPriority(2);
        PriorityBean priorityBean2=new PriorityBean();
        priorityBean2.setName("C");
        priorityBean2.setPriority(1);


        Queue<PriorityBean> queue = new PriorityQueue();
        queue.add(priorityBean);
        queue.add(priorityBean1);
        queue.add(priorityBean2);
        while (!queue.isEmpty()){
            System.out.println(queue.poll().getName());
        }

    }
}
