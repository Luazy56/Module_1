import java.util.Scanner;
public class MainStats {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter text:");
        String s = sc.nextLine();
        char[] glas = {'а','е','ё','и','о','у','ы','э','ю','я',
                'А','Е','Ё','И','О','У','Ы','Э','Ю','Я'};
        SymStats st = new SymStats(glas);
        st.calculate(s);
        st.writeStats();
    }
}