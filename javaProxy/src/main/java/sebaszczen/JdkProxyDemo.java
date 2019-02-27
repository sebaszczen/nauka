package sebaszczen;


import java.lang.reflect.InvocationHandler;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
public class JdkProxyDemo {
    interface If {
        void originalMethod(String s);
    }
    static class Original implements If {
        private String name = "ania";

        public Original(String name) {
            this.name = name;
        }

        public Original() {

        }

        public void originalMethod(String s) {
            System.out.println(s+" "+name);
        }

    }

    interface Woman{
        public void sayHi();
    }

    static class Man implements Woman{
        private String name;

        public Man(String name) {
            this.name = name;
        }

        public void printName() {
            System.out.println("name");
        }

        @Override
        public void sayHi() {
            System.out.println("hi");
        }
    }

    static class Handler implements InvocationHandler {
        private final If original;
        private final Man man;
        public Handler(If original, Man man) {
            this.original = original;
            this.man = man;
        }
        public Object invoke(Object proxy, Method method, Object[] args)
                throws IllegalAccessException, IllegalArgumentException,
                InvocationTargetException {
            System.out.println("BEFORE");
//            for (Object arg : args) {
//                System.out.println("argument "+ arg);
//            }
            method.invoke(man);
//            method.invoke(new Original("xxx"), "Sdf");
            System.out.println("AFTER");
            return null;
        }
    }
    public static void main(String[] args){
//        System.out.println("tutaj");
        Original original = new Original();
        Man man = new Man("seba");
        Handler handler = new Handler(original, man);
//        If f = (If) ProxyStudy.newProxyInstance(If.class.getClassLoader(),
//                new Class[] { If.class },
//                handler);
//        f.originalMethod("Hallo");


        Woman o = (Woman) Proxy.newProxyInstance(Man.class.getClassLoader(), new Class[]{Woman.class}, handler);
        o.sayHi();
    }
}
