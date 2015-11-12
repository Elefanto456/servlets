package ru.kpfu.itis.servlets;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

public class ServletAuthentication extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        String email = request.getParameter("email");
        String password = request.getParameter("password");

        /*try {
            User user = UserRepository.identificate(email, password);
            session.setAttribute("authen", user);
            response.sendRedirect("/profile");
            return;
        } catch (DatabaseException e) {
            request.setAttribute("message", e.getMessage());
        } catch (IdentificationException e) {
            request.setAttribute("message", e.getMessage());
        }
        request.getServletContext().getRequestDispatcher("/WEB-INF/views/login.jsp");*/
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();

        if (session.getAttribute("authen") == null) {
            request.getServletContext().getRequestDispatcher("/WEB-INF/views/Login.jsp").forward(request, response);
        } else {
            response.sendRedirect("/profile");
        }
    }
}
