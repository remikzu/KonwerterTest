/**
 * @author Remigiusz Zudzin
 */
public class InchCalculator {
    public double convertInchToCm(double inchNumber) {
        double result = inchNumber*2.54;
        Math.round(result);
        return result;
    }

    public double convertCmToInch(double cmNumber) {
        double result = cmNumber*0.39;
        Math.round(result);
        return result;
    }
}
