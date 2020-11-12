package tv.nosy.cli.models.dao.custom;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name = "CLI")
public class Client implements Serializable{

    /**
     *
     */
    private static final long serialVersionUID = -3607580012274399598L;
    
    @Id
    @Column(name = "ID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "NAME")
    private String name;

    @Column(name = "TEL")
    private String tel;

    @Column(name = "MAIL")
    private String mail;

    @ManyToMany
    @JoinColumn(name = "references", nullable = true)
    private List<Achat> bon_achat;

}
