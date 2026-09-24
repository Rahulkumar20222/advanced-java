package com.advancedjava.mvc;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet("/mvc")
public class MvcServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request,
                          HttpServletResponse response)
            throws ServletException, IOException {

        MvcController controller = new MvcController();

        MvcModel model = controller.processRequest();

        request.setAttribute("message", model.getMessage());

        request.getRequestDispatcher("/experiment3.jsp")
               .forward(request, response);
    }
}