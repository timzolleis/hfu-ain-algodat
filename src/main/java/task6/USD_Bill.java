package task6;

import java.util.Optional;

public class USD_Bill extends USD implements Bill {
    private final properties properties;

    public USD_Bill(double wert) {
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
        final properties[] data = {new properties(1, 155.81, 66.42),
                new properties(2, 155.81, 66.42),
                new properties(5, 155.81, 66.42),
                new properties(10, 155.81, 66.42),
                new properties(20, 155.81, 66.42),
                new properties(50, 155.81, 66.42),
                new properties(100, 155.81, 66.42)};
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
