package hello.springMVC2.basic.requestmapping;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/mapping/users")
public class MappingClassController {

    // 회원 목록 조회
    @GetMapping
    public String user() {
        return "get users";
    }

    // 회원 등록
    @PostMapping
    public String addUser() {
        return "post user";
    }

    // 회원 조회
    @GetMapping("/{userId}")
    public String findUser(@PathVariable String userId) {
        return "get userId = " + userId;
    }

    // 회원 수정
    @PatchMapping("/{userId}")
    public String updateUsers(@PathVariable String userId) {
        return "update userId = " + userId;
    }

    // 회원 삭
    @DeleteMapping("/{userId}")
    public String deleteUsers(@PathVariable String userId) {
        return "delete userId = " + userId;
    }
}
