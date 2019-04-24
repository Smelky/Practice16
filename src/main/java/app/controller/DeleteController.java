package app.controller;

import app.dao.UserI;
import app.dao.UserDaoImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Optional;

@WebServlet("/delete")
public class DeleteController extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        Optional<String> userId = Optional.of(request.getParameter("id"));
        if (userId.isEmpty()) {
            request.getRequestDispatcher("/list").forward(request, response);
        }
        else {
            Integer id = Integer.parseInt(userId.get());
            UserI dao = UserDaoImpl.getInstance();
            dao.deleteUser(id);
            response.sendRedirect(request.getContextPath() + "/list");
        }
    }
}
