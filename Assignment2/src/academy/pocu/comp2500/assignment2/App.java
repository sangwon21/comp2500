package academy.pocu.comp2500.assignment2;

import academy.pocu.comp2500.assignment2.registry.Registry;

public class App {
    public App(Registry registry) {
        // register your classes or methods here
        // 1. 빨강 잉크 스탬프를 만드는 생성자나 메서드를 등록한다. 2개의 오버로딩된 메서드가 있으니 본인의 설계에 적합한 버전을 사용할 것.
        registry.registerRedStampCreator("Stamp");
        // 2. 파랑 잉크 스탬프를 만드는 생성자나 메서드를 등록한다. 2개의 오버로딩된 메서드가 있으니 본인의 설계에 적합한 버전을 사용할 것.
        registry.registerBlueStampCreator("Stamp");
        // 3. 녹색 잉크 스탬프를 만드는 생성자나 메서드를 등록한다. 2개의 오버로딩된 메서드가 있으니 본인의 설계에 적합한 버전을 사용할 것.
        registry.registerGreenStampCreator("Stamp");
        // 4. 벽걸이 달력을 만드는 생성자나 메서드를 등록한다. 2개의 오버로딩된 메서드가 있으니 본인의 설계에 적합한 버전을 사용할 것.
        registry.registerWallCalendarCreator("Calendar");
        // 5. 자석 달력을 만드는 생성자나 메서드를 등록한다. 2개의 오버로딩된 메서드가 있으니 본인의 설계에 적합한 버전을 사용할 것.
        registry.registerMagnetCalendarCreator("Calendar");
        // 6. 탁상 달력을 만드는 생성자나 메서드를 등록한다. 2개의 오버로딩된 메서드가 있으니 본인의 설계에 적합한 버전을 사용할 것.
        registry.registerDeskCalendarCreator("Calendar");
        // 7. 가로 방향 배너를 만드는 생성자나 메서드를 등록한다. 2개의 오버로딩된 메서드가 있으니 본인의 설계에 적합한 버전을 사용할 것.
        registry.registerLandscapeBannerCreator("Banner");
        // 8. 세로 방향 배너를 만드는 생성자나 메서드를 등록한다. 2개의 오버로딩된 메서드가 있으니 본인의 설계에 적합한 버전을 사용할 것.
        registry.registerPortraitBannerCreator("Banner");
        // 9. 반사 배너를 만드는 생성자나 메서드를 등록한다. 2개의 오버로딩된 메서드가 있으니 본인의 설계에 적합한 버전을 사용할 것.
        registry.registerGlossBannerCreator("Banner");
        // 10. 스크림 배너를 만드는 생성자나 메서드를 등록한다. 2개의 오버로딩된 메서드가 있으니 본인의 설계에 적합한 버전을 사용할 것.
        registry.registerScrimBannerCreator("Banner");
        // 11. 메쉬 배너를 만드는 생성자나 메서드를 등록한다. 2개의 오버로딩된 메서드가 있으니 본인의 설계에 적합한 버전을 사용할 것.
        registry.registerMeshBannerCreator("Banner");
        // 12. 가로 방향 명함을 만드는 생성자나 메서드를 등록한다. 2개의 오버로딩된 메서드가 있으니 본인의 설계에 적합한 버전을 사용할 것.
        registry.registerLandscapeBusinessCardCreator("BusinessCard");
        // 13. 세로 방향 명함을 만드는 생성자나 메서드를 등록한다. 2개의 오버로딩된 메서드가 있으니 본인의 설계에 적합한 버전을 사용할 것.
        registry.registerPortraitBusinessCardCreator("BusinessCard");
        // 14. 아이보리 종이에 찍는 명함을 만드는 생성자나 메서드를 등록한다. 2개의 오버로딩된 메서드가 있으니 본인의 설계에 적합한 버전을 사용할 것.
        registry.registerIvoryBusinessCardCreator("BusinessCard");
        // 15. 회색 종이에 찍는 명함을 만드는 생성자나 메서드를 등록한다. 2개의 오버로딩된 메서드가 있으니 본인의 설계에 적합한 버전을 사용할 것.
        registry.registerGrayBusinessCardCreator("BusinessCard");
        // 16. 흰색 종이에 찍는 명함을 만드는 생성자나 메서드를 등록한다. 2개의 오버로딩된 메서드가 있으니 본인의 설계에 적합한 버전을 사용할 것.
        registry.registerWhiteBusinessCardCreator("BusinessCard");
        // 17. 레이드지 인쇄용지에 찍는 명함을 만드는 생성자나 메서드를 등록한다. 2개의 오버로딩된 메서드가 있으니 본인의 설계에 적합한 버전을 사용할 것.
        registry.registerLaidBusinessCardCreator("BusinessCard");
        // 18. 린넨커버 인쇄용지에 찍는 명함을 만드는 생성자나 메서드를 등록한다. 2개의 오버로딩된 메서드가 있으니 본인의 설계에 적합한 버전을 사용할 것.
        registry.registerLinenBusinessCardCreator("BusinessCard");
        // 19. 스노우지 인쇄용지에 찍는 명함을 만드는 생성자나 메서드를 등록한다. 2개의 오버로딩된 메서드가 있으니 본인의 설계에 적합한 버전을 사용할 것.
        registry.registerSmoothBusinessCardCreator("BusinessCard");
        // 20. 단면 명함을 만드는 생성자나 메서드를 등록한다. 2개의 오버로딩된 메서드가 있으니 본인의 설계에 적합한 버전을 사용할 것.
        registry.registerSingleSidedBusinessCardCreator("BusinessCard");
        // 21. 양면 명함을 만드는 생성자나 메서드를 등록한다. 2개의 오버로딩된 메서드가 있으니 본인의 설계에 적합한 버전을 사용할 것.
        registry.registerDoubleSidedBusinessCardCreator("BusinessCard");
        // 22. 장바구니를 만드는 생성자를 등록한다.
        registry.registerCartCreator("ShoppingCart");
        // 23. 장바구니에 상품을 추가하는 메서드를 등록한다.
        registry.registerProductAdder("ShoppingCart", "addProductToCart");
        // 24. 장바구니에서 상품을 제거하는 메서드를 등록한다.
        registry.registerProductRemover("ShoppingCart", "removeProductFromCart");
        // 25. 장바구니에서 총액을 구해오는 메서드를 등록한다.
        registry.registerTotalPriceGetter("ShoppingCart", "getTotalPrice");
        // 26. 가로 방향 배너에 문구를 추가하는 메서드를 등록한다.
        registry.registerLandscapeBannerTextApertureAdder("ProductWithAperture", "addAperture");
        // 27. 가로 방향 배너에 사진을 추가하는 메서드를 등록한다.
        registry.registerLandscapeBannerImageApertureAdder("ProductWithAperture", "addAperture");
        // 28. 세로 방향 배너에 문구를 추가하는 메서드를 등록한다.
        registry.registerPortraitBannerTextApertureAdder("ProductWithAperture", "addAperture");
        // 29. 세로 방향 배너에 사진을 추가하는 메서드를 등록한다.
        registry.registerPortraitBannerImageApertureAdder("ProductWithAperture", "addAperture");
        // 30. 반사 배너에 문구를 추가하는 메서드를 등록한다.
        registry.registerGlossBannerTextApertureAdder("ProductWithAperture", "addAperture");
        // 31. 반사 배너에 사진을 추가하는 메서드를 등록한다.
        registry.registerGlossBannerImageApertureAdder("ProductWithAperture", "addAperture");
        // 32. 스크림 배너에 문구를 추가하는 메서드를 등록한다.
        registry.registerScrimBannerTextApertureAdder("ProductWithAperture", "addAperture");
        // 33. 스크림 배너에 사진을 추가하는 메서드를 등록한다.
        registry.registerScrimBannerImageApertureAdder("ProductWithAperture", "addAperture");
        // 34. 메쉬 배너에 문구를 추가하는 메서드를 등록한다.
        registry.registerMeshBannerTextApertureAdder("ProductWithAperture", "addAperture");
        // 35. 메쉬 배너에 사진을 추가하는 메서드를 등록한다.
        registry.registerMeshBannerImageApertureAdder("ProductWithAperture", "addAperture");
        // 36. 가로 방향 명함에 문구를 추가하는 메서드를 등록한다.
        registry.registerLandscapeBusinessCardTextApertureAdder("ProductWithAperture", "addAperture");
        // 37. 가로 방향 명함에 사진을 추가하는 메서드를 등록한다.
        registry.registerLandscapeBusinessCardImageApertureAdder("ProductWithAperture", "addAperture");
        // 38. 세로 방향 명함에 문구를 추가하는 메서드를 등록한다.
        registry.registerPortraitBusinessCardTextApertureAdder("ProductWithAperture", "addAperture");
        // 39. 세로 방향 명함에 사진을 추가하는 메서드를 등록한다.
        registry.registerPortraitBusinessCardImageApertureAdder("ProductWithAperture", "addAperture");
        // 40. 아이보리 종이에 찍는 명함에 문구를 추가하는 메서드를 등록한다.
        registry.registerIvoryBusinessCardTextApertureAdder("ProductWithAperture", "addAperture");
        // 41. 아이보리 종이에 찍는 명함에 사진을 추가하는 메서드를 등록한다.
        registry.registerIvoryBusinessCardImageApertureAdder("ProductWithAperture", "addAperture");
        // 42. 회색 종이에 찍는 명함에 문구를 추가하는 메서드를 등록한다.
        registry.registerGrayBusinessCardTextApertureAdder("ProductWithAperture", "addAperture");
        // 43. 회색 종이에 찍는 명함에 사진을 추가하는 메서드를 등록한다.
        registry.registerGrayBusinessCardImageApertureAdder("ProductWithAperture", "addAperture");
        // 44. 흰색 종이에 찍는 명함에 문구를 추가하는 메서드를 등록한다.
        registry.registerWhiteBusinessCardTextApertureAdder("ProductWithAperture", "addAperture");
        // 45. 흰색 종이에 찍는 명함에 사진을 추가하는 메서드를 등록한다.
        registry.registerWhiteBusinessCardImageApertureAdder("ProductWithAperture", "addAperture");
        // 46. 레이드지 인쇄용지에 찍는 명함에 문구를 추가하는 메서드를 등록한다.
        registry.registerLaidBusinessCardTextApertureAdder("ProductWithAperture", "addAperture");
        // 47. 레이드지 인쇄용지에 찍는 명함에 사진을 추가하는 메서드를 등록한다.
        registry.registerLaidBusinessCardImageApertureAdder("ProductWithAperture", "addAperture");
        // 48. 린넨커버 인쇄용지에 찍는 명함에 문구를 추가하는 메서드를 등록한다.
        registry.registerLinenBusinessCardTextApertureAdder("ProductWithAperture", "addAperture");
        // 49. 린넨커버 인쇄용지에 찍는 명함에 사진을 추가하는 메서드를 등록한다.
        registry.registerLinenBusinessCardImageApertureAdder("ProductWithAperture", "addAperture");
        // 50. 스노우지 인쇄용지에 찍는 명함에 문구를 추가하는 메서드를 등록한다.
        registry.registerSmoothBusinessCardTextApertureAdder("ProductWithAperture", "addAperture");
        // 51. 스노우지 인쇄용지에 찍는 명함에 사진을 추가하는 메서드를 등록한다.
        registry.registerSmoothBusinessCardImageApertureAdder("ProductWithAperture", "addAperture");
        // 52. 단면 명함에 문구를 추가하는 메서드를 등록한다.
        registry.registerSingleSidedBusinessCardTextApertureAdder("ProductWithAperture", "addAperture");
        // 53. 단면 명함에 사진을 추가하는 메서드를 등록한다.
        registry.registerSingleSidedBusinessCardImageApertureAdder("ProductWithAperture", "addAperture");
        // 54. 양면 명함에 문구를 추가하는 메서드를 등록한다.
        registry.registerDoubleSidedBusinessCardTextApertureAdder("ProductWithAperture", "addAperture");
        // 55. 양면 명함에 사진을 추가하는 메서드를 등록한다.
        registry.registerDoubleSidedBusinessCardImageApertureAdder("ProductWithAperture", "addAperture");
    }
}
