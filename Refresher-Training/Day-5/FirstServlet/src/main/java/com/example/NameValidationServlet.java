package com.example;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/validateName")
public class NameValidationServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request,
                          HttpServletResponse response)
            throws ServletException, IOException {

        String name = request.getParameter("name");

        response.setContentType("text/html");

        PrintWriter out = response.getWriter();

        if (isValidName(name)) {
            out.println("<h2>Valid Name</h2>");
            out.println("<p>Name: " + name + "</p>");
        } else {
            out.println("<h2>Invalid Name</h2>");
            out.println("<p>Name must start with a capital letter and have at least 3 characters.</p>");
        }
    }

    private boolean isValidName(String name) {

        return name != null
                && name.length() >= 3
                && Character.isUpperCase(name.charAt(0));
    }
}