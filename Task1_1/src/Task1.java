import java.util.Scanner;
public class Task1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter text:");
        String s = sc.nextLine();
        char[] glas = {'а','е','ё','и','о','у','ы','э','ю','я',
                'А','Е','Ё','И','О','У','Ы','Э','Ю','Я'};
        int[] schet = new int[glas.length];
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            for (int j = 0; j < glas.length; j++) {
                if (c == glas[j]) {
                    schet[j] = schet[j] + 1;
                }
            }
        }
        System.out.println("Result:");
        int vsego = 0;
        for (int j = 0; j < glas.length; j++) {
            if (schet[j] > 0) {
                System.out.println(glas[j] + " - " + schet[j]);
                vsego = vsego + schet[j];
            }
        }
        System.out.println("Total Vowels: " + vsego);
    }
}