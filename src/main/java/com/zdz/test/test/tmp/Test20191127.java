package com.zdz.test.test.tmp;

import com.alibaba.fastjson.JSON;
import com.google.common.collect.Lists;
import lombok.Data;
import org.apache.commons.lang3.time.DateUtils;
import org.apache.poi.ss.formula.functions.T;
import org.joda.time.DateTime;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.stream.Collectors;

/**
 * @author zhangdezhi
 * @date 2019-11-27
 */
public class Test20191127 {
    private static int generateYearWeekNo() {
        StringBuilder yearWeekBuilder;

        yearWeekBuilder = new StringBuilder()
                .append(DateTime.now().weekyear().get())
                .append(DateTime.now().weekOfWeekyear().get());

        return Integer.parseInt(yearWeekBuilder.toString());
    }
    public static String dateFromString(Date date, String pattern) {

        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);
        return date != null ? simpleDateFormat.format(date) : null;
    }
    public static int getSeconds(){
        Calendar curDate = Calendar.getInstance();
        Calendar tommorowDate = new GregorianCalendar(curDate
                .get(Calendar.YEAR), curDate.get(Calendar.MONTH), curDate
                .get(Calendar.DATE) + 1, 0, 0, 0);
        return (int)(tommorowDate.getTimeInMillis() - curDate .getTimeInMillis()) / 1000;
    }
    public static Date getStartTime() {
        Calendar todayStart = Calendar.getInstance();
        todayStart.add(Calendar.DATE,-1);
        todayStart.set(Calendar.HOUR_OF_DAY, 0);
        todayStart.set(Calendar.MINUTE, 0);
        todayStart.set(Calendar.SECOND, 0);
        todayStart.set(Calendar.MILLISECOND, 0);
        return todayStart.getTime();
    }

    public static Date getEndTime() {
        Calendar todayEnd = Calendar.getInstance();
        todayEnd.add(Calendar.DATE,-1);
        todayEnd.set(Calendar.HOUR_OF_DAY, 23);
        todayEnd.set(Calendar.MINUTE, 59);
        todayEnd.set(Calendar.SECOND, 59);
        todayEnd.set(Calendar.MILLISECOND, 999);
        return todayEnd.getTime();
    }
    @Data
    public class RewardRule{
        String ruleKey;
        private int sort;
    }
    public static Integer getWeek(int minusDay) {
        Calendar cal = Calendar.getInstance();
        cal.setTime(DateTime.now().minusDays(minusDay).toDate());
        return cal.get(Calendar.DAY_OF_WEEK) - 1;
    }
    //获取本周是本月第几周
    public static int getWeekOfMonth() {
        Calendar calendar = Calendar.getInstance();
        int week = calendar.get(Calendar.WEEK_OF_MONTH);
        return week;
    }
    // 获得一周开始时间
    public static Date getTimesWeekMorning() {
        Calendar cal = Calendar.getInstance();
        int dayWeek = cal.get(Calendar.DAY_OF_WEEK);// 获得当前日期是一个星期的第几天
        if (1 == dayWeek) {
            cal.add(Calendar.DAY_OF_WEEK, -1);
        }
        cal.setFirstDayOfWeek(Calendar.MONDAY);
        int day = cal.get(Calendar.DAY_OF_WEEK);
        cal.add(Calendar.DATE, cal.getFirstDayOfWeek() - day);
        return cal.getTime();
    }
    public static String formatDate(Date date, String pattern) {
        if (date == null){
            return null;
        }
        DateFormat format = new SimpleDateFormat(pattern);
        return format.format(date);
    }
    public final static String STANDARD_DATE_PATTERN = "yyyy-MM-dd";
    public static String formatDate(Date date) {
        return formatDate(date, STANDARD_DATE_PATTERN);
    }    /**
     * 计算 day 天后的时间
     *
     * @param date
     * @param day
     * @return
     */
    public static Date addDay(Date date, int day) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.add(Calendar.DAY_OF_MONTH, day);
        return calendar.getTime();
    }
    /**
     * 当周所有日期
     *
     * @return
     */
    public static List<String> dayOfMonthList() {
        List<String> list = Lists.newArrayList();
        Calendar calendar = Calendar.getInstance();
        calendar.add(Calendar.MONTH, 0);
        calendar.set(Calendar.DAY_OF_MONTH, 1);
        int month = calendar.get(Calendar.MONTH);
        //第一天
        Date date=getTimesWeekMorning();
        list.add(formatDate(date));
        for (int i = 1; i < 7; i++) {
            list.add(formatDate(addDay(date,i)));
        }
        return list;
    }
    /**
     * 当月所有日期
     *
     * @return
     */
    public static List<String> dayOfMonthList11() {
        List<String> list = Lists.newArrayList();
        Calendar calendar = Calendar.getInstance();
        calendar.add(Calendar.MONTH, 0);
        calendar.set(Calendar.DAY_OF_MONTH, 1);
        int month = calendar.get(Calendar.MONTH);
        System.out.println("===="+month);
        System.out.println("===="+calendar.get(Calendar.MONTH));
        //第一天
        list.add(formatDate(calendar.getTime()));
        for (int i = 0; i < 31; i++) {
            calendar.add(Calendar.DAY_OF_MONTH, 1);
            System.out.println("==1=="+formatDate(calendar.getTime()));
            if(month != calendar.get(Calendar.MONTH)){
                break;
            }
            System.out.println("===="+calendar.get(Calendar.MONTH));
            list.add(formatDate(calendar.getTime()));
        }
        return list;
    }
    public static Date addDay12(Date date, int day) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.add(Calendar.DAY_OF_MONTH, day);
        return calendar.getTime();
    }
    //获取本周第几天  周一为第一天
    public static int getDayOfWeek() {
        Calendar calendar = Calendar.getInstance();
        int day = calendar.get(Calendar.DAY_OF_WEEK) - 1;
        if (day == 0) {
            return 7;
        }
        return day;
    }
    public static Date getStartTime11() {
        Calendar todayStart = Calendar.getInstance();
        todayStart.set(Calendar.HOUR_OF_DAY, 0);
        todayStart.set(Calendar.MINUTE, 0);
        todayStart.set(Calendar.SECOND, 0);
        todayStart.set(Calendar.MILLISECOND, 0);
        return todayStart.getTime();
    }
    //获取本月第几天
    public static int getDayOfMonth() {
        Calendar calendar = Calendar.getInstance();
        int day = calendar.get(Calendar.DAY_OF_MONTH);
        return day;
    }

    public static Date lastDayOfMonthDate() {
        Calendar calendar = Calendar.getInstance();
        calendar.add(Calendar.MONTH, 1);
        calendar.set(Calendar.DAY_OF_MONTH, 0);
        return calendar.getTime();
    }
    public static String lastDayOfMonth() {
        Calendar calendar = Calendar.getInstance();
        calendar.add(Calendar.MONTH, 1);
        calendar.set(Calendar.DAY_OF_MONTH, 0);
        return formatDate(calendar.getTime()) + " 23:59:59";
    }
    // 获得一周开始时间
    public static Date getTimesWeekMorning1() {
        Calendar cal = Calendar.getInstance();
        int dayWeek = cal.get(Calendar.DAY_OF_WEEK);// 获得当前日期是一个星期的第几天
        if (1 == dayWeek) {
            cal.add(Calendar.DAY_OF_WEEK, -1);
        }
        cal.setFirstDayOfWeek(Calendar.MONDAY);
        int day = cal.get(Calendar.DAY_OF_WEEK);
        cal.add(Calendar.DATE, cal.getFirstDayOfWeek() - day);
        return cal.getTime();
    }
    public static Date getEndTim21e() {
        Calendar todayEnd = Calendar.getInstance();
        todayEnd.set(Calendar.HOUR_OF_DAY, 23);
        todayEnd.set(Calendar.MINUTE, 59);
        todayEnd.set(Calendar.SECOND, 59);
        todayEnd.set(Calendar.MILLISECOND, 999);
        return todayEnd.getTime();
    }

    public static Date getStartTime13() {
        Calendar cal = Calendar.getInstance();
        int dayWeek = cal.get(Calendar.DAY_OF_WEEK);// 获得当前日期是一个星期的第几天
        if (1 == dayWeek) {
            cal.add(Calendar.DAY_OF_WEEK, -1);
        }
        cal.setFirstDayOfWeek(Calendar.MONDAY);
        int day = cal.get(Calendar.DAY_OF_WEEK);
        cal.add(Calendar.DATE, cal.getFirstDayOfWeek() - day);
        cal.set(Calendar.HOUR_OF_DAY, 0);
        cal.set(Calendar.MINUTE, 0);
        cal.set(Calendar.SECOND, 0);
        cal.set(Calendar.MILLISECOND, 0);
        return cal.getTime();
    }
    // 获得周日24点时间
    public static Date getTimesWeekNight() {
        Calendar cal = Calendar.getInstance();
        cal.setTime(getTimesWeekMorning());
        cal.add(Calendar.DAY_OF_WEEK, 7);
        return cal.getTime();
    }
    public static Date getEndWeekTime() {
        Calendar cal = Calendar.getInstance();
        cal.setTime(getTimesWeekMorning());
        cal.add(Calendar.DAY_OF_WEEK, 6);
        cal.set(Calendar.HOUR_OF_DAY, 23);
        cal.set(Calendar.MINUTE, 59);
        cal.set(Calendar.SECOND, 59);
        cal.set(Calendar.MILLISECOND, 999);
        return cal.getTime();
    }    //获取本周第几天  周一为第一天

    public static void main(String[] args) throws ParseException {
        System.out.println("8888888888888888888888888888888");
        System.out.println(2-1<2);
        System.out.println(lastDayOfMonthDate());
        System.out.println(getTimesWeekNight());
        System.out.println(addDay(getTimesWeekNight(),1));
//        System.out.println(getDayOfWeek());
//        List<PagePosition> pagePositions=new ArrayList<>();
//        for (int i = 0; i < 10000; i++) {
//            PagePosition pagePosition=new PagePosition();
////            pagePosition.setModuleName("");
//            if (i==5){
//                pagePosition.setModuleName("i");
//            }else{
//                pagePosition.setModuleName("null+i"+i);
//            }
//            pagePosition.setI(i);
//        }
//        int count=pagePositions.stream().collect(Collectors.groupingBy(PagePosition::getModuleName)).size();
//        System.out.println(count);
//        System.out.println(getEndTime().getTime());
//        System.out.println(System.currentTimeMillis());
        System.out.println((addDay(getEndTime(),1).getTime()-System.currentTimeMillis())/1000);
//        System.out.println(getEndTim21e());
        ;
//        List patchList=new ArrayList();
//        patchList.add(1);
//        patchList.add(2);
//        patchList.add(3);
//        patchList.clear();
//        patchList.add(4);
//        patchList = (List) patchList.stream().limit(5).collect(Collectors.toList());
//
//        System.out.println(patchList);
//
//
//
//        System.out.println(1578046887349L-System.currentTimeMillis());
//        System.out.println(8215542/1000/60/60);
//        System.out.println(dayOfMonthList11().size());



//        List list= new ArrayList();
//        for (int i = 0; i <101; i++) {
//            list.add(i);
//        }
//        int pageNum=6;
//        int pageSize=20;
//        int f=(pageNum-1)*pageSize;
//        int e=f+pageSize;
//        if (f>=list.size()){
//            System.out.println("======888");
//        }else if(e>list.size()){
//            e=list.size();
//        }
//        System.out.println(JSON.toJSONString(list.subList(0,0)));
//        System.out.println(JSON.toJSONString(list.subList(f,e)));

//        Test20191127 test=new Test20191127();
//        List<RewardRule> rewardRuleList=new ArrayList<>();
//        for (int i = 0; i < 10; i++) {
//            RewardRule rule=test.new RewardRule();
//            rule.setRuleKey(String.valueOf(i));
//            rule.setSort(1);
//            rewardRuleList.add(rule);
//        }
////        rewardRuleList = rewardRuleList.parallelStream().sorted(Comparator.comparing(RewardRule::getRuleKey)).collect(Collectors.toList());
////
////        for (int i = 0; i < 10; i++) {
////            System.out.println(rewardRuleList.get(i).ruleKey);
////        }
//
//        rewardRuleList = rewardRuleList.stream().sorted(Comparator.comparingInt(RewardRule::getSort)).collect(Collectors.toList());
//
//        for (int i = 0; i < 10; i++) {
//            System.out.println(rewardRuleList.get(i).ruleKey);
//        }



//        SimpleDateFormat simpleDateFormat1 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
//        System.out.println(DateUtils.addDays(new Date(),7).after(simpleDateFormat1.parse("2019-12-14 12:12:12")));
//        System.out.println(simpleDateFormat1.parse("2019-12-14 12:12:12").before(DateUtils.addDays(new Date(),-3)));
//        System.out.println(DateUtils.addDays(new Date(),3).after(simpleDateFormat1.parse("2019-12-14 12:12:12")));
//
//        System.out.println(getStartTime());
//        System.out.println(getEndTime());
//        System.out.println(getSeconds());
//        Date date=new Date();
//        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd 02:00:00");
//        if (date.before(simpleDateFormat.parse(simpleDateFormat.format(date)))){
//            System.out.println("=======================================-=-");
//        }
//        System.out.println("=======================================-=-"+simpleDateFormat1.parse(simpleDateFormat.format(date)));
//        if (new Date().after(DateTime.now().minusDays(1).toDate())){
//            System.out.println("=======================================-=-");
//        }
//        System.out.println(DateTime.now().minusDays(1).toDate());
//        Date date=new Date(System.currentTimeMillis()-12222*1000);
//        System.out.println("8888======"+date);
//        Map<String,Object>map13=new HashMap<>();
//        map13.put("appPackage","com.mianfeinovel");
//        map13.put("queryIds","5769b05fd48745522ca7d9d6,576917a7439953079024ed02,59a8db5ee4ee79097cb6cc4b,57695c62e1ef5126fef5d9a4,57690be50fca687a11776d8c,57698bbc0fca687a11c00efe,577a77720fca681476b8ae85,5769aa304399530790ae72c1,5ac043a7f71a51737b27632c,576971c2d48745522cf40c06,5769586bd48745522caf1868,576a03cee1ef5126fecb5bfd,576949921b341116f6aa5d11,59fa3289ea1fe54388c03e0c,57691194439953079015dfdf,59ba2c81e331b64458a64b0e,580d27bd8107d358a74820cf,5769097b0fca687a11706839,57698237e1ef5126fe5c83a2,576989a21b341116f654d84a,576946ded48745522c84f6f2,5769667e1b341116f6f43d2c,5abdb8012aa09f3180246f38,57692e5de1ef5126fe82d997,576912021fa84070e9ab405a,58c081114ed3437c6297f976,576973c61b341116f619f1a7,5769265a0fca687a11bd4153,59fa2c6fea1fe54388c03a30,5769219f1fa84070e9d22d9a,576a00d21b341116f6ab9d6b,5769a214e1ef5126feba8f62,59c37a3afc23fa055c99348a,57694dca4399530790ae3e66,57693d63d48745522c6c57f8,5b0d31172aa09f1a64641853,5769f62e1fa84070e9158ab8,5769fd311b341116f6a1bd2d,5996278e4ed34339c4f2bd18,57693da9e1ef5126fea9c2a6,57690");
//        map13.put("cityCode","010");
//        map13.put("channel","QG,FEE,VFREE");
//        System.out.println(JSON.toJSON(map13));
//        int week=generateYearWeekNo();
//        int day=DateTime.now().getDayOfWeek();
//        System.out.println("=="+week);
//        System.out.println("=="+day);
//        String str="11147474";
//        try {
//           Integer ii= Integer.valueOf(str);
//            System.out.println("====s==s===s=="+ii);
//        }catch (Exception e){
//
//        }
//        System.out.println(dateFromString(new Date(),"yyyy-MM-dd 00:00:00"));
//        System.out.println(dateFromString(new Date(),"yyyy-MM-dd 23:59:59"));
//
//
//
//
//        Calendar cal = Calendar.getInstance();
//        cal.setTime(DateTime.now().minusDays(-1).toDate());
//        int week_index = cal.get(Calendar.DAY_OF_WEEK) -1;
//        System.out.println("week_index=="+week_index);
//        System.out.println(Math.min(100,100));
//
//        List<Map<String, String>> readTimes=new ArrayList<>();
//        for (int i = 0; i < 3; i++) {
//            Map<String, String> map=new HashMap<>();
//            map.put("readTime","5");
//            readTimes.add(map);
//
//        }
//        System.out.println(JSON.toJSON(readTimes));
//
//        Map<Integer,Integer> map123=new HashMap<>();
//        map123.put(1,1);
//        System.out.println("======"+map123.size());
//        Integer po=5;
//        Long pol= po.longValue();
//        System.out.println(po.longValue());
//        System.out.println(pol.longValue());
//        System.out.println(DateTime.now().minusDays(331).dayOfYear().get());
//        System.out.println(DateTime.now().minusDays(331));
//        int index= DateTime.now().dayOfYear().get();
//        System.out.println(index);
//
//        char[] map=new char[730];
//        String strr="\uFFFF\uFFFF\uFFFF\uFFFF\uFFFF\uFFFF\uFFFF\uFFFF\uFFFF\uFFFF\uFFFF\uFFFF\uFFFF\uFFFF\uFFFF\uFFFF\uFFFF\uFFFF\uFFFF\uFFFF\uFFFF\uFFFF\uFFFF\uFFFF\uFFFF\uFFFF\uFFFF\uFFFF\uFFFF\uFFFF\uFFFF\uFFFF\uFFFF\uFFFF\uFFFF\uFFFF\uFFFF\uFFFF\uFFFF\uFFFF\uFFFF\uFFFF\uFFFF\uFFFF\uFFFF\uFFFF\uFFFF\uFFFF\uFFFF\uFFFF\uFFFF\uFFFF\uFFFF\uFFFF\uFFFF\uFFFF\uFFFF\uFFFF\uFFFF\uFFFF\uFFFF\uFFFF\uFFFF\uFFFF\uFFFF\uFFFF\uFFFF\uFFFF\uFFFF\uFFFF\uFFFF\uFFFF\uFFFF\uFFFF\uFFFF\uFFFF\uFFFF\uFFFF\uFFFF\uFFFF\uFFFF\uFFFF\uFFFF\uFFFF\uFFFF\uFFFF\uFFFF\uFFFF\uFFFF\uFFFF\uFFFF\uFFFF\uFFFF\uFFFF\uFFFF\uFFFF\uFFFF\uFFFF\uFFFF\uFFFF\uFFFF\uFFFF\uFFFF\uFFFF\uFFFF\uFFFF\uFFFF\uFFFF\uFFFF\uFFFF\uFFFF\uFFFF\uFFFF\uFFFF\uFFFF\uFFFF\uFFFF\uFFFF\uFFFF\uFFFF\uFFFF\uFFFF\uFFFF\uFFFF\uFFFF\uFFFF\uFFFF\uFFFF\uFFFF\uFFFF\uFFFF\uFFFF\uFFFF\uFFFF\uFFFF\uFFFF\uFFFF\uFFFF\uFFFF\uFFFF\uFFFF\uFFFF\uFFFF\uFFFF\uFFFF\uFFFF\uFFFF\uFFFF\uFFFF\uFFFF\uFFFF\uFFFF\uFFFF\uFFFF\uFFFF\uFFFF\uFFFF\uFFFF\uFFFF\uFFFF\uFFFF\uFFFF\uFFFF\uFFFF\uFFFF\uFFFF\uFFFF\uFFFF\uFFFF\uFFFF\uFFFF\uFFFF\uFFFF\uFFFF\uFFFF\uFFFF\uFFFF\uFFFF\uFFFF\uFFFF\uFFFF\uFFFF\uFFFF\uFFFF\uFFFF\uFFFF\uFFFF\uFFFF\uFFFF\uFFFF\uFFFF\uFFFF\uFFFF\uFFFF\uFFFF\uFFFF\uFFFF\uFFFF\uFFFF\uFFFF\uFFFF\uFFFF\uFFFF\uFFFF\uFFFF\uFFFF\uFFFF\uFFFF\uFFFF\uFFFF\uFFFF\uFFFF\uFFFF\uFFFF\uFFFF\uFFFF\uFFFF\uFFFF\uFFFF\uFFFF\uFFFF\uFFFF\uFFFF\uFFFF\uFFFF\uFFFF\uFFFF\uFFFF\uFFFF\uFFFF\uFFFF\uFFFF\uFFFF\uFFFF\uFFFF\uFFFF\uFFFF\uFFFF\uFFFF\uFFFF\uFFFF\uFFFF\uFFFF\uFFFF\uFFFF\uFFFF\uFFFF\uFFFF\uFFFF\uFFFF\uFFFF\uFFFF\uFFFF\uFFFF\uFFFF\uFFFF\uFFFF\uFFFF\uFFFF\uFFFF\uFFFF\uFFFF\uFFFF\uFFFF\uFFFF\uFFFF\uFFFF\uFFFF\uFFFF\uFFFF\uFFFF\uFFFF\uFFFF\uFFFF\uFFFF\uFFFF\uFFFF\uFFFF\uFFFF\uFFFF\uFFFF\uFFFF\uFFFF\uFFFF\uFFFF\uFFFF\uFFFF\uFFFF\uFFFF\uFFFF\uFFFF\uFFFF\uFFFF\uFFFF\uFFFF\uFFFF\uFFFF\uFFFF\uFFFF\uFFFF\uFFFF\uFFFF\uFFFF\uFFFF\uFFFF\uFFFF\uFFFF\uFFFF\uFFFF\uFFFF\uFFFF\uFFFF\uFFFF\uFFFF\uFFFF\uFFFF\uFFFF\uFFFF\uFFFF\uFFFF\uFFFF\uFFFF\uFFFF\uFFFF\uFFFF\uFFFF\uFFFF\uFFFF\uFFFF\uFFFF\uFFFF\uFFFF\uFFFF\uFFFF\uFFFF\uFFFF\uFFFF\uFFFF\uFFFF\uFFFF\uFFFF\uFFFF\uFFFF\uFFFF\uFFFF\uFFFF\uFFFF\uFFFF\uFFFF\uFFFF\uFFFF\uFFFF\uFFFF\uFFFF\uFFFF\uFFFF\uFFFF\uFFFF\uFFFF\uFFFF\uFFFF\uFFFF\uFFFF\uFFFF\uFFFF\uFFFF\uFFFF\uFFFF\uFFFF\uFFFF\uFFFF\uFFFF\uFFFF\uFFFF\uFFFF\uFFFF\uFFFF\uFFFF\uFFFF\uFFFF\uFFFF\uFFFF\uFFFF\uFFFF\uFFFF\uFFFF\uFFFF\uFFFF\uFFFF\uFFFF\uFFFF\uFFFF\uFFFF\uFFFF\uFFFF\uFFFF\uFFFF\uFFFF\uFFFF\uFFFF\uFFFF\uFFFF\uFFFF\uFFFF\uFFFF\uFFFF\uFFFF\uFFFF\uFFFF\uFFFF\uFFFF\uFFFF\uFFFF\uFFFF\uFFFF\uFFFF\uFFFF\uFFFF\uFFFF\uFFFF\uFFFF\uFFFF\uFFFF\uFFFF\uFFFF\uFFFF\uFFFF\uFFFF\uFFFF\uFFFF\uFFFF\uFFFF\uFFFF\uFFFF\uFFFF\uFFFF\uFFFF\uFFFF\uFFFF\uFFFF\uFFFF\uFFFF\uFFFF\uFFFF\uFFFF\uFFFF\uFFFF\uFFFF\uFFFF\uFFFF\uFFFF\uFFFF\uFFFF\uFFFF\uFFFF\uFFFF\uFFFF\uFFFF\uFFFF\uFFFF\uFFFF\uFFFF\uFFFF\uFFFF\uFFFF\uFFFF\uFFFF\uFFFF\uFFFF\uFFFF\uFFFF\uFFFF\uFFFF\uFFFF\uFFFF\uFFFF\uFFFF\uFFFF\uFFFF\uFFFF\uFFFF\uFFFF\uFFFF\uFFFF\uFFFF\uFFFF\uFFFF\uFFFF\uFFFF\uFFFF\uFFFF\uFFFF\uFFFF\uFFFF\uFFFF\uFFFF\uFFFF\uFFFF\uFFFF\uFFFF\uFFFF\uFFFF\uFFFF\uFFFF\uFFFF\uFFFF\uFFFF\uFFFF\uFFFF\uFFFF\uFFFF\uFFFF\uFFFF\uFFFF\uFFFF\uFFFF\uFFFF\uFFFF\uFFFF\uFFFF\uFFFF\uFFFF\uFFFF\uFFFF\uFFFF\uFFFF\uFFFF\uFFFF\uFFFF\uFFFF\uFFFF\uFFFF\uFFFF\uFFFF\uFFFF\uFFFF\uFFFF\uFFFF\uFFFF\uFFFF\uFFFF\uFFFF\uFFFF\uFFFF\uFFFF\uFFFF\uFFFF\uFFFF\uFFFF\uFFFF\uFFFF\uFFFF\uFFFF\uFFFF\uFFFF\uFFFF\uFFFF\uFFFF\uFFFF\uFFFF\uFFFF\uFFFF\uFFFF\uFFFF\uFFFF\uFFFF\uFFFF\uFFFF\uFFFF\uFFFF\uFFFF\uFFFF\uFFFF\uFFFF\uFFFF\uFFFF\uFFFF\uFFFF\uFFFF\uFFFF\uFFFF\uFFFF\uFFFF\uFFFF\uFFFF\uFFFF\uFFFF\uFFFF\uFFFF\uFFFF\uFFFF\uFFFF\uFFFF\uFFFF\uFFFF\uFFFF\uFFFF\uFFFF\uFFFF\uFFFF\uFFFF\uFFFF\uFFFF\uFFFF\uFFFF\uFFFF\uFFFF\uFFFF\uFFFF\uFFFF\uFFFF\uFFFF\uFFFF\uFFFF\uFFFF\uFFFF\uFFFF\uFFFF\uFFFF\uFFFF\uFFFF\uFFFF\uFFFF\uFFFF\uFFFF\uFFFF\uFFFF\uFFFF\uFFFF\uFFFF\uFFFF\uFFFF\uFFFF\uFFFF\uFFFF\uFFFF\uFFFF\uFFFF\uFFFF\uFFFF\uFFFF\uFFFF\uFFFF\uFFFF\uFFFF\uFFFF\uFFFF\uFFFF\uFFFF\uFFFF\uFFFF\uFFFF\uFFFF\uFFFF\uFFFF\uFFFF\uFFFF\uFFFF\uFFFF\uFFFF\uFFFF\uFFFF\uFFFF\uFFFF\u0001\u0005\uFFFF\uFFFF\uFFFF\uFFFF\uFFFF\uFFFF\uFFFF\uFFFF\uFFFF\uFFFF\uFFFF\uFFFF\uFFFF\uFFFF\uFFFF\uFFFF\uFFFF\uFFFF\uFFFF\uFFFF\uFFFF\uFFFF\uFFFF\uFFFF\uFFFF\uFFFF\uFFFF\uFFFF\uFFFF\uFFFF\uFFFF\uFFFF\uFFFF\uFFFF\uFFFF\uFFFF\uFFFF\uFFFF\uFFFF\uFFFF\uFFFF\uFFFF\uFFFF\uFFFF\uFFFF\uFFFF\uFFFF\uFFFF\uFFFF\uFFFF\uFFFF\uFFFF\uFFFF\uFFFF\uFFFF\uFFFF\uFFFF\uFFFF\uFFFF\uFFFF\uFFFF\uFFFF\uFFFF\uFFFF";
////        map= strr.toCharArray();
////        for (int i = 0; i < 730; i++) {
////            System.out.println("=========="+((int)map[i]));
////        }
//        strr="";
//        StringBuffer sbf=new StringBuffer(365);
//        for (int i = 0; i < 365-1; i++) {
//            if (i==364){
//                sbf.append(",100");
//            }else{
//                sbf.append(",");
//            }
//        }
//        strr=sbf.toString();
//
//        String[] arr=strr.split(",");
//        System.out.println("*******"+arr.length);
////        for (int i = 0; i < arr.length; i++) {
////            System.out.println("---"+arr[i].equals(""));
////        }
//        String js= JSON.toJSON(arr).toString();
//        System.out.println(js);
//        Long[] arr1=JSON.parseObject(js,Long[].class);
//        for (int i = 0; i < arr1.length; i++) {
//            System.out.println("-1--"+arr1[i]);
//        }
//        System.out.println(strr.length());
//        int index=1;
//        map[index*2+1]=65535;
//        System.out.println("====b======"+(int)(char)((int)map[index*2+1]+2));
//        Long b=(long)map[index*2+1]+65535;
//        System.out.println("====b======"+b);
//        map[index*2]=(char)((long)map[index*2]+b/65535);
//        map[index*2+1]=(char)(b%65535);
//        System.out.println("====map[index*2]======"+(long)map[index*2]);
//        System.out.println("====map[index*2+1]======"+(long)map[index*2+1]);


//        char[] da=new char[366];
//        da[0]=(char)-1;
//        for (int i = 1; i < 366; i++) {
//            da[i]=0;
//        }
//        System.out.println(new String(da));
//        Map<String,Integer> map=new HashMap<>();
//        map.put("1",65535);
//        map.put("2",65535);
//        map.put("3",5);
//        map.put("4",5);
//        map.put("5",5);
//        map.put("6",10);
//        map.put("7",20);
//        String str22=JSON.toJSONString(map);
//        System.out.println(str22);
    }
}
