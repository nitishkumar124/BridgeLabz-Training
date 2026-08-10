package com.example;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {

    private static final String VALID_USERNAME = "admin";
    private static final String VALID_PASSWORD = "admin123";

    @Override
    protected void doPost(HttpServletRequest request,
                          HttpServletResponse response)
            throws ServletException, IOException {

        String username = request.getParameter("username");
        String password = request.getParameter("password");

        response.setContentType("text/html");

        PrintWriter out = response.getWriter();

        if (VALID_USERNAME.equals(username)
                && VALID_PASSWORD.equals(password)) {

            out.println("<h2>Login Successful</h2>");

        } else {

            out.println("<h2>Invalid Username or Password</h2>");
        }
    }
}