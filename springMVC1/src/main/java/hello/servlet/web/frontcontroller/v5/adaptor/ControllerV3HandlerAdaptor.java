package hello.servlet.web.frontcontroller.v5.adaptor;

import hello.servlet.web.frontcontroller.ModelView;
import hello.servlet.web.frontcontroller.v3.ControllerV3;
import hello.servlet.web.frontcontroller.v5.MyHandlerAdaptor;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/*
* 핸들러
*   : 컨트롤러 이름을 더 넓은 범위인 어댑터로 확장(변경)했다.
*      그 이유는 이제 어댑터(MyHandlerAdaptor)가 존재하기 때문에 꼭 컨트롤러의 개념 뿐 만 아니라 어떠한 것이든
*      해당하는 종류의 어댑터만 있다면 다 처리할 수 있기 때문이다.
*   : 이전에는 컨트롤러가 직접 URL을 매핑하여 사용했다. (ControllerV4 controller = controllerV4Map.get(requestURI);)
*      그런데 이제는 어댑터를 사용하기 때문에 컨트롤러 뿐 만 아니라 어댑터가 지원하기만 하면
*      어떤 것이라도 URL에 매핑해서 사용할 수 있게 되었다.
* */
public class ControllerV3HandlerAdaptor implements MyHandlerAdaptor {

    @Override
    public boolean supports(Object handler) {
        return (handler instanceof ControllerV3);
    }

    /*
    * HTTP 요청에 맞는 Handler를 찾아서 호출하면,
    * 해당 Handler에 맞는 Controller를 호출하여 Controller로 비즈니스 로직 수행 후 결과를 ModelView로 반환한다.
    * */
    @Override
    public ModelView handle(HttpServletRequest req, HttpServletResponse resp, Object handler) throws ServletException, IOException {
        ControllerV3 controllerV3 = (ControllerV3) handler;

        Map<String, String> paramMap = createParamMap(req);
        ModelView mv = controllerV3.process(paramMap);

        return mv;
    }

    private static Map<String, String> createParamMap(HttpServletRequest req) {
        Map<String, String> paramMap = new HashMap<>();
        req.getParameterNames().asIterator()
                .forEachRemaining(paramName -> paramMap.put(paramName, req.getParameter(paramName)));
        return paramMap;
    }
}
