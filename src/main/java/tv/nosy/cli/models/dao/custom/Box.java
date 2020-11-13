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
    private Long reference;

    @ManyToOne
    @JoinColumn(name = "reference", nullable = true)
    private Achat ref_achat;

    @OneToMany(mappedBy = "box")
    private List<ReSubscription> ref_abnm;

    public Box() {
    }

    public Box(Long reference, Achat ref_achat, List<ReSubscription> ref_abnm) {
        this.reference = reference;
        this.ref_achat = ref_achat;
        this.ref_abnm = ref_abnm;
    }

    public Long getReference() {
        return reference;
    }

    public void setReference(Long reference) {
        this.reference = reference;
    }

    public Achat getRef_achat() {
        return ref_achat;
    }

    public void setRef_achat(Achat ref_achat) {
        this.ref_achat = ref_achat;
    }

    public List<ReSubscription> getRef_abnm() {
        return ref_abnm;
    }

    public void setRef_abnm(List<ReSubscription> ref_abnm) {
        this.ref_abnm = ref_abnm;
    }

}
