package com.htp.controller;

import com.htp.domain.HibernateUser;
import com.htp.repository.HibernateUserDao;
import com.htp.repository.HibernateUserDaoImpl;
import com.htp.repository.HibernateUserRepository;
import lombok.RequiredArgsConstructor;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

@RequiredArgsConstructor
@WebServlet("/controlservlet")
public class ControlServlet extends HttpServlet {

    private final HibernateUserDao hibernateUserDao;
    private final HibernateUserRepository hibernateUserRepository;
    /*private static final long serialVersionUID = 1L;

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.service(req, resp);
    }

    @Override
    public void destroy() {
        super.destroy();
    }

    @Override
    public void init(ServletConfig config) throws ServletException {
        super.init(config);
    }*/

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
                "        autoRefresh();\n" +
                "    </script>\n" +
                "</head>\n" +
                "<body>\n" +
                "</body>\n" +
                "</html>");
        out.close();
    }

    /*@Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/");
        dispatcher.forward(request, response);
    }*/
}