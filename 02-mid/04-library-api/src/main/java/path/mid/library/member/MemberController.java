
package path.mid.library.member;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/members")
public class MemberController {
    private final MemberRepository members;

    public MemberController(MemberRepository members) {
        this.members = members;
    }

    @GetMapping
    public List<Member> all() {
        return members.findAll();
    }

    @PostMapping
    public Member create(@RequestBody Member member) {
        member.setId(null);
        return members.save(member);
    }
}
