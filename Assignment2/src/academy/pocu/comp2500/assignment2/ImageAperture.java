package academy.pocu.comp2500.assignment2;

public class ImageAperture extends Aperture {
    private String imageUrl;

    public ImageAperture(final int x, final int y, final int width, final int height, final String imagePath) {
        super(x, y, width, height);
        this.imageUrl = imagePath;
    }

    public String getImageUrl() {
        return this.imageUrl;
    }

    public void setImageUrl(final String imageUrl) {
        this.imageUrl = imageUrl;
    }
}
