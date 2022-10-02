import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Objects;

public class Registration_form extends JFrame{
    private JLabel nameLabel;
    private JLabel genderLabel;
    public JPanel EmployeeRegForm;
    private JLabel startDateLabel;
    private JLabel levelLabel;
    private JLabel getTeamInfo;
    private JLabel phoneLabel;
    private JLabel emailLabel;
    private JButton saveButton;
    private JButton clearButton;
    private JTextField name;
    private JTextField teamInfo;
    private JTextField phone;
    private JTextField email;
    private JTextField level;
    private JTextField setDOB;
    private JTextField startDate;
    private JTextField gender;
    private JLabel idLabel;
    private JTextField id;
    private JButton selectImageFileButton;
    private JTextField age;
    private JLabel ageLabel;
    private JTextField position;

    private BufferedImage img;

    public Registration_form() {
        saveButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {

                if(id.getText().isEmpty() && !name.getText().isEmpty()){
                    JOptionPane.showMessageDialog(saveButton,  "Id is required");
                    return;
                }else if(!id.getText().isEmpty() && name.getText().isEmpty()){
                    JOptionPane.showMessageDialog(saveButton,  "Name is required");
                    return;
                }else if(id.getText().isEmpty() && name.getText().isEmpty()) {
                    JOptionPane.showMessageDialog(saveButton, "Id and Name are required");
                    return;
                }

                DataStore storeInstance = DataStore.getDataStoreInstance();
                System.out.println(id.getText() + "fetched");
                storeInstance.addRecordIfNotExist(new Employee(id.getText(), name.getText(), age.getText(),
                        gender.getText(), startDate.getText(), level.getText(), teamInfo.getText(), position.getText(),
                        phone.getText(), email.getText(), img));
                JOptionPane.showMessageDialog(saveButton,  "Added successfully!!!");
                clearAll();
            }
        });
        clearButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                clearAll();
            }
        });
        selectImageFileButton.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                JFileChooser chooser = new JFileChooser();
                int ch = chooser.showOpenDialog(null);

                if(ch==JFileChooser.APPROVE_OPTION){
                    try {
                        File fl = chooser.getSelectedFile();
                        img = ImageIO.read(fl);
                        selectImageFileButton.setEnabled(false);
                        selectImageFileButton.setText(fl.getAbsolutePath());
                    } catch (IOException ex) {
                        JOptionPane.showMessageDialog(null, "Unable to load image");
                    }
                }
            }
        });
    }

    private void resetImage(){
        selectImageFileButton.setEnabled(true);
        selectImageFileButton.setText("Select Image File");
        img=null;
    }

    private void clearAll(){
        id.setText("");
        name.setText("");
        age.setText("");
        gender.setText("");
        startDate.setText("");
        level.setText("");
        teamInfo.setText("");
        position.setText("");
        phone.setText("");
        email.setText("");
        resetImage();
    }
}
