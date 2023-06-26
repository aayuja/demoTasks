package com.qr.code.contoller;

import java.io.File;
import java.io.IOException;
import java.nio.file.FileSystems;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Base64;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import com.google.zxing.WriterException;
import com.qr.code.model.QrData;
import com.qr.code.work.EmailService;
import com.qr.code.work.QrZip;

@Controller
public class QrCodeFront {

	@Autowired
	private EmailService emailService;
	
	private static final String QR_CODE_IMAGE_PATH = "src/main/resources/static/";
	
	@RequestMapping(value = "/index")
	public String index() {
		return "InputForm";
	}

	@PostMapping(value = "/qrShow")
	public String showQr(Model model, @RequestParam("codeText") String codeText, @RequestParam("width") int width,
		@RequestParam("height") int height) throws WriterException, IOException {
		byte[] qr = QrData.getQRCodeImage(codeText, width, height);
		String qrCode = Base64.getEncoder().encodeToString(qr);
		model.addAttribute("qrCode", "data:image/png;base64," + qrCode);
		model.addAttribute("textValue", codeText);
		return "showQr";
	}

	@RequestMapping(value = "/multipleQr")
	public String multipleQr() {
		return "MultipleForm";
	}

	@PostMapping(value = "/qrShowMultiple")
	public String showQrMultiple(Model model,@RequestParam("width") String width,@RequestParam("height") String height,
			@RequestParam("qrData") String qrData,
			@RequestParam("qr_count") String qrCount, @RequestParam("email") String email) throws NumberFormatException, WriterException, IOException {
		System.out.println("email--------------------------------------------------------   "   +  email);
		String[] qrArr = qrData.split(",");
		System.out.println(qrData+" >>>>> "+qrArr.length);
		ArrayList<String> qrs = new ArrayList<>();
		long dir = System.currentTimeMillis();
	    String directoryName = QR_CODE_IMAGE_PATH.concat(String.valueOf(dir));

	    File directory = new File(directoryName);
	    if (! directory.exists()){
	        directory.mkdir();
	        // If you require it to make the entire directory path including parents,
	        // use directory.mkdirs(); here instead.
	    }
		for (int i = 0; i < Integer.parseInt(qrCount); i++) {
			QrData.getQRCodeImage(qrArr[i], Integer.parseInt(width), Integer.parseInt(height),
					directoryName + "/qr" + i + ".png");
		}
		  Path path =FileSystems.getDefault().getPath(directoryName);
		new QrZip().zipFolder(path, directoryName+".zip");
		model.addAttribute("zipLink", dir+".zip");
		
//		mailto:emailservice.sendmail("ayuushibartwal@gmail.com", "Happy Coding", "Email sent with demo application");
		emailService.sendMailWithAttachment(email, "Qr Data", "Check file attached", directoryName+".zip");
//        emailService.sendPreConfiguredMail("Happy Coding");
		return "multipleQr";
	}
		

	@RequestMapping(value = "/home")
	public String homePage() {
		return "homePage";
	}
	
	@RequestMapping(value = "/csvFile")
	public String csvFile() {
		return "CsvFile";
	}
}
