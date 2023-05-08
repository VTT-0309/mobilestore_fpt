package estore.customer.cotroller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import estore.repository.Product;
import estore.repository.service.ProductService;

@Controller
public class HomeController {
	@Autowired
	ProductService productService;
	
	@RequestMapping("home/index")
	 public String showProduct(Model model) {
		 List<Product> listproduct = productService.findAll();
		 model.addAttribute("listproduct", listproduct);
	        return "customer/product/productlist";
	    }
}
