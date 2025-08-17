package view;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionListener;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

public class MainViewImpl extends JFrame implements MainView {

    private JButton showButton = new JButton("Show");
    private JButton newButton = new JButton("New");
    private JButton deleteButton = new JButton("Delete");
    private JButton listButton = new JButton("List");
    private JButton forwardButton = new JButton("⮚");
    private JButton backwardButton = new JButton("⮘");
    private JButton updateButton = new JButton("Update");
    private JTextField textempid = new JTextField();
    private JTextField textname = new JTextField();
    private JTextField textdate = new JTextField();
    private JTextField textcheck_in = new JTextField();
    private JTextField textcheck_out = new JTextField();
    private JTextField texthours_worked = new JTextField();
    
    public MainViewImpl() {
        setTitle("Employee Attendance");
        setSize(600, 350);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        addComponent();
        pack();
        setVisible(true);
    }

    private void addComponent() {
        setLayout( new BorderLayout() );


        JPanel bottomPanel = new JPanel( new FlowLayout() );
        add( bottomPanel, BorderLayout.SOUTH );

        JPanel centerPanel = new JPanel( new GridLayout(6, 2) );
        centerPanel.setBorder(new EmptyBorder(5,5,5,5));
        add( centerPanel, BorderLayout.CENTER );

        centerPanel.add( new JLabel("Employee Id:") );
        centerPanel.add( textempid );
        centerPanel.add( new JLabel("Name") );
        centerPanel.add( textname );
        centerPanel.add( new JLabel("Date") );
        centerPanel.add( textdate );
        centerPanel.add( new JLabel("check_in") );
        centerPanel.add( textcheck_in );
        centerPanel.add( new JLabel("check_out") );
        centerPanel.add( textcheck_out );
        centerPanel.add( new JLabel("hours_worked") );
        centerPanel.add( texthours_worked );

        bottomPanel.add(backwardButton);
        bottomPanel.add( showButton );
        bottomPanel.add( newButton );
        bottomPanel.add( updateButton );
        bottomPanel.add( listButton );
        bottomPanel.add(deleteButton);
        bottomPanel.add(forwardButton);
    }

    @Override
    public void showid(int id) {
        textempid.setText( String.valueOf(id) );
    }

    @Override
    public void showname(String name) {
        textname.setText(name);
    }

    @Override
    public void showdate(LocalDate date) {
        textdate.setText(date.toString());
    }

    @Override
    public void showcheck_in(LocalTime check_in) {
        textcheck_in.setText(check_in.toString());
    }

    @Override
    public void showcheck_out(LocalTime check_out) {
        textcheck_out.setText(check_out.toString());
    }

    @Override
    public void showhours_worked(BigDecimal hours_worked ) { 
        texthours_worked.setText(hours_worked.toString());
    }

    @Override
    public int getid() {
        int id = 0;
        try {
            id = Integer.parseInt( textempid.getText() );
        }
        catch (NumberFormatException ignored) {
            // silencing this exception
            //showWarning("Please, enter a valid account number");
        }
        return id;
    }

    @Override
    public void showMessage(String message) {
        JOptionPane.showMessageDialog(
            this, message, "Information", JOptionPane.INFORMATION_MESSAGE);
    }

    @Override
    public  void showWarning(String message) {
        JOptionPane.showMessageDialog(
            this, message, "Warning", JOptionPane.WARNING_MESSAGE);
    }

    @Override
    public boolean confirmationDialog(String message) {
        return JOptionPane.YES_OPTION == JOptionPane.showConfirmDialog(this, message, "Question", JOptionPane.YES_NO_OPTION);
    }

    @Override
    public String getname() {
        return textname.getText();
    }

    @Override
    public LocalDate getdate() {
    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
    return LocalDate.parse(textdate.getText(),formatter);
    }
    
    @Override
    public LocalTime getcheck_in() {
    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("H:mm"); 
    return LocalTime.parse(textcheck_in.getText(), formatter);
    }

    @Override
    public LocalTime getcheck_out() {
    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("H:mm");
    return LocalTime.parse(textcheck_out.getText(), formatter);
    }

    @Override
    public BigDecimal gethours_worked() {
    return new BigDecimal(texthours_worked.getText());
    }

    @Override
    public void setShowButtonActionListener(ActionListener listener) {
        showButton.addActionListener(listener);
    }

    @Override
    public void setListButtonActionListener(ActionListener listener) {
        listButton.addActionListener(listener);
    }

    @Override
    public void setNewButtonActionListener(ActionListener listener) {
        newButton.addActionListener(listener);
    }
    
    @Override
    public void setUpdateButtonActionListener(ActionListener listener) {
        updateButton.addActionListener(listener);
    }
    @Override
    public void setDeleteButtonActionListener(ActionListener listener) {
        deleteButton.addActionListener(listener);
    }

    @Override
    public void setBackwardButtonActionListener(ActionListener listener) {
        backwardButton.addActionListener(listener);
    }

    @Override
    public void setForwardButtonActionListener(ActionListener listener) {
        forwardButton.addActionListener(listener);
    }

    @Override
    public void enableWindow(boolean enabled) {
        setEnabled(enabled);
    }

    @Override
    public void getFocus() {
        requestFocus();
    }
}
