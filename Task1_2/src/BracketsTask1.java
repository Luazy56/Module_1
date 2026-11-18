import java.util.Scanner;
public class BracketsTask1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Введите текст со скобками:");
        String s = sc.nextLine();
        char[] stack = new char[s.length()];
        int top = 0;
        int errorPos = -1;
        String errorMsg = "";
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == '(' || c == '{' || c == '[' || c == '<') {
                stack[top] = c;
                top++;
            }
            else if (c == ')' || c == '}' || c == ']' || c == '>') {
                if (top == 0) {
                    errorPos = i;
                    errorMsg = "Лишняя закрывающая скобка: " + c;
                    break;
                }
                top--;
                char lastOpen = stack[top];
                boolean isMatch = false;
                if (lastOpen == '(' && c == ')') isMatch = true;
                if (lastOpen == '{' && c == '}') isMatch = true;
                if (lastOpen == '[' && c == ']') isMatch = true;
                if (lastOpen == '<' && c == '>') isMatch = true;
                if (!isMatch) {
                    errorPos = i;
                    errorMsg = "Несовпадение скобок: ожидалось закрытие для " + lastOpen + ", а встретилось " + c;
                    break;
                }
            }
        }
        if (errorPos == -1 && top > 0) {
            errorMsg = "Не хватает закрывающих скобок. Открыта и не закрыта: " + stack[top - 1];
            errorPos = s.length();
        }
        if (errorPos == -1) {
            System.out.println("Скобки сбалансированы.");
        } else {
            System.out.println("ОШИБКА на позиции " + errorPos + ": " + errorMsg);
        }
    }
}