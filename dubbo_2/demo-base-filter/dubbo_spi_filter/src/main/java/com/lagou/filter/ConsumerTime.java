package com.lagou.filter;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/**
 * @author Chenyuhua
 * @date 2020/5/10 19:58
 */
public class ConsumerTime implements Runnable{
    private static ConsumerTime instance;
    public  static Map<String, Map<Date,Long>>  mothodTime= new ConcurrentHashMap<>();

    public  Map<String, Map<Date, Long>> getMothodTime() {
        return mothodTime;
    }

    public  void setMothodTime(Map<String, Map<Date, Long>> mothodTime) {
        ConsumerTime.mothodTime = mothodTime;
    }

    private ConsumerTime (){
        Executors.newSingleThreadScheduledExecutor().scheduleWithFixedDelay(this, 1, 5, TimeUnit.SECONDS);
     }
    public static synchronized ConsumerTime getInstance() {
        if (instance == null) {
            instance = new ConsumerTime();
        }
        return instance;
    }

    @Override
    public void run() {
        System.out.println("性能监控启动");
        Set<Map.Entry<String, Map<Date, Long>>> entries = mothodTime.entrySet();
        if(Objects.isNull(entries)||entries.size() ==0){
            System.out.println("not entries");
            return;
        }
        for (Map.Entry<String, Map<Date, Long>> en:entries) {
            String key = en.getKey();
            Map<Date, Long> value = en.getValue();
            Set<Map.Entry<Date, Long>> dateCosts = value.entrySet();
            Calendar cal = Calendar.getInstance();
            cal.add(Calendar.MINUTE, -1);
            Date actTime = cal.getTime();
            if(Objects.isNull(dateCosts)||dateCosts.size() ==0){
                System.out.println("not costTime");
                continue;
            }
            for (Map.Entry<Date, Long> dateCost:dateCosts) {
                Date key1 = dateCost.getKey();
                if(key1.before(actTime)){
                    value.remove(key1);
                }
            }

            Collection<Long> values = value.values();
            ArrayList<Long> longs = new ArrayList<>(values);
            Collections.sort(longs);

            int index = (int)(0.9 * longs.size() - 1);
            if(index<0){
                index =0;
            }
            Long tp90 = longs.get(index);
            System.out.println("method:"+key+"tp90:"+tp90);

            int NineNineIndex= (int)(0.99 * longs.size() - 1);
            if(NineNineIndex<0){
                NineNineIndex =0;
            }
            Long tp99 = longs.get(NineNineIndex);
            System.out.println("method:"+key+"tp99:"+tp99);
        }
    }
}
