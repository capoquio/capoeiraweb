package capoeira.capoeiraweb.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/capoeiraweb")
public class HederController {
    @GetMapping("")
    public String index() {
        return "index"; //=>templates 폴더의 index.html을 찾아감
    }
    //아바다 카포에이라 페이지 출력 요청
    @GetMapping("/abada")
    public String abada() {
        return "abada_capoeira";
    }

    @GetMapping("/abadamap")
    public String abadamap() {
        return "abada_capoeiramap";
    }
    @GetMapping("/abadamapp")
    public String abadamapp() {
        return "abada_capoeiramapp";
    }
    //무젠자 카포에이라 페이지 출력 요청
    @GetMapping("/muzenza")
    public String muzenza() {
        return "muzenza_capoeira";
    }

    @GetMapping("/muzenzamap")
    public String muzenzamap() {
        return "muzenza_capoeiramap";
    }

    //로그인 페이지
    @GetMapping("/login")
    public String loginForm() {
        return "login";
    }

    //커뮤니티 페이지
    @GetMapping("/cmniti")
    public String cmniti() {
        return "cmniti";
    }

}