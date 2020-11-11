package tv.nosy.cli.models;

import tv.nosy.cli.models.dao.Admin;
import tv.nosy.cli.models.dao.HL;
import tv.nosy.cli.models.services.AdminImplDAO;
import tv.nosy.cli.models.services.CImplDAO;
import tv.nosy.cli.models.services.HLImplDAO;

public class LoginModel {

    private static AdminImplDAO aid = new AdminImplDAO();
    private static CImplDAO cid = new CImplDAO();
    private static HLImplDAO hid = new HLImplDAO();

    public static Admin auth(String name, String pass){
        try{

            Admin adm = aid.getAdminByName(name);
            HL hl = hid.getHLByAdmin(adm.getIdAdmin());
            boolean b = cid.getCodeByAdmin(adm, hl, pass);
            if(b) {
                return adm;
            }
        }catch(Exception e){
            e.printStackTrace();
        }

        return null;
    }
}
