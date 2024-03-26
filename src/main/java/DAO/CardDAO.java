package DAO;

import entities.Card;
import entities.User;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.TypedQuery;

import java.time.LocalDate;
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


        public String ValidityByUserId(long user_id) {
            LocalDate today = LocalDate.now();
            TypedQuery<Card> query = em.createQuery(
                    "SELECT c FROM Card c WHERE c.user.id = :user_id", Card.class);
            query.setParameter("user_id", user_id);
            Card card = query.getSingleResult();

            if (card.getExpiryDate().isAfter(today)) {
                return "Your card is valid.";
            } else {
                return "Your card IS NOT valid.";
            }
        }

    }



