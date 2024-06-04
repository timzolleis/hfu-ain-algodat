package task6;

import lombok.Getter;

@Getter
public abstract class PaymentMethod implements Comparable<PaymentMethod> {
    private final String currency;
    private final double value;

    protected PaymentMethod(final String currency, final double value) {
        this.currency = currency;
        this.value = value;
    }

    public abstract boolean isValid();

    public final String toString() {
        return (value + " " + currency);
    }

}
