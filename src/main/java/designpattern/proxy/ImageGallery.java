package designpattern.proxy;

public class ImageGallery {
    public static void main(String... args) {
        long startTime = System.currentTimeMillis();
        DisplayObject image1 = new ImageFile("alvan-nee-unsplash-01.jpg");
        DisplayObject image2 = new ImageFile("anoir-chafik-unsplash-01.jpg");
        DisplayObject image3 = new ImageFile("james-barker-unsplash-01.jpg");
        DisplayObject image4 = new ImageFile("roberto-nickson-unsplash-01.jpg");
        long postLoadTime = System.currentTimeMillis();
        image1.display();
        image2.display();
        image3.display();
        image4.display();

        image1.display();
        image2.display();
        image3.display();
        image4.display();
        long postDisplayTime = System.currentTimeMillis();
        System.out.println("time to load = " + (postLoadTime - startTime) + " ms");
        System.out.println("time to render = " + (postDisplayTime - postLoadTime) + " ms");
    }
}
