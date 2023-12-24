package app;

import app.database.Database;
import app.database.PrepareService;
import app.parametr.Client;
import app.parametr.Project;
import app.parametr.Worker;

import java.time.LocalDate;

public class App {
    public static void main(String[] args) throws Exception {
        Database database = Database.getInstance();


        PrepareService prepareService = new PrepareService(database);

        Worker worker = new Worker("Roman", LocalDate.now().minusYears(5), "Trainee", 200);
        boolean result1 = prepareService.createNewWorker(worker);

        Client client = new Client("Windows");
        boolean result2 = prepareService.createNewClient(client);

        Project project = new Project(1, LocalDate.now().minusMonths(2),LocalDate.now().minusMonths(1));
        boolean result3 = prepareService.createNewProject(project);

        boolean result4 = prepareService.createNewProjectWorker(11,1);

        System.out.println("result1 = " + result1);
        System.out.println("result2 = " + result2);
        System.out.println("result3 = " + result3);
        System.out.println("result4 = " + result4);
    }

}
