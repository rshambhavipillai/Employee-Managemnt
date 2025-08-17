package controller;


import DAO.EmployeeDBbySQL;
import view.MainViewImpl;

public class Main {
    public static void main(String[] args) {
        MainController controller = new MainController(new MainViewImpl(), new EmployeeDBbySQL());
    }
}
