package by.training.demothreads.runnableperson;

public class RunnablePerson implements Runnable {
    private Person person;

    public RunnablePerson(Person person) {
        this.person = person;
    }

    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            System.out.println(person.getName() + ": Hello World!");
        }
    }
}
