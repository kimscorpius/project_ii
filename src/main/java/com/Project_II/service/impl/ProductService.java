package com.Project_II.service.impl;

import com.Project_II.service.IProductService;
import com.Project_II.dao.IProductDAO;
import com.Project_II.dao.impl.ProductDAO;
import com.Project_II.model.Product;

import java.util.List;

public class ProductService implements IProductService {

    private IProductDAO productDAO = new ProductDAO();

    @Override
    public List<Product> findAll() {
        return productDAO.findAll();
    }

    @Override
    public Long insert(Product product) {
        return productDAO.insert(product);
    }

    @Override
    public void update(Product product) {
        productDAO.update(product);
    }

    @Override
    public Product findOne(Integer id) {
        return productDAO.findOne(id);
    }

    @Override
    public List<Product> findByCategory(String category) {
        return productDAO.findByCategory(category);
    }

    @Override
    public List<Product> findByTradeMark(String tradeMark) {
        return productDAO.findByTradeMark(tradeMark);
    }

    @Override
    public void delete(Integer id) {
        productDAO.delete(id);
    }

    @Override
    public List<Product> findByRange(Integer max, Integer min) {
        return productDAO.findByRange(max, min);
    }
}
