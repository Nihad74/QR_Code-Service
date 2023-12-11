package qrcodeapi.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import qrcodeapi.Application;

@RestController
public class QRCodeController {
    @Autowired
    private Application.QRCodeService qrCodeService;

    @GetMapping("/api/health")
    public ResponseEntity<String> health() {
        return ResponseEntity.ok("OK");
    }

    @GetMapping("/api/qrcode")
    public ResponseEntity<byte[]> qrcode() {
        byte[] bytes = qrCodeService.generateQRCode();
        return ResponseEntity
                .ok()
                .contentType(MediaType.IMAGE_PNG)
                .body(bytes);
    }
}
