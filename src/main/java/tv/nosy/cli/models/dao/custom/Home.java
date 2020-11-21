package tv.nosy.cli.models.dao.custom;

import java.util.List;

import tv.nosy.cli.models.dao.Admin;


public class Home {
    private Admin admin;
    private List<Client> cli;
    private List<Box> box;

    public Home() {
    }

    public Home(Admin admin, List<Client> cli, List<Box> box) {
        this.admin = admin;
        this.cli = cli;
        this.box = box;
    }
    public Home(List<Client> cli, List<Box> box){
        this.cli = cli;
        this.box = box;
    }

    public Admin getAdmin() {
        return admin;
    }

    public void setAdmin(Admin admin) {
        this.admin = admin;
    }

    public List<Client> getCli() {
        return cli;
    }

    public void setCli(List<Client> cli) {
        this.cli = cli;
    }

    public List<Box> getBox() {
        return box;
    }

    public void setBox(List<Box> box) {
        this.box = box;
    }

    
}
