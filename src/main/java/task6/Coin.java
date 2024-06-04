package task6;

public interface Coin {
    double getWeight();

    double getDiameter();

    double getThickness();

    class properties {
        final double value;
        final double weight;
        final double diameter;
        final double thickness;

        properties(final double value, final double weight, final double diameter, final double thickness) {
            this.value = value;
            this.weight = weight;
            this.diameter = diameter;
            this.thickness = thickness;
        }
    }

}
