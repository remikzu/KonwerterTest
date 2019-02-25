package Enums;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author Remigiusz Zudzin
 */
public enum HexadecimalValues {
    A(10),
    a(10),
    B(11),
    b(11),
    C(12),
    c(12),
    D(13),
    d(12),
    E(14),
    e(14),
    F(15),
    f(15);

    private int value;

    HexadecimalValues(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }

    public static List<HexadecimalValues> getReverseSortedValues() {
        return Arrays.stream(values())
                .sorted(Comparator.comparing((HexadecimalValues e) -> e.value).reversed())
                .collect(Collectors.toList());
    }
}
