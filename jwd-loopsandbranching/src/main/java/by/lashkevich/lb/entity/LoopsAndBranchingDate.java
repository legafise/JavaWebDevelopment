package by.lashkevich.lb.entity;

import java.util.Objects;

/**
 * Class created to work within a job with date validation
 * @author RomalLashkevich
 */
public class LoopsAndBranchingDate {
    private int day;
    private int month;

    public LoopsAndBranchingDate(int day, int month) {
        this.day = day;
        this.month = month;
    }

    public int getDay() {
        return day;
    }

    public void setDay(int day) {
        this.day = day;
    }

    public int getMonth() {
        return month;
    }

    public void setMonth(int month) {
        this.month = month;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        LoopsAndBranchingDate that = (LoopsAndBranchingDate) o;
        return day == that.day &&
                month == that.month;
    }

    @Override
    public int hashCode() {
        return Objects.hash(day, month);
    }

    @Override
    public String toString() {
        return "Date{" +
                "day=" + day +
                ", month=" + month +
                '}';
    }
}
