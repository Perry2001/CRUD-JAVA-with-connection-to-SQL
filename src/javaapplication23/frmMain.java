package javaapplication23;

import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class frmMain implements ActionListener {

    JFrame myFrame;
    JPanel myPanel;
    JMenuBar mbMain;
    JMenu mFile, mCustomer;
    JMenuItem miExit, miAddCustomer, miCustomerViewer;

    public frmMain() {
        myFrame = new JFrame("My Java Application");
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        myFrame.setSize(screenSize.width, screenSize.height);
        myFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        myFrame.setLocationRelativeTo(null);
        myPanel = new JPanel();
        myFrame.setContentPane(myPanel);
        myPanel.setLayout(null);
        mbMain = new JMenuBar();
        mFile = new JMenu("File");
        mFile.setMnemonic(KeyEvent.VK_F);
        mbMain.add(mFile);
        mCustomer = new JMenu("Customer");
        mCustomer.setMnemonic(KeyEvent.VK_C);
        mbMain.add(mCustomer);
        miExit = new JMenuItem("Exit", KeyEvent.VK_X);
        mFile.add(miExit);
        miExit.addActionListener(this);
        miAddCustomer = new JMenuItem("Add Customer", KeyEvent.VK_A);

        mCustomer.add(miAddCustomer);
        miAddCustomer.addActionListener(this);
        miCustomerViewer = new JMenuItem("View Customer", KeyEvent.VK_V);
        mCustomer.add(miCustomerViewer);
        miCustomerViewer.addActionListener(this);
        myFrame.setJMenuBar(mbMain);
        myFrame.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == miAddCustomer) {
            frmCustomer myCustomer = new frmCustomer();
        
        } else if (e.getSource() == miExit) {
            int ans = JOptionPane.showConfirmDialog(myFrame, "Exit Application?");
            if (ans == JOptionPane.YES_OPTION) {
                System.exit(0);
            }
        }
    }
}
