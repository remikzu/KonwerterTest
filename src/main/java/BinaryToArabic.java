/**
 * @author Remigiusz Zudzin
 */
public class BinaryToArabic {

    int[] numberToTabConverter(String binaryNumber) {
        char[] tab = binaryNumber.toCharArray();
        int[] intTab = new int[tab.length];
        for (int i = 0; i < tab.length; i++) {
            intTab[i] = Character.getNumericValue(tab[i]);
        }
        return intTab;
    }

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

    public int convertBinaryToArabic(String binaryNumber) {

        int arabicNumber = 0;
        int[] intTab = numberToTabConverter(binaryNumber);

        for (int i = intTab.length - 1; i >= 0; i--) {
            arabicNumber += intTab[i]*(Math.pow(2, (intTab.length - 1) - i));
        }

        return arabicNumber;

    }
}
