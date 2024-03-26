package bw4_team1;

import DAO.PassDAO;
import DAO.SalesDAO;
import DAO.UserDAO;
import com.github.javafaker.Faker;
import entities.Card;
import entities.Pass;
import entities.Sales;
import enums.PassDuration;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

import java.time.ZoneId;
import java.util.Random;
import java.util.concurrent.TimeUnit;
import java.util.function.Supplier;

public class PassTest {

    private static final EntityManagerFactory emf = Persistence.createEntityManagerFactory("atm");

    public static void main(String[] args) {

        EntityManager em = emf.createEntityManager();

        UserDAO udao= new UserDAO(em);
        SalesDAO sdao= new SalesDAO(em);
        PassDAO pdao= new PassDAO(em);
        Faker faker = new Faker();
        Random random = new Random();

        Supplier<Pass> passSupplier = () -> (new Pass(PassDuration.WEEKLY,2020));
            for(int i=0; i< 30; i++)
            pdao.save(passSupplier.get());
            System.out.println(passSupplier.get());




        em.close();
        emf.close();


    }
}
