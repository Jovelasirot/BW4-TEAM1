package DAO;
import entities.Ticket;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;


public class TicketDAO {
    private final EntityManager em;


    public TicketDAO(EntityManager em) {
        this.em = em;
    }

    public void save(Ticket ticket) {
        EntityTransaction transaction = em.getTransaction();
        transaction.begin();
        em.persist(ticket);
        transaction.commit();
        System.out.println("The ticket with id: " + ticket.getTicket_id() + ", has been saved correctly");
    }
}
