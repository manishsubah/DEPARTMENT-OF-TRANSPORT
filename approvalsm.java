import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.sql.*;
import java.io.File;
import java.util.Calendar;
import java.util.Date;
import java.awt.image.BufferedImage;
import javax.imageio.ImageIO;

class approvalsm extends JFrame implements KeyListener, ActionListener {
    ResultSet rs;
    String dlnumber = "BR-DL13000";
    JScrollPane sp;
    JLabel lup;
    String fname = "", hname = "", pp = "", ap = "", bp = "", pa = "", sa = "", tha = "";
    String sql = "", up = "";
    JLabel ll, l, lp, l1, l2, l3, l4, l5, l6, l7, l8, l9, l10, l11, l12, l13, l14, l15, l16, l17, l18, l19, l20, l21,
            l22, l23, lvclass;
    JTextField ta, ta1, ta2, t1, t2, t3, t4, t5, t6, t7, t8, t9, t10, t11, t12, t13, t14, t15, t16, tvclass1, tvclass2,
            tcb1, tcb2, trd;
    JCheckBox ch1, ch2, ch3;
    JComboBox cb1, cb2;
    JRadioButton rd1, rd2, rd3;
    
    ButtonGroup group;
    JPanel panel1 = new JPanel();
    JPanel panel2 = new JPanel();
    
    JButton b1, b2, b3, b5, up1, up2, up3, next, previous;;
    Date date = new Date();
    Calendar now = Calendar.getInstance();
    String valid = "";

