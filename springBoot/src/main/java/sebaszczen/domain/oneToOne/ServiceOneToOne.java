package sebaszczen.domain.oneToOne;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;

@Service
public class ServiceOneToOne {

    @Autowired
    private EntityManagerFactory entityManagerFactory;

    public void save() {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        EntityTransaction transaction = entityManager.getTransaction();
        Girl girl = new Girl();
        Man man = new Man(girl);
        transaction.begin();
        entityManager.persist(girl);
        transaction.commit();
        transaction.begin();
        entityManager.persist(man);
        transaction.commit();
        transaction.begin();
        Man man1 = new Man(2L);
        entityManager.persist(man1);
        transaction.commit();

    }

}
