package com.Project_II.controller.web;

import com.Project_II.service.IProductService;

import javax.inject.Inject;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(urlPatterns = {"/price"})
public class PriceCollectionController extends HttpServlet {

    @Inject
    private IProductService productService;

    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws IOException, ServletException {
        Integer max = Integer.parseInt(request.getParameter("max"));
        Integer min = Integer.parseInt(request.getParameter("min"));

        request.setAttribute("products", productService.findByRange(max, min));
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("/views/web/views/range-collection.jsp");
        requestDispatcher.forward(request, response);
    }
}
