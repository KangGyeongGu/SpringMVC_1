package hello.servlet.web.frontcontroller.v5;

import hello.servlet.web.frontcontroller.ModelView;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

/*
* 핸들러 어댑터 : 중간 어댑터 역할을 하는 어댑터가 추가되었는데 이름이 핸들러 어댑터이다. 여기서 어댑터 역할을 해준 덕분에 다양한 종류의 컨트롤러를 호출할 수 있다.
* */
public interface MyHandlerAdaptor {

    boolean supports(Object handler);

    /*
    * (3) 해당 핸들러 호출
    * */
    ModelView handle(HttpServletRequest req, HttpServletResponse resp, Object handler) throws ServletException, IOException;
}
