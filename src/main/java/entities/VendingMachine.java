package entities;

import enums.status;
import jakarta.persistence.*;

@Entity
@Table(name = "vending_machine")
public class VendingMachine extends Sales{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int vendingMachine_id;
    @Enumerated(EnumType.STRING)
    private status status;



    public VendingMachine() {}
    public VendingMachine(int id, status status) {
        super(id);
    this.status =status;
    }

    @Override
    public String toString() {
        return "VendingMachine{" +
                "id=" + id +
                ", status=" + status +
                ", Sales id=" + id +
                '}';
    }
}
