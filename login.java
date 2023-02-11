import java.awt.*;
import java.sql.*;
import javax.swing.*;
import java.awt.event.*;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.io.*;
import java.awt.image.BufferedImage;
import javax.imageio.ImageIO;

class login implements ActionListener, KeyListener {

    String file = "";
    JPanel p1 = new JPanel();
    JDialog dialog = new JDialog((JFrame) null, "Staff - LogIn", true);

    JButton newuser = new JButton("Create New User");
    JLabel labeldate = new JLabel("Date :");
    JLabel labelstaff = new JLabel("Staff Id :");
    JLabel labelname = new JLabel("Enter User Name :");
    JLabel labelpassword = new JLabel("Enter Password :");
    JTextField textfieldstaff = new JTextField();

    JTextField textfielddate = new JTextField();
    JTextField textfieldname = new JTextField();
    JPasswordField textfieldpassword = new JPasswordField();

    JButton dbuttonok = new JButton("Ok");
    JButton dbuttoncancel = new JButton("Cancel");
    JPanel panel3 = new JPanel();
    Image img;
    JLabel lphoto;
    String x = "";
    String sql = "";

    login() {

        dialog.setTitle("User/Staff LogIn");

        textfieldstaff.setFont(new Font("Bookman Old Style", Font.PLAIN, 15));

        textfielddate.setFont(new Font("Bookman Old Style", Font.PLAIN, 15));

        textfieldname.setFont(new Font("Bookman Old Style", Font.PLAIN, 15));

        textfielddate.setEditable(false);
        textfielddate.setBackground(Color.white);
        textfielddate.setForeground(Color.black);
        DateFormat df = new SimpleDateFormat("dd/MM/yyyy");
        Date date = new Date();
        panel3.setBackground(Color.white);
        panel3.setLayout(null);
        lphoto = new JLabel();
        panel3.setLayout(null);
        panel3.setBorder(BorderFactory.createLineBorder(Color.black));
        lphoto.setBounds(415, 30, 170, 173);
        // ---------------------------------------------------------------------------------------
        labeldate.setFont(new Font("Bookman Old Style", Font.PLAIN, 15));
        labelstaff.setFont(new Font("Bookman Old Style", Font.PLAIN, 15));
        labelname.setFont(new Font("Bookman Old Style", Font.PLAIN, 15));
        labelpassword.setFont(new Font("Bookman Old Style", Font.PLAIN, 15));

        textfieldname.addKeyListener(new KeyAdapter() {
            public void keyTyped(KeyEvent e) {
                char keyChar = e.getKeyChar();
                if (Character.isLowerCase(keyChar)) {
                    e.setKeyChar(Character.toUpperCase(keyChar));
                }
            }
        });

        dialog.setResizable(false);
        dialog.setLocation(400, 200);

        dialog.setLayout(null);
        labeldate.setBounds(30, 30, 100, 30);
        labelstaff.setBounds(30, 80, 100, 30);
        labelname.setBounds(30, 130, 200, 30);
        labelpassword.setBounds(30, 180, 200, 30);
        textfielddate.setBounds(200, 30, 200, 30);
        textfielddate.setText(df.format(date));
        textfieldstaff.setBounds(200, 80, 200, 30);
        textfieldname.setBounds(200, 130, 200, 30);
        textfieldpassword.setBounds(200, 180, 200, 30);
        dbuttonok.setBounds(190, 235, 100, 30);
        dbuttoncancel.setBounds(310, 235, 100, 30);
        newuser.setBounds(460, 255, 130, 20);

        dialog.add(textfieldstaff);
        dialog.add(labelstaff);
        dialog.add(labeldate);
        dialog.add(labelname);
        dialog.add(labelpassword);

        dialog.add(textfielddate);

        dialog.add(textfieldname);
        dialog.add(textfieldpassword);
        dialog.add(lphoto);
        dialog.add(dbuttonok);
        dialog.add(dbuttoncancel);
        dialog.add(newuser);
        p1.setBackground(Color.blue);
        p1.setBounds(12, 220, 570, 3);
        dialog.add(p1);

        dbuttonok.addActionListener(this);
        dbuttoncancel.addActionListener(this);
        dbuttonok.addKeyListener(this);
        dbuttoncancel.addKeyListener(this);
        newuser.addActionListener(this);

        dialog.setDefaultCloseOperation(dialog.DO_NOTHING_ON_CLOSE);
        dialog.setSize(600, 305);
        textfieldname.addKeyListener(this);
        textfieldpassword.addKeyListener(this);
        textfieldstaff.addKeyListener(this);
        textfieldstaff.addKeyListener(new KeyAdapter() {
            public void keyTyped(KeyEvent e) {
                char keyChar = e.getKeyChar();
                if (Character.isLowerCase(keyChar)) {
                    e.setKeyChar(Character.toUpperCase(keyChar));
                }
            }
        });
        textfieldstaff.requestFocus();
        dialog.setVisible(true);

    }

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == dbuttonok) {
            System.out.print(labelname.getText());
            if ((textfieldstaff.getText()).equals("") || textfieldstaff.getText().equals(null)) {
                JOptionPane.showMessageDialog(dialog, "Please Enter Staff id.", "Staff-LogIn",
                        JOptionPane.ERROR_MESSAGE);
                textfieldstaff.requestFocus();
            } else if ((textfieldname.getText()).equals("") || textfieldname.getText().equals(null)) {
                JOptionPane.showMessageDialog(dialog, "Please Enter Your Name.", "Staff-LogIn",
                        JOptionPane.ERROR_MESSAGE);
                textfieldname.requestFocus();
            } else if ((textfieldpassword.getPassword()).equals("") || textfieldpassword.getPassword().equals(null)) {
                JOptionPane.showMessageDialog(dialog, "Please Enter Password/Security Code.", "Staff-LogIn",
                        JOptionPane.ERROR_MESSAGE);
                textfieldpassword.requestFocus();
            } else {
                try {
                    Class.forName("oracle.jdbc.driver.OracleDriver");
                    Connection c = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "system",
                            "manish");
                    Statement s = c.createStatement();
                    String sql = "Select staffid,name,password from nuser WHERE staffid='" + textfieldstaff.getText()
                            + "'";

                    ResultSet rs = s.executeQuery(sql);
                    if (rs.next()) {
                        if ((textfieldstaff.getText()).equals(rs.getString("staffid"))
                                && (textfieldname.getText()).equals(rs.getString("name"))
                                && (String.valueOf(textfieldpassword.getPassword())).equals(rs.getString("password"))) {
                            JOptionPane.showMessageDialog(dialog, "Successful.", "", JOptionPane.INFORMATION_MESSAGE);
                            try {
                                Class.forName("oracle.jdbc.driver.OracleDriver");
                                Connection cc = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe",
                                        "system", "manish");
                                Statement ss = cc.createStatement();
                                String sql1 = ("INSERT INTO login (ldate,staffid,staffusername) VALUES('"
                                        + textfielddate.getText() + "','" + textfieldstaff.getText() + "','"
                                        + textfieldname.getText() + "')");
                                ss.executeUpdate(sql1);
                            } catch (Exception eee) {
                            }
                            try {
                                new home(textfieldname.getText(), textfieldstaff.getText());
                                dialog.dispose();
                            } catch (Exception eeee) {
                            }

                        }
                    } else {
                        JOptionPane.showMessageDialog(dialog, "Not a Valid Staffid,User Name or Password.", "",
                                JOptionPane.INFORMATION_MESSAGE);
                        textfieldname.setText("");
                        textfieldpassword.setText("");
                        textfieldname.requestFocus();

                    }
                    c.close();
                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(dialog, ex.getMessage(), "", JOptionPane.INFORMATION_MESSAGE);
                }
            }

        } else if (e.getSource() == dbuttoncancel) {
            dialog.dispose();

        }

        else if (e.getSource() == newuser) {
            dialog.dispose();
            new nuser();

        }

    }

    public void keyPressed(KeyEvent e) {
        if (e.getKeyCode() == 27) {
            dialog.dispose();
        }

        if (e.getKeyCode() == 10) {
            if (e.getSource() == textfieldname) {
                if ((textfieldname.getText()).equals("") || textfieldname.getText().equals(null)) {
                    JOptionPane.showMessageDialog(dialog, "Please Enter Your Name.", "Staff-LogIn",
                            JOptionPane.ERROR_MESSAGE);
                    textfieldname.requestFocus();
                } else {
                    textfieldpassword.requestFocus();
                }
            } else if (e.getSource() == textfieldpassword) {
                if ((textfieldpassword.getPassword()).equals("") || textfieldpassword.getPassword().equals(null)) {
                    JOptionPane.showMessageDialog(dialog, "Please Enter Password/Security Code.", "Staff-LogIn",
                            JOptionPane.ERROR_MESSAGE);
                    textfieldpassword.requestFocus();
                } else {
                    dbuttonok.requestFocus();
                }
            } else if (e.getSource() == textfieldstaff) {
                if ((textfieldstaff.getText()).equals("") || textfieldstaff.getText().equals(null)) {
                    JOptionPane.showMessageDialog(dialog, "Please Enter Staff id.", "Staff-LogIn",
                            JOptionPane.ERROR_MESSAGE);
                    textfieldstaff.requestFocus();
                } else {
                    try {
                        Class.forName("oracle.jdbc.driver.OracleDriver");
                        Connection c = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "system",
                                "manish");
                        Statement s = c.createStatement();
                        String sql = "Select staffid,photoaddress from nuser WHERE staffid='" + textfieldstaff.getText()
                                + "'";
                        ResultSet rs = s.executeQuery(sql);
                        if (rs.next()) {
                            if (rs.getString("staffid").equals(textfieldstaff.getText())) {
                                file = rs.getString("photoaddress");

                                textfieldname.requestFocus();
                            }
                        } else {
                            JOptionPane.showMessageDialog(dialog, "Not a valid Staff Id.", "DTO-CHAPRA",
                                    JOptionPane.INFORMATION_MESSAGE);
                            textfieldstaff.setText("");
                            textfieldstaff.requestFocus();
                        }
                        c.close();
                    } catch (Exception ex) {
                        JOptionPane.showMessageDialog(dialog, ex.getMessage(), "", JOptionPane.INFORMATION_MESSAGE);
                    }
                    try {
                        BufferedImage bimg = ImageIO.read(new File(file));
                        int width = bimg.getWidth();
                        int height = bimg.getHeight();
                        if (width > 165 || height > 165) {
                            Toolkit kit = Toolkit.getDefaultToolkit();
                            img = kit.getImage(file);
                            img = img.getScaledInstance(165, 165, Image.SCALE_DEFAULT);
                            lphoto.setSize(165, 165);
                            lphoto.setIcon(new ImageIcon(img));
                            lphoto.setBorder(BorderFactory.createLineBorder(Color.black));
                        } else {
                            Toolkit kit = Toolkit.getDefaultToolkit();
                            img = kit.getImage(file);
                            lphoto.setSize(width, height);
                            lphoto.setIcon(new ImageIcon(img));
                            lphoto.setBorder(BorderFactory.createLineBorder(Color.black));
                        }
                    } catch (Exception exp) {
                        JOptionPane.showMessageDialog(dialog, "Must be create a new Staff id.", "",
                                JOptionPane.INFORMATION_MESSAGE);

                    }
                    
                }
            } else if (e.getSource() == dbuttonok) {
                try {
                    Class.forName("oracle.jdbc.driver.OracleDriver");
                    Connection c = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "system",
                            "manish");
                    Statement s = c.createStatement();
                    String sql = "Select staffid,photoaddress from nuser WHERE staffid='" + textfieldstaff.getText()
                            + "'";
                    ResultSet rs = s.executeQuery(sql);
                    if (rs.next()) {
                        if (rs.getString("staffid").equals(textfieldstaff.getText())) {
                            file = rs.getString("photoaddress");

                            textfieldname.requestFocus();
                        }
                    } else {
                        JOptionPane.showMessageDialog(dialog, "Not a valid Staff Id.", "DTO-CHAPRA",
                                JOptionPane.INFORMATION_MESSAGE);
                        textfieldstaff.setText("");
                        textfieldstaff.requestFocus();
                    }
                    c.close();
                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(dialog, ex.getMessage(), "", JOptionPane.INFORMATION_MESSAGE);
                }
                try {
                    Toolkit kit = Toolkit.getDefaultToolkit();
                    img = kit.getImage(file);
                } catch (Exception exp) {
                    System.out.print(exp.getMessage());
                }
                dialog.repaint();
                if ((textfieldstaff.getText()).equals("") || textfieldstaff.getText().equals(null)) {
                    JOptionPane.showMessageDialog(dialog, "Please Enter Staff id.", "Staff-LogIn",
                            JOptionPane.ERROR_MESSAGE);
                    textfieldstaff.requestFocus();
                } else if ((textfieldname.getText()).equals("") || textfieldname.getText().equals(null)) {
                    JOptionPane.showMessageDialog(dialog, "Please Enter Your Name.", "Staff-LogIn",
                            JOptionPane.ERROR_MESSAGE);
                    textfieldname.requestFocus();
                } else if ((textfieldpassword.getPassword()).equals("") || textfieldpassword.getPassword().equals(null)) {
                    JOptionPane.showMessageDialog(dialog, "Please Enter Password/Security Code.", "Staff-LogIn",
                            JOptionPane.ERROR_MESSAGE);
                    textfieldpassword.requestFocus();
                } else {
                    try {
                        Class.forName("oracle.jdbc.driver.OracleDriver");
                        Connection c = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "system",
                                "manish");
                        // Connection c=DriverManager.getConnection("jdbc:odbc:dto","","");
                        Statement s = c.createStatement();
                        String sql = "Select staffid,name,password from nuser WHERE staffid='"
                                + textfieldstaff.getText() + "'";
                        ResultSet rs = s.executeQuery(sql);
                        if (rs.next()) {
                            if ((textfieldstaff.getText()).equals(rs.getString("staffid"))
                                    && (textfieldname.getText()).equals(rs.getString("name"))
                                    && (String.valueOf(textfieldpassword.getPassword())).equals(rs.getString("password"))) {
                                JOptionPane.showMessageDialog(dialog, "Successful.", "",
                                        JOptionPane.INFORMATION_MESSAGE);
                                try {

                                    Class.forName("oracle.jdbc.driver.OracleDriver");
                                    Connection cc = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe",
                                            "system", "manish");
                                    // Connection cc=DriverManager.getConnection("jdbc:odbc:dto","","");
                                    Statement ss = cc.createStatement();
                                    String sql1 = ("INSERT INTO login (ldate,staffid,staffusername) VALUES('"
                                            + textfielddate.getText() + "','" + textfieldstaff.getText() + "','"
                                            + textfieldname.getText() + "')");
                                    ss.executeUpdate(sql1);
                                } catch (Exception eee) {
                                }
                                new home(textfieldname.getText(), textfieldstaff.getText());
                                dialog.dispose();
                            } else {
                                JOptionPane.showMessageDialog(dialog, "Not a Valid Staffid,User Name or Password.", "",
                                        JOptionPane.INFORMATION_MESSAGE);
                                textfieldname.setText("");
                                textfieldpassword.setText("");
                                textfieldname.requestFocus();
                            }
                        }
                        c.close();
                    } catch (Exception ex) {
                        JOptionPane.showMessageDialog(dialog, ex.getMessage(), "", JOptionPane.INFORMATION_MESSAGE);
                    }
                }
            } else if (e.getSource() == dbuttoncancel) {
                dialog.dispose();
                
            }

        }
    }

    public void keyTyped(KeyEvent e) {
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

    private class ppanel extends JPanel {
        public void paint(Graphics g) {
            g.drawImage(img, 0, 0, dialog);

        }
    }

    public static void main(String c[]) {

        login f = new login();

    }
}
