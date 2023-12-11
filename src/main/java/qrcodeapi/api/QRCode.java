package qrcodeapi.api;

import java.awt.*;
import java.awt.image.BufferedImage;

public class QRCode {

    public QRCode() {
    }

    public BufferedImage createImage(int pixels){
        int width = pixels;
        int height = width;
        BufferedImage image = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
        Graphics2D g = image.createGraphics();
        g.setColor(Color.WHITE);
        g.fillRect(0,0, width, height);
        return image;
    }
}
