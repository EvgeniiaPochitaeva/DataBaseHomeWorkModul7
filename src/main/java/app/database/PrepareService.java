package app.database;

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
    public boolean createNewWorker(String name, LocalDate birthday, String level, int salary) {
        try {
            InsWorker.setString(1,name);
            InsWorker.setString(2, birthday.toString());
            InsWorker.setString(3, level);
            InsWorker.setInt(4, salary);
            return InsWorker.executeUpdate() > 0;
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return false;
    }
    public boolean createNewClient(String name) {
        try {
            InsClient.setString(1,name);

            return InsClient.executeUpdate() > 0;
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return false;
    }
    public boolean createNewProject(int client_id, LocalDate start_date, LocalDate finish_date) {

        try {
            InsProject.setInt(1,client_id);
            InsProject.setString(2, start_date.toString());
            InsProject.setString(3, finish_date.toString());

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
