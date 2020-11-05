package tv.nosy.cli.models;

import tv.nosy.cli.models.dao.Admin;
import tv.nosy.cli.models.dao.Cd;
import tv.nosy.cli.models.services.AdminImplDAO;
import tv.nosy.cli.models.services.CImplDAO;

public class RegisterModel {
    private AdminImplDAO aid = new AdminImplDAO();
    private CImplDAO cid = new CImplDAO();

    public boolean register(Admin a, Cd c){
        try{
            aid.addAdmin(a);
            cid.addCode(c);
        }catch(Exception e){
            e.printStackTrace();
        }
        return false;
    }
}
