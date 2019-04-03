package sebaszczen;

import org.assertj.core.internal.bytebuddy.implementation.FixedValue;
import org.springframework.cglib.proxy.Enhancer;
import org.springframework.cglib.proxy.InvocationHandler;
import sebaszczen.proxyWlasnyPrzyklad.Car;
import sebaszczen.proxyWlasnyPrzyklad.CarProxy;
import sebaszczen.proxyWlasnyPrzyklad.Tranport;

import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
//        CarProxy carProxy = new CarProxy();
//        Object proxyClass = Proxy.newProxyInstance(Car.class.getClassLoader(), new Class[]{Tranport.class}, carProxy);
//        Tranport proxyClass1 = (Tranport) proxyClass;
//        proxyClass1.speed();

        Enhancer enhancer = new Enhancer();
        enhancer.setSuperclass(Car.class);
        enhancer.setCallback(new InvocationHandler() {
            @Override
            public Object invoke(Object o, Method method, Object[] objects) throws Throwable {
                System.out.println("hello");
                if (method.getName().equalsIgnoreCase("numberOfPassengers")){
                    System.out.println("liczba pasazerow: "+method.invoke(new Car(), 10));
                }
                else {
                  method.invoke(new Car());
                }
                return 1111;
            }
        });
        Car car = (Car) enhancer.create();
        car.speed();
        car.numberOfPassengers(22);
    }

}
