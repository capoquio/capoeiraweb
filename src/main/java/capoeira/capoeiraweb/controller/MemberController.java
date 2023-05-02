package capoeira.capoeiraweb.controller;

import capoeira.capoeiraweb.dto.MemberDTO;
import capoeira.capoeiraweb.service.MemberService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;


@Controller
@RequiredArgsConstructor
@RequestMapping("/capoeiraweb")
public class MemberController {
    //생성자 주입
    private final MemberService memberService;


    //회원가입 페이지 출력 요청
    @GetMapping("/login_info")
    public String login_info() {

        return "login_info";
    }

    @PostMapping("/login_info")
    public String login_info(@ModelAttribute MemberDTO memberDTO) {
        System.out.println("MemberController.save");
        System.out.println("memberDTO = " + memberDTO);
        memberService.login_info(memberDTO);
        return "index";
    }

    //로그인 성공 실패
    @PostMapping("/login")
    public String login(@ModelAttribute MemberDTO memberDTO, HttpSession session) {
        MemberDTO loginResult = memberService.login(memberDTO);
        if (loginResult != null) {
            //login 성공
            session.setAttribute("loginNickname", loginResult.getNickname());
            System.out.println("성공");
            return "index";
        }else {
            //login 실패
            System.out.println("실패");
            return "login";
        }
    }

    @GetMapping("/logout")
    public String logout(HttpSession session) {
        session.invalidate();
        return "index";
    }

    @PostMapping("/member/idCheck")
    public @ResponseBody String idCheck(@RequestParam("id") String id) {
        System.out.println("id = " + id);
        String checkResult = memberService.idChenk(id);
        if (checkResult != null) {
            return "ok";
        }else {
            return "no";
        }
    }
}

