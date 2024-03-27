package DAO;

import entities.Ticket;
import entities.Vehicle;
import exceptions.NotFoundException;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.TypedQuery;


import java.time.LocalDate;
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

    private Vehicle getVehiclebyId(int vehicle_id){
        Vehicle vehicle = em.find(Vehicle.class, vehicle_id);
        return vehicle;

    }
    public void checkManteinence(int vehicle_id) {
        Vehicle vehicle = getVehiclebyId(vehicle_id);
        if (vehicle != null) {
            LocalDate today = LocalDate.now();
            if (!today.isBefore(vehicle.getMaintenanceStartDate()) && !today.isAfter(vehicle.getMaintenanceEndDate())) {
                System.out.println("The vehicle is under manteinence.");
            } else {
                System.out.println("The vehicle is not under manteinence.");
            }
        } else {
            System.out.println("Vehicle by id: " + vehicle_id + "not found");
        }
    }

    }

