
package com.example;

import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class FeedbackServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request,
                          HttpServletResponse response)
                          throws ServletException, IOException {

        request.setCharacterEncoding("UTF-8");
        response.setContentType("text/html;charset=UTF-8");

        String name = request.getParameter("name");
        String email = request.getParameter("email");
        String feedbackType = request.getParameter("feedbackType");
        String comments = request.getParameter("comments");

        LocalDateTime now = LocalDateTime.now();

        DateTimeFormatter formatter =
            DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");

        String dateTime = now.format(formatter);

        PrintWriter out = response.getWriter();

        out.println("<!DOCTYPE html>");
        out.println("<html>");
        out.println("<head>");
        out.println("<title>Feedback Submitted</title>");
        out.println("</head>");
        out.println("<body>");

        out.println("<h2>Feedback Submitted Successfully!</h2>");
        out.println("<p>Thank you, " + escapeHtml(name) + "!</p>");
        out.println("<p><b>Email:</b> " + escapeHtml(email) + "</p>");
        out.println("<p><b>Feedback Type:</b> "
                    + escapeHtml(feedbackType) + "</p>");
        out.println("<p><b>Comments:</b> "
                    + escapeHtml(comments) + "</p>");
        out.println("<p><b>Date and Time:</b> "
                    + escapeHtml(dateTime) + "</p>");

        out.println("<a href='feedback.html'>Go Back</a>");

        out.println("</body>");
        out.println("</html>");

        out.close();
    }

    private String escapeHtml(String value) {
        if (value == null) {
            return "";
        }

        return value.replace("&", "&amp;")
                    .replace("<", "&lt;")
                    .replace(">", "&gt;")
                    .replace("\"", "&quot;")
                    .replace("'", "&#39;");
    }
}
