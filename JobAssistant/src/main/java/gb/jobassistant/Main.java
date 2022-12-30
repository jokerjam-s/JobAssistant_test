package gb.jobassistant;

import gb.jobassistant.ui.UserInterfaceImpl;

public class Main {
    public static void main(String[] args) {
        UserInterfaceImpl ui = new UserInterfaceImpl();

        Double dd = ui.getDoubleConsole("Оклад: ");

        System.out.println(dd);
    }
}