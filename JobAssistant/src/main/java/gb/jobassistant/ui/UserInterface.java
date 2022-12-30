package gb.jobassistant.ui;

import java.util.List;

public interface UserInterface <E>  {
    /**
     * Вывод списка на консоль
     *
     * @param list - список для отображения
     */
    void printList(List<E> list);

    /**
     * Вывод пользовательского меню
     * @param menuList  - список пунктов для отображения
     * @return
     */
    int showMenu(String[] menuList);

    /**
     * Запрос вещественных числовых данных,
     * @param message   - сообщение пользователю
     * @return
     */
    double getDoubleConsole(String message);

    /**
     * Запрос текстовых данных с консоли
     * @param message   - сообщение пользователю
     * @return
     */
    String getStringConsole(String message);

    /**
     * Запрос целочисленных данных с консоли
     * @param message   - сообщение пользователю
     * @return
     */
    int getIntegerConsole(String message);

}
