public class SymStats {
    char[] simvoly;
    int[] schet;
    int vsego;
    public SymStats(char[] charsForStats) {
        simvoly = charsForStats;
        schet = new int[charsForStats.length];
        vsego = 0;
    }
    public void calculate(String s) {
        for (int i = 0; i < schet.length; i++) {
            schet[i] = 0;
        }
        vsego = 0;
        if (s == null) {
            return;
        }
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            for (int j = 0; j < simvoly.length; j++) {
                if (c == simvoly[j]) {
                    schet[j] = schet[j] + 1;
                    vsego = vsego + 1;
                }
            }
        }
    }
    public int countChar(char c) {
        for (int j = 0; j < simvoly.length; j++) {
            if (simvoly[j] == c) {
                return schet[j];
            }
        }
        return 0;
    }
    public int countTotal() {
        return vsego;
    }
    public void writeStats() {
        System.out.println("Result:");
        for (int j = 0; j < simvoly.length; j++) {
            if (schet[j] > 0) {
                System.out.println(simvoly[j] + " - " + schet[j]);
            }
        }
        System.out.println("Total vowels: " + vsego);
    }
}