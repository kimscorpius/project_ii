package com.Project_II.dao;

import com.Project_II.model.Product;

import java.util.List;

public interface IProductDAO extends GenericDAO<Product> {

    List<Product> findAll();

    Long insert(Product product);

    Product findOne(Integer id);

    void update(Product product);

    List<Product> findByCategory(String category);

    List<Product> findByTradeMark(String tradeMark);

    void delete(Integer id);

    List<Product> findByRange(Integer max, Integer min);
}
