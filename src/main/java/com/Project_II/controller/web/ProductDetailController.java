package com.Project_II.controller.web;

import com.Project_II.model.Product;
import com.Project_II.service.IProductService;

import javax.inject.Inject;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(urlPatterns = {"/product/detail"})
public class ProductDetailController extends HttpServlet {

    @Inject
    private IProductService productService;

    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        Product product;
        product = productService.findOne(Integer.parseInt(request.getParameter("id")));
        request.setAttribute("product", product);
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("/views/web/views/product-detail.jsp");
        requestDispatcher.forward(request, response);
    }
}
