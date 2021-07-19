package com.Project_II.service;

import com.Project_II.model.Product;

import java.util.List;

public interface IProductService {

    List<Product> findAll();

    Long insert(Product product);

    void update(Product product);

    Product findOne(Integer id);

    List<Product> findByCategory(String category);

    List<Product> findByTradeMark(String tradeMark);

    void delete(Integer id);

    List<Product> findByRange(Integer max, Integer min);
}
