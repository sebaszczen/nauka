package sebaszczen.builderPattern;

import javax.sound.midi.Sequence;

public class Phone {
    private int ram;
    private String os;
    private String name;
    private int screenSize;

    Phone(PhoneBuilder phoneBuilder) {
        this.ram = phoneBuilder.ram;
        this.os = phoneBuilder.os;
        this.name = phoneBuilder.name;
        this.screenSize = phoneBuilder.screenSize;
    }

    @Override
    public String toString() {
        return "Phone{" +
                "ram=" + ram +
                ", os='" + os + '\'' +
                ", name='" + name + '\'' +
                ", screenSize=" + screenSize +
                '}';
    }

    public static class PhoneBuilder{
        private int ram;
        private String os;
        private String name;
        private int screenSize;

        public PhoneBuilder setRam(int ram) {
            this.ram = ram;
            return this;
        }

        public PhoneBuilder setOs(String os) {
            this.os = os;
            return this;
        }

        public PhoneBuilder setName(String name) {
            this.name = name;
            return this;
        }

        public PhoneBuilder setScreenSize(int screenSize) {
            this.screenSize = screenSize;
            return this;
        }

        public Phone getPhone() {
            return new Phone(this);
        }
    }
}
