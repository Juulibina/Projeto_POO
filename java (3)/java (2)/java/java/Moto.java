public class Moto extends Veiculo {
    private int cilindradas;
    private String tipoCombustivel;
    private String cor;
    private int quilometragem;
    private double preco;
    

    public Moto(String marca, String modelo, int ano, int cilindradas, String tipoCombustivel, String cor, int quilometragem, double preco) {
        super(marca, modelo, ano, cor, quilometragem, preco);
        this.cilindradas = cilindradas;
        this.tipoCombustivel = tipoCombustivel;
        this.cor = cor;
        this.quilometragem = quilometragem;
        this.preco = preco;
        
    }

    public static Moto fromTexto(String linha) {
        String[] partes = linha.split(";");
    
        String marca = partes[0];
        String modelo = partes[1];
        int ano = Integer.parseInt(partes[2]);
        int cilindrada = Integer.parseInt(partes[3]);
        String tipoFreio = partes[4];
        String cor = partes[5];
        int quilometragem = Integer.parseInt(partes[6]);
        double preco = Double.parseDouble(partes[7]);
        
    
        return new Moto(marca, modelo, ano, cilindrada, tipoFreio, cor, quilometragem, preco);
    }
    

    public void exibirDetalhes() {
        System.out.println("Moto: " + getMarca() + " " + getModelo() + " " + getAno());
        System.out.println("Cilindradas: " + cilindradas);
        System.out.println("Tipo de Combustível: " + tipoCombustivel);
        System.out.println("Cor: " + cor);
        System.out.println("Quilometragem: " + quilometragem);
        System.out.println("Preço: " + preco);
        

    }


    public int getCilindradas() {
        return cilindradas;
    }

    public void setCilindradas(int cilindradas) {
        this.cilindradas = cilindradas;
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
        precoVenda = cilindradas*2;
        preco = precoVenda;
        
        
    
        

    }

    

}
