package task6;

import java.util.Optional;

class EUR_Coin extends EUR implements Coin {
    private final properties properties;

    public EUR_Coin(double wert) {
        super(wert);
        properties = select();
    }

    public final boolean isValid() {
        return properties != null;
    }

    public final double getWeight() {
        return Optional.ofNullable(this.properties).map(p -> p.thickness).orElse(0.0);
    }

    public final double getDiameter() {
        return Optional.ofNullable(this.properties).map(p -> p.thickness).orElse(0.0);
    }

    public final double getThickness() {
        return Optional.ofNullable(this.properties).map(p -> p.thickness).orElse(0.0);
    }


    final properties select() {
        final properties[] data = {new properties(0.01, 2.30, 16.25, 1.67),
                new properties(0.02, 3.06, 18.75, 1.67),
                new properties(0.05, 3.92, 21.25, 1.67),
                new properties(0.10, 4.10, 19.75, 1.93),
                new properties(0.20, 5.74, 22.25, 2.14),
                new properties(0.50, 7.80, 24.25, 2.38),
                new properties(1.00, 7.50, 23.25, 2.33),
                new properties(2.00, 8.50, 25.75, 2.20)};
        for (properties dataProperty : data)
            if (this.getValue() == dataProperty.value)
                return dataProperty;
        return null;
    }


    @Override
    public final int compareTo(final PaymentMethod o) {
        return Double.compare(this.getValue(), o.getValue());
    }
}

