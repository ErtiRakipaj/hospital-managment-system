package org.example.hospitalmanagmentsystem;

import javax.swing.*;
import javax.swing.border.BevelBorder;
import javax.swing.border.EtchedBorder;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.sql.*;

public class MenuPage {
    JTabbedPane tabbedPane;
    JPanel mainbodypanel, billdisplaypanel;
    int i = 1;

    JTextArea billtextarea;
    JLabel totaldisplaylabel;
    JTextField patient_name_label;

    // JLabel patient_name;


    DefaultTableModel billtablemodel;
    JTable billtable;
    JScrollPane billdisplayscroll;


    String name;
    String address;
    String phone;
    String age;
    String sex;
    String illness;

    int billamountint;
    double totalsum1=0;

    public MenuPage()
    {
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();


        //create menupageframe JFrame
        final JFrame menupageframe = new JFrame("Menu Page");
        menupageframe.setExtendedState(JFrame.MAXIMIZED_BOTH);
        menupageframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        menupageframe.setVisible(true);
        menupageframe.setLayout(null);


        // CREATE HEADERPANEL JPANEL
        JPanel headerpanel = new JPanel();
        headerpanel.setLayout(null);
        headerpanel.setBounds(10,10,screenSize.width-20,100);
        //headerpanel.setBackground(Color.cyan);
        headerpanel.setBorder(new BevelBorder(BevelBorder.RAISED));

        // CREATE HEADERPANELSH JPANEL
        JPanel headerpanelsh = new JPanel();
        headerpanelsh.setLayout(null);
        headerpanelsh.setBounds(16,16,screenSize.width-20,100);
        headerpanelsh.setBackground(new Color(200, 200, 200));

        // CREATE HEADING JLABEL
        JLabel heading = new JLabel("Some Random Hospital");
        Font font = new Font("Garamond", Font.BOLD, 35);
        heading.setFont(font);
        heading.setForeground(new Color(0, 255, 226));
        heading.setBounds(screenSize.width-700,30,700,45);

        JLabel heading1 = new JLabel("Some Random Hospital");
        Font font1 = new Font("Garamond", Font.BOLD, 35);
        heading1.setFont(font1);
        heading1.setForeground(new Color(0, 126, 112));
        heading1.setBounds(screenSize.width-697,33,700,45);


        // LOGO
        ImageIcon image = new ImageIcon();
        JLabel label = new JLabel("", image, JLabel.CENTER);
        JPanel panel = new JPanel(new BorderLayout());
        panel.add( label, BorderLayout.CENTER );
        panel.setBounds(50,5,100,90);


        //add headerpanel
        menupageframe.add(headerpanel);
        menupageframe.add(headerpanelsh);
        headerpanel.add(heading);
        headerpanel.add(heading1);
        headerpanel.add(panel);


        //FOOTER JPANEL
        JButton home = new JButton("Logout");
        home.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent ae)
            {
                menupageframe.dispose();
                new HMSApp();
            }
        });
        home.setBounds((screenSize.width/2)-140,650,100,30);
        menupageframe.add(home);


        //create mainbodypanel JPanel
        mainbodypanel = new JPanel();
        mainbodypanel.setLayout(null);
        mainbodypanel.setBounds(5,110,screenSize.width-10,screenSize.height-(screenSize.height/4));
        mainbodypanel.setBackground(new Color(255,255,255,255));


        //create Jtabbedpane
        JTabbedPane tabpane = new JTabbedPane();
        tabpane.setBounds(5,115,screenSize.width-10,screenSize.height-(screenSize.height/4));
        menupageframe.add(tabpane);

        // OUTPATIENT start
        JPanel panel1 = new JPanel();
        //panel1.setBackground(Color.red);
        panel1.setOpaque(true);
        panel1.setBounds(5,110,screenSize.width-10,screenSize.height-(screenSize.height/4));
        panel1.setLayout(null);

        // FORM start
        JPanel outform = new JPanel();
        outform.setLayout(null);
        outform.setBounds(410,25,450,480);
        outform.setBorder(new EtchedBorder(EtchedBorder.RAISED));

        JLabel outlabel = new JLabel("Enter Details of Our Patient");
        outlabel.setBounds(140,20,300,40);

        final JTextField outname = new JTextField();
        outname.setText("Enter Name");
        outname.addFocusListener(new FocusListener() {
            @Override
            public void focusGained(FocusEvent e) {

                if(outname.getText().equals("Enter Name")) {
                    outname.setText("");
                }
            }

            @Override
            public void focusLost(FocusEvent e) {
                if (outname.getText().equals("")) {
                    outname.setText("Enter Name");
                }
            }
        });
        outname.setBounds(80,70,300,40);

        final JTextField outaddress = new JTextField();
        outaddress.setText("Enter Address");
        outaddress.addFocusListener(new FocusListener() {
            @Override
            public void focusGained(FocusEvent e) {

                if(outaddress.getText().equals("Enter Address")) {
                    outaddress.setText("");
                }
            }

            @Override
            public void focusLost(FocusEvent e) {
                if (outaddress.getText().equals("")) {
                    outaddress.setText("Enter Address");
                }
            }
        });
        outaddress.setBounds(80,120,300,40);

        final JTextField outnumber = new JTextField();
        outnumber.setText("Enter Ph no");
        outnumber.addFocusListener(new FocusListener() {
            @Override
            public void focusGained(FocusEvent e) {
                if (outnumber.getText().equals("Enter Ph no")) {
                    outnumber.setText("");
                }
            }

            @Override
            public void focusLost(FocusEvent e) {
                if (outnumber.getText().equals("")) {
                    outnumber.setText("Enter Ph no");
                }
            }
        });
        outnumber.setBounds(80,170,300,40);

        final JTextField outage = new JTextField();
        outage.setText("Enter Age");
        outage.addFocusListener(new FocusListener() {
            @Override
            public void focusGained(FocusEvent e) {
                if (outage.getText().equals("Enter Age")) {
                    outage.setText("");
                }
            }

            @Override
            public void focusLost(FocusEvent e) {
                if (outage.getText().equals("")) {
                    outage.setText("Enter Age");
                }
            }
        });

        outage.setBounds(80,220,300,40);

        final JTextField outsex = new JTextField();
        outsex.setText("Enter Patient's Sex");
        outsex.addFocusListener(new FocusListener() {
            @Override
            public void focusGained(FocusEvent e) {
                if (outsex.getText().equals("Enter Patient's Sex")) {
                    outsex.setText("");
                }
            }

            @Override
            public void focusLost(FocusEvent e) {
                if (outsex.getText().equals("")) {
                    outsex.setText("Enter Patient's Sex");
                }
            }
        });
        outsex.setBounds(80,270,300,40);

        final JTextField outillness = new JTextField();

        outillness.setText("Enter Illness");

        outillness.addFocusListener(new FocusListener() {
            @Override
            public void focusGained(FocusEvent e) {
                if (outillness.getText().equals("Enter Illness")) {
                    outillness.setText("");
                }
            }

            @Override
            public void focusLost(FocusEvent e) {
                if (outillness.getText().equals("")) {
                    outillness.setText("Enter Illness");
                }
            }
        });
        outillness.setBounds(80,320,300,40);

        JButton outbutton = new JButton("Submit");
        outbutton.setBounds(100,400,250,40);

        outform.add(outlabel);
        outform.add(outname);
        outform.add(outname);
        outform.add(outaddress);
        outform.add(outnumber);
        outform.add(outage);
        outform.add(outsex);
        outform.add(outillness);
        outform.add(outbutton);

        panel1.add(outform);
        // FORM end

        outbutton.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent ae)
            {
                PreparedStatement pstmt = null;
                PreparedStatement billpstmt = null;
                try {
                    //    Connection conn=DriverManager.getConnection(
                    //              "jdbc:ucanaccess://C:\\Users\\diabolicfeak\\Documents\\NetBeansProjects\\hms\\src\\Database\\Hospital.accdb");
                    //Connection conn = DriverManager.getConnection("jdbc:odbc:hospital");
                    Connection conn = DriverManager.getConnection(
                            "jdbc:mysql://localhost:3306/hms",
                            "root",
                            "password"
                    );

                    String query = "insert into patients(name, address, phone, age, sex, illness) values(?, ?, ?, ?, ?, ?)";


                    // FOR BILLING TABLE start
                    Statement s = conn.createStatement();
                    ResultSet r = s.executeQuery("SELECT COUNT(*) AS rowcount FROM patients");
                    r.next();
                    int count = r.getInt("rowcount");
                    count= count+1;
                    String billquery = "CREATE TABLE patient_"+count+" " +
                            "(id int(6) UNSIGNED AUTO_INCREMENT PRIMARY KEY, " +
                            " bill_item VARCHAR(255), " +
                            " billamount VARCHAR(255))";
                    billpstmt = conn.prepareStatement(billquery);
                    billpstmt.executeUpdate();
                    System.out.println("Inserted into patient_id" );
                    // FOR BILLING TABLE end


                    pstmt = conn.prepareStatement(query);
                    pstmt.setString(1, outname.getText());
                    pstmt.setString(2, outaddress.getText());
                    pstmt.setString(3, outnumber.getText());
                    pstmt.setInt(4, Integer.parseInt(outage.getText()));
                    pstmt.setString(5, outsex.getText());
                    pstmt.setString(6, outillness.getText());
                    pstmt.executeUpdate(); // execute insert statement
                    JOptionPane.showMessageDialog(null, "Successfully entered details");
                    new MenuPage();
                    menupageframe.setVisible(false);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });

        // OUTPATIENT end

        // PATIENT DB START
        JPanel panel2 = new JPanel();
        panel2.setOpaque(true);
        //panel2.setBackground(Color.green);
        panel2.setBounds(5,110,screenSize.width-10,screenSize.height-(screenSize.height/4));
        panel2.setLayout(null);

        JButton editpatient = new JButton("Edit Records");
        editpatient.setBounds(550,15,150,40);
        editpatient.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent ae)
            {
                menupageframe.setVisible(false);
                new EditPatient();
            }
        });

        i=1;
        DefaultTableModel patientmodel = new DefaultTableModel();
        patientmodel.addColumn("id");
        patientmodel.addColumn("Name");
        patientmodel.addColumn("Address");
        patientmodel.addColumn("Phone Number");
        patientmodel.addColumn("Age");
        patientmodel.addColumn("Sex");
        patientmodel.addColumn("Illness");

        try{
            //  Connection conn=DriverManager.getConnection(
            //      "jdbc:ucanaccess://C:\\Users\\diabolicfeak\\Documents\\NetBeansProjects\\hms\\src\\Database\\Hospital.accdb");
            Connection conn = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/hms",
                    "root",
                    "password"
            );
