package Interfaces;

/**
 * @author Remigiusz Zudzin
 */
public interface HexadecimalInterface {

    public long[] numberToIntTabConverter(String hexadecimalNumber);
    public boolean isHexadecimalNumberValid(String hexadecimalNumber);
    public long convertHexadecimalToArabic(String hexadecimalNumber);

}
