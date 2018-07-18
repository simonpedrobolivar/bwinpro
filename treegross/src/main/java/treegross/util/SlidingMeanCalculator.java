package treegross.util;

import java.util.LinkedList;
import java.util.function.Function;

public class SlidingMeanCalculator<E> {
    private final int windowSize;
    private final LinkedList<E> window = new LinkedList<>();

    public SlidingMeanCalculator(int windowSize) {
        super();
        this.windowSize = windowSize;
    }

    public void add(E o) {
        window.add(o);
        while (window.size() > windowSize) { window.remove(); }
    }
    
    public double meanOf(Function<E, Double> mapper) {
        return window.stream().map(mapper).reduce(0d, (sum, value) -> sum + value) / window.size();
    }
    
    public int windowSize() {
        return windowSize;
    }
}