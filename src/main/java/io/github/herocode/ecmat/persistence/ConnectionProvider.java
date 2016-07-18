package io.github.herocode.ecmat.persistence;

import java.net.URI;
import java.net.URISyntaxException;
import java.sql.Connection;
import java.sql.SQLException;
import org.apache.commons.dbcp2.BasicDataSource;

public final class ConnectionProvider {
    
    private static ConnectionProvider connectionProvider;

    private BasicDataSource connectionPool;

    
    private ConnectionProvider() { }
    
    public static synchronized ConnectionProvider getInstance(){
        
        if(connectionProvider == null){
            connectionProvider = new ConnectionProvider();
        }
        
        return connectionProvider;
    }

    public Connection getConnection() throws SQLException {

        if (connectionPool == null || connectionPool.isClosed()) {

            try {

                //URI dbUri       = new URI(System.getenv("DATABASE_URL"));
                String username = "postgres";//dbUri.getUserInfo().split(":")[0];
                String password = "123456";//dbUri.getUserInfo().split(":")[1];
                
//                StringBuilder dbUrl = new StringBuilder();
//                dbUrl.append("jdbc:postgresql://").
//                        append(dbUri.getHost()).
//                        append(':').
//                        append(dbUri.getPort()).
//                        append(':').
//                        append(dbUri.getPath());
                
                connectionPool = new BasicDataSource();

                connectionPool.setUsername(username);
                connectionPool.setPassword(password);
                connectionPool.setDriverClassName("org.postgresql.Driver");
                //connectionPool.setUrl(dbUrl.toString());
                connectionPool.setUrl("jdbc:postgresql://localhost:5432/ecmat");
                
            } catch (IndexOutOfBoundsException ex) {
                connectionPool.close();
                return null;
            }

        }

        return connectionPool.getConnection();
    }

}
