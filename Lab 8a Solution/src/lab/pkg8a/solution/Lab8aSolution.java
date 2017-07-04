package lab.pkg8a.solution;

import java.util.ArrayList;
import java.util.Collections;

public class Lab8aSolution {

    public static void main(String[] args) {
        
        Thread thread1 = new thread_1();
        Thread thread2 = new Thread(new thread_2());
        Thread thread3 = new Thread(new thread_3());
        
        final int size = 1000000;
        
        ArrayList<Double> list1 = new ArrayList<>(size);
        for (int i=0; i<size; i++) {
            list1.add(Math.random());
        }
        
        ArrayList<Double> list2 = new ArrayList<>(size);
        for (int i=0; i<size; i++) {
            list2.add(Math.random());
        }
        
        ArrayList<Double> list3 = new ArrayList<>(size);
        for (int i=0; i<size; i++) {
            list3.add(Math.random());
        }
        
        long time = new Lab8aSolution().sort(list1, list2, list3);
        
        long threadstarttime1;
        long threadstarttime2;
        long threadstarttime3;
        
        long threadendtime1 = 0;
        long threadendtime2 = 0;
        long threadendtime3 = 0;
        
        
        thread1.start();
        thread2.start();
        thread3.start();
        threadstarttime1 = System.currentTimeMillis();
        try{
            thread1.join();
            thread2.join();
            thread3.join();
            threadendtime1 = System.currentTimeMillis();
        }catch(Exception e)
        {
            System.err.println("Thread Interrupted!");
        }
        
        long totalthreadtime = threadendtime1 - threadstarttime1;
        System.out.println("Single Threaded Sorting took " + time + " ms");
        
        System.out.println("Multi Threaded Sorting took " + totalthreadtime + " ms");
    }
    
    
    public long sort(ArrayList<Double> list1, ArrayList<Double> list2, 
            ArrayList<Double> list3) {
        
        long startTime = System.currentTimeMillis();
        
        Collections.sort(list1);
        Collections.sort(list2);
        Collections.sort(list3);

        long endTime = System.currentTimeMillis();
        return endTime - startTime;
    }
}

class thread_1 extends Thread{
    
    @Override
    public void run(){
        int size = 1000000;    
        ArrayList<Double> thread_list1 = new ArrayList<>(size);
        for(int i = 0; i < size; i++)
        {
            thread_list1.add(Math.random());
        }
        
        long start = System.currentTimeMillis();
        Collections.sort(thread_list1);
        long end = System.currentTimeMillis();
        long time = end - start;
        System.out.println("Thread 1: " + time);
}
}

class thread_2 implements Runnable
{
    @Override
    public void run() {
        int size = 1000000;    
        ArrayList<Double> thread_list2 = new ArrayList<>(size);
        for(int i = 0; i < size; i++)
        {
            thread_list2.add(Math.random());
        }
        
        long start = System.currentTimeMillis();
        Collections.sort(thread_list2);
        long end = System.currentTimeMillis();
        long time = end - start;
        System.out.println("Thread 2: " + time);
    }
            
}

class thread_3 implements Runnable
{

    @Override
    public void run() {
        
        int size = 1000000;    
        ArrayList<Double> thread_list3 = new ArrayList<>(size);
        for(int i = 0; i < size; i++)
        {
            thread_list3.add(Math.random());
        }
        
        long start = System.currentTimeMillis();
        Collections.sort(thread_list3);
        long end = System.currentTimeMillis();
        long time = end - start;
        System.out.println("Thread 3 " + time);
    }
}

