package app.controller;

import app.dao.UserI;
import app.dao.UserDaoImpl;
import app.model.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Optional;

@WebServlet("/update")
public class UpdateController extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        Optional<String> userId = Optional.of(request.getParameter("id"));
        if (userId.isEmpty()) {
            request.getRequestDispatcher("/list").forward(request, response);
        } else {
            Integer id = Integer.parseInt(userId.get());
            UserI dao = UserDaoImpl.getInstance();
            User user = dao.findUserById(id);
            request.setAttribute("user", user);
            request.getRequestDispatcher("/list").forward(request, response);
        }
    }
}

