package sebaszczen.builderPattern;

public class Shop {
    public static void main(String[] args) {
        Phone phone = new Phone.PhoneBuilder().setName("samsun").setRam(2).getPhone();
        System.out.println(phone);
    }
}
