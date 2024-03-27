package DAO;

import entities.MaintenanceRecord;
import entities.Ticket;
import entities.Vehicle;
import exceptions.NotFoundException;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.TypedQuery;


import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

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

    private Vehicle getVehiclebyId(long vehicle_id){
        Vehicle vehicle = em.find(Vehicle.class, vehicle_id);
        return vehicle;

    }
    public void checkMaintenance(long vehicle_id) {
        Vehicle vehicle = getVehiclebyId(vehicle_id);
        if (vehicle != null) {
            LocalDate today = LocalDate.now();
            if (!today.isBefore(vehicle.getMaintenanceStartDate()) && !today.isAfter(vehicle.getMaintenanceEndDate())) {
                System.out.println("The vehicle is under maintenance.");
            } else {
                System.out.println("The vehicle is on duty.");
            }
        } else {
            System.out.println("Vehicle by id: " + vehicle_id + "not found");
        }
    }

    private static List<MaintenanceRecord> maintenanceDatabase = new ArrayList<>();


    public static void addMaintenanceRecord(MaintenanceRecord record) {
        maintenanceDatabase.add(record);
    }

    public static List<MaintenanceRecord> getVehicleMaintenanceHistory(Long vehicle_id) {
        return maintenanceDatabase.stream()
                .filter(record -> record.getVehicle().getId().equals(vehicle_id))
                .collect(Collectors.toList());
    }

    }



