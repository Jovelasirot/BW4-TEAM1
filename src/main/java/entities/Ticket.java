package entities;

import enums.Validation;
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

    @ManyToOne
    @JoinColumn(name = "sales_id")
    private Sales sales;
    @Column
    @Enumerated(EnumType.STRING)
    private Validation validation;

@ManyToOne
@JoinColumn(name = "vehicle_id")
private Vehicle vehicle;


    public Ticket(Date issueDate, Validation stato, long vehicle_id) {

        this.issueDate = issueDate;
        this.validation = stato;
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