package com.company;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;
import java.util.Random;

//-----------------L O G I N   F O R M-----------------//
class uiLoginForm extends JFrame{

    //-----------------L A B E L S-----------------//
        Container container = getContentPane();
        JLabel usernameLabel = new JLabel ("Username: ");
        JLabel passwordLabel = new JLabel("Passoword: ");
    //-----------------L A B E L S-----------------//
    //____________________________________________//
    //-----------------T E X T  F I E L D S-----------------//
        JTextField usernameTextField = new JTextField();
        JPasswordField passwordField = new JPasswordField();
    //-----------------T E X T  F I E L D S-----------------//
        JButton btn = new JButton("Sign In");
        Button reg_btn = new Button("Sign Up");



        uiLoginForm(){
        setLayoutManager();
        SetLocationAndSize();
        addComponentsToContainer();
        }
       public void setLayoutManager(){
        container.setLayout(null);
        }
        public void SetLocationAndSize(){

            usernameLabel.setBounds(10,10,100,30);
            passwordLabel.setBounds(10,50,100,30);
            usernameTextField.setBounds(90,10,220,30);
            passwordField.setBounds(90,50,220,30);
            btn.setBounds(120,90,100,30);
            reg_btn.setBounds(120,130,100,30);

        }
        public void addComponentsToContainer(){
            container.add(usernameLabel);
            container.add(passwordLabel);
            container.add(usernameTextField);
            container.add(passwordField);
            container.add(btn);
            container.add(reg_btn);

        }
        }
//-----------------R E G I S T E R   F O R M-----------------//

class uiRegisterForm extends JFrame{

    Container regContainer =  getContentPane();
    //-----------------L A B E L S-----------------//
    JLabel firstNameLabel = new JLabel("First Name:");
    JLabel surnameLabel = new JLabel("Second Name:");
    JLabel emailLabel = new JLabel("Email:");
    JLabel regPassworLabel = new JLabel("Password:");
    JLabel RePasswordLabel = new JLabel("Repeat Password:");
    //-----------------L A B E L S-----------------//

    JButton regbtn = new JButton("Register");

    //____________________________________________//

    //-----------------T E X T  F I E L D S-----------------//
    JTextField firstNameTxtField = new JTextField();
    JTextField surnameTxtField = new JTextField();
    JTextField emailTxtField = new JTextField();
    JPasswordField passwordTxtField = new JPasswordField();
    JPasswordField rePasswordTxtField = new JPasswordField();
    //-----------------T E X T  F I E L D S-----------------//

    uiRegisterForm(){
        setRegLayoutManager();
        setRegLocationAndSize();
        addRegComponentsToContainer();
    }
    public void setRegLayoutManager(){
        regContainer.setLayout(null);
    }
    public void setRegLocationAndSize(){
        firstNameLabel.setBounds(10,10,100,30);
        surnameLabel.setBounds(10,50,100,30);
        emailLabel.setBounds(10,90,100,30);
        regPassworLabel.setBounds(10,130,100,30);
        RePasswordLabel.setBounds(10,170,130,30);

        regbtn.setBounds(160,210,100,30);

        firstNameTxtField.setBounds(120,10,220,30);
        surnameTxtField.setBounds(120,50,220,30);
        emailTxtField.setBounds(120,90,220,30);
        passwordTxtField.setBounds(120,130,220,30);
        rePasswordTxtField.setBounds(120,170,220,30);

    }
    public void addRegComponentsToContainer(){
        regContainer.add(firstNameLabel);
        regContainer.add(surnameLabel);
        regContainer.add(emailLabel);
        regContainer.add(regPassworLabel);
        regContainer.add(RePasswordLabel);

        regContainer.add(regbtn);

        regContainer.add(firstNameTxtField);
        regContainer.add(surnameTxtField);
        regContainer.add(emailTxtField);
        regContainer.add(passwordTxtField);
        regContainer.add(rePasswordTxtField);
    }
}

class DataBaseConnection {
     String URL = "jdbc:mysql://localhost:3306/customers";
     String USER = "defuser";
     String PASSWORD = "password";
}

public class Main {
    public static final String JDBC_DRIVER = "com.mysql.cj.jdbc.Driver";


    public static void main(String[] args) {
        //-------------------L O G I N  F O R M-------------------//
        uiLoginForm frame = new uiLoginForm();
        frame.setTitle("Login");
        frame.setVisible(true);
        frame.setResizable(false);
        frame.setBounds(10,10,350,210);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        //-------------------L O G I N  F O R M-------------------//
        //-------------------------------------------------------//
        //-------------------R E G I S T E R  F O R M-------------------//
        uiRegisterForm regFrame = new uiRegisterForm();
        regFrame.setTitle("Register");
        regFrame.setVisible(false);
        regFrame.setBounds(10,10,450,310);
        regFrame.setResizable(false);

        frame.reg_btn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                regFrame.setVisible(true);
            }
        });

        //---------------------------DB CONNECTION LOGIN---------------------------//
        DataBaseConnection dbConnection = new DataBaseConnection();
        frame.btn.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    Connection connection = DriverManager.getConnection(dbConnection.URL, dbConnection.USER, dbConnection.PASSWORD);
                    Statement stmt = connection.createStatement();
                    String SQL = "SELECT * FROM customer WHERE username ='"+frame.usernameTextField.getText()+"'AND password = '"+frame.passwordField.getText()+"'";
                    ResultSet rs = stmt.executeQuery(SQL);
                    if(rs.next()){
                        JOptionPane.showMessageDialog(null,"Welcome! "+frame.usernameTextField.getText());

                    }
                    else{
                        JOptionPane.showMessageDialog(null,"Wrong username or password!","ERROR",JOptionPane.ERROR_MESSAGE);
                    }
                }
                catch (Exception E) {
                    System.out.println("Connection was not successful2!");

                }
            }
        });
        //---------------------------DB CONNECTION REGISTER---------------------------//

            regFrame.regbtn.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    char first = regFrame.firstNameTxtField.getText().charAt(0);
                    String secChar = "";
                    if(regFrame.surnameTxtField.getText().length() > 2){
                        secChar = regFrame.surnameTxtField.getText().substring(0,5);
                    }
                    Random rand = new Random();
                    int rand_int1 = rand.nextInt(1000);
                    String genUserName = first+"_"+secChar+rand_int1;
                    try{
                        Connection con = DriverManager.getConnection(dbConnection.URL, dbConnection.USER, dbConnection.PASSWORD);
                        String insertQuery;
                        insertQuery = "INSERT INTO `customer`(`first_name`,`surname`,`email`,`password`,`username`)"+"VALUES(?,?,?,?,?)";
                        Class.forName(JDBC_DRIVER);
                        PreparedStatement pst = con.prepareStatement(insertQuery);
                        pst.setString(1,regFrame.firstNameTxtField.getText());
                        pst.setString(2,regFrame.surnameTxtField.getText());
                        pst.setString(3,regFrame.emailTxtField.getText());
                        pst.setString(4,regFrame.passwordTxtField.getText());
                        pst.setString(5,genUserName.toLowerCase());
                        pst.executeUpdate();
                        pst.close();
                    }
                    catch (Exception ex){
                        System.out.println("Connection was not successful!");
                    }

                    }

            });

     }

}

