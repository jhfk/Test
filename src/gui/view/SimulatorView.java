package gui.view;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;


public class SimulatorView extends Application {

    Stage window;

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        window = primaryStage;
        window.setTitle("FootballSimulator");

        //GridPane with 10px padding around edge
        GridPane grid = new GridPane();
        grid.setPadding(new Insets(10, 10, 10, 10));
        grid.setVgap(8);
        grid.setHgap(10);

        //Name Label - constrains use (child, column, row)
        Label nameFirstTeam = new Label("Team 1");
        GridPane.setConstraints(nameFirstTeam, 0, 0);

        //Name Input
        TextField score = new TextField();
        score.setText("0 : 0");
        score.setMaxWidth(100);
        score.setDisable(true);
        GridPane.setConstraints(score, 1, 0);

        //Password Label
        Label nameSecondTeam = new Label("Team 2");
        GridPane.setConstraints(nameSecondTeam, 2, 0);



        //Login
        Button startButton = new Button("Start the Game");
        GridPane.setConstraints(startButton, 1, 2);

        //Add everything to grid
        grid.getChildren().addAll(nameFirstTeam, score, nameSecondTeam, startButton);

        Scene scene = new Scene(grid, 300, 200);
        scene.getStylesheets().add("Viper.css");
        window.setScene(scene);
        window.show();
    }


}

