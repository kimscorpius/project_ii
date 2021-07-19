package com.Project_II.controller.admin;

import com.Project_II.service.IProductService;

import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(urlPatterns = {"/admin/products/delete"})
public class ProductDeleteController extends HttpServlet {

    @Inject
    private IProductService productService;

    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException {
        Integer proId = Integer.parseInt(request.getParameter("id"));
        productService.delete(proId);
        response.sendRedirect(request.getContextPath() + "/admin/products");
    }
}
