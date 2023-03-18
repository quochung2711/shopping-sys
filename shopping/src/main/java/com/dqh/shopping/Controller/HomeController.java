package com.dqh.shopping.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

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
	public String homePage(@Param("pdname") String pdname, @Param("pdtype") String pdtype, Model model) {

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

	@RequestMapping(value = "/order-product")
	public String orderProduct(@RequestParam("soluong") List<String> soluong, RedirectAttributes redirectAttrs) {
		String msg = "";
		for (String sl : soluong) {
			if (!sl.isBlank()) {
				if (!isNumeric(sl)) {
					msg = "số lượng không hợp lệ, vui long nhập lại";
					redirectAttrs.addFlashAttribute("msg", msg);
					return "redirect:/";
				} else {
					return "order";
				}
			} else {
				msg = "Vui lòng chọn sản phẩm và nhập số lượng";

			}
		}
		redirectAttrs.addFlashAttribute("msg", msg);
		return "redirect:/";
	}
	public static boolean isNumeric(String str) {
	    if (str == null) {
	        return false;
	    }
	    try {
	        Double.parseDouble(str);
	        return true;
	    } catch (NumberFormatException nfe) {
	        return false;
	    }
	}
}
