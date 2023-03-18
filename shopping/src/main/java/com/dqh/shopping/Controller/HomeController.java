package com.dqh.shopping.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import com.dqh.shopping.Entity.Product;
import com.dqh.shopping.ProductReponsitory.ProductRepository;
import com.dqh.shopping.Service.ProductService;

@Controller
public class HomeController {

	@Autowired
	ProductService productService;

	@Autowired
	ProductRepository productRepository;

	@GetMapping("/search")
	public String homePage(@Param("pdname") String pdname, @Param("pdtype") String pdtype,
			Model model) {

		List<Product> listproduct = productService.searchProduct(pdname, pdtype);
		model.addAttribute("listproduct", listproduct);
		model.addAttribute("pdname", pdname);
		model.addAttribute("pdtype", pdtype);
		return "index";
	}

	@GetMapping("/")
	public String homePage(Model model) {
		List<Product> listproduct = productRepository.findAll();
		model.addAttribute("listproduct", listproduct);
		return "index";
	}
}
