import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.sql.*;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
class applicationf extends JFrame implements KeyListener, ActionListener {
    DateFormat df = new SimpleDateFormat("dd/MM/yyyy");
    String x = "";
    String extension = "";
    String img1, img2, img3;
    String applicantid = "AI0000";
    String formno = "FN00";
    JLabel l, lp, l1, l2, l3, l4, l5, l6, l7, l8, l9, l10, l11, l12, l13, l14, l15, l16, l17, l18, l19, l20, l21, l22,
            l23;
    JTextField ta, ta1, ta2, t1, t2, t3, t4, t5, t6, t7, t8, t9, t10, t11, t12, t13, t14, t15, t16;
    JComboBox cb1, cb2;
    JRadioButton rd1, rd2, rd3;
    JCheckBox ch1, ch2, ch3;
    ButtonGroup group;
    JButton b1,b2,b3,up1,up2,up3;
    JPanel panel1 = new JPanel();
    JPanel panel2 = new JPanel();
    
    applicationf() {
        setTitle("Apply Learner's Licence");
        setSize(1350, 730);
        setResizable(false);
        setLocationRelativeTo(null);
        setLayout(null);
        setIconImage(Toolkit.getDefaultToolkit().getImage("hicon.png"));
        panel1.setLayout(null);
        panel2.setLayout(null);
        panel1.setBackground(Color.blue);
        panel2.setBackground(Color.white);
        try {
            UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel");
        } catch (Exception e) {
        }

        Date date = new Date();

        // l=new JLabel("Application for Learner's Licence");
        l = new JLabel("APPLICATION FOR LEARNER'S LICENCE");
        l.setForeground(Color.white);
        l.setFont(new Font("Sans-Serif", Font.BOLD, 20));

        l1 = new JLabel("Date :");
        l1.setFont(new Font("Bookman Old Style", Font.PLAIN, 16));
        l3 = new JLabel("Applicant Id :");
        l3.setFont(new Font("Bookman Old Style", Font.PLAIN, 16));
        l2 = new JLabel("Form No.");
        l2.setBorder(BorderFactory.createLineBorder(Color.black));
        l2.setFont(new Font("Bookman Old Style", Font.PLAIN, 16));
        l4 = new JLabel("Name :");
        l4.setFont(new Font("Bookman Old Style", Font.PLAIN, 16));
        l5 = new JLabel("Sex :");
        l5.setFont(new Font("Bookman Old Style", Font.PLAIN, 16));
        l6 = new JLabel("Relation :");
        l6.setFont(new Font("Bookman Old Style", Font.PLAIN, 16));
        l7 = new JLabel("Father/Husband Name :");
        l7.setFont(new Font("Bookman Old Style", Font.PLAIN, 16));
        l8 = new JLabel("Permanent Address :");
        l8.setFont(new Font("Bookman Old Style", Font.PLAIN, 16));
        l9 = new JLabel("Present Address/Official Address :");
        l9.setFont(new Font("Bookman Old Style", Font.PLAIN, 16));
        l10 = new JLabel("Village/Town :");
        l10.setFont(new Font("Bookman Old Style", Font.PLAIN, 16));
        l11 = new JLabel("District :");
        l11.setFont(new Font("Bookman Old Style", Font.PLAIN, 16));
        l12 = new JLabel("City :");
        l12.setFont(new Font("Bookman Old Style", Font.PLAIN, 16));
        l13 = new JLabel("Pin No. :");
        l13.setFont(new Font("Bookman Old Style", Font.PLAIN, 16));
        l14 = new JLabel("Mobile Number :");
        l14.setFont(new Font("Bookman Old Style", Font.PLAIN, 16));
        l15 = new JLabel("Addhar Number :");
        l15.setFont(new Font("Bookman Old Style", Font.PLAIN, 16));
        l16 = new JLabel("E-mail :");

        l16.setFont(new Font("Bookman Old Style", Font.PLAIN, 16));
        l17 = new JLabel("Documents- :");
        l17.setFont(new Font("Bookman Old Style", Font.PLAIN, 16));
        l18 = new JLabel("Address1 :");
        l18.setFont(new Font("Bookman Old Style", Font.PLAIN, 16));
        l19 = new JLabel("Address2 :");
        l19.setFont(new Font("Bookman Old Style", Font.PLAIN, 16));
        lp = new JLabel("Pincode :");
        lp.setFont(new Font("Bookman Old Style", Font.PLAIN, 16));
        l21 = new JLabel("Date of Birth(dd/mm/yyyy):");
        l21.setFont(new Font("Bookman Old Style", Font.PLAIN, 16));
        l22 = new JLabel("Blood Group :");
        l22.setFont(new Font("Bookman Old Style", Font.PLAIN, 16));
        l23 = new JLabel("Identification Marks :");
        l23.setFont(new Font("Bookman Old Style", Font.PLAIN, 16));

        t1 = new JTextField();
        t1.setText(df.format(date));
        t1.setFont(new Font("Bookman Old Style", Font.PLAIN, 14));
        t1.setEditable(false);
        ta = new JTextField();
        ta.setFont(new Font("Bookman Old Style", Font.PLAIN, 14));
        ta1 = new JTextField();
        ta1.setFont(new Font("Bookman Old Style", Font.PLAIN, 14));
        ta2 = new JTextField();
        ta2.setFont(new Font("Bookman Old Style", Font.PLAIN, 14));
        t2 = new JTextField();
        t2.setFont(new Font("Bookman Old Style", Font.PLAIN, 14));
        t2.setEditable(false);
        t3 = new JTextField();
        t3.setFont(new Font("Bookman Old Style", Font.PLAIN, 14));
        t3.setEditable(false);
        t4 = new JTextField();
        t4.setEditable(false);
        t4.setFont(new Font("Bookman Old Style", Font.PLAIN, 14));
        t5 = new JTextField();
        t5.setFont(new Font("Bookman Old Style", Font.PLAIN, 14));
        t6 = new JTextField();
        t6.setFont(new Font("Bookman Old Style", Font.PLAIN, 14));
        t7 = new JTextField();
        t7.setFont(new Font("Bookman Old Style", Font.PLAIN, 14));
        t8 = new JTextField();
        t8.setFont(new Font("Bookman Old Style", Font.PLAIN, 14));
        t8.setTransferHandler(null);
        t9 = new JTextField();
        t9.setFont(new Font("Bookman Old Style", Font.PLAIN, 14));
        t9.setTransferHandler(null);
        t10 = new JTextField();
        t10.setFont(new Font("Bookman Old Style", Font.PLAIN, 14));
        t10.setTransferHandler(null);
        t11 = new JTextField();
        t11.setFont(new Font("Bookman Old Style", Font.PLAIN, 14));
        t12 = new JTextField();
        t12.setFont(new Font("Bookman Old Style", Font.PLAIN, 14));
        t12.setTransferHandler(null);
        t13 = new JTextField();
        t13.setFont(new Font("Bookman Old Style", Font.PLAIN, 14));
        t14 = new JTextField();
        t14.setFont(new Font("Bookman Old Style", Font.PLAIN, 14));
        t14.setEditable(false);
        t15 = new JTextField();
        t15.setFont(new Font("Bookman Old Style", Font.PLAIN, 14));
        t16 = new JTextField();
        t16.setFont(new Font("Bookman Old Style", Font.PLAIN, 14));
        cb1 = new JComboBox();
        cb1.setFont(new Font("Bookman Old Style", Font.PLAIN, 14));
        cb1.addItem("--Select--");
        cb1.addItem("Male");
        cb1.addItem("Female");
        cb2 = new JComboBox();
        cb2.setFont(new Font("Bookman Old Style", Font.PLAIN, 14));
        cb2.addItem("--Select Blood Group--");
        cb2.addItem("O-");
        cb2.addItem("O+");
        cb2.addItem("A-");
        cb2.addItem("A+");
        cb2.addItem("B-");
        cb2.addItem("B+");
        cb2.addItem("AB-");
        cb2.addItem("AB+");
        ch1 = new JCheckBox("Photo Proof");
        ch2 = new JCheckBox("Address Proof");
        ch3 = new JCheckBox("Blood Group Proof");
        group = new ButtonGroup();
        rd1 = new JRadioButton("S/O");
        rd2 = new JRadioButton("D/O");
        rd3 = new JRadioButton("W/O");

        group.add(rd1);
        group.add(rd2);
        group.add(rd3);

        b1 = new JButton("Next");
        b2 = new JButton("Reset");
        b3 = new JButton("Cancel");
        b3.setEnabled(false);
        b1.setFont(new Font("Bookman Old Style", Font.PLAIN, 14));
        b2.setFont(new Font("Bookman Old Style", Font.PLAIN, 14));
        b3.setFont(new Font("Bookman Old Style", Font.PLAIN, 14));

        up1 = new JButton("Upload");
        up2 = new JButton("Upload");
        up3 = new JButton("Upload");

        panel1.setBounds(0, 0, 1400, 60);
        l.setBounds(480, 18, 400, 30);

        panel2.setBounds(0, 60, 1350, 560);
        l1.setBounds(30, 30, 150, 30);
        l2.setBounds(1160, 30, 150, 30);
        l3.setBounds(30, 70, 150, 30);
        l4.setBounds(30, 110, 150, 30);
        l5.setBounds(30, 150, 150, 30);
        l6.setBounds(30, 190, 150, 30);
        l7.setBounds(30, 230, 230, 30);
        l21.setBounds(26, 270, 230, 30);
        l22.setBounds(30, 310, 200, 30);
        l8.setBounds(30, 350, 200, 30);
        l10.setBounds(30, 390, 200, 30);
        l11.setBounds(30, 430, 200, 30);
        l12.setBounds(30, 470, 200, 30);
        l13.setBounds(30, 510, 200, 30);

        l23.setBounds(630, 30, 200, 30);
        l17.setBounds(630, 110, 200, 30);
        l9.setBounds(630, 230, 300, 30);
        l18.setBounds(630, 270, 200, 30);
        l19.setBounds(630, 310, 200, 30);
        lp.setBounds(630, 350, 200, 30);
        l16.setBounds(630, 390, 150, 30);
        l15.setBounds(630, 430, 200, 30);
        l14.setBounds(630, 470, 200, 30);

        t1.setBounds(250, 30, 300, 30);
        t2.setBounds(250, 70, 300, 30);
        t3.setBounds(250, 110, 300, 30);
        cb1.setBounds(250, 150, 300, 30);
        rd1.setBounds(250, 190, 50, 30);
        rd2.setBounds(310, 190, 50, 30);
        rd3.setBounds(370, 190, 50, 30);
        t4.setBounds(250, 230, 300, 30);
        t14.setBounds(250, 270, 300, 30);
        cb2.setBounds(250, 310, 300, 30);
        ta.setBounds(250, 350, 300, 30);
        t5.setBounds(250, 390, 300, 30);
        t6.setBounds(250, 430, 300, 30);
        t7.setBounds(250, 470, 300, 30);
        t8.setBounds(250, 510, 300, 30);

        t15.setBounds(830, 30, 300, 30);
        t16.setBounds(830, 70, 300, 30);
        ch1.setBounds(830, 110, 300, 30);
        up1.setBounds(1140, 110, 70, 30);
        ch2.setBounds(830, 150, 300, 30);
        up2.setBounds(1140, 150, 70, 30);
        ch3.setBounds(830, 190, 300, 30);
        up3.setBounds(1140, 190, 70, 30);
        ta1.setBounds(830, 270, 300, 30);
        ta2.setBounds(830, 310, 300, 30);
        t12.setBounds(830, 350, 300, 30);
        t11.setBounds(830, 390, 300, 30);
        t10.setBounds(830, 430, 300, 30);
        t9.setBounds(830, 470, 300, 30);

        b1.setBounds(790, 640, 100, 30);
        b2.setBounds(910, 640, 100, 30);
        b3.setBounds(1030, 640, 100, 30);

        panel1.add(l);
        panel2.add(l1);
        panel2.add(t1);
        panel2.add(l2);
        panel2.add(l3);
        panel2.add(t2);
        panel2.add(l4);
        panel2.add(t3);
        panel2.add(l5);
        panel2.add(cb1);
        panel2.add(l6);
        panel2.add(rd1);
        panel2.add(rd2);
        panel2.add(rd3);
        panel2.add(l7);
        panel2.add(t4);
        panel2.add(l21);
        panel2.add(t14);
        panel2.add(l22);
        panel2.add(cb2);
        panel2.add(l8);
        panel2.add(ta);
        panel2.add(l10);
        panel2.add(t5);
        panel2.add(l11);
        panel2.add(t6);
        panel2.add(l12);
        panel2.add(t7);
        panel2.add(l13);
        panel2.add(t8);
        panel2.add(l14);
        panel2.add(t9);
        panel2.add(l23);
        panel2.add(t15);
        panel2.add(t16);
        panel2.add(l17);
        panel2.add(ch1);
        panel2.add(ch2);
        panel2.add(ch3);
        panel2.add(up1);
        panel2.add(up2);
        panel2.add(up3);
        panel2.add(l9);
        panel2.add(l18);
        panel2.add(ta1);
        panel2.add(l19);
        panel2.add(ta2);
        panel2.add(lp);
        panel2.add(t12);
        panel2.add(l16);
        panel2.add(t11);
        panel2.add(l15);
        panel2.add(t10);

        add(b1);
        add(b2);
        add(b3);

        // JScrollBar sb=new JScrollBar(JScrollBar.VERTICAL,0,0,0,180);
        // JScrollPane sp=new
        // JScrollPane(JFrame,ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS,ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
        // sb.setBounds(1000,0,10,700);
        // add(sb);

        add(panel1);
        add(panel2);

        t2.addKeyListener(this);
        t2.addActionListener(this);
        t3.addActionListener(this);
        cb1.addActionListener(this);
        t4.addActionListener(this);
        t14.addActionListener(this);
        cb2.addActionListener(this);
        ta.addActionListener(this);

        t5.addActionListener(this);
        t6.addActionListener(this);
        t7.addActionListener(this);
        t8.addActionListener(this);
        t15.addActionListener(this);
        t16.addActionListener(this);
        ch1.addActionListener(this);
        ch2.addActionListener(this);
        ch3.addActionListener(this);
        ta1.addActionListener(this);
        ta2.addActionListener(this);
        ta2.addKeyListener(this);
        t12.addActionListener(this);
        t9.addActionListener(this);
        t10.addActionListener(this);
        t11.addActionListener(this);
        t10.addKeyListener(this);
        t11.addKeyListener(this);
        t3.addKeyListener(this);
        cb1.addKeyListener(this);
        t4.addKeyListener(this);
        t14.addKeyListener(this);
        cb2.addKeyListener(this);
        ta.addKeyListener(this);
        t5.addKeyListener(this);
        t6.addKeyListener(this);
        t7.addKeyListener(this);
        t8.addKeyListener(this);
        t15.addKeyListener(this);
        t16.addKeyListener(this);
        ch1.addKeyListener(this);
        ch2.addKeyListener(this);
        ch3.addKeyListener(this);
        ta1.addKeyListener(this);
        t12.addKeyListener(this);
        t9.addKeyListener(this);
        rd1.addActionListener(this);
        rd1.addKeyListener(this);
        rd2.addActionListener(this);
        rd2.addKeyListener(this);
        rd3.addActionListener(this);
        rd3.addKeyListener(this);
        up1.addActionListener(this);
        up1.addKeyListener(this);
        up2.addActionListener(this);
        up3.addKeyListener(this);
        up3.addActionListener(this);
        up2.addKeyListener(this);
        b1.addActionListener(this);
        b2.addActionListener(this);
        b3.addActionListener(this);
        b1.addKeyListener(this);
        b2.addKeyListener(this);
        b3.addKeyListener(this);

        t3.addKeyListener(new KeyAdapter() {
            public void keyTyped(KeyEvent e) {
                char keyChar = e.getKeyChar();
                if (Character.isLowerCase(keyChar)) {
                    e.setKeyChar(Character.toUpperCase(keyChar));
                }
            }
        });

        t14.addKeyListener(new KeyAdapter() {
            public void keyTyped(KeyEvent e) {
                char c = e.getKeyChar();

                if (!((c == KeyEvent.VK_ENTER))) {
                    e.consume();
                }
            }
        });

        /*
         * t3.addKeyListener(new KeyAdapter()
         * {
         * public void keyTyped(KeyEvent e)
         * {
         * char car=e.getKeyChar();
         * if((car=='a'))
         * {
         * e.consume();
         * }
         * }
         * });
         */
        t4.addKeyListener(new KeyAdapter() {
            public void keyTyped(KeyEvent e) {
                char keyChar = e.getKeyChar();
                if (Character.isLowerCase(keyChar)) {
                    e.setKeyChar(Character.toUpperCase(keyChar));
                }
            }
        });
        ta.addKeyListener(new KeyAdapter() {
            public void keyTyped(KeyEvent e) {
                char keyChar = e.getKeyChar();
                if (Character.isLowerCase(keyChar)) {
                    e.setKeyChar(Character.toUpperCase(keyChar));
                }
            }
        });
        t5.addKeyListener(new KeyAdapter() {
            public void keyTyped(KeyEvent e) {
                char keyChar = e.getKeyChar();
                if (Character.isLowerCase(keyChar)) {
                    e.setKeyChar(Character.toUpperCase(keyChar));
                }
            }
        });
        t6.addKeyListener(new KeyAdapter() {
            public void keyTyped(KeyEvent e) {
                char keyChar = e.getKeyChar();
                if (Character.isLowerCase(keyChar)) {
                    e.setKeyChar(Character.toUpperCase(keyChar));
                }
            }
        });
        t7.addKeyListener(new KeyAdapter() {
            public void keyTyped(KeyEvent e) {
                char keyChar = e.getKeyChar();
                if (Character.isLowerCase(keyChar)) {
                    e.setKeyChar(Character.toUpperCase(keyChar));
                }
            }
        });
        ta1.addKeyListener(new KeyAdapter() {
            public void keyTyped(KeyEvent e) {
                char keyChar = e.getKeyChar();
                if (Character.isLowerCase(keyChar)) {
                    e.setKeyChar(Character.toUpperCase(keyChar));
                }
            }
        });
        ta2.addKeyListener(new KeyAdapter() {
            public void keyTyped(KeyEvent e) {
                char keyChar = e.getKeyChar();
                if (Character.isLowerCase(keyChar)) {
                    e.setKeyChar(Character.toUpperCase(keyChar));
                }
            }
        });
        t15.addKeyListener(new KeyAdapter() {
            public void keyTyped(KeyEvent e) {
                char keyChar = e.getKeyChar();
                if (Character.isLowerCase(keyChar)) {
                    e.setKeyChar(Character.toUpperCase(keyChar));
                }
            }
        });
        t16.addKeyListener(new KeyAdapter() {
            public void keyTyped(KeyEvent e) {
                char keyChar = e.getKeyChar();
                if (Character.isLowerCase(keyChar)) {
                    e.setKeyChar(Character.toUpperCase(keyChar));
                }
            }
        });
        t8.addKeyListener(new KeyAdapter() {
            public void keyTyped(KeyEvent e) {
                char car = e.getKeyChar();
                if ((car < '0') || (car > '9')) {
                    e.consume();
                }
                if (t8.getText().length() == 6) {
                    // JOptionPane.showMessageDialog(null,"Pincode must be Six Digits.");
                    e.consume();
                }
            }
        });

        t10.addKeyListener(new KeyAdapter() {
            public void keyTyped(KeyEvent e) {
                char car = e.getKeyChar();
                if ((car < '0') || (car > '9')) {
                    e.consume();
                }
                if (t10.getText().length() == 12) {
                    e.consume();
                }
            }
        });

        t12.addKeyListener(new KeyAdapter() {
            public void keyTyped(KeyEvent e) {
                char car = e.getKeyChar();
                if ((car < '0') || (car > '9')) {
                    e.consume();
                }
                if (t12.getText().length() == 6) {
                    e.consume();
                }
            }
        });

        t9.addKeyListener(new KeyAdapter() {
            public void keyTyped(KeyEvent e) {
                char car = e.getKeyChar();
                if ((car < '0') || (car > '9')) {
                    e.consume();
                }
                if (t9.getText().length() == 10) {
                    e.consume();
                }
            }
        });

        setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);

