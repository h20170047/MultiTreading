package org.svj.multiTreading;

import java.util.LinkedList;
import java.util.List;

public class MultiExecutor {

    // Add any necessary member variables here

    /*
     * @param tasks to executed concurrently
     */
    public MultiExecutor(List<Runnable> tasks) {
        // Complete your code here
        List<Thread> parallelThreads= new LinkedList<>();
        for(int i=0; i<tasks.size(); i++){
            parallelThreads.add(new Thread(tasks.get(i)));
            parallelThreads.get(i).start();
        }
    }

    /**
     * Starts and executes all the tasks concurrently
     */
    public void executeAll() {
        // complete your code here
        List<Runnable> tasks= new LinkedList<>();

    }
}
