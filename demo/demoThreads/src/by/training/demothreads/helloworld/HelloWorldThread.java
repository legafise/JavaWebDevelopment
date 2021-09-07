package by.training.demothreads.helloworld;

public class HelloWorldThread extends Thread {
    private String message;

    public HelloWorldThread(String message, String name) {
        super(name);
        this.message = message;
    }

    @Override
    public void run() {
        System.out.println(message + " - " + Thread.currentThread().getName());
    }
}
