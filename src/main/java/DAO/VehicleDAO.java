package DAO;

import entities.Vehicle;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;

public class VehicleDAO {
    
    private final EntityManager em;

    public VehicleDAO(EntityManager em) {
        this.em = em;
    }

    public void save(Vehicle vehicle) {
        EntityTransaction transaction = em.getTransaction();
        transaction.begin();
        em.persist(vehicle);
        transaction.commit();
        System.out.println("The vehicle: " + vehicle.getId() + ", has been saved correctly");
    }
}
