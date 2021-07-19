package com.Project_II.controller.web;

import com.Project_II.service.IProductService;
import com.Project_II.utils.QuantityCollectionUtil;

import javax.inject.Inject;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(urlPatterns = {"/home"})
public class HomeController extends HttpServlet {

    @Inject
    private IProductService productService;

    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws IOException, ServletException {
        //IProductService productService = new ProductService();
        request.setAttribute("productsHTVP",
                QuantityCollectionUtil.selectWithFour(productService.findByCategory("HỌC TẬP - VĂN PHÒNG")));
        request.setAttribute("productsDHKT",
                QuantityCollectionUtil.selectWithFour(productService.findByCategory("ĐỒ HỌA - KỸ THUẬT")));
        request.setAttribute("productsLGM",
                QuantityCollectionUtil.selectWithFour(productService.findByCategory("LAPTOP GAMING")));
        request.setAttribute("productsCCST",
                QuantityCollectionUtil.selectWithFour(productService.findByCategory("CAO CẤP - SANG TRỌNG")));
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("/views/web/views/index.jsp");
        requestDispatcher.forward(request, response);
    }
}
