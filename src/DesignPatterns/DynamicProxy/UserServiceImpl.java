package DesignPatterns.DynamicProxy;

public class UserServiceImpl implements UserService {
    @Override
    public void select() {
        System.out.println("Select byId");
    }

    @Override
    public void update() {
        System.out.println("Update byId");
    }
}
