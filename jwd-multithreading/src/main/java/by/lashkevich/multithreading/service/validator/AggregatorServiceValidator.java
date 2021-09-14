package by.lashkevich.multithreading.service.validator;

import java.util.List;

/**
 * Class that validates aggregators
 * @author RomalLashkevich
 */
public class AggregatorServiceValidator {
    public boolean isValidAggregatorsAmount(List<Integer> aggregatorsData, int minAmount, int maxAmount) {
        return aggregatorsData.size() > minAmount && aggregatorsData.size() < maxAmount;
    }
}
