package hello.springMVC2.basic.response;

import hello.springMVC2.basic.HelloData;
import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;

@Slf4j
@Controller
//@ResponseBody : 클래스 레벨에 붙이면 전체 메서드에 적용된다.
//@RestController : @Controller + @ResponseBody
public class ResponseBodyController {

    // 서블릿을 직접 다룰 때 처럼
    @GetMapping("/response-body-string-v1")
    public void responseBodyV1(HttpServletResponse response) throws IOException {
        response.getWriter().write("ok");
    }

    // ResponseEntity<T> 엔티티 사용하여 응답 코드 설정하기
    @GetMapping("/response-body-string-v2")
    public ResponseEntity<String> responseBodyV2(HttpServletResponse response) throws IOException {
        return new ResponseEntity<>("ok", HttpStatus.OK);
    }

    // @ResponseBody : View를 사용하지 않고, HTTP 메시지를 직접 입력할 수 있다.
    @ResponseBody
    @GetMapping("/response-body-string-v3")
    public String responseBodyV3() {
        return "ok";
    }

    // ResponseEntity를 반환한다. HTTP 메시지 컨버터를 이용해서 내부적으로 JSON 형식으로 변환 후 반환된다.
    @GetMapping("/response-body-json-v1")
    public ResponseEntity<HelloData> responseBodyJsonV1() {
        HelloData helloData = new HelloData();
        helloData.setUsername("userA");
        helloData.setAge(20);

        return new ResponseEntity<>(helloData, HttpStatus.OK);
    }


    // @ResponseBody 사용 시 HTTP 응답 코드 설정이 까다롭다.
    @ResponseStatus(HttpStatus.OK) // 이 어노테이션을 사용해서 응답 코드를 설정할 수 있다. 하지만 동적으로 변경할 수 는 없다.
    @ResponseBody
    @GetMapping("/response-body-json-v2")
    public HelloData responseBodyJsonV2() {
        HelloData helloData = new HelloData();
        helloData.setUsername("userA");
        helloData.setAge(20);

        return helloData; // 응답 상태 코드를 바꿀 수 없어서 어노테이션을 사용한다.
    }
}
