package Interfaces;

/**
 * @author Remigiusz Zudzin
 */
public interface HexadecimalInterface {

    public int[] numberToIntTabConverter(String hexadecimalNumber);
    public boolean isHexadecimalNumberValid(String hexadecimalNumber);
    public int convertHexadecimalToArabic(String hexadecimalNumber);

}
