package GRExamStyle;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import util.NetworkUtil;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class ScoreScreenController implements Initializable{

    static NetworkUtil nc_student = QuizScreenController.nc_student1;



    private GRExam main;
    @FXML
    private Label History;
    @FXML
    private Label name;
    @FXML
    private Label score;

    public void setName(String name) {
        this.name.setText(name);
    }

    public void setScore(String score) {
        try {
            this.score.setText(score);
            //System.out.println("MyScore: " + this.score.getText());
        } catch (Exception e) {
            /*if(score == null) System.out.println("NULLLIASKHA");
            else System.out.println(score);
            System.out.println("I FOUND THE BUG");*/
            System.out.println(e);
        }
        System.out.println(score + " " + 12);
    }


    @FXML
    private Button logout;
    @FXML
    private Button progress;
    @FXML
    private Button finish;


    @FXML

    public void LogOutAction() throws Exception {
       main.showLoginPage();
    }




    @FXML

    public void FinishAction() throws Exception {

       main.showHomePage(LoginScreenController.getName());
    }



    @Override
    public void initialize(URL url, ResourceBundle rb) {

       // nc_student1 = LoginScreenController.nc_socket


        try (BufferedReader reader = new BufferedReader(new FileReader("regsave.txt"))) {

            while (true) {
                String line = reader.readLine();
                if (line == null) break;
                if (line.equals(LoginScreenController.getName())) {

                     reader.readLine();
                     line = reader.readLine();
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }


        System.out.println(nc_student);

    }
    void setGRExam(GRExam main)
    {


        setName(LoginScreenController.getName());
        setScore(QuizScreenController.getc());
       // setScore("45678");
        this.main = main;
    }





}
