package javaapplication23;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import java.sql.*;

public class frmCustomer implements ActionListener {

    JFrame myFrame;
    JPanel myPanel;
    JLabel lblName, lblBirthday, lblAddress, lblMobile, lblEmail;
    JTextField txtName, txtBirthday, txtAddress, txtMobile, txtEmail, txtStatus;
    JButton btnSave, btnClear, btnExit;

    public frmCustomer() {
        myFrame = new JFrame("Customer Information Entry Form");
        myFrame.setSize(330, 300);
        myFrame.setLocationRelativeTo(null);
        myPanel = new JPanel();
        myFrame.setContentPane(myPanel);
        myPanel.setBackground(new Color(128,128,128));
        myPanel.setLayout(null);
        lblName = new JLabel("Name");
        lblName.setSize(100, 30);
        lblName.setForeground(Color.white);
        myPanel.add(lblName);
        lblName.setLocation(10, 10);
        txtName = new JTextField();
        txtName.setSize(120, 30);
        myPanel.add(txtName);
        txtName.setLocation(120, 10);
        lblBirthday = new JLabel("Birthday");
        lblBirthday.setSize(100, 30);
        lblBirthday.setForeground(Color.white);
        myPanel.add(lblBirthday);
        lblBirthday.setLocation(10, 45);
        txtBirthday = new JTextField();
        txtBirthday.setSize(120, 30);
        myPanel.add(txtBirthday);
        txtBirthday.setLocation(120, 45);
        lblAddress = new JLabel("Address");
        lblAddress.setSize(100, 30);
        lblAddress.setForeground(Color.white);
        myPanel.add(lblAddress);
        lblAddress.setLocation(10, 80);
        txtAddress = new JTextField();
        txtAddress.setSize(120, 30);
        myPanel.add(txtAddress);
        txtAddress.setLocation(120, 80);
        lblMobile = new JLabel("Mobile");
        lblMobile.setSize(100, 30);
        lblMobile.setForeground(Color.white);
        myPanel.add(lblMobile);
        lblMobile.setLocation(10, 115);
        txtMobile = new JTextField();
        txtMobile.setSize(120, 30);
        myPanel.add(txtMobile);
        txtMobile.setLocation(120, 115);
        lblEmail = new JLabel("Email");
        lblEmail.setSize(100, 30);
        lblEmail.setForeground(Color.white);
        myPanel.add(lblEmail);
        lblEmail.setLocation(10, 150);
        txtEmail = new JTextField();
        txtEmail.setSize(120, 30);
        myPanel.add(txtEmail);
        txtEmail.setLocation(120, 150);
        btnSave = new JButton("Save");
        btnSave.setSize(120, 25);
        btnSave.setFont(new Font("Helvetica", Font.PLAIN, 12));
        myPanel.add(btnSave);
        btnSave.setLocation(25, 190);
        btnSave.addActionListener(this);
        btnClear = new JButton("Clear");
        btnClear.setSize(120, 25);
        btnClear.setFont(new Font("Helvetica", Font.PLAIN, 12));
        myPanel.add(btnClear);
        btnClear.setLocation(150, 190);
        btnClear.addActionListener(this);
        
        txtStatus = new JTextField("Ready");
        txtStatus.setSize(305, 30);
        txtStatus.setHorizontalAlignment(JLabel.RIGHT);
        
        myPanel.add(txtStatus);
        txtStatus.setLocation(1, 230);
        txtStatus.setForeground ( Color.black);
        txtStatus.setBackground (new Color(175, 225, 175));
        txtStatus.setBorder(BorderFactory.createEtchedBorder(1));
        
        
        myFrame.setVisible(true);
        myFrame.setAlwaysOnTop(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == btnSave) {
            try {
                Class.forName("com.mysql.jdbc.Driver");

                Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/sampleDB2",
                        "root", "");
                Statement st = con.createStatement();
                String customer, birthday, address, mobile, email, sql;
                customer = txtName.getText().toString();
                birthday = txtBirthday.getText().toString();
                address = txtAddress.getText().toString();
                mobile = txtMobile.getText().toString();
                email = txtEmail.getText().toString();
                sql = "Insert into customers values(null, '" + customer + "', '" + birthday + "', '" + address + "', '"
                        + mobile + "', '" + email + "')";
                int x = st.executeUpdate(sql);
                if (x == 1) {
                    txtStatus.setText("Record successfully added");
                } else {
                    txtStatus.setText("Record was not added");
                }
                clearEntry();
            } catch (SQLException | ClassNotFoundException ex) {
                txtStatus.setText("Error: " + ex.getMessage());
                txtStatus.setForeground ( Color.black);
                txtStatus.setBackground (new Color(196, 30, 58));
            }
        } else if (e.getSource() == btnClear) {
            txtStatus.setText("Ready");
            clearEntry();
        }
    }

    public void clearEntry() {
        txtName.setText("");
        txtBirthday.setText("");
        txtAddress.setText("");
        txtMobile.setText("");
        txtEmail.setText("");
        txtName.requestFocus();
    }
}
