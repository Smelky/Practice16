package app.controller;

import app.dao.UserDao;
import app.dao.UserDaoImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Optional;

@WebServlet("/update")
public class UpdateController extends HttpServlet {
    private UserDao userDao = UserDaoImpl.getInstance();

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        Optional<String> userId = Optional.ofNullable(request.getParameter("id"));
        if (!userId.isPresent()) {
            request.getRequestDispatcher("/list").forward(request, response);
        } else {
            Integer id = Integer.parseInt(userId.get());
            Optional user = userDao.findById(id);
            request.setAttribute("user", user);
            request.getRequestDispatcher("/list").forward(request, response);
        }
    }
}

