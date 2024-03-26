package entities;

import jakarta.persistence.*;

@Entity
public class VerifiedSupplier extends Sales{


    protected String supplierName;


    public VerifiedSupplier() {}

    public VerifiedSupplier(String supplierName) {
//        super(id);
        this.supplierName = supplierName;
    }

    @Override
    public String toString() {
        return "VerifiedSupplier{" +
                ", supplierName='" + supplierName + '\'' +
                ", id=" + id +
                '}';
    }
}
