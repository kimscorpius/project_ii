package com.Project_II.utils;

import com.Project_II.model.Product;

import java.util.ArrayList;
import java.util.List;

public class QuantityCollectionUtil {

    public static List<Product> selectWithFour(List<Product> products) { // use T if has many type of pro.
        List<Product> productsAfter = new ArrayList<>();
        for (int i = 0; i <= 3; i++) productsAfter.add(products.get(i));
        return productsAfter;
    }
}