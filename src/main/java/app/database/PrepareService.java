package app.database;

import app.parametr.Client;
import app.parametr.Project;
import app.parametr.Worker;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.time.LocalDate;

public class PrepareService {
    private PreparedStatement InsWorker;
    private PreparedStatement InsClient;
    private PreparedStatement InsProject;
    private PreparedStatement InsProjectWorker;

    public PrepareService(Database database) throws SQLException {
        Connection connection = database.getConnection();

        InsWorker = connection.prepareStatement(
                "INSERT INTO worker (name, birthday, level, salary) VALUES(?,?,?,?)"
        );
        InsClient = connection.prepareStatement(
                "INSERT INTO client (name) VALUES(?)"
        );
        InsProject = connection.prepareStatement(
                "INSERT INTO project (client_id, start_date, finish_date) VALUES(?,?,?)"
        );
        InsProjectWorker = connection.prepareStatement(
                "INSERT INTO project_worker (project_id, worker_id) VALUES(?,?)"
        );
    }
    public boolean createNewWorker(Worker worker) {
        try {
            System.out.println("Executing SQL: " + "INSERT INTO worker (name, birthday, level, salary) VALUES(?,?,?,?)");
            InsWorker.setString(1, worker.getName());
            InsWorker.setString(1,worker.getName());
            InsWorker.setString(2,worker.getBirthday().toString());
            InsWorker.setString(3, worker.getLevel());
            InsWorker.setInt(4, worker.getSalary());
            return InsWorker.executeUpdate() > 0;
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return false;
    }
    public boolean createNewClient(Client client) {
        try {
            InsClient.setString(1, client.getName());

            return InsClient.executeUpdate() > 0;
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return false;
    }
    public boolean createNewProject(Project project) {

        try {
            InsProject.setInt(1,project.getClientId());
            InsProject.setString(2, project.getStartDate().toString());
            InsProject.setString(3, project.getFinishDate().toString());

            return InsProject.executeUpdate() > 0;
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return false;
    }
    public boolean createNewProjectWorker(int project_id, int worker_id) {
        try {
            InsProjectWorker.setInt(1,project_id);
            InsProjectWorker.setInt(2,worker_id);

            return InsProjectWorker.executeUpdate() > 0;
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return false;
    }

}
