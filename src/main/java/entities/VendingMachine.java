package entities;

import enums.Status;
import jakarta.persistence.*;

@Entity

public class VendingMachine extends Sales{


    @Enumerated(EnumType.STRING)
    private Status status;



    public VendingMachine() {}
    public VendingMachine( Status status) {
//        super(id);
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
