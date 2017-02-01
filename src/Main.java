import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class Main extends Application {
    @Override
    public void start(Stage primaryStage) throws Exception {
        int tegijaid = 70;
        Andmebaas baas = new Andmebaas(tegijaid);
        Pane pane = new Pane();
        Scene scene = new Scene(pane, 500, 500);

        Label juhis = new Label("Sisesta esimesse lahtrisse nimi ja teise tulemus");
        Label suurimTulemus = new Label();
        suurimTulemus.setTranslateY(120);
        Label labivus = new Label();
        labivus.setTranslateY(150);

        TextField knimi = new TextField();
        knimi.setTranslateY(30);
        TextField tulemus = new TextField();
        tulemus.setTranslateY(60);

        Button submit = new Button("Järgmine");
        submit.setTranslateY(90);

        submit.setOnMouseClicked(event -> {
            baas.lisaSisestus(knimi.getText(),tulemus.getText());
            knimi.clear();
            tulemus.clear();
            suurimTulemus.setText(baas.parimTulemus());
            labivus.setText(baas.labivusProtsent());
        });

        pane.getChildren().addAll(juhis, knimi, tulemus, submit, suurimTulemus, labivus);
        primaryStage.setScene(scene);
        primaryStage.show();

    }
}