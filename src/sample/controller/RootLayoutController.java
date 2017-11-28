package sample.controller;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import sample.Main;
import sample.Utility.Utility;

import java.sql.ResultSet;

/**
 * Created by anu on 11/27/2017.
 */
public class RootLayoutController {

    @FXML
    private TextField username;
    @FXML
    private TextField password;

    private Stage primaryStage = new Stage();
    @FXML
    private void initialize()
    {


    }

    @FXML
    private void checkLogin()
    {
        try {
            String name = username.getText();
            String pswd = password.getText();
            if(!name.isEmpty() && !pswd.isEmpty()) {
                String stmt = "Select * from Employee where EmployeeId = " + name + " and Password = '" + pswd + "'";
                ResultSet rs = Utility.execute(stmt);
                if (rs.isBeforeFirst()) {
                    FXMLLoader loader = new FXMLLoader();
                    loader.setLocation(Main.class.getResource("view/AdministratorView.fxml"));
                    primaryStage.setTitle("Employee Details");
                    AnchorPane employeeView = (AnchorPane) loader.load();

                    Scene scene = new Scene(employeeView); //We are sending rootLayout to the Scene.
                    primaryStage.setScene(scene);
                    primaryStage.show();
                }
            }
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
    }
}
