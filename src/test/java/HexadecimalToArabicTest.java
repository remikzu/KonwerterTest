import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * @author Remigiusz Zudzin
 */
class HexadecimalToArabicTest {

    @ParameterizedTest
    @ValueSource(strings = {"3E8","4B42"})
    void isHexadecimalNumberCorrect(String number) {
        Calculations hexadecimalToArabic = new Calculations();
        assertThat(hexadecimalToArabic.isHexadecimalNumberValid(number)).isEqualTo(true);
    }

    @ParameterizedTest
    @ValueSource(strings = {"3G12","6U7"})
    void isHexadecimalNumberCorrectFail(String number) {
        Calculations hexadecimalToArabic = new Calculations();
        assertThat(hexadecimalToArabic.isHexadecimalNumberValid(number)).isEqualTo(false);
    }

    @ParameterizedTest
    @CsvSource({"98BA94, 10009236", "3E8, 1000", "1D62D, 120365", "93C501, 9684225"})
    void isBinaryNumberConvertionCorrect(String hexadecimalNumber, int arabicNumber) {
        Calculations hexadecimalToArabic = new Calculations();
        Assertions.assertEquals(arabicNumber, hexadecimalToArabic.convertHexadecimalToArabic(hexadecimalNumber));
    }

}