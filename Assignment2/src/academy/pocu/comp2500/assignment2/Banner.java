package academy.pocu.comp2500.assignment2;

public class Banner extends ProductWithAperture {
    private BannerType bannerType;
    private int color;
    private BannerSize bannerSize;

    // registerLandscapeBannerCreator
    // registerPortraitBannerCreator
    // registerGlossBannerCreator
    // registerScrimBannerCreator
    // registerMeshBannerCreator
    public Banner(BannerType bannerType, BannerSize bannerSize, int color, Orientation orientation) {
        this.bannerType = bannerType;
        this.color = color;
        this.orientation = orientation;
        this.bannerSize = bannerSize;

        switch (bannerSize) {
            case W1000H500:
                setWidth(1000);
                setHeight(500);
                setPrice(5000);
                break;
            case W1000H1000:
                setWidth(1000);
                setHeight(1000);
                setPrice(5200);
                break;
            case W2000H500:
                setWidth(2000);
                setHeight(500);
                setPrice(5300);
                break;
            case W3000H1000:
                setWidth(3000);
                setHeight(1000);
                setPrice(6000);
                break;
        }

        if (bannerType == BannerType.MESH || bannerType == BannerType.SCRIM) {
            setPrice(this.price + 100);
        }
    }

    public BannerType getBannerType() {
        return this.bannerType;
    }

    public int getColor() {
        return this.color;
    }

    public BannerSize getBannerSize() {
        return this.bannerSize;
    }
}
