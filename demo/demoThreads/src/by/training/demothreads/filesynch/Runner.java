package by.training.demothreads.filesynch;

import java.io.IOException;

public class Runner {
    public static void main(String[ ] args) {
        Resource s = null;
        try {
            s = new Resource ("D:\\JavaWebDevelopment\\demo\\demoThreads\\src\\by\\training\\demothreads\\filesynch\\resources\\result.txt");
            SyncThread t1 = new SyncThread("First", s);
            SyncThread t2 = new SyncThread("Second", s);
            t1.start();
            t2.start();
            t1.join();
            t2.join();
        } catch (IOException e) {
            System.err.print("ошибка файла: " + e);
        } catch (InterruptedException e) {
            System.err.print("ошибка потока: " + e);
        } finally {
            s.close();
        }
    }
}
