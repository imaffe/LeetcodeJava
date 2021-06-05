package DesignPatterns.SingletonPattern;

public class SingletonDemo {
    private static SingletonDemo instance;
    private SingletonDemo(){};

    public static SingletonDemo getInstance() {
        if(instance == null) {
            synchronized (SingletonDemo.class) {
                if(instance == null) {
                    instance = new SingletonDemo();
                }
            }
        }
        return instance;
    }

    public void showMessage(){
        System.out.println("Hello World");
    }

}
