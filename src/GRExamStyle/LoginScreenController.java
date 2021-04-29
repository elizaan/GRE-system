package GRExamStyle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import util.NetworkUtil;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;

public class LoginScreenController {


    private static String name;

    public static String getName() {
        return name;
    }

    private GRExam main;
    @FXML
    private TextField userText;

    @FXML
    private PasswordField passwordText;

    @FXML
    private Button resetButton;

    @FXML
    private Button loginButton;

    @FXML
    private Button regButton;


    static NetworkUtil nc_socket = new NetworkUtil("localhost", 3333);

    @FXML
    void loginAction() throws Exception{
        HashMap<String, String> acc = new HashMap<>();

        try{
            BufferedReader br = new BufferedReader(new FileReader(Server.INFO_FILE));
            String line;
            while(true){
                String name = br.readLine();
                if (name  == null) break;
                String password = br.readLine();
                if (name  == null) break;
                String scores[] = br.readLine().split(":");
                if (name  == null) break;

                acc.put(name, password);
            }
        }catch (Exception e){
            e.printStackTrace();
        }

        String userName = userText.getText();
        name = userName;
        String password = passwordText.getText();

        boolean flag = false;
        if(acc.containsKey(userName)){
            flag = acc.get(userName).equals(password);
        }

        if(flag){
            main.showHomePage(userName);
        }
        else {
            // failed login
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Incorrect Credentials");
            alert.setHeaderText("Incorrect Credentials");
            alert.setContentText("The username and password you provided is not correct.");
            alert.showAndWait();
        }
    }


    @FXML
    void resetAction(ActionEvent event)
    {
        userText.setText(null);
        passwordText.setText(null);
    }

    @FXML
    void regAction(ActionEvent event)
    {
        try
        {
            Stage stage = (Stage) regButton.getScene().getWindow();
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(getClass().getResource("reg.fxml"));
            Parent root = loader.load();

            // Loading the controller
            RegScreenController controller = loader.getController();

            controller.setGRExam(main);

            // Set the primary stage
            stage.setTitle("Registration");
            stage.setScene(new Scene(root, 800, 800));
            stage.show();
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }

    }

    void setGRExam(GRExam main) {
        this.main = main;
    }
}
