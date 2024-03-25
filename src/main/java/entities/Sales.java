package entities;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "sales")
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
public class Sales {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    protected int id;

    @OneToMany (mappedBy = "sales")
    private List<Ticket> tickets;

    @OneToMany (mappedBy = "Pass_id")
    private List<Pass> passes;


    public Sales() { }

    public Sales(int id) {
        this.id = id;
    }


}
