package com.Project_II.controller.admin;

import com.Project_II.model.Product;
import com.Project_II.service.IProductService;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import javax.inject.Inject;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(urlPatterns = {"/admin/products/add"})
public class ProductAddController extends HttpServlet {

    @Inject
    private IProductService productService;

    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws IOException, ServletException {
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("/views/admin/views/add-product.jsp");
        requestDispatcher.forward(request, response);
    }

    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response)
            throws IOException {
        Product product = new Product();
        DiskFileItemFactory diskFileItemFactory = new DiskFileItemFactory();
        ServletFileUpload servletFileUpload = new ServletFileUpload(diskFileItemFactory);
        servletFileUpload.setHeaderEncoding("UTF-8");
        try {
            List<FileItem> items = servletFileUpload.parseRequest(request);
            for (FileItem item : items) {
                String itemName = item.getFieldName();
                String itemConcept = item.getString("UTF-8");
                switch (itemName) {
                    case "name" : product.setName(itemConcept); break;
                    case "price" : product.setPrice(Integer.parseInt(itemConcept)); break;
                    case "image" : product.setImage(itemConcept); break;
                    case "des" : product.setDes(itemConcept); break;
                    case "shortDes" : product.setShortDes(itemConcept); break;
                    case "ram" : product.setRam(itemConcept); break;
                    case "cpu" : product.setCpu(itemConcept); break;
                    case "screen" : product.setScreen(itemConcept); break;
                    case "hardDrive" : product.setHardDrive(itemConcept); break;
                    case "graphicsCard" : product.setGraphicsCard(itemConcept); break;
                    case "tradeMark" : product.setTradeMark(itemConcept); break;
                    case "connector" : product.setConnectors(itemConcept); break;
                    case "weight" : product.setWeight(Float.parseFloat(itemConcept)); break;
                    case "size" : product.setSize(itemConcept); break;
                    case "category" : product.setCategory(itemConcept); break;
                    case "pin" : product.setPin(itemConcept); break;
                }
            }

            productService.insert(product);
            response.sendRedirect(request.getContextPath() + "/admin/products");
        } catch (FileUploadException e) {
            e.printStackTrace();
        }
    }
}
