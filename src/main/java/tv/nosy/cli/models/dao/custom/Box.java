package tv.nosy.cli.models.dao.custom;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "BOX")
public class Box implements Serializable{

    /**
     *
     */
    private static final long serialVersionUID = 6354040234602187219L;

    @Id
    @Column(name = "REF")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long reference;

    @ManyToOne
    @JoinColumn(name = "reference", nullable = true)
    private Achat ref_achat;

    @OneToMany(mappedBy = "box")
    private List<ReSubscription> ref_ab;

}
