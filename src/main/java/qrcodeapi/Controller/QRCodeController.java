package qrcodeapi.Controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class QRCodeController {

    @GetMapping("/api/health")
    public ResponseEntity<String> health() {
        return ResponseEntity.ok("OK");
    }

    @GetMapping("/api/qrcode")
    public ResponseEntity<String> qrcode() {
        return new ResponseEntity<>("Not implemented", HttpStatus.NOT_IMPLEMENTED);
    }
}
