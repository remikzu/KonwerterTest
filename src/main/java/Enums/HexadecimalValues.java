package Enums;

/**
 * @author Remigiusz Zudzin
 */
public enum HexadecimalValues {
    A(10),
    B(11),
    C(12),
    D(13),
    E(14),
    F(15);

    private int value;

    HexadecimalValues(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }}
