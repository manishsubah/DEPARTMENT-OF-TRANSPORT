import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.sql.*;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
class form5 extends JFrame implements ActionListener, KeyListener {
    Timer timer;
    int count = 1;
    String post1 = "", post2 = "", post3 = "";
    String applicantid = "AI0000";
    JLabel l, l1, l2, l3, l4, l5, l7, l8;
    JTextField t, t1, t2, t3, t5, t6, t7;
    JComboBox cb1;
    JButton b1, b3, v1;
    JPanel panel1 = new JPanel();
    JPanel panel2 = new JPanel();
    form5() {
        setTitle("Fees Description");
        setSize(600, 640);
        setResizable(false);
        setLocationRelativeTo(null);
        setIconImage(Toolkit.getDefaultToolkit().getImage("images/hicon.png"));
        setLayout(null);
        Toolkit tk = Toolkit.getDefaultToolkit();
        Dimension ss = tk.getScreenSize();

        panel1.setLayout(null);
        panel1.setBackground(Color.blue);
        panel2.setLayout(null);
        panel2.setBackground(Color.white);
        try {
            UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel");
        } catch (Exception e) {
        }
        DateFormat df = new SimpleDateFormat("dd/MM/yyyy");
        Date date = new Date();

        l1 = new JLabel("FEE PARTICULAR DESCRIPTION");
        l1.setForeground(Color.white);
        l1.setFont(new Font("Sans-Serif", Font.BOLD, 20));
        l = new JLabel("Date :");
        l.setFont(new Font("Bookman Old Style", Font.PLAIN, 17));

        l2 = new JLabel("Applicant Id :");
        l2.setFont(new Font("Bookman Old Style", Font.PLAIN, 17));
        l3 = new JLabel("Fee Option :");
        l3.setFont(new Font("Bookman Old Style", Font.PLAIN, 17));
        l4 = new JLabel("Fee :");
        l4.setFont(new Font("Bookman Old Style", Font.PLAIN, 17));
        l5 = new JLabel("Name :");
        l5.setFont(new Font("Bookman Old Style", Font.PLAIN, 17));

        l7 = new JLabel("Date of Birth(dd/mm/yyyy) :");
        l7.setFont(new Font("Bookman Old Style", Font.PLAIN, 17));
        l8 = new JLabel("Type of Vehicle(s) :");
        l8.setFont(new Font("Bookman Old Style", Font.PLAIN, 17));

        t = new JTextField();
        t.setText(df.format(date));
        t.setFont(new Font("Bookman Old Style", Font.PLAIN, 14));

        t1 = new JTextField();
        t1.setFont(new Font("Bookman Old Style", Font.PLAIN, 14));

        t2 = new JTextField();
        t2.setFont(new Font("Bookman Old Style", Font.PLAIN, 14));

        t3 = new JTextField();
        t3.setFont(new Font("Bookman Old Style", Font.PLAIN, 14));
        t5 = new JTextField();
        t5.setFont(new Font("Bookman Old Style", Font.PLAIN, 14));
        t6 = new JTextField();
        t6.setFont(new Font("Bookman Old Style", Font.PLAIN, 14));
        t7 = new JTextField();
        t7.setFont(new Font("Bookman Old Style", Font.PLAIN, 14));

        cb1 = new JComboBox();
        cb1.setFont(new Font("Bookman Old Style", Font.PLAIN, 14));
        cb1.addItem("--Select--");
        cb1.addItem("Learner Licence for 1-Vehicle");
        cb1.addItem("Learner Licence for 2-Vehicles");

        v1 = new JButton("Select Type of Vehicle");
        v1.setFont(new Font("Bookman Old Style", Font.PLAIN, 12));

        b1 = new JButton("Next");

        b3 = new JButton("Cancel");
        panel1.setBounds(0, 0, 700, 75);
        panel2.setBounds(0, 75, 700, 480);
        l1.setBounds(160, 28, 350, 30);
        l.setBounds(50, 30, 150, 30);
        l2.setBounds(50, 80, 250, 30);

        l5.setBounds(50, 130, 250, 30);
        l7.setBounds(50, 180, 250, 30);
        l3.setBounds(50, 230, 250, 30);
        l4.setBounds(50, 280, 200, 30);
        l8.setBounds(50, 330, 200, 30);
        t.setBounds(300, 30, 250, 30);
        t1.setBounds(300, 80, 250, 30);
        t3.setBounds(300, 130, 250, 30);
        t5.setBounds(300, 180, 250, 30);
        cb1.setBounds(300, 230, 250, 30);
        t2.setBounds(300, 280, 250, 30);
        t6.setBounds(300, 330, 250, 30);
        t7.setBounds(300, 380, 250, 30);
        v1.setBounds(160, 570, 170, 30);
        b1.setBounds(340, 570, 100, 30);
        b3.setBounds(450, 570, 100, 30);

        add(panel1);
        add(panel2);

        panel1.add(l1);
        panel2.add(l);
        panel2.add(t);
        panel2.add(l2);
        panel2.add(t1);
        panel2.add(l5);
        panel2.add(t3);

        panel2.add(l7);
        panel2.add(t5);
        panel2.add(l3);
        panel2.add(cb1);
        panel2.add(l4);
        panel2.add(t2);
        panel2.add(l8);
        panel2.add(t6);
        panel2.add(t7);
        panel2.add(v1);
        add(b1);
        add(v1);
        add(b3);
        t3.addKeyListener(this);

        t5.addKeyListener(this);

        b1.addActionListener(this);

        b3.addActionListener(this);
        b1.addKeyListener(this);
        cb1.addKeyListener(this);
        cb1.addActionListener(this);

        b3.addKeyListener(this);
        v1.addKeyListener(this);
        v1.addActionListener(this);

        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        t3.addKeyListener(new KeyAdapter() {
            public void keyTyped(KeyEvent e) {
                char keyChar = e.getKeyChar();
                if (Character.isLowerCase(keyChar)) {
                    e.setKeyChar(Character.toUpperCase(keyChar));
                }
            }
        });
        t5.addKeyListener(new KeyAdapter() {
            public void keyTyped(KeyEvent e) {
                char c = e.getKeyChar();
                if (t5.getCaretPosition() == 0) {
                    if (!((c == '0') || (c == '1') || (c == '2') || (c == '3') || (c == KeyEvent.VK_BACK_SPACE)
                            || (c == KeyEvent.VK_DELETE) || (c == KeyEvent.VK_ENTER))) {
                        JOptionPane.showMessageDialog(null, "Please Enter Valid Number.");
                        e.consume();
                    }
                }
                if (t5.getCaretPosition() == 1) {
                    if (String.valueOf(t5.getText().charAt(0)).equals("3")) {
                        if (!((c == '0') || (c == '1') || (c == KeyEvent.VK_BACK_SPACE) || (c == KeyEvent.VK_DELETE))) {
                            JOptionPane.showMessageDialog(null, "Please Enter Valid Number.");
                            e.consume();
                        }

                    } else {
                        if (!((c == '0') || (c == '1') || (c == '2') || (c == '3') || (c == '4') || (c == '5')
                                || (c == '6') || (c == '7') || (c == '8') || (c == '9') || (c == KeyEvent.VK_BACK_SPACE)
                                || (c == KeyEvent.VK_DELETE))) {
                            JOptionPane.showMessageDialog(null, "Please Enter Valid Number.");
                            e.consume();
                        }
                    }
                }
                if (t5.getCaretPosition() == 2) {
                    if (!((c == KeyEvent.VK_SLASH) || (c == KeyEvent.VK_BACK_SPACE) || (c == KeyEvent.VK_DELETE))) {
                        JOptionPane.showMessageDialog(null, "Please Enter Slash(/).");
                        e.consume();
                    }
                }
                if (t5.getCaretPosition() == 3) {
                    if (!((c == '0') || (c == '1') || (c == KeyEvent.VK_BACK_SPACE) || (c == KeyEvent.VK_DELETE))) {
                        JOptionPane.showMessageDialog(null, "Please Enter Valid Number.");
                        e.consume();
                    }
                }
                if (t5.getCaretPosition() == 4 && (String.valueOf(t5.getText().charAt(3))).equals("0")) {
                    if (!((c == '1') || (c == '2') || (c == '3') || (c == '4') || (c == '5') || (c == '6') || (c == '7')
                            || (c == '8') || (c == '9') || (c == KeyEvent.VK_BACK_SPACE)
                            || (c == KeyEvent.VK_DELETE))) {
                        JOptionPane.showMessageDialog(null, "Please Enter Valid Number.");
                        e.consume();
                    }
                }
                if (t5.getCaretPosition() == 4 && (String.valueOf(t5.getText().charAt(3))).equals("1")) {
                    if (!((c == '0') || (c == '1') || (c == '2') || (c == KeyEvent.VK_BACK_SPACE)
                            || (c == KeyEvent.VK_DELETE))) {
                        JOptionPane.showMessageDialog(null, "Please Enter Valid Number.");
                        e.consume();
                    }
                }

                if (t5.getCaretPosition() == 5) {
                    if (!((c == KeyEvent.VK_SLASH) || (c == KeyEvent.VK_BACK_SPACE) || (c == KeyEvent.VK_DELETE))) {
                        JOptionPane.showMessageDialog(null, "Please Enter Slash(/).");
                        e.consume();
                    }
                }

                if (t5.getCaretPosition() == 6 || t5.getCaretPosition() == 7 || t5.getCaretPosition() == 8
                        || t5.getCaretPosition() == 9) {
                    if (!((c >= '0') && (c <= '9') || (c == KeyEvent.VK_BACK_SPACE) || (c == KeyEvent.VK_DELETE)
                            || (c == KeyEvent.VK_ENTER))) {
                        JOptionPane.showMessageDialog(null, "Please Enter Valid Key or Number.");
                        e.consume();
                    }
                }
                if (t5.getText().length() == 10) {
                    e.consume();
                }
            }
        });

        setVisible(true);
        try {
            Class.forName("oracle.jdbc.driver.OracleDriver");
            Connection c = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "system", "manish");
            // Connection c=DriverManager.getConnection("jdbc:odbc:dto","","");
            Statement s = c.createStatement();
            ResultSet rs = s.executeQuery("select count(applicantid) from feeparticulardescription");
            if (rs.next()) {
                applicantid = applicantid + String.valueOf(Integer.valueOf(rs.getString(1)) + 1);
                t1.setText(applicantid);
                // JOptionPane.showMessageDialog(this,staff,"DTO-CHAPRA",JOptionPane.INFORMATION_MESSAGE);
            }
            c.close();
        } catch (Exception ec) {
        }

