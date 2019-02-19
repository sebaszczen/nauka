package sebaszczen;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import sebaszczen.domain.oneToOne.ServiceOneToOne;
import sebaszczen.domain.sequenceStrategy.Bicycle;
import sebaszczen.repository.*;
import sebaszczen.service.Transactions;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.PersistenceContext;

/**
 * Hello world!
 *
 */

@SpringBootApplication
@EnableTransactionManagement
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

    public static void main( String[] args )
    {
        SpringApplication.run(App.class);
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
        serviceOneToOne.save();
    }


}
