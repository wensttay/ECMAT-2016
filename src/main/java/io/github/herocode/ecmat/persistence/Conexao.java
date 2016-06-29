package io.github.herocode.ecmat.persistence;

import java.net.URI;
import java.net.URISyntaxException;
import java.sql.Connection;
import java.sql.SQLException;
import org.apache.commons.dbcp2.BasicDataSource;

public final class Conexao {
    
    private static Conexao conexao;
    
    private Conexao() { }
    
    public static synchronized Conexao getInstance(){
        
        if(conexao == null){
            conexao = new Conexao();
        }
        
        return conexao;
    }

    private BasicDataSource connectionPool;

    public Connection getConnection() throws SQLException {

        if (connectionPool == null || connectionPool.isClosed()) {

            try {

                URI dbUri       = new URI(System.getenv("DATABASE_URL"));
                String username = dbUri.getUserInfo().split(":")[0];
                String password = dbUri.getUserInfo().split(":")[1];
                
                StringBuilder dbUrl = new StringBuilder();
                dbUrl.append("jdbc:postgresql://").
                        append(dbUri.getHost()).
                        append(':').
                        append(dbUri.getPort()).
                        append(':').
                        append(dbUri.getPath());
                
                connectionPool = new BasicDataSource();

                connectionPool.setUsername(username);
                connectionPool.setPassword(password);
                connectionPool.setDriverClassName("org.postgresql.Driver");
                connectionPool.setUrl(dbUrl.toString());
                
            } catch (URISyntaxException | IndexOutOfBoundsException ex) {
                connectionPool.close();
                return null;
            }

        }

        return connectionPool.getConnection();
    }

}
