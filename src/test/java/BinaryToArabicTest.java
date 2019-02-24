import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * @author Remigiusz Zudzin
 */
class BinaryToArabicTest {

    @ParameterizedTest
    @ValueSource(strings = {"1010","1111"})
    void isBinaryNumberCorrect(String number) {
        BinaryToArabic binaryToArabic = new BinaryToArabic();
        assertThat(binaryToArabic.isBinaryNumberValid(number)).isEqualTo(true);
    }

    @ParameterizedTest
    @ValueSource(strings = {"1234","78951"})
    void isBinaryNumberCorrectFail(String number) {
        BinaryToArabic binaryToArabic = new BinaryToArabic();
        assertThat(binaryToArabic.isBinaryNumberValid(number)).isEqualTo(false);
    }

    @ParameterizedTest
    @CsvSource({"1010, 10", "1111, 15", "101111, 47", "11111111, 255"})
    void isBinaryNumberConvertionCorrect(String binaryNumber, int arabicNumber) {
        BinaryToArabic binaryToArabic = new BinaryToArabic();
        Assertions.assertEquals(arabicNumber, binaryToArabic.convertBinaryToArabic(binaryNumber));
    }

}