    approvalsm() {
        setTitle("Approval-Driving Licence");
        setSize(1350, 730);
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

        now.setTime(date);
        System.out.println("Current date:" + now.get(Calendar.DATE) + "-" + (now.get(Calendar.MONTH) + 1) + "-"
                + now.get(Calendar.YEAR));
        now.add(Calendar.YEAR, 20);
        valid = (now.get(Calendar.DATE) + "/" + (now.get(Calendar.MONTH) + 1) + "/" + now.get(Calendar.YEAR));

        System.out.println(valid);

        l = new JLabel("APPROVAL-DRIVING LICENCE");
        l.setForeground(Color.white);
        l.setFont(new Font("Sans-Serif", Font.BOLD, 20));

        l1 = new JLabel("Date of Applied :");
        l1.setFont(new Font("Bookman Old Style", Font.PLAIN, 16));
        ll = new JLabel("Learner Licence Number :");
        ll.setFont(new Font("Bookman Old Style", Font.PLAIN, 16));
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
        l21 = new JLabel("Date of Birth :");
        l21.setFont(new Font("Bookman Old Style", Font.PLAIN, 16));
        l22 = new JLabel("Blood Group :");
        l22.setFont(new Font("Bookman Old Style", Font.PLAIN, 16));
        l23 = new JLabel("Identification Marks :");
        l23.setFont(new Font("Bookman Old Style", Font.PLAIN, 16));

        lvclass = new JLabel("Type of Vehicle(s) :");
        lvclass.setFont(new Font("Bookman Old Style", Font.PLAIN, 16));

        t1 = new JTextField();
        
        t1.setFont(new Font("Bookman Old Style", Font.PLAIN, 14));
        t1.setEditable(false);
        ta = new JTextField();
        ta.setFont(new Font("Bookman Old Style", Font.PLAIN, 14));
        ta.setEditable(false);
        ta1 = new JTextField();
        ta1.setFont(new Font("Bookman Old Style", Font.PLAIN, 14));
        ta1.setEditable(false);
        ta2 = new JTextField();
        ta2.setFont(new Font("Bookman Old Style", Font.PLAIN, 14));
        ta2.setEditable(false);
        t2 = new JTextField();
        t2.setFont(new Font("Bookman Old Style", Font.PLAIN, 14));
        t2.setEditable(false);
        t3 = new JTextField();
        t3.setEditable(false);
        t3.setFont(new Font("Bookman Old Style", Font.PLAIN, 14));
        t4 = new JTextField();
        t4.setFont(new Font("Bookman Old Style", Font.PLAIN, 14));
        t4.setEditable(false);
        t5 = new JTextField();
        t5.setEditable(false);
        t5.setFont(new Font("Bookman Old Style", Font.PLAIN, 14));
        t6 = new JTextField();
        t6.setEditable(false);
        t6.setFont(new Font("Bookman Old Style", Font.PLAIN, 14));
        t7 = new JTextField();
        t7.setEditable(false);
        t7.setFont(new Font("Bookman Old Style", Font.PLAIN, 14));
        t8 = new JTextField();
        t8.setEditable(false);
        t8.setFont(new Font("Bookman Old Style", Font.PLAIN, 14));
        t9 = new JTextField();
        t9.setEditable(false);
        t9.setFont(new Font("Bookman Old Style", Font.PLAIN, 14));
        t10 = new JTextField();
        t10.setEditable(false);
        t10.setFont(new Font("Bookman Old Style", Font.PLAIN, 14));
        t11 = new JTextField();
        t11.setEditable(false);
        t11.setFont(new Font("Bookman Old Style", Font.PLAIN, 14));
        t12 = new JTextField();
        t12.setEditable(false);
        t12.setFont(new Font("Bookman Old Style", Font.PLAIN, 14));
        t13 = new JTextField();
        t13.setEditable(false);
        t13.setFont(new Font("Bookman Old Style", Font.PLAIN, 14));
        t14 = new JTextField();
        t14.setEditable(false);
        t14.setFont(new Font("Bookman Old Style", Font.PLAIN, 14));
        t15 = new JTextField();
        t15.setEditable(false);
        t15.setFont(new Font("Bookman Old Style", Font.PLAIN, 14));
        t16 = new JTextField();
        t16.setEditable(false);
        t16.setFont(new Font("Bookman Old Style", Font.PLAIN, 14));

        tvclass1 = new JTextField();
        tvclass1.setFont(new Font("Bookman Old Style", Font.PLAIN, 14));
        tvclass1.setEditable(false);
        tvclass2 = new JTextField();
        tvclass2.setFont(new Font("Bookman Old Style", Font.PLAIN, 14));
        tvclass2.setEditable(false);

        tcb1 = new JTextField();
        tcb1.setFont(new Font("Bookman Old Style", Font.PLAIN, 14));
        tcb1.setEditable(false);
        tcb2 = new JTextField();
        tcb2.setFont(new Font("Bookman Old Style", Font.PLAIN, 14));
        tcb2.setEditable(false);
        ch1 = new JCheckBox("Photo Proof");
        ch2 = new JCheckBox("Address Proof");
        ch3 = new JCheckBox("Blood Group Proof");

        trd = new JTextField();
        trd.setFont(new Font("Bookman Old Style", Font.PLAIN, 14));
        trd.setEditable(false);

        b1 = new JButton("Approved");
        b2 = new JButton("Disapproved");
        b3 = new JButton("Cancel");
        b1.setFont(new Font("Bookman Old Style", Font.PLAIN, 14));
        b2.setFont(new Font("Bookman Old Style", Font.PLAIN, 14));
        b3.setFont(new Font("Bookman Old Style", Font.PLAIN, 14));

        b5 = new JButton("Show Biometrics");
        b5.setFont(new Font("Bookman Old Style", Font.PLAIN, 14));
        next = new JButton("Next");
        next.setFont(new Font("Bookman Old Style", Font.PLAIN, 14));
        previous = new JButton("Previous");
        previous.setFont(new Font("Bookman Old Style", Font.PLAIN, 14));

        up1 = new JButton("Show");
        up2 = new JButton("Show");
        up3 = new JButton("Show");

        
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
        l21.setBounds(26, 270, 250, 30);
        l22.setBounds(30, 310, 200, 30);
        l8.setBounds(30, 350, 200, 30);
        l10.setBounds(30, 390, 200, 30);
        l11.setBounds(30, 430, 200, 30);
        l12.setBounds(30, 470, 200, 30);
        l13.setBounds(30, 510, 200, 30);

        
        ll.setBounds(620, 30, 250, 30);
        l23.setBounds(630, 70, 200, 30);
        l17.setBounds(630, 150, 300, 30);
        l9.setBounds(630, 270, 300, 30);
        l18.setBounds(630, 310, 200, 30);
        l19.setBounds(630, 350, 200, 30);
        lp.setBounds(630, 390, 150, 30);
        l16.setBounds(630, 430, 200, 30);
        l15.setBounds(630, 470, 200, 30);
        l14.setBounds(630, 510, 200, 30);

        t1.setBounds(250, 30, 300, 30);
        t2.setBounds(250, 70, 300, 30);
        t3.setBounds(250, 110, 300, 30);
        tcb1.setBounds(250, 150, 300, 30);
        trd.setBounds(250, 190, 50, 30);
        t4.setBounds(250, 230, 300, 30);
        t14.setBounds(250, 270, 300, 30);
        tcb2.setBounds(250, 310, 300, 30);
        ta.setBounds(250, 350, 300, 30);
        t5.setBounds(250, 390, 300, 30);
        t6.setBounds(250, 430, 300, 30);
        t7.setBounds(250, 470, 300, 30);
        t8.setBounds(250, 510, 300, 30);

        
        t13.setBounds(830, 30, 300, 30);
        t15.setBounds(830, 70, 300, 30);
        t16.setBounds(830, 110, 300, 30);
        ch1.setBounds(830, 150, 300, 30);
        up1.setBounds(1140, 150, 70, 30);
        ch2.setBounds(830, 190, 300, 30);
        up2.setBounds(1140, 190, 70, 30);
        ch3.setBounds(830, 230, 300, 30);
        up3.setBounds(1140, 230, 70, 30);
        ta1.setBounds(830, 310, 300, 30);
        ta2.setBounds(830, 350, 300, 30);
        t12.setBounds(830, 390, 300, 30);
        t11.setBounds(830, 430, 300, 30);
        t10.setBounds(830, 470, 300, 30);
        t9.setBounds(830, 510, 300, 30);
        lvclass.setBounds(1150, 430, 180, 30);
        tvclass1.setBounds(1150, 470, 80, 30);
        tvclass2.setBounds(1250, 470, 80, 30);

        b5.setBounds(1150, 510, 150, 30);
        previous.setBounds(340, 640, 150, 30);
        next.setBounds(500, 640, 150, 30);

        b1.setBounds(660, 640, 150, 30);
        b2.setBounds(820, 640, 150, 30);
        b3.setBounds(980, 640, 150, 30);

        panel1.add(l);
        
        panel2.add(l1);
        panel2.add(t1);
        panel2.add(l2);
        panel2.add(l3);
        panel2.add(t2);
        panel2.add(l4);
        panel2.add(t3);
        panel2.add(l5);
        panel2.add(tcb1);
        panel2.add(l6);
        panel2.add(trd);
        panel2.add(l7);
        panel2.add(t4);
        panel2.add(l21);
        panel2.add(t14);
        panel2.add(l22);
        panel2.add(tcb2);
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
        panel2.add(ll);
        panel2.add(t13);
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
        panel2.add(lvclass);
        panel2.add(tvclass1);
        panel2.add(tvclass2);

        panel2.add(b5);
        add(previous);
        add(next);

        add(b1);
        add(b2);
        add(b3);

        
        add(panel1);
        add(panel2);
        b1.addActionListener(this);
        b2.addActionListener(this);
        b3.addActionListener(this);
        b1.addKeyListener(this);
        b2.addKeyListener(this);
        b3.addKeyListener(this);
        previous.addActionListener(this);
        previous.addKeyListener(this);
        next.addActionListener(this);
        next.addKeyListener(this);
        b5.addActionListener(this);
        b5.addKeyListener(this);
        up1.addActionListener(this);
        up2.addActionListener(this);
        up3.addActionListener(this);
        up1.addKeyListener(this);
        up2.addKeyListener(this);
        up3.addKeyListener(this);

        setVisible(true);
        

        b1.requestFocus();
        try {
            Class.forName("oracle.jdbc.driver.OracleDriver");
            Connection c = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "system", "manish");
            Statement s = c.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
            
            sql = "Select * from applicationdl WHERE status='PENDING' ORDER BY applicantid";
            rs = s.executeQuery(sql);
            if (rs.next()) {
                l2.setText(rs.getString(1));
                t1.setText(rs.getString(2));
                t2.setText(rs.getString(3));
                t3.setText(rs.getString(4));
                tcb1.setText(rs.getString(5));
                trd.setText(rs.getString(6));
                hname = rs.getString(7);
                fname = rs.getString(8);
                t14.setText(rs.getString(9));
                tcb2.setText(rs.getString(10));
                ta.setText(rs.getString(11));
                t5.setText(rs.getString(12));
                t6.setText(rs.getString(13));
                t7.setText(rs.getString(14));
                t8.setText(rs.getString(15));
                t13.setText(rs.getString(16));
                t15.setText(rs.getString(17));
                t16.setText(rs.getString(18));
                pp = rs.getString(19);
                ap = rs.getString(20);
                bp = rs.getString(21);

                ta1.setText(rs.getString(22));
                ta2.setText(rs.getString(23));
                t12.setText(rs.getString(24));
                t11.setText(rs.getString(25));
                t10.setText(rs.getString(26));
                t9.setText(rs.getString(27));
                tvclass1.setText(rs.getString(28));
                tvclass2.setText(rs.getString(29));
                pa = rs.getString(30);
                sa = rs.getString(31);
                tha = rs.getString(32);

            }
            
        } catch (Exception ec) {
            JOptionPane.showMessageDialog(this, ec.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
        if ((trd.getText()).equals("S/O") || (trd.getText()).equals("D/O")) {
            t4.setText(fname);
        }
        if ((trd.getText()).equals("W/O")) {
            t4.setText(hname);
        }
        try {
            if (!(pp.equals(""))) {
                ch1.setSelected(true);
            } else {
                ch1.setSelected(false);
            }
        } catch (Exception eda) {
        }
        try {
            if (!(ap.equals(""))) {
                ch2.setSelected(true);
            } else {
                ch2.setSelected(false);
            }
        } catch (Exception esd) {
        }
        try {
            if (!(bp.equals(""))) {
                ch3.setSelected(true);
            } else {
                ch3.setSelected(false);
            }
        } catch (Exception edd) {
        }

    }

    public void actionPerformed(ActionEvent e) {
        

        if (e.getSource() == b1) {
            try {
                Class.forName("oracle.jdbc.driver.OracleDriver");
                Connection c = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "system", "manish");
                
                Statement s = c.createStatement();
                ResultSet rs = s.executeQuery("select count(dlnumber) from drivinglicense");
                if (rs.next()) {
                    dlnumber = dlnumber + String.valueOf(Integer.valueOf(rs.getString(1)) + 1);

                    // JOptionPane.showMessageDialog(this,staff,"DTO-CHAPRA",JOptionPane.INFORMATION_MESSAGE);
                }
                c.close();
            } catch (Exception ec) {
            }
            if ((trd.getText()).equals("S/O") || (trd.getText()).equals("D/O")) {
                try {
                    Class.forName("oracle.jdbc.driver.OracleDriver");
                    Connection c = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "system",
                            "manish");
                    
                    Statement s = c.createStatement();
                    s.executeQuery("INSERT INTO drivinglicense VALUES('" + l2.getText() + "','" + t1.getText() + "','"
                            + t2.getText() + "','" + t3.getText() + "','" + tcb1.getText() + "','" + trd.getText()
                            + "','','" + t4.getText() + "','" + t14.getText() + "','" + tcb2.getText() + "','"
                            + ta.getText() + "','" + t5.getText() + "','" + t6.getText() + "','" + t7.getText() + "','"
                            + t8.getText() + "','" + t13.getText() + "','" + t15.getText() + "','" + t16.getText()
                            + "','" + pp + "','" + ap + "','" + bp + "','" + ta1.getText() + "','" + ta2.getText()
                            + "','" + t12.getText() + "','" + t11.getText() + "','" + t10.getText() + "','"
                            + t9.getText() + "','" + tvclass1.getText() + "','" + tvclass2.getText() + "','" + pa
                            + "','" + sa + "','" + tha + "','" + valid + "','" + dlnumber + "','APPROVED')");

                    c.close();
                } catch (Exception ec) {
                    JOptionPane.showMessageDialog(this, ec.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
                }
                try {
                    Class.forName("oracle.jdbc.driver.OracleDriver");
                    Connection c = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "system",
                            "manish");
                    
                    Statement s = c.createStatement();
                    Statement s1 = c.createStatement();
                    s1.executeUpdate(
                            "UPDATE applicationdl SET status='APPROVED' WHERE applicantid='" + t2.getText() + "'");
                    s.executeQuery("INSERT INTO appdlstatus VALUES('" + t2.getText() + "','" + t1.getText() + "','"
                            + t3.getText() + "','','" + t4.getText() + "','" + t14.getText() + "','" + tcb2.getText()
                            + "','" + t9.getText() + "','APPROVED')");
                    c.close();
                } catch (Exception ep) {
                    System.out.print(ep.getMessage());
                }
            } else if ((trd.getText()).equals("W/O")) {
                try {
                    Class.forName("oracle.jdbc.driver.OracleDriver");
                    Connection c = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "system",
                            "manish");
                    
                    Statement s = c.createStatement();

                    s.executeQuery("INSERT INTO drivinglicense VALUES('" + l2.getText() + "','" + t1.getText() + "','"
                            + t2.getText() + "','" + t3.getText() + "','" + tcb1.getText() + "','" + trd.getText()
                            + "','" + t4.getText() + "','','" + t14.getText() + "','" + tcb2.getText() + "','"
                            + ta.getText() + "','" + t5.getText() + "','" + t6.getText() + "','" + t7.getText() + "','"
                            + t8.getText() + "','" + t13.getText() + "','" + t15.getText() + "','" + t16.getText()
                            + "','" + pp + "','" + ap + "','" + bp + "','" + ta1.getText() + "','" + ta2.getText()
                            + "','" + t12.getText() + "','" + t11.getText() + "','" + t10.getText() + "','"
                            + t9.getText() + "','" + tvclass1.getText() + "','" + tvclass2.getText() + "','" + pa
                            + "','" + sa + "','" + tha + "','" + valid + "','" + dlnumber + "','APPROVED')");
                    c.close();
                } catch (Exception ec) {
                    JOptionPane.showMessageDialog(this, ec.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
                }
                try {
                    Class.forName("oracle.jdbc.driver.OracleDriver");
                    Connection c = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "system",
                            "manish");
                    
                    Statement s = c.createStatement();
                    Statement s1 = c.createStatement();
                    s1.executeUpdate(
                            "UPDATE applicationdl SET status='APPROVED' WHERE applicantid='" + t2.getText() + "'");
                    s.executeQuery("INSERT INTO appdlstatus VALUES('" + t2.getText() + "','" + t1.getText() + "','"
                            + t3.getText() + "','" + t4.getText() + "','','" + t14.getText() + "','" + tcb2.getText()
                            + "','" + t9.getText() + "','APPROVED')");
                    c.close();
                } catch (Exception ep) {
                    System.out.print(ep.getMessage());
                }
            }

