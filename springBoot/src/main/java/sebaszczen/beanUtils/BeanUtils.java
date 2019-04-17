package sebaszczen.beanUtils;

public class BeanUtils {

    public static void main(String[] args) {
        Mouse mouse = new Mouse("mysz 1");
        Cat cat = new Cat(mouse, "cat1");
        Cat2 cat2 = new Cat2();
        org.springframework.beans.BeanUtils.copyProperties(cat,cat2);
        System.out.println(cat2);
    }
}
