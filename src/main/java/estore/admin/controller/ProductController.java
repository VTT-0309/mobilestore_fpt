package estore.admin.controller;

import java.io.File;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.multipart.MultipartFile;

import estore.repository.Category;
import estore.repository.Condition;
import estore.repository.Product;
import estore.repository.service.CategoryService;
import estore.repository.service.ConditionService;
import estore.repository.service.ProductService;
import estore.service.upload.UploadService;

@Controller
public class ProductController {
	@Autowired
	ProductService productService;
	
	@Autowired
	CategoryService categoryService;
	
	@Autowired
	ConditionService conditionService;
	
	@Autowired
	UploadService uploadService;
	
	 @GetMapping("/addProduct")
	    public String showAddProductForm() {
	        return "admin/product/form";
	    }

	 @PostMapping("/addProduct")
	 public String addProduct(Model model,
	 @RequestPart("image_file") MultipartFile imageFile,
	 @ModelAttribute Product product) {
		 if(!imageFile.isEmpty()) {
				File image = uploadService.save(imageFile, "/images/items/");
				product.setImage(image.getName());
	 } else {
		 product.setImage("new.jpg");
	 }
	     // Thêm sản phẩm vào cơ sở dữ liệu
		 productService.create(product);
	        return "admin/product/form";
    }
	 
	 @ModelAttribute("categories")
	 public List<Category> getCategories() {
		 return categoryService.findAll();
	 }
	 
	 @ModelAttribute("conditions")
	 public List<Condition> getConditions() {
		 return conditionService.findAll();
	 }


}
