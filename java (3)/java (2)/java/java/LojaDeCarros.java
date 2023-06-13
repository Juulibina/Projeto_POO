import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import java.nio.file.Path;


public class LojaDeCarros {
    private List<Veiculo> veiculos;
    
    private boolean podeRemoverVeiculo(Veiculo veiculo) {
        // Verifique as restrições para determinar se o veículo pode ser removido
        if (veiculo instanceof Carro && veiculo.getAno() <= 2000) {
            return false; //se o carro for de antes de 2000, nao pode ser removido 
        }
        
        if (veiculo instanceof Carro && veiculo.getQuilometragem() >= 200000) {
            return false;
        }
        
        
        
        return true;
    }

    public LojaDeCarros() {
        veiculos = new ArrayList<>();
    }

    public void salvarVeiculoEmArquivo(Veiculo veiculo) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter("veiculos.txt", true))) {
            writer.write(veiculo.getMarca() + " " + veiculo.getModelo() + " " + veiculo.getAno() + " " + veiculo.getCor() + " " + veiculo.getPreco() + " " + veiculo.getQuilometragem());
            writer.newLine();
        } catch (IOException e) {
            System.out.println("Erro ao salvar veículo no arquivo: " + e.getMessage());
        }
    
    }

    public void adicionarVeiculo(Veiculo veiculo) {
        veiculos.add(veiculo);
        salvarVeiculoEmArquivo(veiculo);
    }

    public void removerVeiculo(Veiculo veiculo) throws VeiculoNaoRemovidoException {
        if (!podeRemoverVeiculo(veiculo)) {
            throw new VeiculoNaoRemovidoException("Veículo não pode ser removido devido a restrições específicas. ");
            
        }

        veiculos.remove(veiculo);

        try {
            List<String> linhas = Files.readAllLines(Paths.get("veiculos.txt"));
            BufferedWriter writer = new BufferedWriter(new FileWriter("veiculos.txt"));

            for (String linha : linhas) {
                if (!linha.equals(veiculo.toString())) {
                    writer.write(linha);
                    writer.newLine();
                }
            }

            writer.close();
        } catch (IOException e) {
            System.out.println("Erro ao remover o veículo do arquivo.");
            
            e.printStackTrace();
        }
    }

    public List<Veiculo> getVeiculos() {
        try{
        Path caminho = Paths.get("C:/txt/veiculos.tx");
        List<String> strings = Files.readAllLines(caminho);
        for(String texto : strings){
            System.out.println(texto);
}} catch (IOException e){
            
        }   
        return veiculos;
    }

    public void carregarVeiculosDoArquivo() {
        
        Path caminho = Paths.get("C:/txt/veiculos.tx");
        try {
        byte[] texto = Files.readAllBytes(caminho);
        String leitura = new String(texto);

        JOptionPane.showMessageDialog(null, leitura);

        } catch(Exception erro) {

        }
    }
    
    
}
