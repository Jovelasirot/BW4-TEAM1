package DAO;

import entities.Vehicle;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.TypedQuery;

import java.util.List;

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
        System.out.println("The vehicle with id: " + vehicle.getId() + ", has been saved correctly");
    }

    public List<Vehicle> getAllVehicles() {
        TypedQuery<Vehicle> query = em.createQuery("SELECT v FROM Vehicle v", Vehicle.class);
        return query.getResultList();
    }
}
