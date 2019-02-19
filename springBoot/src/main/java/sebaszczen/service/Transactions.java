package sebaszczen.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import sebaszczen.domain.sequenceStrategy.Bicycle;
import sebaszczen.domain.sequenceStrategy.Wheel;

import javax.persistence.*;

@Service
public class Transactions {

    @PersistenceContext
    private EntityManager entityManager;

    @Autowired
    private EntityManagerFactory entityManagerFactory;


    public void saveBicycleManually() {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        EntityTransaction transaction = entityManager.getTransaction();
        transaction.begin();
        Bicycle bicycle = new Bicycle();
        entityManager.persist(bicycle);
        transaction.commit();
        transaction.begin();
        Bicycle bicycle1 = new Bicycle();
        entityManager.persist(bicycle1);
        transaction.commit();
        transaction.begin();
        Bicycle bicycle2 = new Bicycle();
        Bicycle bicycle3 = new Bicycle();
        Bicycle bicycle4 = new Bicycle();
        entityManager.persist(bicycle2);
        entityManager.persist(bicycle3);
        entityManager.persist(bicycle4);
        transaction.commit();
        transaction.begin();
        Wheel wheel = new Wheel();
        Bicycle bicycle5 = new Bicycle();
        entityManager.persist(wheel);
        entityManager.persist(bicycle5);
        transaction.commit();

        for (int i = 0; i <50 ; i++) {
            transaction.begin();
            entityManager.persist(new Bicycle());
            transaction.commit();
        }

    }


//    @Transactional
    public void saveBicycle() {

        Bicycle bicycle = new Bicycle();
        Wheel wheel = new Wheel();
        Bicycle bicycle1 = new Bicycle();
        Wheel wheel1 = new Wheel();
        EntityTransaction transaction = entityManager.getTransaction();
        transaction.begin();
        persist(bicycle);
        persist(wheel);
        persist(bicycle1);
        persist(wheel1);
        transaction.commit();
    }

//    @Transactional
     private <T> void persist(T bicycle) {
        entityManager.persist(bicycle);
    }
}
