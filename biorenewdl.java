import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.sql.*;
import java.io.*;
import java.io.File;
import java.awt.image.BufferedImage;
import javax.imageio.ImageIO;

class biorenewdl extends JFrame implements KeyListener, ActionListener {
    String applicantid = "AI10000";
    String extension = "", dlnumber = "", post1 = "";
    String file = "", file1 = "", file2 = "";
    JLabel l, l1, l2, l3, l4, l5, lp1, lp2, lp3;
    JTextField t1, t2;
    JPanel panel1 = new JPanel();
    JPanel panel2 = new JPanel();
    JPanel p1 = new JPanel();
    JPanel p2 = new JPanel();
    JPanel p3 = new JPanel();
    JPanel lp, lpp, lppp;
    String x = "";
    JButton b1, b2, b3, b4, b5, b6;
    Image img, img1, img2;

    biorenewdl() {
        setTitle("Biometrics");
        setSize(710, 610);
        setIconImage(Toolkit.getDefaultToolkit().getImage("images/hicon.png"));
        setResizable(false);
        setLocationRelativeTo(null);
        setLayout(null);
        try {
            UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel");
        } catch (Exception e) {
        }
        panel1.setLayout(null);
        panel2.setLayout(null);
        l = new JLabel("BIOMETRICS");
        l.setForeground(Color.white);
        l.setFont(new Font("Bookman Old Style", Font.BOLD, 20));
        lp = new ppanel();
        lpp = new pppanel();
        lppp = new ppppanel();
        lp2 = new JLabel();
        lp1 = new JLabel();
        lp3 = new JLabel();
        l1 = new JLabel("Applicant Id :");
        l1.setFont(new Font("Bookman Old Style", Font.PLAIN, 17));
        l2 = new JLabel("Driving License No. :");
        l2.setFont(new Font("Bookman Old Style", Font.PLAIN, 17));
        l3 = new JLabel("Photo");
        l3.setFont(new Font("Bookman Old Style", Font.PLAIN, 17));
        l4 = new JLabel("Signature");
        l4.setFont(new Font("Bookman Old Style", Font.PLAIN, 17));
        l5 = new JLabel("Thumb");
        l5.setFont(new Font("Bookman Old Style", Font.PLAIN, 17));
        t1 = new JTextField();
        t1.setFont(new Font("Bookman Old Style", Font.PLAIN, 17));
        t2 = new JTextField();
        t2.setFont(new Font("Bookman Old Style", Font.PLAIN, 17));
        b1 = new JButton("Upload");
        b2 = new JButton("Upload");
        b3 = new JButton("Upload");
        b4 = new JButton("Finish");
        b5 = new JButton("Refresh");
        b6 = new JButton("Cancel");
        b6.setEnabled(false);
        panel1.setBounds(0, 0, 750, 75);
        panel1.setBackground(Color.blue);
        panel2.setBounds(0, 75, 750, 450);
        l.setBounds(300, 25, 200, 30);
        l1.setBounds(50, 30, 150, 30);
        t1.setBounds(230, 30, 300, 30);
        l2.setBounds(50, 80, 200, 30);
        t2.setBounds(230, 80, 300, 30);
        l3.setBounds(50, 150, 140, 30);
        l3.setBorder(BorderFactory.createLineBorder(Color.black));

        try {
            l3.setHorizontalAlignment(0);
        } catch (Exception e) {
        }
        l4.setBounds(280, 150, 140, 30);
        l4.setBorder(BorderFactory.createLineBorder(Color.black));
        try {
            l4.setHorizontalAlignment(0);
        } catch (Exception e) {
        }
        l5.setBounds(500, 150, 140, 30);
        l5.setBorder(BorderFactory.createLineBorder(Color.black));
        try {
            l5.setHorizontalAlignment(0);
        } catch (Exception e) {
        }

        p1.setLayout(null);
        p1.setBounds(30, 200, 200, 200);
        p1.setBorder(BorderFactory.createLineBorder(Color.black));
        lp.setBounds(5, 5, 190, 190);
        lp.setToolTipText("The Size of Image must be less than or equals to 185 X 185 pixels");
        p1.add(lp);
        p2.setLayout(null);
        p2.setBounds(250, 200, 200, 200);
        p2.setBorder(BorderFactory.createLineBorder(Color.black));
        lpp.setBounds(5, 5, 190, 190);
        lpp.setToolTipText("The Size of Image must be less than or equals to 185 X 185 pixels");
        p2.add(lpp);
        lpp.setBorder(BorderFactory.createLineBorder(Color.black));

        p3.setLayout(null);
        p3.setBounds(470, 200, 200, 200);
        p3.setBorder(BorderFactory.createLineBorder(Color.black));
        lppp.setBounds(5, 5, 190, 190);
        lppp.setToolTipText("The Size of Image must be less than or equals to 185 X 185 pixels");
        p3.add(lppp);
        lppp.setBorder(BorderFactory.createLineBorder(Color.black));
        b1.setBounds(60, 410, 140, 30);
        b1.setFont(new Font("Times New Roman", Font.PLAIN, 15));
        b2.setBounds(280, 410, 140, 30);
        b2.setFont(new Font("Times New Roman", Font.PLAIN, 15));
        b3.setBounds(500, 410, 140, 30);
        b3.setFont(new Font("Times New Roman", Font.PLAIN, 15));
        
        b4.setBounds(455, 540, 100, 30);
        b6.setBounds(565, 540, 100, 30);

        add(panel1);
        add(panel2);
        panel2.setBackground(Color.white);
        panel1.add(l);
        panel2.add(l1);
        panel2.add(t1);
        panel2.add(l2);
        panel2.add(t2);
        panel2.add(l3);
        panel2.add(p1);
        panel2.add(l4);
        panel2.add(p2);
        panel2.add(l5);
        panel2.add(p3);
        panel2.add(b1);
        panel2.add(b2);
        panel2.add(b3);
        
        add(b4);
        add(b6);
        b1.addActionListener(this);
        b2.addActionListener(this);
        b3.addActionListener(this);
        b1.addKeyListener(this);
        b2.addKeyListener(this);
        b3.addKeyListener(this);
        b4.addActionListener(this);
        b5.addActionListener(this);
        b6.addActionListener(this);
        b4.addKeyListener(this);
        b5.addKeyListener(this);
        b6.addKeyListener(this);
        setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
        setVisible(true);
        
        try {
            Class.forName("oracle.jdbc.driver.OracleDriver");
            Connection c = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "system", "manish");
            
            Statement s = c.createStatement();
            ResultSet rs = s.executeQuery(
                    "select applicantid from feeappdl WHERE feeoption='Renewal-Smart Card/Driving Licence' ORDER BY applicantid");
            while (rs.next()) {
                applicantid = rs.getString(1);
            }
            c.close();
        } catch (Exception ec) {
        }

