import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.sql.*;

class approvaldl extends JFrame implements ActionListener, KeyListener {
    ResultSet rs, rs1;
    String sql;
    JLabel l, l1, l2, l3, l4, l5, l6, l7, l8, l9, l10, l11, l12, l13, l14;
    JTextField t1, t2, t3, t4, t5, t6, t7, t8, t9, t10, t11, t12, t13, t14, t15, t16;
    JToggleButton tb1, tb2;
    JSeparator sp = new JSeparator(JSeparator.VERTICAL);
    ButtonGroup group = new ButtonGroup();
    JButton b1, b2, b3, b4, b5, b6, b7, renew;
    JPanel panel1 = new JPanel();
    JPanel panel2 = new JPanel();
    
    approvaldl() {
        setTitle("Approval");
        setSize(1000, 675);
        setIconImage(Toolkit.getDefaultToolkit().getImage("hicon.png"));
        setResizable(false);
        setLocationRelativeTo(null);
        setLayout(null);
        panel1.setLayout(null);
        panel2.setLayout(null);
        panel1.setBackground(Color.blue);
        panel2.setBackground(Color.white);
        
        l = new JLabel("APPROVAL");
        l.setForeground(Color.white);
        l.setFont(new Font("Sans-Serif", Font.BOLD, 20));

        l1 = new JLabel("Date of Apply :");
        l1.setFont(new Font("Bookman Old Style", Font.PLAIN, 16));
        
        l2 = new JLabel("Applicant Id :");
        l2.setFont(new Font("Bookman Old Style", Font.PLAIN, 16));

        l3 = new JLabel("Name :");
        l3.setFont(new Font("Bookman Old Style", Font.PLAIN, 16));
        l4 = new JLabel("Sex :");
        l4.setFont(new Font("Bookman Old Style", Font.PLAIN, 16));
        l5 = new JLabel("Date of Birth :");
        l5.setFont(new Font("Bookman Old Style", Font.PLAIN, 16));
        l6 = new JLabel("Mobile Number :");
        l6.setFont(new Font("Bookman Old Style", Font.PLAIN, 16));
        l7 = new JLabel("Type of Vehicle(s) :");
        l7.setFont(new Font("Bookman Old Style", Font.PLAIN, 16));

        l8 = new JLabel("Date of Apply :");
        l8.setFont(new Font("Bookman Old Style", Font.PLAIN, 16));
        l9 = new JLabel("Applicant Id :");
        l9.setFont(new Font("Bookman Old Style", Font.PLAIN, 16));
        l10 = new JLabel("Name :");
        l10.setFont(new Font("Bookman Old Style", Font.PLAIN, 16));
        l11 = new JLabel("Sex :");
        l11.setFont(new Font("Bookman Old Style", Font.PLAIN, 16));
        l12 = new JLabel("Date of Birth :");
        l12.setFont(new Font("Bookman Old Style", Font.PLAIN, 16));
        l13 = new JLabel("Mobile Number :");
        l13.setFont(new Font("Bookman Old Style", Font.PLAIN, 16));
        l14 = new JLabel("Type of Vehicle(s) :");
        l14.setFont(new Font("Bookman Old Style", Font.PLAIN, 16));

        t1 = new JTextField();
        t1.setFont(new Font("Bookman Old Style", Font.PLAIN, 14));
        t1.setEditable(false);
        t1.setBackground(Color.white);
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
        t4.setEditable(false);
        t4.setBackground(Color.white);
        t5 = new JTextField();
        t5.setFont(new Font("Bookman Old Style", Font.PLAIN, 14));
        t5.setEditable(false);
        t5.setBackground(Color.white);
        t6 = new JTextField();
        t6.setFont(new Font("Bookman Old Style", Font.PLAIN, 14));
        t6.setEditable(false);
        t6.setBackground(Color.white);
        t7 = new JTextField();
        t7.setFont(new Font("Bookman Old Style", Font.PLAIN, 14));
        t7.setEditable(false);
        t7.setBackground(Color.white);
        t15 = new JTextField();
        t15.setFont(new Font("Bookman Old Style", Font.PLAIN, 14));
        t15.setEditable(false);
        t15.setBackground(Color.white);

        t8 = new JTextField();
        t8.setFont(new Font("Bookman Old Style", Font.PLAIN, 14));
        t8.setEditable(false);
        t8.setBackground(Color.white);
        t9 = new JTextField();
        t9.setFont(new Font("Bookman Old Style", Font.PLAIN, 14));
        t9.setEditable(false);
        t9.setBackground(Color.white);
        t10 = new JTextField();
        t10.setFont(new Font("Bookman Old Style", Font.PLAIN, 14));
        t10.setEditable(false);
        t10.setBackground(Color.white);
        t11 = new JTextField();
        t11.setFont(new Font("Bookman Old Style", Font.PLAIN, 14));
        t11.setEditable(false);
        t11.setBackground(Color.white);
        t12 = new JTextField();
        t12.setFont(new Font("Bookman Old Style", Font.PLAIN, 14));
        t12.setEditable(false);
        t12.setBackground(Color.white);
        t13 = new JTextField();
        t13.setFont(new Font("Bookman Old Style", Font.PLAIN, 14));
        t13.setEditable(false);
        t13.setBackground(Color.white);
        t14 = new JTextField();
        t14.setFont(new Font("Bookman Old Style", Font.PLAIN, 14));
        t14.setEditable(false);
        t14.setBackground(Color.white);
        t16 = new JTextField();
        t16.setFont(new Font("Bookman Old Style", Font.PLAIN, 14));
        t16.setEditable(false);
        t16.setBackground(Color.white);

        tb1 = new JToggleButton("Learner Licence");
        tb1.setFont(new Font("Bookman Old Style", Font.PLAIN, 16));

        tb2 = new JToggleButton("Driving Licence");
        tb2.setFont(new Font("Bookman Old Style", Font.PLAIN, 16));

        group.add(tb1);
        group.add(tb2);

        b1 = new JButton("Previous");
        b1.setFont(new Font("Bookman Old Style", Font.PLAIN, 14));
        b2 = new JButton("Next");
        b2.setFont(new Font("Bookman Old Style", Font.PLAIN, 14));
        b3 = new JButton("Show");
        b3.setFont(new Font("Bookman Old Style", Font.PLAIN, 14));

        b4 = new JButton("Previous");
        b4.setFont(new Font("Bookman Old Style", Font.PLAIN, 14));
        b5 = new JButton("Next");
        b5.setFont(new Font("Bookman Old Style", Font.PLAIN, 14));
        b6 = new JButton("Show");
        b6.setFont(new Font("Bookman Old Style", Font.PLAIN, 14));

        b7 = new JButton("Cancel");
        b7.setFont(new Font("Bookman Old Style", Font.PLAIN, 14));

        renew = new JButton("Renewal Approval");
        renew.setFont(new Font("Bookman Old Style", Font.PLAIN, 14));

        
        panel1.setBounds(0, 0, 1000, 60);
        l.setBounds(450, 18, 350, 30);

        panel2.setBounds(0, 60, 1000, 540);

        sp.setBounds(500, 10, 50, 500);

        tb1.setBounds(80, 30, 350, 30);
        tb2.setBounds(570, 30, 350, 30);

        l1.setBounds(30, 100, 150, 30);
        l2.setBounds(30, 150, 300, 30);
        l3.setBounds(30, 200, 300, 30);
        l4.setBounds(30, 250, 300, 30);
        l5.setBounds(30, 300, 300, 30);
        l6.setBounds(30, 350, 300, 30);
        l7.setBounds(30, 400, 300, 30);

        l8.setBounds(530, 100, 300, 30);
        l9.setBounds(530, 150, 300, 30);
        l10.setBounds(530, 200, 300, 30);
        l11.setBounds(530, 250, 300, 30);
        l12.setBounds(530, 300, 300, 30);
        l13.setBounds(530, 350, 300, 30);
        l14.setBounds(530, 400, 300, 30);

        t1.setBounds(190, 100, 280, 30);
        t2.setBounds(190, 150, 280, 30);
        t3.setBounds(190, 200, 280, 30);
        t4.setBounds(190, 250, 280, 30);
        t5.setBounds(190, 300, 280, 30);
        t6.setBounds(190, 350, 280, 30);
        t7.setBounds(190, 400, 280, 30);
        t15.setBounds(190, 450, 280, 30);

        t8.setBounds(680, 100, 280, 30);
        t9.setBounds(680, 150, 280, 30);
        t10.setBounds(680, 200, 280, 30);
        t11.setBounds(680, 250, 280, 30);
        t12.setBounds(680, 300, 280, 30);
        t13.setBounds(680, 350, 280, 30);
        t14.setBounds(680, 400, 280, 30);
        t16.setBounds(680, 450, 280, 30);

        b1.setBounds(160, 500, 100, 30);
        b2.setBounds(270, 500, 100, 30);
        b3.setBounds(380, 500, 100, 30);

        b4.setBounds(650, 500, 100, 30);
        b5.setBounds(760, 500, 100, 30);
        b6.setBounds(870, 500, 100, 30);

        b7.setBounds(870, 610, 100, 30);

        renew.setBounds(680, 610, 180, 30);

        panel1.add(l);
        panel2.add(sp);
        panel2.add(tb1);
        panel2.add(tb2);
        panel2.add(l1);
        panel2.add(t1);
        panel2.add(l2);
        panel2.add(t2);
        panel2.add(l3);
        panel2.add(t3);
        panel2.add(l4);
        panel2.add(t4);
        panel2.add(l5);
        panel2.add(t5);
        panel2.add(l6);
        panel2.add(t6);
        panel2.add(l7);
        panel2.add(t7);
        panel2.add(t15);

        panel2.add(b1);
        panel2.add(b2);
        panel2.add(b3);

        panel2.add(l8);
        panel2.add(t8);
        panel2.add(l9);
        panel2.add(t9);
        panel2.add(l10);
        panel2.add(t10);
        panel2.add(l11);
        panel2.add(t11);
        panel2.add(l12);
        panel2.add(t12);
        panel2.add(l13);
        panel2.add(t13);
        panel2.add(l14);
        panel2.add(t14);
        panel2.add(t16);

        panel2.add(b4);
        panel2.add(b5);
        panel2.add(b6);

        add(panel1);
        add(panel2);

        add(b7);
        add(renew);
        b1.addActionListener(this);
        b1.addKeyListener(this);
        b2.addActionListener(this);
        b2.addKeyListener(this);
        b3.addActionListener(this);
        b3.addKeyListener(this);
        b4.addActionListener(this);
        b4.addKeyListener(this);
        b5.addActionListener(this);
        b5.addKeyListener(this);
        b6.addActionListener(this);
        b6.addKeyListener(this);
        b7.addActionListener(this);
        b7.addKeyListener(this);
        tb1.addActionListener(this);
        tb1.addKeyListener(this);
        tb2.addActionListener(this);
        tb2.addKeyListener(this);
        renew.addActionListener(this);
        renew.addKeyListener(this);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        setVisible(true);
        
        tb1.requestFocus();

    }

