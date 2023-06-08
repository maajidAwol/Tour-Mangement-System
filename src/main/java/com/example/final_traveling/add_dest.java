package com.example.final_traveling;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class add_dest {
    @FXML
    public TextField name;
    @FXML
    public TextField distance;
    @FXML
    public TextField air;
    @FXML
    public TextField car;
    @FXML
    public TextField costday;
    @FXML
    public TextField hotel;
    @FXML
    public TextField costhotel;
    @FXML
    public Button register;
    @FXML
  public   Button backhome;
    @FXML
    public Label message;
    @FXML
    public Label errormessage;
    private    Stage stage;
    private Scene scene;
    private Parent root;

    public void add_dest()  {
        if(name.getText()=="" || distance.getText()=="" || air.getText()=="" || car.getText()==""
                || costday.getText()=="" || hotel.getText()=="" || costhotel.getText()==""){
            errormessage.setText("All Field are Required !");
        }
        else{
        try {
            BufferedWriter writer=new BufferedWriter(new FileWriter("Destination.txt",true));
            writer.write(name.getText()+"~"+distance.getText()+"~"+air.getText()+"~"+car.getText()+"~"
                    +costday.getText()+"~"+hotel.getText()+"~"+costhotel.getText()+"\n");
            writer.close();
            message.setText("Registration succesfull");
            add_dest a=new add_dest();



        }catch (Exception e){}}

    }

    public void backhome(ActionEvent event) {
        try{
            Parent root= FXMLLoader.load(getClass().getResource("home.fxml"));
            stage =(Stage)((Node)event.getSource()).getScene().getWindow();
            scene=new Scene(root,700,500);
            stage.setTitle("HOME PAGE");
            stage.setResizable(false);
            stage.setScene(scene);
            stage.show();}catch (Exception e){}
    }

    public void displaydest(ActionEvent event) {
        try{
            Parent root= FXMLLoader.load(getClass().getResource("disp_dest.fxml"));
            stage =(Stage)((Node)event.getSource()).getScene().getWindow();
            scene=new Scene(root,850,500);
            stage.setTitle("DISPLAY DESTINATION");
            stage.setResizable(false);
            stage.setScene(scene);
            stage.show();}catch (Exception e){}
    }
    public void allorder(ActionEvent event) {
        try {
            Parent root= FXMLLoader.load(getClass().getResource("all_order.fxml"));
            stage =(Stage)((Node)event.getSource()).getScene().getWindow();
            scene=new Scene(root,750,500);
            stage.setTitle("ORDER AVAILABLE");
            stage.setResizable(false);
            stage.setScene(scene);
            stage.show();
        }catch (Exception e){};
    }
}
