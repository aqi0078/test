package com.zdz.test.test.tmp;

import java.util.PriorityQueue;
import java.util.Queue;

public class E {
    public static void main(String[] args) {
        Queue<Integer> queue = new PriorityQueue();
        queue.add(1);
        queue.add(2);
        queue.add(5);
        queue.add(3);
        while (!queue.isEmpty()){
            System.out.println(queue.poll());
        }

        while (!queue.isEmpty()){
            System.out.println(queue.poll());
        }
    }
}
