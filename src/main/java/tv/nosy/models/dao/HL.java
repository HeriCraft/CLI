package tv.nosy.models.dao;

import java.io.Serializable;
import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.MapsId;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "HistoryLogin")
public class HL implements Serializable{

    /**
     *
     */
    private static final long serialVersionUID = 1L;
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "REF")
    private long reference;

    @OneToOne
    @MapsId
    @JoinColumn(name = "idAdmin")
    @Column(name = "USR")
    private Admin admin;

    @OneToOne
    @MapsId
    @JoinColumn(name = "idCd")
    @Column(name = "pwd")
    private Cd c;

    @Column(name = "LAST_LOGIN")
    private Date date;

    @Column(name = "KEY_VALUE")
    private String keyValue;

    public HL() {
    }

    public HL(long reference, Admin admin, Cd c, Date date, String keyValue) {
        this.reference = reference;
        this.admin = admin;
        this.c = c;
        this.date = date;
        this.keyValue = keyValue;
    }

    public long getReference() {
        return reference;
    }

    public void setReference(long reference) {
        this.reference = reference;
    }

    public Admin getAdmin() {
        return admin;
    }

    public void setAdmin(Admin admin) {
        this.admin = admin;
    }

    public Cd getC() {
        return c;
    }

    public void setC(Cd c) {
        this.c = c;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getKeyValue() {
        return keyValue;
    }

    public void setKeyValue(String keyValue) {
        this.keyValue = keyValue;
    }
}
