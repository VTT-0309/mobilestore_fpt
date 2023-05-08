package estore.customer.cotroller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import estore.repository.Product;
import estore.repository.service.ProductService;

@Controller
public class DetailProductController {
	@Autowired
	ProductService productService;
	
	@RequestMapping("product/detail/{id}")
	public String Detail(Model model, @PathVariable("id") Integer id) {
		Product product = productService.getById(id);
		model.addAttribute("product", product);
		return"customer/product/detail";
	}
}
