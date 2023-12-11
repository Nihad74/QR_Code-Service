package qrcodeapi.api;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.EncodeHintType;
import com.google.zxing.WriterException;
import com.google.zxing.client.j2se.MatrixToImageWriter;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.qrcode.QRCodeWriter;
import com.google.zxing.qrcode.decoder.ErrorCorrectionLevel;

import java.awt.image.BufferedImage;
import java.util.HashMap;
import java.util.Map;

public class QRCode {

    QRCodeWriter qrCodeWriter = new QRCodeWriter();

    public QRCode() {
    }

    public BufferedImage createImage(int pixels, String content, String correction){
        Map<EncodeHintType,?> hints = new HashMap<>();
        if(correction.equals("L")){
            hints = Map.of(EncodeHintType.ERROR_CORRECTION, ErrorCorrectionLevel.L);
        }else if(correction.equals("M")){
            hints = Map.of(EncodeHintType.ERROR_CORRECTION, ErrorCorrectionLevel.M);
        }else if(correction.equals("Q")){
            hints = Map.of(EncodeHintType.ERROR_CORRECTION, ErrorCorrectionLevel.Q);
        } else if (correction.equals("H")) {
            hints = Map.of(EncodeHintType.ERROR_CORRECTION, ErrorCorrectionLevel.H);
        }
        try{
            BitMatrix bitMatrix = qrCodeWriter.encode(content, BarcodeFormat.QR_CODE, pixels, pixels,hints);
            BufferedImage bufferedImage = MatrixToImageWriter.toBufferedImage(bitMatrix);
            return bufferedImage;
        }catch(WriterException e){
            System.out.println(e);
        }
        return null;
    }
}
