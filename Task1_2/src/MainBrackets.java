import java.util.Scanner;
public class MainBrackets {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Введите текст со скобками:");
        String s = sc.nextLine();
        BracketsValidator validator = new BracketsValidator();
        boolean result = validator.isValid(s);
        if (result) {
            System.out.println("Скобки сбалансированы.");
        } else {
            System.out.println("ОШИБКА на позиции " + validator.getErrorPos() + ": " + validator.getErrorMessage());
        }
    }
}