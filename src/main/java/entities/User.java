package entities;

import jakarta.persistence.*;

@Entity
@Table(name ="users" )
public class User{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long user_id;
    private String name;
    private String surname;
//    @Column( name = "card_number")
//    private long cardNumber;
    @OneToOne
    @JoinColumn(name = "card_number")
    private Card card;


    public User(){}

    public User( String name, String surname) {
        this.name = name;
        this.surname = surname;

    }



    public long getUser_id() {
        return user_id;
    }


    public void setUser_Id(long user_id) {
        this.user_id = user_id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

//    public Card getCard() {
//        return card;
//    }
//
//    public void setCard(Card card) {
//        this.card = card;
//    }

    @Override
    public String toString() {
        return "User{" +
                "user_id=" + user_id +
                ", name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                '}';
    }
}
