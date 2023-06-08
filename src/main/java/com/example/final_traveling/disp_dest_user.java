package com.example.final_traveling;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

import javafx.scene.control.TableView;

import java.io.BufferedReader;
import java.io.FileReader;
import java.net.URL;
import java.util.ResourceBundle;


public class disp_dest_user implements Initializable{

    @FXML
    public TableView<List> disp_dest;
    @FXML
    private TableColumn<List,String > distance;
    @FXML
    private TableColumn<List, String> destination;
    @FXML
    private TableColumn<List,String > costair;
    @FXML
    private TableColumn<List, String> costcar;
    @FXML
    private TableColumn<List,String > costday;
    @FXML
    private TableColumn<List, String> hotel;
    @FXML
    private TableColumn<List, String> costhotel;
    private    Stage stage;
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


    @Override
    public  void initialize(URL url, ResourceBundle resourceBundle){
        try{
            String[] temp=new String[7];
            BufferedReader reader=new BufferedReader(new FileReader("Destination.txt"));
            String line,c,b,d,e,f,g,h;
            while ((line=reader.readLine())!=null){
                temp=line.split("~");
                b=temp[0];
                c=temp[1];
                d=temp[2];
                e=temp[3];
                f=temp[4];
                g=temp[5];
                h=temp[6];
                List a=new List(b,c,d,e,f,g,h);
                disp_dest.getItems().add(a);
            }
            reader.close();

        }
        catch (Exception e){}


        destination.setCellValueFactory(new PropertyValueFactory<List,String>("destination"));
        distance.setCellValueFactory(new PropertyValueFactory<List,String>("distance"));
        costair.setCellValueFactory(new PropertyValueFactory<List,String>("costair"));
        costcar.setCellValueFactory(new PropertyValueFactory<List,String>("costcar"));
        costday.setCellValueFactory(new PropertyValueFactory<List,String>("costday"));
        hotel.setCellValueFactory(new PropertyValueFactory<List,String>("hotel"));
        costhotel.setCellValueFactory(new PropertyValueFactory<List,String>("costhotel"));
    }

    public void tobook(ActionEvent event) {
        try{
            Parent root= FXMLLoader.load(getClass().getResource("book.fxml"));
            stage =(Stage)((Node)event.getSource()).getScene().getWindow();
            scene=new Scene(root,700,500);
            stage.setTitle("BOOK TOUR");
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




