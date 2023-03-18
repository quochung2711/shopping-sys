package com.dqh.shopping.ProductReponsitory;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;

import com.dqh.shopping.Entity.Product;

public interface ProductRepository extends JpaRepository<Product, Long>, JpaSpecificationExecutor<Product>{
	
		@Query(value = "SELECT pd FROM Product pd OUTER JOIN Order or on pd.productId = or.orderPk.productId WHERE "
				+ "lower(pd.productName) LIKE lower(concat('%', ?1,'%')) "
				+ " AND lower(pd.productType) LIKE  lower(concat('%', ?2,'%'))"
				+ " ORDER BY or.orderQuantity")
		List<Product> search(String productName, String productType);
}
