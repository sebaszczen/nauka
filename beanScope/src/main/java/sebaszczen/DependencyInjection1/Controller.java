package sebaszczen.DependencyInjection1;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Controller {

    @RequestMapping("/set")
    public void setValue() {
    }

}
