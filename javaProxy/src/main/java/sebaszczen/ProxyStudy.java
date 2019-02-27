package sebaszczen;

import com.sun.java.browser.net.ProxyServiceProvider;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class ProxyStudy {

    interface Car{
        public void drive();
    }

    interface Engine{
        public void startEngine();
    }

    public static class Audi implements Car,Engine{

        @Override
        public void drive() {
            System.out.println("jedzie audi");
        }

        @Override
        public void startEngine() {
            System.out.println("silnik uruchomiony");
        }
    }

    public static class Proxy implements InvocationHandler{

        private Car car;
        private Engine engine;

        public Proxy(Car car, Engine engine) {
            this.car = car;
            this.engine = engine;
        }

        @Override
        public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
//            for (Object arg : args) {
//                System.out.println("argument: "+arg);
//            }
            System.out.println("start");
            method.invoke(engine);
            method.invoke(car);
            System.out.println("finish");
            return null;
        }
    }

    public static void main(String[] args) {
        Audi audi = new Audi();
        Car car = new Audi();
        Engine engine = new Audi();
        Proxy proxy = new Proxy(car, engine);
        Object o =  java.lang.reflect.Proxy.newProxyInstance(Proxy.class.getClassLoader(), new Class[]{Engine.class,Car.class}, proxy);
        Engine o1 = (Engine) o;
        o1.startEngine();
    }
}
