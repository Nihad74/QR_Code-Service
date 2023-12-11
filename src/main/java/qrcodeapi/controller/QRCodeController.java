package qrcodeapi.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import qrcodeapi.service.QRCodeService;

@RestController
public class QRCodeController {
    @Autowired
    private QRCodeService qrCodeService;

    @GetMapping("/api/health")
    public ResponseEntity<String> health() {
        return ResponseEntity.ok("OK");
    }

    @GetMapping("/api/qrcode")
    public ResponseEntity<?> qrcode(@RequestParam(required = false,defaultValue = "200") int size,
                                         @RequestParam(required = false,defaultValue = "png") String type) {
        return qrCodeService.generateQRCode(size, type);
    }
}
