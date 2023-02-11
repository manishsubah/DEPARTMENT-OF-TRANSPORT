import java.sql.*;
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

class form2 extends JFrame implements ActionListener, KeyListener {
    JLabel l1, l2, l3, l4, l5, l6;
    JTextField t1, t2;
    JPasswordField p1, p2, p3;
    JButton b1, b2, b3;
    JPanel panel1 = new JPanel();
    JPanel panel2 = new JPanel();
    
    form2() {
        setTitle("Update Password");
        setSize(500, 450);
        setIconImage(Toolkit.getDefaultToolkit().getImage("hicon.png"));
        setResizable(false);
        setLocationRelativeTo(null);
        setLayout(null);
        
        try {
            UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel");
        } catch (Exception e) {
        }
        DateFormat df = new SimpleDateFormat("dd/MM/yyyy");
        Date date = new Date();
        panel2.setLayout(null);
        panel2.setBackground(Color.white);
        l1 = new JLabel("PASSWORD UPDATION BOX");
        l1.setFont(new Font("Book Antiqua", Font.BOLD, 20));
        l1.setForeground(Color.white);
        l2 = new JLabel("Enter Staff id :");
        l2.setFont(new Font("Bookman Old Style", Font.PLAIN, 17));
        l3 = new JLabel("Current Date :");
        l3.setFont(new Font("Bookman Old Style", Font.PLAIN, 17));
        l4 = new JLabel("Enter Old Password :");
        l4.setFont(new Font("Bookman Old Style", Font.PLAIN, 17));
        l5 = new JLabel("Enter New Password :");
        l5.setFont(new Font("Bookman Old Style", Font.PLAIN, 17));
        l6 = new JLabel("Conform New Password :");
        l6.setFont(new Font("Bookman Old Style", Font.PLAIN, 17));
        t1 = new JTextField();
        t1.setFont(new Font("Bookman Old Style", Font.PLAIN, 14));
        t2 = new JTextField();
        t2.setText(df.format(date));
        t2.setFont(new Font("Bookman Old Style", Font.PLAIN, 14));
        t2.setEditable(false);
        p1 = new JPasswordField();

        p2 = new JPasswordField();
        p3 = new JPasswordField();
        b1 = new JButton("Update");
        b2 = new JButton("Reset");
        b3 = new JButton("Cancel");
        panel1.setLayout(null);
        panel1.setBackground(Color.blue);
        panel1.setBounds(0, 0, 600, 75);
        panel2.setBounds(0, 75, 600, 270);
        l1.setBounds(110, 21, 350, 40);

        l3.setBounds(118, 30, 200, 30);
        l2.setBounds(120, 80, 200, 30);

        l4.setBounds(65, 130, 200, 30);
        l5.setBounds(60, 180, 200, 30);
        l6.setBounds(32, 230, 250, 30);
        t1.setBounds(300, 80, 150, 30);
        t2.setBounds(300, 30, 150, 30);
        p1.setBounds(300, 130, 150, 30);
        p2.setBounds(300, 180, 150, 30);
        p3.setBounds(300, 230, 150, 30);
        b1.setBounds(130, 360, 100, 30);
        b2.setBounds(240, 360, 100, 30);
        b3.setBounds(350, 360, 100, 30);
        add(panel1);
        panel1.add(l1);
        add(panel2);
        panel2.add(l2);
        panel2.add(l3);
        panel2.add(l4);
        panel2.add(l5);
        panel2.add(l6);
        panel2.add(t1);
        panel2.add(t2);
        panel2.add(p1);
        panel2.add(p2);
        panel2.add(p3);
        add(b1);
        add(b2);
        add(b3);
        b1.addActionListener(this);
        b1.addKeyListener(this);
        b2.addKeyListener(this);
        b3.addKeyListener(this);
        b2.addActionListener(this);
        b3.addActionListener(this);
        t1.addKeyListener(this);
        p1.addKeyListener(this);
        p2.addKeyListener(this);
        p3.addKeyListener(this);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        t1.addKeyListener(new KeyAdapter() {
            public void keyTyped(KeyEvent e) {
                char keyChar = e.getKeyChar();
                if (Character.isLowerCase(keyChar)) {
                    e.setKeyChar(Character.toUpperCase(keyChar));
                }
            }
        });
        setVisible(true);
        t1.requestFocus();

    }

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == b1) {
            if ((t1.getText()).equals("") || (t1.getText()).equals(null)) {
                JOptionPane.showMessageDialog(this, "Please enter a valid Staff Id.", "Password Updation Box",
                        JOptionPane.ERROR_MESSAGE);
                t1.requestFocus();
            } else if ((p1.getPassword()).equals("") || (p1.getPassword()).equals(null)) {
                JOptionPane.showMessageDialog(this, "Please enter a valid Password.", "Password Updation Box",
                        JOptionPane.ERROR_MESSAGE);
                p1.requestFocus();
            } else if ((p2.getPassword()).equals("") || (p2.getPassword()).equals(null)) {
                JOptionPane.showMessageDialog(this, "Please enter Password.", "Password Updation Box",
                        JOptionPane.ERROR_MESSAGE);
                p2.requestFocus();
            } else if ((p3.getPassword()).equals("") || (p3.getPassword()).equals(null)) {
                JOptionPane.showMessageDialog(this, "Please enter Password.", "Password Updation Box",
                        JOptionPane.ERROR_MESSAGE);
                p3.requestFocus();
            } else {
                String staff = "", pass = "";
                try {
                    Class.forName("oracle.jdbc.driver.OracleDriver");
                    Connection c = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "system",
                            "manish");
                    Statement s = c.createStatement();
                    ResultSet rs = s
                            .executeQuery("SELECT staffid,password from nuser where staffid='" + t1.getText() + "'");
                    if (rs.next()) {
                        staff = rs.getString(1);
                        pass = rs.getString(2);
                    }
                    c.close();
                } catch (Exception ec) {
                    JOptionPane.showMessageDialog(this, ec.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
                }

                if ((staff).equals(t1.getText()) && (pass).equals(p1.getPassword())) {
                    if ((String.valueOf(p2.getPassword())).equals(String.valueOf(p3.getPassword()))) {
                        try {
                            Class.forName("oracle.jdbc.driver.OracleDriver");
                            Connection c = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "system",
                                    "manish");
                            Statement s1 = c.createStatement();
                            s1.executeUpdate("UPDATE nuser SET password='" + String.valueOf(p2.getPassword())
                                    + "' WHERE staffid='" + t1.getText() + "'");
                            Statement s2 = c.createStatement();
                            s2.executeQuery("INSERT INTO passwordupdation VALUES('" + t1.getText() + "','"
                                    + t2.getText() + "','" + p1.getPassword() + "','" + p2.getPassword() + "')");

                        } catch (Exception exdd) {
                        }
                        JOptionPane.showMessageDialog(this, "Your Password is Updated Successfully.",
                                "Password Updation Box", JOptionPane.INFORMATION_MESSAGE);
                        t1.setText("");
                        p1.setText("");
                        p2.setText("");
                        p3.setText("");
                        t1.requestFocus();
                    } else {
                        p3.setBackground(Color.red);
                        JOptionPane.showMessageDialog(this, "Password Not Matched.", "Error",
                                JOptionPane.ERROR_MESSAGE);
                        p2.requestFocus();
                        p2.setText("");
                        p3.setText("");
                        p3.setBackground(Color.white);
                    }
                } else {
                    JOptionPane.showMessageDialog(this, "Your Staff Id or Old Password is not Valid.", "Error",
                            JOptionPane.ERROR_MESSAGE);
                    t1.setText("");
                    p1.setText("");
                    t1.requestFocus();
                }

            }
        } else if (e.getSource() == b2) {
            t1.setText("");
            p1.setText("");
            p2.setText("");
            p3.setText("");
            t1.requestFocus();
        } else if (e.getSource() == b3) {
            dispose();
        }

    }

    public void keyPressed(KeyEvent e) {
        System.out.println(e.getKeyCode());
        if (e.getKeyCode() == KeyEvent.VK_ENTER) {
            if (e.getSource() == t1) {
                if ((t1.getText()).equals("") || (t1.getText()).equals(null)) {
                    JOptionPane.showMessageDialog(this, "Please enter a valid Staff Id.", "Password Updation Box",
                            JOptionPane.ERROR_MESSAGE);
                    t1.requestFocus();
                } else {
                    try {
                        Class.forName("oracle.jdbc.driver.OracleDriver");
                        Connection c = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "system",
                                "manish");
                        // Connection c=DriverManager.getConnection("jdbc:odbc:dto","","");
                        Statement s = c.createStatement();
                        ResultSet rs = s.executeQuery("select staffid from nuser where staffid='" + t1.getText() + "'");
                        if (rs.next()) {
                            p1.requestFocus();
                        } else {
                            JOptionPane.showMessageDialog(this, "Please Enter a Valid Staff Id.", "Password Updation",
                                    JOptionPane.INFORMATION_MESSAGE);
                            t1.setText("");
                            t1.requestFocus();
                        }

                        c.close();
                    } catch (Exception ec) {
                    }
                }
            } else if (e.getSource() == p1) {
                if ((p1.getPassword()).equals("") || (p1.getPassword()).equals(null)) {
                    JOptionPane.showMessageDialog(this, "Please enter a valid Password.", "Password Updation Box",
                            JOptionPane.ERROR_MESSAGE);
                    p1.requestFocus();
                } else {
                    try {
                        Class.forName("oracle.jdbc.driver.OracleDriver");
                        Connection c = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "system",
                                "manish");
                        Statement s = c.createStatement();
                        ResultSet rs = s.executeQuery("select password from nuser where staffid='" + t1.getText()
                                + "' AND password='" + p1.getPassword() + "'");
                        if (rs.next()) {
                            p2.requestFocus();
                        } else {
                            JOptionPane.showMessageDialog(this, "Your Old Password is not Valid.", "Password Updation",
                                    JOptionPane.INFORMATION_MESSAGE);
                            p1.setText("");
                            p1.requestFocus();
                        }

                        c.close();
                    } catch (Exception ec) {
                    }

                }
            }

            else if (e.getSource() == p2) {
                if ((p2.getPassword()).equals("") || (p2.getPassword()).equals(null)) {
                    JOptionPane.showMessageDialog(this, "Please enter Password.", "Password Updation Box",
                            JOptionPane.ERROR_MESSAGE);
                    p2.requestFocus();
                } else {
                    p3.requestFocus();
                }
            } else if (e.getSource() == p3) {
                if ((p3.getPassword()).equals("") || (p3.getPassword()).equals(null)) {
                    JOptionPane.showMessageDialog(this, "Please enter Password.", "Password Updation Box",
                            JOptionPane.ERROR_MESSAGE);
                    p3.requestFocus();
                } else {
                    b1.requestFocus();
                }
            } else if (e.getSource() == b1) {
                if ((t1.getText()).equals("") || (t1.getText()).equals(null)) {
                    JOptionPane.showMessageDialog(this, "Please enter a valid Staff Id.", "Password Updation Box",
                            JOptionPane.ERROR_MESSAGE);
                    t1.requestFocus();
                } else if ((p1.getPassword()).equals("") || (p1.getPassword()).equals(null)) {
                    JOptionPane.showMessageDialog(this, "Please enter a valid Password.", "Password Updation Box",
                            JOptionPane.ERROR_MESSAGE);
                    p1.requestFocus();
                } else if ((p2.getPassword()).equals("") || (p2.getPassword()).equals(null)) {
                    JOptionPane.showMessageDialog(this, "Please enter Password.", "Password Updation Box",
                            JOptionPane.ERROR_MESSAGE);
                    p2.requestFocus();
                } else if ((p3.getPassword()).equals("") || (p3.getPassword()).equals(null)) {
                    JOptionPane.showMessageDialog(this, "Please enter Password.", "Password Updation Box",
                            JOptionPane.ERROR_MESSAGE);
                    p3.requestFocus();
                }
            } else if (e.getSource() == b2) {
                t1.setText("");
                p1.setText("");
                p2.setText("");
                p3.setText("");
                t1.requestFocus();
            }

        } else if (e.getKeyCode() == 27) {
            dispose();
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
        new form2();
    }
}
