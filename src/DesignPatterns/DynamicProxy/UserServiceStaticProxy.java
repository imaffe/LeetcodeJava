package DesignPatterns.DynamicProxy;

public class UserServiceStaticProxy implements UserService {
    private UserService target;

    public UserServiceStaticProxy(UserService target) {
        this.target = target;
    }

    @Override
    public void select() {
        before();
        target.select();
        after();
    }

    @Override
    public void update() {
        before();
        target.update();
        after();
    }

    private void before() {
        System.out.println("log start time");
    }
    private void after() {
        System.out.println("log finish time");
    }
}