//			Connection conn = DriverManager.getConnection("jdbc:odbc:hospital");
            PreparedStatement pst = conn.prepareStatement("Select * from patients");
            ResultSet rs = pst.executeQuery();
            // Statement s = conn.createStatement();
            // ResultSet r = s.executeQuery("SELECT COUNT(*) AS rowcount FROM Patients");
            // r.next();
            // int count = r.getInt("rowcount");
            // System.out.println(count);
            // JButton[] buttons = new JButton[10];
            while(rs.next())
            {

                int id = rs.getInt("id");
                String name = rs.getString("name");
                String address = rs.getString("address");
                String phone = rs.getString("phone");
                int age = rs.getInt("age");
                String sex = rs.getString("sex");
                String illness = rs.getString("illness");
                patientmodel.addRow(new Object[]{id, name, address, phone, age, sex, illness});
                i++;



            }
        }
        catch(Exception e){
            e.printStackTrace();
        }
        JTable patienttable = new JTable(patientmodel);
        JScrollPane patientpane = new JScrollPane(patienttable);
        patientpane.setBounds(10,70,1240,420);
        panel2.add(editpatient);
        panel2.add(patientpane);
        panel2.setVisible(true);
        // PATIENT DB END



        // DOCOTORS DB start
        JPanel panel3 = new JPanel();
        panel3.setOpaque(true);
        panel3.setLayout(null);
        //panel3.setBackground(Color.blue);
        panel3.setBounds(5,110,screenSize.width-10,screenSize.height-(screenSize.height/4));


        JButton editdoctor = new JButton("Edit Records");
        editdoctor.setBounds(550,15,150,40);
        editdoctor.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent ae)
            {
                menupageframe.setVisible(false);
                new EditDoctor();
            }
        });


        DefaultTableModel doctormodel = new DefaultTableModel();
        doctormodel.addColumn("id");
        doctormodel.addColumn("Name");
        doctormodel.addColumn("Specialisation");
        doctormodel.addColumn("Address");
        doctormodel.addColumn("Phone Number");

        try{
            //  Connection conn=DriverManager.getConnection(
            //      "jdbc:ucanaccess://C:\\Users\\diabolicfeak\\Documents\\NetBeansProjects\\hms\\src\\Database\\Hospital.accdb");
            Connection conn = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/hms",
                    "root",
                    "password"
            );
            //Connection conn = DriverManager.getConnection("jdbc:odbc:hospital");
            PreparedStatement pst = conn.prepareStatement("select * from doctors");
            ResultSet rs = pst.executeQuery();
            while(rs.next())
            {
                String id = rs.getString("id");
                String name = rs.getString("docname");
                String specialisation = rs.getString("specilalisation");
                String address = rs.getString("address");
                String phone_number = rs.getString("phone_number");
                doctormodel.addRow(new Object[]{id, name, specialisation, address, phone_number});

            }
        }
        catch(Exception e){
            e.printStackTrace();
        }
        JTable doctortable = new JTable(doctormodel);
        JScrollPane doctorpane = new JScrollPane(doctortable);
        doctorpane.setBounds(10,70,1240,420);
        panel3.add(editdoctor);
        panel3.add(doctorpane);
        panel3.setVisible(true);

        // DOCOTORS DB end




        //BILL PAYMENT START
        final JPanel panel4 = new JPanel();
        panel4.setLayout(null);
        panel4.setOpaque(true);
