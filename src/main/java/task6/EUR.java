package task6;

public abstract class EUR extends PaymentMethod {
    public EUR(final double value) {
        super("EUR", value);
    }

    public abstract boolean isValid();

}

