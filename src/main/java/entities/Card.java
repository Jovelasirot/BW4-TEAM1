package entities;

import jakarta.persistence.*;

import java.time.LocalDate;
@Entity
@Table(name = "cards")
public class Card {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column( name = "card_number")
    private long cardNumber;
    @Column(name = "date_of_issue")
    private LocalDate dateOfIssue;
    @Column(name = "expiry_date")
    private LocalDate expiryDate;
//    @OneToMany
//    private Pass pass;

    public Card(){}

    public Card(LocalDate dateOfIssue, LocalDate expiryDate) {
        this.dateOfIssue = dateOfIssue;
        this.expiryDate = expiryDate;
    }

    public long getCardNumber() {
        return cardNumber;
    }

    public void setCardNumber(long cardNumber) {
        this.cardNumber = cardNumber;
    }

    public LocalDate getDateOfIssue() {
        return dateOfIssue;
    }

    public void setDateOfIssue(LocalDate dateOfIssue) {
        this.dateOfIssue = dateOfIssue;
    }

    public LocalDate getExpiryDate() {
        return expiryDate;
    }

    public void setExpiryDate(LocalDate expiryDate) {
        this.expiryDate = expiryDate;
    }

    @Override
    public String toString() {
        return "Card{" +
                "cardNumber=" + cardNumber +
                ", dateOfIssue=" + dateOfIssue +
                ", expiryDate=" + expiryDate +
                '}';
    }
}
