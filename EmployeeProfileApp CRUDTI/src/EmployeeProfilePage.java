import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.Objects;

public class EmployeeProfilePage extends JFrame{
    private JTextField EmployeeId;
    private JTextField Name;
    private JButton saveButton;
    public JPanel employeeDetailPage;
    private JLabel image;
    private JTextField Gender;
    private JTextField startDate;
    private JTextField level;
    private JTextField teamInfo;
    private JTextField Age;
    private JTextField email;
    private JTextField phone;
    private JTextField position;
    private JButton deleteButton;

    private BufferedImage image1;

    public EmployeeProfilePage() { //save button code
        saveButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                DataStore dataStore  = DataStore.getDataStoreInstance();
                Employee employee = new Employee(EmployeeId.getText(), Name.getText(), Age.getText(), Gender.getText(),
                        startDate.getText(), level.getText(), teamInfo.getText(), position.getText(),
                        phone.getText(), email.getText(), image1);

                dataStore.updateRecord(employee);
            }
        });


        deleteButton.addActionListener(new ActionListener() {//delete button code
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                DataStore ds  = DataStore.getDataStoreInstance();
                ds.deleteRecord(EmployeeId.getText());
                JOptionPane.showMessageDialog(saveButton,  "Deleted successfully!");
            }
        });
//        image.addMouseListener(new MouseAdapter() {
//            @Override
//            public void mouseClicked(MouseEvent e) {
//                super.mouseClicked(e);
//                JFileChooser chooser = new JFileChooser();
//                int ch = chooser.showOpenDialog(null);
//
//                if(ch==JFileChooser.APPROVE_OPTION){
//                    try {
//                        image1 = ImageIO.read(chooser.getSelectedFile());
//                    } catch (IOException ex) {
//                        JOptionPane.showMessageDialog(null,  "Can't load image");
//                    }
//                }
//                showImage();
//            }
//        });
    }

    public void setData(Employee e) {
        EmployeeId.setText(e.getId());
        Name.setText(e.getName());
        Age.setText(e.getAge());
        Gender.setText(e.getGender());
        startDate.setText(e.getStartDate());
        level.setText(e.getLevel());
        teamInfo.setText(e.getTeamInfo());
        position.setText(e.getPosition());
        phone.setText(e.getPhone());
        email.setText(e.getEmail());
        image1 = e.getImage();
        showImage();
    }

//    private void showImage() {
//        if(Objects.nonNull(image1)){
//            image.setIcon(new ImageIcon(image1));
//        }
//    }
}
