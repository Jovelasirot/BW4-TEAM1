package entities;

import DAO.UserDAO;
import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.List;
import java.util.Random;
import java.util.function.Supplier;

@Entity
@Table(name = "cards")
public class Card {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "card_id")
    private long cardNumber;
    @Column(name = "date_of_issue")
    private LocalDate dateOfIssue;
    @Column(name = "expiry_date")
    private LocalDate expiryDate;
    @OneToMany(mappedBy = "card", cascade = CascadeType.ALL)
    private List<Pass> passes;
    @OneToOne
    @JoinColumn(name = "user_id")
    private User user;

    public Card() {
    }

    public Card(LocalDate dateOfIssue, User user) {
        this.dateOfIssue = dateOfIssue;
        this.expiryDate = dateOfIssue.plusDays(30);
        this.user = user;
    }

    public static Supplier<Card> getCardSupplier(EntityManagerFactory emf, UserDAO uDAO) {
        Random rdm = new Random();


        return () -> {
            EntityManager eM = emf.createEntityManager();

            LocalDate dateOfIssue = LocalDate.now().minusDays(rdm.nextInt(730));

            TypedQuery<User> userQuery = eM.createQuery("SELECT u from User u", User.class);
            List<User> userList = userQuery.getResultList();

            User user = uDAO.findById(rdm.nextInt(userList.size()));

            return new Card(dateOfIssue, user);
        };
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
