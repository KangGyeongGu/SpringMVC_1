package hello.servlet.web.springmvc.v1;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.io.IOException;

/*
* @Controller (또는 @Component + @RequestMapping)
*   : Spring이 자동으로 Spring Bean으로 등록한다. (내부에 @Component가 있어서 자동으로 컴포넌트 스캔 대상으로 지정된다.)
*       Spring MVC에서 어노테이션 기반 컨트롤러로 인식한다. -> 'RequestMappingHandlerMapping'에서 핸들러 대상이 된다.
* */
@Controller
public class SpringMemberFormControllerV1 {

    /*
    * @RequestMapping
    *   : 요청 정보를 매핑한다. 해당 URL이 호출되면 이 메서드가 호출된다.
    *       어노테이션을 기반으로 동작하기 때문에 메서드명은 임의로 지을 수 있다.
    * */
    @RequestMapping("/springmvc/v1/members/new-form")
    public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("SpringMemberFormControllerV1.handleRequest");

        /*
        * ModelAndView
        *   : 모델과 뷰의 정보를 담아서 반환하면 된다.
        * */
        return new ModelAndView("new-form");
    }
}
