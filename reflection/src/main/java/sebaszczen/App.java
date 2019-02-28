package sebaszczen;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * Hello world!
 */
public class App {
    public static void main(String[] args) throws NoSuchMethodException, InvocationTargetException, IllegalAccessException, NoSuchFieldException {
        Person person = new Person("pawel");
        Class aClass = person.getClass();
        System.out.println("nazwa: " + aClass.getName());
        try {
            System.out.println("konstruktor: " + aClass.getConstructor(String.class).getName());
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        }
        System.out.println("-----------------");
        Method[] declaredMethods = aClass.getDeclaredMethods();
        System.out.println("metody obiektu: ");
        for (Method method : declaredMethods) {
            System.out.println(method);
        }
        System.out.println("-----------------");
        Method[] methods = aClass.getMethods();
        System.out.println("metody obiektu: ");
        for (Method method : methods) {
            System.out.println(method);
        }
        System.out.println("-----------------");

        Method saySth = aClass.getDeclaredMethod("saySth", String.class);
        saySth.setAccessible(true);
        saySth.invoke(person, "witamm");

        Field name = aClass.getDeclaredField("name");
        name.setAccessible(true);
        name.set(person,"jamnik");
        System.out.println(person.getName());
        System.out.println("-----------------");
        Method showMessage = aClass.getDeclaredMethod("showMessage");
        System.out.println(showMessage.isAccessible());
        showMessage.setAccessible(true);
        System.out.println(showMessage.isAccessible());
        System.out.println("-----------------");
    }
}
