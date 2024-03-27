package DAO;

import entities.Route;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;

public class RouteDAO {
    private final EntityManager em;

    public RouteDAO(EntityManager em) {
        this.em = em;
    }

    public void save(Route route) {
        EntityTransaction transaction = em.getTransaction();
        transaction.begin();
        em.persist(route);
        transaction.commit();
        System.out.println("The route with id: " + route.getId() + ", has been saved correctly");
    }

    public Route findByid(long id) {
        return em.find(Route.class, id);
    }
}
