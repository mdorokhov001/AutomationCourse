package lesson8;

public class Test {
    public static void main(String[] args) {
        Guitar guitar = new Guitar();
        Piano piano = new Piano();

        guitar.play(Instruments.StringCount.GUITAR.getStrings());
        piano.play(Instruments.StringCount.PIANO.getStrings());
    }
}
