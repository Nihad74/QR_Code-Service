package qrcodeapi.service;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import qrcodeapi.api.ErrorResponse;
import qrcodeapi.api.QRCode;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.IOException;

@Service

public class QRCodeService {
    private QRCode qrCode = new QRCode();

    public ResponseEntity<?> generateQRCode(int size, String type) {
        if(size <150 || size > 350){
            return ResponseEntity
                    .badRequest()
                    .header("Content-Type", "application/json")
                    .body(new ErrorResponse("Image size must be between 150 and 350 pixels"));
        }
        BufferedImage image = qrCode.createImage(size);
        try(var baos = new ByteArrayOutputStream()) {
            ImageIO.write(image, type, baos);
            if(type.equals("png")) {
                return ResponseEntity
                        .ok()
                        .header("Content-Type", "image/png")
                        .body(baos.toByteArray());
            }else if(type.equals("jpeg")){
                return ResponseEntity
                        .ok()
                        .header("Content-Type", "image/jpeg")
                        .body(baos.toByteArray());
            } else if (type.equals("gif")) {
                return ResponseEntity
                        .ok()
                        .header("Content-Type", "image/gif")
                        .body(baos.toByteArray());
            }else{
                return ResponseEntity
                        .badRequest()
                        .header("Content-Type", "application/json")
                        .body(new ErrorResponse("Only png, jpeg and gif image types are supported"));
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
