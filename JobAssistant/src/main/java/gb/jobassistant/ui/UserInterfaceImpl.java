package gb.jobassistant.ui;

import gb.jobassistant.data.JobInfo;
import gb.jobassistant.data.JobKind;

import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class UserInterfaceImpl implements UserInterface<JobInfo> {
    public UserInterfaceImpl() {
    }

    /**
     * Вывод списка на консоль
     *
     * @param list - список для отображения
     */
    public void printList(List<JobInfo> list) {
        for (JobInfo s : list){
            System.out.println(s.toString());
        }
    }

    /**
     * Запрос информации о вакансии у пользователя
     * @return  - JobKind на основе введенных данных
     */
    public JobInfo askData(){
        String name = this.getStringConsole("Наименование вакансии: ");
        String skills = this.getStringConsole("Навыки: ");
        String text = this.getStringConsole("Описание: ");
        Double summa = this.getDoubleConsole("Зарплата: ");
        int kind = this.getIntegerConsole("Вид (1-удаленноб 2-офис, 3-смешанный): ") - 1;

        JobKind jobKind;
        switch (kind){
            case 0 -> jobKind = JobKind.REMOTE;
            case 1 -> jobKind = JobKind.OFFICE;
            default -> jobKind = JobKind.MIXED;
        }

        return new JobInfo(name, skills, text, summa, jobKind);
    }

    /**
     * Вывод пользовательского меню
     *
     * @param menuList - список пунктов для отображения
     * @return
     */
    @Override
    public int showMenu(String[] menuList) {
        int menu = 1;

        for (String s: menuList){
            System.out.println(s);
        }

        menu = getIntegerConsole("> ");
        menu = (menu < 0 || menu >= menuList.length) ? 0 : menu;

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
        System.out.print(message);
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
