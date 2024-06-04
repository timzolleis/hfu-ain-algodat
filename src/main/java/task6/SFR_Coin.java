package task6;

import java.util.Optional;

public class SFR_Coin extends SFR implements Coin {
    private final properties properties;

    public SFR_Coin(double wert) {
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
        final properties[] daten = {new properties(0.05, 1.80, 17.15, 1.25),
                new properties(0.10, 3.00, 19.15, 1.45),
                new properties(0.20, 4.00, 21.05, 1.65),
                new properties(0.50, 2.20, 18.20, 1.25),
                new properties(1.00, 4.40, 23.20, 1.55),
                new properties(2.00, 8.80, 27.40, 2.15),
                new properties(5.00, 13.20, 31.45, 2.35)};
        for (properties dataProperty : daten)
            if (this.getValue() == dataProperty.value)
                return dataProperty;
        return null;
    }

    @Override
    public final int compareTo(final PaymentMethod o) {
        return Double.compare(this.getValue(), o.getValue());
    }
}

