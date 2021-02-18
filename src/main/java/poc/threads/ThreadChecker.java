package poc.threads;

public class ThreadChecker {

    public static void main(String... args) {
        System.out.println("[01]Active thread count = " + Thread.activeCount());
        MyThread thread1 = new MyThread();
        thread1.setName("TR01");
        thread1.start();
        System.out.println("[02]Active thread count = " + Thread.activeCount());
        MyThread thread2 = new MyThread();
        thread2.setName("TR02");
        thread2.start();
        System.out.println("[03]Active thread count = " + Thread.activeCount());

        Thread thread3 = new Thread(new MyRunnable());
        thread3.start();
        System.out.println("[04]Active thread count = " + Thread.activeCount());
        Thread thread4 = new Thread(new Runnable() {
            @Override
            public void run() {
                for (int counter = 0; counter < 10; counter++) {
                    System.out.println(counter + " " + Thread.currentThread().getName());
                }
            }
        });
        thread4.start();
        System.out.println("[05]Active thread count = " + Thread.activeCount());
        Thread thread5 = new Thread(() -> {
            for (int counter = 0; counter < 10; counter++) {
                System.out.println(counter + " " + Thread.currentThread().getName());
            }
        });
        thread5.start();
        System.out.println("[06]Active thread count = " + Thread.activeCount());
    }
}
