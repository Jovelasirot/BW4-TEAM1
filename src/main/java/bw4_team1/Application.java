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


        System.out.println("Hello World!");


        emf.close();
        eM.close();
    }
}
