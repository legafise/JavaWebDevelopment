package by.training.demothreads.helloworld;

public class Main {
    public static void main(String[] args) {
        for (int i = 0; i < 15; i++) {
            HelloWorldThread thread = new HelloWorldThread("Hello World! " + i, "Thread №" + i);
            thread.start();
        }
    }
}
