package com.example.final_traveling;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ToggleGroup;
import javafx.stage.Stage;

import java.awt.*;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;

public class book_ticket {
    private    Stage stage;
    private Scene scene;
    private Parent root;
    @FXML
    public Button book;
    @FXML
    public javafx.scene.control.TextField name;
    @FXML
    public javafx.scene.control.TextField number;
    @FXML
    public javafx.scene.control.TextField phone;
    @FXML
    public javafx.scene.control.TextField email;
    @FXML
    public javafx.scene.control.TextField destination;
    @FXML
    public javafx.scene.control.TextField stayday;
    @FXML
    public javafx.scene.control.Label message;
    @FXML
    public RadioButton aircar1;
    @FXML
    public RadioButton aircar2;

    String transport;
    String costperday;
    String destcheck;
    String hotelcost;
    Float totalcost;
    String tc;
    String staynumber;
    String peoplenumber;

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
    public void book()  {
        try {
            String aircar;
            message.setText("registration successful");
            ToggleGroup chs=new ToggleGroup();
            aircar1.setToggleGroup(chs);
            aircar2.setToggleGroup(chs);
            if (aircar1.isSelected()) {
                aircar=aircar1.getText();
            }
            else{
                aircar=aircar2.getText();
            }
            destcheck=destination.getText();
            staynumber=stayday.getText();
            peoplenumber=number.getText();
            //please
            String[] temp=new String[7];
            BufferedReader reader=new BufferedReader(new FileReader("Destination.txt"));
            String line,c,b,d,e,f,g,h;
            int flag=0;
            while ((line=reader.readLine())!=null && flag==0){
                temp=line.split("~");
                b=temp[0];
                c=temp[1];
                d=temp[2];
                e=temp[3];
                f=temp[4];
                g=temp[5];
                h=temp[6];
            if (destcheck.equals(b)){
                if(aircar.equals("car")){
                    transport=e;
                }
                else{
                    transport=d;
                }
                hotelcost=h;
                costperday=f;
                flag=1;
            }
            }
            totalcost=(Float.parseFloat(transport)*Float.parseFloat(peoplenumber))+(Float.parseFloat(hotelcost)+
                    Float.parseFloat(costperday))*Float.parseFloat(staynumber)*Float.parseFloat(peoplenumber);
            //please
            tc=Float.toString(totalcost);

            BufferedWriter writer=new BufferedWriter(new FileWriter("Book.txt",true));
            writer.write(name.getText()+"~"+phone.getText()+"~"+email.getText()+"~"+number.getText()+"~"
                    +destination.getText()+"~"+stayday.getText()+"~"+aircar+"~"+tc+"\n");
            writer.close();


        }catch (Exception e){}

    }
    public void displaydest(ActionEvent event) {
        try{
            Parent root= FXMLLoader.load(getClass().getResource("disp_dest_user.fxml"));
            stage =(Stage)((Node)event.getSource()).getScene().getWindow();
            scene=new Scene(root,850,500);
            stage.setTitle("DIDPLAY DESTINATION");
            stage.setResizable(false);
            stage.setScene(scene);
            stage.show();}catch (Exception e){}
    }

    public void check(ActionEvent event) {
        try{
            Parent root= FXMLLoader.load(getClass().getResource("search_booking.fxml"));
            stage =(Stage)((Node)event.getSource()).getScene().getWindow();
            scene=new Scene(root,700,500);
            stage.setTitle("SEARCH BOOKING");
            stage.setResizable(false);
            stage.setScene(scene);
            stage.show();}catch (Exception e){}
    }
}
