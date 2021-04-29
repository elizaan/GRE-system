package GRExamStyle;


import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import util.NetworkUtil;

import javafx.event.ActionEvent;
import java.io.*;
import java.net.URL;

import java.util.*;


public class RegScreenController implements Initializable{

    // private static ArrayList<regist>registList = new ArrayList<regist>();

    static NetworkUtil nc_student = LoginScreenController.nc_socket;

    private GRExam main;

    @FXML
    private TextField username;

    @FXML
    private PasswordField password;

    @FXML
    private PasswordField confirmPassword;

    @FXML
    private TextField email;

    @FXML
    private Button submit;
    @FXML
    private Button back;

    @Override
    public void initialize(URL url, ResourceBundle rb) {

        nc_student = LoginScreenController.nc_socket;

    }

    @FXML
    void submitAction(ActionEvent event) throws Exception{

        String userName = username.getText();
        String Password = password.getText();
        String Email = email.getText();
        String confirmPass = confirmPassword.getText();


       try {
           if (Password.equals(confirmPass)){
               BufferedWriter bw = new BufferedWriter(new FileWriter(Server.INFO_FILE, true));
               try{
                   bw.append(userName).append("\n").append(Password).append("\n").append("Score");
               } catch (IOException e){
                   e.printStackTrace();
               }
               bw.close();
               main.showLoginPage();
           }
           else {
               Alert alert = new Alert(Alert.AlertType.ERROR);
               alert.setTitle("Incorrect Credentials");
               alert.setHeaderText("Incorrect Credentials");
               alert.setContentText("Passwords must be identical.");
               alert.showAndWait();
           }
       }catch (IOException E)
       {
           E.printStackTrace();
       }

    }

    @FXML
    void backAction(ActionEvent event) {
        try {
            main.showLoginPage();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }



    void setGRExam( GRExam main) {
        this.main = main;
    }


}
