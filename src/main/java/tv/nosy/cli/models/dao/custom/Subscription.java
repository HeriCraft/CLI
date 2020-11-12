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
    private List<ReSubscription> ref_ab;

}
