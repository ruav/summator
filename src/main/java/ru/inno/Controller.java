package ru.inno;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Created by ruav on 18.12.16.
 */
public class Controller {


    // Карта для хранения счетчиков вхождений. На данном уровне, хватит и hashmap и synchronized блоков.
    private Map<String, Integer> map = new HashMap<>();

    volatile static boolean breakAll = false;

    public volatile static long count = 0;

    // Различные варианты блокировки. Сугубо для практики.
    private Object monitor = new Object();
    private Lock lock = new ReentrantLock();

    List<Thread> threadList = new ArrayList<>();

    public Controller() {
    }

    public void start(String[] args){

        for(int i = 0; i < args.length; ){
//            Thread thread = new Thread(new Counter(s,map, monitor));
            Thread thread = new Thread(new Counter(args[i], args[i+1],getMap(), getLock()));
            i = i + 2;
            threadList.add(thread);
            thread.start();

            // для того, что бы все отработало, и после нормально посмотреть общую статистику.
//            try {
//                thread.join();
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }

            if(breakAll){
                map.clear();
//            logger.warn("Файлы содержат латиницу, поэтому статистика не верна.");
//            System.out.println("Файлы содержат латиницу, поэтому статистика не верна.");
                return;
            }
        }

    }

    public Map<String, Integer> getMap() {
        return map;
    }

    public Object getMonitor() {
        return monitor;
    }

    public Lock getLock() {
        return lock;
    }
}