        setVisible(true);
        
        try {

            Class.forName("oracle.jdbc.driver.OracleDriver");
            Connection c = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "system", "manish");
            // Connection c=DriverManager.getConnection("jdbc:odbc:dto","","");
            Statement s = c.createStatement();
            ResultSet rs = s.executeQuery("select count(formno) from applicationlearner");
            if (rs.next()) {
                formno = formno + String.valueOf(Integer.valueOf(rs.getString(1)) + 1);
                l2.setText(formno);

                // JOptionPane.showMessageDialog(this,staff,"DTO-CHAPRA",JOptionPane.INFORMATION_MESSAGE);
            }
            c.close();
        } catch (Exception ec) {
        }

        t3.requestFocus();
    }

    // -----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
    applicationf(String x1, String x2, String x3) {
        setTitle("Apply Learner's Licence");
        setSize(1350, 730);
        setResizable(false);
        setLocationRelativeTo(null);
        setLayout(null);
        setIconImage(Toolkit.getDefaultToolkit().getImage("hicon.png"));

        panel1.setLayout(null);
        panel2.setLayout(null);
        panel1.setBackground(Color.blue);
        panel2.setBackground(Color.white);
        try {
            UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel");
        } catch (Exception e) {
        }

        Date date = new Date();

        l = new JLabel("Application for Learner's Licence");
        l.setForeground(Color.white);
        l.setFont(new Font("Bookman Old Style", Font.BOLD, 20));

        l1 = new JLabel("Date :");
        l1.setFont(new Font("Bookman Old Style", Font.PLAIN, 16));
        l3 = new JLabel("Applicant Id :");
        l3.setFont(new Font("Bookman Old Style", Font.PLAIN, 16));
        l2 = new JLabel("Form No.");
        l2.setBorder(BorderFactory.createLineBorder(Color.black));
        l2.setFont(new Font("Bookman Old Style", Font.PLAIN, 16));
        l4 = new JLabel("Name :");
        l4.setFont(new Font("Bookman Old Style", Font.PLAIN, 16));
        l5 = new JLabel("Sex :");
        l5.setFont(new Font("Bookman Old Style", Font.PLAIN, 16));
        l6 = new JLabel("Relation :");
        l6.setFont(new Font("Bookman Old Style", Font.PLAIN, 16));
        l7 = new JLabel("Father/Husband Name :");
        l7.setFont(new Font("Bookman Old Style", Font.PLAIN, 16));
        l8 = new JLabel("Permanent Address :");
        l8.setFont(new Font("Bookman Old Style", Font.PLAIN, 16));
        l9 = new JLabel("Present Address/Official Address :");
        l9.setFont(new Font("Bookman Old Style", Font.PLAIN, 16));
        l10 = new JLabel("Village/Town :");
        l10.setFont(new Font("Bookman Old Style", Font.PLAIN, 16));
        l11 = new JLabel("District :");
        l11.setFont(new Font("Bookman Old Style", Font.PLAIN, 16));
        l12 = new JLabel("City :");
        l12.setFont(new Font("Bookman Old Style", Font.PLAIN, 16));
        l13 = new JLabel("Pin No. :");
        l13.setFont(new Font("Bookman Old Style", Font.PLAIN, 16));
        l14 = new JLabel("Mobile Number :");
        l14.setFont(new Font("Bookman Old Style", Font.PLAIN, 16));
        l15 = new JLabel("Addhar Number :");
        l15.setFont(new Font("Bookman Old Style", Font.PLAIN, 16));
        l16 = new JLabel("E-mail :");

        l16.setFont(new Font("Bookman Old Style", Font.PLAIN, 16));
        l17 = new JLabel("Documents- :");
        l17.setFont(new Font("Bookman Old Style", Font.PLAIN, 16));
        l18 = new JLabel("Address1 :");
        l18.setFont(new Font("Bookman Old Style", Font.PLAIN, 16));
        l19 = new JLabel("Address2 :");
        l19.setFont(new Font("Bookman Old Style", Font.PLAIN, 16));
        lp = new JLabel("Pincode :");
        lp.setFont(new Font("Bookman Old Style", Font.PLAIN, 16));
        l21 = new JLabel("Date of Birth(dd/mm/yyyy):");
        l21.setFont(new Font("Bookman Old Style", Font.PLAIN, 16));
        l22 = new JLabel("Blood Group :");
        l22.setFont(new Font("Bookman Old Style", Font.PLAIN, 16));
        l23 = new JLabel("Identification Marks :");
        l23.setFont(new Font("Bookman Old Style", Font.PLAIN, 16));

        t1 = new JTextField();
        t1.setText(df.format(date));
        t1.setFont(new Font("Bookman Old Style", Font.PLAIN, 14));
        t1.setEditable(false);
        t1.setBackground(Color.white);
        ta = new JTextField();
        ta.setFont(new Font("Bookman Old Style", Font.PLAIN, 14));
        ta1 = new JTextField();
        ta1.setFont(new Font("Bookman Old Style", Font.PLAIN, 14));
        ta2 = new JTextField();
        ta2.setFont(new Font("Bookman Old Style", Font.PLAIN, 14));
        t2 = new JTextField();
        t2.setFont(new Font("Bookman Old Style", Font.PLAIN, 14));
        t2.setEditable(false);
        t2.setBackground(Color.white);
        t3 = new JTextField();
        t3.setFont(new Font("Bookman Old Style", Font.PLAIN, 14));
        t3.setEditable(false);
        t3.setBackground(Color.white);
        t4 = new JTextField();
        t4.setFont(new Font("Bookman Old Style", Font.PLAIN, 14));
        t5 = new JTextField();
        t5.setFont(new Font("Bookman Old Style", Font.PLAIN, 14));
        t6 = new JTextField();
        t6.setFont(new Font("Bookman Old Style", Font.PLAIN, 14));
        t7 = new JTextField();
        t7.setFont(new Font("Bookman Old Style", Font.PLAIN, 14));
        t8 = new JTextField();
        t8.setFont(new Font("Bookman Old Style", Font.PLAIN, 14));
        t8.setTransferHandler(null);
        t9 = new JTextField();
        t9.setFont(new Font("Bookman Old Style", Font.PLAIN, 14));
        t9.setTransferHandler(null);
        t10 = new JTextField();
        t10.setFont(new Font("Bookman Old Style", Font.PLAIN, 14));
        t10.setTransferHandler(null);
        t11 = new JTextField();
        t11.setFont(new Font("Bookman Old Style", Font.PLAIN, 14));
        t12 = new JTextField();
        t12.setFont(new Font("Bookman Old Style", Font.PLAIN, 14));
        t12.setTransferHandler(null);
        t13 = new JTextField();
        t13.setFont(new Font("Bookman Old Style", Font.PLAIN, 14));
        t14 = new JTextField();
        t14.setFont(new Font("Bookman Old Style", Font.PLAIN, 14));
        t14.setEditable(false);
        t14.setBackground(Color.white);
        t15 = new JTextField();
        t15.setFont(new Font("Bookman Old Style", Font.PLAIN, 14));
        t16 = new JTextField();
        t16.setFont(new Font("Bookman Old Style", Font.PLAIN, 14));
        cb1 = new JComboBox();
        cb1.setFont(new Font("Bookman Old Style", Font.PLAIN, 14));
        cb1.addItem("--Select--");
        cb1.addItem("Male");
        cb1.addItem("Female");
        cb2 = new JComboBox();
        cb2.setFont(new Font("Bookman Old Style", Font.PLAIN, 14));
        cb2.addItem("--Select Blood Group--");
        cb2.addItem("O-");
        cb2.addItem("O+");
        cb2.addItem("A-");
        cb2.addItem("A+");
        cb2.addItem("B-");
        cb2.addItem("B+");
        cb2.addItem("AB-");
        cb2.addItem("AB+");
        ch1 = new JCheckBox("Photo Proof");
        ch2 = new JCheckBox("Address Proof");
        ch3 = new JCheckBox("Blood Group Proof");
        group = new ButtonGroup();
        rd1 = new JRadioButton("S/O");
        rd2 = new JRadioButton("D/O");
        rd3 = new JRadioButton("W/O");

        group.add(rd1);
        group.add(rd2);
        group.add(rd3);

        b1 = new JButton("Next");
        b2 = new JButton("Reset");
        b3 = new JButton("Cancel");
        b3.setEnabled(false);
        b1.setFont(new Font("Bookman Old Style", Font.PLAIN, 14));
        b2.setFont(new Font("Bookman Old Style", Font.PLAIN, 14));
        b3.setFont(new Font("Bookman Old Style", Font.PLAIN, 14));

        up1 = new JButton("Upload");
        up2 = new JButton("Upload");
        up3 = new JButton("Upload");

        panel1.setBounds(0, 0, 1400, 60);
        l.setBounds(500, 18, 350, 30);

        panel2.setBounds(0, 60, 1350, 560);
        l1.setBounds(30, 30, 150, 30);
        l2.setBounds(1160, 30, 150, 30);
        l3.setBounds(30, 70, 150, 30);
        l4.setBounds(30, 110, 150, 30);
        l5.setBounds(30, 150, 150, 30);
        l6.setBounds(30, 190, 150, 30);
        l7.setBounds(30, 230, 230, 30);
        l21.setBounds(26, 270, 230, 30);
        l22.setBounds(30, 310, 200, 30);
        l8.setBounds(30, 350, 200, 30);
        l10.setBounds(30, 390, 200, 30);
        l11.setBounds(30, 430, 200, 30);
        l12.setBounds(30, 470, 200, 30);
        l13.setBounds(30, 510, 200, 30);

        l23.setBounds(630, 30, 200, 30);
        l17.setBounds(630, 110, 200, 30);
        l9.setBounds(630, 230, 300, 30);
        l18.setBounds(630, 270, 200, 30);
        l19.setBounds(630, 310, 200, 30);
        lp.setBounds(630, 350, 200, 30);
        l16.setBounds(630, 390, 150, 30);
        l15.setBounds(630, 430, 200, 30);
        l14.setBounds(630, 470, 200, 30);

        t1.setBounds(250, 30, 300, 30);
        t2.setBounds(250, 70, 300, 30);
        t3.setBounds(250, 110, 300, 30);
        cb1.setBounds(250, 150, 300, 30);
        rd1.setBounds(250, 190, 50, 30);
        rd2.setBounds(310, 190, 50, 30);
        rd3.setBounds(370, 190, 50, 30);
        t4.setBounds(250, 230, 300, 30);
        t14.setBounds(250, 270, 300, 30);
        cb2.setBounds(250, 310, 300, 30);
        ta.setBounds(250, 350, 300, 30);
        t5.setBounds(250, 390, 300, 30);
        t6.setBounds(250, 430, 300, 30);
        t7.setBounds(250, 470, 300, 30);
        t8.setBounds(250, 510, 300, 30);

        t15.setBounds(830, 30, 300, 30);
        t16.setBounds(830, 70, 300, 30);
        ch1.setBounds(830, 110, 300, 30);
        up1.setBounds(1140, 110, 70, 30);
        ch2.setBounds(830, 150, 300, 30);
        up2.setBounds(1140, 150, 70, 30);
        ch3.setBounds(830, 190, 300, 30);
        up3.setBounds(1140, 190, 70, 30);
        ta1.setBounds(830, 270, 300, 30);
        ta2.setBounds(830, 310, 300, 30);
        t12.setBounds(830, 350, 300, 30);
        t11.setBounds(830, 390, 300, 30);
        t10.setBounds(830, 430, 300, 30);
        t9.setBounds(830, 470, 300, 30);

        b1.setBounds(790, 640, 100, 30);
        b2.setBounds(910, 640, 100, 30);
        b3.setBounds(1030, 640, 100, 30);

        panel1.add(l);
        panel2.add(l1);
        panel2.add(t1);
        panel2.add(l2);
        panel2.add(l3);
        panel2.add(t2);
        panel2.add(l4);
        panel2.add(t3);
        panel2.add(l5);
        panel2.add(cb1);
        panel2.add(l6);
        panel2.add(rd1);
        panel2.add(rd2);
        panel2.add(rd3);
        panel2.add(l7);
        panel2.add(t4);
        panel2.add(l21);
        panel2.add(t14);
        panel2.add(l22);
        panel2.add(cb2);
        panel2.add(l8);
        panel2.add(ta);
        panel2.add(l10);
        panel2.add(t5);
        panel2.add(l11);
        panel2.add(t6);
        panel2.add(l12);
        panel2.add(t7);
        panel2.add(l13);
        panel2.add(t8);
        panel2.add(l14);
        panel2.add(t9);
        panel2.add(l23);
        panel2.add(t15);
        panel2.add(t16);
        panel2.add(l17);
        panel2.add(ch1);
        panel2.add(ch2);
        panel2.add(ch3);
        panel2.add(up1);
        panel2.add(up2);
        panel2.add(up3);
        panel2.add(l9);
        panel2.add(l18);
        panel2.add(ta1);
        panel2.add(l19);
        panel2.add(ta2);
        panel2.add(lp);
        panel2.add(t12);
        panel2.add(l16);
        panel2.add(t11);
        panel2.add(l15);
        panel2.add(t10);

        add(b1);
        add(b2);
        add(b3);

        // JScrollBar sb=new JScrollBar(JScrollBar.VERTICAL,0,0,0,180);
        // JScrollPane sp=new
        // JScrollPane(JFrame,ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS,ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
        // sb.setBounds(1000,0,10,700);
        // add(sb);

        add(panel1);
        add(panel2);

        t2.addKeyListener(this);
        t2.addActionListener(this);
        t3.addActionListener(this);
        cb1.addActionListener(this);
        t4.addActionListener(this);
        t14.addActionListener(this);
        cb2.addActionListener(this);
        ta.addActionListener(this);

        t5.addActionListener(this);
        t6.addActionListener(this);
        t7.addActionListener(this);
        t8.addActionListener(this);
        t15.addActionListener(this);
        t16.addActionListener(this);
        ch1.addActionListener(this);
        ch2.addActionListener(this);
        ch3.addActionListener(this);
        ta1.addActionListener(this);
        ta2.addActionListener(this);
        ta2.addKeyListener(this);
        t12.addActionListener(this);
        t9.addActionListener(this);
        t10.addActionListener(this);
        t11.addActionListener(this);
        t10.addKeyListener(this);
        t11.addKeyListener(this);
        t3.addKeyListener(this);
        cb1.addKeyListener(this);
        t4.addKeyListener(this);
        t14.addKeyListener(this);
        cb2.addKeyListener(this);
        ta.addKeyListener(this);
        t5.addKeyListener(this);
        t6.addKeyListener(this);
        t7.addKeyListener(this);
        t8.addKeyListener(this);
        t15.addKeyListener(this);
        t16.addKeyListener(this);
        ch1.addKeyListener(this);
        ch2.addKeyListener(this);
        ch3.addKeyListener(this);
        ta1.addKeyListener(this);
        t12.addKeyListener(this);
        t9.addKeyListener(this);
        rd1.addActionListener(this);
        rd1.addKeyListener(this);
        rd2.addActionListener(this);
        rd2.addKeyListener(this);
        rd3.addActionListener(this);
        rd3.addKeyListener(this);
        up1.addActionListener(this);
        up1.addKeyListener(this);
        up2.addActionListener(this);
        up3.addKeyListener(this);
        up3.addActionListener(this);
        up2.addKeyListener(this);
        b1.addActionListener(this);
        b2.addActionListener(this);
        b3.addActionListener(this);
        b1.addKeyListener(this);
        b2.addKeyListener(this);
        b3.addKeyListener(this);

        t3.addKeyListener(new KeyAdapter() {
            public void keyTyped(KeyEvent e) {
                char keyChar = e.getKeyChar();
                if (Character.isLowerCase(keyChar)) {
                    e.setKeyChar(Character.toUpperCase(keyChar));
                }
            }
        });

        t14.addKeyListener(new KeyAdapter() {
            public void keyTyped(KeyEvent e) {
                char c = e.getKeyChar();
                e.consume();
            }
        });

        /*
         * t3.addKeyListener(new KeyAdapter()
         * {
         * public void keyTyped(KeyEvent e)
         * {
         * char car=e.getKeyChar();
         * if((car=='a'))
         * {
         * e.consume();
         * }
         * }
         * });
         */
        t4.addKeyListener(new KeyAdapter() {
            public void keyTyped(KeyEvent e) {
                char keyChar = e.getKeyChar();
                if (Character.isLowerCase(keyChar)) {
                    e.setKeyChar(Character.toUpperCase(keyChar));
                }
            }
        });
        ta.addKeyListener(new KeyAdapter() {
            public void keyTyped(KeyEvent e) {
                char keyChar = e.getKeyChar();
                if (Character.isLowerCase(keyChar)) {
                    e.setKeyChar(Character.toUpperCase(keyChar));
                }
            }
        });
        t5.addKeyListener(new KeyAdapter() {
            public void keyTyped(KeyEvent e) {
                char keyChar = e.getKeyChar();
                if (Character.isLowerCase(keyChar)) {
                    e.setKeyChar(Character.toUpperCase(keyChar));
                }
            }
        });
        t6.addKeyListener(new KeyAdapter() {
            public void keyTyped(KeyEvent e) {
                char keyChar = e.getKeyChar();
                if (Character.isLowerCase(keyChar)) {
                    e.setKeyChar(Character.toUpperCase(keyChar));
                }
            }
        });
        t7.addKeyListener(new KeyAdapter() {
            public void keyTyped(KeyEvent e) {
                char keyChar = e.getKeyChar();
                if (Character.isLowerCase(keyChar)) {
                    e.setKeyChar(Character.toUpperCase(keyChar));
                }
            }
        });
        ta1.addKeyListener(new KeyAdapter() {
            public void keyTyped(KeyEvent e) {
                char keyChar = e.getKeyChar();
                if (Character.isLowerCase(keyChar)) {
                    e.setKeyChar(Character.toUpperCase(keyChar));
                }
            }
        });
        ta2.addKeyListener(new KeyAdapter() {
            public void keyTyped(KeyEvent e) {
                char keyChar = e.getKeyChar();
                if (Character.isLowerCase(keyChar)) {
                    e.setKeyChar(Character.toUpperCase(keyChar));
                }
            }
        });
        t15.addKeyListener(new KeyAdapter() {
            public void keyTyped(KeyEvent e) {
                char keyChar = e.getKeyChar();
                if (Character.isLowerCase(keyChar)) {
                    e.setKeyChar(Character.toUpperCase(keyChar));
                }
            }
        });
        t16.addKeyListener(new KeyAdapter() {
            public void keyTyped(KeyEvent e) {
                char keyChar = e.getKeyChar();
                if (Character.isLowerCase(keyChar)) {
                    e.setKeyChar(Character.toUpperCase(keyChar));
                }
            }
        });
        t8.addKeyListener(new KeyAdapter() {
            public void keyTyped(KeyEvent e) {
                char car = e.getKeyChar();
                if ((car < '0') || (car > '9')) {
                    e.consume();
                }
                if (t8.getText().length() == 6) {
                    // JOptionPane.showMessageDialog(null,"Pincode must be Six Digits.");
                    e.consume();
                }
            }
        });

        t10.addKeyListener(new KeyAdapter() {
            public void keyTyped(KeyEvent e) {
                char car = e.getKeyChar();
                if ((car < '0') || (car > '9')) {
                    e.consume();
                }
                if (t10.getText().length() == 12) {
                    e.consume();
                }
            }
        });

        t12.addKeyListener(new KeyAdapter() {
            public void keyTyped(KeyEvent e) {
                char car = e.getKeyChar();
                if ((car < '0') || (car > '9')) {
                    e.consume();
                }
                if (t12.getText().length() == 6) {
                    e.consume();
                }
            }
        });

        t9.addKeyListener(new KeyAdapter() {
            public void keyTyped(KeyEvent e) {
                char car = e.getKeyChar();
                if ((car < '0') || (car > '9')) {
                    e.consume();
                }
                if (t9.getText().length() == 10) {
                    e.consume();
                }
            }
        });

        setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);

        setVisible(true);
        try {
            Class.forName("oracle.jdbc.driver.OracleDriver");
            Connection c = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "system", "manish");
            // Connection c=DriverManager.getConnection("jdbc:odbc:dto","","");
            Statement s = c.createStatement();
            ResultSet rs = s.executeQuery("select count(formno) from applicationlearner");
            if (rs.next()) {
                formno = formno + String.valueOf(Integer.valueOf(rs.getString(1)) + 1);
                l2.setText(formno);

                // JOptionPane.showMessageDialog(this,staff,"DTO-CHAPRA",JOptionPane.INFORMATION_MESSAGE);
            }
            c.close();
        } catch (Exception ec) {
        }

        t3.setText(x1);
        t14.setText(x2);
        t2.setText(x3);
        t3.requestFocus();
    }

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == b1) {
            if ((t2.getText()).equals("") || (t2.getText()).equals(null)) {
                JOptionPane.showMessageDialog(this, "Please Enter Applicant Id.", "Learner's Licence",
                        JOptionPane.ERROR_MESSAGE);
                t2.requestFocus();
            } else if ((t3.getText()).equals("") || (t3.getText()).equals(null)) {
                JOptionPane.showMessageDialog(this, "Please Enter Name.", "Learner's Licence",
                        JOptionPane.ERROR_MESSAGE);
                t3.requestFocus();
            } else if ((cb1.getSelectedItem()).equals("--Select--")) {
                JOptionPane.showMessageDialog(this, "Please Select Desired Item.", "Learner's Licence",
                        JOptionPane.ERROR_MESSAGE);
                cb1.requestFocus();
            } else if ((rd1.isSelected()) != true && rd2.isSelected() != true && rd3.isSelected() != true) {
                JOptionPane.showMessageDialog(this, "Please Select Desired Item.", "Learner's Licence",
                        JOptionPane.ERROR_MESSAGE);
                rd1.requestFocus();
            } else if ((t4.getText()).equals("") || (t4.getText()).equals(null)) {
                JOptionPane.showMessageDialog(this, "Please Enter Father's/Husband's Name.", "Learner's Licence",
                        JOptionPane.ERROR_MESSAGE);
                t4.requestFocus();
            } else if ((t14.getText()).equals("") || (t14.getText()).equals(null)) {
                JOptionPane.showMessageDialog(this, "Please Enter Date of Birth.", "Learner's Licence",
                        JOptionPane.ERROR_MESSAGE);
                t14.requestFocus();
            } else if ((cb2.getSelectedItem()).equals("--Select Blood Group--")) {
                JOptionPane.showMessageDialog(this, "Please Select Desired Item.", "Learner's Licence",
                        JOptionPane.ERROR_MESSAGE);
                cb2.requestFocus();
            } else if ((ta.getText()).equals("") || (ta.getText()).equals(null)) {
                JOptionPane.showMessageDialog(this, "Please Enter Permanent Address.", "Learner's Licence",
                        JOptionPane.ERROR_MESSAGE);
                ta.requestFocus();
            } else if ((t5.getText()).equals("") || (t5.getText()).equals(null)) {
                JOptionPane.showMessageDialog(this, "Please Enter Village/Town.", "Learner's Licence",
                        JOptionPane.ERROR_MESSAGE);
                t5.requestFocus();
            } else if ((t6.getText()).equals("") || (t6.getText()).equals(null)) {
                JOptionPane.showMessageDialog(this, "Please Enter District.", "Learner's Licence",
                        JOptionPane.ERROR_MESSAGE);
                t6.requestFocus();
            } else if ((t7.getText()).equals("") || (t7.getText()).equals(null)) {
                JOptionPane.showMessageDialog(this, "Please Enter City Name.", "Learner's Licence",
                        JOptionPane.ERROR_MESSAGE);
                t7.requestFocus();
            } else if ((t8.getText()).equals("") || (t8.getText()).equals(null)) {
                JOptionPane.showMessageDialog(this, "Please Enter Pincode.", "Learner's Licence",
                        JOptionPane.ERROR_MESSAGE);
                t8.requestFocus();
            } else if ((t15.getText()).equals("") || (t15.getText()).equals(null)) {
                JOptionPane.showMessageDialog(this, "Please Enter Identification Mark1.", "Learner's Licence",
                        JOptionPane.ERROR_MESSAGE);
                t15.requestFocus();
            } else if ((t16.getText()).equals("") || (t16.getText()).equals(null)) {
                JOptionPane.showMessageDialog(this, "Please Enter Identification Mark2.", "Learner's Licence",
                        JOptionPane.ERROR_MESSAGE);
                t16.requestFocus();
            } else if ((ta1.getText()).equals("") || (ta1.getText()).equals(null)) {
                JOptionPane.showMessageDialog(this, "Please Enter Present/Official Address.", "Learner's Licence",
                        JOptionPane.ERROR_MESSAGE);
                ta1.requestFocus();
            } else if ((t12.getText()).equals("") || (t12.getText()).equals(null)) {
                JOptionPane.showMessageDialog(this, "Please Enter Pincode.", "Learner's Licence",
                        JOptionPane.ERROR_MESSAGE);
                t12.requestFocus();
            } else if ((t9.getText()).equals("") || (t9.getText()).equals(null)) {
                JOptionPane.showMessageDialog(this, "Please Enter Mobile Number.", "Learner's Licence",
                        JOptionPane.ERROR_MESSAGE);
                t9.requestFocus();
            } else if ((ch1.isSelected() != true)) {
                JOptionPane.showMessageDialog(this, "Please Upload Photo Proof Image.", "Learner's Licence",
                        JOptionPane.ERROR_MESSAGE);
                up1.requestFocus();
            } else if ((ch2.isSelected() != true)) {
                JOptionPane.showMessageDialog(this, "Please Upload Address Proof Image.", "Learner's Licence",
                        JOptionPane.ERROR_MESSAGE);
                up2.requestFocus();
            } else if ((ch3.isSelected() != true)) {
                JOptionPane.showMessageDialog(this, "Please Upload Blood Group Proof Image.", "Learner's Licence",
                        JOptionPane.ERROR_MESSAGE);
                up3.requestFocus();
            } else if ((t9.getText()).length() != 10) {
                JOptionPane.showMessageDialog(this, "Mobile Number must be 10 digits.", "Learner's Licence",
                        JOptionPane.ERROR_MESSAGE);
                t9.requestFocus();
            } else if ((t8.getText()).length() != 6) {
                JOptionPane.showMessageDialog(this, "Pin Number must be 6 digits.", "Learner's Licence",
                        JOptionPane.ERROR_MESSAGE);
                t8.requestFocus();
            } else if ((t12.getText()).length() != 6) {
                JOptionPane.showMessageDialog(this, "Pin Number must be 6 digits.", "Learner's Licence",
                        JOptionPane.ERROR_MESSAGE);
                t12.requestFocus();
            } else {
                if ((l7.getText()).equals("Father's Name :") && (rd1.isSelected() == true)) {
                    try {
                        Class.forName("oracle.jdbc.driver.OracleDriver");
                        Connection c = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "system",
                                "manish");
                        // Connection c=DriverManager.getConnection("jdbc:odbc:dto","","");
                        Statement s = c.createStatement();
                        s.executeQuery("INSERT INTO applicationlearner VALUES('" + l2.getText() + "','" + t1.getText()
                                + "','" + t2.getText() + "','" + t3.getText() + "','" + cb1.getSelectedItem() + "','"
                                + rd1.getText() + "','','" + t4.getText() + "','" + t14.getText() + "','"
                                + cb2.getSelectedItem() + "','" + ta.getText() + "','" + t5.getText() + "','"
                                + t6.getText() + "','" + t7.getText() + "','" + t8.getText() + "','" + t15.getText()
                                + "','" + t16.getText() + "','" + img1 + "','" + img2 + "','" + img3 + "','"
                                + ta1.getText() + "','" + ta2.getText() + "','" + t12.getText() + "','" + t11.getText()
                                + "','" + t10.getText() + "','" + t9.getText() + "','','','','','','PENDING')");
                        c.close();
                    } catch (Exception ec) {
                        JOptionPane.showMessageDialog(this, ec.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
                    }
                } else if ((l7.getText()).equals("Father's Name :") && (rd2.isSelected() == true)) {
                    try {
                        Class.forName("oracle.jdbc.driver.OracleDriver");
                        Connection c = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "system",
                                "manish");
                        // Connection c=DriverManager.getConnection("jdbc:odbc:dto","","");
                        Statement s = c.createStatement();
                        s.executeQuery("INSERT INTO applicationlearner VALUES('" + l2.getText() + "','" + t1.getText()
                                + "','" + t2.getText() + "','" + t3.getText() + "','" + cb1.getSelectedItem() + "','"
                                + rd2.getText() + "','','" + t4.getText() + "','" + t14.getText() + "','"
                                + cb2.getSelectedItem() + "','" + ta.getText() + "','" + t5.getText() + "','"
                                + t6.getText() + "','" + t7.getText() + "','" + t8.getText() + "','" + t15.getText()
                                + "','" + t16.getText() + "','" + img1 + "','" + img2 + "','" + img3 + "','"
                                + ta1.getText() + "','" + ta2.getText() + "','" + t12.getText() + "','" + t11.getText()
                                + "','" + t10.getText() + "','" + t9.getText() + "','','','','','','PENDING')");
                        c.close();
                    } catch (Exception ec) {
                        JOptionPane.showMessageDialog(this, ec.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
                    }
                } else if ((l7.getText()).equals("Husband's Name :")) {
                    try {
                        Class.forName("oracle.jdbc.driver.OracleDriver");
                        Connection c = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "system",
                                "manish");
                        // Connection c=DriverManager.getConnection("jdbc:odbc:dto","","");
                        Statement s = c.createStatement();
                        s.executeQuery("INSERT INTO applicationlearner VALUES('" + l2.getText() + "','" + t1.getText()
                                + "','" + t2.getText() + "','" + t3.getText() + "','" + cb1.getSelectedItem() + "','"
                                + rd3.getText() + "','" + t4.getText() + "','','" + t14.getText() + "','"
                                + cb2.getSelectedItem() + "','" + ta.getText() + "','" + t5.getText() + "','"
                                + t6.getText() + "','" + t7.getText() + "','" + t8.getText() + "','" + t15.getText()
                                + "','" + t16.getText() + "','" + img1 + "','" + img2 + "','" + img3 + "','"
                                + ta1.getText() + "','" + ta2.getText() + "','" + t12.getText() + "','" + t11.getText()
                                + "','" + t10.getText() + "','" + t9.getText() + "','','','','','','PENDING')");
                        c.close();
                    } catch (Exception ec) {
                        JOptionPane.showMessageDialog(this, ec.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
                    }

                }

                /*
                 * t2.setText("");t3.setText("");t4.setText("");t5.setText("");t6.setText("");t7
                 * .setText("");t8.setText("");t9.setText("");t10.setText("");t11.setText("");
                 * t12.setText("");t13.setText("");t14.setText("");t15.setText("");t16.setText(
                 * "");
                 * ta.setText("");ta1.setText("");ta2.setText("");
                 * cb1.setSelectedItem("--Select--");cb2.
                 * setSelectedItem("--Select Blood Group--");
                 * //rd1.setState(false);
                 * //rd2.setValue(false);rd3.setValue(false);
                 * ch1.setSelected(false);ch2.setSelected(false);ch3.setSelected(false);
                 * t3.requestFocus();
                 */
                new vclass().setVisible(true);
                dispose();
                // Toolkit.getDefaultToolkit().setLockingKeyState(KeyEvent.VK_CAPS_LOCK,false);
            }

        }

        else if (e.getSource() == b2) {
            int result = JOptionPane.showConfirmDialog(this,
                    "Do you want to reset all textfields? This will harm your data or records.",
                    "Application Learner Licence", JOptionPane.YES_NO_OPTION);

            if (result == JOptionPane.YES_OPTION) {

                t4.setText("");
                t5.setText("");
                t6.setText("");
                t7.setText("");
                t8.setText("");
                t9.setText("");
                t10.setText("");
                t11.setText("");
                t12.setText("");
                t13.setText("");
                t15.setText("");
                t16.setText("");
                ta.setText("");
                ta1.setText("");
                ta2.setText("");
                cb1.setSelectedItem("--Select--");
                cb2.setSelectedItem("--Select Blood Group--");
                // rd1.setState(false);
                // rd2.setValue(false);rd3.setValue(false);
                ch1.setSelected(false);
                ch2.setSelected(false);
                ch3.setSelected(false);
                t3.requestFocus();
            }

        } else if (e.getSource() == b3) {
            // Toolkit.getDefaultToolkit().setLockingKeyState(KeyEvent.VK_CAPS_LOCK,false);
            dispose();

        } else if (e.getSource() == rd1) {
            if (rd1.isSelected() == true) {
                l7.setText("Father's Name :");
            }
        } else if (e.getSource() == rd2) {
            if (rd2.isSelected() == true) {
                l7.setText("Father's Name :");
            }
        } else if (e.getSource() == rd3) {
            if (rd3.isSelected() == true) {
                l7.setText("Husband's Name :");
            }
        } else if (e.getSource() == up1) {
            String f = getImageFile();
            try {
                Integer ex = (x.lastIndexOf('.') + 1);
                for (int i = ex; i < (ex + 3); i++) {
                    extension = extension + (x.charAt(i));
                }
            } catch (Exception exdd) {
            }
            if (!(extension.equals("jpg") || extension.equals("gif") || extension.equals("png"))) {
                JOptionPane.showMessageDialog(this, "Please Upload 'jpg' or 'gif' or 'png' Format Image.", "Error",
                        JOptionPane.ERROR_MESSAGE);
                up1.requestFocus();
            } else if (f != null) {
                // Toolkit kit=Toolkit.getDefaultToolkit();
                Toolkit kit = Toolkit.getDefaultToolkit();
                // img2=kit.getImage(f);
                // repaint();
                img1 = x;
                System.out.print(img1);
                ch1.setSelected(true);
                up2.requestFocus();
            }
            x = "";
            extension = "";
            // System.out.println(x+"manisn");
        } else if (e.getSource() == up2) {
            String f = getImageFile();
            try {
                Integer ex = (x.lastIndexOf('.') + 1);
                for (int i = ex; i < (ex + 3); i++) {
                    extension = extension + (x.charAt(i));
                }
            } catch (Exception exdf) {
            }
            if (!(extension.equals("jpg") || extension.equals("gif") || extension.equals("png"))) {
                JOptionPane.showMessageDialog(this, "Please Upload 'jpg' or 'gif' or 'png' Format Image.", "Error",
                        JOptionPane.ERROR_MESSAGE);
                up2.requestFocus();
            } else if (f != null) {
                // Toolkit kit=Toolkit.getDefaultToolkit();
                Toolkit kit = Toolkit.getDefaultToolkit();
                // img2=kit.getImage(f);
                // repaint();
                img2 = x;
                System.out.print(img2);
                ch2.setSelected(true);
                up3.requestFocus();
            }
            x = "";
            extension = "";
            // System.out.println(x+"manisn");
        } else if (e.getSource() == up3) {
            String f = getImageFile();
            try {
                Integer ex = (x.lastIndexOf('.') + 1);
                for (int i = ex; i < (ex + 3); i++) {
                    extension = extension + (x.charAt(i));
                }
            } catch (Exception es) {
            }
            if (!(extension.equals("jpg") || extension.equals("gif") || extension.equals("png"))) {
                JOptionPane.showMessageDialog(this, "Please Upload 'jpg' or 'gif' or 'png' Format Image.", "Error",
                        JOptionPane.ERROR_MESSAGE);
                up3.requestFocus();
            } else if (f != null) {
                // Toolkit kit=Toolkit.getDefaultToolkit();
                Toolkit kit = Toolkit.getDefaultToolkit();
                // img2=kit.getImage(f);
                // repaint();
                img3 = x;
                System.out.print(img3);
                ch3.setSelected(true);
                ta1.requestFocus();
            }
            x = "";
            extension = "";
            // System.out.println(x+"manisn");
        }

        else if (e.getSource() == ch1) {
            ch1.setSelected(false);
            JOptionPane.showMessageDialog(this, "Please Don't Click on this.", "Learner's Licence",
                    JOptionPane.ERROR_MESSAGE);
        } else if (e.getSource() == ch2) {
            ch2.setSelected(false);
            JOptionPane.showMessageDialog(this, "Please Don't Click on this.", "Learner's Licence",
                    JOptionPane.ERROR_MESSAGE);
        } else if (e.getSource() == ch3) {
            ch3.setSelected(false);
            JOptionPane.showMessageDialog(this, "Please Don't Click on this.", "Learner's Licence",
                    JOptionPane.ERROR_MESSAGE);
        }

    }

    public void keyPressed(KeyEvent e) {
        if (e.getKeyCode() == 10) {
            if (e.getSource() == t2) {
                if ((t2.getText()).equals("") || (t2.getText()).equals(null)) {
                    JOptionPane.showMessageDialog(this, "Please Enter Applicant Id.", "Learner's Licence",
                            JOptionPane.ERROR_MESSAGE);
                    t2.requestFocus();
                } else {
                    t3.requestFocus();
                }
            } else if (e.getSource() == t3) {
                if ((t3.getText()).equals("") || (t3.getText()).equals(null)) {
                    JOptionPane.showMessageDialog(this, "Please Enter Name.", "Learner's Licence",
                            JOptionPane.ERROR_MESSAGE);
                    t3.requestFocus();
                } else {
                    cb1.requestFocus();
                }
            } else if (e.getSource() == cb1) {
                if ((cb1.getSelectedItem()).equals("--Select--")) {
                    JOptionPane.showMessageDialog(this, "Please Select Desired Item.", "Learner's Licence",
                            JOptionPane.ERROR_MESSAGE);
                    cb1.requestFocus();
                } else {
                    rd1.requestFocus();
                }
            } else if (e.getSource() == rd1) {
                if (rd1.isSelected() == false) {
                    rd1.setSelected(true);
                    l7.setText("Father's Name :");
                    t4.requestFocus();
                }
            } else if (e.getSource() == rd2) {
                if (rd2.isSelected() == false) {
                    rd2.setSelected(true);
                    l7.setText("Father's Name :");
                    t4.requestFocus();
                }
            } else if (e.getSource() == rd3) {
                if (rd3.isSelected() == false) {
                    rd3.setSelected(true);
                    l7.setText("Husband's Name :");
                    t4.requestFocus();
                }
            } else if (e.getSource() == t4) {
                if ((t4.getText()).equals("") || (t4.getText()).equals(null)) {
                    JOptionPane.showMessageDialog(this, "Please Enter Father's/Husband's Name.", "Learner's Licence",
                            JOptionPane.ERROR_MESSAGE);
                    t4.requestFocus();
                } else {
                    t14.requestFocus();
                }
            } else if (e.getSource() == t14) {
                // final JFrame f = new JFrame();
                // String date=(new DatePicker(f).setPickedDate());
                // t14.setText((date).replace('-','/'));

                cb2.requestFocus();

            } else if (e.getSource() == cb2) {
                if ((cb2.getSelectedItem()).equals("--Select Blood Group--")) {
                    JOptionPane.showMessageDialog(this, "Please Select Desired Item.", "Learner's Licence",
                            JOptionPane.ERROR_MESSAGE);
                    cb2.requestFocus();
                } else {
                    ta.requestFocus();
                }
            } else if (e.getSource() == ta) {
                if ((ta.getText()).equals("") || (ta.getText()).equals(null)) {
                    JOptionPane.showMessageDialog(this, "Please Enter Permanent Address.", "Learner's Licence",
                            JOptionPane.ERROR_MESSAGE);
                    ta.requestFocus();
                } else {
                    t5.requestFocus();
                }
            } else if (e.getSource() == t5) {
                if ((t5.getText()).equals("") || (t5.getText()).equals(null)) {
                    JOptionPane.showMessageDialog(this, "Please Enter Village/Town.", "Learner's Licence",
                            JOptionPane.ERROR_MESSAGE);
                    t5.requestFocus();
                } else {
                    t6.requestFocus();
                }
            } else if (e.getSource() == t6) {
                if ((t6.getText()).equals("") || (t6.getText()).equals(null)) {
                    JOptionPane.showMessageDialog(this, "Please Enter District.", "Learner's Licence",
                            JOptionPane.ERROR_MESSAGE);
                    t6.requestFocus();
                } else {
                    t7.requestFocus();
                }
            } else if (e.getSource() == t7) {
                if ((t7.getText()).equals("") || (t7.getText()).equals(null)) {
                    JOptionPane.showMessageDialog(this, "Please Enter City Name.", "Learner's Licence",
                            JOptionPane.ERROR_MESSAGE);
                    t7.requestFocus();
                } else {
                    t8.requestFocus();
                }
            } else if (e.getSource() == t8) {
                if ((t8.getText()).equals("") || (t8.getText()).equals(null)) {
                    JOptionPane.showMessageDialog(this, "Please Enter Pincode.", "Learner's Licence",
                            JOptionPane.ERROR_MESSAGE);
                    t8.requestFocus();
                } else {
                    t15.requestFocus();
                }
            } else if (e.getSource() == t15) {
                if ((t15.getText()).equals("") || (t15.getText()).equals(null)) {
                    JOptionPane.showMessageDialog(this, "Please Enter Identification Mark1.", "Learner's Licence",
                            JOptionPane.ERROR_MESSAGE);
                    t15.requestFocus();
                } else {
                    t16.requestFocus();
                }
            } else if (e.getSource() == t16) {
                if ((t16.getText()).equals("") || (t16.getText()).equals(null)) {
                    JOptionPane.showMessageDialog(this, "Please Enter Identification Mark2.", "Learner's Licence",
                            JOptionPane.ERROR_MESSAGE);
                    t16.requestFocus();
                } else {
                    up1.requestFocus();
                }
            } else if (e.getSource() == up1) {
                // ch1.setSelected(true);
                up2.requestFocus();
            } else if (e.getSource() == up2) {
                // ch2.setSelected(true);
                up3.requestFocus();
            } else if (e.getSource() == up3) {
                // ch3.setSelected(true);
                ta1.requestFocus();
            }

            else if (e.getSource() == ta1) {
                if ((ta1.getText()).equals("") || (ta1.getText()).equals(null)) {
                    JOptionPane.showMessageDialog(this, "Please Enter Present/Official Address.", "Learner's Licence",
                            JOptionPane.ERROR_MESSAGE);
                    ta1.requestFocus();
                } else {
                    ta2.requestFocus();
                }
            } else if (e.getSource() == ta2) {
                t12.requestFocus();
            } else if (e.getSource() == t12) {
                if ((t12.getText()).equals("") || (t12.getText()).equals(null)) {
                    JOptionPane.showMessageDialog(this, "Please Enter Pincode.", "Learner's Licence",
                            JOptionPane.ERROR_MESSAGE);
                    t12.requestFocus();
                } else {
                    t11.requestFocus();
                }
            } else if (e.getSource() == t11) {
                if ((t11.getText()).equals("") || (t11.getText()).equals(null)) {
                    t10.requestFocus();
                } else {
                    String com = "";
                    Integer ex1 = 0;
                    Integer ex = 0;
                    try {
                        for (int j = 0; j <= (t11.getText().length()); j++) {
                            if ((String.valueOf(t11.getText().charAt(j))).equals("@")) {
                                ex = j;
                            } else if ((String.valueOf(t11.getText().charAt(j))).equals(".")) {
                                ex1 = j;
                                for (int i = (ex1 + 1); i < (ex1 + 4); i++) {
                                    com = com + (t11.getText().charAt(i));
                                }
                            }

                        }

                    } catch (Exception eexxx) {
                    }
                    String at = (String.valueOf(t11.getText().charAt(ex)));
                    String point = (String.valueOf(t11.getText().charAt(ex1)));

                    if (!(com.equals("com") && at.equals("@") && point.equals("."))) {
                        JOptionPane.showMessageDialog(this, "Please Enter a Valid e-mail id.", "Learner's Licence",
                                JOptionPane.ERROR_MESSAGE);
                    } else {
                        t10.requestFocus();
                    }
                }
            } else if (e.getSource() == t10) {
                t9.requestFocus();
            }

            else if (e.getSource() == t9) {
                if ((t9.getText()).equals("") || (t9.getText()).equals(null)) {
                    JOptionPane.showMessageDialog(this, "Please Enter Mobile Number.", "Learner's Licence",
                            JOptionPane.ERROR_MESSAGE);
                    t9.requestFocus();
                } else {
                    b1.requestFocus();
                }
            } else if (e.getSource() == ch1) {
                ch1.setSelected(false);
                JOptionPane.showMessageDialog(this, "Please Don't Click on this.", "Learner's Licence",
                        JOptionPane.ERROR_MESSAGE);
            } else if (e.getSource() == ch2) {
                ch2.setSelected(false);
                JOptionPane.showMessageDialog(this, "Please Don't Click on this.", "Learner's Licence",
                        JOptionPane.ERROR_MESSAGE);
            } else if (e.getSource() == ch3) {
                ch3.setSelected(false);
                JOptionPane.showMessageDialog(this, "Please Don't Click on this.", "Learner's Licence",
                        JOptionPane.ERROR_MESSAGE);
            }

            else if (e.getSource() == b1) {
                if ((t3.getText()).equals("") || (t3.getText()).equals(null)) {
                    JOptionPane.showMessageDialog(this, "Please Enter Name.", "Learner's Licence",
                            JOptionPane.ERROR_MESSAGE);
                    t3.requestFocus();
                }

                else if ((cb1.getSelectedItem()).equals("--Select--")) {
                    JOptionPane.showMessageDialog(this, "Please Select Desired Item.", "Learner's Licence",
                            JOptionPane.ERROR_MESSAGE);
                    cb1.requestFocus();
                } else if (rd1.isSelected() != true && rd2.isSelected() != true && rd3.isSelected() != true) {
                    JOptionPane.showMessageDialog(this, "Please Select Desired Item.", "Learner's Licence",
                            JOptionPane.ERROR_MESSAGE);
                    rd1.requestFocus();
                } else if ((t4.getText()).equals("") || (t4.getText()).equals(null)) {
                    JOptionPane.showMessageDialog(this, "Please Enter Father's/Husband's Name.", "Learner's Licence",
                            JOptionPane.ERROR_MESSAGE);
                    t4.requestFocus();
                } else if ((t14.getText()).equals("") || (t14.getText()).equals(null)) {
                    JOptionPane.showMessageDialog(this, "Please Enter Date of Birth.", "Learner's Licence",
                            JOptionPane.ERROR_MESSAGE);
                    t14.requestFocus();
                } else if ((cb2.getSelectedItem()).equals("--Select Blood Group--")) {
                    JOptionPane.showMessageDialog(this, "Please Select Desired Item.", "Learner's Licence",
                            JOptionPane.ERROR_MESSAGE);
                    cb2.requestFocus();
                } else if ((ta.getText()).equals("") || (ta.getText()).equals(null)) {
                    JOptionPane.showMessageDialog(this, "Please Enter Permanent Address.", "Learner's Licence",
                            JOptionPane.ERROR_MESSAGE);
                    ta.requestFocus();
                } else if ((t5.getText()).equals("") || (t5.getText()).equals(null)) {
                    JOptionPane.showMessageDialog(this, "Please Enter Village/Town.", "Learner's Licence",
                            JOptionPane.ERROR_MESSAGE);
                    t5.requestFocus();
                }

                else if ((t6.getText()).equals("") || (t6.getText()).equals(null)) {
                    JOptionPane.showMessageDialog(this, "Please Enter District.", "Learner's Licence",
                            JOptionPane.ERROR_MESSAGE);
                    t6.requestFocus();
                }

                else if ((t7.getText()).equals("") || (t7.getText()).equals(null)) {
                    JOptionPane.showMessageDialog(this, "Please Enter City Name.", "Learner's Licence",
                            JOptionPane.ERROR_MESSAGE);
                    t7.requestFocus();
                }

                else if ((t8.getText()).equals("") || (t8.getText()).equals(null)) {
                    JOptionPane.showMessageDialog(this, "Please Enter Pincode.", "Learner's Licence",
                            JOptionPane.ERROR_MESSAGE);
                    t8.requestFocus();
                }

                else if ((t15.getText()).equals("") || (t15.getText()).equals(null)) {
                    JOptionPane.showMessageDialog(this, "Please Enter Identification Mark1.", "Learner's Licence",
                            JOptionPane.ERROR_MESSAGE);
                    t15.requestFocus();
                }

                else if ((t16.getText()).equals("") || (t16.getText()).equals(null)) {
                    JOptionPane.showMessageDialog(this, "Please Enter Identification Mark2.", "Learner's Licence",
                            JOptionPane.ERROR_MESSAGE);
                    t16.requestFocus();
                } else if ((ch1.isSelected() != true)) {
                    JOptionPane.showMessageDialog(this, "Please Upload Photo Proof Image.", "Learner's Licence",
                            JOptionPane.ERROR_MESSAGE);
                    up1.requestFocus();
                } else if ((ch2.isSelected() != true)) {
                    JOptionPane.showMessageDialog(this, "Please Upload Address Proof Image.", "Learner's Licence",
                            JOptionPane.ERROR_MESSAGE);
                    up2.requestFocus();
                } else if ((ch3.isSelected() != true)) {
                    JOptionPane.showMessageDialog(this, "Please Upload Blood Group Proof Image.", "Learner's Licence",
                            JOptionPane.ERROR_MESSAGE);
                    up3.requestFocus();
                } else if ((ta1.getText()).equals("") || (ta1.getText()).equals(null)) {
                    JOptionPane.showMessageDialog(this, "Please Enter Present/Official Address.", "Learner's Licence",
                            JOptionPane.ERROR_MESSAGE);
                    ta1.requestFocus();
                }

                else if ((t12.getText()).equals("") || (t12.getText()).equals(null)) {
                    JOptionPane.showMessageDialog(this, "Please Enter Pincode.", "Learner's Licence",
                            JOptionPane.ERROR_MESSAGE);
                    t12.requestFocus();
                }

                else if ((t9.getText()).equals("") || (t9.getText()).equals(null)) {
                    JOptionPane.showMessageDialog(this, "Please Enter Mobile Number.", "Learner's Licence",
                            JOptionPane.ERROR_MESSAGE);
                    t9.requestFocus();
                } else {

                }
            }
        }

        else if (e.getKeyCode() == 39) {
            if (e.getSource() == rd1) {
                rd2.requestFocus();
            } else if (e.getSource() == rd2) {
                rd3.requestFocus();
            } else if (e.getSource() == rd3) {
                rd1.requestFocus();
            }
        } else if (e.getKeyCode() == 37) {
            if (e.getSource() == rd1) {
                rd3.requestFocus();
            } else if (e.getSource() == rd2) {
                rd1.requestFocus();
            } else if (e.getSource() == rd3) {
                rd2.requestFocus();
            }
        }

    }

    public void keyTyped(KeyEvent e) {
        /*
         * if(Toolkit.getDefaultToolkit().getLockingKeyState(KeyEvent.VK_CAPS_LOCK)!=
         * true)
         * {
         * JOptionPane.showMessageDialog(this,"Please Turn On Caps Lock Button."
         * ,"Apply Application",JOptionPane.ERROR_MESSAGE);
         * }
         */
        if (e.getSource() == t3) {
            char car = e.getKeyChar();
            if (!(car < '0' || car > '9')) {
                String c = String.valueOf(e.getKeyChar());
                JOptionPane.showMessageDialog(this, "Please Don't Enter Number(s).", "Apply Application",
                        JOptionPane.ERROR_MESSAGE);
                e.consume();
            }
        } else if (e.getSource() == t4) {
            char car = e.getKeyChar();
            if (!(car < '0' || car > '9')) {
                String c = String.valueOf(e.getKeyChar());
                JOptionPane.showMessageDialog(this, "Please Don't Enter Number(s).", "Apply Application",
                        JOptionPane.ERROR_MESSAGE);
                e.consume();
            }
        } else if (e.getSource() == t6) {
            char car = e.getKeyChar();
            if (!(car < '0' || car > '9')) {
                String c = String.valueOf(e.getKeyChar());
                JOptionPane.showMessageDialog(this, "Please Don't Enter Number(s).", "Apply Application",
                        JOptionPane.ERROR_MESSAGE);
                e.consume();
            }
        } else if (e.getSource() == t7) {
            char car = e.getKeyChar();
            if (!(car < '0' || car > '9')) {
                String c = String.valueOf(e.getKeyChar());
                JOptionPane.showMessageDialog(this, "Please Don't Enter Number(s).", "Apply Application",
                        JOptionPane.ERROR_MESSAGE);
                e.consume();
            }
        }
        
    }

    public void keyReleased(KeyEvent e) {
    }

    private String getImageFile() {
        JFileChooser ch = new JFileChooser();
        int result = ch.showOpenDialog(null);
        if (result == JFileChooser.APPROVE_OPTION) {
            // file=ch.getSelectedFile();
            x = ch.getSelectedFile().getPath();
            return x;
        } else {
            return null;
        }

    }

    class Animation extends JLabel {
        private static final long serialVersionUID = 1L;

        public void paintComponent(Graphics g) {
          
            g.fillRect(0, 0, getWidth(), getHeight());
        }
    }

    public static void main(String c[]) {
        new applicationf();
    }
}
