package clases;

public class Range<T extends Comparable<? super T>> {
    private T low;
    private T high;

    public Range(T low, T high) {
        this.low = low;
        this.high = high;
    }

    public boolean contains(T o) {
        return (o.compareTo(low) >= 0 && o.compareTo(high) <= 0);
    }
}