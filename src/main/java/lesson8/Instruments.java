package lesson8;

public class Instruments {
    public enum StringCount{
        GUITAR(6),
        PIANO(0);

        private final int strings;

        StringCount(int strings){
            this.strings = strings;
        }

        public int getStrings(){
            return strings;
        }
    }
}
