package com.example.final_traveling;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.stage.Stage;
import javafx.stage.*;

public class home {
    @FXML
    private Label welcomeText;
    private    Stage stage;
    private Scene scene;
    private Parent root;
    @FXML
    public Button userlogin;
    @FXML
    public Button adminlogin;

    @FXML
    protected void tologin(ActionEvent event) {
        try{
        Parent root= FXMLLoader.load(getClass().getResource("admin_login.fxml"));
        stage =(Stage)((Node)event.getSource()).getScene().getWindow();
        scene=new Scene(root,600,450);
        stage.setTitle("Login Page");
        stage.setScene(scene);
        stage.show();}catch (Exception e){}
    }

    public void touser(ActionEvent event) {
        try{
            Parent root= FXMLLoader.load(getClass().getResource("disp_dest_user.fxml"));
            stage =(Stage)((Node)event.getSource()).getScene().getWindow();
            scene=new Scene(root,850,500);
            stage.setTitle("BOOK TOUR");
            stage.setResizable(false);
            stage.setScene(scene);
            stage.show();}catch (Exception e){}

    }
}