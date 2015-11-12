package ru.kpfu.itis.servlets;

import ru.kpfu.itis.entities.User;
import ru.kpfu.itis.exceptions.DatabaseException;
import ru.kpfu.itis.exceptions.DuplicateEntryException;
import ru.kpfu.itis.exceptions.NotValidEmailException;
import ru.kpfu.itis.exceptions.NotValidPasswordException;
import ru.kpfu.itis.repositories.UserRepository;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

public class ServletFormForRegistration extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String email = request.getParameter("email");
        String password = request.getParameter("password");
        String gender = request.getParameter("gender");
        String subscription = request.getParameter("subscription");

        if (email != null && password != null && gender != null && subscription != null) {
            try {
                UserRepository.addUser(new User(email, password, gender, subscription));
                response.sendRedirect("/login");
            } catch (DatabaseException e) {
                request.setAttribute("message", "Error with DB");
            } catch (DuplicateEntryException e) {
                request.setAttribute("message", "User with this email already exist");
            } catch (NotValidPasswordException e) {
                request.setAttribute("message", e.getMessage());
            } catch (NotValidEmailException e) {
                request.setAttribute("message", e.getMessage());
            }
        } else {
            request.setAttribute("message", "Please fill the required fields");
        }

        getServletContext().getRequestDispatcher("/WEB-INF/views/registration.jsp").forward(request, response);

    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        if (session.getAttribute("authen") != null) {
            response.sendRedirect("/profile");
        } else if (session.getAttribute("reg") != null) {
            response.sendRedirect("/login");
        } else {
            request.getServletContext().getRequestDispatcher("/WEB-INF/views/registration.jsp").forward(request, response);
        }
    }
}
