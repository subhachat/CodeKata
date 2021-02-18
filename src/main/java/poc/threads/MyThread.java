package poc.threads;

public class MyThread extends Thread {

    @Override
    public void run() {
        for (int counter = 0; counter < 10; counter++) {
            System.out.println(counter + " " + this.getName());
        }
    }
}
