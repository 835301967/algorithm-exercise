package file;

/**
 * @Author yuxiangjin
 * @Date 2023/6/19 15:39
 **/
import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.net.URL;

public class ImageValidatorNew {
    public static void main(String[] args) {
        String imageUrl = "https://example.com/image.jpg";
        int maxWidth = 800;
        int maxHeight = 600;

        try {
            boolean isValid = validateImageDimensions(imageUrl, maxWidth, maxHeight);
            if (isValid) {
                System.out.println("Image dimensions are valid.");
            } else {
                System.out.println("Image dimensions exceed the maximum allowed size.");
            }
        } catch (IOException e) {
            System.out.println("An error occurred while validating the image: " + e.getMessage());
        }
    }

    public static boolean validateImageDimensions(String imageUrl, int maxWidth, int maxHeight) throws IOException {
        URL url = new URL(imageUrl);
        BufferedImage image = ImageIO.read(url);

        int imageWidth = image.getWidth();
        int imageHeight = image.getHeight();

        return imageWidth <= maxWidth && imageHeight <= maxHeight;
    }
}

