package sample.controller;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Label;
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
                FXMLLoader loader = new FXMLLoader();

                if (rs.next()) {
                    String role = rs.getString("role");
                    if(role.equals("D")){
                        loader.setLocation(Main.class.getResource("Doctor_view/DoctorView.fxml"));
                        AnchorPane employeeView = (AnchorPane) loader.load();
                        primaryStage.setTitle("Patient Diagnosis");
                        Node label = employeeView.getChildren().get(6);
                        ((Label)label).setText(name);

                        Scene scene = new Scene(employeeView);
                        primaryStage.setScene(scene);
                    }
                    else if(role.equals("R")){
                        loader.setLocation(Main.class.getResource("Receptionist_view/Receptionist_view.fxml"));
                        AnchorPane employeeView = (AnchorPane) loader.load();
                        primaryStage.setTitle("Patient Details");

                        Scene scene = new Scene(employeeView);
                        primaryStage.setScene(scene);
                    }
                    else if(role.equals("A")){
                        loader.setLocation(Main.class.getResource("view/AdministratorView.fxml"));
                        AnchorPane employeeView = (AnchorPane) loader.load();
                        primaryStage.setTitle("Patient Details");

                        Scene scene = new Scene(employeeView);
                        primaryStage.setScene(scene);
                    }


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
