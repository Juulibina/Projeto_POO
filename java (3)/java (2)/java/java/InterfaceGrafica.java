import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.scene.layout.HBox;
import javafx.geometry.Pos;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;


public class InterfaceGrafica extends Application {
    private LojaDeCarros loja;
    private Stage primaryStage;

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        this.primaryStage = primaryStage;
        loja = new LojaDeCarros();

        primaryStage.setTitle("Loja de Carros");

        Label labelTitulo = new Label("Bem-vindo à Loja de Carros");
        Button buttonAdicionar = new Button("Adicionar Veículo");
        Button buttonRemover = new Button("Remover Veículo");
        Button buttonListar = new Button("Listar Veículos");
        
        


        buttonAdicionar.setOnAction(event -> mostrarInterfaceAdicionar());
        buttonRemover.setOnAction(event -> removerVeiculo());
        buttonListar.setOnAction(event -> listarVeiculos());

        VBox vbox = new VBox(10);
        vbox.setPadding(new Insets(20));
        vbox.getChildren().addAll(labelTitulo, buttonAdicionar, buttonRemover, buttonListar);

        Scene scene = new Scene(vbox, 800, 200);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    private void mostrarInterfaceAdicionar() {
        Stage adicionarStage = new Stage();
        adicionarStage.setTitle("Adicionar Veículo");

        Label labelTipoVeiculo = new Label("Selecione o tipo de veículo:");
        ChoiceBox<String> choiceBoxTipoVeiculo = new ChoiceBox<>();
        choiceBoxTipoVeiculo.getItems().addAll("Carro", "Moto");
        choiceBoxTipoVeiculo.setValue("Carro");

        VBox vboxTipoVeiculo = new VBox(10);
        vboxTipoVeiculo.setPadding(new Insets(20));
        vboxTipoVeiculo.getChildren().addAll(labelTipoVeiculo, choiceBoxTipoVeiculo);

        Button buttonSelecionar = new Button("Selecionar");
        buttonSelecionar.setOnAction(event -> {
            String tipoVeiculo = choiceBoxTipoVeiculo.getValue();
            mostrarInterfaceAdicionarVariaveis(tipoVeiculo, adicionarStage);
        });

        VBox vbox = new VBox(10);
        vbox.setPadding(new Insets(20));
        vbox.getChildren().addAll(vboxTipoVeiculo, buttonSelecionar);

        Scene scene = new Scene(vbox, 300, 200);
        adicionarStage.setScene(scene);
        adicionarStage.show();
    }

    private void mostrarInterfaceAdicionarVariaveis(String tipoVeiculo, Stage adicionarStage) {
        Stage adicionarVariaveisStage = new Stage();
        adicionarVariaveisStage.setTitle("Adicionar " + tipoVeiculo);

        VBox vboxVariaveis = new VBox(10);
        vboxVariaveis.setPadding(new Insets(20));

        if (tipoVeiculo.equals("Carro")) {
            Label labelMarca = new Label("Marca:");
            TextField textFieldMarca = new TextField();

            Label labelModelo = new Label("Modelo:");
            TextField textFieldModelo = new TextField();

            Label labelAno = new Label("Ano:");
            TextField textFieldAno = new TextField();

            Label labelQuantidadePortas = new Label("Cor:");
            TextField textFieldQuantidadePortas = new TextField();

            Label labelTipoCombustivel = new Label("Preço:");
            TextField textFieldTipoCombustivel = new TextField();

            Label labelCor = new Label("Quilometragem:");
            TextField textFieldCor = new TextField();

            Label labelQuilometragem = new Label("Quantidade de Portas:");
            TextField textFieldQuilometragem = new TextField();

            Label labelPreco = new Label("Tipo de Combustível:");
            TextField textFieldPreco = new TextField();

            vboxVariaveis.getChildren().addAll(labelMarca, textFieldMarca, labelModelo, textFieldModelo,
            labelAno, textFieldAno, labelQuantidadePortas, textFieldQuantidadePortas,
            labelTipoCombustivel, textFieldTipoCombustivel, labelCor, textFieldCor, labelQuilometragem, textFieldQuilometragem,
                labelPreco, textFieldPreco);

        } else if (tipoVeiculo.equals("Moto")) {
            Label labelMarca = new Label("Marca:");
            TextField textFieldMarca = new TextField();

            Label labelModelo = new Label("Modelo:");
            TextField textFieldModelo = new TextField();

            Label labelAno = new Label("Ano:");
            TextField textFieldAno = new TextField();

            Label labelCilindrada = new Label("Cor:");
            TextField textFieldCilindrada = new TextField();

            Label labelTipoFreio = new Label("Quilometragem:");
            TextField textFieldTipoFreio = new TextField();

            Label labelCor = new Label("Preço:");
            TextField textFieldCor = new TextField();

            Label labelQuilometragem = new Label("Cilindros:");
            TextField textFieldQuilometragem = new TextField();

            Label labelPreco = new Label("Tipo de Freio:");
            TextField textFieldPreco = new TextField();

            vboxVariaveis.getChildren().addAll(labelMarca, textFieldMarca, labelModelo, textFieldModelo,
            labelAno, textFieldAno, labelCilindrada, textFieldCilindrada, labelTipoFreio, textFieldTipoFreio, labelCor, textFieldCor, labelQuilometragem, textFieldQuilometragem,
                labelPreco, textFieldPreco);
        }

        Button buttonConcluir = new Button("Concluir");
            buttonConcluir.setOnAction(event -> {
            String marca = ((TextField) vboxVariaveis.getChildren().get(1)).getText();
            String modelo = ((TextField) vboxVariaveis.getChildren().get(3)).getText();
            int ano = Integer.parseInt(((TextField) vboxVariaveis.getChildren().get(5)).getText());
            String cor = ((TextField) vboxVariaveis.getChildren().get(7)).getText();
            int quilometragem = Integer.parseInt(((TextField) vboxVariaveis.getChildren().get(9)).getText());
            double preco = Double.parseDouble(((TextField) vboxVariaveis.getChildren().get(11)).getText());

            if (tipoVeiculo.equals("Carro")) {
            int quantidadePortas = Integer.parseInt(((TextField) vboxVariaveis.getChildren().get(13)).getText());
            String tipoCombustivel = ((TextField) vboxVariaveis.getChildren().get(15)).getText();

            Carro carro = new Carro(marca, modelo, ano, quantidadePortas, tipoCombustivel, cor, quilometragem, preco);
            loja.adicionarVeiculo(carro);

        } else if (tipoVeiculo.equals("Moto")) {
            int cilindrada = Integer.parseInt(((TextField) vboxVariaveis.getChildren().get(13)).getText());
            String tipoFreio = ((TextField) vboxVariaveis.getChildren().get(15)).getText();

            Moto moto = new Moto(marca, modelo, ano, cilindrada, tipoFreio, cor, quilometragem, preco);


            loja.adicionarVeiculo(moto);
    }  


    adicionarVariaveisStage.close();

    atualizarInterfacePrincipal();
});


        VBox vbox = new VBox(10);
        vbox.setPadding(new Insets(20));
        vbox.getChildren().addAll(vboxVariaveis, buttonConcluir);

        Scene scene = new Scene(vbox, 1080, 720);
        adicionarVariaveisStage.setScene(scene);
        adicionarVariaveisStage.show();
    }

