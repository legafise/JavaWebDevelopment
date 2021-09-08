package by.training.demothreads.producerconsumer;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public class LockProducerConsumerApp {
    public static void main(String[] args) {
        LockStore store = new LockStore();
        LockProducer producer = new LockProducer(store);
        LockConsumer consumer = new LockConsumer(store);
        new Thread(producer).start();
        new Thread(consumer).start();
    }
}

//Класс Склад, хранящий произведенные товары
class LockStore {
    private int product = 0;
    ReentrantLock locker;
    Condition notFull;
    Condition notNull;

    LockStore() {
        locker = new ReentrantLock(); // создаем блокировку
        notFull = locker.newCondition(); // получаем условие, связанное с блокировкой
        notNull = locker.newCondition(); // получаем условие, связанное с блокировкой
    }

    public void get() {
        locker.lock();
        try {
            // пока нет доступных товаров на складе, ожидаем
            while (product < 1) {
                notNull.await();
            }

            product--;
            System.out.println("Покупатель купил 1 товар");
            System.out.println("Товаров на складе: " + product);

            // сигнализируем
            notFull.signal();
        } catch (InterruptedException e) {
            System.out.println(e.getMessage());
        } finally {
            locker.unlock();
        }
    }

    public void put() {
        locker.lock();
        try {
            // пока на складе 3 товара, ждем освобождения места
            while (product >= 3) {
                notFull.await();
            }

            product++;
            System.out.println("Производитель добавил 1 товар");
            System.out.println("Товаров на складе: " + product);
            // сигнализируем
            notNull.signal();
        } catch (InterruptedException e) {
            System.out.println(e.getMessage());
        } finally {
            locker.unlock();
        }
    }
}

//класс Производитель
class LockProducer implements Runnable {
    LockStore store;

    LockProducer(LockStore store) {
        this.store = store;
    }

    public void run() {
        for (int i = 1; i < 6; i++) {
            store.put();
        }
    }
}

//Класс Потребитель
class LockConsumer implements Runnable {
    LockStore store;

    LockConsumer(LockStore store) {
        this.store = store;
    }

    public void run() {
        for (int i = 1; i < 6; i++) {
            store.get();
        }
    }
}
