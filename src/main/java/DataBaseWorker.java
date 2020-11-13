import database.Saver;

import java.io.Serializable;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DataBaseWorker implements Serializable { //мб checklist останется
    private  CheckList checkList;
    private final Saver saver = new Saver();
    private Connection connection = null;

    public DataBaseWorker(){
        this.saver.createTable();
        this.connection = saver.getConnect();
    }

    public CheckList getCheckList() {
        return this.checkList;
    }

    public void setCheckList(CheckList checkList) {
        this.checkList = checkList;
    }

    public CheckList getPoints(){
        checkList = new CheckList();
       try {
           Statement statement = connection.createStatement();
           ResultSet resultSet = statement.executeQuery("SELECT FROM results");
           while (resultSet.next()){
               Check check = new Check();
               check.setX(resultSet.getDouble(1));
               check.setY(resultSet.getDouble(2));
               check.setR(resultSet.getDouble(3));
               check.setResult(resultSet.getBoolean(4));
               checkList.add(check);
           }
       } catch (SQLException e){
           //ignored
       }
        return checkList;
    }

}