            dlnumber = "BR-DL13000";
            JOptionPane.showMessageDialog(this, "Application Approved.", "Approval-DL",
                    JOptionPane.INFORMATION_MESSAGE);
        }

        else if (e.getSource() == b2) {
            if ((trd.getText()).equals("S/O") || (trd.getText()).equals("D/O")) {
                try {
                    Class.forName("oracle.jdbc.driver.OracleDriver");
                    Connection c = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "system",
                            "manish");
                    
                    Statement s1 = c.createStatement();
                    s1.executeUpdate(
                            "UPDATE applicationdl SET status='DISAPPROVED' WHERE applicantid='" + t2.getText() + "'");
                    Statement s = c.createStatement();
                    s.executeQuery("INSERT INTO appdlstatus VALUES('" + t2.getText() + "','" + t1.getText() + "','"
                            + t3.getText() + "','','" + t4.getText() + "','" + t14.getText() + "','" + tcb2.getText()
                            + "','" + t9.getText() + "','DISAPPROVED')");
                    c.close();
                } catch (Exception ep) {
                    System.out.print(ep.getMessage());
                }

            } else if ((trd.getText()).equals("W/O")) {
                try {
                    Class.forName("oracle.jdbc.driver.OracleDriver");
                    Connection c = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "system",
                            "manish");
                    
                    Statement s1 = c.createStatement();
                    s1.executeUpdate(
                            "UPDATE applicationdl SET status='DISAPPROVED' WHERE applicantid='" + t2.getText() + "'");
                    Statement s = c.createStatement();
                    s.executeQuery("INSERT INTO appdlstatus VALUES('" + t2.getText() + "','" + t1.getText() + "','"
                            + t3.getText() + "','" + t4.getText() + "','','" + t14.getText() + "','" + tcb2.getText()
                            + "','" + t9.getText() + "','DISAPPROVED')");
                    c.close();
                } catch (Exception ep) {
                    
                }
            }
            JOptionPane.showMessageDialog(this, "Application Disapproved.", "Approval-DL",
                    JOptionPane.INFORMATION_MESSAGE);
        }
        if (e.getSource() == b3) {
            dispose();
        } else if (e.getSource() == b5) {
            new biometrics();
        }

        else if (e.getSource() == up1) {
            if (ch1.isSelected() == false) {
                JOptionPane.showMessageDialog(this, "No Photo Proof Available.", "Photo Proof",
                        JOptionPane.INFORMATION_MESSAGE);
            } else {
                up = pp;
                new photo();
            }
        } else if (e.getSource() == up2) {
            if (ch2.isSelected() == false) {
                JOptionPane.showMessageDialog(this, "No ADDRESS Proof Available.", "Address Proof",
                        JOptionPane.INFORMATION_MESSAGE);
            } else {
                up = ap;
                new photo();
            }
        } else if (e.getSource() == up3) {
            if (ch3.isSelected() == false) {
                JOptionPane.showMessageDialog(this, "No BLOOD GROUP Proof Available.", "BloodGroup Proof",
                        JOptionPane.INFORMATION_MESSAGE);
            } else {
                up = bp;
                new photo();
            }
        } else if (e.getSource() == previous) {

            try {
                if (!(rs.isFirst() == true)) {
                    if (rs.previous()) {
                        l2.setText(rs.getString(1));
                        t1.setText(rs.getString(2));
                        t2.setText(rs.getString(3));
                        t3.setText(rs.getString(4));
                        tcb1.setText(rs.getString(5));
                        trd.setText(rs.getString(6));
                        hname = rs.getString(7);
                        fname = rs.getString(8);
                        t14.setText(rs.getString(9));
                        tcb2.setText(rs.getString(10));
                        ta.setText(rs.getString(11));
                        t5.setText(rs.getString(12));
                        t6.setText(rs.getString(13));
                        t7.setText(rs.getString(14));
                        t8.setText(rs.getString(15));
                        t13.setText(rs.getString(16));
                        t15.setText(rs.getString(17));
                        t16.setText(rs.getString(18));
                        pp = rs.getString(19);
                        ap = rs.getString(20);
                        bp = rs.getString(21);

                        ta1.setText(rs.getString(22));
                        ta2.setText(rs.getString(23));
                        t12.setText(rs.getString(24));
                        t11.setText(rs.getString(25));
                        t10.setText(rs.getString(26));
                        t9.setText(rs.getString(27));
                        tvclass1.setText(rs.getString(28));
                        tvclass2.setText(rs.getString(29));
                        pa = rs.getString(30);
                        sa = rs.getString(31);
                        tha = rs.getString(32);
                    }
                } else {
                    JOptionPane.showMessageDialog(this, "No more record found.", "Error", JOptionPane.ERROR_MESSAGE);
                }

            } catch (Exception ese) {
            }
            if ((trd.getText()).equals("S/O") || (trd.getText()).equals("D/O")) {
                t4.setText(fname);
            }
            if ((trd.getText()).equals("W/O")) {
                t4.setText(hname);
            }
            try {
                if (!(pp.equals(""))) {
                    ch1.setSelected(true);
                } else {
                    ch1.setSelected(false);
                }
            } catch (Exception eda) {
            }
            try {
                if (!(ap.equals(""))) {
                    ch2.setSelected(true);
                } else {
                    ch2.setSelected(false);
                }
            } catch (Exception esd) {
            }
            try {
                if (!(bp.equals(""))) {
                    ch3.setSelected(true);
                } else {
                    ch3.setSelected(false);
                }
            } catch (Exception edd) {
            }
        } else if (e.getSource() == ch1) {
            if (ch1.isSelected() == true) {
                ch1.setSelected(true);
            }

        }

        else if (e.getSource() == ch2) {
            if (ch2.isSelected() == true) {
                ch2.setSelected(true);
            } else {
                ch2.setSelected(false);
            }
        } else if (e.getSource() == ch3) {
            if (ch3.isSelected() == true) {
                ch3.setSelected(true);
            } else {
                ch3.setSelected(false);
            }

        } else if (e.getSource() == next) {

            try {
                if (!(rs.isLast() == true)) {
                    if (rs.next()) {
                        l2.setText(rs.getString(1));
                        t1.setText(rs.getString(2));
                        t2.setText(rs.getString(3));
                        t3.setText(rs.getString(4));
                        tcb1.setText(rs.getString(5));
                        trd.setText(rs.getString(6));
                        hname = rs.getString(7);
                        fname = rs.getString(8);
                        t14.setText(rs.getString(9));
                        tcb2.setText(rs.getString(10));
                        ta.setText(rs.getString(11));
                        t5.setText(rs.getString(12));
                        t6.setText(rs.getString(13));
                        t7.setText(rs.getString(14));
                        t8.setText(rs.getString(15));
                        t13.setText(rs.getString(16));
                        t15.setText(rs.getString(17));
                        t16.setText(rs.getString(18));
                        pp = rs.getString(19);
                        ap = rs.getString(20);
                        bp = rs.getString(21);

                        ta1.setText(rs.getString(22));
                        ta2.setText(rs.getString(23));
                        t12.setText(rs.getString(24));
                        t11.setText(rs.getString(25));
                        t10.setText(rs.getString(26));
                        t9.setText(rs.getString(27));
                        tvclass1.setText(rs.getString(28));
                        tvclass2.setText(rs.getString(29));
                        pa = rs.getString(30);
                        sa = rs.getString(31);
                        tha = rs.getString(32);
                    }
                } else {
                    JOptionPane.showMessageDialog(this, "No more record found.", "Error", JOptionPane.ERROR_MESSAGE);
                }

            } catch (Exception ese) {
            }
            if ((trd.getText()).equals("S/O") || (trd.getText()).equals("D/O")) {
                t4.setText(fname);
            }
            if ((trd.getText()).equals("W/O")) {
                t4.setText(hname);
            }
            try {
                if (!(pp.equals(""))) {
                    ch1.setSelected(true);
                } else {
                    ch1.setSelected(false);
                }
            } catch (Exception eda) {
            }
            try {
                if (!(ap.equals(""))) {
                    ch2.setSelected(true);
                } else {
                    ch2.setSelected(false);
                }
            } catch (Exception esd) {
            }
            try {
                if (!(bp.equals(""))) {
                    ch3.setSelected(true);
                } else {
                    ch3.setSelected(false);
                }
            } catch (Exception edd) {
            }
        } else if (e.getSource() == ch1) {
            if (ch1.isSelected() == true) {
                ch1.setSelected(true);
            }

        }

        else if (e.getSource() == ch2) {
            if (ch2.isSelected() == true) {
                ch2.setSelected(true);
            } else {
                ch2.setSelected(false);
            }
        } else if (e.getSource() == ch3) {
            if (ch3.isSelected() == true) {
                ch3.setSelected(true);
            } else {
                ch3.setSelected(false);
            }
        }

    }

    public void keyPressed(KeyEvent e) {
    }

    public void keyTyped(KeyEvent e) {
    }

    public void keyReleased(KeyEvent e) {
    }

    // -----------------------------------------------------------------------------------------------------------------
    private class biometrics extends JFrame implements KeyListener, ActionListener {
        String file = "";
        JLabel l3, l4, l5, lp1, lp2, lp3;
        JTextField t1, t2;

        JPanel panel2 = new JPanel();
        JPanel p1 = new JPanel();
        JPanel p2 = new JPanel();
        JPanel p3 = new JPanel();
        JPanel lp, lpp, lppp;
        String x = "";
        JButton b6;
        Color c = new Color(0, 128, 128);
        Image img, img1, img2;

        biometrics() {
            setTitle("Biometrics");
            setSize(700, 350);
            setResizable(false);
            setLocationRelativeTo(null);
            setLayout(null);
            try {
                UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel");
            } catch (Exception e) {
            }

            panel2.setLayout(null);
            lp = new ppanel();
            lpp = new pppanel();
            lppp = new ppppanel();
            lp2 = new JLabel();
            lp1 = new JLabel();
            lp3 = new JLabel();
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
            b6 = new JButton("Cancel");
            panel2.setBounds(0, 0, 750, 450);
            l3.setBounds(50, 50, 140, 30);
            l3.setBorder(BorderFactory.createLineBorder(Color.black));

            try {
                l3.setHorizontalAlignment(0);
            } catch (Exception e) {
            }
            l4.setBounds(280, 50, 140, 30);
            l4.setBorder(BorderFactory.createLineBorder(Color.black));
            try {
                l4.setHorizontalAlignment(0);
            } catch (Exception e) {
            }
            l5.setBounds(500, 50, 140, 30);
            l5.setBorder(BorderFactory.createLineBorder(Color.black));
            try {
                l5.setHorizontalAlignment(0);
            } catch (Exception e) {
            }

            p1.setLayout(null);
            p1.setBounds(30, 100, 200, 200);
            p1.setBorder(BorderFactory.createLineBorder(Color.black));
            lp.setBounds(5, 5, 190, 190);
            lp.setToolTipText("The Size of Image must be less than or equals to 185 X 185 pixels");
            p1.add(lp);
            p2.setLayout(null);
            p2.setBounds(250, 100, 200, 200);
            p2.setBorder(BorderFactory.createLineBorder(Color.black));
            lpp.setBounds(5, 5, 190, 190);
            lpp.setToolTipText("The Size of Image must be less than or equals to 185 X 185 pixels");
            p2.add(lpp);
            lpp.setBorder(BorderFactory.createLineBorder(Color.black));

            p3.setLayout(null);
            p3.setBounds(470, 100, 200, 200);
            p3.setBorder(BorderFactory.createLineBorder(Color.black));
            lppp.setBounds(5, 5, 190, 190);
            lppp.setToolTipText("The Size of Image must be less than or equals to 185 X 185 pixels");
            p3.add(lppp);
            lppp.setBorder(BorderFactory.createLineBorder(Color.black));

            b6.setBounds(565, 540, 100, 30);

            add(panel2);
            panel2.setBackground(Color.white);
            panel1.add(l);

            panel2.add(l3);
            panel2.add(p1);
            panel2.add(l4);
            panel2.add(p2);
            panel2.add(l5);
            panel2.add(p3);
            add(b6);

            setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
            setVisible(true);

            try {
                BufferedImage bimg = ImageIO.read(new File(pa));
                int width = bimg.getWidth();
                int height = bimg.getHeight();
                if (width > 185 || height > 185) {
                    Toolkit kit = Toolkit.getDefaultToolkit();
                    img = kit.getImage(pa);
                    img = img.getScaledInstance(185, 185, Image.SCALE_DEFAULT);
                } else {
                    Toolkit kit = Toolkit.getDefaultToolkit();
                    img = kit.getImage(pa);
                }

            } catch (Exception exp) {
                // System.out.print(exp.getMessage());
            }
            try {
                Toolkit kit = Toolkit.getDefaultToolkit();
                img1 = kit.getImage(sa);
            } catch (Exception exp) {
                // System.out.print(exp.getMessage());
            }
            try {
                Toolkit kit = Toolkit.getDefaultToolkit();
                img2 = kit.getImage(tha);
            } catch (Exception exp) {
                // System.out.print(exp.getMessage());
            }

        }

        public void actionPerformed(ActionEvent e) {
        }

        public void keyPressed(KeyEvent e) {
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

    }

    // ------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
    private class photo extends JFrame implements KeyListener {
        String file = "";
        String x = "";
        Image img;
        File filename;

        photo() {

            try {
                Connection c = DriverManager.getConnection("jdbc:odbc:dto", "", "");
                Statement s = c.createStatement();

                ResultSet rs = s.executeQuery(up);
                if (rs.next()) {
                    try {
                        file = rs.getString(1);
                    } catch (Exception dd) {
                    }
                }

                c.close();
            } catch (Exception ex) {
                // JOptionPane.showMessageDialog(this,ex.getMessage(),"",JOptionPane.INFORMATION_MESSAGE);
            }
            try {
                Toolkit kit = Toolkit.getDefaultToolkit();
                img = kit.getImage(up);
            } catch (Exception exp) {
                // System.out.print(exp.getMessage());
            }

            setTitle("Proof");
            setSize(550, 600);
            setResizable(true);
            setLocationRelativeTo(null);

            Container cp = getContentPane();
            JPanel p = new ppanel();
            try {
                lup = new JLabel(new ImageIcon(img));

                sp = new JScrollPane(lup);
                cp.add(sp);

            } catch (Exception effjjf) {
            }
            // l.addKeyListener(this);
            setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
            l.addKeyListener(this);
            sp.addKeyListener(this);
            setVisible(true);
        }

        public void keyPressed(KeyEvent e) {
            System.out.print(e.getKeyCode());
            if (e.getKeyCode() == 27) {
                if (e.getSource() == l || e.getSource() == sp) {
                    dispose();
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
                g.drawImage(img, 0, 0, this);
            }
        }
    }

    

    public static void main(String c[]) {
        new approvalsm();
    }
}
