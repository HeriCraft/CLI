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

            //getting Admin
            System.out.println("+++++++++++++++++++++++++++++++++++++++++++++++++++++++++");
            System.out.println("Getting Admin by name");
            System.out.println("+++++++++++++++++++++++++++++++++++++++++++++++++++++++++");
            Admin adm = aid.getAdminByName(name);


            //getting HL by adm
            System.out.println("+++++++++++++++++++++++++++++++++++++++++++++++++++++++++");
            System.out.println("Getting HL by Admin name");
            System.out.println("+++++++++++++++++++++++++++++++++++++++++++++++++++++++++");
            HL hl = hid.getHLByAdmin(adm.getIdAdmin());

            //checking pass by these two
            System.out.println("+++++++++++++++++++++++++++++++++++++++++++++++++++++++++");
            System.out.println("Checking passwor by these all");
            System.out.println("+++++++++++++++++++++++++++++++++++++++++++++++++++++++++");

            boolean b = cid.getCodeByAdmin(adm, hl, pass);
            System.out.println("//////////////////////////////////////////////////////////////");
            System.out.println(b);
            System.out.println("//////////////////////////////////////////////////////////////");
            if(b) {
                System.out.println("!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
                System.out.println("Mirotsaka ny fahasoavana!!! XD");
                System.out.println("!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
                return adm;
            }
        }catch(Exception e){
            e.printStackTrace();
        }

        return null;
    }
}
