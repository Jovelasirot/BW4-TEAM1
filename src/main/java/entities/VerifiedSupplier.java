package entities;

import jakarta.persistence.*;

@Entity
@Table(name = "verified_supplier")
public class VerifiedSupplier extends Sales{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int verifiedSupplier_id;
    protected String supplierName;


    public VerifiedSupplier() {}

    public VerifiedSupplier(int id,String supplierName) {
        super(id);
        this.supplierName = supplierName;
    }

    @Override
    public String toString() {
        return "VerifiedSupplier{" +
                "verifiedSupplier_id=" + verifiedSupplier_id +
                ", supplierName='" + supplierName + '\'' +
                ", id=" + id +
                '}';
    }
}
