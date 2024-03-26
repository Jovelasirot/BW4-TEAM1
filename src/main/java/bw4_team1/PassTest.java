package bw4_team1;

import DAO.CardDAO;
import DAO.PassDAO;
import DAO.SalesDAO;
import DAO.UserDAO;
import com.github.javafaker.Faker;
import entities.Card;
import entities.Pass;
import entities.Sales;
import enums.PassDuration;
import enums.Validation;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.concurrent.TimeUnit;
import java.util.function.Supplier;

public class PassTest {
    private static final  List<PassDuration> duration = Arrays.stream(PassDuration.values())
            .toList();


    private static final EntityManagerFactory emf = Persistence.createEntityManagerFactory("atm");

    public static void main(String[] args) {

        EntityManager em = emf.createEntityManager();

        UserDAO udao= new UserDAO(em);
        SalesDAO sdao= new SalesDAO(em);
        PassDAO pdao= new PassDAO(em);
        Faker faker = new Faker();
        Random random = new Random();
        CardDAO cdao = new CardDAO(em);

//        Supplier<Pass> passSupplier = () -> (new Pass(PassDuration.WEEKLY,2020));
            for(long i=1; i< 20; i++){
            pdao.save(new Pass(duration.get(random.nextInt(0,duration.size())), LocalDate.now().plusDays(random.nextInt(1,365)),cdao.findById(i),sdao.findById(i)));
            }


        em.close();
        emf.close();


    }
}
