package org.svj.multiTreading;

import java.text.NumberFormat;
import java.util.Locale;
import java.util.Random;

public class SecurityGame {
    private static int maxKeyValue= 1000;
    public static void main(String[] args) {
        Vault vault= new Vault();
        Thread[] hacker = new HackerThread[]{new HackerThread(vault), new HackerThread(vault), new HackerThread(vault)};
//        = new HackerThread[3];
        for(int i=0; i< hacker.length; i++){
            hacker[i].setName("Hacker-"+(i+1));
            hacker[i].start();
        }
        Thread police= new PoliceThread();
        police.setName("Police");
        police.start();
    }

    private static class HackerThread extends HeistThread{
        public HackerThread(Vault vault) {
            super(vault);
        }
    }

    private static class PoliceThread extends Thread{
        @Override
        public void run() {
            int waitTime = 10;
            while (waitTime > 0) {
                System.out.println("Police will arrive in " + waitTime + " seconds");
                try {
                    sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                waitTime--;
            }
            System.out.println("Capturing robbers!");
            System.exit(-2);
        }
    }

    private static class HeistThread extends Thread {
        protected static Vault vault;
        protected boolean stopThread= false;

        public HeistThread(Vault vault){
            this.vault= vault;
//            this.setName(this.getClass().getName());
            setPriority(MAX_PRIORITY);
        }
        @Override
        public void run() {
            try {
                Random random= new Random();
//                System.out.println("Hint Vault key is "+vault.vaultKey);
                int guess;
                while(!stopThread){
                    sleep(50);
                    guess= random.nextInt(maxKeyValue);
                    if(guess== vault.vaultKey){
                        System.out.println("Vault key "+vault.vaultKey+" was cracked by "+getName());
                        vault.fund= "$ 0";
                        vault.stolen= true;
                        stopThread= true;
                        System.exit(-1);
                    }
                }
            } catch (InterruptedException e) {
                System.out.println("Thread "+getName()+" was interrupted- "+e.getMessage());
            }
        }
    }

    private static class Vault {
        boolean stolen= false;
        int vaultKey= new Random().nextInt(maxKeyValue);
        NumberFormat moneyFormatter= NumberFormat.getCurrencyInstance(Locale.US);
        String fund= moneyFormatter.format(1000000000);
    }
}
