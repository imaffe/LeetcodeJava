package DesignPatterns.AdapterPattern;

public class Sparrow implements  Bird {
    @Override
    public void makeSound() {
        System.out.println("Gua");
    }
}
