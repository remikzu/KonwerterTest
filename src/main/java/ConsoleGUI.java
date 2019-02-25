import java.util.Scanner;

/**
 * @author Remigiusz Zudzin
 */
public class ConsoleGUI {

    public void showTitle() {
        System.out.println("Konwerter v1.0");
        System.out.println("----------------------");
    }

    public void showMenu() {
        System.out.println("Wybierz co chcesz zrobić:");
        System.out.println("1. Konwersja Rzymskie -> Arabskie");
        System.out.println("2. Konwersja Binarne -> Arabskie");
        System.out.println("3. Konwersja 16-tkowe -> Arabskie");
        System.out.println("4. Wyjście z programu");
    }

    private Scanner sc = new Scanner(System.in);
    private Calculations calculate = new Calculations();

    public void calculate() {
        showTitle();
        while(true) {
            showMenu();
            int choice = sc.nextInt();
            switch (choice) {
                case 1: {
                    System.out.println("Podaj liczbę Rzymską:");
                    String word = sc.next();
                    System.out.println(calculate.convertRomanToArabic(word));
                }
                break;
                case 2: {
                    System.out.println("Podaj liczbę Binarną:");
                    String word = sc.next();
                    System.out.println(calculate.convertBinaryToArabic(word));
                }
                break;
                case 3: {
                    System.out.println("Podaj liczbę w formacie 16-tkowym:");
                    String word = sc.next();
                    System.out.println(calculate.convertHexadecimalToArabic(word));
                }
                break;
                case 4: {
                    System.out.println("Wychodzę z programu!");
                    System.exit(0);
                }
                break;
            }
        }

    }

}
