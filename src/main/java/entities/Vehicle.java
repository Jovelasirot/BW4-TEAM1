package entities;

import enums.ServiceType;
import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
public abstract class Vehicle {
    @ManyToOne
    @JoinColumn(name = "route_id", nullable = false, unique = true)
    protected static Route route;
    @Id
    @GeneratedValue
    @Column(name = "vehicle_id")
    protected long id;
    @Enumerated(EnumType.STRING)
    protected ServiceType serviceType;
    @Column(name = "duty_start_date")
    protected LocalDate dutyStartDate;
    @Column(name = "maintenance_start_date")
    protected LocalDate maintenanceStartDate;
    @Column(name = "duty_end_date")
    protected LocalDate dutyEndDate;
    @Column(name = "maintenance_end_date")
    protected LocalDate maintenanceEndDate;
    @Column(name = "actual_route_time")
    protected int actualRouteTime;
    @Column(name = "validated_ticket")
    protected int validatedTicket;
    @Column(name = "period_on_duty")
    protected Long periodOnDuty;
    @Column(name = "period_on_maintenance")
    protected Long periodOnMaintenance;

    public Vehicle() {
    }
    
    public Vehicle(ServiceType serviceType, LocalDate startDate, LocalDate endDate, int actualRouteTime, int validatedTicket, Long period) {

        this.serviceType = serviceType;
        if (ServiceType.ON_DUTY.equals(serviceType)) {
            this.dutyStartDate = startDate;
            this.dutyEndDate = endDate;
            this.periodOnDuty = period;
        } else if (ServiceType.IN_MAINTENANCE.equals(serviceType)) {
            this.maintenanceStartDate = startDate;
            this.maintenanceEndDate = endDate;
            this.periodOnMaintenance = period;
        }

        this.actualRouteTime = actualRouteTime;
        this.validatedTicket = validatedTicket;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public ServiceType getServiceType() {
        return serviceType;
    }

    public void setServiceType(ServiceType serviceType) {
        this.serviceType = serviceType;
    }

    public LocalDate getDutyStartDate() {
        return dutyStartDate;
    }

    public void setDutyStartDate(LocalDate dutyStartDate) {
        this.dutyStartDate = dutyStartDate;
    }

    public LocalDate getMaintenanceStartDate() {
        return maintenanceStartDate;
    }

    public void setMaintenanceStartDate(LocalDate maintenanceStartDate) {
        this.maintenanceStartDate = maintenanceStartDate;
    }

    public LocalDate getDutyEndDate() {
        return dutyEndDate;
    }

    public void setDutyEndDate(LocalDate dutyEndDate) {
        this.dutyEndDate = dutyEndDate;
    }

    public LocalDate getMaintenanceEndDate() {
        return maintenanceEndDate;
    }

    public void setMaintenanceEndDate(LocalDate maintenanceEndDate) {
        this.maintenanceEndDate = maintenanceEndDate;
    }

    public int getActualRouteTime() {
        return actualRouteTime;
    }

    public void setActualRouteTime(int actualRouteTime) {
        this.actualRouteTime = actualRouteTime;
    }

    public int getValidatedTicket() {
        return validatedTicket;
    }

    public void setValidatedTicket(int validatedTicket) {
        this.validatedTicket = validatedTicket;
    }

    public Long getPeriodOnDuty() {
        return periodOnDuty;
    }

    public void setPeriodOnDuty(Long periodOnDuty) {
        this.periodOnDuty = periodOnDuty;
    }

    public Long getPeriodOnMaintenance() {
        return periodOnMaintenance;
    }

    public void setPeriodOnMaintenance(Long periodOnMaintenance) {
        this.periodOnMaintenance = periodOnMaintenance;
    }

    public Route getRoute() {
        return route;
    }

    public void setRoute(Route route) {
        this.route = route;
    }

    @Override
    public String toString() {
        return "Vehicle{" +
                "id=" + id +
                ", serviceType=" + serviceType +
                ", dutyStartDate=" + dutyStartDate +
                ", maintenanceStartDate=" + maintenanceStartDate +
                ", dutyEndDate=" + dutyEndDate +
                ", maintenanceEndDate=" + maintenanceEndDate +
                ", actualRouteTime=" + actualRouteTime +
                ", validatedTicket=" + validatedTicket +
                ", periodOnDuty=" + periodOnDuty +
                ", periodOnMaintenance=" + periodOnMaintenance +
                ", route=" + route +
                '}';
    }
}
