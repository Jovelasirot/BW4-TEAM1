package entities;

import enums.Validation;
import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.List;
import java.util.Random;
import java.util.function.Supplier;


@Entity
public class Ticket {
    @Id
    @Column
    @GeneratedValue
    private int ticket_id; // primary key
    @Column
    private LocalDate issueDate;

    @ManyToOne
    @JoinColumn(name = "sales_id")
    private Sales sales;
    @Column
    @Enumerated(EnumType.STRING)
    private Validation validation;

    @ManyToOne
    @JoinColumn(name = "vehicle_id")
    private Vehicle vehicle;

    public Ticket() {
    }

    public Ticket(LocalDate issueDate, Validation stato, Vehicle vehicle) {
        this.vehicle = vehicle;
        this.issueDate = issueDate;
        this.validation = stato;
    }

    public static Supplier<Ticket> getTicketSupplier(EntityManagerFactory emf) {
        Random rdm = new Random();
        Validation[] validations = Validation.values();

        return () -> {
            EntityManager eM = emf.createEntityManager();

            TypedQuery<Vehicle> vehicleQuery = eM.createQuery("SELECT v from Vehicle v", Vehicle.class);
            List<Vehicle> vehicleList = vehicleQuery.getResultList();
            Vehicle selectedVehicle = null;

            int rdmValidation = rdm.nextInt(validations.length);
            Validation validationSelector = validations[rdmValidation];
            if (Validation.VALIDATED.equals(validationSelector) && !vehicleList.isEmpty()) {
                selectedVehicle = vehicleList.get(rdm.nextInt(vehicleList.size()));
            }

            LocalDate issueDate = LocalDate.now().plusDays(rdm.nextInt(730));

            eM.close();

            return new Ticket(issueDate, validationSelector, selectedVehicle);
        };
    }

    public int getTicket_id() {
        return ticket_id;
    }

    public void setTicket_id(int ticket_id) {
        this.ticket_id = ticket_id;
    }

    public LocalDate getIssueDate() {
        return issueDate;
    }

    public void setIssueDate(LocalDate issueDate) {
        this.issueDate = issueDate;
    }

    public Validation getValidation() {
        return validation;
    }

    public void setValidation(Validation validation) {
        this.validation = validation;
    }

    @Override
    public String toString() {
        return "Ticket{" +
                "ticket_id=" + ticket_id +
                ", issueDate=" + issueDate +

                ", validation=" + validation +
                '}';
    }
}