import database.Saver;

import java.io.Serializable;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class DataBaseWorker implements Serializable { //мб checklist останется (нет)
    private  List<Check> checks;
    private final Saver saver = new Saver();
    private Connection connection = null;

    public DataBaseWorker(){
        this.checks = new ArrayList<>();
        this.saver.createTable();
        this.connection = saver.getConnect();
    }
    public List<Check> getChecks() {
        return checks;
    }

    public void add(Check check) {
        checks.add(check);
        saver.addPoint(check.getX(),check.getY(),check.getR(),check.isResult());
    }



    public List<Check> getPoints(){ //должен достать точки при запуске приложения, если они есть
       try {
           Statement statement = connection.createStatement();
           ResultSet resultSet = statement.executeQuery("SELECT FROM results");
           while (resultSet.next()){
               Check check = new Check();
               check.setX(resultSet.getDouble(1));
               check.setY(resultSet.getDouble(2));
               check.setR(resultSet.getDouble(3));
               check.setResult(resultSet.getBoolean(4));
               this.checks.add(check);
           }
       } catch (SQLException e){
           //ignored
       }
        return this.checks;
    }

}
