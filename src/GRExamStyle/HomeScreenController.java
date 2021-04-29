package GRExamStyle;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;
import sample.Main;
import util.NetworkUtil;

import java.io.*;
import java.net.Socket;
import java.net.URL;
import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;



public class HomeScreenController implements Initializable{


   static NetworkUtil nc_student = LoginScreenController.nc_socket;


    private GRExam main;

    @FXML
    private Label usertext;

    @FXML
    private Button getexambutton;

    @FXML
    private ChoiceBox choiceBox;



    @Override
    public void initialize(URL url, ResourceBundle rb) {

        nc_student = LoginScreenController.nc_socket;


    }

    void init(String msg)
    {
        usertext.setText("WELCOME " + msg + "!!!");
    }

    @FXML
    void GetxmAction(ActionEvent event) {

        if (choiceBox.getValue().equals("MATH")) {
            // successful login
            try {
                 showQuizPage();

                //System.out.println("run korse to");

            } catch (Exception e) {
                e.printStackTrace();
            }

        }else if (choiceBox.getValue().equals("ENGLISH")) {
            // successful login
            try {
                showQuizPage2();

                //System.out.println("run korse to");

            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        else {
            // failed login
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Incorrect Credentials");
            alert.setHeaderText("Incorrect Credentials");
            alert.setContentText("The Exam Name you have provided  is not available.");
            alert.showAndWait();
        }

    }


    public void showQuizPage() throws Exception {

        Stage stage = (Stage) getexambutton.getScene().getWindow();
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("newquiz.fxml"));
        Parent root = loader.load();

        // Loading the controller
        QuizScreenController controller = loader.getController();

        controller.setGRExam(main);

        // Set the primary stage
        stage.setTitle("Quiz");
        stage.setScene(new Scene(root));
        stage.show();
    }

    public void showQuizPage2() throws Exception {

        Stage stage2 = (Stage) getexambutton.getScene().getWindow();
        FXMLLoader loader2 = new FXMLLoader();
        loader2.setLocation(getClass().getResource("newquiz2.fxml"));
        Parent root = loader2.load();

        // Loading the controller
        QuizScreenController2 controller2 = loader2.getController();

        controller2.setGRExam(main);

        // Set the primary stage
        stage2.setTitle("Quiz");
        stage2.setScene(new Scene(root));
        stage2.show();
    }

    void setGRExam( GRExam main) {

        ObservableList<String> choicelist = FXCollections.observableArrayList("MATH","ENGLISH");

        choiceBox.setValue("MATH");
        choiceBox.setItems(choicelist);


        this.main = main;
    }

}
