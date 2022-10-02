import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class MainCodePage extends JFrame{


    private JButton AddNewEmp;
    private JTable table;
    private JPanel ListPage;
    private JTextField idSearchQry;
    private JTextField nameSearchQry;
    private JButton search;
    private JLabel tfName;
    private JLabel tfId;

    Registration_form registrationForm = new Registration_form();
    EmployeeProfilePage employeeDetailPage = new EmployeeProfilePage();

    DataStore dataStore;

    public MainCodePage() {
        dataStore = DataStore.getDataStoreInstance();
        AddNewEmp.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                registerNewUser();
                updateList();
            }
        });
        search.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                updateList();
            }
        });

        table.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent listSelectionEvent) {
                if(table.getSelectedRow()<0)return;
                String idOfSelected = (String) table.getValueAt(table.getSelectedRow(),0);
                table.clearSelection();
                Employee e = dataStore.getRecord(idOfSelected);
                if(Objects.isNull(e)){
                    return;
                }

                employeeDetailPage.setContentPane(employeeDetailPage.employeeDetailPage);
                employeeDetailPage.setTitle("Employee Detail");
                employeeDetailPage.setSize(800,600);
                employeeDetailPage.setVisible(true);
                employeeDetailPage.setData(e);
            }
        });
    }

    public void updateList(){

        String idSearchQry = this.idSearchQry.getText();
        String nameSearchQry = this.nameSearchQry.getText();

        String[] columnNames = { "ID", "Name"};
        List<Employee> empList = dataStore.getRecords().stream().filter(employee ->
            employee.getId().contains(idSearchQry)
        ).filter(employee -> employee.getName().contains(nameSearchQry)).collect(Collectors.toList());
        System.out.println(empList.size());
        DefaultTableModel model = new DefaultTableModel(columnNames,0){
            @Override
            public boolean isCellEditable(int row, int column) {
                //all cells false
                return false;
            }
        };

        for(int i=0;i<empList.size();i++){
            Employee emp = empList.get(i);
            Object[] row = { emp.getId(), emp.getName()};
            model.addRow(row);
        }
        table.setModel(model);
    }

    public void registerNewUser()
    {
        registrationForm.setContentPane(registrationForm.EmployeeRegForm);
        registrationForm.setTitle("Registration Form");
        registrationForm.setSize(600,400);
        registrationForm.setVisible(true);
    }

    public static void main(String[] args){
        MainCodePage listPage = new MainCodePage();
        listPage.setContentPane(listPage.ListPage);
        listPage.setTitle("Application");
        listPage.setSize(800,600);
        listPage.setVisible(true);
        listPage.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    }
}
