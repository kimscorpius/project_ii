package com.Project_II.dao.impl;

import com.Project_II.dao.IProductDAO;
import com.Project_II.model.Product;
import com.Project_II.mapper.ProductMapper;

import java.util.ArrayList;
import java.util.List;

public class ProductDAO extends AbstractDAO<Product> implements IProductDAO {

    @Override
    public List<Product> findAll() {
        StringBuilder sql = new StringBuilder("select * from product");
        return query(sql.toString(), new ProductMapper());
    }

    @Override
    public Long insert(Product product) {
        StringBuilder sql = new StringBuilder("INSERT INTO product");
        sql.append("(name, price, des, image, short_des, ram, cpu, screen, ");
        sql.append("hard_drive, graphics_card, trade_mark, connectors, weight, size, category, pin) ");
        sql.append("VALUE(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?) ");
        return insert(sql.toString(), product.getName(), product.getPrice(), product.getDes(),
                        product.getImage(), product.getShortDes(), product.getRam(), product.getCpu(),
                        product.getScreen(), product.getHardDrive(), product.getGraphicsCard(),
                        product.getTradeMark(), product.getConnectors(), product.getWeight(), product.getSize(),
                        product.getCategory(), product.getPin());
    }

    @Override
    public Product findOne(Integer id) {
        StringBuilder sql = new StringBuilder("select * from product ");
        sql.append("where id = ? ");
        List<Product> products =  query(sql.toString(), new ProductMapper(), id);
        return products.isEmpty() ? null : products.get(0);
    }

    @Override
    public void update(Product product) {
        StringBuilder sql = new StringBuilder("update product set ");
        sql.append("name = ?, price = ?, image = ?, des = ?, short_des = ?, ");
        sql.append("ram = ?, cpu = ?, screen = ?, hard_drive = ?, ");
        sql.append("graphics_card = ?, trade_mark = ?, connectors = ?, weight = ?, size = ?, ");
        sql.append("category = ?, pin = ? ");
        sql.append("where id = ? ");
        update(sql.toString(), product.getName(), product.getPrice(), product.getImage(),
                product.getDes(), product.getShortDes(), product.getRam(), product.getCpu(),
                product.getScreen(), product.getHardDrive(), product.getGraphicsCard(),
                product.getTradeMark(), product.getConnectors(), product.getWeight(), product.getSize(),
                product.getCategory(), product.getPin(), product.getId());
    }

    @Override
    public List<Product> findByCategory(String category) {
        StringBuilder sql = new StringBuilder("SELECT * FROM product ");
        sql.append("WHERE category LIKE ? ");
        return query(sql.toString(), new ProductMapper(), category);
    }

    @Override
    public List<Product> findByTradeMark(String tradeMark) {
        StringBuilder sql = new StringBuilder("SELECT * FROM product ");
        sql.append("WHERE trade_mark LIKE ? ");
        return query(sql.toString(), new ProductMapper(), tradeMark);
    }

    @Override
    public void delete(Integer id) {
        StringBuilder sql = new StringBuilder("delete from product ");
        sql.append("where id = ? ");
        update(sql.toString(), id);
    }

    @Override
    public List<Product> findByRange(Integer max, Integer min) {
        if (max == 0) {
            String sql = "select * from product where price > ?";
            return query(sql, new ProductMapper(), min);
        } else if (min == 0) {
            String sql = "select * from product where price < ?";
            return query(sql, new ProductMapper(), max);
        } else {
            String sql = "select * from product where price >= ? and price <= ?";
            return query(sql, new ProductMapper(), min, max);
        }
    }
}
