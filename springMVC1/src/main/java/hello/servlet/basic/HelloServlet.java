package hello.servlet.basic;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet(name = "helloServlet", urlPatterns = "/hello") // name, userMapping은 겹치면 안된다.
public class HelloServlet extends HttpServlet {


    /**
     * Spring Boot가 내장 Tomcat Server를 띄워주고,
     * Servlet Container에서 Servlet을 생성해준다.
     * 이후 웹 브라우저에서 요청을 보내면, 서버에서는 Request, Response 객체를 만들어서 HelloServlet을 호출한 후 객체를 넘겨준다.
     * */
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("HelloServlet.service"); // http url 요청 확인 출력

        System.out.println("request = " + req); // request = org.apache.catalina.connector.RequestFacade@42aaad7f
        System.out.println("response = " + resp); // response = org.apache.catalina.connector.ResponseFacade@5ee465a9

        String username = req.getParameter("username"); // url query parameter를 편리하게 추춣
        System.out.println("username = " + username); // username = kim

        resp.setContentType("text/plain");
        resp.setCharacterEncoding("utf-8");
        resp.getWriter().write("hello " + username);
    }
}
