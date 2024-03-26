package DAO;

import entities.Pass;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;

public class PassDAO {
    private final EntityManager em;

    public PassDAO(EntityManager em) {
        this.em = em;
    }

    public void save(Pass pass) {
        EntityTransaction transaction = em.getTransaction();
        transaction.begin();
        em.persist(pass);
        transaction.commit();
        System.out.println("The pass with id: " + pass.getPass_id() + ", has been saved correctly");
    }


}