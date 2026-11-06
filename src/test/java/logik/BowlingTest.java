package logik;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

class BowlingTest {

    @Test
    void test1() {
        Bowling b = new Bowling();
        for (int i = 0; i < 20; i++) {
            b.roll(0);
        }
        assertThat(b.score()).isEqualTo(0);
    }

    @Test
    void test2() {
        Bowling b = new Bowling();
        for (int i = 0; i < 20; i++) {
            b.roll(1);
        }
        assertThat(b.score()).isEqualTo(20);
    }

    @Test
    void test3() {
        Bowling b = new Bowling();
        b.roll(5);
        b.roll(5); // Spare
        b.roll(3);
        for (int i = 0; i < 17; i++) {
            b.roll(0);
        }
        assertThat(b.score()).isEqualTo(16);
    }

    @Test
    void test4() {
        Bowling b = new Bowling();
        b.roll(10); // Strike
        b.roll(3);
        b.roll(4);
        for (int i = 0; i < 16; i++) {
            b.roll(0);
        }
        assertThat(b.score()).isEqualTo(24);
    }

    @Test
    void test5() {
        Bowling b = new Bowling();
        for (int i = 0; i < 12; i++) {
            b.roll(10);
        }
        assertThat(b.score()).isEqualTo(300);
    }
}
