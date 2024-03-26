package entities;

import com.github.javafaker.Faker;
import jakarta.persistence.*;

import java.util.Collections;
import java.util.List;
import java.util.Random;
import java.util.function.Supplier;

@Entity
@Table(name = "routes")
public class Route {
    @ManyToOne
    @JoinColumn(name = "vehicle_id")
    private Vehicle vehicle;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "route_id")
    private long id;

    @Column(name = "start_route")
    private String starRoute;

    @Column(name = "end_route")
    private String endRoute;

    @Column(name = "average_route_time")
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


            Collections.shuffle(vehicleList, rdm);


            for (Vehicle vehicle : vehicleList) {
                String startRoute = faker.cat().name();
                String endRoute = faker.cat().breed();
                int averageRouteTime = rdm.nextInt(60, 120);

                Route route = new Route(vehicle, startRoute, endRoute, averageRouteTime);

                eM.close();

                return route;
            }


            return null;
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
