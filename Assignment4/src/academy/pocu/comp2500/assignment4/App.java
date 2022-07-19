package academy.pocu.comp2500.assignment4;

import academy.pocu.comp2500.assignment4.registry.Registry;

public class App {
    public App(Registry registry) {
        registry.registerDrawPixelCommandCreator("CommandDrawPixel");
        registry.registerIncreasePixelCommandCreator("CommandIncreasePixel");
        registry.registerDecreasePixelCommandCreator("CommandDecreasePixel");
        registry.registerToUppercaseCommandCreator("CommandToUpper");
        registry.registerToLowercaseCommandCreator("CommandToLower");
        registry.registerFillHorizontalLineCommandCreator("CommandFillHorizontalLine");
        registry.registerFillVerticalLineCommandCreator("CommandFillVerticalLine");
        registry.registerClearCommandCreator("CommandClear");
    }
}
