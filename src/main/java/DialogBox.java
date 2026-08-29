import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;

public class DialogBox extends HBox {
    private Label text;
    private ImageView displayPic;

    public DialogBox(String s, Image i) {
        text = new Label(s);
        displayPic = new ImageView(i);

        // Styling
        text.setWrapText(true);
        displayPic.setFitWidth(100.0);
        displayPic.setFitHeight(100.0);
        this.setAlignment(Pos.TOP_RIGHT);

        this.getChildren().addAll(text, displayPic);
    }
}
