package HexadecimalToArabic;

/**
 * @author Remigiusz Zudzin
 */
public class HexadecimalToArabic {

    public static int[] numberToIntTabConverter(String hexadecimalNumber) {
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

    public static boolean isHexadecimalNumberValid(String hexadecimalNumber) {
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

    public static boolean isConvertingCorrect(String hexadecimalNumber, int[] tab) {
        return numberToIntTabConverter(hexadecimalNumber).equals(tab);
    }

    public int convertHexadecimalToArabic(String hexadecimalNumber) {

        int arabicNumber = 0;
        int[] intTab = numberToIntTabConverter(hexadecimalNumber);

        for (int i = intTab.length - 1; i >= 0; i--) {
            arabicNumber += intTab[i]*(Math.pow(16, (intTab.length - 1) - i));
        }

        return arabicNumber;

    }
}
