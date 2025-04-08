package org.example.thread;

public class ThreadState extends Thread {

    @Override
    public void run() {
        synchronized (this) {
            try {
                Thread.sleep(500);
                wait();
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                System.out.println(e.getMessage());
            }
        }
    }

    public static void main(String[] args) throws InterruptedException {
        ThreadState threadState = new ThreadState();
        System.out.println(threadState.getState()); //NEW

        threadState.start();
        System.out.println(threadState.getState()); //RUNNABLE

        Thread.sleep(500);
        System.out.println(threadState.getState()); //TIMED_WAITING

        synchronized (threadState) {
            System.out.println(threadState.getState()); // WAITING
            threadState.notify();
        }

        Thread blockedThread = new Thread(() -> {
            synchronized (threadState) {
            }
        });

        synchronized (threadState) {
            blockedThread.start();
            Thread.sleep(500);
            System.out.println(blockedThread.getState()); //BLOCKED
        }

        threadState.join();
        System.out.println(threadState.getState()); //TERMINATED
    }
}

/**
 *
 * ### **Code Analysis and State Explanations**
 *
 * 1. **`System.out.println(threadState.getState()); // NEW`**
 *    - **State**: `NEW`
 *    - **Reason**: The thread is created but not yet started, so it remains in the `NEW` state. No system resources are allocated yet.
 *
 * ---
 *
 * 2. **`threadState.start(); System.out.println(threadState.getState()); // RUNNABLE`**
 *    - **State**: `RUNNABLE`
 *    - **Reason**: The thread is ready to run but may or may not be actively running on the CPU. Threads in the `RUNNABLE` state are queued by the OS scheduler and may still be waiting for execution time.
 *
 * ---
 *
 * 3. **`Thread.sleep(500); System.out.println(threadState.getState()); // TIMED_WAITING`**
 *    - **State**: `TIMED_WAITING`
 *    - **Reason**: The thread is inside `Thread.sleep(500)` for the specified duration. During this time, it cannot perform any task and is waiting for the sleep period to complete.
 *    - **Why State Might Differ**:
 *      - If the `sleep()` finishes execution before the `getState()` call, the thread transitions back to `RUNNABLE`.
 *      - Thread scheduling is nondeterministic; delays in CPU cycles may lead to timing discrepancies.
 *
 * ---
 *
 * 4. **`synchronized (threadState) { System.out.println(threadState.getState()); // WAITING }`**
 *    - **State**: `WAITING`
 *    - **Reason**: The thread is in the `wait()` method and is waiting indefinitely until it is notified. The `WAITING` state occurs when `wait()` is invoked without a timeout.
 *    - **Why State Might Differ**:
 *      - If `notify()` is already called by the main thread before `getState()` is invoked, the thread might not remain in the `WAITING` state. It could have transitioned to `RUNNABLE` or `TERMINATED`.
 *
 * ---
 *
 * 5. **Blocked Thread**:
 *    ```java
 *    Thread blockedThread = new Thread(() -> {
 *        synchronized (threadState) {}
 *    });
 *    synchronized (threadState) {
 *        blockedThread.start();
 *        Thread.sleep(500);
 *        System.out.println(blockedThread.getState()); // BLOCKED
 *    }
 *    ```
 *    - **State**: `BLOCKED`
 *    - **Reason**: The `blockedThread` is attempting to acquire a lock on `threadState` but cannot because the main thread holds the lock at that moment. This results in the `BLOCKED` state.
 *    - **Why State Might Differ**:
 *      - If the lock is released quickly or the CPU scheduler delays the thread's execution, the thread might transition from `BLOCKED` to `RUNNABLE` or `TERMINATED` by the time `getState()` is called.
 *
 * ---
 *
 * 6. **`threadState.join(); System.out.println(threadState.getState()); // TERMINATED`**
 *    - **State**: `TERMINATED`
 *    - **Reason**: After completing its `run()` method, the thread transitions to the `TERMINATED` state. The `join()` ensures the main thread waits for the worker thread to finish.
 *    - **Why State Might Differ**:
 *      - If the `join()` is skipped or not executed, the state might still be `RUNNABLE` or `WAITING` when checked earlier, depending on the thread's progress.
 *
 * ---
 *
 * ### **General Notes on State Variations**
 * 1. **Timing and Scheduling**:
 *    - The JVM and OS thread scheduler decide thread execution, leading to potential timing variations.
 *    - `getState()` is a snapshot and may not represent the current state precisely if the thread transitions between states quickly.
 *
 * 2. **Synchronization Delays**:
 *    - If the main thread delays acquiring or releasing locks, other threads may remain in `BLOCKED` or `WAITING` states longer than expected.
 *
 * 3. **CPU Load and Resource Contention**:
 *    - High CPU load or resource contention can delay thread execution and cause states like `RUNNABLE` to persist longer.
 *
 * By carefully using `synchronized` blocks and ensuring sufficient delays (`Thread.sleep`) to allow transitions, you can consistently observe each state in this program.
 */
