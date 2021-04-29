package GRExamStyle;

import javafx.animation.KeyFrame;
import javafx.animation.KeyValue;
import javafx.animation.Timeline;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.util.Duration;
import util.NetworkUtil;
import java.lang.Integer;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.net.Socket;
import java.net.URL;
import java.util.ArrayList;
import java.util.Collections;
import java.util.ResourceBundle;

public class QuizScreenController2 implements Initializable{



    int[] ans = new int[10];
    static int count=0;
    static int[] std_ans=new int[10];



    private GRExam main;

    @FXML
    private Label q1;
    @FXML
    private Label q2;
    @FXML
    private Label q3;
    @FXML
    private Label q4;
    @FXML
    private Label q5;
    @FXML
    private Label q6;
    @FXML
    private Label q7;
    @FXML
    private Label q8;
    @FXML
    private Label q9;
    @FXML
    private Label q10;

    @FXML
    private ToggleGroup option1;
    @FXML
    private ToggleGroup option2;
    @FXML
    private ToggleGroup option3;
    @FXML
    private ToggleGroup option4;
    @FXML
    private ToggleGroup option5;
    @FXML
    private ToggleGroup option6;
    @FXML
    private ToggleGroup option7;
    @FXML
    private ToggleGroup option8;
    @FXML
    private ToggleGroup option9;
    @FXML
    private ToggleGroup option10;

    @FXML
    private RadioButton b1op1;
    @FXML
    private RadioButton b1op2;
    @FXML
    private RadioButton b1op3;
    @FXML
    private RadioButton b1op4;


    @FXML
    private RadioButton b2op1;
    @FXML
    private RadioButton b2op2;
    @FXML
    private RadioButton b2op3;
    @FXML
    private RadioButton b2op4;

    @FXML
    private RadioButton b3op1;
    @FXML
    private RadioButton b3op2;
    @FXML
    private RadioButton b3op3;
    @FXML
    private RadioButton b3op4;

    @FXML
    private RadioButton b4op1;
    @FXML
    private RadioButton b4op2;
    @FXML
    private RadioButton b4op3;
    @FXML
    private RadioButton b4op4;


    @FXML
    private RadioButton b5op1;
    @FXML
    private RadioButton b5op2;
    @FXML
    private RadioButton b5op3;
    @FXML
    private RadioButton b5op4;

    @FXML
    private RadioButton b6op1;
    @FXML
    private RadioButton b6op2;
    @FXML
    private RadioButton b6op3;
    @FXML
    private RadioButton b6op4;

    @FXML
    private RadioButton b7op1;
    @FXML
    private RadioButton b7op2;
    @FXML
    private RadioButton b7op3;
    @FXML
    private RadioButton b7op4;


    @FXML
    private RadioButton b8op1;
    @FXML
    private RadioButton b8op2;
    @FXML
    private RadioButton b8op3;
    @FXML
    private RadioButton b8op4;

    @FXML
    private RadioButton b9op1;
    @FXML
    private RadioButton b9op2;
    @FXML
    private RadioButton b9op3;
    @FXML
    private RadioButton b9op4;

    @FXML
    private RadioButton b10op1;
    @FXML
    private RadioButton b10op2;
    @FXML
    private RadioButton b10op3;
    @FXML
    private RadioButton b10op4;

    @FXML
    private Label score;

    @FXML
    private Button submit;
    @FXML
    private Timeline timeline;
    @FXML
    private Label timerLabel ;


    NetworkUtil nc_student1 = HomeScreenController.nc_student;



    @FXML
    void submit_clicked(ActionEvent event) throws Exception {
        for (int i=0,j=0;i<10;i++) {
            if(j==i) submit.setDisable(false);

            if (std_ans[i] == ans[i]) {

                System.out.println(std_ans[i] + "& " + ans[i]);
                count++;
            }
            submit.setDisable(true);
            j++;
        }
        score.setText("your score is" + count);

        main.ScorePage();
    }



    @FXML
    void radio_bottun_clicked1(ActionEvent event) {
        if (b1op1.isSelected()) {
            ans[0] = 1;
            System.out.println(ans[0]);
        }
        if (b1op2.isSelected()) {
            ans[0] = 2;
            System.out.println(ans[0]);
        }
        if (b1op3.isSelected()) {
            ans[0] = 3;
            System.out.println(ans[0]);
        }

        if (b1op4.isSelected()) {
            ans[0] = 4;
            System.out.println(ans[0]);
        }

    }