    private void removerVeiculo() {
        Stage stage = new Stage();
        stage.setTitle("Remover Veículo");
    
        VBox vbox = new VBox(10);
        vbox.setPadding(new Insets(20));
    
        Label labelTitulo = new Label("Lista de Veículos para Remoção");
        vbox.getChildren().add(labelTitulo);
    
        for (Veiculo veiculo : loja.getVeiculos()) {
            HBox hbox = new HBox(10);
            hbox.setAlignment(Pos.CENTER_LEFT);
    
            Label labelVeiculo = new Label(veiculo.getMarca() + " " + veiculo.getModelo());
    
            Button buttonRemover = new Button("Remover");
            buttonRemover.setOnAction(e -> {
                try {
                    loja.removerVeiculo(veiculo);
                    vbox.getChildren().remove(hbox);
                } catch (VeiculoNaoRemovidoException ex) {
                    ex.printStackTrace();
                    // Exiba uma mensagem de erro para o usuário
                    Alert alert = new Alert(Alert.AlertType.ERROR);
                    alert.setTitle("Erro ao remover veículo");
                    alert.setHeaderText("Não foi possível remover o veículo");
                    alert.setContentText(ex.getMotivo());
                    alert.showAndWait();
                }
            });
    
            hbox.getChildren().addAll(labelVeiculo, buttonRemover);
            vbox.getChildren().add(hbox);
        }
    
        Scene scene = new Scene(vbox, 300, 200);
        stage.setScene(scene);
        stage.show();
    }

    private void listarVeiculos() {
        Stage stage = new Stage();
        stage.setTitle("Lista de Veículos");
    
        VBox vbox = new VBox(10);
        vbox.setPadding(new Insets(20));
    
        Label labelTitulo = new Label("Lista de Veículos");
        vbox.getChildren().add(labelTitulo);
    
        ListView<String> listViewVeiculos = new ListView<>();

    
        try (BufferedReader reader = new BufferedReader(new FileReader("C:/txt/veiculos.txt"))) {
            //D:/CODIGOS/veiculos.txt
            String linha;
            while ((linha = reader.readLine()) != null) {
                if (!linha.trim().isEmpty()) {
                    listViewVeiculos.getItems().add(linha);
                }
            }
        } catch (IOException e) {
            System.out.println("Erro ao ler o arquivo de veículos: " + e.getMessage());
        }
    
        if (listViewVeiculos.getItems().isEmpty()) {
            Label labelNenhumVeiculo = new Label("Nenhum veículo encontrado.");
            vbox.getChildren().add(labelNenhumVeiculo);
        } else {
            vbox.getChildren().add(listViewVeiculos);
            
            loja.carregarVeiculosDoArquivo();

        }
    
        Scene scene = new Scene(vbox, 300, 200);
        stage.setScene(scene);
        stage.show();

    }




    
    
    

    private void atualizarInterfacePrincipal() {
        // Atualize a interface principal com os veículos da loja
        VBox vbox = new VBox(10);
        vbox.setPadding(new Insets(20));
        
        Label labelTitulo = new Label("Bem-vindo à Loja de Carros");
        Button buttonAdicionar = new Button("Adicionar Veículo");
        Button buttonRemover = new Button("Remover Veículo");
        Button buttonListar = new Button("Listar Veículos");

        // Define os eventos dos botões
        buttonAdicionar.setOnAction(event -> mostrarInterfaceAdicionar());
        buttonRemover.setOnAction(event -> removerVeiculo());
        buttonListar.setOnAction(event -> listarVeiculos());

        vbox.getChildren().addAll(labelTitulo, buttonAdicionar, buttonRemover, buttonListar);

        Scene scene = new Scene(vbox, 300, 200);
        primaryStage.setScene(scene);
        primaryStage.show();
    }
}
