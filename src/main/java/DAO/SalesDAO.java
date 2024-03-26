package DAO;

import entities.Sales;
import entities.User;
import entities.Vehicle;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;

public class SalesDAO {

    private final EntityManager em;

    public SalesDAO(EntityManager em) {
        this.em = em;
    }

    public void save(Sales vehicle) {
        EntityTransaction transaction = em.getTransaction();
        transaction.begin();
        em.persist(vehicle);
        transaction.commit();
        System.out.println("Salvato");
    }

    public Sales findById(long id){
        Sales sales = em.find(Sales.class,id);
        return sales;
    }


}
