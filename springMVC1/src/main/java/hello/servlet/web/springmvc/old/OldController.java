package hello.servlet.web.springmvc.old;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

/*
* 어노테이션 이전 구버전 : org.springframework.web.servlet.mvc.Controller
*
* 이 컨트롤러가 호출되려면 다음 두 가지가 필요하다.
* 1. HandlerMapping(핸들러 매핑)
*   : 핸들러 매핑에서 이 컨트롤러를 찾을 수 있어야 한다.
*   예) "스프링 빈의 이름으로 핸들러를 찾을 수 있는 핸들러 매핑"이 필요하다.
* 2. HandlerAdapter(핸들러 어댑터)
*   : 핸들러 매핑을 통해서 찾은 핸들러를 '실행'할 수 있는 핸들러 어댑터가 필요하다.
*   예) 'Controller' 인터페이스를 실행할 수 있는 핸들러 어댑터를 찾고 실행해야 한다.
*
* ==> 스프링은 이미 필요한 핸들러 매핑과 어댑터를 대부분 구현해두었다.
*       개발자가 직접 핸들러 매핑과 핸들러 어댑터를 만드는 일은 거의 없다.
* */
@Component("/springmvc/old-controller")
public class OldController implements Controller {

    @Override
    public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
        System.out.println("OldController.handleRequest");

        /*
        * 컨트롤러는 정상 호출되지만 Whitelabel Error Page 오류가 발생한다.
        * '뷰 리졸버 - InternalResourceViewResolver'
        *   : 스프링 부트는 'InternalResourceViewResolver'라는 뷰 리졸버를 자동으로 등록하는데,
        *       이때 'application.properties'에 등록한 'spring.mvc.view.prefix', 'spring.mvc.view.suffix' 설정 정보를 사용하여 등록한다.
        *
        * 1. 핸들러 어댑터 호출
        *   : 핸들러 어댑터를 통해 'new-form'이라는 논리 뷰 이름을 획득한다.
        *
        * 2. 'ViewResolver' 호출
        *   : 'new-form'이라는 뷰 이름으로 viewResolver를 순서대로 호출한다.
        *       'BeanNameViewResolver'는 'new-form'이라는 이름의 스프링 빈으로 등록된 뷰를 찾아야 하는데 없기 때문에,
        *       'InternalResourceViewResolver'가 호출된다.
        *
        * 3. 'InternalResourceViewResolver'
        *   : 이 뷰 리졸버는 'InternalResourceView'를 반환한다.
        *
        * 4. 뷰 - 'InternalResourceView'
        *   : 'InternalResourceView'는 JSP 처럼 forward()를 호출하여 처리할 수 있는 경우에 사용한다.
        *
        * 5. 'view.render()'
        *   : view.render()가 호출되고, InternalResourceView는 forward()를 사용해서 JSP를 실행한다.
        * */
        return new ModelAndView("new-form");
    }
}
