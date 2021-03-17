package demo;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class Main extends Application {

    Stage window;

    TableView<Student> tableView;

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        window = primaryStage;
        window.setTitle("List students - Demo");

        // Name column
        TableColumn<Student, String> nameColumn = new TableColumn<>("Name");
        nameColumn.setMinWidth(200);
        nameColumn.setCellValueFactory(new PropertyValueFactory<>("name"));

        // Age column
        TableColumn<Student, String> ageColumn = new TableColumn<>("Age");
        ageColumn.setMinWidth(100);
        ageColumn.setCellValueFactory(new PropertyValueFactory<>("age"));

        // Score column
        TableColumn<Student, String> scoreColumn = new TableColumn<>("Score");
        scoreColumn.setMinWidth(100);
        scoreColumn.setCellValueFactory(new PropertyValueFactory<>("score"));

        tableView = new TableView<>();

        tableView.setItems(getStudents());
        tableView.getColumns().addAll(nameColumn, ageColumn, scoreColumn);


        VBox vBox = new VBox();
        vBox.getChildren().addAll(tableView);

        Scene scene = new Scene(vBox);
        window.setScene(scene);
        window.show();
    }

    public ObservableList<Student> getStudents() {

        ObservableList<Student> students = FXCollections.observableArrayList();

        students.add(new Student("Đào Minh Giang", 19, 4.50));
        students.add(new Student("La Văn Phi", 28, 9.50));
        students.add(new Student("Phan Văn Dũng", 28, 8.50));

        return bubbleSort(students);
    }

    // Hàm sắp xếp nổi bọt
    ObservableList<Student> bubbleSort(ObservableList<Student> listSort) {
        int n = listSort.size();
        for (int i = 0; i < n - 1; i++)
            for (int j = 0; j < n - i - 1; j++)
                if (listSort.get(j).getScore() < listSort.get(j + 1).getScore()) {
                    // swap students.get(j + 1) và students.get(i)
                    double score = listSort.get(j).getScore();
                    listSort.get(j).setScore(listSort.get(j + 1).getScore());
                    listSort.get(j + 1).setScore(score);
                }

        return listSort;
    }
}
