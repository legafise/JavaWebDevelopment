package by.lashkevich.figures.service;

import by.lashkevich.figures.entity.Tetrahedron;

public class ServiceValidator {
    private static final double ACCURACY_FOR_COMPARE = 0.1;

    public boolean validateTetrahedron(Tetrahedron tetrahedron) {
        DistanceFinder distanceFinder = new DistanceFinder();
        double firstDistance = distanceFinder
                .findDistanceBetweenTwoPoints(tetrahedron.getFourthPoint(), tetrahedron.getFirstPoint());
        double secondDistance = distanceFinder
                .findDistanceBetweenTwoPoints(tetrahedron.getFourthPoint(), tetrahedron.getSecondPoint());
        double thirdDistance = distanceFinder
                .findDistanceBetweenTwoPoints(tetrahedron.getFourthPoint(), tetrahedron.getThirdPoint());
        double fourthDistance = distanceFinder
                .findDistanceBetweenTwoPoints(tetrahedron.getFirstPoint(), tetrahedron.getSecondPoint());
        double fifthDistance = distanceFinder
                .findDistanceBetweenTwoPoints(tetrahedron.getFirstPoint(), tetrahedron.getThirdPoint());
        double sixthDistance = distanceFinder
                .findDistanceBetweenTwoPoints(tetrahedron.getSecondPoint(), tetrahedron.getThirdPoint());

        return compareDoubleValuesWithAccuracy(firstDistance, secondDistance)
                && compareDoubleValuesWithAccuracy(firstDistance, thirdDistance)
                && compareDoubleValuesWithAccuracy(firstDistance, fourthDistance)
                && compareDoubleValuesWithAccuracy(firstDistance, fifthDistance)
                && compareDoubleValuesWithAccuracy(firstDistance, sixthDistance);
    }

    private boolean compareDoubleValuesWithAccuracy(double firstNumber, double secondNumber) {
        return Math.abs(firstNumber - secondNumber) <= ServiceValidator.ACCURACY_FOR_COMPARE;
    }
}
