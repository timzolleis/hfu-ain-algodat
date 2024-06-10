package task6;

import java.util.Optional;

public class EUR_Bill extends EUR implements Bill {
    private final properties properties;

    public EUR_Bill(double wert) {
        super(wert);
        this.properties = select();
    }

    public final boolean isValid() {
        return properties != null;
    }

    public final double getLength() {
        return Optional.ofNullable(this.properties).map(p -> p.length).orElse(0.0);
    }

    public final double getWidth() {
        return Optional.ofNullable(this.properties).map(p -> p.width).orElse(0.0);
    }


    private properties select() {
        final properties[] data = {new properties(5, 120.00, 62.00),
                new properties(10, 127.00, 67.00),
                new properties(20, 133.00, 72.00),
                new properties(50, 140.00, 77.00),
                new properties(100, 147.00, 82.00),
                new properties(200, 153.00, 82.00),
                new properties(500, 160.00, 82.00)};
        for (properties dataProperty : data)
            if (this.getValue() == dataProperty.value)
                return dataProperty;
        return null;
    }

}
