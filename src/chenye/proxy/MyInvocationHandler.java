package chenye.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

public class MyInvocationHandler implements InvocationHandler {
    private final Object target;

    public MyInvocationHandler(Object target){
        this.target = target;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("do something before invoke the underlying method");
        Object ret = method.invoke(target, args);
        System.out.println("do something after invoke the underlying method");
        return ret;
    }
}
