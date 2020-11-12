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
    private long reference;

    @ManyToOne
    @JoinColumn(name = "reference", nullable = true)
    private Subscription abonnement;

    @ManyToOne
    @JoinColumn(name = "reference", nullable = true)
    private Box box;

    @Column(name = "DATE")
    private Date date;

}
