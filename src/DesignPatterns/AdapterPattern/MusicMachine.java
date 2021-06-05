package DesignPatterns.AdapterPattern;

public class MusicMachine implements Machine {
    @Override
    public void work() {
        System.out.println("PlayingMusic: gua");
    }
}
