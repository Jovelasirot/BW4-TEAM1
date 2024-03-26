package entities;

import com.github.javafaker.Faker;
import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.function.Supplier;

@Entity
@Table(name = "maintenance_records")
public class MaintenanceRecord {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "record_id")
    private Long idRecord;

    @ManyToOne
    @JoinColumn(name = "vehicle_id")
    private Vehicle vehicle;

    @Transient
    private LocalDate startDate;

    @Transient
    private LocalDate endDate;


    @Column(name = "maintenance_period")
    private String maintenancePeriod;
    @Column(name = "reason")
    private String reason;

    public MaintenanceRecord() {
    }

    public MaintenanceRecord(Vehicle vehicle, LocalDate startDate, LocalDate endDate, String reason) {
        this.vehicle = vehicle;
        this.startDate = startDate;
        this.endDate = endDate;
        this.reason = reason;
        this.maintenancePeriod = periodCalculator(startDate, endDate);
    }

    public static Supplier<List<MaintenanceRecord>> getMaintenanceRecords(EntityManagerFactory emf) {
        Random rdm = new Random();
        Faker faker = new Faker();

        return () -> {
            EntityManager eM = emf.createEntityManager();

            TypedQuery<Vehicle> vehicleQuery = eM.createQuery("SELECT v from Vehicle v", Vehicle.class);
            List<Vehicle> vehicleList = vehicleQuery.getResultList();
            int rdmVehicleSelector = rdm.nextInt(vehicleList.size());
            Vehicle selectedVehicle = vehicleList.get(rdmVehicleSelector);

            int numMaintenanceRecords = rdm.nextInt(1, 5);
            List<MaintenanceRecord> maintenanceRecords = new ArrayList<>();
            for (int i = 0; i < numMaintenanceRecords; i++) {
                LocalDate startDate = LocalDate.now().plusDays(rdm.nextInt(730));
                LocalDate endDate = startDate.plusDays(rdm.nextInt(7, 60));
                String reason = faker.lorem().sentence();
                maintenanceRecords.add(new MaintenanceRecord(selectedVehicle, startDate, endDate, reason));
            }

            eM.close();

            return maintenanceRecords;
        };
    }
    

    public String periodCalculator(LocalDate startDate, LocalDate endDate) {
        return startDate.toString() + " - " + endDate.toString();
    }

    public Long getIdRecord() {
        return idRecord;
    }

    public void setIdRecord(Long idRecord) {
        this.idRecord = idRecord;
    }

    public Vehicle getVehicle() {
        return vehicle;
    }

    public void setVehicle(Vehicle vehicle) {
        this.vehicle = vehicle;
    }

    public LocalDate getStartDate() {
        return startDate;
    }

    public void setStartDate(LocalDate startDate) {
        this.startDate = startDate;
    }

    public LocalDate getEndDate() {
        return endDate;
    }

    public void setEndDate(LocalDate endDate) {
        this.endDate = endDate;
    }

    public String getMaintenancePeriod() {
        return maintenancePeriod;
    }

    public void setMaintenancePeriod(String maintenancePeriod) {
        this.maintenancePeriod = maintenancePeriod;
    }

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }
}
