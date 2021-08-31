package by.training.demofuncinterface.controller;

import by.training.demofuncinterface.entity.Car;

//@FunctionalInterface
interface CheckCar {
    public boolean test(Car car);

    default public boolean test1(Car car){
         return true;
    }
    default public boolean test2(Car car){
        return true;
    }
}

