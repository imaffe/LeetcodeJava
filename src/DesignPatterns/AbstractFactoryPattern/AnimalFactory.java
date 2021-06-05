package DesignPatterns.AbstractFactoryPattern;

public class AnimalFactory implements AbstractFactory<Animal> {
    @Override
    public Animal create(String animalType) {
        if("ducks".equalsIgnoreCase(animalType)) {
            return new Duck();
        }

        return null;
    }
}
