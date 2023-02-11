import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.sql.*;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.awt.print.*;
import java.awt.image.BufferedImage;
import javax.imageio.ImageIO;
import java.io.*;

class appdrivingform extends JFrame implements Printable, ActionListener, KeyListener {
    String relation = "", fname = "", hname = "", img = "";
    PrinterJob pj = PrinterJob.getPrinterJob();
    javax.print.attribute.HashPrintRequestAttributeSet att = new javax.print.attribute.HashPrintRequestAttributeSet();
    JLabel lhead, ldate, l1, l2, l3, l4, l5, l6, l7, l8, l9, l10, l11, l12, l13, l14, l15, l16, lp, ls;
    JLabel ll1, ll2, ll3, ll4, ll5, ll6, ll7, ll8, ll9, ll10, ll11, ll12;
    JSeparator sep = new JSeparator(JSeparator.HORIZONTAL);
    JButton b1;
    JPanel p1 = new JPanel();
    DateFormat df = new SimpleDateFormat("dd/MM/yyyy");
    Date date = new Date();

    appdrivingform() {
        setTitle("Application driving Licence");
        setSize(1050, 700);
        setResizable(false);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout());
        setIconImage(Toolkit.getDefaultToolkit().getImage("hicon.png"));
        p1.setLayout(null);
        p1.setSize(1000, 700);

        ldate = new JLabel(df.format(date));
        ldate.setFont(new Font("Bookman Old Style", Font.PLAIN, 15));
        lhead = new JLabel("<html><b><u>Driving Licence Report</html>");
        lhead.setFont(new Font("Arial", Font.PLAIN, 15));
        l1 = new JLabel(new ImageIcon("indian.png"));

        l2 = new JLabel("INDIAN TRANSPORT DEPARTMENT");
        l2.setFont(new Font("Bookman Old Style", Font.PLAIN, 20));
        l3 = new JLabel("GOVERNMENT OF BIHAR");
        l3.setFont(new Font("Bookman Old Style", Font.PLAIN, 19));

        l4 = new JLabel("Applicant Id :");
        l4.setFont(new Font("Bookman Old Style", Font.PLAIN, 17));
        l5 = new JLabel("Name :");
        l5.setFont(new Font("Bookman Old Style", Font.PLAIN, 17));
        l6 = new JLabel("S/W/D of :");
        l6.setFont(new Font("Bookman Old Style", Font.PLAIN, 17));
        l7 = new JLabel("Address :");
        l7.setFont(new Font("Bookman Old Style", Font.PLAIN, 17));
        l8 = new JLabel("District :");
        l8.setFont(new Font("Bookman Old Style", Font.PLAIN, 17));
        l9 = new JLabel("City :");
        l9.setFont(new Font("Bookman Old Style", Font.PLAIN, 17));
        l10 = new JLabel("State :");
        l10.setFont(new Font("Bookman Old Style", Font.PLAIN, 17));
        l11 = new JLabel("Date Of Birth :");
        l11.setFont(new Font("Bookman Old Style", Font.PLAIN, 17));
        l12 = new JLabel("Blood Group :");
        l12.setFont(new Font("Bookman Old Style", Font.PLAIN, 17));
        l13 = new JLabel("Type of Vehicle :");
        l13.setFont(new Font("Bookman Old Style", Font.PLAIN, 17));
        l14 = new JLabel("Issued On :");
        l14.setFont(new Font("Bookman Old Style", Font.PLAIN, 17));
        l15 = new JLabel("Valid Till :");
        l15.setFont(new Font("Bookman Old Style", Font.PLAIN, 17));
        lp = new JLabel();
        lp.setBorder(BorderFactory.createLineBorder(Color.black));
        ls = new JLabel();
        ls.setBorder(BorderFactory.createLineBorder(Color.black));