    @FXML
    void radio_bottun_clicked2(ActionEvent event) {


        if (b2op1.isSelected()) {
            ans[1] = 1;
            System.out.println(ans[1]);
        }
        if (b2op2.isSelected()) {
            ans[1] = 2;
            System.out.println(ans[1]);
        }
        if (b2op3.isSelected()) {
            ans[1] = 3;
            System.out.println(ans[1]);
        }
        if (b2op4.isSelected()) {
            ans[1] = 4;
            System.out.println(ans[1]);
        }


    }

    @FXML
    void radio_bottun_clicked3(ActionEvent event) {

        if (b3op1.isSelected()) {
            ans[2] = 1;
            System.out.println(ans[2]);
        }
        if (b3op2.isSelected()) {
            ans[2] = 2;
            System.out.println(ans[2]);
        }
        if (b3op3.isSelected()) {
            ans[2] = 3;
            System.out.println(ans[2]);
        }
        if (b3op4.isSelected()) {
            ans[2] = 4;
            System.out.println(ans[2]);
        }
    }

    @FXML
    void radio_bottun_clicked4(ActionEvent event) {
        if (b4op1.isSelected()) {
            ans[3] = 1;
            System.out.println(ans[0]);
        }
        if (b4op2.isSelected()) {
            ans[3] = 2;
            System.out.println(ans[0]);
        }
        if (b4op3.isSelected()) {
            ans[3] = 3;
            System.out.println(ans[0]);
        }

        if (b4op4.isSelected()) {
            ans[3] = 4;
            System.out.println(ans[0]);
        }

    }

    @FXML
    void radio_bottun_clicked5(ActionEvent event) {
        if (b5op1.isSelected()) {
            ans[4] = 1;
            System.out.println(ans[0]);
        }
        if (b5op2.isSelected()) {
            ans[4] = 2;
            System.out.println(ans[0]);
        }
        if (b5op3.isSelected()) {
            ans[4] = 3;
            System.out.println(ans[0]);
        }

        if (b5op4.isSelected()) {
            ans[4] = 4;
            System.out.println(ans[0]);
        }

    }

    @FXML
    void radio_bottun_clicked6(ActionEvent event) {
        if (b6op1.isSelected()) {
            ans[5] = 1;
            System.out.println(ans[0]);
        }
        if (b6op2.isSelected()) {
            ans[5] = 2;
            System.out.println(ans[0]);
        }
        if (b6op3.isSelected()) {
            ans[5] = 3;
            System.out.println(ans[0]);
        }

        if (b6op4.isSelected()) {
            ans[5] = 4;
            System.out.println(ans[0]);
        }

    }

    @FXML
    void radio_bottun_clicked7(ActionEvent event) {
        if (b7op1.isSelected()) {
            ans[6] = 1;
            System.out.println(ans[0]);
        }
        if (b7op2.isSelected()) {
            ans[6] = 2;
            System.out.println(ans[0]);
        }
        if (b7op3.isSelected()) {
            ans[6] = 3;
            System.out.println(ans[0]);
        }

        if (b7op4.isSelected()) {
            ans[6] = 4;
            System.out.println(ans[0]);
        }

    }

    @FXML
    void radio_bottun_clicked8(ActionEvent event) {
        if (b8op1.isSelected()) {
            ans[7] = 1;
            System.out.println(ans[0]);
        }
        if (b8op2.isSelected()) {
            ans[7] = 2;
            System.out.println(ans[0]);
        }
        if (b8op3.isSelected()) {
            ans[7] = 3;
            System.out.println(ans[0]);
        }

        if (b8op4.isSelected()) {
            ans[7] = 4;
            System.out.println(ans[0]);
        }

    }

    @FXML
    void radio_bottun_clicked9(ActionEvent event) {
        if (b9op1.isSelected()) {
            ans[8]= 1;
            System.out.println(ans[0]);
        }
        if (b9op2.isSelected()) {
            ans[8] = 2;
            System.out.println(ans[0]);
        }
        if (b9op3.isSelected()) {
            ans[8] = 3;
            System.out.println(ans[0]);
        }

        if (b9op4.isSelected()) {
            ans[8] = 4;
            System.out.println(ans[0]);
        }

    }

