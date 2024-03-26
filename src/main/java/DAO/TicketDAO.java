package DAO;
import entities.Ticket;
import enums.Validation;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.TypedQuery;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;


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

    public List<Ticket> findTicketsBySalesId(int sales_id) {
        TypedQuery<Ticket> query = em.createQuery(
                "SELECT t FROM Ticket t WHERE t.sales.sales_id = :salesId", Ticket.class);
        query.setParameter("salesId", sales_id);
        return query.getResultList();
    }

    public List<Ticket> findTicketsByIssueDateRange(LocalDate startDate, LocalDate endDate) {
        TypedQuery<Ticket> query = em.createQuery(
                "SELECT t FROM Ticket t WHERE t.issueDate BETWEEN :startDate AND :endDate", Ticket.class);
        query.setParameter("startDate", startDate);
        query.setParameter("endDate", endDate);
        return query.getResultList();

    }

    public List<Ticket> findTicketsComplete(int sales_id, LocalDate startDate, LocalDate endDate) {
        TypedQuery<Ticket> query = em.createQuery(
                "SELECT t FROM Ticket t WHERE t.sales.sales_id = :salesId AND t.issueDate BETWEEN :startDate AND :endDate", Ticket.class);
        query.setParameter("salesId", sales_id);
        query.setParameter("startDate", startDate);
        query.setParameter("endDate", endDate);
        return query.getResultList();
    }

    public long countValidatedTicketsByVehicleId(int vehicleId) {
        TypedQuery<Long> query = em.createQuery(
                "SELECT COUNT(t) FROM Ticket t WHERE t.sales.vehicle.id = :vehicleId AND t.validation = :validatedStatus", Long.class);
        query.setParameter("vehicleId", vehicleId);
        query.setParameter("validatedStatus", Validation.VALIDATED);
        return query.getSingleResult();
    }
}
