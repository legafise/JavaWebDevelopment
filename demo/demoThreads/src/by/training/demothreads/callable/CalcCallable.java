package by.training.demothreads.callable;

import java.util.Random;
import java.util.concurrent.*;

public class CalcCallable implements Callable<Number> {
    @Override
    public Number call() {
        Number res = new Random().nextGaussian(); // имитация вычислений
        return res;
    }
}

/* # 39 # запуск потока и извлечение результата его выполнения # CalcRunner.java */
class CalcRunner {
    public static void main(String[] args) {
        ExecutorService es = Executors.newSingleThreadExecutor();
        Future<Number> future = es.submit(new CalcCallable());
        es.shutdown();
        try {
            System.out.println(future.get());
        } catch (InterruptedException | ExecutionException e) {
            e.printStackTrace();
        }
    }
}
