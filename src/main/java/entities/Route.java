package entities;

import com.github.javafaker.Faker;
import jakarta.persistence.*;

import java.util.List;
import java.util.Random;
import java.util.function.Supplier;

@Entity
public class Route {
    @ManyToOne
    @JoinColumn(name = "vehicle_id", nullable = false, unique = true)
    private Vehicle vehicle;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "route_id")
    private long id;
    private String starRoute;
    private String endRoute;

    private int averageRouteTime;

    public Route() {
    }

    public Route(Vehicle vehicle, String starRoute, String endRoute, int averageRouteTime) {
        this.vehicle = vehicle;
        this.starRoute = starRoute;
        this.endRoute = endRoute;
        this.averageRouteTime = averageRouteTime;
    }

    public static Supplier<Route> getRouteSupplier(EntityManagerFactory emf) {
        Random rdm = new Random();
        Faker faker = new Faker();

        return () -> {
            EntityManager eM = emf.createEntityManager();

            TypedQuery<Vehicle> vehicleQuery = eM.createQuery("SELECT v from Vehicle v", Vehicle.class);
            List<Vehicle> vehicleList = vehicleQuery.getResultList();
            int rdmVehicleSelector = rdm.nextInt(vehicleList.size());
            Vehicle selectedVehicle = vehicleList.get(rdmVehicleSelector);

            String startRoute = faker.harryPotter().character();
            String endRoute = faker.harryPotter().character();

            int averageRouteTime = rdm.nextInt(60, 180);

            return new Route(selectedVehicle, startRoute, endRoute, averageRouteTime);
        };
    }

    public Vehicle getVehicle() {
        return vehicle;
    }

    public void setVehicle(Vehicle vehicle) {
        this.vehicle = vehicle;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getStarRoute() {
        return starRoute;
    }

    public void setStarRoute(String starRoute) {
        this.starRoute = starRoute;
    }

    public String getEndRoute() {
        return endRoute;
    }

    public void setEndRoute(String endRoute) {
        this.endRoute = endRoute;
    }

    public int getAverageRouteTime() {
        return averageRouteTime;
    }

    public void setAverageRouteTime(int averageRouteTime) {
        this.averageRouteTime = averageRouteTime;
    }
}
