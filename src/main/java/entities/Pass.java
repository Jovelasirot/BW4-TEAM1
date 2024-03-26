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
    @JoinColumn
    private Sales Issue_id;
    private LocalDate IssueDate;
    @ManyToOne
    @JoinColumn
    private Card card;


    public Pass() {
    }

    public Pass(PassDuration passDuration,  LocalDate issueDate,Card card,Sales sales ) {

        this.passDuration = passDuration;

        IssueDate= issueDate;

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

    public Sales getIssue_id() {
        return Issue_id;
    }

    public void setIssue_id(Sales issue_id) {
        Issue_id = issue_id;
    }

    public LocalDate getIssueDate() {
        return IssueDate;
    }

    public void setIssueDate(LocalDate issueDate) {
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
                ", Issue_id=" + Issue_id +
                ", IssueDate=" + IssueDate +
                ", card=" + card +
                '}';
    }
}
