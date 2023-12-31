package tsk2;

public class Circle implements FlatFigure{
    private final double radius;

    public Circle(final double radius) {
        if (radius <= 0)
            throw new IllegalArgumentException("Radius can`t be zero or less");
        this.radius = radius;
    }
    public double getArea() {
        return radius * radius * Math.PI;
    }
}
