package database;

import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;

public class Connect {
    private DataSource dataSource = null;
    private Connection connection = null;

    protected void setConnection(){
        try {
            InitialContext initialContext = new InitialContext();
            this.dataSource = (DataSource) initialContext.lookup("");
            if(dataSource != null){
                this.connection = dataSource.getConnection();
            }
        } catch (SQLException sqlException){
            //ignored
        }
        catch (NamingException namingException){
            //ignored
        }
    }

    protected Connection getConnection(){
        return this.connection;
    }

    public Connect(){
        setConnection();
    }
}