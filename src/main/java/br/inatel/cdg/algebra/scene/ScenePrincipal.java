package br.inatel.cdg.algebra.scene;

import javafx.scene.Scene;
import br.inatel.cdg.algebra.reta.Ponto;
import br.inatel.cdg.algebra.reta.Reta;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class ScenePrincipal {

    private Button btnCalcCoefLinear, btnCalcCoefAngular; //Button representa botoes
    private Label lblP1X, lblP2X, lblP1Y, lblP2Y;//Label representam rótulos
    private TextField txtP1X, txtP2X, txtP1Y, txtP2Y; //TextField Representam áreas de texto

    public void criaScenePrincipal(Stage stage){

        //Criando os labels para os pontos e os campos de texto para os dados
        lblP1X= new Label("Ponto P1.X"); //rótulos
        txtP1X = new TextField(); //área de texto onde vc digitara alguma coisa

        lblP1Y= new Label("Ponto P1.Y");
        txtP1Y = new TextField();

        lblP2X= new Label("Ponto P2.X");
        txtP2X = new TextField();

        lblP2Y= new Label("Ponto P2.Y");
        txtP2Y = new TextField();


        //HBox é usado para agrupar elementos horizontalmente
        HBox hboxP1X = new HBox(lblP1X, txtP1X); //Passamos no construtor todos os elementos. Você poderá criar vários grupos horizontais
        HBox hboxP1Y = new HBox(lblP1Y, txtP1Y);
        HBox hboxP2X = new HBox(lblP2X, txtP2X);
        HBox hboxP2Y = new HBox(lblP2Y, txtP2Y);

        VBox vboxEntradaCoord = new VBox(hboxP1X,hboxP1Y,hboxP2X,hboxP2Y);


        //Caixas de texto para os resultador
        TextField txtCoefAngular = new TextField();
        txtCoefAngular.setEditable(false);
        txtCoefAngular.setText( "Coef Angular: ");

        TextField txtCoefLinear = new TextField();
        txtCoefLinear.setEditable(false);
        txtCoefLinear.setText( "Coef Linear: ");

        HBox hboxRespostas = new HBox(txtCoefAngular, txtCoefLinear);



        //Criamos o botão
        btnCalcCoefAngular = new Button("Calcula Coeficiente Angular");
        //Criamos a ação que o botão responderá as ser pressionado
        btnCalcCoefAngular.setOnAction(evento -> {
            //Aqui dentro é a ação que será executado ao pressionar o botão
            Reta reta = construirReta();

           txtCoefAngular.setText("Coef Angular: "+ reta.calcCoeficienteAngular());//Acessamos o componente textField1, pegamos o texto e colocaos em textField2
        });

        btnCalcCoefLinear = new Button("Calcula Coeficiente Linear");

        btnCalcCoefLinear.setOnAction(evento -> {

            Reta reta = construirReta();

            txtCoefLinear.setText("Coef Linear: "+ reta.calcCoeficienteAngular());
        });
        HBox hBoxBotoes = new HBox(btnCalcCoefAngular , btnCalcCoefLinear);

        //VBox é usada para agrupar elementos verticalmente
        //No construtor passamos todos os elementos que serão agrupados, que podem ser outros grupos
        VBox layoutFinal = new VBox(vboxEntradaCoord, hboxRespostas,hBoxBotoes);//Aqui vamos agrupar verticalmente o grupo (Label + Texto) o Botao e A area que aparecer o texto digitado

        //Criamos a Scene
        Scene scene = new Scene(layoutFinal, 300 , 200);

        stage.setTitle("Software Para Calculos de Álgebra Linear");
        stage.setScene(scene);
        stage.show();
    }

    private Reta construirReta() {
        Ponto p1 = new Ponto(Double.parseDouble(txtP1X.getText()),
                Double.parseDouble(txtP1Y.getText()));

        Ponto p2 = new Ponto(Double.parseDouble(txtP2X.getText()),
        Double.parseDouble(txtP2Y.getText()));

       Reta reta = new Reta(p1,p2);
       return reta;


    }

}
