package sebaszczen.proxyWlasnyPrzyklad;


import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

public class CarProxy implements InvocationHandler {

//    private Car car;
//
//    public CarProxy(Car car) {
//        this.car = car;
//    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("invoke method --- called");
        System.out.println("invoking method name: "+method.getName());
        method.invoke(new Car());
//        method.invoke(car,args);
//        method.invoke(car,args);
        return null;
    }
}
