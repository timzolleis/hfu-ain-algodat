package task6;

public interface Bill {
    double getLength();

    double getWidth();

    class properties {
        final double value;
        final double length;
        final double width;

        properties(final double value, final double length, final double width) {
            this.value = value;
            this.length = length;
            this.width = width;
        }
    }


}
