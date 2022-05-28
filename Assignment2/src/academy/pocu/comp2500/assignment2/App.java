package academy.pocu.comp2500.assignment2;

import academy.pocu.comp2500.assignment2.registry.Registry;

public class App {
    public App(Registry registry) {
        // register your classes or methods here
        // 1. 빨강 잉크 스탬프를 만드는 생성자나 메서드를 등록한다. 2개의 오버로딩된 메서드가 있으니 본인의 설계에 적합한 버전을 사용할 것.
        registry.registerRedStampCreator("Stamp", "Stamp");
        // 2. 파랑 잉크 스탬프를 만드는 생성자나 메서드를 등록한다. 2개의 오버로딩된 메서드가 있으니 본인의 설계에 적합한 버전을 사용할 것.
        registry.registerBlueStampCreator("Stamp", "Stamp");
        // 3. 녹색 잉크 스탬프를 만드는 생성자나 메서드를 등록한다. 2개의 오버로딩된 메서드가 있으니 본인의 설계에 적합한 버전을 사용할 것.
        registry.registerGreenStampCreator("Stamp", "Stamp");
        // 4. 벽걸이 달력을 만드는 생성자나 메서드를 등록한다. 2개의 오버로딩된 메서드가 있으니 본인의 설계에 적합한 버전을 사용할 것.
        registry.registerWallCalendarCreator("Calendar", "Calendar");
        // 5. 자석 달력을 만드는 생성자나 메서드를 등록한다. 2개의 오버로딩된 메서드가 있으니 본인의 설계에 적합한 버전을 사용할 것.
        registry.registerMagnetCalendarCreator("Calendar", "Calendar");
        // 6. 탁상 달력을 만드는 생성자나 메서드를 등록한다. 2개의 오버로딩된 메서드가 있으니 본인의 설계에 적합한 버전을 사용할 것.
        registry.registerDeskCalendarCreator("Calendar", "Calendar");
        // 7. 가로 방향 배너를 만드는 생성자나 메서드를 등록한다. 2개의 오버로딩된 메서드가 있으니 본인의 설계에 적합한 버전을 사용할 것.
        registry.registerLandscapeBannerCreator("Banner", "Banner");
        // 8. 세로 방향 배너를 만드는 생성자나 메서드를 등록한다. 2개의 오버로딩된 메서드가 있으니 본인의 설계에 적합한 버전을 사용할 것.
        registry.registerPortraitBannerCreator("Banner", "Banner");
        // 9. 반사 배너를 만드는 생성자나 메서드를 등록한다. 2개의 오버로딩된 메서드가 있으니 본인의 설계에 적합한 버전을 사용할 것.
        registry.registerGlossBannerCreator("Banner", "Banner");
        // 10. 스크림 배너를 만드는 생성자나 메서드를 등록한다. 2개의 오버로딩된 메서드가 있으니 본인의 설계에 적합한 버전을 사용할 것.
        registry.registerScrimBannerCreator("Banner", "Banner");
        // 11. 메쉬 배너를 만드는 생성자나 메서드를 등록한다. 2개의 오버로딩된 메서드가 있으니 본인의 설계에 적합한 버전을 사용할 것.
        registry.registerMeshBannerCreator("Banner", "Banner");
        // 12. 가로 방향 명함을 만드는 생성자나 메서드를 등록한다. 2개의 오버로딩된 메서드가 있으니 본인의 설계에 적합한 버전을 사용할 것.
        registry.registerLandscapeBusinessCardCreator("BusinessCard", "BusinessCard");
        // 13. 세로 방향 명함을 만드는 생성자나 메서드를 등록한다. 2개의 오버로딩된 메서드가 있으니 본인의 설계에 적합한 버전을 사용할 것.
        registry.registerPortraitBusinessCardCreator("BusinessCard", "BusinessCard");
        // 14. 아이보리 종이에 찍는 명함을 만드는 생성자나 메서드를 등록한다. 2개의 오버로딩된 메서드가 있으니 본인의 설계에 적합한 버전을 사용할 것.
        registry.registerIvoryBusinessCardCreator("BusinessCard", "BusinessCard");
        // 15. 회색 종이에 찍는 명함을 만드는 생성자나 메서드를 등록한다. 2개의 오버로딩된 메서드가 있으니 본인의 설계에 적합한 버전을 사용할 것.
        registry.registerGrayBusinessCardCreator("BusinessCard", "BusinessCard");
        // 16. 흰색 종이에 찍는 명함을 만드는 생성자나 메서드를 등록한다. 2개의 오버로딩된 메서드가 있으니 본인의 설계에 적합한 버전을 사용할 것.
        registry.registerWhiteBusinessCardCreator("BusinessCard", "BusinessCard");
        // 17. 레이드지 인쇄용지에 찍는 명함을 만드는 생성자나 메서드를 등록한다. 2개의 오버로딩된 메서드가 있으니 본인의 설계에 적합한 버전을 사용할 것.
        registry.registerLaidBusinessCardCreator("BusinessCard", "BusinessCard");
        // 18. 린넨커버 인쇄용지에 찍는 명함을 만드는 생성자나 메서드를 등록한다. 2개의 오버로딩된 메서드가 있으니 본인의 설계에 적합한 버전을 사용할 것.
        registry.registerLinenBusinessCardCreator("BusinessCard", "BusinessCard");
        // 19. 스노우지 인쇄용지에 찍는 명함을 만드는 생성자나 메서드를 등록한다. 2개의 오버로딩된 메서드가 있으니 본인의 설계에 적합한 버전을 사용할 것.
        registry.registerSmoothBusinessCardCreator("BusinessCard", "BusinessCard");
        // 20. 단면 명함을 만드는 생성자나 메서드를 등록한다. 2개의 오버로딩된 메서드가 있으니 본인의 설계에 적합한 버전을 사용할 것.
        registry.registerSingleSidedBusinessCardCreator("BusinessCard", "BusinessCard");
        // 21. 양면 명함을 만드는 생성자나 메서드를 등록한다. 2개의 오버로딩된 메서드가 있으니 본인의 설계에 적합한 버전을 사용할 것.
        registry.registerDoubleSidedBusinessCardCreator("BusinessCard", "BusinessCard");
        // 22. 장바구니를 만드는 생성자를 등록한다.
        registry.registerCartCreator("ShoppingCart");
        // 23. 장바구니에 상품을 추가하는 메서드를 등록한다.
        registry.registerProductAdder("ShoppingCart", "addProductToCart");
        // 24. 장바구니에서 상품을 제거하는 메서드를 등록한다.
        registry.registerProductRemover("ShoppingCart", "removeProductFromCart");
        // 25. 장바구니에서 총액을 구해오는 메서드를 등록한다.
        registry.registerTotalPriceGetter("ShoppingCart", "getTotalPrice");
        // 26. 가로 방향 배너에 문구를 추가하는 메서드를 등록한다.
        registry.registerLandscapeBannerTextApertureAdder("Banner", "addAperture");
        // 27. 가로 방향 배너에 사진을 추가하는 메서드를 등록한다.
        registry.registerLandscapeBannerImageApertureAdder("Banner", "addAperture");
        // 28. 세로 방향 배너에 문구를 추가하는 메서드를 등록한다.
        registry.registerPortraitBannerTextApertureAdder("Banner", "addAperture");
        // 29. 세로 방향 배너에 사진을 추가하는 메서드를 등록한다.
        registry.registerPortraitBannerImageApertureAdder("Banner", "addAperture");
        // 30. 반사 배너에 문구를 추가하는 메서드를 등록한다.
        registry.registerGlossBannerTextApertureAdder("Banner", "addAperture");
        // 31. 반사 배너에 사진을 추가하는 메서드를 등록한다.
        registry.registerGlossBannerImageApertureAdder("Banner", "addAperture");
        // 32. 스크림 배너에 문구를 추가하는 메서드를 등록한다.
        registry.registerScrimBannerTextApertureAdder("Banner", "addAperture");
        // 33. 스크림 배너에 사진을 추가하는 메서드를 등록한다.
        registry.registerScrimBannerImageApertureAdder("Banner", "addAperture");
        // 34. 메쉬 배너에 문구를 추가하는 메서드를 등록한다.
        registry.registerMeshBannerTextApertureAdder("Banner", "addAperture");
        // 35. 메쉬 배너에 사진을 추가하는 메서드를 등록한다.
        registry.registerMeshBannerImageApertureAdder("Banner", "addAperture");
        // 36. 가로 방향 명함에 문구를 추가하는 메서드를 등록한다.
        registry.registerLandscapeBusinessCardTextApertureAdder("Banner", "addAperture");
        // 37. 가로 방향 명함에 사진을 추가하는 메서드를 등록한다.
        registry.registerLandscapeBusinessCardImageApertureAdder("BusinessCard", "addAperture");
        // 38. 세로 방향 명함에 문구를 추가하는 메서드를 등록한다.
        registry.registerPortraitBusinessCardTextApertureAdder("BusinessCard", "addAperture");
        // 39. 세로 방향 명함에 사진을 추가하는 메서드를 등록한다.
        registry.registerPortraitBusinessCardImageApertureAdder("BusinessCard", "addAperture");
        // 40. 아이보리 종이에 찍는 명함에 문구를 추가하는 메서드를 등록한다.
        registry.registerIvoryBusinessCardTextApertureAdder("BusinessCard", "addAperture");
        // 41. 아이보리 종이에 찍는 명함에 사진을 추가하는 메서드를 등록한다.
        registry.registerIvoryBusinessCardImageApertureAdder("BusinessCard", "addAperture");
        // 42. 회색 종이에 찍는 명함에 문구를 추가하는 메서드를 등록한다.
        registry.registerGrayBusinessCardTextApertureAdder("BusinessCard", "addAperture");
        // 43. 회색 종이에 찍는 명함에 사진을 추가하는 메서드를 등록한다.
        registry.registerGrayBusinessCardImageApertureAdder("BusinessCard", "addAperture");
        // 44. 흰색 종이에 찍는 명함에 문구를 추가하는 메서드를 등록한다.
        registry.registerWhiteBusinessCardTextApertureAdder("BusinessCard", "addAperture");
        // 45. 흰색 종이에 찍는 명함에 사진을 추가하는 메서드를 등록한다.
        registry.registerWhiteBusinessCardImageApertureAdder("BusinessCard", "addAperture");
        // 46. 레이드지 인쇄용지에 찍는 명함에 문구를 추가하는 메서드를 등록한다.
        registry.registerLaidBusinessCardTextApertureAdder("BusinessCard", "addAperture");
        // 47. 레이드지 인쇄용지에 찍는 명함에 사진을 추가하는 메서드를 등록한다.
        registry.registerLaidBusinessCardImageApertureAdder("BusinessCard", "addAperture");
        // 48. 린넨커버 인쇄용지에 찍는 명함에 문구를 추가하는 메서드를 등록한다.
        registry.registerLinenBusinessCardTextApertureAdder("BusinessCard", "addAperture");
        // 49. 린넨커버 인쇄용지에 찍는 명함에 사진을 추가하는 메서드를 등록한다.
        registry.registerLinenBusinessCardImageApertureAdder("BusinessCard", "addAperture");
        // 50. 스노우지 인쇄용지에 찍는 명함에 문구를 추가하는 메서드를 등록한다.
        registry.registerSmoothBusinessCardTextApertureAdder("BusinessCard", "addAperture");
        // 51. 스노우지 인쇄용지에 찍는 명함에 사진을 추가하는 메서드를 등록한다.
        registry.registerSmoothBusinessCardImageApertureAdder("BusinessCard", "addAperture");
        // 52. 단면 명함에 문구를 추가하는 메서드를 등록한다.
        registry.registerSingleSidedBusinessCardTextApertureAdder("BusinessCard", "addAperture");
        // 53. 단면 명함에 사진을 추가하는 메서드를 등록한다.
        registry.registerSingleSidedBusinessCardImageApertureAdder("BusinessCard", "addAperture");
        // 54. 양면 명함에 문구를 추가하는 메서드를 등록한다.
        registry.registerDoubleSidedBusinessCardTextApertureAdder("BusinessCard", "addAperture");
        // 55. 양면 명함에 사진을 추가하는 메서드를 등록한다.
        registry.registerDoubleSidedBusinessCardImageApertureAdder("BusinessCard", "addAperture");
    }
}
