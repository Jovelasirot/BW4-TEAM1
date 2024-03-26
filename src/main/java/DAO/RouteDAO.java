package DAO;

import entities.Route;
import entities.Vehicle;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;

import java.util.Random;

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

    public int RouteTimeByVehicleId(long vehicleId) {

        Random random = new Random();
        int count = random.nextInt(5) + 1;

        int randomMinutes = random.nextInt(60);

        int routeTime = Vehicle.averageRouteTime + randomMinutes;

        System.out.println("Il routeTime per il vehicleId " + vehicleId + " è: " + routeTime + " minuti.");

        return routeTime;
    }
}
