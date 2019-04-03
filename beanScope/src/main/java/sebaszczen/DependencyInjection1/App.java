package sebaszczen.DependencyInjection1;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

/**
 * Hello world!
 *
 */
@SpringBootApplication
public class   App
{
    public static void main( String[] args )
    {

        ConfigurableApplicationContext run = SpringApplication.run(App.class);
//        AlienSingleton bean1 = run.getBean(AlienSingleton.class);


        //2
//        AlienSingleton bean2 = run.getBean(AlienSingleton.class);
//        bean1.setName("xxx");
//        System.out.println(bean2.getName());


        //3
//        AlienPrototype bean3 = run.getBean(AlienPrototype.class);
//        AlienPrototype bean4 = run.getBean(AlienPrototype.class);


//        AlienRequestScope alienRequestScope = run.getBean(AlienRequestScope.class);

        String[] beanDefinitionNames = run.getBeanDefinitionNames();
        for (String beanDefinitionName : beanDefinitionNames) {
            System.out.println("-----------bean name: "+beanDefinitionName);
        }

    }
}
