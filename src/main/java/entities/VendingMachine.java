package entities;

import enums.status;
import jakarta.persistence.*;

@Entity
//@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public class VendingMachine extends Sales{


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
