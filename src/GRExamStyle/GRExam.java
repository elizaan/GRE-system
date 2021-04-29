package GRExamStyle;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;


public class GRExam extends Application{


    Stage stage;

    @Override
    public void start(Stage primaryStage) throws Exception{
        stage = primaryStage;
        showLoginPage();
    }

    public void showLoginPage() throws Exception {
        // XML Loading using FXMLLoader
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("login.fxml"));
        Parent root = loader.load();

        // Loading the controller44444444444444444444
        LoginScreenController controller = loader.getController();
        controller.setGRExam(this);

        // Set the primary stage
        stage.setTitle("Login");
        stage.setScene(new Scene(root, 800, 800));
        stage.show();
    }

    public void showHomePage(String userName) throws Exception {

        //Stage stage = (Stage) LoginScreenController.loginButton.getScene().getWindow();
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("home.fxml"));
        Parent root = loader.load();

        // Loading the controller
        HomeScreenController controller = loader.getController();

        try{
            controller.init(userName);
        }

        catch (Exception e)
        {
            e.printStackTrace();
        }
        controller.setGRExam(this);

        // Set the primary stage
        stage.setTitle("Home");
        stage.setScene(new Scene(root, 800, 800));
        stage.show();
    }


    public void ScorePage() throws Exception {
        // XML Loading using FXMLLoader
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("score.fxml"));
        Parent root = loader.load();

        // Loading the controller44444444444444444444
        ScoreScreenController controller = loader.getController();
        controller.setGRExam(this);

        // Set the primary stage
        stage.setTitle("score");
        stage.setScene(new Scene(root, 800, 800));
        stage.show();
    }


    public static void main(String[] args) {
        // This will launch the JavaFX application
        launch(args);
    }

}
