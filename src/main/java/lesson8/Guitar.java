package lesson8;

public class Guitar implements Playable{
    @Override
    public void play(int strings) {
        System.out.println("У гитары " + strings + " струн.");
    }
}
