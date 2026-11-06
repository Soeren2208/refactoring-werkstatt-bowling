package logik;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

// Abnahmetest zur Bowling-Kata.
@DisplayName("Abnahmetest Bowling")
public class BowlingAcceptanceTest {

    private Bowling game;

    @BeforeEach
    public void setUp() {
        game = new Bowling();
    }

    private void rollMany(int times, int pins) {
        for (int i = 0; i < times; i++) {
            game.roll(pins);
        }
    }

    private void roll(int... pins) {
        for (int p : pins) {
            game.roll(p);
        }
    }

    @Test
    @DisplayName("20 x 0 -> 0 (Gutter Game)")
    void givenGutterGame_whenScore_thenReturn0() {
        rollMany(20, 0);
        assertEquals(0, game.score());
    }

    @Test
    @DisplayName("20 x 1 -> 20 (nur Open Frames)")
    void givenAllOnes_whenScore_thenReturn20() {
        rollMany(20, 1);
        assertEquals(20, game.score());
    }

    @Test
    @DisplayName("5, 5, 3, dann 17 x 0 -> 16 (ein Spare)")
    void givenOneSpare_whenScore_thenReturn16() {
        roll(5, 5, 3);
        rollMany(17, 0);
        assertEquals(16, game.score());
    }

    @Test
    @DisplayName("10, 3, 4, dann 16 x 0 -> 24 (ein Strike)")
    void givenOneStrike_whenScore_thenReturn24() {
        roll(10, 3, 4);
        rollMany(16, 0);
        assertEquals(24, game.score());
    }

    @Test
    @DisplayName("12 x 10 -> 300 (Perfect Game)")
    void givenPerfectGame_whenScore_thenReturn300() {
        rollMany(12, 10);
        assertEquals(300, game.score());
    }

    @Test
    @DisplayName("21 x 5 -> 150 (nur Spares, Bonuswurf im 10. Frame)")
    void givenAllSpares_whenScore_thenReturn150() {
        rollMany(21, 5);
        assertEquals(150, game.score());
    }

    @Test
    @DisplayName("18 x 0, dann 5, 5, 5 -> 15 (Spare im 10. Frame)")
    void givenSpareInTenthFrame_whenScore_thenReturn15() {
        rollMany(18, 0);
        roll(5, 5, 5);
        assertEquals(15, game.score());
    }

    @Test
    @DisplayName("18 x 0, dann 10, 10, 10 -> 30 (Strikes im 10. Frame)")
    void givenStrikesInTenthFrame_whenScore_thenReturn30() {
        rollMany(18, 0);
        roll(10, 10, 10);
        assertEquals(30, game.score());
    }

    @Test
    @DisplayName("3, 5, 5, 2, dann 16 x 0 -> 15 (kein Spare ueber eine Framegrenze hinweg)")
    void givenTenPinsAcrossTwoFrames_whenScore_thenNoSpareBonus() {
        roll(3, 5, 5, 2);
        rollMany(16, 0);
        assertEquals(15, game.score());
    }

    @Test
    @DisplayName("0, 10, 5, 3, dann 16 x 0 -> 23 (0 und 10 sind ein Spare, kein Strike)")
    void givenZeroThenTen_whenScore_thenCountAsSpare() {
        roll(0, 10, 5, 3);
        rollMany(16, 0);
        assertEquals(23, game.score());
    }

    @Test
    @DisplayName("10, 10, 3, 4, dann 14 x 0 -> 47 (zwei Strikes hintereinander)")
    void givenTwoStrikesInARow_whenScore_thenReturn47() {
        roll(10, 10, 3, 4);
        rollMany(14, 0);
        assertEquals(47, game.score());
    }

    @Test
    @DisplayName("Beispielspiel vom Arbeitsblatt -> 154")
    void givenExampleGameFromWorksheet_whenScore_thenReturn154() {
        roll(10, 3, 7, 8, 0, 7, 2, 10, 10, 9, 0, 6, 4, 4, 5, 10, 7, 2);
        assertEquals(154, game.score());
    }
}
