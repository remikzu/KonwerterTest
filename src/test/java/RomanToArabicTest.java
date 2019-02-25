import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.*;

/**
 * @author Remigiusz Zudzin
 */
class RomanToArabicTest {

    @ParameterizedTest
    @CsvSource({"IVXM, 1016", "MMMCCCM, 4300"})
    void sumTest(String number, Integer sumNumber) {
        Calculations romanToArabic = new Calculations();
        assertThat(romanToArabic.isSumNumberValid(number, sumNumber)).isEqualTo(true);
    }

    @ParameterizedTest(name = "run #{index} with [{arguments}]")
    @CsvSource ({"I","V","X","L","C","D","M"})
    void isValidTest(String val){
        Calculations romanToArabic = new Calculations();
        Assertions.assertTrue (romanToArabic.isValid(val));
    }

    @ParameterizedTest(name = "run #{index} with [{arguments}]")
    @CsvSource ({"A","B","E","F","G","H","J","K","N","O","P","R","S","T","U","W","Y","Z"})
    void isValidTestFail(String val){
        Calculations romanToArabic = new Calculations();
        Assertions.assertFalse (romanToArabic.isValid(val));
    }

    @ParameterizedTest
    @ValueSource(strings = {"MXVI", "MMMCC"})
    void isRomanNumberInCorrectOrder(String number){
        Calculations romanToArabic = new Calculations();
        assertThat(romanToArabic
                .isRomanNumberValid(number))
                .isEqualTo(true);
    }

    @ParameterizedTest
    @ValueSource(strings = {"IVXM", "VVV"})
    void isRomanNumberInCorrectOrderFail(String number){
        Calculations romanToArabic = new Calculations();
        assertThat(romanToArabic
                .isRomanNumberValid(number))
                .isEqualTo(false);
    }

    @ParameterizedTest
    @CsvSource({"MXVI, 1016", "MMM, 3000"})
    void isConvertionCorrect(String romanNumber, Integer arabicNumber) {
        Calculations romanToArabic = new Calculations();
        assertThat(romanToArabic
                .isConvertionCorrect(romanNumber, arabicNumber))
                .isEqualTo(true);
    }

    @ParameterizedTest
    @CsvSource({"MXVI, 1610", "MMM, 300"})
    void isConvertionCorrectFail(String romanNumber, Integer arabicNumber) {
        Calculations romanToArabic = new Calculations();
        assertThat(romanToArabic
                .isConvertionCorrect(romanNumber, arabicNumber))
                .isEqualTo(false);
    }
}