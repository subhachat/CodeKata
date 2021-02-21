package designpattern.proxy;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.net.URISyntaxException;
import java.util.Objects;

public class ImageFile implements DisplayObject {
    private final Image image;

    public ImageFile(String fileName) {
        this.image = loadImage(fileName);
    }

    public String[] getProperties() {
        return null;
    }

    @Override
    public void display() {
        ImageIcon icon = new ImageIcon(this.image);
        JLabel label = new JLabel(icon);
        JOptionPane.showMessageDialog(null, label);
    }

    private Image loadImage(String fileName) {
        Objects.requireNonNull(fileName);
        Image scaledImage = null;
        try {
            scaledImage = ImageIO.read(
                    new File(ClassLoader.getSystemResource(fileName).toURI())
            ).getScaledInstance(500, 500, Image.SCALE_SMOOTH);
        } catch (IOException | URISyntaxException e) {
            System.err.println("WARNING: the image loading error ->" + e.getMessage());
        }
        return scaledImage;
    }
}
