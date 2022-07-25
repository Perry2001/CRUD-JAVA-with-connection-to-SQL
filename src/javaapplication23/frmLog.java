package javaapplication23;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.DriverManager;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import java.sql.*;

public class frmLog implements ActionListener {

    JFrame myFrame;
    JPanel myPanel;
    JLabel lblUser, lblPassword;
    JTextField txtUser;
    JPasswordField pssWord;
    

JButton btnLog, btnClear;

    public frmLog() {
        myFrame = new JFrame("User's Login Form");
        myFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        myFrame.setLocationRelativeTo(null);
        myFrame.setSize(300, 200);
        myPanel = new JPanel();
        myFrame.setContentPane(myPanel);
        myPanel.setLayout(null);
        myPanel.setBackground(new Color(128,128,128));
        lblUser = new JLabel("UserName");
        lblUser.setFont(new Font("Arial", Font.BOLD, 14));
        lblUser.setForeground(Color.black);
        lblUser.setSize(100, 25);
        myPanel.add(lblUser);
        lblUser.setLocation(10, 10);
        txtUser = new JTextField();
        txtUser.setFont(new Font("Arial", Font.PLAIN, 14));
        txtUser.setSize(100, 25);
        txtUser.setHorizontalAlignment(JTextField.LEFT);
        myPanel.add(txtUser);
        txtUser.setLocation(120, 10);
        lblPassword = new JLabel("Password");
        lblPassword.setFont(new Font("Arial", Font.BOLD, 14));
        lblPassword.setForeground(Color.black);
        lblPassword.setSize(100, 25);
        myPanel.add(lblPassword);
        lblPassword.setLocation(10, 45);
        pssWord = new JPasswordField();
        pssWord.setSize(100, 25);
        pssWord.setHorizontalAlignment(JPasswordField.LEFT);
        myPanel.add(pssWord);
        pssWord.setLocation(120, 45);
        btnLog = new JButton("Login");
        btnLog.setFont(new Font("Arial", Font.BOLD, 12));
        btnLog.setSize(80, 30);
        myPanel.add(btnLog);
        btnLog.setLocation(30, 90);
        btnLog.addActionListener(this);
        btnClear = new JButton("Clear");
        btnClear.setFont(new Font("Arial", Font.BOLD, 12));
        btnClear.setSize(80, 30);

        myPanel.add(btnClear);
        btnClear.setLocation(140, 90);
        btnClear.addActionListener(this);
        myFrame.setVisible(true);
    }

    public void closeLog() {
        myFrame.setVisible(false);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == btnLog) {
            try {
                Class.forName("com.mysql.jdbc.Driver");
                Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/sampleDB2",
                        "root", "");
                Statement st = con.createStatement();
                String user, pword, sql;
                
                char[] mypass;
                user = txtUser.getText().toString();
                mypass = pssWord.getPassword();
                pword = String.valueOf(mypass);
                sql = "Select * from users where userName='" + user + "' and userPassword=password('"
                        + pword + "')";
                ResultSet rs = st.executeQuery(sql);
                String usr = "", pd = "";
                int utype = 0, ctr = 0;
                while (rs.next()) {
                    ctr++; // do this to count the number of records retrieved
                }
                frmMain myForm = new frmMain();
                closeLog();
            } catch (SQLException | ClassNotFoundException ex) {
                System.out.println("Error: " + ex.getMessage());
            }
        } else if (e.getSource() == btnClear) {
            txtUser.setText("");
            pssWord.setText("");
            txtUser.requestFocus();
        }
    }
}
