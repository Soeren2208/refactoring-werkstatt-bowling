package logik;

public class Bowling {

    int[] r = new int[21];
    int c = 0;

    public void roll(int p) {
        r[c] = p;
        c++;
    }

    // berechnet die Punkte
    public int score() {
        int s = 0;
        int i = 0;
        for (int f = 0; f < 10; f++) {
            // Strike
            if (r[i] == 10) {
                s = s + 10 + r[i + 1] + r[i + 2];
                i = i + 1;
            } else {
                // Spare
                if (r[i] + r[i + 1] == 10) {
                    s = s + 10 + r[i + 2];
                    i = i + 2;
                } else {
                    // normaler Frame
                    s = s + r[i] + r[i + 1];
                    i = i + 2;
                }
            }
        }
        // System.out.println("Punkte: " + s);
        return s;
    }
}