        ll1 = new JLabel();
        ll1.setFont(new Font("Bookman Old Style", Font.PLAIN, 15));
        ll2 = new JLabel();
        ll2.setFont(new Font("Bookman Old Style", Font.PLAIN, 15));
        ll3 = new JLabel();
        ll3.setFont(new Font("Bookman Old Style", Font.PLAIN, 15));
        ll4 = new JLabel();
        ll4.setFont(new Font("Bookman Old Style", Font.PLAIN, 15));
        ll5 = new JLabel();
        ll5.setFont(new Font("Bookman Old Style", Font.PLAIN, 15));
        ll6 = new JLabel();
        ll6.setFont(new Font("Bookman Old Style", Font.PLAIN, 15));
        ll7 = new JLabel();
        ll7.setFont(new Font("Bookman Old Style", Font.PLAIN, 15));
        ll8 = new JLabel();
        ll8.setFont(new Font("Bookman Old Style", Font.PLAIN, 15));
        ll9 = new JLabel();
        ll9.setFont(new Font("Bookman Old Style", Font.PLAIN, 15));
        ll10 = new JLabel();
        ll10.setFont(new Font("Bookman Old Style", Font.PLAIN, 15));
        ll11 = new JLabel();
        ll11.setFont(new Font("Bookman Old Style", Font.PLAIN, 15));
        ll12 = new JLabel();
        ll12.setFont(new Font("Bookman Old Style", Font.PLAIN, 15));

        b1 = new JButton("PRINT");
        b1.setFont(new Font("Arial", Font.PLAIN, 13));

        l1.setBounds(300, 20, 70, 100);
        l2.setBounds(400, 20, 600, 50);
        ldate.setBounds(900, 10, 100, 30);
        sep.setBounds(380, 70, 400, 30);

        l3.setBounds(450, 70, 400, 50);
        lhead.setBounds(480, 120, 300, 50);
        lp.setBounds(800, 180, 200, 200);
        ls.setBounds(800, 380, 200, 100);

        l4.setBounds(310, 170, 220, 30);
        ll1.setBounds(480, 170, 300, 30);
        l5.setBounds(360, 210, 220, 30);
        ll2.setBounds(480, 210, 300, 30);
        l6.setBounds(330, 250, 220, 30);
        ll3.setBounds(480, 250, 300, 30);

        l7.setBounds(340, 290, 300, 30);
        ll4.setBounds(480, 290, 500, 30);
        l8.setBounds(345, 340, 300, 30);
        ll5.setBounds(480, 340, 300, 30);

        l9.setBounds(373, 380, 300, 30);
        ll6.setBounds(480, 380, 300, 30);
        l10.setBounds(362, 420, 300, 30);
        ll7.setBounds(480, 420, 300, 30);
        l11.setBounds(293, 460, 300, 30);
        ll8.setBounds(480, 460, 300, 30);
        l12.setBounds(295, 500, 300, 30);
        ll9.setBounds(480, 500, 300, 30);
        l13.setBounds(275, 540, 300, 30);
        ll10.setBounds(480, 540, 300, 30);
        l14.setBounds(315, 580, 300, 30);
        ll11.setBounds(480, 580, 300, 30);
        l15.setBounds(327, 620, 300, 30);
        ll12.setBounds(480, 620, 300, 30);
        b1.setBounds(900, 600, 100, 30);

        p1.add(ldate);
        p1.add(l1);
        p1.add(l2);
        p1.add(lhead);
        p1.add(sep);
        p1.add(l3);
        p1.add(l4);
        p1.add(ll1);
        p1.add(l5);
        p1.add(l6);
        p1.add(l7);
        p1.add(l8);
        p1.add(l9);
        p1.add(l10);
        p1.add(l11);
        p1.add(l12);
        p1.add(l13);
        p1.add(l14);
        p1.add(l15);

        p1.add(ll2);
        p1.add(ll3);
        p1.add(ll4);
        p1.add(ll5);
        p1.add(ll6);
        p1.add(ll7);
        p1.add(ll8);
        p1.add(ll9);
        p1.add(ll10);
        p1.add(ll11);
        p1.add(ll12);

        p1.add(b1);
        p1.add(lp);
        p1.setBackground(Color.white);
        add(p1);
        b1.addActionListener(this);
        b1.addKeyListener(this);
        setVisible(true);

