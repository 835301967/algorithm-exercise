package file;

/**
 * @Author yuxiangjin
 * @Date 2023/6/19 11:44
 **/
import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class ImageValidator {
    public static void main(String[] args) {
        String imagePath = "/Users/yuxiangjin/Pictures/test1.png";
        int maxWidth = 100;
        int maxHeight = 100;

        try {
            boolean isValid = validateImageDimensions(imagePath, maxWidth, maxHeight);
            if (isValid) {
                System.out.println("Image dimensions are valid.");
            } else {
                System.out.println("Image dimensions exceed the maximum allowed size.");
            }
        } catch (IOException e) {
            System.out.println("An error occurred while validating the image: " + e.getMessage());
        }
    }

    public static boolean validateImageDimensions(String imagePath, int maxWidth, int maxHeight) throws IOException {
        File imageFile = new File(imagePath);
        if (!imageFile.exists()){
            return false;
        }
        BufferedImage image = ImageIO.read(imageFile);
        int imageWidth = image.getWidth();
        int imageHeight = image.getHeight();

        return imageWidth <= maxWidth && imageHeight <= maxHeight;
    }
}

