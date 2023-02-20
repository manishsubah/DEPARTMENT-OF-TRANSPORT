import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.sql.*;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

class feedl extends JFrame implements ActionListener, KeyListener {
    String applicantid = "AI10000";
    JLabel l, l1, l2, l3, l4, l5, l6, l7, l8, l9;
    JTextField t, t1, t2, t3, t4, t5, t6, t7, t8;
    JComboBox cb1;
    JButton b1, b3;
    JPanel panel1 = new JPanel();
    JPanel panel2 = new JPanel();
    String validity = "";
    DateFormat df = new SimpleDateFormat("dd/MM/yyyy");
    Date date = new Date();
    int y1 = 0, y2 = 0, d1 = 0, d2 = 0, m1 = 0, m2 = 0;
    
    feedl() {
        setTitle("Fee Description");
        setSize(600, 670);
        setIconImage(Toolkit.getDefaultToolkit().getImage("images/hicon.png"));
        setResizable(false);
        setLocationRelativeTo(null);
        setLayout(null);
        panel1.setLayout(null);
        panel2.setLayout(null);
        panel1.setBackground(Color.blue);
        panel2.setBackground(Color.white);
        try {
            UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel");
        } catch (Exception e) {
        }
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
        l5 = new JLabel("Learner Licence No. :");
        l5.setFont(new Font("Bookman Old Style", Font.PLAIN, 17));
        l6 = new JLabel("Name :");
        l6.setFont(new Font("Bookman Old Style", Font.PLAIN, 17));
        l7 = new JLabel("S/W/D of :");
        l7.setFont(new Font("Bookman Old Style", Font.PLAIN, 17));
        l8 = new JLabel("Date of Birth :");
        l8.setFont(new Font("Bookman Old Style", Font.PLAIN, 17));
        l9 = new JLabel("Type of Vehicles :");
        l9.setFont(new Font("Bookman Old Style", Font.PLAIN, 17));
        t = new JTextField();
        t.setText(df.format(date));
        t.setFont(new Font("Bookman Old Style", Font.PLAIN, 14));
        t.setEditable(false);
        t1 = new JTextField();
        t1.setFont(new Font("Bookman Old Style", Font.PLAIN, 14));
        t1.setEditable(false);
        t2 = new JTextField();
        t2.setFont(new Font("Bookman Old Style", Font.PLAIN, 14));
        t3 = new JTextField();
        t3.setFont(new Font("Bookman Old Style", Font.PLAIN, 14));
        t4 = new JTextField();
        t4.setFont(new Font("Bookman Old Style", Font.PLAIN, 14));
        t4.setEditable(false);
        t5 = new JTextField();
        t5.setFont(new Font("Bookman Old Style", Font.PLAIN, 14));
        t5.setEditable(false);
        t6 = new JTextField();
        t6.setFont(new Font("Bookman Old Style", Font.PLAIN, 14));
        t6.setEditable(false);
        t7 = new JTextField();
        t7.setFont(new Font("Bookman Old Style", Font.PLAIN, 14));
        t7.setEditable(false);
        t8 = new JTextField();
        t8.setFont(new Font("Bookman Old Style", Font.PLAIN, 14));
        t8.setEditable(false);
        cb1 = new JComboBox();
        cb1.setFont(new Font("Bookman Old Style", Font.PLAIN, 14));
        cb1.addItem("--Select--");
        cb1.addItem("Smart Card/Driving Licence");
        cb1.addItem("Renewal-Smart Card/Driving Licence");
        b1 = new JButton("Next");
        b3 = new JButton("Cancel");
        panel1.setBounds(0, 0, 700, 75);
        panel2.setBounds(0, 75, 700, 520);
        l1.setBounds(150, 28, 350, 30);
        l.setBounds(50, 30, 150, 30);
        l2.setBounds(50, 80, 250, 30);
        l3.setBounds(50, 130, 250, 30);
        l4.setBounds(50, 180, 100, 30);
        l5.setBounds(50, 230, 250, 30);
        l6.setBounds(50, 280, 200, 30);
        l7.setBounds(50, 330, 200, 30);
        l8.setBounds(50, 380, 250, 30);
        l9.setBounds(50, 430, 250, 30);
        t.setBounds(300, 30, 250, 30);
        t1.setBounds(300, 80, 250, 30);
        cb1.setBounds(300, 130, 250, 30);
        t2.setBounds(300, 180, 250, 30);
        t3.setBounds(300, 230, 250, 30);
        t4.setBounds(300, 280, 250, 30);
        t5.setBounds(300, 330, 250, 30);
        t6.setBounds(300, 380, 250, 30);
        t7.setBounds(300, 430, 250, 30);
        t8.setBounds(300, 480, 250, 30);
        b1.setBounds(340, 600, 100, 30);
        b3.setBounds(450, 600, 100, 30);
        add(panel1);
        add(panel2);
        panel1.add(l1);
        panel2.add(l);
        panel2.add(t);
        panel2.add(l2);
        panel2.add(t1);
        panel2.add(l5);
        panel2.add(t3);
        panel2.add(l3);
        panel2.add(cb1);
        panel2.add(l4);
        panel2.add(t2);
        panel2.add(l6);
        panel2.add(t4);
        panel2.add(l7);
        panel2.add(t5);
        panel2.add(l8);
        panel2.add(t6);
        panel2.add(l9);
        panel2.add(t7);
        panel2.add(t8);
        add(b1);
        add(b3);
        b1.addActionListener(this);
        b3.addActionListener(this);
        b1.addKeyListener(this);
        cb1.addKeyListener(this);
        cb1.addActionListener(this);
        b3.addKeyListener(this);
        t3.addKeyListener(this);
        t4.addKeyListener(this);
        t5.addKeyListener(this);
        t6.addKeyListener(this);
        t7.addKeyListener(this);
        t8.addKeyListener(this);
        t3.addKeyListener(new KeyAdapter() {
            public void keyTyped(KeyEvent e) {
                char keyChar = e.getKeyChar();
                if (Character.isLowerCase(keyChar)) {
                    e.setKeyChar(Character.toUpperCase(keyChar));
                }
            }
        });
        t4.addKeyListener(new KeyAdapter() {
            public void keyTyped(KeyEvent e) {
                char keyChar = e.getKeyChar();
                e.consume();
            }
        });
        t5.addKeyListener(new KeyAdapter() {
            public void keyTyped(KeyEvent e) {
                char keyChar = e.getKeyChar();
                e.consume();
            }
        });
        t6.addKeyListener(new KeyAdapter() {
            public void keyTyped(KeyEvent e) {
                char keyChar = e.getKeyChar();
                e.consume();
            }
        });
        t7.addKeyListener(new KeyAdapter() {
            public void keyTyped(KeyEvent e) {
                char keyChar = e.getKeyChar();
                e.consume();
            }
        });
        t8.addKeyListener(new KeyAdapter() {
            public void keyTyped(KeyEvent e) {
                char keyChar = e.getKeyChar();
                e.consume();
            }
        });
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setVisible(true);

        try {
            Class.forName("oracle.jdbc.driver.OracleDriver");
            Connection c = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "system", "manish");
            Statement s = c.createStatement();
            ResultSet rs = s.executeQuery("select count(applicantid) from feeappdl");
            if (rs.next()) {
                applicantid = applicantid + String.valueOf(Integer.valueOf(rs.getString(1)) + 1);
                t1.setText(applicantid);
            }
            c.close();
        } catch (Exception ec) {
        }
        cb1.requestFocus();
        

    }

    public void actionPerformed(ActionEvent e) {
        
        String status = "";
        if (e.getSource() == b1) {
            if ((cb1.getSelectedItem()).equals("--Select--")) {
                JOptionPane.showMessageDialog(this, "Please Select Desired Item.", "Fee Particular Description",
                        JOptionPane.ERROR_MESSAGE);
                cb1.requestFocus();
            } else if (((t3.getText()).equals("") || (t3.getText()).equals(null))
                    && (l5.getText()).equals("Learner Licence No. :")) {
                JOptionPane.showMessageDialog(this, "Please Enter Learner Licence Number.", "Fee Description",
                        JOptionPane.ERROR_MESSAGE);
                t3.requestFocus();
            } else if (((t3.getText()).equals("") || (t3.getText()).equals(null))
                    && (l5.getText()).equals("Driving Licence No. :")) {
                JOptionPane.showMessageDialog(this, "Please Enter Driving Licence Number.", "Fee Description",
                        JOptionPane.ERROR_MESSAGE);
                t3.requestFocus();
            } else if (((t4.getText()).equals("")
                    || (t4.getText()).equals(null) && (l5.getText()).equals("Learner Licence No. :"))) {
                JOptionPane.showMessageDialog(this, "Please Enter Valid Learner Licence Number and Click Enter Key.",
                        "Fee Description", JOptionPane.ERROR_MESSAGE);
                t3.requestFocus();
            } else if (((t4.getText()).equals("") || (t4.getText()).equals(null))
                    && (l5.getText()).equals("Driving Licence No. :")) {
                JOptionPane.showMessageDialog(this, "Please Enter Valid Driving Licence Number and Click Enter Key.",
                        "Fee Description", JOptionPane.ERROR_MESSAGE);
                t3.requestFocus();
            } else if (((t5.getText()).equals("")
                    || (t5.getText()).equals(null) && (l5.getText()).equals("Learner Licence No. :"))) {
                JOptionPane.showMessageDialog(this, "Please Enter Valid Learner Licence Number and Click Enter Key.",
                        "Fee Description", JOptionPane.ERROR_MESSAGE);
                t3.requestFocus();
            } else if (((t5.getText()).equals("") || (t5.getText()).equals(null))
                    && (l5.getText()).equals("Driving Licence No. :")) {
                JOptionPane.showMessageDialog(this, "Please Enter Valid Driving Licence Number and Click Enter Key.",
                        "Fee Description", JOptionPane.ERROR_MESSAGE);
                t3.requestFocus();
            } else if (((t6.getText()).equals("")
                    || (t6.getText()).equals(null) && (l5.getText()).equals("Learner Licence No. :"))) {
                JOptionPane.showMessageDialog(this, "Please Enter Valid Learner Licence Number and Click Enter Key.",
                        "Fee Description", JOptionPane.ERROR_MESSAGE);
                t3.requestFocus();
            } else if (((t6.getText()).equals("") || (t6.getText()).equals(null))
                    && (l5.getText()).equals("Driving Licence No. :")) {
                JOptionPane.showMessageDialog(this, "Please Enter Valid Driving Licence Number and Click Enter Key.",
                        "Fee Description", JOptionPane.ERROR_MESSAGE);
                t3.requestFocus();
            } else if (((t4.getText()).equals("")
                    || (t4.getText()).equals(null) && (l5.getText()).equals("Learner Licence No. :"))) {
                JOptionPane.showMessageDialog(this, "Please Enter Valid Learner Licence Number and Click Enter Key.",
                        "Fee Description", JOptionPane.ERROR_MESSAGE);
                t3.requestFocus();
            } else if (((t7.getText()).equals("") || (t7.getText()).equals(null))
                    && (l5.getText()).equals("Driving Licence No. :")) {
                JOptionPane.showMessageDialog(this, "Please Enter Valid Driving Licence Number and Click Enter Key.",
                        "Fee Description", JOptionPane.ERROR_MESSAGE);
                t3.requestFocus();
            } else if (cb1.getSelectedItem() == "Smart Card/Driving Licence") {
                try {
                    Class.forName("oracle.jdbc.driver.OracleDriver");
                    Connection c = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "system",
                            "manish");
                    Statement s = c.createStatement();
                    String sql = "Select learnerlicenseno,status,uptovalid from learnerlicense where learnerlicenseno='"
                            + t3.getText() + "'";
                    ResultSet rs = s.executeQuery(sql);
                    if (rs.next()) {
                        status = rs.getString(2);
                        validity = rs.getString(3);
                    } else {
                        JOptionPane.showMessageDialog(this, "Invalid Learner Licence Number .", "DTO-CHAPRA",
                                JOptionPane.INFORMATION_MESSAGE);
                        t3.setText("");
                        t3.requestFocus();
                    }
                    c.close();
                } catch (Exception ex) {
                }
                if (status.equals("APPROVED")) {
                    try {
                        Class.forName("oracle.jdbc.driver.OracleDriver");
                        Connection c = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "system",
                                "manish");
                        Statement s = c.createStatement();
                        s.executeQuery("INSERT INTO feeappdl VALUES('" + t.getText() + "','" + t1.getText() + "','"
                                + t3.getText() + "','" + cb1.getSelectedItem() + "','" + t2.getText() + "','"
                                + t4.getText() + "','" + t5.getText() + "','" + t6.getText() + "','" + t7.getText()
                                + "','" + t8.getText() + "')");
                        c.close();
                    } catch (Exception ec) {
                        JOptionPane.showMessageDialog(this, ec.getMessage(), "Information",
                                JOptionPane.INFORMATION_MESSAGE);
                    }
                    new applications(t3.getText(), t7.getText(), t8.getText()).setVisible(true);
                    dispose();
                }
                status = "";
            } else if (cb1.getSelectedItem() == "Renewal-Smart Card/Driving Licence") {
                try {
                    Class.forName("oracle.jdbc.driver.OracleDriver");
                    Connection c = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "system",
                            "manish");
                    Statement s = c.createStatement();
                    String sql = "Select dlnumber,status from drivinglicense where dlnumber='" + t3.getText() + "'";
                    ResultSet rs = s.executeQuery(sql);
                    if (rs.next()) {
                        status = rs.getString(2);
                    } else {
                        JOptionPane.showMessageDialog(this, "Invalid Driving Licence Number .", "DTO-CHAPRA",
                                JOptionPane.INFORMATION_MESSAGE);
                        t3.setText("");
                        t3.requestFocus();
                    }
                    c.close();
                } catch (Exception ex) {
                }
                if (status.equals("APPROVED")) {
                    try {
                        Class.forName("oracle.jdbc.driver.OracleDriver");
                        Connection c = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "system",
                                "manish");
                        Statement s = c.createStatement();
                        s.executeQuery("INSERT INTO feeappdl VALUES('" + t.getText() + "','" + t1.getText() + "','','"
                                + cb1.getSelectedItem() + "','" + t2.getText() + "','" + t4.getText() + "','"
                                + t5.getText() + "','" + t6.getText() + "','" + t7.getText() + "','" + t8.getText()
                                + "')");
                        c.close();
                    } catch (Exception ec) {
                    }
                    new renewdl(t3.getText(), t1.getText());
                    dispose();
                }
                status = "";
            }
        } else if (e.getSource() == b3) {
            dispose();
        } else if (e.getSource() == cb1) {
            if (cb1.getSelectedItem() == "Smart Card/Driving Licence") {
                t2.setText("450");
                l5.setText("Learner Licence No. :");
                t3.setText("");
                t4.setText("");
                t5.setText("");
                t6.setText("");
                t7.setText("");
                t8.setText("");
            } else if (cb1.getSelectedItem() == "Renewal-Smart Card/Driving Licence") {
                t2.setText("550");
                l5.setText("Driving Licence No. :");
                t3.setText("");
                t4.setText("");
                t5.setText("");
                t6.setText("");
                t7.setText("");
                t8.setText("");
            }
        }
    }

    public void keyPressed(KeyEvent e) {

        if (e.getKeyCode() == 10) {
            if (e.getSource() == t3) {
                if (((t3.getText()).equals("") || (t3.getText()).equals(null))
                        && (l5.getText()).equals("Learner Licence No. :")) {
                    JOptionPane.showMessageDialog(this, "Please Enter Learner Licence Number.", "Fee Description",
                            JOptionPane.ERROR_MESSAGE);
                    t3.requestFocus();
                } else if (((t3.getText()).equals("") || (t3.getText()).equals(null))
                        && (l5.getText()).equals("Driving Licence No. :")) {
                    JOptionPane.showMessageDialog(this, "Please Enter Driving Licence Number.", "Fee Description",
                            JOptionPane.ERROR_MESSAGE);
                    t3.requestFocus();
                } else {
                    String rl = "";
                    String hname = "";
                    String fname = "";
                    if (l5.getText().equals("Learner Licence No. :")) {
                        try {
                            Class.forName("oracle.jdbc.driver.OracleDriver");
                            Connection c = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "system",
                                    "manish");
                            Statement s = c.createStatement();
                            String sql = "Select uptovalid from learnerlicense where learnerlicenseno='" + t3.getText()
                                    + "'";
                            ResultSet rs = s.executeQuery(sql);
                            if (rs.next()) {
                                validity = rs.getString(1);
                            }
                        } catch (Exception eee) {
                        }

                        if ((validity.equals(t.getText()))) {
                            JOptionPane.showMessageDialog(this, "Expired.", "Fee Description",
                                    JOptionPane.ERROR_MESSAGE);
                            b1.setEnabled(false);
                        }
                        try {
                            Class.forName("oracle.jdbc.driver.OracleDriver");
                            Connection c = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "system",
                                    "manish");
                            Statement s = c.createStatement();
                            String sql = "Select name,husbandname,fathername,dob,vehicletype1,vehicletype2,relation from learnerlicense where learnerlicenseno='"
                                    + t3.getText() + "'";
                            ResultSet rs = s.executeQuery(sql);
                            if (rs.next()) {
                                t4.setText(rs.getString(1));
                                hname = rs.getString(2);
                                fname = rs.getString(3);
                                t6.setText(rs.getString(4));
                                t7.setText(rs.getString(5));
                                t8.setText(rs.getString(6));
                                rl = rs.getString(7);
                                b1.requestFocus();
                            } else {
                                JOptionPane.showMessageDialog(this, "Please Enter Valid Learner Licence Number.",
                                        "Fee Description", JOptionPane.ERROR_MESSAGE);
                                t3.setText("");
                                t3.requestFocus();
                            }
                            if (rl.equals("S/O") || rl.equals("D/O")) {
                                l7.setText("Father Name :");
                                t5.setText(fname);
                            }
                            if (rl.equals("W/O")) {
                                l7.setText("Husband Name :");
                                t5.setText(hname);
                            }
                            c.close();
                        } catch (Exception ee) {
                            JOptionPane.showMessageDialog(this, ee.getMessage(), "Fee Description",
                                    JOptionPane.ERROR_MESSAGE);
                        }
                    } else if (l5.getText().equals("Driving Licence No. :")) {
                        try {
                            Class.forName("oracle.jdbc.driver.OracleDriver");
                            Connection c = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "system",
                                    "manish");
                            Statement s = c.createStatement();
                            String sql = "Select name,husbandname,fathername,dob,vehicletype1,vehicletype2,relation from drivinglicense where dlnumber='"
                                    + t3.getText() + "'";
                            ResultSet rs = s.executeQuery(sql);
                            if (rs.next()) {
                                t4.setText(rs.getString(1));
                                hname = rs.getString(2);
                                fname = rs.getString(3);
                                t6.setText(rs.getString(4));
                                t7.setText(rs.getString(5));
                                t8.setText(rs.getString(6));
                                rl = rs.getString(7);
                                b1.requestFocus();
                            } else {
                                JOptionPane.showMessageDialog(this, "Please Enter Valid Driving Licence Number.",
                                        "Fee Description", JOptionPane.ERROR_MESSAGE);
                                t3.setText("");
                                t3.requestFocus();
                            }
                            if (rl.equals("S/O") || rl.equals("S/O")) {
                                l7.setText("Father Name :");
                                t5.setText(fname);
                            }
                            if (rl.equals("W/O")) {
                                l7.setText("Husband Name :");
                                t5.setText(hname);
                            }
                            c.close();
                        } catch (Exception ee) {
                            JOptionPane.showMessageDialog(this, ee.getMessage(), "Fee Description",
                                    JOptionPane.ERROR_MESSAGE);
                        }
                    }
                }
            } else if (e.getSource() == cb1) {
                if ((cb1.getSelectedItem()).equals("--Select--")) {
                    JOptionPane.showMessageDialog(this, "Please Select Desired Item.", "Fee Description",
                            JOptionPane.ERROR_MESSAGE);
                    cb1.requestFocus();
                } else {
                    t3.requestFocus();
                }
            } else if (e.getSource() == b1) {
                if ((cb1.getSelectedItem()).equals("--Select--")) {
                    JOptionPane.showMessageDialog(this, "Please Select Desired Item.", "Fee Description",
                            JOptionPane.ERROR_MESSAGE);
                    cb1.requestFocus();
                } else if (((t3.getText()).equals("") || (t3.getText()).equals(null))
                        && (l5.getText()).equals("Learner Licence No. :")) {
                    JOptionPane.showMessageDialog(this, "Please Enter Learner Licence Number.", "Fee Description",
                            JOptionPane.ERROR_MESSAGE);
                    t3.requestFocus();
                } else if (((t3.getText()).equals("") || (t3.getText()).equals(null))
                        && (l5.getText()).equals("Driving Licence No. :")) {
                    JOptionPane.showMessageDialog(this, "Please Enter Driving Licence Number.", "Fee Description",
                            JOptionPane.ERROR_MESSAGE);
                    t3.requestFocus();
                }
            }
        }
        if (e.getKeyCode() == 27) {
            dispose();
        }
        if (e.getSource() == t4) {
            if (e.getKeyCode() == 8) {
                e.consume();
            }
        }
        if (e.getSource() == t5) {
            if (e.getKeyCode() == 8) {
                e.consume();
            }
        }
        if (e.getSource() == t6) {
            if (e.getKeyCode() == 8) {
                e.consume();
            }
        }
        if (e.getSource() == t7) {
            if (e.getKeyCode() == 8) {
                e.consume();
            }
        }
        if (e.getSource() == t8) {
            if (e.getKeyCode() == 8) {
                e.consume();
            }
        }
    }

    public void keyTyped(KeyEvent e) {
    }

    public void keyReleased(KeyEvent e) {
    }

    class Animation extends JLabel {
        private static final long serialVersionUID = 1L;

        public void paintComponent(Graphics g) {
            
            g.fillRect(0, 0, getWidth(), getHeight());
        }
    }

    public static void main(String c[]) {
        new feedl();
    }
}
