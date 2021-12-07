package com.zdz.test.test.tmp;

import lombok.RequiredArgsConstructor;
import lombok.ToString;
import org.apache.commons.lang3.StringUtils;

import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.concurrent.*;
import java.util.concurrent.locks.ReentrantLock;
import java.util.stream.Collectors;

/**
 * @Description:
 * @Date: 2021/5/24
 */
public class Test20210524 {

//    public static void main(String[] args) {
//        String type = "phone";
//        String str = "";
//        switch (type){
//            case "phone":str = "ALL_WAREHOUSE_WARN_PHONE";break;
//        }
//        System.out.println(str);
//    }
    public static void main(String[] args) {

        Integer[] data = new Integer[7];
        Set<Integer> set = new HashSet();
        Random random = new Random();
        Integer index = 0;
        while(set.size() < 6){
            Integer num = random.nextInt(7)+1;
            System.out.println("==="+num);
            if (set.add(num)){
                data[index++] = num;
            }
        }
//        data[6] = random.nextInt(16)+1;
//        data
//        System.out.println(data);
//        List<Integer> list1 = new ArrayList<>();
//        List<Integer> list2 = new ArrayList<>();
//        list2.add(1);
//        list1.addAll(list2);
//        System.out.println(list1);
//        Map<Key,Key> map =new HashMap<>();
//        Key key = new Key(1,1L);
//        Key key1 = null;
//        key1 = new Key(1,2L);
//        map.put(key, key1);
//        map.put(new Key(1,1L),2);
//        map.put(new Key(1,2L),3);
//        System.out.println(map);
//        System.out.println(map.size());
//        System.out.println(map.get(new Key(1,1L)));
//        list1.add(1);
//        list1.add(12);
//        System.out.println(list1);
//        Collections.reverse(list1);
//        System.out.println(list1);
//        int a =-1000009;
//        System.out.println(a%10);
//
//        Map<Integer, Integer> map = new HashMap<>();
//        list1.forEach(coreContractFuture -> map.put(coreContractFuture,coreContractFuture));
//
//        System.out.println(map);
//        map.put(null,1);
//        System.out.println(map.get(null));
//        System.out.println(BigDecimal.ZERO.compareTo(null) == 0);
        Long count = 10L;
        Long id = 163L;

        Long i1=0L;
        System.out.println(i1==0);
//        System.out.println(count<<40);
        System.out.println(count<<40|id);
        Long i = count<<40|id;
//        System.out.println(count<<40^i);

//        SimpleDateFormat formatter  = new SimpleDateFormat("yyyy-MM-dd 17:30:00");
////         formatter.format(date);
//        System.out.println(formatter.format(new Date()));
//        Calendar todayStart = Calendar.getInstance();
//        todayStart.add(Calendar.DATE,-1);
//        todayStart.set(Calendar.HOUR_OF_DAY, 17);
//        todayStart.set(Calendar.MINUTE, 30);
//        todayStart.set(Calendar.SECOND, 0);
//        todayStart.set(Calendar.MILLISECOND, 0);
//        Date data = todayStart.getTime();
////         formatter.format(date);
//        SimpleDateFormat formatter1  = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
//        System.out.println(formatter1.format(data));
//        System.out.println(i<<24>>24);
//        long MASK = (1L << 40) - 1;
//        System.out.println(i&MASK);
//
//        System.out.println(istrue());
//        System.out.println(122&MASK);

//        Long tmp = (count<<40) + id;
//        Long end = tmp- (count << 40);
//        System.out.println(tmp);
//        System.out.println(end);
//        System.out.println(tmp- (count << 40));
//        ExecutorService executorService = new ThreadPoolExecutor(10, 10,
//                0L, TimeUnit.MILLISECONDS,
//                new LinkedBlockingQueue<Long>());
//        executorService.execute();


    }

    public static Integer istrue(){
        Integer i =0;
        try{
            i= i/0;
        }finally {
             i = 100;
            System.out.println("-------");
        }
        System.out.println("**********");
        return i;
    }
    @RequiredArgsConstructor
    @ToString
    public static class Key{
        private final Integer contractId;
        private final Long userId;
        @Override
        public boolean equals(Object obj) {
            if(this == obj){
                return true;//地址相等
            }

            if(obj == null){
                return false;//非空性：对于任意非空引用x，x.equals(null)应该返回false。
            }

            if(obj instanceof Key){
                Key other = (Key) obj;
                //需要比较的字段相等，则这两个对象相等
                if (this.contractId.compareTo(other.contractId) == 0
                        &&this.userId.compareTo(other.userId) == 0){
                    return true;
                }
            }

            return false;
        }
        @Override
        public int hashCode() {
            int result = 17;
            result = 31 * result + (contractId == null ? 0 : contractId.hashCode());
            result = 31 * result + (userId == null ? 0 : userId.hashCode());
            return result;
        }
    }
}
