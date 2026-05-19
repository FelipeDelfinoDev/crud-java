package persistence;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import model.Produto;


public class JDBCProduto {
    
    Connection conexao;

    public JDBCProduto(Connection conexao) {
        this.conexao = conexao;
    }
    
    public void inserirProduto(Produto p){
        String sql = "insert into produto (nome, valor, qtd) values (?,?,?)";
        PreparedStatement ps;
        try {
            ps = this.conexao.prepareStatement(sql);
            ps.setString(1,p.getNome());
            ps.setInt(2, p.getValor());
            ps.setInt(3, p.getQtd());
            ps.execute();
        } catch(SQLException e) {
            e.printStackTrace();
        }
    }
    
    public ArrayList<Produto> listarProduto(){
        
        ArrayList<Produto> produtos = new ArrayList<Produto>();
        String sql = "select * from produto";
        
        try {
            
            Statement declaracao = conexao.createStatement();
            ResultSet resposta = declaracao.executeQuery(sql);
            
            while(resposta.next()){
                
                int id = resposta.getInt("id");
                String nome = resposta.getString("nome");
                int valor = resposta.getInt("valor");
                int qtd = resposta.getInt("qtd");
                
                Produto p = new Produto();
                
                p.setId(id);
                p.setNome(nome);
                p.setValor(valor);
                p.setQtd(qtd);
                        
                produtos.add(p);
            }
            
        } catch(SQLException e) {
            
            e.printStackTrace();
            
        }
        
        return produtos;
        
    }
    
    public void apagarTudo(){
        String sql = "delete from produto";
        
        PreparedStatement ps;
        
        try{
            
            ps = this.conexao.prepareStatement(sql);
            ps.execute();
            
        } catch(SQLException e) {
            
            e.printStackTrace();
            
        }
        
    }
    
}
