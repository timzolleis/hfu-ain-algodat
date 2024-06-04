package task6;

public abstract class USD extends PaymentMethod {
    protected USD(final double value) {
        super("USD", value);
    }

    public abstract boolean isValid();
}
