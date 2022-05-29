package academy.pocu.comp2500.assignment2;

public class Banner extends ProductWithAperture {
    private BannerType bannerType;
    private BannerSize bannerSize;
    private int color;

    // registerLandscapeBannerCreator
    // registerPortraitBannerCreator
    // registerGlossBannerCreator
    // registerScrimBannerCreator
    // registerMeshBannerCreator
    public Banner(BannerType bannerType, BannerSize bannerSize, int color, Orientation orientation, ShippingMethod shippingMethod) {
        this.bannerType = bannerType;
        this.color = color;
        this.orientation = orientation;
        this.bannerSize = bannerSize;
        this.shippingMethod = shippingMethod;

        switch (bannerSize) {
            case W1000H500:
                setWidth(100);
                setHeight(50);
                setPrice(5000);
                break;
            case W1000H1000:
                setWidth(100);
                setHeight(100);
                setPrice(5200);
                break;
            case W2000H500:
                setWidth(200);
                setHeight(50);
                setPrice(5300);
                break;
            case W3000H1000:
                setWidth(300);
                setHeight(100);
                setPrice(6000);
                break;
        }

        if (bannerType == BannerType.MESH || bannerType == BannerType.SCRIM) {
            setPrice(this.price + 100);
        }

        switch (bannerType) {
            case MESH:
                setDisplayName("Mesh Banner");
                break;
            case GLOSS:
                setDisplayName("Gloss Banner");
                break;
            case SCRIM:
                setDisplayName("Scrim Banner");
                break;
        }
    }

    public BannerType getBannerType() {
        return this.bannerType;
    }

    public BannerSize getBannerSize() {
        return this.bannerSize;
    }

    public int getColor() {
        return this.color;
    }
}
