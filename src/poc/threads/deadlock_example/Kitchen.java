package poc.threads.deadlock_example;

public class Kitchen {

    private static Object spoon = new Object();
    private static Object bowl = new Object();

    public static void main(String... args){
        /*Thread cook1 = new Thread(() -> {
            synchronized (spoon){
                System.out.println("Cook1 has the Spoon...waiting for the Bowl");
                synchronized (bowl){
                    System.out.println("Cook1 has the Spoon and the Bowl");
                }
            }
        });*/
        Thread cook1 = new Thread(() -> {
            synchronized (bowl){
                System.out.println("Cook1 has the Bowl...waiting for the Spoon");
                synchronized (spoon){
                    System.out.println("Cook1 has the Bowl and the Spoon");
                }
            }
        });

        Thread cook2 = new Thread(() -> {
            synchronized (bowl){
                System.out.println("Cook2 has the Bowl...waiting for the Spoon");
                synchronized (spoon){
                    System.out.println("Cook2 has the Bowl and the Spoon");
                }
            }
        });

        cook1.start();
        cook2.start();
    }
}
