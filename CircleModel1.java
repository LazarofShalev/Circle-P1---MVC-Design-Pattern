

import java.util.ArrayList;
import java.util.EventListener;
import javafx.beans.property.SimpleBooleanProperty;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.scene.paint.Color;

public class CircleModel1 {

	private SimpleDoubleProperty radius = new SimpleDoubleProperty(20);
	private SimpleBooleanProperty filled = new SimpleBooleanProperty();
	
	private Color color;

	private ArrayList<EventHandler<Event>> eventListenerList = new ArrayList<EventHandler<Event>>();

	public void setRadius(SimpleDoubleProperty radius) {
		this.radius = radius;
		notifyListeners(new ActionEvent(), new SimpleStringProperty("radius"));
	}

	public void setFilled(SimpleBooleanProperty filled) {
		this.filled.setValue(filled.getValue());
		notifyListeners(new ActionEvent(), new SimpleStringProperty("filled"));
	}

	public void setColor(Color color) {
		this.color = color;
		notifyListeners(new ActionEvent(), new SimpleStringProperty("Color"));
	}

	public Color getColor() {
		return color;
	}

	public SimpleDoubleProperty getRadius() {
		return radius;
	}

	public SimpleBooleanProperty isFilled() {
		return this.filled;
	}

	public void addListener(EventHandler<Event> e) {
		eventListenerList.add(e);
	}

	public void removeListener(EventListener e) {
		if (eventListenerList != null && eventListenerList.contains(e))
			eventListenerList.remove(e);
	}

	public void notifyListeners(ActionEvent e, SimpleStringProperty simpleStringProperty) {

		System.out.println("size of actionListenerList is: " + eventListenerList.size());
		System.out.println("event is: " + simpleStringProperty.getValue());

		for (int i = 0; i < eventListenerList.size(); i++) {
			eventListenerList.get(i).handle(e);
		}
	}
}