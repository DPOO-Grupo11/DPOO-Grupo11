package clases;

import java.io.Serializable;

public class Range<T extends Comparable<? super T>> implements Serializable {
	private static final long serialVersionUID = -3579384219578136573L;
	/**
	 * 
	 */
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