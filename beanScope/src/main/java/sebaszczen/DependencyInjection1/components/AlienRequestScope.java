package sebaszczen.DependencyInjection1.components;

import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Component;
import org.springframework.web.context.WebApplicationContext;

@Component
@Scope(value = WebApplicationContext.SCOPE_REQUEST, proxyMode = ScopedProxyMode.TARGET_CLASS)
public class AlienRequestScope {

    public String show() {
        return "hello";
    }

    public AlienRequestScope() {
        System.out.println("Alien request scope created");
    }
}
