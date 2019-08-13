package com.zdz.test.algorithm.binarySearch;

public class ArrayBinarySearch {
    public static void main(String[] args) {
        int[] arr={1,3,4,5,7,8,9};
        int index=getIndex(arr,10,0,arr.length-1);
        System.out.println(index);
//        System.out.println(getIndex(arr,8,0,arr.length-1));
//        System.out.println(getIndex(arr,7,0,arr.length-1));
//        System.out.println(getIndex(arr,5,0,arr.length-1));
//        System.out.println(getIndex(arr,4,0,arr.length-1));
//        System.out.println(getIndex(arr,3,0,arr.length-1));
//        System.out.println(getIndex(arr,1,0,arr.length-1));
    }
    public static int getIndex(int[] arr,int data,int first,int end) {
        if(first<=end&&end<arr.length){
            if (arr[(end+first)/2]>data){
                return getIndex(arr, data, first, (end+first)/2);
            }else if (arr[(end+first)/2]<data){
                return getIndex(arr, data, (end+first)/2+1, end);
            }else{
                return (end+first)/2;
            }
        }
        return -1;
    }
}
