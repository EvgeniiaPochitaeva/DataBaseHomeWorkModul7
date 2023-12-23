package app;

import app.database.Database;
import app.database.DatabaseQueryService;
import app.database.PrepareService;

import java.lang.reflect.AnnotatedArrayType;
import java.time.LocalDate;

public class App {
    public static void main(String[] args) throws Exception {
        Database database = Database.getInstance();
//        System.out.println(new DatabaseQueryService().findMaxSalaryWorker(database));
//        System.out.println(new DatabaseQueryService().findMaxProjectsClient(database));
//        System.out.println(new DatabaseQueryService().findLongestProject(database));
//        System.out.println(new DatabaseQueryService().findYoungestEldestWorkers(database));
//        System.out.println(new DatabaseQueryService().findProjectPrices(database));

        PrepareService prepareService = new PrepareService(database);
        boolean result = prepareService.createNewWorker(
                "Anna",
                LocalDate.now().minusYears(20),
                "Junior",
                300);
        System.out.println("result = " + result);


        boolean result2 = prepareService.createNewClient("Nasa");
        boolean result3 = prepareService.createNewProject(
                1,
                LocalDate.now().minusMonths(12),
                LocalDate.now().minusMonths(6));
        boolean result4 = prepareService.createNewProjectWorker(11,11);

        System.out.println("result2 = " + result2);
        System.out.println("result3 = " + result3);
        System.out.println("result4 = " + result4);
    }

}
