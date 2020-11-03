package tv.nosy.models.dao;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

@Entity
@Table(name = "ADMIN")
public class Admin implements Serializable{

	/**
	 *
	 */
	private static final long serialVersionUID = 1L;
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private long idAdmin;

    @Column(name = "UNAME")
    private String username;

    @Column(name = "MAIL")
    private String mail;

    @OneToOne(mappedBy = "HL", cascade = CascadeType.ALL)
    @PrimaryKeyJoinColumn
    @Column(name = "H_FK")
    private HL history;


    public Admin() {
    }

    public Admin(long idAdmin, String username, String mail) {
        this.idAdmin = idAdmin;
        this.username = username;
        this.mail = mail;
    }

    public long getIdAdmin() {
        return idAdmin;
    }

    public void setIdAdmin(long idAdmin) {
        this.idAdmin = idAdmin;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

}
