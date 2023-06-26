package com.qr.code.contoller;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import com.qr.code.model.QrData;

@RestController
public class QrController {

private static final String QR_CODE_IMAGE_PATH = "./src/main/resources/QRCode.png";

	
    @GetMapping(value = "/genrateAndDownloadQRCode/{codeText}/{width}/{height}")
		public void download(
				@PathVariable("codeText") String codeText,
				@PathVariable("width") Integer width,
				@PathVariable("height") Integer height)
			    throws Exception {
			    QrData.generateQRCodeImage(codeText, width, height, QR_CODE_IMAGE_PATH);
			    }
    
         @GetMapping(value = "/genrateQRCode/{codeText}/{width}/{height}")
   	     public ResponseEntity<byte[]> generateQRCode(
   			@PathVariable("codeText") String codeText,
   			@PathVariable("width") Integer width,
   			@PathVariable("height") Integer height)
   		    throws Exception {
   		     return ResponseEntity.status(HttpStatus.OK).contentType(MediaType.IMAGE_PNG).body(QrData.getQRCodeImage(codeText, width, height));
   		    } 	     
   	     
//      	  @PostMapping(value = "/genrateQRCode")
// 	          public ResponseEntity<byte[]> generateQRCodePost(
// 			  @RequestParam("codeText") String codeText)
// 		      throws Exception {
// 		      return ResponseEntity.status(HttpStatus.OK).contentType(MediaType.IMAGE_PNG).body(QrData.getQRCodeImage(codeText, 350, 350));
// 		       }
   	     
}
