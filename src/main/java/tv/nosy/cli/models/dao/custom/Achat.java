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
    private long reference;

    @OneToMany(mappedBy = "ref_achat")
    private List<Box> marchandise;

    @ManyToMany(mappedBy = "bon_achat")
    private List<Client> acheteur;

    @Column(name = "DATE")
    private Date dt;

}
