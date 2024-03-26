package bw4_team1;

import DAO.CardDAO;
import DAO.UserDAO;
import com.github.javafaker.Faker;
import entities.Card;
import entities.User;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

import java.time.LocalDate;
import java.util.Random;
import java.util.function.Supplier;

public class CardTest {

    private static final EntityManagerFactory emf = Persistence.createEntityManagerFactory("atm");

    public static void main(String[] args) {

        EntityManager em = emf.createEntityManager();
        CardDAO card_dao = new CardDAO(em);
        UserDAO user_dao = new UserDAO(em);
        Random random = new Random();

       // Supplier<Card> cardSupplier = () -> (new Card(LocalDate.now().plusDays(random.nextInt(365)),));
        for (long i = 0; i < 30; i++) {
            card_dao.save(new Card(LocalDate.now().minusDays(random.nextInt(730)),user_dao.findById(i)));

        }


    }
}
