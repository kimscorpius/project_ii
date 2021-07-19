package com.Project_II.mapper;

import com.Project_II.model.Product;

import java.sql.ResultSet;
import java.sql.SQLException;

public class ProductMapper implements RowMapper<Product> {

    @Override
    public Product mapRow(ResultSet resultSet) {
        Product product = new Product();
        try {
            product.setId(resultSet.getInt("id"));
            product.setDes(resultSet.getString("des"));
            product.setName(resultSet.getString("name"));
            product.setPrice(resultSet.getInt("price"));
            product.setImage(resultSet.getString("image"));
            product.setShortDes(resultSet.getString("short_des"));
            product.setRam(resultSet.getString("ram"));
            product.setCpu(resultSet.getString("cpu"));
            product.setScreen(resultSet.getString("screen"));
            product.setHardDrive(resultSet.getString("hard_drive"));
            product.setGraphicsCard(resultSet.getString("graphics_card"));
            product.setTradeMark(resultSet.getString("trade_mark"));
            product.setConnectors(resultSet.getString("connectors"));
            product.setSize(resultSet.getString("size"));
            product.setCategory(resultSet.getString("category"));
            product.setWeight(resultSet.getFloat("weight"));
            product.setPin(resultSet.getString("pin"));

            return product;
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }
}
