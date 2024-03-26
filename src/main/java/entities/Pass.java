package entities;

import enums.PassDuration;
import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
@Table(name = "Pass")
public class Pass {
    @Id
    @GeneratedValue
    private long Pass_id;
    @Enumerated(EnumType.STRING)
    private PassDuration passDuration;
    @ManyToOne
    private Sales Issue_id;
    private LocalDate IssueDate;
    @ManyToOne
    @JoinColumn(name = "card_id")
    private Card card;


    public Pass() {
    }

    public Pass( PassDuration passDuration,  LocalDate issueDate,Card card, Sales issue_id) {

        this.passDuration = passDuration;

        this.IssueDate = issueDate;
        this.card = card;
        this.Issue_id = issue_id;

    }

    public long getPass_id() {
        return Pass_id;
    }

    public void setPass_id(long pass_id) {
        Pass_id = pass_id;
    }

    public PassDuration getPassDuration() {
        return passDuration;
    }

    public void setPassDuration(PassDuration passDuration) {
        this.passDuration = passDuration;
    }

//    public Sales getIsssue_id() {
//        return Isssue_id;
//    }
//
//    public void setIsssue_id(Sales isssue_id) {
//        Isssue_id = isssue_id;
//    }

//    public int getIssueDate() {
//        return IssueDate;
//    }
//
//    public void setIssueDate(int issueDate) {
//        IssueDate = issueDate;
//    }

    public Card getCard() {
        return card;
    }

    public void setCard(Card card) {
        this.card = card;
    }

    @Override
    public String toString() {
        return "Pass{" +
                "Pass_id=" + Pass_id +
                ", passDuration=" + passDuration +
//                ", Isssue_id=" + Isssue_id +
                ", IssueDate=" + IssueDate +
                ", card=" + card +
                '}';
    }
}
