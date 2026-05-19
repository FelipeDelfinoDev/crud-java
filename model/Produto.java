package model;

public class Produto {
    private int id;
    private String nome;
    private int valor;
    private int qtd;

    public Produto(){}
    
    public Produto(int id, String nome, int valor, int qtd) {
        this.id = id;
        this.nome = nome;
        this.valor = valor;
        this.qtd = qtd;
    }

    public Produto(String nome, int valor, int qtd) {
        this.nome = nome;
        this.valor = valor;
        this.qtd = qtd;
    }    
    
    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getValor() {
        return valor;
    }

    public void setValor(int valor) {
        this.valor = valor;
    }

    public int getQtd() {
        return qtd;
    }

    public void setQtd(int qtd) {
        this.qtd = qtd;
    }
    
    
}
