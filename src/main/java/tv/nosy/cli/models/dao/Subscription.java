package tv.nosy.cli.models.dao;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
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

    @OneToOne(mappedBy = "sub")
    private Box bx;
    
    public Subscription() {
    }


    
}
