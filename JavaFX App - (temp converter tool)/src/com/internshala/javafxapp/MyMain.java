package com.internshala.javafxapp;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.util.Optional;

public class MyMain extends Application {
	public static void main(String[] args){
		System.out.println("main");
    launch(args);
	}

	@Override
	public void init() throws Exception {
		System.out.println("init");
		super.init();
	}

	@Override
	public void start(Stage primaryStage) throws Exception {
		System.out.println("start");
		FXMLLoader loader = new
				FXMLLoader(getClass().getResource("app_layout.fxml"));
		VBox rootNode = loader.load();
		MenuBar menuBar=createMenu();
		rootNode.getChildren().add(0,menuBar);

		Scene scene = new Scene(rootNode, 300, 275);

		primaryStage.setScene(scene);
		primaryStage.setTitle("Temperature Converter Tool");
		primaryStage.setResizable(true);
		primaryStage.show();
	}
private MenuBar createMenu()
	{
     Menu fileMenu=new Menu("File");
     MenuItem newMenuItem=new MenuItem("New");
		newMenuItem.setOnAction(event -> System.out.println("done"));
     SeparatorMenuItem separate=new SeparatorMenuItem();
     MenuItem newquit=new MenuItem("Quit");
     newquit.setOnAction(event -> {
     	Platform.exit();
     	System.exit(0);
     });
     fileMenu.getItems().addAll(newMenuItem,separate,newquit);
     Menu helpMenu=new Menu("Help");
     MenuItem about=new MenuItem("About");
     about.setOnAction(event -> aboutApp());
     helpMenu.getItems().addAll(about);
     MenuBar menuBar=new MenuBar();
     menuBar.getMenus().addAll(fileMenu,helpMenu);
     return menuBar;
	}

	private void aboutApp() {
		Alert alertDialogue=new Alert(Alert.AlertType.INFORMATION);
		alertDialogue.setTitle("About Me");
		alertDialogue.setHeaderText("Vishwa");
		alertDialogue.setContentText("i m kumar vishwajeeet.i m a beginner but on the way to become pro...");
		ButtonType btnyes=new ButtonType("Yes");
		ButtonType btnno=new ButtonType("No");
		alertDialogue.getButtonTypes().setAll(btnyes,btnno);
		Optional<ButtonType>clickedbtn=alertDialogue.showAndWait();
		if (clickedbtn.isPresent()&&clickedbtn.get()==btnyes)
		{
			System.out.println("yes clicked");
		}
		if(clickedbtn.isPresent()&&clickedbtn.get()==btnno)
		{
			System.out.println("no clicked");
		}
	}

	@Override
	public void stop() throws Exception {
		System.out.println("stop");
		super.stop();
	}
}
