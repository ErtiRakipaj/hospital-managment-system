package org.example.hospitalmanagmentsystem;

import javax.swing.*;
import javax.swing.border.BevelBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class EditDoctor {

    String name;
    String address;
    String phone;
    String specialisation;

    JFrame editframe;
    JPanel formpanel, editpane, menubuttonpane;
    JButton menubutton;


    public EditDoctor()
    {
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();


        JFrame editframe = new JFrame("Edit");
        editframe.setExtendedState(JFrame.MAXIMIZED_BOTH);
        editframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        editframe.setLayout(null);


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
        heading.setBounds(screenSize.width-700,40,700,45);

        JLabel heading1 = new JLabel("Some Random Hospital");
        Font font1 = new Font("Garamond", Font.BOLD, 35);
        heading1.setFont(font1);
        heading1.setForeground(new Color(0, 126, 112));
        heading1.setBounds(screenSize.width-697,43,700,45);



        ImageIcon image = new ImageIcon();
        JLabel label = new JLabel("", image, JLabel.CENTER);
        JPanel panel = new JPanel(new BorderLayout());
        panel.add( label, BorderLayout.CENTER );
        panel.setBounds(50,15,100,90);

        JButton home = new JButton("Home");
        home.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent ae) {
                editframe.dispose();
                //editframe.setVisible(true);
                new MenuPage();
            }
        });

        home.setBounds((screenSize.width / 2) - 140, 650, 100, 30);
        editframe.add(home);

        //FOOTER JPANEL

        editpane = new JPanel();
        editpane.setLayout(null);
        editpane.setBounds(500,120,400,200);

//        menubuttonpane = new JPanel();
//        menubuttonpane.setLayout(null);
//        menubuttonpane.setBounds(510,120,400,50);

        final JTextField idfield = new JTextField();
        idfield.setText("Enter ID");
        idfield.addFocusListener(new FocusListener() {
            @Override
            public void focusGained(FocusEvent e) {
                if (idfield.getText().equals("Enter ID")) {
                    idfield.setText("");
                }
            }

            @Override
            public void focusLost(FocusEvent e) {
                if (idfield.getText().equals("")) {
                    idfield.setText("Enter ID");
                }
            }
        });
        idfield.setBounds(10,10,150,30);
        JButton editbutton = new JButton("Edit");
        editbutton.setBounds(170,10,150,30);

//        menubutton = new JButton("View ");
//        menubutton.setBounds(120,10,150,30);
//        menubuttonpane.add(menubutton);
//        menubuttonpane.setVisible(false);

        editpane.add(idfield);
        editpane.add(editbutton);

        editframe.add(editpane);
        //editframe.add(menubuttonpane);
        editframe.add(panel);
        editframe.add(heading);
        editframe.add(heading1);
        editframe.add(headerpanel);
        editframe.add(headerpanelsh);




        formpanel = new JPanel();
        formpanel.setBounds(350,150,600,900);
        formpanel.setLayout(null);


        editbutton.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent ae)
            {
                PreparedStatement pstmt = null;
                try {
                    //    Connection conn=DriverManager.getConnection(
                    //              "jdbc:ucanaccess://C:\\Users\\diabolicfeak\\Documents\\NetBeansProjects\\hms\\src\\Database\\Hospital.accdb");
                    Connection conn = DriverManager.getConnection(
                            "jdbc:mysql://localhost:3306/hms",
                            "root",
                            "password"
                    );

//		Connection conn=DriverManager.getConnection("jdbc:odbc:hospital");
                    int a = Integer.parseInt(idfield.getText());
                    String query = "select * FROM doctors WHERE id = ?";
                    pstmt = conn.prepareStatement(query); // create a statement
                    pstmt.setInt(1, a); // set input parameter 1
                    ResultSet rs = pstmt.executeQuery(); // execute insert statement
                    rs.next();
                    name = rs.getString("docname");
                    specialisation = rs.getString("specilalisation");
                    address = rs.getString("address");
                    phone = rs.getString("phone_number");

                    editform(name, specialisation, address, phone, a);

                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });

        editframe.add(formpanel);

        editframe.setVisible(true);
    }

    public void editform(String name, String specialisation, String address, String phone, final int a)
    {
        // EDITFORM


        final JTextField namefield = new JTextField(name);
        namefield.setBounds(200,60,280,40);
        formpanel.add(namefield);

        final JTextField specialisationfield = new JTextField(specialisation);
        specialisationfield.setBounds(200,110,280,40);
        formpanel.add(specialisationfield);

        final JTextField addressfield = new JTextField(address);
        addressfield.setBounds(200,160,280,40);
        formpanel.add(addressfield);

        final JTextField phonefield = new JTextField(phone);
        phonefield.setBounds(200,210,280,40);
        formpanel.add(phonefield);

        JButton formeditbutton = new JButton("Submit");
        formeditbutton.setBounds(225,380,230,40);
        formeditbutton.setVisible(true);
        formpanel.add(formeditbutton);


        editpane.setVisible(false);
        //menubuttonpane.setVisible(true);
        formpanel.repaint();


        // SECOND ONCLICK
        formeditbutton.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent ae)
            {
                PreparedStatement pstmt = null;
                try {
                    //   Connection conn=DriverManager.getConnection(
                    //             "jdbc:ucanaccess://C:\\Users\\diabolicfeak\\Documents\\NetBeansProjects\\hms\\src\\Database\\Hospital.accdb");
                    Connection conn = DriverManager.getConnection(
                            "jdbc:mysql://localhost:3306/hms",
                            "root",
                            "password"
                    );

                    String query = "UPDATE doctors SET docname=?, specilalisation=?, address=?, phone_number=? WHERE id=?";

                    pstmt = conn.prepareStatement(query); // create a statement
                    pstmt.setString(1, namefield.getText()); // set input parameter 1
                    pstmt.setString(2, specialisationfield.getText()); // set input parameter 2
                    pstmt.setString(3, addressfield.getText()); // set input parameter 3
                    pstmt.setString(4, phonefield.getText());
                    pstmt.setInt(5, a);
                    pstmt.executeUpdate(); // execute insert statement
                    JOptionPane.showMessageDialog(null, "Successfully entered details");


                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });



    }

    public static void main(String ar[])
    {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new EditDoctor();
            }});

    }
}
