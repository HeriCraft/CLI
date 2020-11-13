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
    private Long id;

    @Column(name = "NAME")
    private String name;

    @Column(name = "TEL")
    private String tel;

    @Column(name = "MAIL")
    private String mail;

    @ManyToMany
    @JoinColumn(name = "references", nullable = true)
    private List<Achat> bon_achat;

    public Client() {
    }

    public Client(Long id, String name, String tel, String mail, List<Achat> bon_achat) {
        this.id = id;
        this.name = name;
        this.tel = tel;
        this.mail = mail;
        this.bon_achat = bon_achat;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public List<Achat> getBon_achat() {
        return bon_achat;
    }

    public void setBon_achat(List<Achat> bon_achat) {
        this.bon_achat = bon_achat;
    }

}
