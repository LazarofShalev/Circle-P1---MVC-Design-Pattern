

import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;

public class CircleView1 extends Pane implements EventHandler<Event> {

	private CircleModel1 model = new CircleModel1();
	private Circle circle = new Circle(20);

	public CircleView1() {
		circle.centerXProperty().bind(widthProperty().divide(2));
		circle.centerYProperty().bind(heightProperty().divide(2));
		circle.setStroke(Color.BLACK);
		circle.setFill(Color.TRANSPARENT);
		getChildren().add(circle);
	}

	public void setModel(CircleModel1 newModel) {
		if (model != null) {
			model = newModel;
			model.addListener(this);
		}
	}

	public CircleModel1 getModel() {
		return model;
	}

	@Override
	public void handle(Event e) {
		
		circle.setRadius(model.getRadius().doubleValue());
		
		if(model.getColor() == null){
			model.setColor(Color.BLACK);
			circle.setStroke(model.getColor());
		}
		
		if (model.isFilled().getValue() == false) {
			circle.setStroke(model.getColor());
			circle.setFill(Color.TRANSPARENT);
		} else {
			circle.setFill(model.getColor());
			circle.setStroke(model.getColor());
		}
	}
}