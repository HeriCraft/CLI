package tv.nosy.cli.models.dao;

import java.io.Serializable;
import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
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
    @OneToOne
    @JoinColumn(name = "idAdmin")
    private Admin admin;

    @OneToOne
    @JoinColumn(name = "idCd")
    private Cd c;

    @Column(name = "LAST_LOGIN")
    private Date date;

    @Column(name = "KEY_VALUE")
    private String keyValue;

    public HL() {
    }

    public HL(Admin admin, Cd c, Date date, String keyValue) {
        this.admin = admin;
        this.c = c;
        this.date = date;
        this.keyValue = keyValue;
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
