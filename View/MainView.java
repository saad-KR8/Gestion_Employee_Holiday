package View;
import javax.swing.*;
public class MainView extends JFrame {
    private static final MainView INSTANCE = new MainView();
    private JTabbedPane tabbedPane = new JTabbedPane();
    private MainView() {
        setTitle("Application de gestion des employees et congees ");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(950, 550);
        setLocationRelativeTo(null);
        tabbedPane.addTab("Gestion des Employés", EmployeeView.getInstance().getContentPane());
        tabbedPane.addTab("Gestion des Holidays", HolidayView.getInstance().getContentPane());
        add(tabbedPane);
        setVisible(true);
    }
    public static MainView getInstance() {
        return INSTANCE;
    }
}
