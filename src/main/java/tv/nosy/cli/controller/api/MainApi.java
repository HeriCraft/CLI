package tv.nosy.cli.controller.api;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import tv.nosy.cli.models.dao.custom.Home;
import tv.nosy.cli.models.services.custom.API;
import tv.nosy.cli.models.utilities.LoginInfo;

@RestController
public class MainApi {
    

    @GetMapping("/api/home")
    public ResponseEntity<Home> home(){
        Home res = API.getAllInfos();
        return ResponseEntity.ok(res);
    }

    @PostMapping("/api/auth")
    public ResponseEntity<Home> auth(@RequestBody LoginInfo info){
        Home res = API.getAllInfos(info);
        return ResponseEntity.ok(res);
    }
}
