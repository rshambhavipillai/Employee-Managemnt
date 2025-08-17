package view;

import java.awt.BorderLayout;
import java.awt.ScrollPane;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JList;

public class EmployeeListView extends JFrame {
    private JList<String> employeeList = new JList<>();

    public EmployeeListView() {
        setTitle("Employee List");
        setSize(500, 500);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);

        setLayout( new BorderLayout() );
        ScrollPane scrollPane = new ScrollPane();
        scrollPane.add(employeeList, BorderLayout.CENTER);
        add(scrollPane);

        JButton okayButton = new JButton("Okay");
        add(okayButton, BorderLayout.SOUTH );
        okayButton.addActionListener( e -> dispose() );
        pack();
        setVisible(true);
    }

    public void setListModel(DefaultListModel<String> listModel) {
        employeeList.setModel(listModel);
    }
}
