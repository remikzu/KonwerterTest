import RomanNumbersExercise.RomanNumbers;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.*;

/**
 * @author Remigiusz Zudzin
 */
class RomanNumbersTest {

    @ParameterizedTest
    @CsvSource({"IVXM, 1016", "MMMCCCM, 4300"})
    void sumTest(String number, Integer sumNumber) {
        RomanNumbers romanNumbers = new RomanNumbers();
        assertThat(romanNumbers.isSumNumberValid(number, sumNumber)).isEqualTo(true);
    }

    @ParameterizedTest(name = "run #{index} with [{arguments}]")
    @CsvSource ({"I","V","X","L","C","D","M"})
    void isValidTest(String val){
        Assertions.assertTrue (RomanNumbers.isValid(val));
    }

    @ParameterizedTest(name = "run #{index} with [{arguments}]")
    @CsvSource ({"A","B","E","F","G","H","J","K","N","O","P","R","S","T","U","W","Y","Z"})
    void isValidTestFail(String val){
        Assertions.assertFalse (RomanNumbers.isValid(val));
    }

    @ParameterizedTest
    @ValueSource(strings = {"MXVI", "MMMCC"})
    void isRomanNumberInCorrectOrder(String number){
        RomanNumbers romanNumbers = new RomanNumbers();
        assertThat(romanNumbers
                .isRomanNumberValid(number))
                .isEqualTo(true);
    }

    @ParameterizedTest
    @ValueSource(strings = {"IVXM", "VVV"})
    void isRomanNumberInCorrectOrderFail(String number){
        RomanNumbers romanNumbers = new RomanNumbers();
        assertThat(romanNumbers
                .isRomanNumberValid(number))
                .isEqualTo(false);
    }
}