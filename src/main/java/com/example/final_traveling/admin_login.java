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

import java.awt.*;

public class admin_login  {
    @FXML
    public Button backhome;
    @FXML
    public javafx.scene.control.TextField username;
    @FXML
    public javafx.scene.control.TextField adminpassword;
    @FXML
    public javafx.scene.control.Label message;



    private    Stage stage;
    private Scene scene;
    private Parent root;


    public void backhome(javafx.event.ActionEvent event) {
        try{
            Parent root= FXMLLoader.load(getClass().getResource("home.fxml"));
            stage =(Stage)((Node)event.getSource()).getScene().getWindow();
            scene=new Scene(root,700,500);
            stage.setTitle("HOME PAGE");
            stage.setResizable(false);
            stage.setScene(scene);
            stage.show();}catch (Exception e){}
    }

    public void login(ActionEvent event) {
        try{
        if(username.getText().equals("admin") && adminpassword.getText().equals("0000"))
        {
            Parent root= FXMLLoader.load(getClass().getResource("add_dest.fxml"));
            stage =(Stage)((Node)event.getSource()).getScene().getWindow();
            scene=new Scene(root,700,500);
            stage.setTitle("REGISTER NEW DESTINATION");
            stage.setResizable(false);
            stage.setScene(scene);
            stage.show();
        }
        else{
            message.setText("incorrect password!");
        }

        }catch (Exception e){}


    }
}

