package controller;

import DAO.EmployeeDAO;
import Model.Employee;
import java.awt.event.ActionEvent;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalTime;
import javax.swing.DefaultListModel;
import javax.swing.JOptionPane;
import view.EmployeeListView;
import view.MainView;

public class MainController {
    private MainView mainView;
    private EmployeeDAO employeeDAO;

    public MainController(MainView mainView, EmployeeDAO employeeDAO) {
        this.mainView = mainView;
        this.employeeDAO = employeeDAO;
        mainView.setShowButtonActionListener(this::onClickShowButton);
        mainView.setDeleteButtonActionListener(this::onClickDeleteButton);
        mainView.setNewButtonActionListener(this::onClickNewButton);
        mainView.setUpdateButtonActionListener(this::onClickUpdateButton);
        mainView.setForwardButtonActionListener(this::onClickForwardButton);
        mainView.setBackwardButtonActionListener(this::onClickBackwardButton);
        mainView.setListButtonActionListener(this::onClickListButton);
    }

    public void onClickListButton(ActionEvent e) {
        EmployeeListView listView = new EmployeeListView();

        DefaultListModel<String> defaultListModel = new DefaultListModel<>();
        for (Employee employee : employeeDAO.getAllemployees()) {
            defaultListModel.addElement( employee.toString() );
        }
        listView.setListModel(defaultListModel);
        mainView.enableWindow(false);

        listView.addWindowListener(new WindowListener() {
            @Override
            public void windowOpened(WindowEvent e) {}

            @Override
            public void windowClosing(WindowEvent e) {}

            @Override
            public void windowClosed(WindowEvent e) {
                mainView.enableWindow(true);
                mainView.getFocus();
            }

            @Override
            public void windowIconified(WindowEvent e) {}

            @Override
            public void windowDeiconified(WindowEvent e) {}

            @Override
            public void windowActivated(WindowEvent e) {}

            @Override
            public void windowDeactivated(WindowEvent e) {}
        });
    }

    public void onClickForwardButton(ActionEvent e) {
        int id = mainView.getid();
        int lastid = employeeDAO.lastempid();
        int startid = id;
        Employee employee = null;
        do {
            id++;
            if (id > lastid) id=1;
            employee = employeeDAO.getempid(id);
            if (id == startid) {
            JOptionPane.showMessageDialog(null, "No valid employee found.");
            return; }
        } while (employee == null);
        mainView.showid(id);
        onClickShowButton(e);
    }

    public void onClickBackwardButton(ActionEvent e) {
        int id = mainView.getid();
        int lastid = employeeDAO.lastempid();
        Employee employee = null;
        int startid = id;
        do {
            id--;
            if (id < 1) id = lastid;
            employee = employeeDAO.getempid(id);
            if (id == startid) {
            JOptionPane.showMessageDialog(null, "No valid employee found.");
            return; }
        } while (employee == null);
        mainView.showid(id);
        onClickShowButton(e);
    }

    /**
     * @param e
     */
    public void onClickNewButton(ActionEvent e) {
        int id = mainView.getid();
        String name = mainView.getname();
        LocalDate date = mainView.getdate();
        LocalTime check_in = mainView.getcheck_in();
        LocalTime check_out = mainView.getcheck_out();
        BigDecimal hours_worked = mainView.gethours_worked();
        if (id > 0 && !name.isBlank()) {
        if (employeeDAO.getempid(id) != null) {
            mainView.showWarning("Employee ID " + id + " already exists.");
        } else {
            boolean success = employeeDAO.insertEmployee(
                new Employee(id, name, date, check_in, check_out, hours_worked)
            );
            if (success)
                mainView.showMessage("Employee added successfully");
            else
                mainView.showWarning("Unable to add this Employee");
        }
    } else {
        mainView.showWarning("Please provide a valid Employee ID and name.");
    }
}

    public void onClickUpdateButton(ActionEvent e) {
        int id = mainView.getid();
        String name = mainView.getname();
        LocalDate date = mainView.getdate();
        LocalTime check_in = mainView.getcheck_in();
        LocalTime check_out = mainView.getcheck_out();
        BigDecimal hours_worked = mainView.gethours_worked();
        if (id > 0 && !name.isBlank()) {
            Employee emp = new Employee( id, name, date, check_in, check_out, hours_worked);
            boolean success = employeeDAO.updateEmployee(id, emp);
            if (success)
                mainView.showMessage("update  successfully");
            else   
                mainView.showWarning("Unable to update this Employee");
        }
        else
            mainView.showWarning("Please provide a valid Employee id and Employee name");
    }

    public void onClickDeleteButton(ActionEvent e) {
        int id = mainView.getid();
        if (id > 0) {
            Employee employee = employeeDAO.getempid(id);
            if (employee != null) {
                if (mainView.confirmationDialog("Do you really want to delete the details of " + employee.getname())) {
                    if (employeeDAO.deleteemployee(id)) {
                        mainView.showMessage("Employee deleted successfully");
                        blankAccountView();
                    }
                }
            }
            else {
                mainView.showWarning("There is no account with that number!");
            }
        }
    }

    public void onClickShowButton(ActionEvent e) {
        int id = mainView.getid();
        if (id <= 0) {
            mainView.showWarning("Please enter an ID.");
        return;
        }

            Employee employee = employeeDAO.getempid(id);
            if (employee != null) {
                mainView.showname(employee.getname());
                mainView.showdate(employee.getdate());
                mainView.showcheck_in(employee.getcheck_in());
                mainView.showcheck_out(employee.getcheck_out());
                mainView.showhours_worked(employee.gethours_worked());
                
            }   else {
                mainView.showWarning(
                    "An account with that number does not exist!");
                blankAccountView();
        }
    }
    private void blankAccountView() {
        mainView.showname("");
        mainView.showdate(null);
        mainView.showcheck_in(null);
        mainView.showcheck_out(null);
        mainView.showhours_worked(null);
    
    }
}
