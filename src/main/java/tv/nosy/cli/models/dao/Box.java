package tv.nosy.cli.models.dao;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
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
    @JoinColumn(name = "id")
    private Client client;

    @OneToOne
    @JoinColumn(name = "reference")
    private Subscription sub;

}
