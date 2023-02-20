import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.sql.*;

class vclassrenewdl extends JFrame implements ActionListener, KeyListener {
    String applicantid = "AI10000";
    String dlnumber = "", vtype1 = "", vtype2 = "";
    ButtonGroup g = new ButtonGroup();
    JLabel l1, l2;
    JCheckBox ch1, ch2, ch3, ch4, ch5, ch6, ch7, ch8, ch9;
    JButton b1;
    JPanel panel1 = new JPanel();
    JPanel panel2 = new JPanel();
    
    vclassrenewdl() {
        setTitle("Vehicle Class");
        setSize(600, 400);
        setResizable(false);
        setLocationRelativeTo(null);
        setLayout(null);
        setIconImage(Toolkit.getDefaultToolkit().getImage("images/hicon.png"));
        panel1.setLayout(null);
        panel2.setLayout(null);
        panel1.setBackground(Color.blue);
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

        g.add(ch2);
        g.add(ch3);
        g.add(ch4);
        g.add(ch5);
        g.add(ch6);
        g.add(ch7);
        g.add(ch8);
        g.add(ch9);

        l2.setFont(new Font("Bookman Old Style", Font.PLAIN, 16));
        b1 = new JButton("Next");
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
        setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
        setVisible(true);
        
        try {
            Class.forName("oracle.jdbc.driver.OracleDriver");
            Connection c = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "system", "manish");
            // Connection c=DriverManager.getConnection("jdbc:odbc:dto","","");
            Statement s = c.createStatement();
            ResultSet rs = s.executeQuery(
                    "select applicantid from feeappdl WHERE feeoption='Renewal-Smart Card/Driving Licence' ORDER BY applicantid");
            while (rs.next()) {
                applicantid = rs.getString(1);
            }
            c.close();
        } catch (Exception ec) {
        }

        try {
            Class.forName("oracle.jdbc.driver.OracleDriver");
            Connection c = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "system", "manish");
            // Connection c=DriverManager.getConnection("jdbc:odbc:dto","","");
            Statement s = c.createStatement();
            ResultSet rs1 = s.executeQuery(
                    "select vehicletype1,vehicletype2 from drivinglicense where applicantid='" + applicantid + "'");
            if (rs1.next()) {

                vtype1 = rs1.getString(1);
                vtype2 = rs1.getString(2);

            }
            if (vtype1.equals("MCWG")) {
                ch2.setSelected(true);
            } else if (vtype1.equals("LMV")) {
                ch4.setSelected(true);
            } else if (vtype1.equals("LMV-TR")) {
                ch6.setSelected(true);
            } else if (vtype1.equals("HPMV")) {
                ch8.setSelected(true);
            } else if (vtype1.equals("MCWOG")) {
                ch3.setSelected(true);
            } else if (vtype1.equals("LMV-NT")) {
                ch5.setSelected(true);
            } else if (vtype1.equals("HMV")) {
                ch7.setSelected(true);
            } else if (vtype1.equals("HGMV")) {
                ch9.setSelected(true);
            }
            if (vtype2.equals("MCWG")) {
                ch2.setSelected(true);
            } else if (vtype2.equals("LMV")) {
                ch4.setSelected(true);
            } else if (vtype2.equals("LMV-TR")) {
                ch6.setSelected(true);
            } else if (vtype2.equals("HPMV")) {
                ch8.setSelected(true);
            } else if (vtype2.equals("MCWOG")) {
                ch3.setSelected(true);
            } else if (vtype2.equals("LMV-NT")) {
                ch5.setSelected(true);
            } else if (vtype2.equals("HMV")) {
                ch7.setSelected(true);
            } else if (vtype2.equals("HGMV")) {
                ch9.setSelected(true);
            }
            c.close();
        } catch (Exception ec) {
        }

    }

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == b1) {
            if (ch2.isSelected() == false && ch3.isSelected() == false && ch4.isSelected() == false
                    && ch5.isSelected() == false && ch6.isSelected() == false && ch7.isSelected() == false
                    && ch8.isSelected() == false && ch9.isSelected() == false) {
                JOptionPane.showMessageDialog(this, "Please Check Desire Item(s).", "Vehicle Class",
                        JOptionPane.ERROR_MESSAGE);
                ch2.requestFocus();
            } else {
                try {
                    Class.forName("oracle.jdbc.driver.OracleDriver");
                    Connection c = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "system",
                            "manish");
                    // Connection c=DriverManager.getConnection("jdbc:odbc:dto","","");
                    Statement s = c.createStatement();

                    if (ch2.isSelected() == true) {
                        s.executeQuery("UPDATE drivinglicense SET vehicletype='" + ch2.getText() + "' where dlnumber='"
                                + dlnumber + "'");
                    }
                    if (ch3.isSelected() == true) {
                        s.executeQuery("UPDATE drivinglicense SET vehicletype='" + ch3.getText() + "' where dlnumber='"
                                + dlnumber + "'");
                    }
                    if (ch4.isSelected() == true) {
                        s.executeQuery("UPDATE drivinglicense SET vehicletype='" + ch4.getText() + "' where dlnumber='"
                                + dlnumber + "'");
                    }
                    if (ch5.isSelected() == true) {
                        s.executeQuery("UPDATE drivinglicense SET vehicletype='" + ch5.getText() + "' where dlnumber='"
                                + dlnumber + "'");
                    }
                    if (ch6.isSelected() == true) {
                        s.executeQuery("UPDATE drivinglicense SET vehicletype='" + ch6.getText() + "' where dlnumber='"
                                + dlnumber + "'");
                    }
                    if (ch7.isSelected() == true) {
                        s.executeQuery("UPDATE drivinglicense SET vehicletype='" + ch7.getText() + "' where dlnumber='"
                                + dlnumber + "'");
                    }
                    if (ch8.isSelected() == true) {
                        s.executeQuery("UPDATE drivinglicense SET vehicletype='" + ch8.getText() + "' where dlnumber='"
                                + dlnumber + "'");
                    }
                    if (ch9.isSelected() == true) {
                        s.executeQuery("UPDATE drivinglicense SET vehicletype='" + ch9.getText() + "' where dlnumber='"
                                + dlnumber + "'");
                    }
                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(this, ex.getMessage(), "Vehicle Class", JOptionPane.ERROR_MESSAGE);
                }
                new biorenewdl().setVisible(true);
                dispose();
            }
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
                    JOptionPane.showMessageDialog(this, "Please Check Desire Item(s).", "Vehicle Class",
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

    class Animation extends JLabel {
        private static final long serialVersionUID = 1L;

        public void paintComponent(Graphics g) {
            g.fillRect(0, 0, getWidth(), getHeight());
        }
    }

    public static void main(String c[]) {
        new vclassrenewdl();
    }
}
