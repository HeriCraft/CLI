package tv.nosy.cli.models.dao;

import java.io.Serializable;
import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

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
@Table(name = "CODES")
public class Cd implements Serializable {

    /**
     *
     */
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "REF")
    private long idCd;

    @Column(name = "PASS")
    private String code;

    @OneToOne(mappedBy = "c", cascade = CascadeType.ALL)
    private HL history;

    public Cd() {
    }

    public Cd(long idCd, String code) throws NoSuchAlgorithmException {
        this.idCd = idCd;
        this.setCode(code);
    }

    public long getIdCd() {
        return idCd;
    }

    public void setIdCd(long idCd) {
        this.idCd = idCd;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) throws NoSuchAlgorithmException {
        String pass = code;
        try {
            byte[] converti = code.getBytes("UTF-8");
            MessageDigest md = MessageDigest.getInstance("MD5");
            byte[] finalByte = md.digest(converti);

            pass = finalByte.toString();
        } catch (UnsupportedEncodingException e) {
            System.out.println("Misy olana");
            e.printStackTrace();
        }


        this.code = pass;
    }
    
    
}
