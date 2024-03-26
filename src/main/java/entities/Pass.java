package entities;

import enums.PassDuration;
import jakarta.persistence.*;

@Entity
@Table(name = "Pass")
public class Pass {
    @Id
    @GeneratedValue
    private long Pass_id;
    @Enumerated(EnumType.STRING)
    private PassDuration passDuration;
    @ManyToOne
    private Sales Isssue_id;
    private int IssueDate;
    @ManyToOne
    @JoinColumn(name = "card_number")
    private Card card;


    public Pass() {
    }

    public Pass( PassDuration passDuration,  int issueDate) {

        this.passDuration = passDuration;

        IssueDate = issueDate;

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

    public Sales getIsssue_id() {
        return Isssue_id;
    }

    public void setIsssue_id(Sales isssue_id) {
        Isssue_id = isssue_id;
    }

    public int getIssueDate() {
        return IssueDate;
    }

    public void setIssueDate(int issueDate) {
        IssueDate = issueDate;
    }

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
                ", Isssue_id=" + Isssue_id +
                ", IssueDate=" + IssueDate +
                ", card=" + card +
                '}';
    }
}
