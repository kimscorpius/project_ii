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

@WebServlet(urlPatterns = {"/laptop-sinh-vien-van-phong", "/laptop-do-hoa", "/laptop-gaming", "/cao-cap-sang-trong"})
public class CategoryCollectionController extends HttpServlet {

    @Inject
    private IProductService productService;

    ResourceBundle resourceBundle = ResourceBundle.getBundle("category-url");

    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws IOException, ServletException {
        String requestURI = request.getRequestURI().replace("/", "");
        String category = resourceBundle.getString(requestURI);
        category = new String(category.getBytes("ISO-8859-1"), "UTF-8");

        request.setAttribute("products", productService.findByCategory(category));
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("/views/web/views/category-collection.jsp");
        requestDispatcher.forward(request, response);
    }
}
