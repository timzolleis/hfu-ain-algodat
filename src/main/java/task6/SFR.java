package task6;

public abstract class SFR extends PaymentMethod {
    protected SFR(final double value) {
        super("SFR", value);
    }

    public abstract boolean isValid();
}
