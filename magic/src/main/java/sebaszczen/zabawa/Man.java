package sebaszczen.zabawa;

import java.util.Objects;

public class Man {
    public static String name;
    public String color;

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Man man = (Man) o;
        return Objects.equals(name, man.name);
    }

    @Override
    public int hashCode() {

        return Objects.hash(name);
    }
}
