package gb.jobassistant.controller;

import gb.jobassistant.data.JobInfo;
import gb.jobassistant.service.SqlJobAssistant;
import gb.jobassistant.ui.UserInterfaceImpl;

import java.io.File;
import java.util.List;

public class JobAssistantController {
    private UserInterfaceImpl ui = new UserInterfaceImpl();
    private SqlJobAssistant assistant = new SqlJobAssistant();
    private final String[] userMenu = new String[] {
            "1 - ввод данных",
            "2 - поиск ",
            "0 - выход"
    };


    public void Run(){
        int menu;
        JobInfo info;

        while ((menu = ui.showMenu(userMenu)) > 0){
            switch (menu){
                case 1 -> newInfo();
                case 2 -> findInfo();
            }
        }
    }

    /**
     * Добавлениеи информации в БД
     */
    public void newInfo(){
        JobInfo info = ui.askData();
        assistant.add(info);
    }

    /**
     * Поиск по БД
     */
    public void findInfo(){
        String findString = ui.getStringConsole("Значениеи для поиска: ");
        List<JobInfo> infoList = assistant.find(findString);
        ui.printList(infoList);
    }
}
