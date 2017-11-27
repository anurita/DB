package sample;

import javafx.application.Application;
import javafx.beans.InvalidationListener;
import javafx.collections.FXCollections;
import javafx.collections.ListChangeListener;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.*;
import javafx.scene.control.TableView;
import javafx.stage.Stage;
import java.sql.*;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

public class Main extends Application {
    @FXML
    private TableView<Main> Employees = new TableView<>();
    private ObservableList data = new ObservableList() {
        @Override
        public void addListener(ListChangeListener listener) {

        }

        @Override
        public void removeListener(ListChangeListener listener) {

        }

        @Override
        public boolean addAll(Object[] elements) {
            return false;
        }

        @Override
        public boolean setAll(Object[] elements) {
            return false;
        }

        @Override
        public boolean setAll(Collection col) {
            return false;
        }

        @Override
        public boolean removeAll(Object[] elements) {
            return false;
        }

        @Override
        public boolean retainAll(Object[] elements) {
            return false;
        }

        @Override
        public void remove(int from, int to) {

        }

        @Override
        public int size() {
            return 0;
        }

        @Override
        public boolean isEmpty() {
            return false;
        }

        @Override
        public boolean contains(Object o) {
            return false;
        }

        @Override
        public Iterator iterator() {
            return null;
        }

        @Override
        public Object[] toArray() {
            return new Object[0];
        }

        @Override
        public Object[] toArray(Object[] a) {
            return new Object[0];
        }

        @Override
        public boolean add(Object o) {
            return false;
        }

        @Override
        public boolean remove(Object o) {
            return false;
        }

        @Override
        public boolean containsAll(Collection c) {
            return false;
        }

        @Override
        public boolean addAll(Collection c) {
            return false;
        }

        @Override
        public boolean addAll(int index, Collection c) {
            return false;
        }

        @Override
        public boolean removeAll(Collection c) {
            return false;
        }

        @Override
        public boolean retainAll(Collection c) {
            return false;
        }

        @Override
        public void clear() {

        }

        @Override
        public Object get(int index) {
            return null;
        }

        @Override
        public Object set(int index, Object element) {
            return null;
        }

        @Override
        public void add(int index, Object element) {

        }

        @Override
        public Object remove(int index) {
            return null;
        }

        @Override
        public int indexOf(Object o) {
            return 0;
        }

        @Override
        public int lastIndexOf(Object o) {
            return 0;
        }

        @Override
        public ListIterator listIterator() {
            return null;
        }

        @Override
        public ListIterator listIterator(int index) {
            return null;
        }

        @Override
        public List subList(int fromIndex, int toIndex) {
            return null;
        }

        @Override
        public void addListener(InvalidationListener listener) {

        }

        @Override
        public void removeListener(InvalidationListener listener) {

        }
    };
    @Override
    public void start(Stage primaryStage) throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("sample.fxml"));
        String url = "";
        String userName = "";
        String password = "";
        String dbName = "";
        String driver = "com.mysql.jdbc.Driver";
        Connection connection = DriverManager.getConnection(url + dbName, userName, password);
        Statement stmt = connection.createStatement();
        ResultSet rs = stmt.executeQuery("select * from Employee");
        ResultSetMetaData resultMetaData = rs.getMetaData();
        while (rs.next()) {
            ObservableList row = FXCollections.observableArrayList();

            for (int i = 1; i <= rs.getMetaData().getColumnCount(); i++) {
                row.add(rs.getString(i));

            }

            data.add(row);

        }
        Employees.setItems(data);
        primaryStage.setTitle(connection.toString());
        connection.close();
        primaryStage.setScene(new Scene(root, 300, 275));
        primaryStage.show();
    }


    public static void main(String[] args) {
        launch(args);
    }
}
