package hello.servlet.basic.request;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.Enumeration;

/*
* 1. 파라미터 전송 기능
* -> http://localhost:8080/request-param?username=hello&age=20
* [전체 파라미터 조회] - start
* username: hello
* age: 20
* [전체 파라미터 조회] - end
*
* 2. 이름이 같은 파라미터 중복
* -> http://localhost:8080/request-param?username=hello&age=20&username=hello2
* [이름이 같은 복수 파라미터 조회]
* username = hello
* username = hello2
* */
@WebServlet(name = "requestParamServlet", urlPatterns = "/request-param")
public class RequestParamServlet extends HttpServlet {

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        System.out.println("[전체 파라미터 조회] - start");

        req.getParameterNames().asIterator()
                        .forEachRemaining(paramName -> System.out.println(paramName + ": " + req.getParameter(paramName)));

        System.out.println("[전체 파라미터 조회] - end");
        System.out.println();

        System.out.println("[단일 파라미터 조회]");
        String username = req.getParameter("username");
        String age = req.getParameter("age");
        System.out.println("username = " + username);
        System.out.println("age = " + age);
        System.out.println();

        System.out.println("[이름이 같은 복수 파라미터 조회]");
        String[] usernames = req.getParameterValues("username");
        for (String name : usernames) {
            System.out.println("username = " + name);
        }
    }
}
