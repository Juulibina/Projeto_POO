

public abstract class Veiculo { // 3. Contém classe abstrata ✅
    private String marca;
    private String modelo;
    private int ano;
    private String cor;
    private int quilometragem;
    private double preco;

    public Veiculo(String marca, String modelo, int ano, String cor, int quilometragem, double preco) {
        this.marca = marca;
        this.modelo = modelo;
        this.ano = ano;
        this.cor = cor;
        this.quilometragem = quilometragem;
        this.preco = preco;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public int getAno() {
        return ano;
    }

    public void setAno(int ano) {
        this.ano = ano;
    }

    public String getCor() {
        return cor;
    }

    public void setCor(String cor) {
        this.cor = cor;
    }

    public int getQuilometragem() {
        return quilometragem;
    }

    public void setQuilometragem(int quilometragem) {
        this.quilometragem = quilometragem;
    }

    public double getPreco() {
        return preco;
    }

    public void setPreco(double preco) {
        this.preco = preco;
    }

    public abstract void exibirDetalhes(); // 4. Programa contém método abstrato ✅

    public void calcularPrecoVenda() {
        
    }

    
}    
