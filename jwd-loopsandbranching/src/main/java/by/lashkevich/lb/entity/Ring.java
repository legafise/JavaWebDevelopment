package by.lashkevich.lb.entity;

import java.util.Objects;

public class Ring {
    private double innerRadius;
    private double outerRadius;

    public Ring() {
    }

    public Ring(double innerRadius, double outerRadius) {
        this.innerRadius = innerRadius;
        this.outerRadius = outerRadius;
    }

    public double getInnerRadius() {
        return innerRadius;
    }

    public void setInnerRadius(double innerRadius) {
        this.innerRadius = innerRadius;
    }

    public double getOuterRadius() {
        return outerRadius;
    }

    public void setOuterRadius(double outerRadius) {
        this.outerRadius = outerRadius;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Ring ring = (Ring) o;
        return Double.compare(ring.innerRadius, innerRadius) == 0 &&
                Double.compare(ring.outerRadius, outerRadius) == 0;
    }

    @Override
    public int hashCode() {
        return Objects.hash(innerRadius, outerRadius);
    }

    @Override
    public String toString() {
        return "Ring{" +
                "innerRadius=" + innerRadius +
                ", outerRadius=" + outerRadius +
                '}';
    }
}
