package hello.servlet.web.servletmvc;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet(name = "mvcMemberFormServlet", urlPatterns = "/servlet-mvc/members/new-form")
public class MvcMemberFormServlet extends HttpServlet {

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String viewPath = "/WEB-INF/views/new-form.jsp";
        RequestDispatcher dispatcher = req.getRequestDispatcher(viewPath); // Controller -> View 이동 시 사용
        dispatcher.forward(req, resp); // 다른 Servlet 또는 JSP로 이동할 수 있는 기능, 서버 내부에서 다시 호출이 발생한다.
    }
}

/*
* Redirect vs Forward?
* Redirect : 실제 클라이언트(웹 브라우저)에 응답이 나갔다가, 클라이언트가 redirect 경로로 재요청한다.
* 따라서 클라이언트가 인지할 수 있고, URL 경로도 실제로 변경된다.
* Forward : 서버 내부에서 일어나는 호출로, 클라이언트가 전혀 인지하지 못한다.
* */