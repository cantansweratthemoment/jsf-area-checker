package database;

import java.sql.*;

public class Saver {
    private static Connection connection = null;
    private static final Connect connect = new Connect();

    protected void init(){
        connection = connect.getConnection();
    }

    public void createTable(){
        init();
        try {
            Statement statement = connection.createStatement();
            statement.executeUpdate("CREATE TABLE results(float x, float y, float r, result bool)");
        }catch (SQLException sqlException){
            //ignored
        }
    }
    
    public void addPoint(double x, double y, double r, String result){
        try {
            if(connection == null){
                init();
            }
            PreparedStatement statement = connection.prepareStatement("INSERT INTO results(x,y,r,bool) values(?, ?, ?, ?)");
            statement.setDouble(1, x);
            statement.setDouble(2, y);
            statement.setDouble(3, r);
            statement.setString(4, result);
            statement.executeUpdate();
        }catch (SQLException sqlException){
            //ignored
        }
    }

}
