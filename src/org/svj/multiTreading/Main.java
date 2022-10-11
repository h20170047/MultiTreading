package org.svj.multiTreading;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        Thread thread= new Thread(new Runnable(){
            @Override
            public void run() {
                System.out.println("This is from thread:  "+Thread.currentThread().getName());
                System.out.println("Priority of thread is "+Thread.currentThread().getPriority());
            }
        });
        System.out.println("From thread: "+Thread.currentThread().getName()+". Before execution of new thread");
        thread.setName("New Worker Thread");
        thread.setPriority(Thread.MAX_PRIORITY);
        thread.start();
        Thread.sleep(1000);
        System.out.println("From thread: "+Thread.currentThread().getName()+". After execution of new thread");
    }
}
