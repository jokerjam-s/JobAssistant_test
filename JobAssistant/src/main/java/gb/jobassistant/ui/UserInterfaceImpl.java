package gb.jobassistant.ui;

import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class UserInterfaceImpl implements UserInterface {
    public UserInterfaceImpl() {
    }

    /**
     * Вывод пользовательского меню
     *
     * @param menuList - список пунктов для отображения
     * @return
     */
    @Override
    public int showMenu(List<String> menuList) {
        int menu = 1;

        for (String s: menuList){
            System.out.println(s);
        }

        menu = getIntegerConsole("> ");
        menu = (menu < 0 || menu >= menuList.size()) ? 0 : menu;

        return menu;
    }

    /**
     * Запрос вещественных числовых данных.
     *
     * @param message - сообщение пользователю
     * @return
     */
    @Override
    public double getDoubleConsole(String message) {
        boolean isErrorValue = true;
        double value = 0;

        while (isErrorValue){
            try{
                Scanner scanner = new Scanner(System.in);
                System.out.print(message);
                value = scanner.nextDouble();
                isErrorValue = false;
            }catch (InputMismatchException ex){
                System.out.println("Неверный ввод. Повторите.");
            }
        }
        return value;
    }

    /**
     * Запрос текстовых данных с консоли
     *
     * @param message - сообщение пользователю
     * @return
     */
    @Override
    public String getStringConsole(String message) {
        Scanner scanner = new Scanner(System.in);
        return scanner.nextLine();
    }

    /**
     * Запрос целочисленных данных с консоли
     *
     * @param message - сообщение пользователю
     * @return
     */
    @Override
    public int getIntegerConsole(String message) {
        boolean isErrorValue = true;
        int value = 0;

        while (isErrorValue){
            try{
                Scanner scanner = new Scanner(System.in);
                System.out.print(message);
                value = scanner.nextInt();
                isErrorValue = false;
            }catch (InputMismatchException ex){
                System.out.println("Неверный ввод. Повторите.");
            }
        }
        return value;

    }
}
