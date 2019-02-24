package RomanNumbersExercise;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author Remigiusz Zudzin
 */
public class RomanNumbers {

    Integer convertNumbers(String romanNumbers) {
        Integer sum = 0;
        char[] numberTab = romanNumbers.toCharArray();
        for (int i = 0; i < numberTab.length; i++) {
            if (numberTab[i] == 'I') sum += 1;
            else if (numberTab[i] == 'V') sum += 5;
            else if (numberTab[i] == 'X') sum += 10;
            else if (numberTab[i] == 'L') sum += 50;
            else if (numberTab[i] == 'C') sum += 100;
            else if (numberTab[i] == 'D') sum += 500;
            else if (numberTab[i] == 'M') sum += 1000;


        }
        return sum;
    }

//    Zasady dla zadania:
//Do zapisu liczby używamy co najwyżej trzech takich samych symboli spośród: I, X, C, M.
//
//Obok siebie nie możemy umieścić dwóch takich samych symboli spośród: V, L, D.
//
//Jeżeli symbole występują w kolejności malejącej, to wartości odpowiadające tym symbolom dodajemy.
//
//Jeżeli przed symbolem oznaczającym większą wartość, występuje symbol oznaczający mniejszą wartość,
// to od większej wartości odejmujemy mniejszą,

    Integer convertCorrectRomanNumbers (String romanNumbers) {
        if (!isRomanNumberValid(romanNumbers)) {
            return null;
        }
        else {
            Integer sum = 0;
            char[] numberTab = romanNumbers.toCharArray();
            return sum;
        }
    }



    public boolean isSumNumberValid(String number, Integer sumNumber) {
        return convertNumbers(number).equals(sumNumber);
    }

    public static boolean isValid(String val) {
        Pattern pattern = Pattern.compile("[IVXLMCD]");
        Matcher matcher = pattern.matcher(val);
        return matcher.matches();
    }

    public boolean isRomanNumberValid(String number) {
        String romanRegex = "^M{0,4}(CM|CD|D?C{0,3})(XC|XL|L?X{0,3})(IX|IV|V?I{0,3})$";
        return number.matches(romanRegex);
    }

/*    public boolean isValid2(String number) {
        boolean isCorrect = true;
        char[] numberTab = number.toCharArray();
        for (int i = 0; i < numberTab.length; i++) {
            if (numberTab[i] == 'I' ||
                numberTab[i] == 'V' ||
                numberTab[i] == 'X' ||
                numberTab[i] == 'L' ||
                numberTab[i] == 'C' ||
                numberTab[i] == 'D' ||
                numberTab[i] == 'M') {
                isCorrect = true;
            } else isCorrect = false;
        }
        return isCorrect;
    }*/
}
