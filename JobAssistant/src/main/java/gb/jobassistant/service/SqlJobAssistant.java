package gb.jobassistant.service;

import gb.jobassistant.data.JobInfo;
import gb.jobassistant.data.JobKind;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

public class SqlJobAssistant {

    public SqlJobAssistant() {
    }

    public JobInfo add(JobInfo info){
        try(Connection connection = SQLiteConnection.getConnection();
            PreparedStatement statement = connection.prepareStatement(
                    "insert into vacancy (name, skills, text, summa, kind) values (?,?,?,?,?)",
                    Statement.RETURN_GENERATED_KEYS)
        ){
            statement.setString(1, info.getName());
            statement.setString(2, info.getSkills());
            statement.setString(3, info.getText());
            statement.setDouble(4, info.getSumma());
            int kind;
            switch (info.getJobKind()){
                case REMOTE -> kind = 0;
                case OFFICE -> kind = 1;
                default -> kind = 2;
            }
            statement.setInt(5, kind);

            int result = statement.executeUpdate();
            info.setId(result);
        } catch (SQLException e) {
            Logger.getAnonymousLogger().info(e.getMessage());
        }

        return info;
    }

    public List<JobInfo> find(String findString){
        List<JobInfo> jobList = new ArrayList<>();

        try(Connection connection = SQLiteConnection.getConnection();
            PreparedStatement statement = connection.prepareStatement(
                    "select id, name, skills, text, summa, kind from vacancy where name like ?")
        ) {
            String searchStr = "%" + findString + "%";

            statement.setString(1, searchStr);
            ResultSet result = statement.executeQuery();

            while (result.next()) {
                JobInfo person = new JobInfo();
                person.setId(result.getInt("id"));
                person.setName(result.getString("name"));
                person.setSkills(result.getString("skills"));
                person.setText(result.getString("text"));
                person.setSumma(result.getDouble("summa"));

                int kind = result.getInt("kind");
                switch (kind){
                    case 1 -> person.setJobKind(JobKind.REMOTE);
                    case 2 -> person.setJobKind(JobKind.OFFICE);
                    default -> person.setJobKind(JobKind.MIXED);
                }

                jobList.add(person); // добавляем в коллекцию, чтобы обновить данные в tableView
            }

        } catch (SQLException e) {
            Logger.getAnonymousLogger().info(e.getMessage());
        }

        return jobList;
    }
}
