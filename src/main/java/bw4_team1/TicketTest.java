package bw4_team1;

import DAO.TicketDAO;
import entities.Ticket;
import enums.Validation;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

import java.util.Date;
import java.util.Random;
import java.util.function.Supplier;

public class TicketTest implements Supplier<Ticket> {
    private Random random = new Random();
    private static final Validation[] VALIDATIONS = Validation.values();

    private static final EntityManagerFactory emf = Persistence.createEntityManagerFactory("atm");
    @Override
    public Ticket get() {
        EntityManager eM = emf.createEntityManager();
        TicketDAO td = new TicketDAO(eM);
        TicketTest ticketTest = new TicketTest();

        for (int i =0; i < 30; i++ ){
            Ticket anotherRandomTicket = ticketTest.get();
            td.save(anotherRandomTicket);

        }
        Date issueDate = new Date();
        Validation validation = VALIDATIONS[random.nextInt(VALIDATIONS.length)];
        long vehicle_id = random.nextLong();


        return new Ticket(issueDate, validation, vehicle_id);
    }
}