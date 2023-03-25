package com.mycompany.compressor.decompressor;

import comp_decomp.Compressor;
import comp_decomp.Decompressor;
import javax.swing.*;
import java.awt.event.*;
import java.awt.*;
import java.io.*;

public class AppFrame extends JFrame implements ActionListener{
    
    JButton compressButton;
    JButton decompressButton;
    
    AppFrame(){
        
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//        close the operation or execution on click of close button

        compressButton = new JButton("Select the file to compress");
        compressButton.setBounds(100, 100, 200, 20);
        compressButton.addActionListener(this);
        add(compressButton);
        
        decompressButton = new JButton("Select the file to decompress");
        decompressButton.setBounds(320, 100, 200, 20);
        decompressButton.addActionListener(this);
        add(decompressButton);
        
        setSize(1000, 500);
        setLocation(300, 10);
        getContentPane().setBackground(Color.BLACK);
        setVisible(true);
    }
    
    @Override
    public void actionPerformed(ActionEvent ae){
        if(ae.getSource() == compressButton){
            JFileChooser fileChooser = new JFileChooser();
//            used to browse file from pc
            int response = fileChooser.showSaveDialog(null);
//            it pops up a save file chooser dialog
            if(response == JFileChooser.APPROVE_OPTION){
//                is yes is selected
                File file = new File(fileChooser.getSelectedFile().getAbsolutePath());
                System.out.println(file);
                try{
                    Compressor.method(file);
                }catch(Exception e){
                    JOptionPane.showMessageDialog(null, e.toString());
                }
            }
        }
        
        if(ae.getSource() == decompressButton){
            JFileChooser fileChooser = new JFileChooser();
//            used to browse file from pc
            int response = fileChooser.showSaveDialog(null);
//            it pops up a save file chooser dialog
            if(response == JFileChooser.APPROVE_OPTION){
//                is yes is selected
                File file = new File(fileChooser.getSelectedFile().getAbsolutePath());
                System.out.println(file);
                try{
                    Decompressor.method(file);
                }catch(Exception e){
                    JOptionPane.showMessageDialog(null, e.toString());
                }
            }
        }
    }
}
