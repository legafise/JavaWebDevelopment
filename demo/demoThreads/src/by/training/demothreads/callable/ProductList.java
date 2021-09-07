package by.training.demothreads.callable;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.concurrent.*;

public class ProductList {
    private static ArrayDeque<String> arr = new ArrayDeque<>() {
        {
            this.add("Product 1");
            this.add("Product 2");
            this.add("Product 3");
            this.add("Product 4");
            this.add("Product 5");
        }
    };

    public static String getProduct() {
        return arr.poll();
    }
}

/* # 41 # поток обработки экземпляра продукта # BaseCallable.java */
class BaseCallable implements Callable<String> {
    @Override
    public String call() throws Exception {
        String product = ProductList.getProduct();
        String result;
        if (product != null) {
            result = product + " done";
        } else {
            result = "productList is empty";
        }

        TimeUnit.MILLISECONDS.sleep(100);
        System.out.println(result);
        return result;
    }
}

/* # 42 # запуск пула потоков и извлечение результатов их работы # RunExecutor.java */
class RunExecutor {
    public static void main(String[] args) throws Exception {
        ArrayList<Future<String>> list = new ArrayList<>();
        ExecutorService es = Executors.newFixedThreadPool(3);
        for (int i = 0; i < 7; i++) {
            list.add(es.submit(new BaseCallable()));
        }

        es.shutdown();
        for (Future<String> future : list) {
            System.out.println(future.get() + " result fixed");
        }
    }
}
