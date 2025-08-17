package view;

import java.awt.event.ActionListener;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalTime;

public interface MainView {

    void showid(int id);
    void showname(String name);
    void showdate(LocalDate date);
    void showcheck_in(LocalTime check_in);
    void showcheck_out(LocalTime check_out);
    void showhours_worked(BigDecimal hours_worked);

    void showMessage(String message);
    void showWarning(String message);
    boolean confirmationDialog(String message);

    int getid();
    String getname();
    LocalDate getdate();
    LocalTime getcheck_in();
    LocalTime getcheck_out();
    BigDecimal gethours_worked();

    void setShowButtonActionListener(ActionListener listener);
    void setNewButtonActionListener(ActionListener listener);
    void setDeleteButtonActionListener(ActionListener listener);
    void setBackwardButtonActionListener(ActionListener listener);
    void setForwardButtonActionListener(ActionListener listener);
    void setListButtonActionListener(ActionListener listener);
    void setUpdateButtonActionListener(ActionListener listener);

    void enableWindow(boolean enabled);
    void getFocus();
}