        t3.requestFocus();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        
        if (e.getSource() == b1) {
            if ((t3.getText()).equals("") || (t3.getText()).equals(null)) {
                JOptionPane.showMessageDialog(this, "Please Enter Name.", "Fee", JOptionPane.ERROR_MESSAGE);
                t3.requestFocus();
            } else if ((t5.getText()).equals("") || (t5.getText()).equals(null) || (t5.getText()).length() < 10) {
                JOptionPane.showMessageDialog(this, "Please Enter Date of Birth(dd/mm/yyyy).", "Fee",
                        JOptionPane.ERROR_MESSAGE);
                t5.requestFocus();
            } else if (t5.getBackground() != Color.green) {
                int y1 = 0, y2 = 0, d1 = 0, d2 = 0, m1 = 0, m2 = 0;
                for (int i = 0; i <= 1; i++) {
                    d1 = d1 * 10;
                    d1 = d1 + Integer.parseInt(String.valueOf((t5.getText()).charAt(i)));
                }
                for (int i = 0; i <= 1; i++) {
                    d2 = d2 * 10;
                    d2 = d2 + Integer.parseInt(String.valueOf((t.getText()).charAt(i)));
                }
                for (int i = 3; i <= 4; i++) {
                    m1 = m1 * 10;
                    m1 = m1 + Integer.parseInt(String.valueOf((t5.getText()).charAt(i)));
                }
                for (int i = 3; i <= 4; i++) {
                    m2 = m2 * 10;
                    m2 = m2 + Integer.parseInt(String.valueOf((t.getText()).charAt(i)));
                }
                for (int i = 6; i <= 9; i++) {
                    y1 = y1 * 10;
                    y1 = y1 + Integer.parseInt(String.valueOf((t5.getText()).charAt(i)));
                }
                for (int i = 6; i <= 9; i++) {
                    y2 = y2 * 10;
                    y2 = y2 + Integer.parseInt(String.valueOf((t.getText()).charAt(i)));
                }
                int dd = 0, mm = 0, yy = 0;
                dd = d2 - d1;
                mm = m2 - m1;
                yy = y2 - y1;

                System.out.println(dd);
                System.out.println(mm);
                System.out.println(yy);
                if (yy <= 18) {
                    if (dd < 0 || mm < 0) {
                        JOptionPane.showMessageDialog(this, "Age is not valid to apply(less than 18 years).",
                                "Date of Birth", JOptionPane.ERROR_MESSAGE);
                        t5.setBackground(Color.white);
                    } else {
                        cb1.requestFocus();
                        t5.setBackground(Color.green);
                    }
                } else {
                    cb1.requestFocus();
                    t5.setBackground(Color.green);
                }

            }

            else if ((cb1.getSelectedItem()).equals("--Select--")) {
                JOptionPane.showMessageDialog(this, "Please Select Desired Item.", "Fee Particular Description",
                        JOptionPane.ERROR_MESSAGE);
                cb1.requestFocus();
            } else if ((t2.getText()).equals("") || (t2.getText()).equals(null)) {
                JOptionPane.showMessageDialog(this, "Please Enter Amount.", "Fee", JOptionPane.ERROR_MESSAGE);
                t2.requestFocus();
            } else if ((t6.getText()).equals("") || (t6.getText()).equals(null)) {
                JOptionPane.showMessageDialog(this, "Please Enter Vehicle Type.", "Fee", JOptionPane.ERROR_MESSAGE);
                v1.requestFocus();
            }

            else if ((cb1.getSelectedItem()).equals("Learner Licence for 1-Vehicle")
                    || (cb1.getSelectedItem()).equals("Learner Licence for 2-Vehicles")) {
                try {

                    Class.forName("oracle.jdbc.driver.OracleDriver");
                    Connection c = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "system",
                            "manish");
                    // Connection c=DriverManager.getConnection("jdbc:odbc:dto","","");
                    Statement s = c.createStatement();
                    s.executeQuery("INSERT INTO feeparticulardescription VALUES('" + t.getText() + "','" + t1.getText()
                            + "','" + t3.getText() + "','" + t5.getText() + "','" + cb1.getSelectedItem() + "','"
                            + t2.getText() + "','" + t6.getText() + "','" + t7.getText() + "')");
                    c.close();
                } catch (Exception ec) {
                    // JOptionPane.showMessageDialog(this,ec.getMessage(),"Information",JOptionPane.INFORMATION_MESSAGE);
                }
                post1 = t3.getText();
                post2 = t5.getText();
                post3 = t1.getText();
                new applicationf(post1, post2, post3).setVisible(true);
                dispose();
            }

        } else if (e.getSource() == v1) {
            new feevclass();
        } else if (e.getSource() == b3) {
            dispose();
        } else if (e.getSource() == cb1) {
            if (cb1.getSelectedItem() == "Learner Licence for 1-Vehicle") {
                t2.setText("150");
            } else if (cb1.getSelectedItem() == "Learner Licence for 2-Vehicles") {
                t2.setText("300");
            }

        }

    }

    public void keyPressed(KeyEvent e) {
        if (e.getKeyCode() == 10) {
            if (e.getSource() == t3) {
                if ((t3.getText()).equals("") || (t3.getText()).equals(null)) {
                    JOptionPane.showMessageDialog(this, "Please Enter Name.", "Fee", JOptionPane.ERROR_MESSAGE);
                    t3.requestFocus();
                } else {
                    t5.requestFocus();
                }
            } else if (e.getSource() == t5) {
                t5.setBackground(Color.white);
                if ((t5.getText()).equals("") || (t5.getText()).equals(null)) {
                    JOptionPane.showMessageDialog(this, "Please Enter Date of Birth.", "Fee",
                            JOptionPane.ERROR_MESSAGE);
                    t5.requestFocus();
                } else {
                    String tt = t5.getText();
                    try {
                        if (String.valueOf(tt.charAt(0)).equals("0") && String.valueOf(tt.charAt(1)).equals("0")) {
                            JOptionPane.showMessageDialog(this, "Invalid Date of Birth.", "Date of Birth",
                                    JOptionPane.ERROR_MESSAGE);
                            t5.requestFocus();
                        } else if (String.valueOf(tt.charAt(3)).equals("0")
                                && String.valueOf(tt.charAt(4)).equals("0")) {
                            JOptionPane.showMessageDialog(this, "Invalid Date of Birth.", "Date of Birth",
                                    JOptionPane.ERROR_MESSAGE);
                            t5.requestFocus();
                        } else if (String.valueOf(tt.charAt(6)).equals("0") && String.valueOf(tt.charAt(7)).equals("0")
                                && String.valueOf(tt.charAt(8)).equals("0")
                                && String.valueOf(tt.charAt(9)).equals("0")) {
                            JOptionPane.showMessageDialog(this, "Invalid Date of Birth.", "Date of Birth",
                                    JOptionPane.ERROR_MESSAGE);
                            t5.requestFocus();
                        } else if (!(t5.getText().length() == 10)) {
                            JOptionPane.showMessageDialog(this, "Invalid Date of Birth.", "Date of Birth",
                                    JOptionPane.ERROR_MESSAGE);
                            t5.requestFocus();
                        } else {
                            int y1 = 0, y2 = 0, d1 = 0, d2 = 0, m1 = 0, m2 = 0;
                            for (int i = 0; i <= 1; i++) {
                                d1 = d1 * 10;
                                d1 = d1 + Integer.parseInt(String.valueOf((t5.getText()).charAt(i)));
                            }
                            for (int i = 0; i <= 1; i++) {
                                d2 = d2 * 10;
                                d2 = d2 + Integer.parseInt(String.valueOf((t.getText()).charAt(i)));
                            }
                            for (int i = 3; i <= 4; i++) {
                                m1 = m1 * 10;
                                m1 = m1 + Integer.parseInt(String.valueOf((t5.getText()).charAt(i)));
                            }
                            for (int i = 3; i <= 4; i++) {
                                m2 = m2 * 10;
                                m2 = m2 + Integer.parseInt(String.valueOf((t.getText()).charAt(i)));
                            }
                            for (int i = 6; i <= 9; i++) {
                                y1 = y1 * 10;
                                y1 = y1 + Integer.parseInt(String.valueOf((t5.getText()).charAt(i)));
                            }
                            for (int i = 6; i <= 9; i++) {
                                y2 = y2 * 10;
                                y2 = y2 + Integer.parseInt(String.valueOf((t.getText()).charAt(i)));
                            }
                            int dd = 0, mm = 0, yy = 0;
                            dd = d2 - d1;
                            mm = m2 - m1;
                            yy = y2 - y1;

                            System.out.println(dd);
                            System.out.println(mm);
                            System.out.println(yy);
                            if (yy <= 18) {
                                if (dd < 0 || mm < 0) {
                                    JOptionPane.showMessageDialog(this,
                                            "Age is not valid to apply(less than 18 years).", "Date of Birth",
                                            JOptionPane.ERROR_MESSAGE);
                                    t5.setBackground(Color.white);
                                } else {
                                    cb1.requestFocus();
                                    t5.setBackground(Color.green);
                                }
                            } else {
                                cb1.requestFocus();
                                t5.setBackground(Color.green);
                            }
                        }
                    } catch (Exception eee) {
                    }

                }

            } else if (e.getSource() == cb1) {
                if ((cb1.getSelectedItem()).equals("--Select--")) {
                    JOptionPane.showMessageDialog(this, "Please Select Desired Item.", "Fee Particular Description",
                            JOptionPane.ERROR_MESSAGE);
                    cb1.requestFocus();
                } else {
                    v1.requestFocus();
                }
            } else if (e.getSource() == b1) {
                if ((t3.getText()).equals("") || (t3.getText()).equals(null)) {
                    JOptionPane.showMessageDialog(this, "Please Enter Name.", "Fee", JOptionPane.ERROR_MESSAGE);
                    t3.requestFocus();
                }

                else if ((t5.getText()).equals("") || (t5.getText()).equals(null)) {
                    JOptionPane.showMessageDialog(this, "Please Enter Date of Birth(dd/mm/yyyy).", "Fee",
                            JOptionPane.ERROR_MESSAGE);
                    t5.requestFocus();
                } else if ((cb1.getSelectedItem()).equals("--Select--")) {
                    JOptionPane.showMessageDialog(this, "Please Select Desired Item.", "Fee Particular Description",
                            JOptionPane.ERROR_MESSAGE);
                    cb1.requestFocus();
                } else if ((t2.getText()).equals("") || (t2.getText()).equals(null)) {
                    JOptionPane.showMessageDialog(this, "Please Enter Amount.", "Fee", JOptionPane.ERROR_MESSAGE);
                    t2.requestFocus();
                }

            }
        }
        if (e.getKeyCode() == 27) {
            dispose();
        }

    }

    public void keyTyped(KeyEvent e) {

    }

    public void keyReleased(KeyEvent e) {
    }

    // ---------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
    private class feevclass extends JFrame implements ActionListener, KeyListener {
        JLabel l1, l2;
        JCheckBox ch1, ch2, ch3, ch4, ch5, ch6, ch7, ch8, ch9;
        JButton b1;
        JPanel panel1 = new JPanel();
        JPanel panel2 = new JPanel();
        Color c = new Color(0, 128, 128);

        feevclass() {
            setTitle("Vehicle Class");
            setSize(600, 400);
            setResizable(false);
            setLocationRelativeTo(null);
            setLayout(null);

            panel1.setLayout(null);
            panel1.setBackground(Color.blue);
            panel2.setLayout(null);
            panel1.setBackground(c);
            panel2.setBackground(Color.white);
            try {
                UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel");
            } catch (Exception e) {
            }

            l1 = new JLabel("Vehicle Class");
            l1.setForeground(Color.white);
            l1.setFont(new Font("Bookman Old Style", Font.BOLD, 20));
            l2 = new JLabel("Class of Vehicles :--");
            l2.setFont(new Font("Bookman Old Style", Font.PLAIN, 16));
            ch2 = new JCheckBox("MCWG");
            ch2.setFont(new Font("Bookman Old Style", Font.PLAIN, 14));
            ch2.setToolTipText("Motor Cycle With Gear");
            ch3 = new JCheckBox("MCWOG");
            ch3.setFont(new Font("Bookman Old Style", Font.PLAIN, 14));
            ch3.setToolTipText("Motor Cycle Without Gear");
            ch4 = new JCheckBox("LMV");
            ch4.setToolTipText("Light Motor Vehicle");
            ch4.setFont(new Font("Bookman Old Style", Font.PLAIN, 14));
            ch5 = new JCheckBox("LMV-NT");
            ch5.setToolTipText("Light Motor Vehicle-Non Transport");
            ch5.setFont(new Font("Bookman Old Style", Font.PLAIN, 14));
            ch6 = new JCheckBox("LMV-TR");
            ch6.setToolTipText("Light Motor Vehicle-Transport");
            ch6.setFont(new Font("Bookman Old Style", Font.PLAIN, 14));
            ch7 = new JCheckBox("HMV");
            ch7.setToolTipText("Heavy Motor Vehicle");
            ch7.setFont(new Font("Bookman Old Style", Font.PLAIN, 14));
            ch8 = new JCheckBox("HPMV");
            ch8.setToolTipText("Heavy Passenger Motor Vehicle");
            ch8.setFont(new Font("Bookman Old Style", Font.PLAIN, 14));
            ch9 = new JCheckBox("HGMV");
            ch9.setToolTipText("Heavy Goods Motor Vehicle");
            ch9.setFont(new Font("Bookman Old Style", Font.PLAIN, 14));

            l2.setFont(new Font("Bookman Old Style", Font.PLAIN, 16));
            b1 = new JButton("Ok");
            b1.setFont(new Font("Bookman Old Style", Font.PLAIN, 14));

            panel1.setBounds(0, 0, 1000, 60);
            l1.setBounds(230, 18, 200, 30);
            panel2.setBounds(0, 60, 1000, 250);
            l2.setBounds(50, 50, 300, 30);
            ch2.setBounds(250, 50, 100, 30);
            ch3.setBounds(400, 50, 100, 30);
            ch4.setBounds(250, 100, 100, 30);
            ch5.setBounds(400, 100, 100, 30);
            ch6.setBounds(250, 150, 100, 30);
            ch7.setBounds(400, 150, 100, 30);
            ch8.setBounds(250, 200, 100, 30);
            ch9.setBounds(400, 200, 100, 30);
            b1.setBounds(400, 330, 100, 30);

            panel1.add(l1);
            panel2.add(l2);

            panel2.add(ch2);
            panel2.add(ch3);
            panel2.add(ch4);
            panel2.add(ch5);
            panel2.add(ch6);
            panel2.add(ch7);
            panel2.add(ch8);
            panel2.add(ch9);
            add(b1);

            add(panel1);
            add(panel2);

            b1.addActionListener(this);
            b1.addKeyListener(this);
            ch2.addKeyListener(this);
            ch3.addKeyListener(this);
            ch4.addKeyListener(this);
            ch5.addKeyListener(this);
            ch6.addKeyListener(this);
            ch7.addKeyListener(this);
            ch8.addKeyListener(this);
            ch9.addKeyListener(this);
            ch2.addActionListener(this);
            ch3.addActionListener(this);
            ch4.addActionListener(this);
            ch5.addActionListener(this);
            ch6.addActionListener(this);
            ch7.addActionListener(this);
            ch8.addActionListener(this);
            ch9.addActionListener(this);
            setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

            setVisible(true);

        }

        public void actionPerformed(ActionEvent e) {

            if (e.getSource() == b1) {
                if (ch2.isSelected() == false && ch3.isSelected() == false && ch4.isSelected() == false
                        && ch5.isSelected() == false && ch6.isSelected() == false && ch7.isSelected() == false
                        && ch8.isSelected() == false && ch9.isSelected() == false) {
                    JOptionPane.showMessageDialog(this, "Please Check Desire Item.", "Vehicle Class",
                            JOptionPane.ERROR_MESSAGE);
                    ch2.requestFocus();
                } else {
                    if ((t6.getText()).equals("") || (t6.getText()).equals(null)) {
                        if (ch2.isSelected() == true) {
                            t6.setText(ch2.getText());
                        } else if (ch3.isSelected() == true) {
                            t6.setText(ch3.getText());
                        } else if (ch4.isSelected() == true) {
                            t6.setText(ch4.getText());
                        } else if (ch5.isSelected() == true) {
                            t6.setText(ch5.getText());
                        } else if (ch6.isSelected() == true) {
                            t6.setText(ch6.getText());
                        } else if (ch7.isSelected() == true) {
                            t6.setText(ch7.getText());
                        } else if (ch8.isSelected() == true) {
                            t6.setText(ch8.getText());
                        } else if (ch9.isSelected() == true) {
                            t6.setText(ch9.getText());
                        }
                    }

                    if ((t7.getText()).equals("") || (t7.getText()).equals(null)) {

                        if (ch9.isSelected() == true) {
                            t7.setText(ch9.getText());
                        } else if (ch8.isSelected() == true) {
                            t7.setText(ch8.getText());
                        } else if (ch7.isSelected() == true) {
                            t7.setText(ch7.getText());
                        } else if (ch6.isSelected() == true) {
                            t7.setText(ch6.getText());
                        } else if (ch5.isSelected() == true) {
                            t7.setText(ch5.getText());
                        } else if (ch4.isSelected() == true) {
                            t7.setText(ch4.getText());
                        } else if (ch3.isSelected() == true) {
                            t7.setText(ch3.getText());
                        } else if (ch2.isSelected() == true) {
                            t7.setText(ch2.getText());
                        }
                    }
                }
                if ((t6.getText()).equals(t7.getText())) {
                    t7.setText("");
                }
                if ((cb1.getSelectedItem()).equals("Learner Licence for 1-Vehicle")) {
                    t7.setText("");
                }
                dispose();

            } else if (e.getSource() == ch2) {
                if (!ch2.isSelected() == false) {
                    b1.requestFocus();
                }
            } else if (e.getSource() == ch3) {
                if (ch3.isSelected() == true) {
                    b1.requestFocus();
                }
            } else if (e.getSource() == ch4) {
                if (ch4.isSelected() == true) {
                    b1.requestFocus();
                }
            } else if (e.getSource() == ch5) {
                if (ch5.isSelected() == true) {
                    b1.requestFocus();
                }
            } else if (e.getSource() == ch6) {
                if (ch6.isSelected() == true) {
                    b1.requestFocus();
                }
            } else if (e.getSource() == ch7) {
                if (ch7.isSelected() == true) {
                    b1.requestFocus();
                }
            } else if (e.getSource() == ch8) {
                if (ch8.isSelected() == true) {
                    b1.requestFocus();
                }
            } else if (e.getSource() == ch9) {
                if (ch9.isSelected() == true) {
                    b1.requestFocus();
                }
            }

        }

        public void keyPressed(KeyEvent e) {
            if (e.getKeyCode() == 10) {
                if (e.getSource() == ch2) {
                    if (ch2.isSelected() == false) {
                        ch2.setSelected(true);
                        b1.requestFocus();
                    } else {
                        ch2.setSelected(false);
                    }
                } else if (e.getSource() == ch3) {
                    if (ch3.isSelected() == false) {
                        ch3.setSelected(true);
                        b1.requestFocus();
                    } else {
                        ch3.setSelected(false);
                    }
                } else if (e.getSource() == ch4) {
                    if (ch4.isSelected() == false) {
                        ch4.setSelected(true);
                        b1.requestFocus();
                    } else {
                        ch4.setSelected(false);
                    }
                } else if (e.getSource() == ch5) {
                    if (ch5.isSelected() == false) {
                        ch5.setSelected(true);
                        b1.requestFocus();
                    } else {
                        ch5.setSelected(false);
                    }
                } else if (e.getSource() == ch6) {
                    if (ch6.isSelected() == false) {
                        ch6.setSelected(true);
                        b1.requestFocus();
                    } else {
                        ch6.setSelected(false);
                    }
                } else if (e.getSource() == ch7) {
                    if (ch7.isSelected() == false) {
                        ch7.setSelected(true);
                        b1.requestFocus();
                    } else {
                        ch7.setSelected(false);
                    }
                } else if (e.getSource() == ch8) {
                    if (ch8.isSelected() == false) {
                        ch8.setSelected(true);
                        b1.requestFocus();
                    } else {
                        ch8.setSelected(false);
                    }
                } else if (e.getSource() == ch9) {
                    if (ch9.isSelected() == false) {
                        ch9.setSelected(true);
                        b1.requestFocus();
                    } else {
                        ch9.setSelected(false);
                    }
                } else if (e.getSource() == b1) {
                    if (ch2.isSelected() == false && ch3.isSelected() == false && ch4.isSelected() == false
                            && ch5.isSelected() == false && ch6.isSelected() == false && ch7.isSelected() == false
                            && ch8.isSelected() == false && ch9.isSelected() == false) {
                        JOptionPane.showMessageDialog(this, "Please Check Desire Item.", "Vehicle Class",
                                JOptionPane.ERROR_MESSAGE);
                        ch2.requestFocus();
                    } else {
                    }
                }
            } else if (e.getKeyCode() == 38) {
                if (e.getSource() == ch9) {
                    ch7.requestFocus();
                } else if (e.getSource() == ch7) {
                    ch5.requestFocus();
                } else if (e.getSource() == ch5) {
                    ch3.requestFocus();
                } else if (e.getSource() == ch3) {
                    ch8.requestFocus();
                } else if (e.getSource() == ch8) {
                    ch6.requestFocus();
                } else if (e.getSource() == ch6) {
                    ch4.requestFocus();
                } else if (e.getSource() == ch4) {
                    ch2.requestFocus();
                }
            } else if (e.getKeyCode() == 40) {
                if (e.getSource() == ch2) {
                    ch4.requestFocus();
                } else if (e.getSource() == ch4) {
                    ch6.requestFocus();
                } else if (e.getSource() == ch6) {
                    ch8.requestFocus();
                } else if (e.getSource() == ch8) {
                    ch3.requestFocus();
                } else if (e.getSource() == ch3) {
                    ch5.requestFocus();
                } else if (e.getSource() == ch5) {
                    ch7.requestFocus();
                } else if (e.getSource() == ch7) {
                    ch9.requestFocus();
                }
            } else if (e.getKeyCode() == 39) {
                if (e.getSource() == ch2) {
                    ch3.requestFocus();
                } else if (e.getSource() == ch4) {
                    ch5.requestFocus();
                } else if (e.getSource() == ch6) {
                    ch7.requestFocus();
                } else if (e.getSource() == ch8) {
                    ch9.requestFocus();
                }
            } else if (e.getKeyCode() == 37) {
                if (e.getSource() == ch3) {
                    ch2.requestFocus();
                } else if (e.getSource() == ch5) {
                    ch4.requestFocus();
                } else if (e.getSource() == ch7) {
                    ch6.requestFocus();
                } else if (e.getSource() == ch9) {
                    ch8.requestFocus();
                }
            }

        }

        public void keyTyped(KeyEvent e) {
        }

        public void keyReleased(KeyEvent e) {
        }
    }

    
    public static void main(String c[]) {
        new form5();
    }
}
