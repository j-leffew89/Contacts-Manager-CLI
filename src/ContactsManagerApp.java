import ConsoleManager.ConsoleUIProvider;
import ConsoleManager.Input;

public class ContactsManagerApp {
    public static void main(String[] args) {
        init();
    }

    public static void init() {

        ConsoleUIProvider uiProvider = new ConsoleUIProvider();
        uiProvider.printMainMenu();

    }
}