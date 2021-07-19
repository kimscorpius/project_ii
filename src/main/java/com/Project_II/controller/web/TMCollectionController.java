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
import java.util.ResourceBundle;

@WebServlet(urlPatterns = {"/trade-mark/dell", "/trade-mark/lenovo", "/trade-mark/hp", "/trade-mark/acer"})
public class TMCollectionController extends HttpServlet {

    @Inject
    private IProductService productService;

    ResourceBundle resourceBundle = ResourceBundle.getBundle("trademark");

    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws IOException, ServletException {
        String requestURI = request.getRequestURI().replace("/trade-mark/", "");
        String trademark = resourceBundle.getString(requestURI);

        request.setAttribute("title", trademark);
        request.setAttribute("products", productService.findByTradeMark(trademark));
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("/views/web/views/trademark-collection.jsp");
        requestDispatcher.forward(request, response);
    }
}
