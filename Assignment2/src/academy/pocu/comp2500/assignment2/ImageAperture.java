package academy.pocu.comp2500.assignment2;

public class ImageAperture extends Aperture {
    private String imageUrl;

    public ImageAperture(int x, int y, int width, int height, String imagePath) {
        super(x, y, width, height);
        this.imageUrl = imagePath;
    }

    public String getImageUrl() {
        return this.imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }
}
