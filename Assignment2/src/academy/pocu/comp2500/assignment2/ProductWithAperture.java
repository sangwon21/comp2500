package academy.pocu.comp2500.assignment2;

import java.util.List;

public class ProductWithAperture extends Product {
    protected List<Aperture> apertures;
    protected Orientation orientation;

    private boolean isValidAperture(final Aperture aperture) {
        final int x = aperture.getX();
        final int y = aperture.getY();
        final int apertureWidth = aperture.getWidth();
        final int apertureHeight = aperture.getHeight();

        return 0 <= x && x <= this.width &&
                0 < apertureWidth && apertureWidth < this.width &&
                x + apertureWidth <= this.width &&
                0 <= y && y <= this.height &&
                0 < apertureHeight && apertureHeight < height &&
                y + apertureHeight < this.height;
    }

    public boolean addAperture(final Aperture aperture) {
        boolean validAperture = isValidAperture(aperture);

        if (validAperture == false) {
            return false;
        }

        this.apertures.add(aperture);
        return true;
    }
}