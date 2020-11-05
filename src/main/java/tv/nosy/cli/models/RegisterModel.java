package tv.nosy.cli.models;

import tv.nosy.cli.models.dao.Admin;
import tv.nosy.cli.models.dao.Cd;
import tv.nosy.cli.models.services.AdminImplDAO;

public class RegisterModel {
    private AdminImplDAO aid = new AdminImplDAO();

    public boolean isMatch(Admin a, Cd c){
        
        return false;
    }
}
