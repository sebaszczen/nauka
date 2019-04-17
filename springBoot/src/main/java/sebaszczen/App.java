package sebaszczen;

import org.hibernate.Hibernate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import sebaszczen.async.TestAsync;
import sebaszczen.domain.Car;
import sebaszczen.domain.oneToOne.Girl;
import sebaszczen.domain.oneToOne.Man;
import sebaszczen.domain.oneToOne.ServiceOneToOne;
import sebaszczen.domain.oneToOne.repository.ManRepository;
import sebaszczen.manyToOneBidirectional.Products;
import sebaszczen.manyToOneBidirectional.Store;
import sebaszczen.manyToOneUnidirectional.House;
import sebaszczen.manyToOneUnidirectional.Street;
import sebaszczen.oneToMany.Dog;
import sebaszczen.oneToMany.DogRepository;
import sebaszczen.oneToMany.Owner;
import sebaszczen.oneToMany.Service;
import sebaszczen.repository.*;
import sebaszczen.service.Transactions;
import sun.awt.AppContext;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import java.util.*;
import java.util.concurrent.*;
import java.util.stream.Stream;

/**
 * Hello world!
 *
 */

@SpringBootApplication
@EnableTransactionManagement
@EnableAsync
public class App implements CommandLineRunner
{

    @Autowired
    private PersonRepository personRepository;
    @Autowired
    private CarRepository carRepository;
    @Autowired
    private StudentRepository studentRepository;
    @Autowired
    private UniversityRepository universityRepository;
    @Autowired
    private Transactions transactions;
    @Autowired
    private ServiceOneToOne serviceOneToOne;
    @Autowired
    private StoreRepository storeRepository;
    @Autowired
    private static ApplicationContext applicationContext;
    @Autowired
    private Service service;
    @Autowired
    DogRepository dogRepository;
    @Autowired
    private TestAsync testAsync;
    @Autowired
    private ManRepository manRepository;


    public static void main( String[] args )
    {
        ConfigurableApplicationContext run = SpringApplication.run(App.class);
        Transactions bean = run.getBean(Transactions.class);
    }

    private static void printBeans() {
        String[] beanDefinitionNames = applicationContext.getBeanDefinitionNames();
        for (String beanDefinitionName : beanDefinitionNames) {
            System.out.println("-------- bean: "+ beanDefinitionName);
        }
    }


    @Override
    public void run(String... strings) throws Exception {
//        Car newCar = new Car(1l,"newCar");
//        Car newcar1 = new Car(1l, "newCar");
//        Car oldCar = new Car(2l,"oldCar");
//        Car oldCar1 = new Car(2l,"oldCar");
//        carRepository.save(newCar);
//        carRepository.save(oldCar);
//        Person person = new Person("adam", newCar,oldCar);
//        personRepository.save(person);
//        Person person1 = new Person("ewa", newCar,oldCar);
//        personRepository.save(person1);
//        Person person2 = new Person("michal",newcar1,oldCar1);
//        personRepository.save(person2);

//        Car newCar2 = new Car(3l, "newcar2");
//        Car oldCar2 = new Car(4l, "oldcar2");
//        Person person3 = new Person("person3", newCar2);
////        Person person4 = new Person("person4", newCar2, oldCar2);
//        carRepository.save(newCar2);
//        carRepository.save(oldCar2);
//        personRepository.save(person3);
//        Car one = carRepository.findOne(3l);
//        List list = Arrays.asList(new Person("ufo"));
//        one.setNewCar(list);
//        carRepository.save(one);


        //aby otrzymać trzecia tabele przechowujaca klucze car i person odkomentowa linie 15-17 w klasie Person

//        University university = new University(1L,"pw");
//        Student student = new Student(1l,"pawel", new University(1L,"pw"));
//        Student student1 = new Student(2l, "gawel", new University(1L,"pw"));
//        System.out.println("pierwsze");
//        studentRepository. save(student);
//        System.out.println("drugi");
//        studentRepository.save(student1);


        //@ManyToOne unidirectional House-Street

//        List houseList = Arrays.asList(new House("czerwonyDom"), new House("zielonyDom"));
//        Street street = new Street(houseList, "ulica");
//        streetRepository.save(street);

        //id-sequence generator

//        transactions.saveBicycle();
//        transactions.saveBicycleManually();

        //OneToOne
//        serviceOneToOne.save();

        //OneToManyBidirectional
//        Products products = new Products();
//        Products products1 = new Products();
//        Set<Products> productsList = new HashSet<>(Arrays.asList(products, products1));
//        Store store = new Store(productsList);
//        products.setStore(store);
//        products1.setStore(store);
//        storeRepository.save(store);
//        System.out.println("tutaj");
//        storeRepository.findById(1l);
//
//        printBeans();
//        List<Owner> ownerList = new ArrayList<>(Arrays.asList(new Owner(), new Owner(), new Owner(), new Owner()));
//        nPlusOneProblem();

//        transactions.checkHowTransactionProxyWorks();
//        transactions.checkHowTransactionProxyWorks2();

//        checkIfAsynWithReturnTypeDifferentThanFutereCreateError();
//        System.out.println("hello");
//        System.out.println("wynik: "+testAsync.returnInt().get());

//        saveEntityWhichInheritClass();

        playWithProxy();

    }

    private void playWithProxy() {
        List<Products> set = new ArrayList<>(Arrays.asList(new Products(), new Products()));
        Store store = new Store(set);
        storeRepository.save(store);
        storeRepository.findById(1l);
        List<Store> all = storeRepository.findAll();
        all.get(1).getProductsSet().get(1);
    }

    private void saveEntityWhichInheritClass() {
        Girl girl = new Girl();
        Man man = new Man(girl);
        manRepository.save(man);
        manRepository.findById(1L);
        Optional<Man> byId = manRepository.findById(1L);
        manRepository.save(byId.get());

    }

    private void checkIfAsynWithReturnTypeDifferentThanFutereCreateError() throws InterruptedException, ExecutionException {
        Future<Integer> integerFuture = testAsync.returnInt();
        System.out.println("tutaj: "+ integerFuture);
    }

    private void nPlusOneProblem() {
        service.save();
        service.nPlusOneProblem();
    }


}
