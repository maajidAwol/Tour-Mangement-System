package com.example.final_traveling;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.awt.*;
import java.io.BufferedReader;
import java.io.FileReader;

public class search_booking {
    @FXML
    public javafx.scene.control.Button search;
    @FXML
    public javafx.scene.control.Button sendemail;
    @FXML
    public javafx.scene.control.Label name;
    @FXML
    public javafx.scene.control.Label message;
    String nm;
    @FXML
    public javafx.scene.control.Label destination;
    String ds;
    @FXML
    public javafx.scene.control.Label numberoftourist;
    String nt;
    @FXML
    public javafx.scene.control.Label phone;
    String pn;
    @FXML
    public javafx.scene.control.Label stayday;
    String sd;
    @FXML
    public javafx.scene.control.Label email;
    String em;
    @FXML
    public javafx.scene.control.Label totalcost;
    String tc;
    @FXML
    public javafx.scene.control.Label travelby;
    String tb;
    @FXML
    javafx.scene.control.TextField in;



    private    Stage stage;
    private Scene scene;
    private Parent root;
String emailbody;

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

    public void display(ActionEvent event) {

            try{
                Parent root= FXMLLoader.load(getClass().getResource("disp_dest_user.fxml"));
                stage =(Stage)((Node)event.getSource()).getScene().getWindow();
                scene=new Scene(root,850,500);
                stage.setTitle("BOOK TOUR");
                stage.setResizable(false);
                stage.setScene(scene);
                stage.show();}catch (Exception e){}
    }

    public void booking(ActionEvent event) {

        try{
            Parent root= FXMLLoader.load(getClass().getResource("book.fxml"));
            stage =(Stage)((Node)event.getSource()).getScene().getWindow();
            scene=new Scene(root,700,500);
            stage.setTitle("BOOK TOUR");
            stage.setResizable(false);
            stage.setScene(scene);
            stage.show();}catch (Exception e){}

    }


    public void search(ActionEvent event) {
        try{
            String[] temp=new String[8];
            BufferedReader reader=new BufferedReader(new FileReader("Book.txt"));
            String line,c,b,d,e,f,g,h,i;
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
                i=temp[7];
                if(in.getText().equals(b)){
                   nm=b;
                   pn=c;
                   em=d;
                   nt=e;
                   ds=f;
                   sd=g;
                   tb=h;
                   tc=i;
                   flag=1;
                   break;
                }
            }
            if(flag==1){
                name.setText(nm);
                destination.setText(ds);
                numberoftourist.setText(nt);
                phone.setText(pn);
                email.setText(em);
                stayday.setText(sd);
                totalcost.setText(tc);
                travelby.setText(tb);
                message.setText("Match Found");
                emailbody="THANK YOU FOR CHOOSING US\n"+"NAME : "+nm+"\nDESTINATION : "+ds
                +"\nNUMBER: "+nt+"\nPHONE : "+pn+"\nTOTAL COST : "+tc+"\nTRAVEL BY: "+tb+"\nSTAY DAY "+sd
                +"\n\nHave a Memorable Time!!!";

            }

    }catch (Exception e){}}

    public void send(ActionEvent event) {
          Mail mail=new Mail();
          mail.send_email(em,emailbody);
    }
}

