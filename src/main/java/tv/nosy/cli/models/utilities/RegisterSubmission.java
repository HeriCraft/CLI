package tv.nosy.cli.models.utilities;

public class RegisterSubmission {
    private String uname;
    private String mail;
    private String pass;

    public RegisterSubmission() {
    }

    public RegisterSubmission(String uname, String mail, String pass) {
        this.uname = uname;
        this.mail = mail;
        this.pass = pass;
    }

    public String getUname() {
        return uname;
    }

    public void setUname(String uname) {
        this.uname = uname;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }
}
