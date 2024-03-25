package entities;

import jakarta.persistence.*;

import java.util.Date;


@Entity
public class Ticket {
@Id
@Column
@GeneratedValue
    private int ticket_id; // primary key
@Column
    private Date issueDate;
@Column
@ManyToOne
@JoinColumn
    private int id;
@Column
@Enumerated(EnumType.STRING)
    private Validation validation;
@Column
        @ManyToOne
        @JoinColumn
long vehicle_id;


    public Ticket(int ticket_id, Date issueDate, int id, Validation stato, long vehicle_id) {
        this.ticket_id = ticket_id;
        this.issueDate = issueDate;
        this.id = id;
        this.validation = stato;
        this.vehicle_id = vehicle_id;
    }

    public int getTicket_id() {
        return ticket_id;
    }

    public void setTicket_id(int ticket_id) {
        this.ticket_id = ticket_id;
    }

    public Date getIssueDate() {
        return issueDate;
    }

    public void setIssueDate(Date issueDate) {
        this.issueDate = issueDate;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Validation getValidation() {
        return validation;
    }

    public void setValidation(Validation validation) {
        this.validation = validation;
    }

    public long getVehicle_id() {
        return vehicle_id;
    }

    public void setVehicle_id(long vehicle_id) {
        this.vehicle_id = vehicle_id;
    }

    @Override
    public String toString() {
        return "Ticket{" +
                "ticket_id=" + ticket_id +
                ", issueDate=" + issueDate +
                ", id=" + id +
                ", validation=" + validation +
                ", vehicle_id=" + vehicle_id +
                '}';
    }
}