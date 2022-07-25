package javaapplication23;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class frmSplash {

    JFrame myFrame;
    JPanel myPanel;
    JLabel lblVersion, lblCreator, lblCopyright, lblImage, lblProgram;
    ImageIcon myIcon;

    public frmSplash() {
        myFrame = new JFrame();
        myFrame.setUndecorated(true);
        myFrame.setSize(450, 275);
        myFrame.setLocationRelativeTo(null);
        myPanel = new JPanel();
        myFrame.setContentPane(myPanel);
        myPanel.setLayout(null);
        myPanel.setBackground(new Color(128,128,128));

        lblProgram = new JLabel("Activity 5&6");

        lblProgram.setSize(400, 200);
        lblProgram.setFont(
                new Font("Times New Roman", Font.BOLD, 46));
                lblProgram.setForeground(Color.white);
        myPanel.add(lblProgram);

        lblProgram.setLocation(100, 40);
       
        lblVersion = new JLabel("Kem, Jeff, Mike");

        lblVersion.setFont(
                new Font("Arial", Font.PLAIN, 8));
        lblVersion.setForeground(Color.red);
        lblVersion.setSize(
                100, 25);
        myPanel.add(lblVersion);

        lblVersion.setLocation(
                350, 230);
        lblCopyright = new JLabel("Copyright 2022, all rights reserved");

        lblCopyright.setFont(
                new Font("Arial", Font.PLAIN, 8));
        lblCopyright.setForeground(Color.white);
        lblCopyright.setSize(
                200, 25);
        myPanel.add(lblCopyright);

        lblCopyright.setLocation(
                10, 230);
        lblCreator = new JLabel("Macro Hard Solutions, Inc");

        lblCreator.setFont(
                new Font("Script MT Bold", Font.BOLD, 12));
        lblCreator.setForeground(Color.red);
        lblCreator.setSize(
                150, 30);
        myPanel.add(lblCreator);

        lblCreator.setLocation(
                250, 190);

         myIcon = new ImageIcon(new ImageIcon("Photo.jpg").getImage().getScaledInstance(600, 300,Image.SCALE_SMOOTH));
        lblImage = new JLabel();

        lblImage.setIcon(myIcon);

        lblImage.setSize(430, 255);
        myPanel.add(lblImage);

        lblImage.setLocation(10, 10);
        
        myFrame.setVisible(
                true);
    }

    public void unShow() {
        myFrame.setVisible(false);
    }

 public static void main(String[] args) {
        try {
            frmSplash mySplash = new frmSplash();
            Thread.sleep(5000);
            mySplash.unShow();
            
            frmLog myLog = new frmLog();
            

        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}


























//kem
//sampledb2