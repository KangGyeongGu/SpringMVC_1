package hello.servlet.web.frontcontroller.v1;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

/*
* 각각의 Controller 들은 이 인터페이스를 구현하면 된다.
* Front Controller는 이 인터페이스를 호출해서 '구현과 관계없이' 로직의 일관성을 가져갈 수 있다. => 다형성
* */
public interface ControllerV1 {

    void process(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException;
}
