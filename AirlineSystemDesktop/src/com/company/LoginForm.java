package com.company;

import javax.swing.*;
import java.awt.*;

public class LoginForm extends JFrame{
    //-----------------L A B E L S-----------------//
    Container container = getContentPane();
    JLabel emailLabel = new JLabel ("Email: ");
    JLabel passwordLabel = new JLabel("Passoword: ");
    //-----------------L A B E L S-----------------//
    //____________________________________________//
    //-----------------T E X T  F I E L D S-----------------//
    JTextField usernameTextField = new JTextField();
    JPasswordField passwordField = new JPasswordField();
    //-----------------T E X T  F I E L D S-----------------//
    JButton btn = new JButton("Sign In");
    Button reg_btn = new Button("Sign Up");



    LoginForm(){
        setLayoutManager();
        SetLocationAndSize();
        addComponentsToContainer();
    }
    public void setLayoutManager(){
        container.setLayout(null);
    }
    public void SetLocationAndSize(){

        emailLabel.setBounds(10,10,100,30);
        passwordLabel.setBounds(10,50,100,30);
        usernameTextField.setBounds(90,10,220,30);
        passwordField.setBounds(90,50,220,30);
        btn.setBounds(120,90,100,30);
        reg_btn.setBounds(120,130,100,30);

    }
    public void addComponentsToContainer(){
        container.add(emailLabel);
        container.add(passwordLabel);
        container.add(usernameTextField);
        container.add(passwordField);
        container.add(btn);
        container.add(reg_btn);

    }
}

