package by.training.demothreads.producerconsumer;

public class NotifyProducerConsumerApp {
    public static void main(String[] args) {
        NotifyStore store = new NotifyStore();
        new NotifyProducer(store).start();
        new NotifyConsumer(store).start();

	 /*	Producer producer = new Producer(store);
		Consumer consumer = new Consumer(store);
		new Thread(producer).start();
		new Thread(consumer).start();*/

    }
}

//Класс Склад, хранящий произведенные товары
class NotifyStore {
    private int product = 0;

    public synchronized void put() {
        while (product >= 3) {
            try {
                wait();
            } catch (InterruptedException e) {
            }
        }

        product++;
        System.out.println("Производитель добавил 1 товар");
        System.out.println("Товаров на складе: " + product);
        notify();
    }

    public synchronized void get() {
        while (product < 1) {
            try {
                wait();
            } catch (InterruptedException e) {
            }
        }
        product--;
        System.out.println("Покупатель купил 1 товар");
        System.out.println("Товаров на складе: " + product);
        notify();
    }
}

//класс Производитель
class NotifyProducer extends Thread {//implements Runnable {
    NotifyStore store;

    NotifyProducer(NotifyStore store) {
        this.store = store;
    }

    public void run() {
        for (int i = 1; i < 6; i++) {
            store.put();
        }
    }
}

//Класс Потребитель
class NotifyConsumer extends Thread {//implements Runnable {
    NotifyStore store;

    NotifyConsumer(NotifyStore store) {
        this.store = store;
    }

    public void run() {
        for (int i = 1; i < 6; i++) {
            store.get();
        }
    }
}

