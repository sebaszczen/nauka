package sebaszczen.unittesting;

import com.jayway.jsonpath.DocumentContext;
import com.jayway.jsonpath.JsonPath;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;


public class JsonPathTest {

    @Test
    public void learning() {
        String json = "[\n" +
                "{\"id\":1,\"name\":x,\"quantity\":22},\n" +
                "{\"id\":2,\"name\":x2,\"quantity\":10},\n" +
                "{\"id\":3,\"name\":x3,\"quantity\":34}\n" +
                "]";

        DocumentContext parse = JsonPath.parse(json);
        int length = parse.read("$.length()");
        assertThat(length).isEqualTo(3);
        List<Integer> list = parse.read("$..id");
        System.out.println(list.toString());
        assertThat(list).hasSize(3).contains(1,3,2);
        System.out.println(parse.read("$.[0]").toString());
        System.out.println(parse.read("$.[0:3]").toString());
        System.out.println(parse.read("$.[?(@.name=='x2')]").toString());
        System.out.println(parse.read("$.[?(@.quantity=='22')]").toString());
    }



}
