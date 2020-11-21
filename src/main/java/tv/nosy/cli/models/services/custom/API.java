package tv.nosy.cli.models.services.custom;

import java.util.List;

import tv.nosy.cli.models.LoginModel;
import tv.nosy.cli.models.dao.Admin;
import tv.nosy.cli.models.dao.custom.Box;
import tv.nosy.cli.models.dao.custom.Client;
import tv.nosy.cli.models.dao.custom.Home;
import tv.nosy.cli.models.utilities.LoginInfo;

public class API {
    private static BoxImp bid;
    private static ClientImpl cid;

    public static Home getAllInfos(LoginInfo info){

        try{
            Admin adm = LoginModel.auth(info.getUname(), info.getPass());
            if(adm == null){
                new Exception("Authentification no olana");
            }
            List<Box> box = bid.findAll();
            List<Client> cli = cid.findAll();
    
            return new Home(adm, cli, box);
        } catch (Exception e){
            e.printStackTrace();
        }

        return null;
    }
    public static Home getAllInfos(){

        try{
            List<Box> box = bid.findAll();
            List<Client> cli = cid.findAll();
    
            return new Home(cli, box);
        } catch (Exception e){
            e.printStackTrace();
        }

        return null;
    }
}
