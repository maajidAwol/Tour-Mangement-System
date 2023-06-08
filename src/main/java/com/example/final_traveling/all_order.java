package com.example.final_traveling;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

import java.io.BufferedReader;
import java.io.FileReader;
import java.net.URL;
import java.util.ResourceBundle;

public class all_order implements Initializable {
    @FXML
    public TableView<List> customers;
    @FXML
    private TableColumn<List,String > custname;
    @FXML
    private TableColumn<List, String> custphone;
    @FXML
    private TableColumn<List,String > custemail;
    @FXML
    private TableColumn<List, String> custtotal;
    private Stage stage;
    float tt;
    private Scene scene;
    private Parent root;
    public void backhome(ActionEvent event) {
        try{
            Parent root= FXMLLoader.load(getClass().getResource("home.fxml"));
            stage =(Stage)((Node)event.getSource()).getScene().getWindow();
            scene=new Scene(root,700,500);
            stage.setTitle("HOMEPAGE");
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
    public void adddestination(ActionEvent event) {
        try {
            Parent root= FXMLLoader.load(getClass().getResource("add_dest.fxml"));
            stage =(Stage)((Node)event.getSource()).getScene().getWindow();
            scene=new Scene(root,700,500);
            stage.setTitle("REGISTER NEW DESTINATION");
            stage.setResizable(false);
            stage.setScene(scene);
            stage.show();
        }catch (Exception e){};
    }

    @Override
    public  void initialize(URL url, ResourceBundle resourceBundle){
        try{
            String[] temp=new String[8];
            BufferedReader reader=new BufferedReader(new FileReader("Book.txt"));
            String line,c,b,d,e,f,g,h,i;
            while ((line=reader.readLine())!=null){
                temp=line.split("~");
                b=temp[0];
                c=temp[1];
                d=temp[2];
                //
                e=temp[3];
                f=temp[4];
                g=temp[5];
                h=temp[6];
                i=temp[7];


                List l=new List(b,c,d,i);
                customers.getItems().add(l);
            }
            reader.close();

        }
        catch (Exception e){}


        custname.setCellValueFactory(new PropertyValueFactory<List,String>("custname"));
        custphone.setCellValueFactory(new PropertyValueFactory<List,String>("custphone"));
        custemail.setCellValueFactory(new PropertyValueFactory<List,String>("custemail"));
        custtotal.setCellValueFactory(new PropertyValueFactory<List,String>("custtotal"));

    }


}
