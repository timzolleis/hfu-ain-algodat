package task6;

import java.util.Optional;

class USD_Coin extends USD implements Coin {
    private final properties properties;

    public USD_Coin(double wert) {
        super(wert);
        this.properties = select();
    }

    public final boolean isValid() {
        return this.properties != null;
    }

    public final double getWeight() {
        return Optional.ofNullable(this.properties).map(p -> p.weight).orElse(0.0);
    }

    public final double getDiameter() {
        return Optional.ofNullable(this.properties).map(p -> p.diameter).orElse(0.0);
    }

    public final double getThickness() {
        return Optional.ofNullable(this.properties).map(p -> p.thickness).orElse(0.0);
    }


    final properties select() {
        final properties[] data = {new properties(0.01, 2.50, 19.05, 1.55),
                new properties(0.05, 5.00, 21.21, 1.95),
                new properties(0.10, 2.27, 19.91, 1.35),
                new properties(0.25, 5.67, 24.26, 1.75),
                new properties(0.50, 11.34, 30.61, 2.15),
                new properties(1.00, 8.10, 26.50, 2.00)};
        for (properties dataProperty : data)
            if (this.getValue() == dataProperty.value)
                return dataProperty;
        return null;
    }

}
