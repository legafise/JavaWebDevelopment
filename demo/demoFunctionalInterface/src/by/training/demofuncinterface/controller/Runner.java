package by.training.demofuncinterface.controller;

import by.training.demofuncinterface.entity.Car;

public class Runner {
    private String value = "Enclosing scope value";

    private static void printTest(Car car, CheckCar checker) {
        if (checker.test(car)) {
            System.out.println(car + " it is fit");
        } else {
            System.out.println(car + " it is not fit");
        }
    }

    public static void main(String[] args) {
        ScopeExperiment scopeExperiment = new ScopeExperiment();
        System.out.println(scopeExperiment.scopeExperiment());
//        Car audiA3 = new Car("AudiA3", true, true);
//        Car audiA6 = new Car("AudiA6", false, false);

//        CheckCar checker = new CheckCar() {
//            @Override
//            public boolean test(Car c) {
//                System.out.println("-----" + isCorrect(c) );
//                return c.isFullDrive();
//            }
//            public boolean isCorrect(Car c) {
//            return true;
//        }
//        };
//        printTest(audiA3, checker);


        //checker.isCorrect(audiA3 );


//
//        printTest(audiA6, checker);
//        printTest(audiA3, checker);
////
//        printTest(audiA3, new CheckCar() {
//                    @Override
//                    public boolean test(Car c) {
//                        return c.isFullDrive();
//                    }
//                });
            //
//        });

//        printTest(audiA3, c -> c.isFullDrive());
//
//
//
//       printTest(audiA6,Car::isFullDrive);
//       printTest(audiA3,Car::isFullDrive);
//
//        printTest(audiA3, checker);
//        printTest(audiA6, checker);


//
//        printTest(audiA3, c -> c.isGasEngine());
//        printTest(audiA6, c -> c.isGasEngine());
//        printTest(audiA6, c -> true);
    }
}


//class Runner{
//    public static void main(String[] args) {
//
//        Consumer<String> con =  new Consumer(){
//            @Override
//            public void accept(final Object newO) {
//                System.out.println(newO);
//            }
//
//        };
//
//        //Consumer<String> con = s -> System.out.println(s);
//        con.accept("Функциональные интерфейсы в Java 8");
//    }
//}

//import java.util.function.*;

//public class Runner{
//    public static void main(String[] args) {
//        BiPredicate<String, String> pred = (s1, s2) -> s1.equals(s2);
//        System.out.println(pred.test("Функциональные интерфейсы", " Функциональные интерфейсы"));
//    }
//}