//        panel4.setBackground(Color.yellow);
        panel4.setBounds(5,110,screenSize.width-10,screenSize.height-(screenSize.height/4));


        // ID PANEL start
        JPanel billidpanel = new JPanel();
        billidpanel.setLayout(null);
        billidpanel.setBounds(450,10,500,50);

        final JTextField billidfield = new JTextField();
        billidfield.setText("Enter id");
        billidfield.addFocusListener(new FocusListener() {
            @Override
            public void focusGained(FocusEvent e) {
                if (billidfield.getText().equals("Enter id")) {
                    billidfield.setText("");
                }
            }

            @Override
            public void focusLost(FocusEvent e) {
                if (billidfield.getText().equals("")) {
                    billidfield.setText("Enter id");
                }
            }
        });
        JButton billidbutton = new JButton("Show");
        billidfield.setBounds(5,5,200,30);
        billidbutton.setBounds(300,5,200,30);

        billidpanel.add(billidfield);
        billidpanel.add(billidbutton);

        // ID PANEL end


        // BILL ENTRY PANEL start

        final JTextField bill_item = new JTextField();
        bill_item.setText("Bill Item");
        bill_item.addFocusListener(new FocusListener() {
            @Override
            public void focusGained(FocusEvent e) {
                if (bill_item.getText().equals("Bill Item")) {
                    bill_item.setText("");
                }
            }

            @Override
            public void focusLost(FocusEvent e) {
                if (bill_item.getText().equals("")){
                    bill_item.setText("Bill Item");
                }
            }
        });
        bill_item.setBounds(140,130,300,30);

        final JTextField bill_amt = new JTextField();
        bill_amt.setText("Bill Amount");
        bill_amt.addFocusListener(new FocusListener() {
            @Override
            public void focusGained(FocusEvent e) {
                if (bill_amt.getText().equals("Bill Amount")) {
                    bill_amt.setText("");
                }
            }

            @Override
            public void focusLost(FocusEvent e) {
                if (bill_amt.getText().equals("")) {
                    bill_amt.setText("Bill Amount");
                }
            }
        });
        bill_amt.setBounds(140,200,300,30);

        JButton bill_submit = new JButton("Add");
        bill_submit.setBounds(240,260,75,30);

        JButton total_amt = new JButton("Show Total Amount");
        total_amt.setBounds(180,320,230,30);

        final JPanel billentrypanel = new JPanel();
        billentrypanel.setLayout(null);
        billentrypanel.setBounds(20,100,600,400);
        billentrypanel.setBorder(new EtchedBorder(EtchedBorder.RAISED));


        bill_submit.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent ae)
            {
                PreparedStatement pstmt = null;
                try
                {
                    int a = Integer.parseInt(billidfield.getText());
                    //    Connection conn=DriverManager.getConnection(
                    //              "jdbc:ucanaccess://C:\\Users\\diabolicfeak\\Documents\\NetBeansProjects\\hms\\src\\Database\\Hospital.accdb");
                    Connection conn = DriverManager.getConnection(
                            "jdbc:mysql://localhost:3306/hms",
                            "root",
                            "password"
                    );
                    //Connection conn = DriverManager.getConnection("jdbc:odbc:hospital");
                    String query = "insert into patient_"+a+"(bill_item, billamount) values(?, ?)";

                    pstmt = conn.prepareStatement(query);
                    pstmt.setString(1, bill_item.getText());
                    pstmt.setString(2, bill_amt.getText());

                    pstmt.executeUpdate(); // execute insert statement

                } catch (Exception e)
                {
                    e.printStackTrace();
                }
            }
        });

        // BILL ENTRY PANEL end





        // BILL DISPLAY PANEL start




        billidbutton.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent ae)
            {
                try{
                    int a = Integer.parseInt(billidfield.getText());
                    // Connection conn1=DriverManager.getConnection(
                    // "jdbc:ucanaccess://C:\\Users\\diabolicfeak\\Documents\\NetBeansProjects\\hms\\src\\Database\\Hospital.accdb");
                    Connection conn = DriverManager.getConnection(
                            "jdbc:mysql://localhost:3306/hms",
                            "root",
                            "password"
                    );
                    //Connection conn1=DriverManager.getConnection("jdbc:odbc:hospital");
                    // FOR PATIENT NAME start
                    Statement s = conn.createStatement();
                    ResultSet r = s.executeQuery("SELECT * FROM patients WHERE id="+a+"");
                    r.next();
                    String patient_name = r.getString("name");
                    int patient_age = r.getInt("age");
                    String patient_sex = r.getString("sex");



                    patient_name_label = new JTextField("Patient Name: "+patient_name);
                    billentrypanel.add(patient_name_label);
                    patient_name_label.setBounds(20,20,150,30);
                    patient_name_label = new JTextField("Patient Age: "+patient_age);
                    billentrypanel.add(patient_name_label);
                    patient_name_label.setBounds(220,20,150,30);
                    patient_name_label = new JTextField("Patient Sex: "+patient_sex);
                    billentrypanel.add(patient_name_label);
                    patient_name_label.setBounds(420,20,150,30);

                    // FOR PATIENT NAME END
                }
                catch(Exception e)
                {
                    e.printStackTrace();
                }


                // BILL TABLE start
                billtablemodel = new DefaultTableModel();
                billtablemodel.addColumn("Bill Item");
                billtablemodel.addColumn("Bill Amount");

                PreparedStatement pstmt = null;
                try
                {
                    // Connection conn=DriverManager.getConnection(
                    //           "jdbc:ucanaccess://C:\\Users\\diabolicfeak\\Documents\\NetBeansProjects\\hms\\src\\Database\\Hospital.accdb");
                    Connection conn = DriverManager.getConnection(
                            "jdbc:mysql://localhost:3306/hms",
                            "root",
                            "password"
                    );
                    //Connection conn=DriverManager.getConnection("jdbc:odbc:hospital");
                    int a = Integer.parseInt(billidfield.getText());

                    PreparedStatement pst = conn.prepareStatement("Select * from patient_"+a+"");
                    ResultSet rs = pst.executeQuery();

                    while(rs.next())
                    {

                        String billitem = rs.getString("bill_item");
                        String billamount = rs.getString("billamount");
                        billtablemodel.addRow(new Object[]{billitem, billamount});

                    }
                    billtable = new JTable(billtablemodel);
//                    billtablemodel.fireTableDataChanged();
                    billdisplayscroll = new JScrollPane(billtable);
                    billdisplayscroll.setBounds(20,20,470,280);
                    billdisplaypanel.add(billdisplayscroll);
                }
                catch(Exception e)
                {
                    e.printStackTrace();
                }

            }
        });



        total_amt.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent ae)
            {
                billtablemodel.fireTableDataChanged();
                billtable.repaint();



                try
                {
                    // Connection conn=DriverManager.getConnection(
                    //           "jdbc:ucanaccess://C:\\Users\\diabolicfeak\\Documents\\NetBeansProjects\\hms\\src\\Database\\Hospital.accdb");
                    Connection conn = DriverManager.getConnection(
                            "jdbc:mysql://localhost:3306/hms",
                            "root",
                            "password"
                    );
                    //Connection conn=DriverManager.getConnection("jdbc:odbc:hospital");
                    int a = Integer.parseInt(billidfield.getText());

                    Statement s = conn.createStatement();
                    System.out.println("long before");
                    ResultSet rs = s.executeQuery("SELECT * FROM patient_"+a+"");
                    System.out.println("bit before");

                    totalsum1 = 0;
                    int sum1 = 0;
//                    PreparedStatement pst = conn.prepareStatement("SELECT SUM(billamount) AS totaltt FROM patient_"+a+"");
//
//                    ResultSet rs = pst.executeQuery();

                    while(rs.next())
                    {

                        System.out.println("before");

                        String id = rs.getString("bill_item");
                        String name = rs.getString("billamount");
                        sum1 = Integer.parseInt(name);
                        totalsum1 = totalsum1 +sum1;
                    }

                }
                catch(Exception e)
                {
                    e.printStackTrace();
                }
                String total2 = String.valueOf(totalsum1);
                totaldisplaylabel = new JLabel();
                totaldisplaylabel.setText("");
                billdisplaypanel.add(totaldisplaylabel);
                totaldisplaylabel.setText("Amount to pay: "+total2);
//                 billdisplaypanel.add(totaldisplaylabel);
//                 totaldisplaylabel.setBounds(250,50,300,600);
//                 totaldisplaylabel.repaint();

                JTextField totaltext = new JTextField();
                totaltext.setText("Amount to pay: "+total2);
                billdisplaypanel.add(totaltext);
                totaltext.setBounds(150,300,200,30);
                System.out.println(total2);

            }
        });

        billdisplaypanel = new JPanel();
        billdisplaypanel.setLayout(null);
        //billdisplaypanel.setBackground(Color.red);
        panel4.add(billdisplaypanel);
        billdisplaypanel.setBounds(700,100,500,400);
        billdisplaypanel.setBorder(new EtchedBorder(EtchedBorder.RAISED));


        // BILL DISPLAY PANEL end

        billentrypanel.add(bill_item);
        billentrypanel.add(bill_amt);
        billentrypanel.add(total_amt);
        billentrypanel.add(bill_submit);



        panel4.add(billentrypanel);

        panel4.add(billidpanel);

        //BILL PAYMENT END


        //add panels to tabpane
        tabpane.setTabPlacement(SwingConstants.LEFT);


        // Create vertical labels to render tab titles
        tabpane.add(panel1,"<html>O<br>U<br>T<br>P<br>A<br>T<br>I<br>E<br>N<br>T</html>");
        tabpane.add(panel2,"<html>P<br>A<br>T<br>I<br>E<br>N<br>T<br> <br>D<br>B</html>");
        tabpane.add(panel3,"<html>D<br>O<br>C<br>T<br>O<br>R<br> <br>D<br>B</html>");
        tabpane.add(panel4,"<html>B<br>I<br>L<brl<br>");

//        menupageframe.pack();

        //add mainbodypanel
        menupageframe.add(mainbodypanel);
    }





    public static void main(String a[])
    {
        SwingUtilities.invokeLater(new Runnable()
        {
            public void run()
            {
                new MenuPage();
            }
        });
    }

}
