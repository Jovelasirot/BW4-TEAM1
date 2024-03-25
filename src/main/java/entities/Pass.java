package entities;

import jakarta.persistence.*;

@Entity
@Table(name = "Pass")
public class Pass {
    @Id
    @GeneratedValue
    private long Pass_id;
    @Enumerated(EnumType.STRING)
    private PassDuration passDuration;
    private int CardNumber;
    private int IssueDate;
    @ManyToOne
    private long IssueId;


    public Pass(){}
    public Pass( PassDuration passDuration, int cardNumber, int issueDate, long issueId) {

        this.passDuration = passDuration;
        CardNumber = cardNumber;
        IssueDate = issueDate;
        IssueId = issueId;
    }

    public long getId() {
        return Pass_id;
    }

    public void setId(long id) {
        this.Pass_id = id;
    }

    public PassDuration getPassDuration() {
        return passDuration;
    }

    public void setPassDuration(PassDuration passDuration) {
        this.passDuration = passDuration;
    }

    public int getCardNumber() {
        return CardNumber;
    }

    public void setCardNumber(int cardNumber) {
        CardNumber = cardNumber;
    }

    public int getIssueDate() {
        return IssueDate;
    }

    public void setIssueDate(int issueDate) {
        IssueDate = issueDate;
    }

    public long getIssueId() {
        return IssueId;
    }

    public void setIssueId(long issueId) {
        IssueId = issueId;
    }


    @Override
    public String toString() {
        return "Pass{" +
                "id=" + Pass_id +
                ", passDuration=" + passDuration +
                ", CardNumber=" + CardNumber +
                ", IssueDate=" + IssueDate +
                ", IssueId=" + IssueId +
                '}';
    }
}
