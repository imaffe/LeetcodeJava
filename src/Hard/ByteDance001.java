package Hard;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class ByteDance001 implements InvocationHandler {
    Object target;

    public Object createProxyInstance() {
        return Proxy.newProxyInstance(target.getClass().getClassLoader(),target.getClass().getInterfaces(),this);
    }

    @Override
    public Object invoke(Object obj, Method method, Object[] args) throws Throwable{
        Object result = null;
        result = method.invoke(target, args);
        return result;
    }
}
