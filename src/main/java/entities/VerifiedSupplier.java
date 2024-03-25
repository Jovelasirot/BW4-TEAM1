package entities;

import jakarta.persistence.*;

@Entity
//@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public class VerifiedSupplier extends Sales{


    protected String supplierName;


    public VerifiedSupplier() {}

    public VerifiedSupplier(int id,String supplierName) {
        super(id);
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
