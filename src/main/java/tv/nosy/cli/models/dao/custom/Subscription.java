package tv.nosy.cli.models.dao.custom;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "SUBS")
public class Subscription implements Serializable{

    /**
     *
     */
    private static final long serialVersionUID = -6642071325109409466L;

    @Id
    @Column(name = "REF")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long reference;

    @Column(name = "NAME")
    private String name;

    @Column(name = "PRICE")
    private long price;
    
    @OneToMany(mappedBy = "abonnement")
    private List<ReSubscription> ref_abnm;

    public Subscription(long reference, String name, long price, List<ReSubscription> ref_abnm) {
        this.reference = reference;
        this.name = name;
        this.price = price;
        this.ref_abnm = ref_abnm;
    }

    public long getReference() {
        return reference;
    }

    public void setReference(long reference) {
        this.reference = reference;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public long getPrice() {
        return price;
    }

    public void setPrice(long price) {
        this.price = price;
    }

    public List<ReSubscription> getRef_abnm() {
        return ref_abnm;
    }

    public void setRef_abnm(List<ReSubscription> ref_abnm) {
        this.ref_abnm = ref_abnm;
    }

}
