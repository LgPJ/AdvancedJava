import java.awt.image.BufferedImage;
import java.io.FileOutputStream;
import java.io.WriteAbortedException;

import javax.imageio.ImageIO;
 
import com.google.zxing.BarcodeFormat;
import java.io.Writer;
import com.google.zxing.WriterException;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.qrcode.QRCodeWriter;

public class GenerateQRCode {
    // Image properties
    private static final int qr_image_width = 400;
    private static final int qr_image_height = 400;
    private static final String IMAGE_FORMAT = "png";
    private static final String IMG_PATH = "c:/temp/qrcode.png";
 
    // Let's do it
    public static void main(String[] args) throws Exception {
 
        // URL to be encoded
        String data = "http://www.google.com";
 
        // Encode URL in QR format
        BitMatrix matrix;
        Writer writer = new QRCodeWriter();
        try {
 
            matrix = writer.encode(data, BarcodeFormat.QR_CODE, qr_image_width, qr_image_height);
 
        } catch (WriteAbortedException e) {
            e.printStackTrace(System.err);
            return;
        }
 
        // Create buffered image to draw to
        BufferedImage image = new BufferedImage(qr_image_width,
                   qr_image_height, BufferedImage.TYPE_INT_RGB);
 
        // Iterate through the matrix and draw the pixels to the image
        for (int y = 0; y < qr_image_height; y++) {
            for (int x = 0; x < qr_image_width; x++) {
                int grayValue = (matrix.get(x, y) ? 0 : 1) & 0xff;
                image.setRGB(x, y, (grayValue == 0 ? 0 : 0xFFFFFF));
            }
        }
 
        // Write the image to a file
        FileOutputStream qrCode = new FileOutputStream(IMG_PATH);
        ImageIO.write(image, IMAGE_FORMAT, qrCode);
 
        qrCode.close();
 
    }
}
