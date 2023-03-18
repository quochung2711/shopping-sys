package com.dqh.shopping.Service;

import java.util.List;

import com.dqh.shopping.Entity.Product;

public interface ProductService {
	List<Product> searchProduct(String productName, String productType);
}
