package sebaszczen.oneToMany;

import org.hibernate.Hibernate;
import org.springframework.beans.factory.annotation.Autowired;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.IntStream;

@org.springframework.stereotype.Service
public class Service {
    @Autowired
    private DogRepository dogRepository;
    @Autowired
    private EntityManagerFactory entityManagerFactory;

    public void studyFetch() {
        Owner owner = new Owner("sdfsd");
        Owner owner2 = new Owner("sdfsd");
        Cat cat = new Cat();
        Cat2 cat2 = new Cat2();
        Dog dog = new Dog(Arrays.asList(owner,owner2), "x",cat,cat2);
        dogRepository.save(dog);
//        find();
    }

//    @Transactional
    public void find() {
        List<Dog> byId = dogRepository.findDogs();
        byId.get(1).getOwnerList();
    }

    //    @Transactional
    public void nPlusOneProblem() {
        List<Dog> all = dogRepository.findAll();
        long start = System.nanoTime();
//        List<Dog> all = dogRepository.findDogs();
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        for (Dog dog : all) {
            System.out.println("pies: "+dog);
            System.out.println("lista włascicieli: ");
            EntityTransaction transaction = entityManager.getTransaction();
//            transaction.begin();
            Hibernate.initialize(dog.getOwnerList());
//            session.close();
//            transaction.commit();
            for (Owner owner : dog.getOwnerList()) {
                System.out.println("własciciel: "+ owner);
            }
        }
        long end = System.nanoTime();
        System.out.println("czas: "+ (end-start));
    }

    public void save() {
        IntStream range = IntStream.range(1, 5);
//        range.forEach(x->dogRepository.save(new Dog(new ArrayList<>(Arrays.asList(new Owner(), new Owner(), new Owner(), new Owner())),"Sdf", cat, cat2)));
//        dogRepository.save(new Dog(new ArrayList<>(Arrays.asList(new Owner(), new Owner(), new Owner(), new Owner())),"Sdf"));
//        dogRepository.save(new Dog(new ArrayList<>(Arrays.asList(new Owner(), new Owner(), new Owner(), new Owner())),"Sdf"));
//        dogRepository.save(new Dog(new ArrayList<>(Arrays.asList(new Owner(), new Owner(), new Owner(), new Owner())),"Sdf"));
//        dogRepository.save(new Dog(new ArrayList<>(Arrays.asList(new Owner(), new Owner(), new Owner(), new Owner())),"Sdf"));
    }
}