    public void actionPerformed(ActionEvent e) {
        
        if (e.getSource() == tb1) {
            if (tb1.isSelected() == true) {
                try {
                    Class.forName("oracle.jdbc.driver.OracleDriver");
                    Connection c = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "system",
                            "manish");
                    
                    Statement s = c.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
                    sql = "Select applydate,applicantid,name,sex,dob,mobile,vehicletype1,vehicletype2 from applicationlearner WHERE status='PENDING' ORDER BY applicantid ASC";
                    rs1 = s.executeQuery(sql);
                    if (rs1.next()) {
                        t1.setText(rs1.getString(1));
                        t2.setText(rs1.getString(2));
                        t3.setText(rs1.getString(3));
                        t4.setText(rs1.getString(4));
                        t5.setText(rs1.getString(5));
                        t6.setText(rs1.getString(6));
                        t7.setText(rs1.getString(7));
                        t15.setText(rs1.getString(8));
                    }
                } catch (Exception ep) {
                    System.out.print(ep.getMessage());
                }
                b4.requestFocus();
            } else {
                JOptionPane.showMessageDialog(this, "Please Firstly Select Learner Licence Button.", "Error",
                        JOptionPane.ERROR_MESSAGE);
            }

        }
        if (e.getSource() == tb2) {
            if (tb2.isSelected() == true) {
                try {
                    Class.forName("oracle.jdbc.driver.OracleDriver");
                    Connection c = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "system",
                            "manish");
                    
                    Statement s = c.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
                    sql = "Select applydate,applicantid,name,sex,dob,mobile,vehicletype1,vehicletype2 from applicationdl WHERE status='PENDING' ORDER BY applicantid";
                    rs = s.executeQuery(sql);
                    if (rs.next()) {
                        t8.setText(rs.getString(1));
                        t9.setText(rs.getString(2));
                        t10.setText(rs.getString(3));
                        t11.setText(rs.getString(4));
                        t12.setText(rs.getString(5));
                        t13.setText(rs.getString(6));
                        t14.setText(rs.getString(7));
                        t16.setText(rs.getString(8));
                    }

                } catch (Exception ep) {
                    System.out.print(ep.getMessage());
                }

            } else {
                JOptionPane.showMessageDialog(this, "Please Firstly Select Driving Licence Button.", "Error",
                        JOptionPane.ERROR_MESSAGE);
            }
        } else if (e.getSource() == b1) {

            try {
                if (!(rs1.isFirst() == true)) {
                    if (rs1.previous()) {
                        
                        t1.setText(rs1.getString(1));
                        t2.setText(rs1.getString(2));
                        t3.setText(rs1.getString(3));
                        t4.setText(rs1.getString(4));
                        t5.setText(rs1.getString(5));
                        t6.setText(rs1.getString(6));
                        t7.setText(rs1.getString(7));
                        t15.setText(rs1.getString(8));
                    }
                } else {
                    JOptionPane.showMessageDialog(this, "No more record found.", "Error", JOptionPane.ERROR_MESSAGE);
                }

            } catch (Exception ese) {
            }

        }

        else if (e.getSource() == b2) {
            try {
                if (!(rs1.isLast() == true)) {
                    if (rs1.next()) {
                        t1.setText(rs1.getString(1));
                        t2.setText(rs1.getString(2));
                        t3.setText(rs1.getString(3));
                        t4.setText(rs1.getString(4));
                        t5.setText(rs1.getString(5));
                        t6.setText(rs1.getString(6));
                        t7.setText(rs1.getString(7));
                        t15.setText(rs1.getString(8));
                    }
                } else {
                    JOptionPane.showMessageDialog(this, "No more record found.", "Error", JOptionPane.ERROR_MESSAGE);
                }

            } catch (Exception ese) {
            }

        } else if (e.getSource() == b3) {
            new approvall().setVisible(true);
        } else if (e.getSource() == b4) {

            try {
                if (!(rs.isFirst() == true)) {
                    if (rs.previous()) {
                        t8.setText(rs.getString(1));
                        t9.setText(rs.getString(2));
                        t10.setText(rs.getString(3));
                        t11.setText(rs.getString(4));
                        t12.setText(rs.getString(5));
                        t13.setText(rs.getString(6));
                        t14.setText(rs.getString(7));
                        t16.setText(rs.getString(8));
                    }
                } else {
                    JOptionPane.showMessageDialog(this, "No more record found.", "Error", JOptionPane.ERROR_MESSAGE);
                }
            } catch (Exception ese) {
            }

        } else if (e.getSource() == b5) {
            try {
                if (!(rs.isLast() == true)) {
                    if (rs.next()) {
                        t8.setText(rs.getString(1));
                        t9.setText(rs.getString(2));
                        t10.setText(rs.getString(3));
                        t11.setText(rs.getString(4));
                        t12.setText(rs.getString(5));
                        t13.setText(rs.getString(6));
                        t14.setText(rs.getString(7));
                        t16.setText(rs.getString(8));
                    }
                } else {
                    JOptionPane.showMessageDialog(this, "No more record found.", "Error", JOptionPane.ERROR_MESSAGE);
                }

            } catch (Exception ese) {
            }

        } else if (e.getSource() == b6) {
            new approvalsm().setVisible(true);
        }

        else if (e.getSource() == b7) {
            dispose();
        } else if (e.getSource() == renew) {
            new approvalrenew().setVisible(true);
        }

    }

    public void keyPressed(KeyEvent e) {
        System.out.print(e.getKeyCode());
        if (e.getKeyCode() == 10) {
            if (e.getSource() == tb1) {
                if (tb1.isSelected() == true) {

                } else {
                    JOptionPane.showMessageDialog(this, "Please Firstly Select Learner Licence Button.", "Error",
                            JOptionPane.ERROR_MESSAGE);
                }
            } else if (e.getSource() == tb2) {
                if (tb2.isSelected() == true) {

                    b4.requestFocus();
                } else {
                    JOptionPane.showMessageDialog(this, "Please Firstly Select Driving Licence Button.", "Error",
                            JOptionPane.ERROR_MESSAGE);

                }

            } else if (e.getSource() == b3) {
                dispose();
            }
        } else if (e.getKeyCode() == 39) {
            if (e.getSource() == tb1) {
                tb2.requestFocus();
            }
        } else if (e.getKeyCode() == 37) {
            if (e.getSource() == tb2) {
                tb1.requestFocus();
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

    

    public static void main(String c[]) {
        new approvaldl();
    }
}
