package com.example;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/validatePassword")
public class PasswordValidationServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request,
                          HttpServletResponse response)
            throws ServletException, IOException {

        String password = request.getParameter("password");

        response.setContentType("text/html");

        PrintWriter out = response.getWriter();

        if (isValidPassword(password)) {
            out.println("<h2>Valid Password</h2>");
        } else {
            out.println("<h2>Invalid Password</h2>");
            out.println("<p>Password must:</p>");
            out.println("<ul>");
            out.println("<li>Have at least 8 characters</li>");
            out.println("<li>Contain at least 1 uppercase letter</li>");
            out.println("<li>Contain at least 1 numeric digit</li>");
            out.println("<li>Contain exactly 1 special character</li>");
            out.println("</ul>");
        }
    }

    private boolean isValidPassword(String password) {

        if (password == null || password.length() < 8) {
            return false;
        }

        int uppercaseCount = 0;
        int digitCount = 0;
        int specialCount = 0;

        for (char ch : password.toCharArray()) {

            if (Character.isUpperCase(ch)) {
                uppercaseCount++;
            } else if (Character.isDigit(ch)) {
                digitCount++;
            } else if (!Character.isLetterOrDigit(ch)) {
                specialCount++;
            }
        }

        return uppercaseCount >= 1
                && digitCount >= 1
                && specialCount == 1;
    }
}
