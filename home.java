import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.sql.*;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.io.*;
import java.awt.image.BufferedImage;
import javax.imageio.ImageIO;
import java.awt.Color;

class home extends JFrame implements ActionListener, KeyListener {
    Color color;
    String userid = "";
    JToggleButton tb1;
    JButton b2, b3, b4, b5, b6, b7;
    JToolBar tb = new JToolBar();
    JLabel l1, l2, user;
    JMenuBar mb;
    JMenu addmin, wf, app, search, report, h;
    JMenuItem li, ucreate, chpass, lo, feell, feedl, ap, sll, sdl, sapp, reportfee, reportll, reportdl, developer,
            master;
    JPanel panel1 = new JPanel();

    String y1 = "", y2 = "";

    home() {
        setTitle("Login-Menu Screen  Connected with Server : DTO");
        setSize(1300, 700);
        setResizable(false);
        setIconImage(Toolkit.getDefaultToolkit().getImage("images/hicon.png"));
        setLocationRelativeTo(null);
        setLayout(null);
        panel1.setLayout(null);
        panel1.setBorder(BorderFactory.createLineBorder(Color.black));
        panel1.setBackground(Color.white);

        mb = new JMenuBar();
        addmin = new JMenu("Administrator");
        addmin.addSeparator();
        wf = new JMenu("WorkFlow");
        wf.addSeparator();
        app = new JMenu("ALLApproval");
        app.addSeparator();
        search = new JMenu("Search");
        search.addSeparator();
        report = new JMenu("Report");
        report.addSeparator();
        h = new JMenu("Help");
        h.addSeparator();

        li = new JMenuItem("Background Color");
        ucreate = new JMenuItem("New Staff/User Creation");
        chpass = new JMenuItem("Change Password");
        lo = new JMenuItem("Log Out");

        feell = new JMenuItem("Fee-Payment for Learner Licence");
        feedl = new JMenuItem("Fee-Payment for Driving Licence");

        ap = new JMenuItem("Approval");

        sll = new JMenuItem("Learner Licence");
        sdl = new JMenuItem("Driving Licence");
        sapp = new JMenuItem("Application Status");

        reportfee = new JMenuItem("Fee-Report");
        reportll = new JMenuItem("LL-Report");
        reportdl = new JMenuItem("DL-Report");

        developer = new JMenuItem("About Developer");
        master = new JMenuItem("Master Administrator");

        addmin.add(master);
        addmin.add(ucreate);
        addmin.add(chpass);
        addmin.add(lo);

        wf.add(feell);
        wf.add(feedl);

        app.add(ap);

        search.add(sll);
        search.add(sdl);
        search.add(sapp);

        report.add(reportfee);
        report.add(reportll);
        report.add(reportdl);

        h.add(developer);
        h.add(li);
        user = new JLabel("User Name : ");
        user.setFont(new Font("Bookman Old Style", Font.PLAIN, 15));
        user.setBorder(BorderFactory.createLineBorder(Color.black));

        l2 = new JLabel("BR-841301-TRANSPORT DEPARTMENT SARAN");
        l2.setFont(new Font("Bookman Old Style", Font.BOLD, 20));

        l1 = new JLabel(new ImageIcon("images/transport.gif"));
        l1.setBounds(350, 50, 500, 200);
        l2.setBounds(340, 130, 1000, 200);
        panel1.add(l1);
        panel1.add(l2);

        mb.add(addmin);
        mb.add(wf);
        mb.add(app);
        mb.add(search);
        mb.add(report);
        mb.add(h);

        setJMenuBar(mb);

        panel1.setBounds(50, 70, 1200, 550);
        add(panel1);

        b2 = new JButton("", new ImageIcon("images/lapplication.png"));
        b3 = new JButton("", new ImageIcon("images/s.png"));
        b4 = new JButton("", new ImageIcon("images/app.png"));
        b5 = new JButton("", new ImageIcon("images/appstatus.png"));
        b6 = new JButton("", new ImageIcon("images/logout.png"));

        tb1 = new JToggleButton("", new ImageIcon("images/unlock.png"));

        b2.setToolTipText("Application for Learner Licence");
        b3.setToolTipText("Application for Smart Card/Driving Licence");
        b4.setToolTipText("Approval");
        b5.setToolTipText("Application Status");
        b6.setToolTipText("Log Off/Exit");
        tb1.setToolTipText("Lock The Screen");

        tb.setFloatable(false);

        tb.setRollover(false);
        tb.add(b2);
        tb.add(b3);
        tb.add(b4);
        tb.add(b5);
        tb.add(b6);
        tb.add(tb1);
        tb.setBounds(0, 0, 460, 60);
        user.setBounds(900, 38, 330, 30);
        add(tb);
        add(user);
        li.addActionListener(this);
        li.addKeyListener(this);
        ucreate.addActionListener(this);
        ucreate.addKeyListener(this);
        chpass.addActionListener(this);
        chpass.addKeyListener(this);
        lo.addActionListener(this);
        lo.addKeyListener(this);
        feell.addActionListener(this);
        feell.addKeyListener(this);
        feedl.addActionListener(this);
        feedl.addKeyListener(this);
        ap.addActionListener(this);
        ap.addKeyListener(this);
        sll.addActionListener(this);
        sll.addKeyListener(this);
        sdl.addActionListener(this);
        sdl.addKeyListener(this);
        sapp.addActionListener(this);
        sapp.addKeyListener(this);
        reportfee.addActionListener(this);
        reportfee.addKeyListener(this);
        reportll.addActionListener(this);
        reportll.addKeyListener(this);
        reportdl.addActionListener(this);
        reportdl.addKeyListener(this);
        developer.addActionListener(this);
        developer.addKeyListener(this);
        master.addActionListener(this);
        master.addKeyListener(this);

        tb1.addActionListener(this);
        tb1.addKeyListener(this);
        b2.addActionListener(this);
        b3.addActionListener(this);
        b4.addActionListener(this);
        b5.addActionListener(this);
        b6.addActionListener(this);
        b2.addKeyListener(this);
        b3.addKeyListener(this);
        b4.addKeyListener(this);
        b5.addKeyListener(this);
        b6.addKeyListener(this);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
        new login1();

        try {
            Class.forName("oracle.jdbc.driver.OracleDriver");
            Connection cc = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "system", "manish");
            Statement s = cc.createStatement();
            ResultSet rs = s.executeQuery("select red,green,blue from admintor");
            if (rs.next()) {
                panel1.setBackground(new Color(rs.getInt(1), rs.getInt(2), rs.getInt(3)));
            }
        } catch (Exception eee) {
        }

    }

    home(String y, String x) {
        y1 = y;
        y2 = x;
        try {
            UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel");

        } catch (Exception e) {
        }
        setTitle("Login-Menu Screen  Connected with Server : DTO");
        setSize(1300, 700);
        setIconImage(Toolkit.getDefaultToolkit().getImage("images/hicon.png"));

        setResizable(false);
        setLocationRelativeTo(null);
        setLayout(null);
        panel1.setLayout(null);
        panel1.setBorder(BorderFactory.createLineBorder(Color.black));
        panel1.setBackground(Color.white);

        mb = new JMenuBar();
        
        addmin = new JMenu("Administrator");
        addmin.addSeparator();
        wf = new JMenu("WorkFlow");
        wf.addSeparator();
        app = new JMenu("ALLApproval");
        app.addSeparator();
        search = new JMenu("Search");
        search.addSeparator();
        report = new JMenu("Report");
        report.addSeparator();
        h = new JMenu("Help");
        h.addSeparator();

        li = new JMenuItem("Background Color");
        ucreate = new JMenuItem("New Staff/User Creation");
        chpass = new JMenuItem("Change Password");
        lo = new JMenuItem("Log Out");

        feell = new JMenuItem("Fee-Payment for Learner Licence");
        feedl = new JMenuItem("Fee-Payment for Driving Licence");

        ap = new JMenuItem("Approval");

        sll = new JMenuItem("Learner Licence");
        sdl = new JMenuItem("Driving Licence");
        sapp = new JMenuItem("Application Status");

        reportfee = new JMenuItem("Fee-Report");
        reportll = new JMenuItem("LL-Report");
        reportdl = new JMenuItem("DL-Report");

        developer = new JMenuItem("About Developer");
        master = new JMenuItem("Master Administrator");

        addmin.add(master);
        addmin.add(ucreate);
        addmin.add(chpass);
        addmin.add(lo);

        wf.add(feell);
        wf.add(feedl);

        app.add(ap);

        search.add(sll);
        search.add(sdl);
        search.add(sapp);

        report.add(reportfee);
        report.add(reportll);
        report.add(reportdl);

        h.add(developer);
        h.add(li);

        user = new JLabel("User Name : ");
        user.setFont(new Font("Bookman Old Style", Font.PLAIN, 15));
        user.setBorder(BorderFactory.createLineBorder(Color.black));

        l2 = new JLabel("BR-841301-TRANSPORT DEPARTMENT SARAN");
        l2.setFont(new Font("Bookman Old Style", Font.BOLD, 20));

        l1 = new JLabel(new ImageIcon("images/transport.gif"));
        l1.setBounds(350, 50, 500, 200);
        l2.setBounds(340, 130, 1000, 200);
        panel1.add(l1);
        panel1.add(l2);

        mb.add(addmin);
        mb.add(wf);
        mb.add(app);
        mb.add(search);
        mb.add(report);
        mb.add(h);

        setJMenuBar(mb);

        panel1.setBounds(50, 70, 1200, 550);
        add(panel1);

        b2 = new JButton("", new ImageIcon("images/lapplication.png"));
        b3 = new JButton("", new ImageIcon("images/s.png"));
        b4 = new JButton("", new ImageIcon("images/app.png"));
        b5 = new JButton("", new ImageIcon("images/appstatus.png"));
        b6 = new JButton("", new ImageIcon("images/logout.png"));

        tb1 = new JToggleButton("", new ImageIcon("images/unlock.png"));

        b2.setToolTipText("Application for Learner Licence");
        b3.setToolTipText("Application for Smart Card/Driving Licence");
        b4.setToolTipText("Approval");
        b5.setToolTipText("Application Status");
        b6.setToolTipText("Log Off/Exit");
        tb1.setToolTipText("Lock The Screen");

        tb.setFloatable(false);

        tb.setRollover(false);
        tb.add(b2);
        tb.add(b3);
        tb.add(b4);
        tb.add(b5);
        tb.add(b6);
        tb.add(tb1);
        tb.setBounds(0, 0, 460, 60);
        user.setBounds(900, 38, 330, 30);
        add(tb);
        add(user);
        li.addActionListener(this);
        li.addKeyListener(this);
        ucreate.addActionListener(this);
        ucreate.addKeyListener(this);
        chpass.addActionListener(this);
        chpass.addKeyListener(this);
        lo.addActionListener(this);
        lo.addKeyListener(this);
        feell.addActionListener(this);
        feell.addKeyListener(this);
        feedl.addActionListener(this);
        feedl.addKeyListener(this);
        ap.addActionListener(this);
        ap.addKeyListener(this);
        sll.addActionListener(this);
        sll.addKeyListener(this);
        sdl.addActionListener(this);
        sdl.addKeyListener(this);
        sapp.addActionListener(this);
        sapp.addKeyListener(this);
        reportfee.addActionListener(this);
        reportfee.addKeyListener(this);
        reportll.addActionListener(this);
        reportll.addKeyListener(this);
        reportdl.addActionListener(this);
        reportdl.addKeyListener(this);
        developer.addActionListener(this);
        developer.addKeyListener(this);
        master.addActionListener(this);
        master.addKeyListener(this);
        tb1.addActionListener(this);
        tb1.addKeyListener(this);
        b2.addActionListener(this);
        b3.addActionListener(this);
        b4.addActionListener(this);
        b5.addActionListener(this);
        b6.addActionListener(this);
        b2.addKeyListener(this);
        b3.addKeyListener(this);
        b4.addKeyListener(this);
        b5.addKeyListener(this);
        b6.addKeyListener(this);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);

        user.setText(user.getText() + y1);
        userid = y2;

        try {
            Class.forName("oracle.jdbc.driver.OracleDriver");
            Connection cc = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "system", "manish");
            Statement s = cc.createStatement();
            ResultSet rs = s.executeQuery("select red,green,blue from admintor");
            if (rs.next()) {
                panel1.setBackground(new Color(rs.getInt(1), rs.getInt(2), rs.getInt(3)));
            }
        } catch (Exception eee) {
        }

    }

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == li) {
            color = JColorChooser.showDialog(this, "Select a New Color...", Color.green);
            if (!(color == null)) {
                panel1.setBackground(color);
            } else {
                panel1.setBackground(Color.white);
            }
            try {

                Class.forName("oracle.jdbc.driver.OracleDriver");
                Connection cc = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "system", "manish");
                Statement s = cc.createStatement();
                s.executeUpdate("UPDATE admintor SET red='" + color.getRed() + "',green='" + color.getGreen()
                        + "',blue='" + color.getBlue() + "' ");
            } catch (Exception eee) {
            }

        } else if (e.getSource() == ucreate) {
            new nuser().setVisible(true);
        } else if (e.getSource() == chpass) {
            new form2().setVisible(true);
        } else if (e.getSource() == lo) {
            System.exit(0);
        } else if (e.getSource() == feell) {
            new form5().setVisible(true);
        } else if (e.getSource() == feedl) {
            new feedl().setVisible(true);
        } else if (e.getSource() == ap) {
            new approvaldl().setVisible(true);
        } else if (e.getSource() == sll) {
            new searchbox().setVisible(true);
        } else if (e.getSource() == sdl) {
            new searchbox2().setVisible(true);
        } else if (e.getSource() == sapp) {
            new apstatus().setVisible(true);
        } else if (e.getSource() == reportfee) {
            new feereport().setVisible(true);
        } else if (e.getSource() == reportll) {
            new llreport().setVisible(true);
        } else if (e.getSource() == reportdl) {
            new dlreport().setVisible(true);
        } else if (e.getSource() == developer) {
            new develop();
        } else if (e.getSource() == master) {
            new admin();
        } else if (e.getSource() == b2) {
            new form5().setVisible(true);
        } else if (e.getSource() == b3) {
            new feedl().setVisible(true);
        } else if (e.getSource() == b4) {
            new approvaldl().setVisible(true);
        } else if (e.getSource() == b5) {
            new apstatus().setVisible(true);
        } else if (e.getSource() == b6) {
            int result = JOptionPane.showConfirmDialog(this, "Do You Want To Exit?", "Confirmation",
                    JOptionPane.YES_NO_OPTION);
            if (result == JOptionPane.YES_OPTION) {
                System.exit(0);
            }
        } else if (e.getSource() == tb1) {
            if (tb1.isSelected() == true) {
                tb1.setIcon(new ImageIcon("images/lock.png"));
                b2.setEnabled(false);
                b3.setEnabled(false);
                b4.setEnabled(false);
                b5.setEnabled(false);
                b6.setEnabled(false);
                li.setEnabled(false);
                ucreate.setEnabled(false);
                chpass.setEnabled(false);
                lo.setEnabled(false);
                feell.setEnabled(false);
                feedl.setEnabled(false);
                ap.setEnabled(false);
                sll.setEnabled(false);
                sdl.setEnabled(false);
                sapp.setEnabled(false);
                reportfee.setEnabled(false);
                reportll.setEnabled(false);
                reportdl.setEnabled(false);
                setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);

            }
            if (tb1.isSelected() == false) {
                new go();
                b2.setEnabled(true);
                b3.setEnabled(true);
                b4.setEnabled(true);
                b5.setEnabled(true);
                b6.setEnabled(true);
                li.setEnabled(true);
                ucreate.setEnabled(true);
                chpass.setEnabled(true);
                lo.setEnabled(true);
                feell.setEnabled(true);
                feedl.setEnabled(true);
                ap.setEnabled(true);
                sll.setEnabled(true);
                sdl.setEnabled(true);
                sapp.setEnabled(true);
                reportfee.setEnabled(true);
                reportll.setEnabled(true);
                reportdl.setEnabled(true);
                developer.setEnabled(true);
                setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                tb1.setIcon(new ImageIcon("images/unlock.png"));
            }

        }

    }

    public void keyPressed(KeyEvent e) {
        if (e.getKeyCode() == 10) {
            if (e.getSource() == b2) {
                new form5().setVisible(true);
            } else if (e.getSource() == b3) {
                new feedl().setVisible(true);
            } else if (e.getSource() == b4) {
                new approvaldl().setVisible(true);
            } else if (e.getSource() == b5) {
                new apstatus().setVisible(true);
            } else if (e.getSource() == b6) {
                int result = JOptionPane.showConfirmDialog(this, "Do You Want To Exit?", "Confirmation",
                        JOptionPane.YES_NO_OPTION);
                if (result == JOptionPane.YES_OPTION) {
                    System.exit(0);
                }

            }
        }
    }

    public void keyTyped(KeyEvent e) {
    }

    public void keyReleased(KeyEvent e) {
    }

    private class go extends JDialog implements ActionListener, KeyListener {
        private JDialog dialog = new JDialog((Frame) null, "Re-LogIn", true);

        JLabel l, l1;
        JPasswordField t1;
        JButton bt1, bt2;
        JPanel panel1 = new JPanel();
        JPanel panel2 = new JPanel();
        Color c = new Color(0, 128, 128);

        go() {

            dialog.setTitle("Password LogIn");
            dialog.setSize(300, 200);
            dialog.setUndecorated(true);
            dialog.setResizable(false);
            dialog.setLocationRelativeTo(null);
            dialog.setLayout(null);
            try {
                UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel");
            } catch (Exception e) {
            }
            panel1.setLayout(null);
            panel1.setBackground(c);
            panel2.setBackground(Color.black);
            l = new JLabel("Re-LogIn");
            l.setForeground(Color.white);
            l.setFont(new Font("Sans-Serif", Font.BOLD, 17));

            l1 = new JLabel(user.getText());
            l1.setFont(new Font("Bookman Old Style", Font.PLAIN, 16));
            
            t1 = new JPasswordField();

            bt1 = new JButton("Ok");
            bt2 = new JButton("Cancel");

            panel1.setBounds(0, 0, 300, 40);
            l.setBounds(110, 10, 200, 20);
            panel1.add(l);

            l1.setBounds(30, 50, 240, 30);

            panel2.setBounds(8, 85, 280, 3);
            t1.setBounds(25, 100, 240, 30);
            bt1.setBounds(10, 135, 130, 30);
            bt2.setBounds(150, 135, 130, 30);
            dialog.add(panel1);
            dialog.add(l1);
            dialog.add(panel2);
            dialog.add(t1);
            dialog.add(bt1);
            dialog.add(bt2);
            t1.addActionListener(this);
            t1.addKeyListener(this);
            bt1.addActionListener(this);
            bt1.addKeyListener(this);
            bt2.addActionListener(this);
            bt2.addKeyListener(this);
            dialog.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

            dialog.setVisible(true);
        }

        public void actionPerformed(ActionEvent e) {
            if (e.getSource() == bt1) {
                if ((t1.getPassword()).equals("") || (t1.getPassword()).equals(null)) {
                    JOptionPane.showMessageDialog(this, "Please Enter Password.", "LogIn", JOptionPane.ERROR_MESSAGE);
                    t1.requestFocus();
                } else {
                    try {
                        Class.forName("oracle.jdbc.driver.OracleDriver");
                        Connection c = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "system",
                                "manish");
                        Statement s = c.createStatement();
                        String sql = ("SELECT password FROM nuser WHERE staffid='" + userid + "' ");
                        ResultSet rs = s.executeQuery(sql);
                        if (rs.next()) {
                            if ((rs.getString("password")).equals(t1.getPassword())) {
                                JOptionPane.showMessageDialog(this, "Successfully LogIn.", "LogIn",
                                        JOptionPane.INFORMATION_MESSAGE);
                                dialog.dispose();
                            } else {
                                JOptionPane.showMessageDialog(dialog, "Not a Valid Password.", "LogIn",
                                        JOptionPane.INFORMATION_MESSAGE);

                                t1.setText("");
                                t1.requestFocus();
                            }
                        }
                        c.close();
                    } catch (Exception ec) {
                        JOptionPane.showMessageDialog(this, ec.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
                    }
                }
            }
            if (e.getSource() == bt2) {
                int result = JOptionPane.showConfirmDialog(this, "Do You Want To Exit?", "Confirmation",
                        JOptionPane.YES_NO_OPTION);
                if (result == JOptionPane.YES_OPTION) {
                    System.exit(0);
                }
            }

        }

        public void keyPressed(KeyEvent e) {
            if (e.getKeyCode() == 10) {
                if (e.getSource() == bt1) {
                    if ((t1.getPassword()).equals("") || (t1.getPassword()).equals(null)) {
                        JOptionPane.showMessageDialog(this, "Please Enter Password.", "LogIn",
                                JOptionPane.ERROR_MESSAGE);
                        t1.requestFocus();
                    } else {
                        bt1.requestFocus();
                    }
                } else if (e.getSource() == t1) {
                    if ((t1.getPassword()).equals("") || (t1.getPassword()).equals(null)) {
                        JOptionPane.showMessageDialog(this, "Please Enter Password.", "LogIn",
                                JOptionPane.ERROR_MESSAGE);
                        t1.requestFocus();
                    } else {
                        bt1.requestFocus();
                    }
                }
            }
        }

        public void keyTyped(KeyEvent e) {
        }

        public void keyReleased(KeyEvent e) {
        }
    }

    private class login1 implements ActionListener, KeyListener {
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
        // dbuttonok.setBackground(null);
        JButton dbuttoncancel = new JButton("Cancel");
        JPanel panel3 = new JPanel();
        Image img;
        JLabel lphoto;
        String x = "";
        String sql = "";

        login1() {

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
                        String sql = "Select staffid,name,password from nuser WHERE staffid='"
                                + textfieldstaff.getText() + "'";

                        ResultSet rs = s.executeQuery(sql);
                        if (rs.next()) {
                            if ((textfieldstaff.getText()).equals(rs.getString("staffid"))
                                    && (textfieldname.getText()).equals(rs.getString("name"))
                                    && (String.valueOf(textfieldpassword.getPassword())).equals(rs.getString("password"))) {
                                JOptionPane.showMessageDialog(dialog, "Successful.", "",
                                        JOptionPane.INFORMATION_MESSAGE);
                                userid = textfieldstaff.getText();
                                user.setText(user.getText() + textfieldname.getText());
                                dialog.dispose();
                            }

                            else {
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
                System.exit(0);
            }

            else if (e.getSource() == newuser) {
                dialog.dispose();
                dispose();
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
                            String sql = "Select staffid,photoaddress from nuser WHERE staffid='"
                                    + textfieldstaff.getText() + "'";
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
                            Statement s = c.createStatement();
                            String sql = "Select staffid,name,password from nuser WHERE staffid='"
                                    + textfieldstaff.getText() + "'";
                            ResultSet rs = s.executeQuery(sql);
                            if (rs.next()) {
                                if ((textfieldstaff.getText()).equals(rs.getString("staffid"))
                                        && (textfieldname.getText()).equals(rs.getString("name"))
                                        && (String.valueOf(textfieldpassword.getPassword()))
                                                .equals(rs.getString("password"))) {
                                    JOptionPane.showMessageDialog(dialog, "Successful.", "",
                                            JOptionPane.INFORMATION_MESSAGE);
                                    try {
                                        Class.forName("oracle.jdbc.driver.OracleDriver");
                                        Connection cc = DriverManager.getConnection(
                                                "jdbc:oracle:thin:@localhost:1521:xe", "system", "manish");
                                        Statement ss = cc.createStatement();
                                        String sql1 = ("INSERT INTO login (ldate,staffid,staffusername) VALUES('"
                                                + textfielddate.getText() + "','" + textfieldstaff.getText() + "','"
                                                + textfieldname.getText() + "')");
                                        ss.executeUpdate(sql1);
                                    } catch (Exception eee) {
                                    }
                                    userid = textfieldstaff.getText();
                                    user.setText(user.getText() + textfieldname.getText());

                                    dialog.dispose();
                                } else {
                                    JOptionPane.showMessageDialog(dialog, "Not a Valid Staffid,User Name or Password.",
                                            "", JOptionPane.INFORMATION_MESSAGE);
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
                    System.exit(0);
                }

            }
            if (e.getKeyCode() == 27) {
                e.consume();
                new login1();
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
    }

    public static void main(String c[]) {
        new home();
    }
}
