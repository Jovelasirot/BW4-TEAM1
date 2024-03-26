package DAO;

import entities.Card;
import entities.User;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;

public class CardDAO {
    private final EntityManager em;


    public CardDAO(EntityManager em) {
        this.em = em;
    }

    public void save(Card card){
        EntityTransaction transaction = em.getTransaction();
        transaction.begin();
        em.persist(card);
        transaction.commit();
        System.out.println("The card: " + card.getCardNumber() + ", has been correctly saved");
    }

    public Card findById(long card_id){
        Card card = em.find(Card.class,card_id);
        return card;
    }
}
