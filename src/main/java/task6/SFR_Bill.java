package task6;

import java.util.Optional;

public class SFR_Bill extends SFR implements Bill {
    private final properties properties;

    public SFR_Bill(double wert) {
        super(wert);
        this.properties = select();
    }

    public final boolean isValid() {
        return this.properties != null;
    }

    public final double getLength() {
        return Optional.ofNullable(this.properties).map(p -> p.length).orElse(0.0);
    }

    public final double getWidth() {
        return Optional.ofNullable(this.properties).map(p -> p.width).orElse(0.0);
    }


    private properties select() {
        final properties[] data = {new properties(10, 74.00, 126.00),
                new properties(20, 74.00, 137.00),
                new properties(50, 74.00, 148.00),
                new properties(100, 74.00, 159.00),
                new properties(200, 74.00, 170.00),
                new properties(1000, 74.00, 181.00)};
        for (properties dataProperty : data)
            if (getValue() == dataProperty.value)
                return dataProperty;
        return null;
    }
}

