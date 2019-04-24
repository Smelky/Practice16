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

@WebServlet("/register")
public class UserRegistrationController extends HttpServlet {
    private UserI dao = UserDaoImpl.getInstance();

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.getRequestDispatcher("/list").forward(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws IOException {

        Optional<String> userId = Optional.of(request.getParameter("id"));
        String name = request.getParameter("name");
        Integer age = Integer.valueOf(request.getParameter("age"));
        String salary = (request.getParameter("salary"));

        User user = new User();
        user.setName(name);
        user.setAge(age);
        user.setSalary(salary);

        if (userId.isEmpty())
            dao.saveUser(user);
        else {
            Integer id = Integer.parseInt(userId.get());
            user.setId(id);
            dao.updateUser(user);
        }
        response.sendRedirect(request.getContextPath() + "/list");
    }
}
