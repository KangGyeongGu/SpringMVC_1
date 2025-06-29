package hello.servlet.web.springmvc.v3;

import hello.servlet.domain.member.Member;
import hello.servlet.domain.member.MemberRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/springmvc/v3/members")
public class SpringMemberControllerV3 {

    private final MemberRepository memberRepository = MemberRepository.getInstance();

    @GetMapping("/new-form") // @RequestMapping(value = "/new-form", method = RequestMethod.GET)
    public String newForm() {
        return "new-form";
    }

    @GetMapping // @RequestMapping
    public String members(Model model) {
        List<Member> members = memberRepository.findAll();
        model.addAttribute("members", members);
        return "members";
    }

    @PostMapping("/save") // @RequestMapping(value = "/save", method = RequestMethod.POST)
    public String save(
            @RequestParam("username") String username,
            @RequestParam("age") int age,
        Model model) {

        Member member = new Member(age, username);
        memberRepository.save(member);

        model.addAttribute("member", member);
        return "save-result";
    }

}