        b4.requestFocus();

    }

    // --------------------------------------------------------------------------------------------------------------------------------------------------

    biorenewdl(String x1, String x2, String x3, String app, String dl) {
        setTitle("Biometrics");
        setSize(710, 610);
        setIconImage(Toolkit.getDefaultToolkit().getImage("images/hicon.png"));

        setResizable(false);
        setLocationRelativeTo(null);
        setLayout(null);
        try {
            UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel");
        } catch (Exception e) {
        }
        panel1.setLayout(null);
        panel2.setLayout(null);
        l = new JLabel("BIOMETRICS");
        l.setForeground(Color.white);
        l.setFont(new Font("Bookman Old Style", Font.BOLD, 20));
        lp = new ppanel();
        lpp = new pppanel();
        lppp = new ppppanel();
        lp2 = new JLabel();
        lp1 = new JLabel();
        lp3 = new JLabel();
        l1 = new JLabel("Applicant Id :");
        l1.setFont(new Font("Bookman Old Style", Font.PLAIN, 17));
        l2 = new JLabel("Driving License No. :");
        l2.setFont(new Font("Bookman Old Style", Font.PLAIN, 17));
        l3 = new JLabel("Photo");
        l3.setFont(new Font("Bookman Old Style", Font.PLAIN, 17));
        l4 = new JLabel("Signature");
        l4.setFont(new Font("Bookman Old Style", Font.PLAIN, 17));
        l5 = new JLabel("Thumb");
        l5.setFont(new Font("Bookman Old Style", Font.PLAIN, 17));
        t1 = new JTextField();
        t1.setFont(new Font("Bookman Old Style", Font.PLAIN, 17));
        t2 = new JTextField();
        t2.setFont(new Font("Bookman Old Style", Font.PLAIN, 17));
        b1 = new JButton("Upload");
        b2 = new JButton("Upload");
        b3 = new JButton("Upload");
        b4 = new JButton("Finish");
        b5 = new JButton("Refresh");
        b6 = new JButton("Cancel");
        b6.setEnabled(false);
        panel1.setBounds(0, 0, 750, 75);
        panel1.setBackground(Color.blue);
        panel2.setBounds(0, 75, 750, 450);
        l.setBounds(300, 25, 200, 30);
        l1.setBounds(50, 30, 150, 30);
        t1.setBounds(230, 30, 300, 30);
        l2.setBounds(50, 80, 200, 30);
        t2.setBounds(230, 80, 300, 30);
        l3.setBounds(50, 150, 140, 30);
        l3.setBorder(BorderFactory.createLineBorder(Color.black));

        try {
            l3.setHorizontalAlignment(0);
        } catch (Exception e) {
        }
        l4.setBounds(280, 150, 140, 30);
        l4.setBorder(BorderFactory.createLineBorder(Color.black));
        try {
            l4.setHorizontalAlignment(0);
        } catch (Exception e) {
        }
        l5.setBounds(500, 150, 140, 30);
        l5.setBorder(BorderFactory.createLineBorder(Color.black));
        try {
            l5.setHorizontalAlignment(0);
        } catch (Exception e) {
        }

        p1.setLayout(null);
        p1.setBounds(30, 200, 200, 200);
        p1.setBorder(BorderFactory.createLineBorder(Color.black));
        lp.setBounds(5, 5, 190, 190);
        lp.setToolTipText("The Size of Image must be less than or equals to 185 X 185 pixels");
        p1.add(lp);
        p2.setLayout(null);
        p2.setBounds(250, 200, 200, 200);
        p2.setBorder(BorderFactory.createLineBorder(Color.black));
        lpp.setBounds(5, 5, 190, 190);
        lpp.setToolTipText("The Size of Image must be less than or equals to 185 X 185 pixels");
        p2.add(lpp);
        lpp.setBorder(BorderFactory.createLineBorder(Color.black));

        p3.setLayout(null);
        p3.setBounds(470, 200, 200, 200);
        p3.setBorder(BorderFactory.createLineBorder(Color.black));
        lppp.setBounds(5, 5, 190, 190);
        lppp.setToolTipText("The Size of Image must be less than or equals to 185 X 185 pixels");
        p3.add(lppp);
        lppp.setBorder(BorderFactory.createLineBorder(Color.black));
        b1.setBounds(60, 410, 140, 30);
        b1.setFont(new Font("Times New Roman", Font.PLAIN, 15));
        b2.setBounds(280, 410, 140, 30);
        b2.setFont(new Font("Times New Roman", Font.PLAIN, 15));
        b3.setBounds(500, 410, 140, 30);
        b3.setFont(new Font("Times New Roman", Font.PLAIN, 15));
        b4.setBounds(455, 540, 100, 30);
        b6.setBounds(565, 540, 100, 30);

        add(panel1);
        add(panel2);
        panel2.setBackground(Color.white);
        panel1.add(l);
        panel2.add(l1);
        panel2.add(t1);
        panel2.add(l2);
        panel2.add(t2);
        panel2.add(l3);
        panel2.add(p1);
        panel2.add(l4);
        panel2.add(p2);
        panel2.add(l5);
        panel2.add(p3);
        panel2.add(b1);
        panel2.add(b2);
        panel2.add(b3);
        add(b4);
        add(b6);
        b1.addActionListener(this);
        b2.addActionListener(this);
        b3.addActionListener(this);
        b1.addKeyListener(this);
        b2.addKeyListener(this);
        b3.addKeyListener(this);
        b4.addActionListener(this);
        b5.addActionListener(this);
        b6.addActionListener(this);
        b4.addKeyListener(this);
        b5.addKeyListener(this);
        b6.addKeyListener(this);
        setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
        setVisible(true);
        
        try {
            Class.forName("oracle.jdbc.driver.OracleDriver");
            Connection c = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "system", "manish");
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
            Statement s = c.createStatement();
            ResultSet rs1 = s.executeQuery(
                    "select photoaddress,signatureaddress,thumbaddress,dlnumber from drivinglicense where applicantid='"
                            + applicantid + "'");
            if (rs1.next()) {
                file = rs1.getString(1);
                file1 = rs1.getString(2);
                file2 = rs1.getString(3);
                dlnumber = rs1.getString(4);
            }
            c.close();
        } catch (Exception ec) {
        }

        t2.setText(dlnumber);
        b4.requestFocus();

        try {
            Toolkit kit = Toolkit.getDefaultToolkit();
            img = kit.getImage(x1);
            img = img.getScaledInstance(185, 185, Image.SCALE_DEFAULT);

            img1 = kit.getImage(x2);
            img2 = kit.getImage(x3);
        } catch (Exception exp) {
        }
        t1.setText(app);
        t2.setText(dl);
    }

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == b1) {
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
                    if (width > 185 || height > 185) {
                        Toolkit kit = Toolkit.getDefaultToolkit();
                        img = kit.getImage(f);
                        img = img.getScaledInstance(185, 185, Image.SCALE_DEFAULT);

                    } else {
                        Toolkit kit = Toolkit.getDefaultToolkit();
                        img = kit.getImage(f);
                    }
                } catch (Exception eeee) {
                }

                repaint();
                b2.requestFocus();
            }
            try {
                Class.forName("oracle.jdbc.driver.OracleDriver");
                Connection c = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "system", "manish");
                Statement s = c.createStatement();
                s.executeUpdate("UPDATE drivinglicense SET photoaddress='" + x + "' where dlnumber='" + t2.getText()
                        + "' AND applicantid='" + t1.getText() + "' ");
                c.close();
            } catch (Exception ec) {
                JOptionPane.showMessageDialog(this, ec.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            }
            extension = "";
        }
        if (e.getSource() == b2) {
            String f = getImageFile();
            try {
                Integer ex = (x.lastIndexOf('.') + 1);

                for (int i = ex; i < (ex + 3); i++) {
                    extension = extension + (x.charAt(i));
                }
                // System.out.println(x.charAt(30));
            } catch (Exception edfds) {
            }
            if (!(extension.equals("jpg") || extension.equals("gif") || extension.equals("png"))) {
                JOptionPane.showMessageDialog(this, "Please Upload 'jpg' or 'gif' or 'png' Format Image.", "Error",
                        JOptionPane.ERROR_MESSAGE);
            } else if (f != null) {
                Toolkit kit = Toolkit.getDefaultToolkit();
                img1 = kit.getImage(f);
                repaint();
                b3.requestFocus();
            }
            try {
                Class.forName("oracle.jdbc.driver.OracleDriver");
                Connection c = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "system", "manish");
                Statement s = c.createStatement();
                s.executeUpdate("UPDATE drivinglicense SET signatureaddress='" + x + "' WHERE dlnumber='" + t2.getText()
                        + "' AND applicantid='" + t1.getText() + "' ");
                c.close();
            } catch (Exception ec) {
                JOptionPane.showMessageDialog(this, ec.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            }
            extension = "";
        }
        if (e.getSource() == b3) {
            String f = getImageFile();
            try {
                Integer ex = (x.lastIndexOf('.') + 1);

                for (int i = ex; i < (ex + 3); i++) {
                    extension = extension + (x.charAt(i));
                }
            } catch (Exception edfdsss) {
            }
            if (!(extension.equals("jpg") || extension.equals("gif") || extension.equals("png"))) {
                JOptionPane.showMessageDialog(this, "Please Upload 'jpg' or 'gif' or 'png' Format Image.", "Error",
                        JOptionPane.ERROR_MESSAGE);
            } else if (f != null) {
                Toolkit kit = Toolkit.getDefaultToolkit();
                img2 = kit.getImage(f);
                repaint();
                b4.requestFocus();
            }
            try {
                Class.forName("oracle.jdbc.driver.OracleDriver");
                Connection c = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "system", "manish");
                Statement s = c.createStatement();
                s.executeUpdate("UPDATE drivinglicense SET thumbaddress='" + x + "' WHERE dlnumber='" + t2.getText()
                        + "' AND applicantid='" + t1.getText() + "' ");
                c.close();
            } catch (Exception ec) {
                JOptionPane.showMessageDialog(this, ec.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            }
            extension = "";
        }
        if (e.getSource() == b4) {
            if (img == null) {
                JOptionPane.showMessageDialog(this, "Please Upload Image of Photo.", "Biometrics",
                        JOptionPane.ERROR_MESSAGE);
                b1.requestFocus();
            } else if (img1 == null) {
                JOptionPane.showMessageDialog(this, "Please Upload Image of Signature.", "Biometrics",
                        JOptionPane.ERROR_MESSAGE);
                b2.requestFocus();
            } else if (img2 == null) {
                JOptionPane.showMessageDialog(this, "Please Upload Image of Thumb.", "Biometrics",
                        JOptionPane.ERROR_MESSAGE);
                b3.requestFocus();
            } else {
                post1 = t1.getText();
                System.out.print(post1);
                new renewform(post1);
                dispose();

            }

        }

        if (e.getSource() == b5) {
            String sql = "";
            t1.setText("");
            t2.setText("");
            try {
                Class.forName("oracle.jdbc.driver.OracleDriver");
                Connection c = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "system", "manish");
                Statement s = c.createStatement();
                sql = "Select photoaddress from biodl";
                ResultSet rs = s.executeQuery(sql);
                if (rs.next()) {
                    JOptionPane.showMessageDialog(this, "Successfully Connected To Database.", "DTO-CHAPRA",
                            JOptionPane.INFORMATION_MESSAGE);
                    file = rs.getString(1);
                    System.out.print(File.separator);
                }

                c.close();
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(this, ex.getMessage(), "", JOptionPane.INFORMATION_MESSAGE);
            }
            try {
                Toolkit kit = Toolkit.getDefaultToolkit();
                img = kit.getImage(file);
            } catch (Exception exp) {
                System.out.print(exp.getMessage());
            }
            repaint();
        }
        if (e.getSource() == b6) {
            dispose();
        }
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

    private class pppanel extends JPanel {
        public void paint(Graphics g) {
            g.fillRect(0, 0, 200, 200);
            g.drawImage(img1, 0, 0, this);
        }
    }

    private class ppppanel extends JPanel {
        public void paint(Graphics g) {
            g.fillRect(0, 0, 200, 200);
            g.drawImage(img2, 0, 0, this);
        }
    }

    public void keyPressed(KeyEvent e) {
        if (e.getKeyCode() == 10) {
        }
    }

    public void keyTyped(KeyEvent e) {
    }

    public void keyReleased(KeyEvent e) {
    }

    public static void main(String c[]) {
        new biorenewdl();

    }
}
