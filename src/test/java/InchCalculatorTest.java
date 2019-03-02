import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @author Remigiusz Zudzin
 */
class InchCalculatorTest {

    @ParameterizedTest
    @CsvSource({"5.0, 12.7", "1.0, 2.54"})
    void isConvertingInchToCmCorrect(double cmNumber, double inchNumber) {
        InchCalculator inchCalculator = new InchCalculator();
        Assertions.assertEquals(inchNumber, inchCalculator.convertInchToCm(cmNumber));
    }

    @ParameterizedTest
    @CsvSource({"1.0, 0.39", "5.0, 1.95 "})
    void isConvertingCmToInchCorrect(double cmNumber, double inchNumber) {
        InchCalculator inchCalculator = new InchCalculator();
        Assertions.assertEquals(inchNumber, inchCalculator.convertCmToInch(cmNumber));
    }

}