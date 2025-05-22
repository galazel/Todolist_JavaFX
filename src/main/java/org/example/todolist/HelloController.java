package org.example.todolist;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.geometry.Insets;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.*;

public class HelloController {
    @FXML
    private TextField inputNote;
    @FXML
    private VBox taskContainer;
    @FXML
    private Label status;

    @FXML
    protected void addNote(ActionEvent e)
    {
        String note = inputNote.getText();
        if (note.isEmpty()) {
            Alert notify = new Alert(Alert.AlertType.ERROR);
            notify.setTitle("Invalid Note");
            notify.setHeaderText(null);
            notify.setContentText("Please fill in the field to add note");
            notify.showAndWait();
        } else {
            status.setStyle("-fx-font-color: green");
            status.setText("Note created successfully!");
            HBox box = new HBox();
            box.setStyle("-fx-border-color: red; -fx-border-width: 2px;");
            box.setSpacing(10);
            box.setPadding(new Insets(10));
            Label label = new Label(note);

            Region spacer = new Region();
            HBox.setHgrow(spacer, Priority.ALWAYS);

            Button deleteBtn = new Button("Delete");
            deleteBtn.setOnAction(actionEvent -> taskContainer.getChildren().remove(box));
            box.getChildren().addAll(label, spacer, deleteBtn);
            taskContainer.getChildren().add(box);
            inputNote.clear();
        }

    }


}