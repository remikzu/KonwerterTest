import Enums.HexadecimalValues;
import Interfaces.BinaryInterface;
import Interfaces.HexadecimalInterface;
import Interfaces.RomanInterface;
import Enums.RomanNumeral;

import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author Remigiusz Zudzin
 */
public class Calculations implements HexadecimalInterface, BinaryInterface, RomanInterface {

    @Override
    public int[] numberToIntTabConverter(String hexadecimalNumber) {
        if (!isHexadecimalNumberValid(hexadecimalNumber)) {
            return null;
        }
        char[] charTab = hexadecimalNumber.toCharArray();
        int[] intTab = new int[charTab.length];

        for (int i = 0; i < charTab.length; i++) {
            if (charTab[i] == 'A') {
                intTab[i] = HexadecimalValues.A.getValue();
            } else if ( charTab[i] == 'B') {
                intTab[i] = HexadecimalValues.B.getValue();
            } else if ( charTab[i] == 'C') {
                intTab[i] = HexadecimalValues.C.getValue();
            } else if ( charTab[i] == 'D') {
                intTab[i] = HexadecimalValues.D.getValue();
            } else if ( charTab[i] == 'E') {
                intTab[i] = HexadecimalValues.E.getValue();
            } else if ( charTab[i] == '0') {
                intTab[i] = 0;
            } else if ( charTab[i] == '1') {
                intTab[i] = 1;
            } else if ( charTab[i] == '2') {
                intTab[i] = 2;
            } else if ( charTab[i] == '3') {
                intTab[i] = 3;
            } else if ( charTab[i] == '4') {
                intTab[i] = 4;
            } else if ( charTab[i] == '5') {
                intTab[i] = 5;
            } else if ( charTab[i] == '6') {
                intTab[i] = 6;
            } else if ( charTab[i] == '7') {
                intTab[i] = 7;
            } else if ( charTab[i] == '8') {
                intTab[i] = 8;
            } else if ( charTab[i] == '9') {
                intTab[i] = 9;
            }
        }
        return intTab;
    }

    @Override
    public boolean isHexadecimalNumberValid(String hexadecimalNumber) {
        boolean isCorrect = false;
        char[] tab = hexadecimalNumber.toCharArray();
        for (int i = 0; i < tab.length; i++) {
            if (tab[i] == '0' ||
                    tab[i] == '1' ||
                    tab[i] == '2' ||
                    tab[i] == '3' ||
                    tab[i] == '4' ||
                    tab[i] == '5' ||
                    tab[i] == '6' ||
                    tab[i] == '7' ||
                    tab[i] == '8' ||
                    tab[i] == '9' ||
                    tab[i] == 'A' ||
                    tab[i] == 'B' ||
                    tab[i] == 'C' ||
                    tab[i] == 'D' ||
                    tab[i] == 'E' ||
                    tab[i] == 'F') {
                isCorrect = true;
            } else {
                isCorrect = false;
                break;
            }
        }
        return isCorrect;
    }

    @Override
    public int convertHexadecimalToArabic(String hexadecimalNumber) {
        if (!isHexadecimalNumberValid(hexadecimalNumber))
            throw new IllegalArgumentException("Zły format liczby w formacie 16-tkowym!");
        int arabicNumber = 0;
        int[] intTab = numberToIntTabConverter(hexadecimalNumber);
        for (int i = intTab.length - 1; i >= 0; i--) {
            arabicNumber += intTab[i]*(Math.pow(16, (intTab.length - 1) - i));
        }
        return arabicNumber;
    }

    @Override
    public int[] numberToTabConverter(String binaryNumber) {
        char[] tab = binaryNumber.toCharArray();
        int[] intTab = new int[tab.length];
        for (int i = 0; i < tab.length; i++) {
            intTab[i] = Character.getNumericValue(tab[i]);
        }
        return intTab;
    }

    @Override
    public boolean isBinaryNumberValid(String number) {
        boolean isCorrect = false;
        int[] intTab = numberToTabConverter(number);
        for (int i = 0; i < intTab.length; i++) {
            if (intTab[i] == 0 || intTab[i] == 1) {
                isCorrect = true;
            } else {
                isCorrect = false;
                break;
            }
        }
        return isCorrect;
    }

    @Override
    public int convertBinaryToArabic(String binaryNumber) {
        if (!isHexadecimalNumberValid(binaryNumber))
            throw new IllegalArgumentException("Zły format liczby w formacie 16-tkowym!");
        int arabicNumber = 0;
        int[] intTab = numberToTabConverter(binaryNumber);

        for (int i = intTab.length - 1; i >= 0; i--) {
            arabicNumber += intTab[i]*(Math.pow(2, (intTab.length - 1) - i));
        }

        return arabicNumber;

    }

    @Override
    public Integer sumRomanNumbers(String romanNumber) {
        Integer result = 0;
        char[] numberTab = romanNumber.toCharArray();
        for (int i = 0; i < numberTab.length; i++) {
            if (numberTab[i] == 'I') result += RomanNumeral.I.getValue();
            else if (numberTab[i] == 'V') result += RomanNumeral.V.getValue();
            else if (numberTab[i] == 'X') result += RomanNumeral.X.getValue();
            else if (numberTab[i] == 'L') result += RomanNumeral.L.getValue();
            else if (numberTab[i] == 'C') result += RomanNumeral.C.getValue();
            else if (numberTab[i] == 'D') result += RomanNumeral.D.getValue();
            else if (numberTab[i] == 'M') result += RomanNumeral.M.getValue();
        }
        return result;
    }

    @Override
    public Integer convertRomanToArabic(String romanNumber) {
        if (!isRomanNumberValid(romanNumber)) throw new IllegalArgumentException("Zły format liczby Romańskiej!");
        String romanNumeral = romanNumber;
        int result = 0;
        //sortowanie w kolejnosci malejacej
        List<RomanNumeral> listOfRomanNumerals = RomanNumeral.getReverseSortedValues();

        int i = 0;
        while ((romanNumeral.length() > 0) && (i < listOfRomanNumerals.size())) {
            RomanNumeral symbol = listOfRomanNumerals.get(i);
            if (romanNumeral.startsWith(symbol.name())) {
                result += symbol.getValue();
                romanNumeral = romanNumeral.substring(symbol.name().length());
            } else {
                i++;
            }
        }

        return result;
    }

    @Override
    public boolean isSumNumberValid(String number, Integer sumNumber) {
        return sumRomanNumbers(number).equals(sumNumber);
    }

    @Override
    public boolean isValid(String val) {
        Pattern pattern = Pattern.compile("[IVXLMCD]");
        Matcher matcher = pattern.matcher(val);
        return matcher.matches();
    }

    @Override
    public boolean isRomanNumberValid(String number) {
        String romanRegex = "^M{0,4}(CM|CD|D?C{0,3})(XC|XL|L?X{0,3})(IX|IV|V?I{0,3})$";
        return number.matches(romanRegex);
    }

    @Override
    public boolean isConvertionCorrect(String romanNumber, Integer arabicNumber) {
        return convertRomanToArabic(romanNumber).equals(arabicNumber);
    }
}