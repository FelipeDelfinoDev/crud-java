
package persistence;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ConnectionFactory {
    private Connection conexao;
    
    public Connection abrirConxao(){
        String url = "jdbc:mysql://";
        String user = "";
        String password = "";
        
        try {
            conexao = DriverManager.getConnection(url,user, password);
        } catch (SQLException ex) {
            Logger.getLogger(ConnectionFactory.class.getName()).log(Level.SEVERE, null, ex);
        }
                
        return conexao;
    }
    
    public void fecharConexao(){
        try {
            conexao.close();
        } catch (SQLException ex) {
            Logger.getLogger(ConnectionFactory.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
