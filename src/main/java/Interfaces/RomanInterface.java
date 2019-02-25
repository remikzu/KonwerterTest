package Interfaces;

/**
 * @author Remigiusz Zudzin
 */
public interface RomanInterface {

    Integer sumRomanNumbers(String romanNumber);
    Integer convertRomanToArabic(String romanNumber);
    public boolean isSumNumberValid(String number, Integer sumNumber);
    public boolean isValid(String val);
    public boolean isRomanNumberValid(String number);
    public boolean isConvertionCorrect(String romanNumber, Integer arabicNumber);
}
