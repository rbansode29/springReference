package com.example.demo.controllers;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.demo.domain.Product;
import com.example.demo.services.crudservices.ProductService;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Font;
import com.itextpdf.text.PageSize;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;

@Controller
public class ProductController {

	private ProductService productService;

	@Autowired
	public void setProductService(ProductService productService) {
		this.productService = productService;
	}

	@RequestMapping("/createPDF")
	public String listProduct(Model model) {
		createNewPdf();		
		return "success";
	}

	private void createNewPdf() {
		String[] headers = new String[] { "Id", "Description", "Price", "Image URL" };

		List<Product> l_productList = productService.listAllProduct();// change this line of code for your model object
																		// select query

		Document document = new Document(PageSize.LETTER.rotate());

		try {

			PdfWriter.getInstance(document, new FileOutputStream(new File("TableDemo.pdf")));
			document.open();

			Font fontHeader = new Font(Font.FontFamily.TIMES_ROMAN, 12, Font.BOLD);
			Font fontRow = new Font(Font.FontFamily.TIMES_ROMAN, 10, Font.NORMAL);

			PdfPTable table = new PdfPTable(headers.length);

			for (String header : headers) {
				PdfPCell cell = new PdfPCell();
				cell.setGrayFill(0.9f);
				cell.setPhrase(new Phrase(header.toUpperCase(), fontHeader));
				table.addCell(cell);
			}

			table.completeRow();
			Product[] array = l_productList.toArray(new Product[l_productList.size()]);
			for (int i = 0; i < array.length; i++) {
				Product p1 = array[i];
				addNewCell(p1.getId().toString(), fontRow, table);
				addNewCell(p1.getDescription().toString(), fontRow, table);
				addNewCell(p1.getImageUrl().toString(), fontRow, table);
				addNewCell(p1.getPrice().toString(), fontRow, table);
			}

			document.addTitle("PDF Table Demo");
			document.add(table);
		} catch (DocumentException | FileNotFoundException e) {
			e.printStackTrace();
		} finally {
			document.close();
		}

	}

	private void addNewCell(String string, Font fontRow, PdfPTable table) {
		Phrase phrase = new Phrase(string, fontRow);
		table.addCell(new PdfPCell(phrase));
	}

}
