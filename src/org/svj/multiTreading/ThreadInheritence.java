package org.svj.multiTreading;

public class ThreadInheritence {
    public static void main(String[] args) {
        Thread thread= new ThreadInstance();
        thread.setName("New Worker Thread");
        thread.start();
    }

    private static class ThreadInstance extends Thread {
        @Override
        public void run() {
            System.out.println("This thread: "+getName()+" is called from main method ");
        }
    }
}
