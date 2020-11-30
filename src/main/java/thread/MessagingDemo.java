//JavaFX  Update UI asynchronously with messages
package thread;

import javafx.concurrent.Task;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.*;
import javafx.application.*;

public class MessagingDemo extends Application {
  public void start(Stage stage) {
    // "message1" won’t be seen because we perform the next action on the JavaFX 
    // application thread then update the label text again without releasing the 
    // thread to the JavaFX system.
    Label label = new Label("message1");
    label.setPrefWidth(300);

    // some action

    // "action done" won’t be seen because we set text again in the next statement.
    label.setText("action done");

    // you're not going to see this because we immediately bind text to the task text and launch the task. 
    label.setText("calling method.. wait for some time");

    Task <Void> task = new Task<Void>() {
      @Override public Void call() throws InterruptedException {
        // "message2" time consuming method (this message will be seen).
        updateMessage("message2");

        // some actions
        Thread.sleep(3000);

        // "message3" time consuming method (this message will be seen).
        updateMessage("message3"); 

        //more  time consuming actions
        Thread.sleep(7000);

        // this will never be actually be seen because we also set a message 
        // in the task::setOnSucceeded handler.
        updateMessage("time consuming method is done with success");

        return null;
      }
    };

    label.textProperty().bind(task.messageProperty());

    task.setOnSucceeded(e -> {
      label.textProperty().unbind();
      // this message will be seen.
      label.setText("operation completed successfully");
    });

    Thread thread = new Thread(task);
    thread.setDaemon(true);
    thread.start();

    stage.setScene(new Scene(label));
    stage.show();
  }

  public static void main(String args[]) {
    launch(args);
  }
}