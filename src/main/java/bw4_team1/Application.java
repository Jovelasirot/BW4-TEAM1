package bw4_team1;

import DAO.TicketDAO;
import entities.Ticket;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class Application {
    private static final EntityManagerFactory emf = Persistence.createEntityManagerFactory("atm");
    public static void main(String[] args) {

        EntityManager eM = emf.createEntityManager();
        TicketDAO td = new TicketDAO(eM);
        TicketTest ticketTest = new TicketTest();

        for (int i =0; i < 30; i++ ){
            Ticket anotherRandomTicket = ticketTest.get();
            td.save(anotherRandomTicket);

        }

        System.out.println("Hello World!");


        emf.close();
        eM.close();
    }
}
