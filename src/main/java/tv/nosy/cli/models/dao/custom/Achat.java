               package tv.nosy.cli.models.dao.custom;

import java.io.Serializable;
import java.sql.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "")
public class Achat implements Serializable{
    
    /**
     *
     */
    private static final long serialVersionUID = 4045080252350978327L;

    @Id
    @Column(name = "REF")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long reference;

    @OneToMany(mappedBy = "ref_achat")
    private List<Box> marchandise;

    @ManyToMany(mappedBy = "bon_achat")
    private List<Client> acheteur;

    @Column(name = "DATE")
    private Date dt;

    public Achat() {
    }

    public Achat(Long reference, List<Box> marchandise, List<Client> acheteur, Date dt) {
        this.reference = reference;
        this.marchandise = marchandise;
        this.acheteur = acheteur;
        this.dt = dt;
    }

    public Long getReference() {
        return reference;
    }

    public void setReference(Long reference) {
        this.reference = reference;
    }

    public List<Box> getMarchandise() {
        return marchandise;
    }

    public void setMarchandise(List<Box> marchandise) {
        this.marchandise = marchandise;
    }

    public List<Client> getAcheteur() {
        return acheteur;
    }

    public void setAcheteur(List<Client> acheteur) {
        this.acheteur = acheteur;
    }

    public Date getDt() {
        return dt;
    }

    public void setDt(Date dt) {
        this.dt = dt;
    }

}
