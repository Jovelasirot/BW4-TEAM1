package DAO;

import entities.Pass;
import enums.PassDuration;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.TypedQuery;

import java.time.LocalDate;
import java.util.List;

public class PassDAO {
    private final EntityManager em;

    public PassDAO(EntityManager em) {
        this.em = em;
    }

    public void save(Pass pass) {
        EntityTransaction transaction = em.getTransaction();
        transaction.begin();
        em.persist(pass);
        transaction.commit();
        System.out.println("The pass with id: " + pass.getPass_id() + ", has been saved correctly");
    }

    public List<Pass> findPassesByIssueId(long issueId) {
        TypedQuery<Pass> query = em.createQuery(
                "SELECT p FROM Pass p WHERE p.Isssue_id.id = :issueId", Pass.class);
        query.setParameter("issueId", issueId);
        return query.getResultList();
    }

    public List<Pass> findPassesByIssueDateRange(LocalDate startDate, LocalDate endDate) {
        TypedQuery<Pass> query = em.createQuery(
                "SELECT p FROM Pass p WHERE p.IssueDate BETWEEN :startDate AND :endDate", Pass.class);
        query.setParameter("startDate", startDate);
        query.setParameter("endDate", endDate);
        return query.getResultList();
    }

    public List<Pass> findPassesComplete(long issueId, LocalDate startDate, LocalDate endDate) {
        TypedQuery<Pass> query = em.createQuery(
                "SELECT p FROM Pass p WHERE p.Isssue_id.id = :issueId AND p.IssueDate BETWEEN :startDate AND :endDate", Pass.class);
        query.setParameter("issueId", issueId);
        query.setParameter("startDate", startDate);
        query.setParameter("endDate", endDate);
        return query.getResultList();
    }

    public String checkPassValidity(Pass pass) {
        LocalDate today = LocalDate.now();
        LocalDate expiryDate;

        if (pass.getPassDuration() == PassDuration.MONTHLY) {
            expiryDate = pass.getIssueDate().plusDays(30);
        } else if (pass.getPassDuration() == PassDuration.WEEKLY) {
            expiryDate = pass.getIssueDate().plusDays(7);
        } else {
            throw new IllegalArgumentException("Unknown PassDuration value");
        }

        return today.isAfter(expiryDate) ? "Pass expired" : "Pass valid";
    }


}