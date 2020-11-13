package database;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
@ManagedBean
@SessionScoped
public class DBconnector {
    private DataSource dataSource;
    private Connection connection;

    protected void doConnect() {
        try {
            Class.forName("org.postgresql.Driver").getDeclaredConstructor().newInstance();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void Connect() throws NamingException {
        Context context = new InitialContext();
        dataSource = (DataSource) context.lookup("java:jboss/lab3DS");
        try {
            connection = dataSource.getConnection();
            connection.createStatement().execute(
                    "CREATE  TABLE results(" +
                            "x float)"
            );
        } catch (SQLException e) {
            //ignored
        }

    }

    public void putSmth() throws SQLException{
        if(connection==null){
            try {
                Connect();
            }catch (NamingException e){
                e.printStackTrace();
            }
        }
        PreparedStatement preparedStatement = connection.prepareStatement("insert into results(x) value(1)");
        preparedStatement.execute();
    }

}