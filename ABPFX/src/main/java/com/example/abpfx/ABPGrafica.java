package com.example.abpfx;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextInputDialog;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.Optional;

public class ABPGrafica extends Application {
    private ABP abpArvore; //Declaração da árvore binária de pesquisa

    public static void main(String[] args) {
        launch(args);
    }
    @Override
    public void start(Stage primaryStage){
        //Inicialização da árvore --- raiz
        abpArvore = new ABP(3);
        //Configuração da interface gráfica
        Button botaoAdicionar = new Button("Adicionar elemento");
        Button botaoRemover = new Button("Remover elemento");
        Button botaoMostrar = new Button("Mostrar árvore");
        TextArea textArea = new TextArea();

        botaoAdicionar.setOnAction(e -> {
            TextInputDialog dialogo = new TextInputDialog();
            dialogo.setTitle("Adicionar elemento");
            dialogo.setHeaderText("Adicionar elemento");
            Optional<String> resultado = dialogo.showAndWait();
            resultado.ifPresent(valor -> abpArvore.inserir(Integer.parseInt(valor)));
        });
        botaoRemover.setOnAction(e -> {
            TextInputDialog dialogo = new TextInputDialog();
            dialogo.setTitle("Remover elemento");
            dialogo.setHeaderText("Remover elemento");
            Optional<String> resultado = dialogo.showAndWait();
            resultado.ifPresent(valor -> {
                //Remove o elemento da árvore
                abpArvore.remover(Integer.parseInt(valor));
            });
        });

        botaoMostrar.setOnAction(e -> {
            //Mostra a árvore
            abpArvore.imprimirArvore();
        });

        VBox layout = new VBox(10);
        layout.getChildren().addAll(botaoAdicionar, botaoRemover, botaoMostrar, textArea);

        Scene scene = new Scene(layout, 300, 250);
        primaryStage.setScene(scene);
        primaryStage.show();
    }
}