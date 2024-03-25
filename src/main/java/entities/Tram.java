package entities;

import enums.ServiceType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.Random;
import java.util.function.Supplier;

@Entity
public class Tram extends Vehicle {
    @Column(name = "max_capacity_tram")
    private int maxCapacityTram = 70;

    public Tram() {
    }

    public Tram(ServiceType serviceType, LocalDate startDate, LocalDate endDate, int actualRouteTime, int validatedTicket, Long period) {
        super(serviceType, startDate, endDate, actualRouteTime, validatedTicket, period);
    }

    public static Supplier<Tram> getTramSupplier() {
        Random rdm = new Random();
        ServiceType[] serviceTypes = ServiceType.values();


        return () -> {
            int rdmServiceType = rdm.nextInt(serviceTypes.length);
            ServiceType serviceType = serviceTypes[rdmServiceType];

            LocalDate startDate = LocalDate.now();
            LocalDate endDate = LocalDate.now();
            Long period = null;
            if (ServiceType.ON_DUTY.equals(serviceType)) {
                startDate = startDate.plusDays(rdm.nextInt(730));
                endDate = startDate.plusDays(rdm.nextInt(7, 60));
                long periodInMaintenance = ChronoUnit.DAYS.between(startDate, endDate);
                period = periodInMaintenance;

            } else if (ServiceType.IN_MAINTENANCE.equals(serviceType)) {
                startDate = LocalDate.now().plusDays(rdm.nextInt(730));
                endDate = startDate.plusDays(rdm.nextInt(7, 60));
                long periodInMaintenance = ChronoUnit.DAYS.between(startDate, endDate);
                period = periodInMaintenance;

            }


            int averageRouteTime = rdm.nextInt(60, 180);
            int actualRouteTime = averageRouteTime + rdm.nextInt(0, 5);

            int validatedTicket = rdm.nextInt(1000);

            return new Tram(serviceType, startDate, endDate, actualRouteTime, validatedTicket, period);
        };
    }

    public int getMaxCapacityTram() {
        return maxCapacityTram;
    }

    public void setMaxCapacityTram(int maxCapacityTram) {
        this.maxCapacityTram = maxCapacityTram;
    }

    @Override
    public String toString() {
        return "Tram{" +
                "maxCapacityTram=" + maxCapacityTram +
                ", id=" + id +
                ", serviceType=" + serviceType +
                ", dutyStartDate=" + dutyStartDate +
                ", maintenanceStartDate=" + maintenanceStartDate +
                ", dutyEndDate=" + dutyEndDate +
                ", maintenanceEndDate=" + maintenanceEndDate +
                ", actualRouteTime=" + actualRouteTime +
                ", validatedTicket=" + validatedTicket +
                ", periodOnDuty=" + periodOnDuty +
                ", periodOnMaintenance=" + periodOnMaintenance +
                '}';
    }
}
