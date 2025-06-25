package hello.servlet.basic.request;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.Enumeration;

/*
* HttpServletRequest를 통해서 HTTP message의 start-line, header 정보 조회하는 방법
* */
@WebServlet(name = "requestHeaderServlet", urlPatterns = "/request-header")
public class RequestHeaderServlet extends HttpServlet {

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        printStartLine(req);
        printHeaders(req);
        printHeaderUtils(req);
    }

    private void printStartLine(HttpServletRequest request) {

        /*
         * --- REQUEST-LINE - start ---
         * request.getMethod() = GET
         * request.getProtocol() = HTTP/1.1
         * request.getScheme() = http
         * request.getRequestURL() = http://localhost:8080/request-header
         * request.getRequestURI() = /request-header
         * request.getQueryString() = null
         * request.isSecure() = false
         * --- REQUEST-LINE - end ---
         * */
        System.out.println("--- REQUEST-LINE - start ---");
        System.out.println("request.getMethod() = " + request.getMethod()); //GET
        System.out.println("request.getProtocol() = " + request.getProtocol()); //HTTP/1.1
        System.out.println("request.getScheme() = " + request.getScheme()); //http
        // http://localhost:8080/request-header
        System.out.println("request.getRequestURL() = " + request.getRequestURL());
        // /request-header
        System.out.println("request.getRequestURI() = " + request.getRequestURI());
        //username=hi
        System.out.println("request.getQueryString() = " + request.getQueryString());
        System.out.println("request.isSecure() = " + request.isSecure()); //https 사용 유무
        System.out.println("--- REQUEST-LINE - end ---");
        System.out.println();
    }

    private void printHeaders(HttpServletRequest request) {

        /*
         * --- Headers - start ---
         * host: host
         * connection: connection
         * cache-control: cache-control
         * sec-ch-ua: sec-ch-ua
         * sec-ch-ua-mobile: sec-ch-ua-mobile
         * sec-ch-ua-platform: sec-ch-ua-platform
         * dnt: dnt
         * upgrade-insecure-requests: upgrade-insecure-requests
         * user-agent: user-agent
         * accept: accept
         * sec-fetch-site: sec-fetch-site
         * sec-fetch-mode: sec-fetch-mode
         * sec-fetch-user: sec-fetch-user
         * sec-fetch-dest: sec-fetch-dest
         * accept-encoding: accept-encoding
         * accept-language: accept-language
         * cookie: cookie
         * --- Headers - end ---
         * */

        System.out.println("--- Headers - start ---");

        // (1)
         Enumeration<String> headerNames = request.getHeaderNames();
         while (headerNames.hasMoreElements()) {
             String headerName = headerNames.nextElement();
             System.out.println(headerName + ": " + headerName);
         }

        // (2)
        request.getHeaderNames().asIterator()
                        .forEachRemaining(headerName -> System.out.println(headerName + ": " + headerName));

        System.out.println("--- Headers - end ---");
        System.out.println();
    }

    //Header 편리한 조회
    private void printHeaderUtils(HttpServletRequest request) {

        /*
         * --- Header 편의 조회 start ---
         * [Host 편의 조회]
         * request.getServerName() = localhost
         * request.getServerPort() = 8080
         *
         * [Accept-Language 편의 조회]
         * locale = ko
         * locale = ko_KR
         * locale = en
         * request.getLocale() = ko
         *
         * [cookie 편의 조회]
         * Idea-5cb4d96: 2e4a1c5a-7605-496b-b697-d2e43425e98b
         *
         * [Content 편의 조회]
         * request.getContentType() = null
         * request.getContentLength() = -1
         * request.getCharacterEncoding() = UTF-8
         * --- Header 편의 조회 end ---
         * */

        System.out.println("--- Header 편의 조회 start ---");
        System.out.println("[Host 편의 조회]");
        System.out.println("request.getServerName() = " +
                request.getServerName()); //Host 헤더
        System.out.println("request.getServerPort() = " +
                request.getServerPort()); //Host 헤더
        System.out.println();
        System.out.println("[Accept-Language 편의 조회]");
        request.getLocales().asIterator()
                .forEachRemaining(locale -> System.out.println("locale = " +
                        locale));
        System.out.println("request.getLocale() = " + request.getLocale());
        System.out.println();
        System.out.println("[cookie 편의 조회]");
        if (request.getCookies() != null) {
            for (Cookie cookie : request.getCookies()) {
                System.out.println(cookie.getName() + ": " + cookie.getValue());
            }
        }
        System.out.println();
        System.out.println("[Content 편의 조회]");
        System.out.println("request.getContentType() = " +
                request.getContentType());
        System.out.println("request.getContentLength() = " +
                request.getContentLength());
        System.out.println("request.getCharacterEncoding() = " +
                request.getCharacterEncoding());
        System.out.println("--- Header 편의 조회 end ---");
        System.out.println();
    }
}
