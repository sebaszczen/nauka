package sebaszczen;

public class Person {
    private String name;

    public Person(String name) {
        this.name = name;
    }

    private void saySth(String word) {
        System.out.println(word);
    }

    public String getName() {
        return name;
    }

    private void showMessage() {
        System.out.println("metoda prywatna złamana, jestemy zgubieni");
    }
}
