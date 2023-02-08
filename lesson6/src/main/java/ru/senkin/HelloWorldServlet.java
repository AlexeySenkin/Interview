package ru.senkin;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

//http://localhost:8080/hello
@WebServlet("/")
public class HelloWorldServlet extends HttpServlet {

    private final Logger logger = LoggerFactory.getLogger(HelloWorldServlet.class);

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        logger.debug("Log: hello world");

        resp.setContentType("text/html");

        PrintWriter out = resp.getWriter();

        out.printf("<html><body>");
        out.printf("<h1> HelloWorld </h1>");
        out.printf("</body></html>");
        out.close();

    }
}