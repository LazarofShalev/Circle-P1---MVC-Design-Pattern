

import javafx.beans.property.SimpleBooleanProperty;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.control.ColorPicker;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;

public class CircleController1 extends GridPane {

	private CircleModel1 model;

	private Label radiusLabel = new Label("Radius  ");
	private Label filledLabel = new Label("Filled  ");
	private Label colorLabel = new Label("Color  ");
	private TextField tfRadius = new TextField();

	private ComboBox<String> trueFalseChoise = new ComboBox<>();

	private ColorPicker colorPicker = new ColorPicker();
	private String[] radiusTextFieldStringArray = { "false", "true" };

	public CircleController1() {

		this.setPadding(new Insets(15, 15, 15, 15));
		this.setHgap(10);
		this.setVgap(10);

		ObservableList<String> items = FXCollections.observableArrayList(radiusTextFieldStringArray);
		trueFalseChoise.getItems().addAll(items);

		colorPicker.setPrefWidth(150);
		
		trueFalseChoise.setPrefWidth(150);
		trueFalseChoise.setValue("false");
		colorPicker.setValue(Color.BLACK);

		add(radiusLabel, 0, 0);
		add(filledLabel, 0, 1);
		add(tfRadius, 1, 0);
		add(trueFalseChoise, 1, 1);
		add(colorLabel, 0, 2);
		add(colorPicker, 1, 2);

		EventHandler<ActionEvent> handler = e -> {
			if (e.getSource() == tfRadius) {
				try{
				model.setRadius(new SimpleDoubleProperty(Double.parseDouble(tfRadius.getText())));
				} catch (Exception ex) {
					tfRadius.setText("inputError");
				}
			} else if (e.getSource() == trueFalseChoise) {
				if (items.indexOf(trueFalseChoise.getValue()) == 0) {
					model.setFilled(new SimpleBooleanProperty(false));
				} else {
					model.setFilled(new SimpleBooleanProperty(true));
				}
			} else if (e.getSource() == colorPicker) {
				model.setColor(colorPicker.getValue());
			}
		};

		tfRadius.setOnAction(handler);
		trueFalseChoise.setOnAction(handler);
		colorPicker.setOnAction(handler);
		
	}

	public void setModel(CircleModel1 newModel) {
		model = newModel;
	}

	public CircleModel1 getModel() {
		return model;
	}

	public TextField getRadiusTextField() {
		return tfRadius;
	}
}
