package tv.nosy.cli.models;

import tv.nosy.cli.models.dao.Admin;
import tv.nosy.cli.models.dao.Cd;
import tv.nosy.cli.models.services.AdminImplDAO;
import tv.nosy.cli.models.services.CImplDAO;
import tv.nosy.cli.models.services.HLImplDAO;

public class RegisterModel {
    private static AdminImplDAO aid = new AdminImplDAO();
    private static CImplDAO cid = new CImplDAO();
    private static HLImplDAO hid = new HLImplDAO();

    public static boolean register(Admin a, Cd c) {
        try {
            aid.addAdmin(a);
            cid.addCode(c);
            hid.addHL(a, c);
        }catch(Exception e){
            e.printStackTrace();
        }
        return false;
    }
}
