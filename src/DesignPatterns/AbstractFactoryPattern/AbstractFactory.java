package DesignPatterns.AbstractFactoryPattern;

public interface AbstractFactory<T> {
    T create(String someType);
}
