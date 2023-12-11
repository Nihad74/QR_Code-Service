package qrcodeapi.api;

import java.awt.*;
import java.awt.image.BufferedImage;

public class QRCode {
    private int width;
    private int height;

    public QRCode() {
        this.width = 250;
        this.height = 250;
    }

    public BufferedImage createImage(){
        BufferedImage image = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
        Graphics2D g = image.createGraphics();
        g.setColor(Color.WHITE);
        g.fillRect(0,0, width, height);
        return image;
    }
}
