package com.qr.code.model;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.nio.file.FileSystems;
import java.nio.file.Path;
import com.google.zxing.BarcodeFormat;
import com.google.zxing.WriterException;
import com.google.zxing.client.j2se.MatrixToImageWriter;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.qrcode.QRCodeWriter;

public class QrData {

	public static void generateQRCodeImage(String text, int width, int height, String filePath)
			throws WriterException, IOException {
		QRCodeWriter qrCodeWriter = new QRCodeWriter();
		BitMatrix bitMatrix = qrCodeWriter.encode(text, BarcodeFormat.QR_CODE, width, height);
		Path path = FileSystems.getDefault().getPath(filePath);
		MatrixToImageWriter.writeToPath(bitMatrix, "PNG", path);
	}

	// Function to convert centimeters to pixels
	public static int Conversion(double centi) {
		double pixels = (96 * centi) / 2.54;
		System.out.println(pixels);
		return (int) pixels;
	}

// Function to generate qr code
	public static byte[] getQRCodeImage(String text, double width, double height) throws WriterException, IOException {
		QRCodeWriter qrCodeWriter = new QRCodeWriter();
		int widthInPixel = Conversion(width);
		int heightInPixel = Conversion(height);
		BitMatrix bitMatrix = qrCodeWriter.encode(text, BarcodeFormat.QR_CODE, widthInPixel, heightInPixel);
		ByteArrayOutputStream pngOutputStream = new ByteArrayOutputStream();
		MatrixToImageWriter.writeToStream(bitMatrix, "PNG", pngOutputStream);
		byte[] pngData = pngOutputStream.toByteArray();
		return pngData;
	}

	public static void getQRCodeImage(String text, double width, double height, String filepath)
	    throws WriterException, IOException {
		QRCodeWriter qrCodeWriter = new QRCodeWriter();
		int widthInPixel = Conversion(width);
		int heightInPixel = Conversion(height);
		BitMatrix bitMatrix = qrCodeWriter.encode(text, BarcodeFormat.QR_CODE, widthInPixel, heightInPixel);
		Path path = FileSystems.getDefault().getPath(filepath);
		MatrixToImageWriter.writeToPath(bitMatrix, "PNG", path);
//		  ByteArrayOutputStream pngOutputStream= new ByteArrayOutputStream();
//		  MatrixToImageWriter.writeToStream(bitMatrix,"PNG", pngOutputStream); byte[] pngData = pngOutputStream.toByteArray();

	}
}
