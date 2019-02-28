package pl.Bundle;

import java.util.ListResourceBundle;

public class ResoourceBundleTest extends ListResourceBundle {
    @Override
    protected Object[][] getContents() {

        return new Object[][]{
                {"hello", "Maciek"},
                {"good", "Java"},
                {"very", "nice Yamaha"}
        };
    }
}
