import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.sql.*;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.awt.image.BufferedImage;
import javax.imageio.ImageIO;
import java.io.*;

class nuser extends JFrame implements ActionListener, KeyListener {
    String staff = "ST00";
    Image img;
    String x, f;
    String extension = "";
    JLabel l, l1, l2, l3, l4, l5, l6;
    JTextField t1, t2, t3, t4;
    JPasswordField p1, p2;
    JButton b1, b2, b3, up;
    JPanel panel1 = new JPanel();
    JPanel panel2 = new JPanel();
    JPanel panel3 = new JPanel();
    JPanel p;
    
    nuser() {
        setTitle("New Staff Creation");
        setSize(800, 480);
        setResizable(false);
        setIconImage(Toolkit.getDefaultToolkit().getImage("hicon.png"));
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
        DateFormat df = new SimpleDateFormat("dd/MM/yyyy");
        Date date = new Date();
        l = new JLabel("CREATE NEW STAFF");
        l.setForeground(Color.white);
        l.setFont(new Font("Book Antiqua", Font.BOLD, 20));
        l1 = new JLabel("Date :");
        l1.setFont(new Font("Bookman Old Style", Font.PLAIN, 17));
        l2 = new JLabel("Staff Id :");
        l2.setFont(new Font("Bookman Old Style", Font.PLAIN, 17));
        l3 = new JLabel("Name :");
        l3.setFont(new Font("Bookman Old Style", Font.PLAIN, 17));
        l4 = new JLabel("Mobile Number :");
        l4.setFont(new Font("Bookman Old Style", Font.PLAIN, 17));
        l5 = new JLabel("New Password :");
        l5.setFont(new Font("Bookman Old Style", Font.PLAIN, 17));
        l6 = new JLabel("Confirm New Password :");
        l6.setFont(new Font("Bookman Old Style", Font.PLAIN, 17));
        p = new ppanel();
        panel3.setBorder(BorderFactory.createLineBorder(Color.black));
        t1 = new JTextField();
        t1.setText(df.format(date));
        t1.setFont(new Font("Bookman Old Style", Font.PLAIN, 14));
        t1.setEditable(false);
        t2 = new JTextField();
        t2.setFont(new Font("Bookman Old Style", Font.PLAIN, 14));
        t2.setEditable(false);
        t3 = new JTextField();
        t3.setFont(new Font("Bookman Old Style", Font.PLAIN, 14));
        t4 = new JTextField();
        t4.setFont(new Font("Bookman Old Style", Font.PLAIN, 14));
        p1 = new JPasswordField();
        p1.setFont(new Font("Bookman Old Style", Font.PLAIN, 14));
        p2 = new JPasswordField();
        p2.setFont(new Font("Bookman Old Style", Font.PLAIN, 14));
        b1 = new JButton("Submit");
        b2 = new JButton("Reset");
        b3 = new JButton("Cancel");
        b1.setFont(new Font("Bookman Old Style", Font.PLAIN, 14));
        b2.setFont(new Font("Bookman Old Style", Font.PLAIN, 14));
        b3.setFont(new Font("Bookman Old Style", Font.PLAIN, 14));
        up = new JButton("Upload");
        up.setFont(new Font("Bookman Old Style", Font.PLAIN, 14));
        panel1.setBounds(0, 0, 800, 60);
        l.setBounds(300, 15, 300, 30);
        panel2.setBounds(0, 60, 800, 330);
        l1.setBounds(50, 30, 150, 30);
        l2.setBounds(50, 80, 150, 30);
        l3.setBounds(50, 130, 150, 30);
        l4.setBounds(50, 180, 150, 30);
        l5.setBounds(50, 230, 150, 30);
        l6.setBounds(50, 280, 250, 30);
        t1.setBounds(255, 30, 250, 30);
        t2.setBounds(255, 80, 250, 30);
        t3.setBounds(255, 130, 250, 30);
        t4.setBounds(255, 180, 250, 30);
        p1.setBounds(255, 230, 250, 30);
        p2.setBounds(255, 280, 250, 30);
        panel3.setLayout(null);
        panel3.setBounds(540, 25, 210, 210);
        p.setBounds(5, 5, 200, 200);
        up.setBounds(550, 250, 190, 30);
        b1.setBounds(430, 405, 100, 30);
        b2.setBounds(540, 405, 100, 30);
        b3.setBounds(650, 405, 100, 30);
        add(b1);
        add(b2);
        add(b3);
        panel3.add(p);
        panel1.add(l);
        panel2.add(l1);
        panel2.add(t1);
        panel2.add(l2);
        panel2.add(t2);
        panel2.add(l3);
        panel2.add(t3);
        panel2.add(l4);
        panel2.add(t4);
        panel2.add(l5);
        panel2.add(p1);
        panel2.add(l6);
        panel2.add(p2);
        panel2.add(up);
        add(panel1);
        add(panel2);
        panel2.add(panel3);
        b1.addActionListener(this);
        b2.addActionListener(this);
        b3.addActionListener(this);
        b1.addKeyListener(this);
        b3.addKeyListener(this);
        b2.addKeyListener(this);
        t3.addKeyListener(this);
        t4.addKeyListener(this);
        p1.addKeyListener(this);
        p2.addKeyListener(this);
        up.addActionListener(this);
        up.addKeyListener(this);
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
                char car = e.getKeyChar();
                if ((car < '0') || (car > '9')) {
                    e.consume();
                }
                if (t4.getText().length() == 10) {
                    e.consume();
                }
            }
        });
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setVisible(true);
        
        try {
            Class.forName("oracle.jdbc.driver.OracleDriver");
            Connection c = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "system", "manish");
            Statement s = c.createStatement();
            ResultSet rs = s.executeQuery("select count(staffid) from nuser");
            if (rs.next()) {
                staff = staff + String.valueOf(Integer.valueOf(rs.getString(1)) + 1);
                t2.setText(staff);
            }
            c.close();
        } catch (Exception ec) {
        }
        t3.requestFocus();
    }

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == up) {
            String f = getImageFile();
            try {
                Integer ex = (x.lastIndexOf('.') + 1);
                for (int i = ex; i < (ex + 3); i++) {
                    extension = extension + (x.charAt(i));
                }
            } catch (Exception eddf) {
            }
            if (!(extension.equals("jpg") || extension.equals("gif") || extension.equals("png"))) {
                JOptionPane.showMessageDialog(this, "Please Upload 'jpg' or 'gif' or 'png' Format Image.", "Error",
                        JOptionPane.ERROR_MESSAGE);
            } else if (f != null) {
                try {
                    BufferedImage bimg = ImageIO.read(new File(f));
                    int width = bimg.getWidth();
                    int height = bimg.getHeight();
                    Toolkit kit = Toolkit.getDefaultToolkit();
                    img = kit.getImage(f);
                    img = img.getScaledInstance(200, 200, Image.SCALE_DEFAULT);
                } catch (Exception eeee) {
                }
                repaint();
                b1.requestFocus();
            }
            extension = "";
        } else if (e.getSource() == b1) {
            if ((t3.getText()).equals("") || (t3.getText()).equals(null)) {
                JOptionPane.showMessageDialog(this, "Please Enter Name.", "New Staff Creation",
                        JOptionPane.ERROR_MESSAGE);
                t3.requestFocus();
            } else if ((t4.getText()).equals("") || (t4.getText()).equals(null)) {
                JOptionPane.showMessageDialog(this, "Please Enter Mobile Number.", "New Staff Creation",
                        JOptionPane.ERROR_MESSAGE);
                t4.requestFocus();
            } else if ((t4.getText()).length() != 10) {
                JOptionPane.showMessageDialog(this, "Mobile Number must be 10 digits.", "New Staff Creation",
                        JOptionPane.ERROR_MESSAGE);
                t4.requestFocus();
            } else if ((p1.getPassword()).equals("") || (p1.getPassword()).equals(null)) {
                JOptionPane.showMessageDialog(this, "Please Enter New Password.", "New Staff Creation",
                        JOptionPane.ERROR_MESSAGE);
                p1.requestFocus();
            } else if ((p2.getPassword()).equals("") || (p2.getPassword()).equals(null)) {
                JOptionPane.showMessageDialog(this, "Please Enter Password.", "New Staff Creation",
                        JOptionPane.ERROR_MESSAGE);
                p2.requestFocus();
            } else if (img == null) {
                JOptionPane.showMessageDialog(this, "Please Upload Your Image.", "New Staff Creation",
                        JOptionPane.ERROR_MESSAGE);
                up.requestFocus();
            } else if ((String.valueOf(p1.getPassword())).equals(String.valueOf(p2.getPassword()))) {
                try {
                    Class.forName("oracle.jdbc.driver.OracleDriver");
                    Connection c = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "system",
                            "manish");
                    Statement s = c.createStatement();
                    s.executeQuery("INSERT INTO nuser VALUES('" + t1.getText() + "','" + t2.getText() + "','"
                            + t3.getText() + "','" + t4.getText() + "','" + p1.getPassword() + "','" + x + "')");
                    JOptionPane.showMessageDialog(this, "New User Created Successfully.", "Error",
                            JOptionPane.ERROR_MESSAGE);
                    c.close();
                } catch (Exception ec) {
                    JOptionPane.showMessageDialog(this, ec.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
                }
                dispose();
                int result = JOptionPane.showConfirmDialog(this, "Do You Want Login?", "Confirmation",
                        JOptionPane.YES_NO_OPTION);
                if (result == JOptionPane.YES_OPTION) {
                    new login();
                }
            } else {
                p2.setBackground(Color.red);
                JOptionPane.showMessageDialog(this, "Password Not Matched.", "Error", JOptionPane.ERROR_MESSAGE);
                p1.requestFocus();
                p1.setText("");
                p2.setText("");
                p2.setBackground(Color.white);
            }
        } else if (e.getSource() == b2) {
            t3.setText("");
            t4.setText("");
            p1.setText("");
            p2.setText("");
            t3.requestFocus();
            f = null;
            x = null;
            img = null;
            p.repaint();
        } else if (e.getSource() == b3) {
            dispose();
        }
    }

    public void keyPressed(KeyEvent e) {
        if (e.getKeyCode() == 10) {
            if (e.getSource() == t3) {
                if ((t3.getText()).equals("") || (t3.getText()).equals(null)) {
                    JOptionPane.showMessageDialog(this, "Please Enter Name.", "Join New Staff Creation",
                            JOptionPane.ERROR_MESSAGE);
                    t3.requestFocus();
                } else {
                    Toolkit.getDefaultToolkit().setLockingKeyState(KeyEvent.VK_CAPS_LOCK, false);
                    t4.requestFocus();
                }
            } else if (e.getSource() == t4) {
                if ((t4.getText()).equals("") || (t4.getText()).equals(null)) {
                    JOptionPane.showMessageDialog(this, "Please Enter Mobile Number.", "Join New Staff Creation",
                            JOptionPane.ERROR_MESSAGE);
                    t4.requestFocus();
                } else {
                    p1.requestFocus();
                }
            } else if (e.getSource() == p1) {
                if ((p1.getPassword()).equals("") || (p1.getPassword()).equals(null)) {
                    JOptionPane.showMessageDialog(this, "Please Enter New Password.", "Join New Staff Creation",
                            JOptionPane.ERROR_MESSAGE);
                    p1.requestFocus();
                } else {
                    p2.requestFocus();
                }
            } else if (e.getSource() == p2) {
                if ((p2.getPassword()).equals("") || (p2.getPassword()).equals(null)) {
                    JOptionPane.showMessageDialog(this, "Please Enter Password.", "Join New Staff Creation",
                            JOptionPane.ERROR_MESSAGE);
                    p2.requestFocus();
                } else {
                    up.requestFocus();
                }
            } else if (e.getSource() == b1) {
                if ((t3.getText()).equals("") || (t3.getText()).equals(null)) {
                    JOptionPane.showMessageDialog(this, "Please Enter Name.", "Join New Staff Creation",
                            JOptionPane.ERROR_MESSAGE);
                    t3.requestFocus();
                } else if ((t4.getText()).equals("") || (t4.getText()).equals(null)) {
                    JOptionPane.showMessageDialog(this, "Please Enter Mobile Number.", "Join New Staff Creation",
                            JOptionPane.ERROR_MESSAGE);
                    t4.requestFocus();
                } else if ((t4.getText()).length() != 10) {
                    JOptionPane.showMessageDialog(this, "Mobile Number must be 10 digits.", "New Staff Creation",
                            JOptionPane.ERROR_MESSAGE);
                    t4.requestFocus();
                } else if ((p1.getPassword()).equals("") || (p1.getPassword()).equals(null)) {
                    JOptionPane.showMessageDialog(this, "Please Enter New Password.", "Join New Staff Creation",
                            JOptionPane.ERROR_MESSAGE);
                    p1.requestFocus();
                } else if ((p2.getPassword()).equals("") || (p2.getPassword()).equals(null)) {
                    JOptionPane.showMessageDialog(this, "Please Enter Password.", "Join New Staff Creation",
                            JOptionPane.ERROR_MESSAGE);
                    p2.requestFocus();
                } else if (img == null) {
                    JOptionPane.showMessageDialog(this, "Please Upload Your Image.", "Join New Staff Creation",
                            JOptionPane.ERROR_MESSAGE);
                    up.requestFocus();
                } else if ((String.valueOf(p1.getPassword())).equals(String.valueOf(p2.getPassword()))) {
                    try {
                        Class.forName("oracle.jdbc.driver.OracleDriver");
                        Connection c = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "system",
                                "manish");
                        Statement s = c.createStatement();
                        s.executeQuery("INSERT INTO nuser VALUES('" + t1.getText() + "','" + t2.getText() + "','"
                                + t3.getText() + "','" + t4.getText() + "','" + p1.getPassword() + "','" + x + "')");
                        JOptionPane.showMessageDialog(this, "New User Created Successfully.", "Error",
                                JOptionPane.ERROR_MESSAGE);
                        c.close();
                    } catch (Exception ec) {
                        JOptionPane.showMessageDialog(this, ec.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
                    }
                    t3.setText("");
                    t4.setText("");
                    p1.setText("");
                    p2.setText("");
                    t3.requestFocus();
                    dispose();
                    int result = JOptionPane.showConfirmDialog(this, "Do You Want Login?", "Confirmation",
                            JOptionPane.YES_NO_OPTION);
                    if (result == JOptionPane.YES_OPTION) {
                        new login();
                    }
                } else {
                    p2.setBackground(Color.red);
                    JOptionPane.showMessageDialog(this, "Password Not Matched.", "Error", JOptionPane.ERROR_MESSAGE);
                    p1.requestFocus();
                    p1.setText("");
                    p2.setText("");
                    p2.setBackground(Color.white);
                }
            }
        }
    }

    public void keyTyped(KeyEvent e) {
        if (e.getSource() == t3) {
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
            x = ch.getSelectedFile().getPath();
            return x;
        } else {
            return null;
        }
    }

    private class ppanel extends JPanel {
        public void paint(Graphics g) {
            g.fillRect(0, 0, 200, 200);
            g.drawImage(img, 0, 0, this);

        }
    }

    

    public static void main(String c[]) {
        new nuser();
    }
}
