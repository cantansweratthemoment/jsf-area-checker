package database;

import java.sql.*;
import java.util.List;

public class Saver {
    private  Connection connection = null;
    private final Connect connect = new Connect();

    protected void init(){
        connection = connect.getConnection();
    }

    public void createTable(){
        init();
        try {
            Statement statement = connection.createStatement();
            statement.executeUpdate("CREATE TABLE results(float x, float y, float r, boolean bool)");
        }catch (SQLException sqlException){
            //ignored
        }
    }
    
    public void addPoint(double x, double y, double r, boolean result){
        try {
            if(connection == null){
                init();
            }
            PreparedStatement statement = connection.prepareStatement("INSERT INTO results(x,y,r,bool) values(?, ?, ?, ?)");
            statement.setDouble(1, x);
            statement.setDouble(2, y);
            statement.setDouble(3, r);
            statement.setBoolean(4, result);
            statement.executeUpdate();
        }catch (SQLException sqlException){
            //ignored
        }
    }

    public  Connection getConnect() {
        return this.connection;
    }

}
