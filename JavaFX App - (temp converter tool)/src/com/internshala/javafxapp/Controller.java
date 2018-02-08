package com.internshala.javafxapp;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;

import java.net.URL;
import java.util.ResourceBundle;

public class Controller implements Initializable {
	@FXML
	public Label welcome;
    @FXML
    public ChoiceBox<String> choice;
    @FXML
    public TextField text;
    @FXML
    public Button button;
    private static final String cToF="Celcius to Fahrenheit";
    private static final String fToC="Fahrenheit to Celcius";
    private  boolean isCToF=true;
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		choice.getItems().add(cToF);
		choice.getItems().add(fToC);
		choice.setValue(cToF);
		choice.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) ->
		{
			if (newValue.equals(cToF)) {
				isCToF = true;
			} else {
				isCToF = false;
			}
		});
		button.setOnAction(event ->
		{
			convert();
		});
	}float newTemp=0.0f;
	private void convert()
		{
   String input=text.getText();
   float enteredTemp=0.0f;
   try
   {
   	enteredTemp=Float.parseFloat(input);
   }catch(Exception e)
   {
   	warnUser();
   	return;
   }
   if(isCToF)
   {
   	newTemp=(enteredTemp*9/5)+32;
   }else
   {
   	newTemp=(enteredTemp-32)*5/9;
   }
   display(newTemp);
		}

	private void warnUser()
	{
		Alert alert=new Alert(Alert.AlertType.ERROR);
		alert.setTitle("Error Occured");
		alert.setHeaderText("Invalid Temperature Entered");
		alert.setContentText("Please enter correct temperature");
		alert.show();
	}

	private void display(float newTemp)
	{
		char unit=isCToF?'F':'C';
		System.out.println("Your temperature is :"+newTemp+unit);
		Alert alert=new Alert(Alert.AlertType.INFORMATION);
		alert.setTitle("Result");
		alert.setContentText("Your temperature is : "+newTemp+" "+unit);
		alert.show();

	}


}
