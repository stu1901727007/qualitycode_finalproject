package uni.plovdiv;

import uni.plovdiv.models.Employee;
import uni.plovdiv.models.EmployeeRoles;
import uni.plovdiv.models.Project;
import uni.plovdiv.models.Task;
import uni.plovdiv.services.EmployeeService;
import uni.plovdiv.services.ProjectService;
import uni.plovdiv.services.TaskMessageService;
import uni.plovdiv.services.TaskService;

public class Main {

    public static void main(String[] args) {


        /**
         *
         * Да се разработи система за управление на проекти.
         * Всеки проект може да съдържа други проекти.
         *
         * Участници:
         *      - ръководител;
         *      - нормални разработчици;
         *
         * Към проекта могат да се създават различни задачи,
         * като всяка задача може да съдържа подзадачи.
         *
         * По задачите не може да се започне работа докато не се определи кой служител ще работи по нея.
         * Задачите трябва да има някой от статусите:
         *      - нова;
         *      - в процес на разработка;
         *      - завършена;
         *      - отказана;
         *
         * При смяна на статус е необходимо да се въведе кратко информационно съобщение.
         * На задача, която е завършена не може да се сменя статуса.
         *
         */

        System.out.println("It works!");
    }
}
