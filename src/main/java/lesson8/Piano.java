package lesson8;

public class Piano implements Playable{
    @Override
    public void play(int strings) {
        System.out.println("У пианино " + strings + " струн.");
    }
}
