package designpattern.proxy.pattern;

import designpattern.proxy.DisplayObject;
import designpattern.proxy.ImageFile;

public class ImageProxy implements DisplayObject {
    private final String fileName;
    private ImageFile image;

    public ImageProxy(String fileName) {
        this.fileName = fileName;
    }

    @Override
    public String[] getProperties() {
        return image.getProperties();
    }

    @Override
    public void display() {
        if (image == null) {
            image = new ImageFile(this.fileName);
        }
        image.display();
    }
}
