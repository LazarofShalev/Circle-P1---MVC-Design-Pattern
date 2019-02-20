

import javafx.application.Application;
import javafx.application.Platform;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

public class SingleCircleMVC1 extends Application {

	private CircleModel1 model = new CircleModel1();

	@Override
	public void start(Stage primaryStage) throws Exception {

		Button btController = new Button("Show Controller");
		Button btView = new Button("Show View");

		HBox mainPain = new HBox();
		mainPain.setSpacing(10);
		mainPain.setAlignment(Pos.CENTER);
		
		mainPain.getChildren().add(btController);
		mainPain.getChildren().add(btView);

		btController.setOnMouseClicked(e -> {
			
			CircleController1 btControllerPane = new CircleController1();
			btControllerPane.setModel(model);
			
			Stage btControllerStage = new Stage();			
			Scene btControllerScene = new Scene(btControllerPane);
			
			btControllerStage.setTitle("Controller");
			btControllerStage.setScene(btControllerScene);		
			btControllerStage.show();
			btControllerStage.setAlwaysOnTop(true);
			btControllerStage.setResizable(false);
		});

		btView.setOnMouseClicked(e -> {
			
			CircleView1 jbtControllerView = new CircleView1();
			jbtControllerView.setModel(model);
				
			Stage jbtViewPaneStage = new Stage();			
			Scene jbtViewScene = new Scene(jbtControllerView, 250, 250);
			
			jbtViewPaneStage.setTitle("View");
			jbtViewPaneStage.setScene(jbtViewScene);			
			jbtViewPaneStage.show();
			jbtViewPaneStage.setAlwaysOnTop(true);
			
		});

		Scene mainScene = new Scene(mainPain, 350, 50);
		primaryStage.setTitle("SingleCirculeMvc1");
		primaryStage.setScene(mainScene);
		primaryStage.show();
		primaryStage.setAlwaysOnTop(true);
		primaryStage.setResizable(false);
		primaryStage.setOnCloseRequest(e -> Platform.exit());
	}
	
	

	public static void main(String[] start) {
		launch(start);
	}

}
