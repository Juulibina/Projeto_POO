public class Carro extends Veiculo {
    private int quantidadePortas;
    private String tipoCombustivel;
    private String cor;
    private int quilometragem;
    private double preco;

    public Carro(String marca, String modelo, int ano, int quantidadePortas, String tipoCombustivel, String cor, int quilometragem, double preco) {
        super(marca, modelo, ano, cor, quilometragem, preco);
        this.quantidadePortas = quantidadePortas;
        this.tipoCombustivel = tipoCombustivel;
        this.cor = cor;
        this.quilometragem = quilometragem;
        this.preco = preco;
    }

    public static Carro fromTexto(String linha) {
        String[] partes = linha.split(";");
    
        String marca = partes[0];
        String modelo = partes[1];
        int ano = Integer.parseInt(partes[2]);
        int quantidadePortas = Integer.parseInt(partes[3]);
        String tipoCombustivel = partes[4];
        String cor = partes[5];
        int quilometragem = Integer.parseInt(partes[6]);
        double preco = Double.parseDouble(partes[7]);
    
        return new Carro(marca, modelo, ano, quantidadePortas, tipoCombustivel, cor, quilometragem, preco);
    }
    

    public void exibirDetalhes() {
        System.out.println("Carro: " + getMarca() + " " + getModelo() + " " + getAno());
        System.out.println("Quantidade de Portas: " + quantidadePortas);
        System.out.println("Tipo de Combustível: " + tipoCombustivel);
        System.out.println("Cor: " + cor);
        System.out.println("Quilometragem: " + quilometragem);
        System.out.println("Preço: " + preco);
    }

    public int getQuantidadePortas() {
        return quantidadePortas;
    }

    public void setQuantidadePortas(int quantidadePortas) {
        this.quantidadePortas = quantidadePortas;
    }

    public String getTipoCombustivel() {
        return tipoCombustivel;
    }

    public void setTipoCombustivel(String tipoCombustivel) {
        this.tipoCombustivel = tipoCombustivel;
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

    public void calcularPrecoVenda(){
        double precoVenda;
        precoVenda = quilometragem/2;
        preco = precoVenda;
        
        
    
        

    }
}
