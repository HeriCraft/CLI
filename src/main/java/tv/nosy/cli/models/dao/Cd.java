package tv.nosy.cli.models.dao;

import java.io.Serializable;
import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Formatter;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
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

    public void setCode(String cd) throws NoSuchAlgorithmException {
        String pass = "";
        try {
            MessageDigest crypt = MessageDigest.getInstance("SHA-1");
            crypt.reset();
            crypt.update(cd.getBytes("UTF-8"));
            pass = byteToHex(crypt.digest());
        } catch (Exception e) {
            System.out.println("Misy olana");
            e.printStackTrace();
        }


        this.code = pass;
    }

    private String byteToHex(byte[] hash) {
        Formatter formatter = new Formatter();
        for (byte b : hash)
        {
            formatter.format("%02x", b);
        }
        String result = formatter.toString();
        formatter.close();
        return result;
    }
    
    
}
