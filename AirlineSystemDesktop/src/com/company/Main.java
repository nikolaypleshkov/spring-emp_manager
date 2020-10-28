package com.company;

import org.jdatepicker.JDatePicker;
import org.jdatepicker.impl.JDatePanelImpl;
import org.jdatepicker.impl.JDatePickerImpl;
import org.jdatepicker.impl.UtilDateModel;

import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.*;
import java.util.Date;
import java.util.List;


//-----------------L O G I N   F O R M-----------------//
class uiLoginForm extends JFrame{

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

        uiLoginForm(){
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
class DateLabelFormatter extends JFormattedTextField.AbstractFormatter {

     String datePattern = "yyyy-MM-dd";
     SimpleDateFormat dateFormatter = new SimpleDateFormat(datePattern);

    @Override
    public Object stringToValue(String text) throws ParseException {
        return dateFormatter.parseObject(text);
    }

    @Override
    public String valueToString(Object value) throws ParseException {
        if (value != null) {
            Calendar cal = (Calendar) value;
            return dateFormatter.format(cal.getTime());
        }

        return "";
    }

}

//-------------------------M A I N  F O R M -------------------------//
class uiMainForm extends JFrame{

    Container container = getContentPane();

    JLabel header = new JLabel("Ticket");
    JLabel fromLabel = new JLabel("From:");
    JLabel toLabel = new JLabel("To:");
    JLabel classLabel = new JLabel("Class:");
    JLabel travLabel = new JLabel("Departure:");
    JLabel depLabel = new JLabel("Return:");
    JLabel adultLabel = new JLabel("Adult:");
    JLabel childLabel = new JLabel("Children:");
    JButton sbm_btn = new JButton("Submit");
    Button serch_btn = new Button("Search");

    JLabel leg = new JLabel("Airports:");
    JLabel airports = new JLabel("<html>Copenhagen Airport (CPH)<br/>" +
            "<html>Charles de Gaulle Airport (CDG)<br/> " +
            "<html>Josep Tarradellas Barcelona–El Prat Airport (BCN)<br/>" +
            "<html> Rome Fiumicino Airport (FCO)<br/>" +
            "<html> Madrid-Barajas Adolfo Suárez Airport (MAD)<br/>" +
            "<html>London Heathrow Airport (LHR)<br/>" +
            "<html>Istanbul International Airport (IST)<br/>" +
            "<html>Amsterdam Airport Schiphol(AMS)<br/>" +
            "<html>Frankfurt Airport (FRA)");

    JComboBox boxFrom=new JComboBox(getAllCountries());
    JComboBox boxTo = new JComboBox(getAllCountriesTo());

    JComboBox combo1 = new JComboBox(getChoice());

    Properties p = new Properties();
    UtilDateModel model = new UtilDateModel();
    JDatePanelImpl datePanel = new JDatePanelImpl(model,p);
    JDatePickerImpl datePicker = new JDatePickerImpl(datePanel,new DateLabelFormatter());

    UtilDateModel model2 = new UtilDateModel();
    JDatePanelImpl datePanel2 = new JDatePanelImpl(model2,p);
    JDatePickerImpl datePicker2 = new JDatePickerImpl(datePanel2,new DateLabelFormatter());

    SpinnerModel spinnerModel = new SpinnerNumberModel(1, 1, 10, 1);
    JSpinner spinner = new JSpinner(spinnerModel);

    SpinnerModel spinnerModel2 = new SpinnerNumberModel(1,1,10,1);
    JSpinner spinner2 = new JSpinner(spinnerModel2);


    JTable jTable1 = new JTable(0, 4);



    public String[] getAllCountries() {
        String[] countries = {"CPH","CDG","BCN","FCO","MAD","IST","LHR","AMS","FRA"};
        return countries;
    }

    public String [] getAllCountriesTo(){
        String[] countries = {"CPH","CDG","BCN","FCO","MAD","IST","LHR","AMS","FRA"};
        return countries;
    }

    public String [] getChoice(){
        String[] choice={"Economy ","Premium","Business","First"};
        return  choice;
    }

    uiMainForm(){
        setMainLayoutManager();
        setMainLocationAndSize();
        addMainComponentsToContainer();
    }
    public void setMainLayoutManager(){container.setLayout(null);}
    public void setMainLocationAndSize(){
        header.setBounds(450,10,420,120);
        header.setFont(header.getFont().deriveFont(68.f));

        fromLabel.setBounds(450,150,100,30);
        fromLabel.setFont((fromLabel.getFont().deriveFont(16.f)));

        toLabel.setBounds(630,150,100,30);
        toLabel.setFont(toLabel.getFont().deriveFont(16.f));

        classLabel.setBounds(20,250,100,30);
        classLabel.setFont(classLabel.getFont().deriveFont(16.f));

        travLabel.setBounds(20,300,150,30);
        travLabel.setFont(travLabel.getFont().deriveFont(16.f));

        depLabel.setBounds(20,350,150,30);
        depLabel.setFont(depLabel.getFont().deriveFont(16.f));

        adultLabel.setBounds(20,400,100,30);
        adultLabel.setFont(adultLabel.getFont().deriveFont(16.f));

        childLabel.setBounds(20,450,100,30);
        childLabel.setFont(childLabel.getFont().deriveFont(16.f));

        sbm_btn.setBounds(560,390, 150, 50);
        sbm_btn.setFont(sbm_btn.getFont().deriveFont(16.f));

        boxFrom.setBounds(510,157,100,20);

        boxTo.setBounds(670,157,100,20);

        combo1.setBounds(150,257,100,20);

        datePicker.setBounds(150,305,120,40);

        datePicker2.setBounds(150, 355,120,40);

        spinner.setBounds(150,400,35,30);

        spinner2.setBounds(150,450,35,30);

        serch_btn.setBounds(620,200,150,50);

        jTable1.setBounds(550, 290,300,80);

        airports.setBounds(780,100,300,180);


    }
    public void addMainComponentsToContainer(){
        container.add(header);
        container.add(fromLabel);
        container.add(toLabel);
        container.add(classLabel);
        container.add(travLabel);
        container.add(depLabel);
        container.add(adultLabel);
        container.add(childLabel);
        container.add(sbm_btn);
        container.add(boxFrom);
        container.add(boxTo);
        container.add(combo1);
        container.add(datePicker);
        container.add(datePicker2);
        container.add(spinner);
        container.add(spinner2);
        container.add(serch_btn);
        container.add(jTable1);
        container.add(airports);

    }
}
//-------------------------M A I N  F O R M -------------------------//

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
        frame.setDefaultCloseOperation(WindowConstants.HIDE_ON_CLOSE);
        //-------------------L O G I N  F O R M-------------------//
        uiMainForm mainFrame = new uiMainForm();
        mainFrame.setVisible(false);
        mainFrame.setResizable(false);
        mainFrame.setBounds(10, 10, 1100, 620 );
        ListSelectionModel cellSelectionModel = mainFrame.jTable1.getSelectionModel();
        cellSelectionModel.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        mainFrame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        //-------------------------------------------------------//
        //-------------------R E G I S T E R  F O R M-------------------//
        uiRegisterForm regFrame = new uiRegisterForm();
        regFrame.setTitle("Register");
        regFrame.setVisible(false);
        regFrame.setBounds(10,10,450,380);
        regFrame.setResizable(false);
        regFrame.setDefaultCloseOperation(WindowConstants.HIDE_ON_CLOSE);

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
                    String SQL = "SELECT * FROM customer WHERE email ='"+frame.usernameTextField.getText()+"'AND password = '"+frame.passwordField.getText()+"'";
                    ResultSet rs = stmt.executeQuery(SQL);
                    if(rs.next()){
                        mainFrame.setVisible(true);
                        frame.setVisible(false);
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

        mainFrame.serch_btn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String[] column= {"From","To","IATA","price"};
                DefaultTableModel tableModel = new DefaultTableModel(column,0);

                try{
                    String selectedFromValue =
                            mainFrame.boxFrom.getSelectedItem().toString();

                    String selectedToValue =
                            mainFrame.boxTo.getSelectedItem().toString();

                    Connection flightConn = DriverManager.getConnection(dbConnection.URL,dbConnection.USER,dbConnection.PASSWORD);
                    PreparedStatement ps = flightConn.prepareStatement("SELECT fromAirport,toAirport,IATAcode,price FROM flights WHERE fromAirport ='"+selectedFromValue+"'AND toAirport = '"+selectedToValue+"'");
                    ResultSet rs = ps.executeQuery();

                    while(rs.next()){

                        String from = rs.getString("fromAirport");
                        String to = rs.getString("toAirport");
                        String iata = rs.getString("IATAcode");
                        String price = rs.getString("price");

                        String data[] = {from, to, iata, price};
                        tableModel.addRow(column);
                        tableModel.addRow(data);
                        mainFrame.jTable1.setModel(tableModel);

                    }


                }catch (Exception exe){
                    System.out.println("Connection failed!");

                }
            }
        });
        mainFrame.sbm_btn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(null,"Ticket Booked!","Message",JOptionPane.INFORMATION_MESSAGE);

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