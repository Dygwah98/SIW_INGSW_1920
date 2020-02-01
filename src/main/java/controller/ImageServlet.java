package controller;

import java.io.File;
import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

@WebServlet(value = "/upload", name = "upload")
@MultipartConfig(fileSizeThreshold = 1024 * 1024 * 10, // 10 MB
		maxFileSize = 1024 * 1024 * 50, // 50 MB
		maxRequestSize = 1024 * 1024 * 100) // 50 MB
public class ImageServlet extends HttpServlet {

	private static final long serialVersionUID = 205242440643911308L;

	/**
	 * Directory where uploaded files will be saved, its relative to the web
	 * application directory.
	 */
	private static final String UPLOAD_DIR = "/WebContent/images";

	/**
	 * Utility method to get file name from HTTP header content-disposition
	 */
	private String getFileName(Part part) {
		String contentDisp = part.getHeader("content-disposition");
		System.out.println("content-disposition header= " + contentDisp);
		String[] tokens = contentDisp.split(";");
		for (String token : tokens) {
			if (token.trim().startsWith("filename")) {
				return token.substring(token.indexOf("=") + 2, token.length() - 1);
			}
		}
		return "";
	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setStatus(405);
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// gets absolute path of the web application
		boolean lovogliodavvero = false;
		String applicationPath;
		if (lovogliodavvero) {
			/*
			 * MOTIVAZIONE PER CUI NON FUNGE CON QUESTA FUNC ATTUALMENTE NON TEMETE I am
			 * running Tomcat through Eclipse, that’s why file location is like this. If you
			 * run tomcat through command line and deploy application by exporting as WAR
			 * file into webapps directory, you will get different structure but a clear
			 * one. *PER FAZIO = sto avviando tomcat attraverso Eclipse, per questola path è
			 * così ... VAFFANCULO SCEMO
			 */
			applicationPath = request.getServletContext().getRealPath("");
		} else {
			// inserisci la tua path LOCALE bestia
			applicationPath = "C:/Users/Antonio/Desktop/SIW_INGSW_1920";
		}
		// constructs path of the directory to save uploaded file
		String uploadFilePath = applicationPath + File.separator + UPLOAD_DIR;

		// creates the save directory if it does not exists
		File fileSaveDir = new File(uploadFilePath);
		if (!fileSaveDir.exists()) {
			fileSaveDir.mkdirs();
		}
		System.out.println("Upload File Directory=" + fileSaveDir.getAbsolutePath());

		String fileName = null;
		// Get all the parts from request and write it to the file on server
		for (Part part : request.getParts()) {
			fileName = getFileName(part);
			part.write(uploadFilePath + File.separator + fileName);
		}

		request.setAttribute("message", fileName + " File uploaded successfully!");
		request.setAttribute("img", UPLOAD_DIR + File.separator + fileName);

		response.sendRedirect("UploadImage.jsp");
	}
}
