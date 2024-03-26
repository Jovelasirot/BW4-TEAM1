package DAO;

import entities.Card;
import entities.User;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;

import java.util.List;

public class CardDAO {
    private final EntityManager em;


    public CardDAO(EntityManager em) {
        this.em = em;
    }

    public void save(Card card) {
        EntityTransaction transaction = em.getTransaction();
        transaction.begin();
        em.persist(card);
        transaction.commit();
        System.out.println("The card: " + card.getCardNumber() + ", has been correctly saved");
    }

    public Card findById(long cardNumber) {
        Card card = em.find(Card.class, cardNumber);
        return card;
    }
}


