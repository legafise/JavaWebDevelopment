package by.training.demothreads.runnableperson;

public class Main {
    public static void main(String[] args) {
        RunnablePerson alis = new RunnablePerson(new Person("Alis", "G"));
        RunnablePerson bob = new RunnablePerson(new Person("Bob", "H"));

        Thread aliceThread = new Thread(alis);
        Thread bobThread = new Thread(bob);

//        aliceThread.setPriority(10);
//        bobThread.setPriority(1);

        aliceThread.start();
        bobThread.start();

        try {
            aliceThread.join();
            bobThread.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("Finish");
    }
}
