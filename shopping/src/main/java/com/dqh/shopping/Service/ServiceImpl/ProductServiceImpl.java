package com.dqh.shopping.Service.ServiceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dqh.shopping.Entity.Product;
import com.dqh.shopping.ProductReponsitory.ProductRepository;
import com.dqh.shopping.Service.ProductService;

@Service
public class ProductServiceImpl implements ProductService{
	
	
	@Autowired
	private ProductRepository productrepository;

	@Override
	public List<Product> searchProduct(String productName, String productType) {
		if(productName != null || productType != null)
		{
			return productrepository.search(productName, productType);
		}
		return productrepository.findAll();
	}

}
