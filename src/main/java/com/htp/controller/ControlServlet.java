package com.htp.controller;

import com.htp.repository.HibernateUserDao;
import lombok.RequiredArgsConstructor;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@RequiredArgsConstructor
@WebServlet("/controlservlet")
public class ControlServlet extends HttpServlet {

    private final HibernateUserDao hibernateUserDao;

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        String[] actionType = request.getParameterValues("checkbox");
        if (request.getParameter("block")!=null) {
            hibernateUserDao.block(actionType);
        } else if (request.getParameter("unblock")!=null) {
            hibernateUserDao.unblock(actionType/*,hibernateUserList*/);
        } else if (request.getParameter("delete")!=null) {
            hibernateUserDao.delete(actionType);
        }
        response.setContentType("text/html;charset=utf-8");
        PrintWriter out = response.getWriter();
        out.print("<!DOCTYPE HTML>\n" +
                "<html>\n" +
                "<head>\n" +
                "    <script>\n" +
                "        history.go(-1);\n" +
                "    </script>\n" +
                "</head>\n" +
                "<body>\n" +
                "</body>\n" +
                "</html>");
        out.close();
    }
}