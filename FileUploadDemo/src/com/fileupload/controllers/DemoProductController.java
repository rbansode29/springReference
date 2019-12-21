package com.fileupload.controllers;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;

import com.fileupload.domain.Product;

@Controller
public class DemoProductController {

	public DemoProductController() {
		super();
	}

	@RequestMapping("/save-product")
	public String uploadResources(HttpServletRequest servletRequest, @ModelAttribute Product product, Model model) throws IOException {
		// Get the uploaded files and store them
		List<MultipartFile> files = product.getImages();
		List<String> fileNames = new ArrayList<String>();
		if (null != files && files.size() > 0) {
			for (MultipartFile multipartFile : files) {

				String fileName = multipartFile.getOriginalFilename();
				fileNames.add(fileName);

				//File imageFile = new File(servletRequest.getServletContext().getRealPath(""), fileName);
				
				
				String path = servletRequest.getServletContext().getRealPath("") + "" + File.separator + fileName;
				System.out.println(path);
				saveFile(servletRequest.getInputStream(), path);
				
				
			}
		}

		// Here, you can save the product details in database

		model.addAttribute("product", product);
		return "viewProductDetail";
	}
	
	private void saveFile(InputStream inputStream, String path) {
		try {
			OutputStream outputStream = new FileOutputStream(new File(path));
			int read = 0;
			byte[] bytes = new byte[1024];
			while ((read = inputStream.read()) != -1) {
				outputStream.write(bytes, 0, read);
			}
			outputStream.flush();
			outputStream.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@RequestMapping(value = "/product-input-form")
	public String inputProduct(Model model) {
		model.addAttribute("product", new Product());
		return "productForm";
	}

}
