package demo.controllers;

import java.io.*;

import javax.servlet.http.HttpServletRequest;

import org.springframework.util.*;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequestMapping("file")
public class FileRestController {

	private String UPLOAD_DIR = "uploads";

	@RequestMapping(value = "upload", method = RequestMethod.POST, consumes = MimeTypeUtils.MULTIPART_FORM_DATA_VALUE)
	public String upload(@RequestParam(value = "file") MultipartFile file, HttpServletRequest request) {
		try {
			String fileName = file.getOriginalFilename();
			String path = request.getServletContext().getRealPath("") + UPLOAD_DIR + File.separator + fileName;
			System.out.println(path);
			saveFile(file.getInputStream(), path);
			return path;
		} catch (Exception e) {
			return e.getMessage();
		}

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
}
