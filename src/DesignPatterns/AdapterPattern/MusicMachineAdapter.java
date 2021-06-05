package DesignPatterns.AdapterPattern;

public class MusicMachineAdapter implements Bird {
    MusicMachine musicMachine;

    public MusicMachineAdapter(MusicMachine musicMachine) {
        this.musicMachine = musicMachine;
    }
    @Override
    public void makeSound() {
        musicMachine.work();
    }
}