    @FXML
    void radio_bottun_clicked10(ActionEvent event) {
        if (b10op1.isSelected()) {
            ans[9] = 1;
            System.out.println(ans[0]);
        }
        if (b10op2.isSelected()) {
            ans[9] = 2;
            System.out.println(ans[0]);
        }
        if (b10op3.isSelected()) {
            ans[9] = 3;
            System.out.println(ans[0]);
        }

        if (b10op4.isSelected()) {
            ans[9] = 4;
            System.out.println(ans[0]);
        }

    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {

        nc_student1 = LoginScreenController.nc_socket;

        System.out.println(nc_student1);

    }





    void setGRExam( GRExam main) {


        try {
            dataflow[] ob = new dataflow[40];
            int ans[] = new int[40];

            for (int i = 0; i < 30; i++) {
                ob[i] = new dataflow();
                ob[i].answer = 0;

            }
            BufferedReader br = null;


            try

            {
                int totalLines = 0;
                br = new BufferedReader(new FileReader(Server.OTHER_INPUT_FILE_NAME));
                while ((br.readLine()) != null) {
                    totalLines++;
                }
                br.close();
                br = new BufferedReader(new FileReader(Server.OTHER_INPUT_FILE_NAME));
                int i = 0;
                String line;
                String line2=null;
                ArrayList<Integer> randomint = new ArrayList<Integer>();
                for (int k =0;k<totalLines;k++)
                {
                    randomint.add(new Integer(k));
                }
                Collections.shuffle(randomint);

                while ((line = br.readLine())!=null) {

                    for(int k=0;k<30;k++)
                    {
                        if (i == randomint.get(k)) {
                            line2 = line;
                        }
                    }
                    String[] t = line2.split("@");
                    ob[randomint.get(i)].answer= Integer.parseInt(t[1]);

                    ob[randomint.get(i)].q = t[0].split("&")[0];

                    ob[randomint.get(i)].op1 = t[0].split("&")[1];
                    ob[randomint.get(i)].op2 = t[0].split("&")[2];
                    ob[randomint.get(i)].op3 = t[0].split("&")[3];
                    ob[randomint.get(i)].op4 =t[0].split("&")[4];
                    i++;

                }


                br.close();


            }catch (IOException e)
            {
                e.printStackTrace();
            }

            for(int l=0;l<10;l++)
            {
                std_ans[l] = ob[l].answer;

                System.out.println("thikase naki :" +std_ans[l]);
            }
            q1.setText(ob[0].q);
            b1op1.setText(ob[0].op1);
            b1op2.setText(ob[0].op2);
            b1op3.setText(ob[0].op3);
            b1op4.setText(ob[0].op4);

            q2.setText(ob[1].q);
            b2op1.setText(ob[1].op1);
            b2op2.setText(ob[1].op2);
            b2op3.setText(ob[1].op3);
            b2op4.setText(ob[1].op4);

            q3.setText(ob[2].q);
            b3op1.setText(ob[2].op1);
            b3op2.setText(ob[2].op2);
            b3op3.setText(ob[2].op3);
            b3op4.setText(ob[2].op4);

            q4.setText(ob[3].q);
            b4op1.setText(ob[3].op1);
            b4op2.setText(ob[3].op2);
            b4op3.setText(ob[3].op3);
            b4op4.setText(ob[3].op4);

            q5.setText(ob[4].q);
            b5op1.setText(ob[4].op1);
            b5op2.setText(ob[4].op2);
            b5op3.setText(ob[4].op3);
            b5op4.setText(ob[4].op4);

            q6.setText(ob[5].q);
            b6op1.setText(ob[5].op1);
            b6op2.setText(ob[5].op2);
            b6op3.setText(ob[5].op3);
            b6op4.setText(ob[5].op4);

            q7.setText(ob[6].q);
            b7op1.setText(ob[6].op1);
            b7op2.setText(ob[6].op2);
            b7op3.setText(ob[6].op3);
            b7op4.setText(ob[6].op4);

            q8.setText(ob[7].q);
            b8op1.setText(ob[7].op1);
            b8op2.setText(ob[7].op2);
            b8op3.setText(ob[7].op3);
            b8op4.setText(ob[7].op4);

            q9.setText(ob[8].q);
            b9op1.setText(ob[8].op1);
            b9op2.setText(ob[8].op2);
            b9op3.setText(ob[8].op3);
            b9op4.setText(ob[8].op4);

            q10.setText(ob[9].q);
            b10op1.setText(ob[9].op1);
            b10op2.setText(ob[9].op2);
            b10op3.setText(ob[9].op3);
            b10op4.setText(ob[9].op4);


        } catch (Exception e) {
            e.printStackTrace();
        }


        this.main = main;
    }
}