        try {
            Class.forName("oracle.jdbc.driver.OracleDriver");
            Connection c = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "system", "manish");
            Statement s = c.createStatement();
            String sql = "Select applicantid,name,husbandname,permanentadd,district,city,dob,bg,vehicletype1,vehicletype2,applydate,photoaddress,signatureaddress,relation,fathername from applicationdl ORDER BY applicantid";
            ResultSet rs = s.executeQuery(sql);
            if (rs.next()) {
                ll1.setText(rs.getString(1));
                ll2.setText(rs.getString(2));
                hname = (rs.getString(3));
                ll4.setText(rs.getString(4));
                ll5.setText(rs.getString(5));
                ll6.setText(rs.getString(6));
                ll7.setText("BIHAR");
                ll8.setText(rs.getString(7));
                ll9.setText(rs.getString(8));
                ll10.setText(rs.getString(9) + "," + rs.getString(10));
                ll11.setText(rs.getString(11));
                ll12.setText("None");
                img = rs.getString(12);
                relation = rs.getString(14);
                fname = rs.getString(15);
            }
        } catch (Exception e) {
            System.out.print(e.getMessage());
        }
        try {
            BufferedImage bimg = ImageIO.read(new File(img));
            int width = bimg.getWidth();
            int height = bimg.getHeight();

            lp.setSize(width, height);
            lp.setIcon(new ImageIcon(img));

            if (width > 185 || height > 185) {
                Toolkit kit = Toolkit.getDefaultToolkit();
                Image im = kit.getImage(img);
                Image ima = im.getScaledInstance(185, 185, Image.SCALE_DEFAULT);
                lp.setSize(185, 185);
                lp.setIcon(new ImageIcon(ima));
            }
        } catch (Exception eeee) {
        }

        if (relation.equals("S/O")) {
            ll3.setText(fname);
        }
        if (relation.equals("D/O")) {
            ll3.setText(fname);
        }
        if (relation.equals("W/O")) {
            ll3.setText(hname);
        }

    }

    // ---------------------------------------------------------------------------------------------------------------------------------------------------------------
    appdrivingform(String x) {
        setTitle("Application Driving Licence");
        setSize(1050, 700);
        setResizable(false);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout());
        setIconImage(Toolkit.getDefaultToolkit().getImage("hicon.png"));

        p1.setLayout(null);
        p1.setSize(1000, 700);

        // panel2.setBackground(Color.white);
        try {
            UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel");
        } catch (Exception e) {
        }

        ldate = new JLabel(df.format(date));
        ldate.setFont(new Font("Bookman Old Style", Font.PLAIN, 15));
        lhead = new JLabel("<html><b><u>Driving Licence Report</html>");
        lhead.setFont(new Font("Arial", Font.PLAIN, 15));
        l1 = new JLabel(new ImageIcon("indian.png"));

        l2 = new JLabel("INDIAN TRANSPORT DEPARTMENT");
        l2.setFont(new Font("Bookman Old Style", Font.PLAIN, 20));
        l3 = new JLabel("GOVERNMENT OF BIHAR");
        l3.setFont(new Font("Bookman Old Style", Font.PLAIN, 19));

        l4 = new JLabel("Applicant Id :");
        l4.setFont(new Font("Bookman Old Style", Font.PLAIN, 17));
        l5 = new JLabel("Name :");
        l5.setFont(new Font("Bookman Old Style", Font.PLAIN, 17));
        l6 = new JLabel("S/W/D of :");
        l6.setFont(new Font("Bookman Old Style", Font.PLAIN, 17));
        l7 = new JLabel("Address :");
        l7.setFont(new Font("Bookman Old Style", Font.PLAIN, 17));
        l8 = new JLabel("District :");
        l8.setFont(new Font("Bookman Old Style", Font.PLAIN, 17));
        l9 = new JLabel("City :");
        l9.setFont(new Font("Bookman Old Style", Font.PLAIN, 17));
        l10 = new JLabel("State :");
        l10.setFont(new Font("Bookman Old Style", Font.PLAIN, 17));
        l11 = new JLabel("Date Of Birth :");
        l11.setFont(new Font("Bookman Old Style", Font.PLAIN, 17));
        l12 = new JLabel("Blood Group :");
        l12.setFont(new Font("Bookman Old Style", Font.PLAIN, 17));
        l13 = new JLabel("Type of Vehicle :");
        l13.setFont(new Font("Bookman Old Style", Font.PLAIN, 17));
        l14 = new JLabel("Issued On :");
        l14.setFont(new Font("Bookman Old Style", Font.PLAIN, 17));
        l15 = new JLabel("Valid Till :");
        l15.setFont(new Font("Bookman Old Style", Font.PLAIN, 17));
        lp = new JLabel();
        lp.setBorder(BorderFactory.createLineBorder(Color.black));
        ls = new JLabel();
        ls.setBorder(BorderFactory.createLineBorder(Color.black));

        ll1 = new JLabel();
        ll1.setFont(new Font("Bookman Old Style", Font.PLAIN, 15));
        ll2 = new JLabel();
        ll2.setFont(new Font("Bookman Old Style", Font.PLAIN, 15));
        ll3 = new JLabel();
        ll3.setFont(new Font("Bookman Old Style", Font.PLAIN, 15));
        ll4 = new JLabel();
        ll4.setFont(new Font("Bookman Old Style", Font.PLAIN, 15));
        ll5 = new JLabel();
        ll5.setFont(new Font("Bookman Old Style", Font.PLAIN, 15));
        ll6 = new JLabel();
        ll6.setFont(new Font("Bookman Old Style", Font.PLAIN, 15));
        ll7 = new JLabel();
        ll7.setFont(new Font("Bookman Old Style", Font.PLAIN, 15));
        ll8 = new JLabel();
        ll8.setFont(new Font("Bookman Old Style", Font.PLAIN, 15));
        ll9 = new JLabel();
        ll9.setFont(new Font("Bookman Old Style", Font.PLAIN, 15));
        ll10 = new JLabel();
        ll10.setFont(new Font("Bookman Old Style", Font.PLAIN, 15));
        ll11 = new JLabel();
        ll11.setFont(new Font("Bookman Old Style", Font.PLAIN, 15));
        ll12 = new JLabel();
        ll12.setFont(new Font("Bookman Old Style", Font.PLAIN, 15));

        b1 = new JButton("PRINT");
        b1.setFont(new Font("Arial", Font.PLAIN, 13));

        l1.setBounds(300, 20, 70, 100);
        l2.setBounds(400, 20, 600, 50);
        ldate.setBounds(900, 10, 100, 30);
        sep.setBounds(380, 70, 400, 30);

        l3.setBounds(450, 70, 400, 50);
        lhead.setBounds(480, 120, 300, 50);
        lp.setBounds(800, 180, 200, 200);
        ls.setBounds(800, 380, 200, 100);

        l4.setBounds(310, 170, 220, 30);
        ll1.setBounds(480, 170, 300, 30);
        l5.setBounds(360, 210, 220, 30);
        ll2.setBounds(480, 210, 300, 30);
        l6.setBounds(330, 250, 220, 30);
        ll3.setBounds(480, 250, 300, 30);

        l7.setBounds(340, 290, 300, 30);
        ll4.setBounds(480, 290, 500, 30);
        l8.setBounds(345, 340, 300, 30);
        ll5.setBounds(480, 340, 300, 30);

        l9.setBounds(373, 380, 300, 30);
        ll6.setBounds(480, 380, 300, 30);
        l10.setBounds(362, 420, 300, 30);
        ll7.setBounds(480, 420, 300, 30);
        l11.setBounds(293, 460, 300, 30);
        ll8.setBounds(480, 460, 300, 30);
        l12.setBounds(295, 500, 300, 30);
        ll9.setBounds(480, 500, 300, 30);
        l13.setBounds(275, 540, 300, 30);
        ll10.setBounds(480, 540, 300, 30);
        l14.setBounds(315, 580, 300, 30);
        ll11.setBounds(480, 580, 300, 30);
        l15.setBounds(327, 620, 300, 30);
        ll12.setBounds(480, 620, 300, 30);
        b1.setBounds(900, 600, 100, 30);

        p1.add(ldate);
        p1.add(l1);
        p1.add(l2);
        p1.add(lhead);
        p1.add(sep);
        p1.add(l3);
        p1.add(l4);
        p1.add(ll1);
        p1.add(l5);
        p1.add(l6);
        p1.add(l7);
        p1.add(l8);
        p1.add(l9);
        p1.add(l10);
        p1.add(l11);
        p1.add(l12);
        p1.add(l13);
        p1.add(l14);
        p1.add(l15);

        p1.add(ll2);
        p1.add(ll3);
        p1.add(ll4);
        p1.add(ll5);
        p1.add(ll6);
        p1.add(ll7);
        p1.add(ll8);
        p1.add(ll9);
        p1.add(ll10);
        p1.add(ll11);
        p1.add(ll12);

        p1.add(b1);
        p1.add(lp);
        // p1.add(ls);

        p1.setBackground(Color.white);
        add(p1);
        b1.addActionListener(this);
        b1.addKeyListener(this);
        setVisible(true);

        try {
            Class.forName("oracle.jdbc.driver.OracleDriver");
            Connection c = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "system", "manish");
            Statement s = c.createStatement();
            String sql = "Select applicantid,name,husbandname,permanentadd,district,city,dob,bg,vehicletype1,vehicletype2,applydate,photoaddress,signatureaddress,relation,fathername from applicationdl where applicantid='"
                    + x + "' ORDER BY applicantid";
            ResultSet rs = s.executeQuery(sql);
            if (rs.next()) {
                ll1.setText(rs.getString(1));
                ll2.setText(rs.getString(2));
                hname = (rs.getString(3));
                ll4.setText(rs.getString(4));
                ll5.setText(rs.getString(5));
                ll6.setText(rs.getString(6));
                ll7.setText("BIHAR");
                ll8.setText(rs.getString(7));
                ll9.setText(rs.getString(8));
                ll10.setText(rs.getString(9) + "," + rs.getString(10));
                ll11.setText(rs.getString(11));
                ll12.setText("None");
                img = rs.getString(12);
                // lp.setIcon(new ImageIcon(rs.getString(12)));
                // ls.setIcon(new ImageIcon(rs.getString(13)));
                relation = rs.getString(14);
                fname = rs.getString(15);
            }
        } catch (Exception e) {
            System.out.print(e.getMessage());
        }
        try {
            BufferedImage bimg = ImageIO.read(new File(img));
            int width = bimg.getWidth();
            int height = bimg.getHeight();

            lp.setSize(width, height);
            lp.setIcon(new ImageIcon(img));

            if (width > 185 || height > 185) {
                Toolkit kit = Toolkit.getDefaultToolkit();
                Image im = kit.getImage(img);
                Image ima = im.getScaledInstance(185, 185, Image.SCALE_DEFAULT);
                lp.setSize(185, 185);
                lp.setIcon(new ImageIcon(ima));
            }
        } catch (Exception eeee) {
        }

        if (relation.equals("S/O")) {
            ll3.setText(fname);
        }
        if (relation.equals("D/O")) {
            ll3.setText(fname);
        }
        if (relation.equals("W/O")) {
            ll3.setText(hname);
        }
    }

    public void actionPerformed(ActionEvent e) {
        PrinterJob job = PrinterJob.getPrinterJob();
        job.setPrintable(this);
        boolean ok = job.printDialog();
        if (ok) {
            try {
                job.print();
            } catch (Exception ee) {
            }
        }

    }

    public void keyPressed(KeyEvent e) {
        // System.out.print(e.getKeyCode());
        if (e.getKeyCode() == 27) {
            dispose();
        }
    }

    public void keyTyped(KeyEvent e) {

    }

    public void keyReleased(KeyEvent e) {
    }

    public int print(Graphics g, PageFormat pf, int page) throws PrinterException {

        if (page > 0) { /* We have only one page, and 'page' is zero-based */
            return NO_SUCH_PAGE;
        }

        Graphics2D g2d = (Graphics2D) g;
        g2d.translate(pf.getImageableX(), pf.getImageableY());

        return PAGE_EXISTS;
    }

    public static void main(String c[]) {
        new appdrivingform();
    }
}
