package lambdastreams.baseoperations;

import java.util.*;
import java.util.function.BinaryOperator;
import java.util.stream.Collectors;

public class Numbers {
    private List<Integer> integers;

    public Numbers(List<Integer> integers) {
        this.integers = new ArrayList<>(integers);
    }

    public Optional<Integer> min() {
        return integers.stream().min(Comparator.comparingInt(x -> x));
    }

    public int sum() {
        return integers.stream().reduce(0, Integer::sum);
    }

    public Collection<Integer> getDistinctElements() {
        return integers.stream().collect(Collectors.toSet());
    }

    public boolean isAllPositive() {
        return integers.stream().allMatch(o -> o > 0);
    }
}
