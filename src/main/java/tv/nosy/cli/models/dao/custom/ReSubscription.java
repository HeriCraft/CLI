package tv.nosy.cli.models.dao.custom;

import java.io.Serializable;
import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "RESUBS")
public class ReSubscription implements Serializable{

    /**
     * 
     */
    private static final long serialVersionUID = 162561358444012680L;
    
    @Id
    @Column(name = "REF")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long ref;

    @ManyToOne
    @JoinColumn(name = "reference", insertable = false, updatable = false)
    private Subscription abonnement;

    @ManyToOne
    @JoinColumn(name = "reference", insertable = false, updatable = false)
    private Box box;

    @Column(name = "DATE")
    private Date date;

    public ReSubscription() {
    }

    public ReSubscription(Long ref, Subscription abonnement, Box box, Date date) {
        this.ref = ref;
        this.abonnement = abonnement;
        this.box = box;
        this.date = date;
    }

    public Long getRef() {
        return ref;
    }

    public void setRef(Long ref) {
        this.ref = ref;
    }

    public Subscription getAbonnement() {
        return abonnement;
    }

    public void setAbonnement(Subscription abonnement) {
        this.abonnement = abonnement;
    }

    public Box getBox() {
        return box;
    }

    public void setBox(Box box) {
        this.box = box;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

}
