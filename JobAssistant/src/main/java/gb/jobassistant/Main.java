package gb.jobassistant;

import gb.jobassistant.controller.JobAssistantController;

public class Main {
    public static void main(String[] args) {
        JobAssistantController controller = new JobAssistantController();

        controller.Run();
    }
}