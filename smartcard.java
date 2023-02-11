import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.sql.*;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.awt.print.*;
import java.io.File;
import java.awt.image.BufferedImage;
import javax.imageio.ImageIO;

class smartcard extends JFrame implements Printable, ActionListener, KeyListener {
    String fname = "", hname = "", relation = "", add = "";
    PrinterJob pj = PrinterJob.getPrinterJob();
    javax.print.attribute.HashPrintRequestAttributeSet att = new javax.print.attribute.HashPrintRequestAttributeSet();
    JLabel l12, ll9, l13, ll10, l14, ll11, l15, ll12, l7, ll4, ldate, lp, ls, l11, ll8, l1, l2, l3, l4, lhead, l5, ll2,
            ll3, l6;
    JSeparator sep = new JSeparator(JSeparator.HORIZONTAL);
    JButton b1;
    JPanel p1 = new JPanel();
    JPanel panel2 = new JPanel();
    DateFormat df = new SimpleDateFormat("dd/MM/yyyy");
    Date date = new Date();
    String img = "", sig = "";
    Image img1, img2;

    smartcard() {
        setTitle("Driving Licence");
        setSize(550, 450);
        setIconImage(Toolkit.getDefaultToolkit().getImage("hicon.png"));
        setResizable(false);
        setLocationRelativeTo(null);
        setLayout(null);

        p1.setLayout(null);
        panel2.setBounds(0, 0, 550, 100);
        p1.setBounds(0, 100, 550, 260);
        panel2.setLayout(null);
        panel2.setBackground(Color.white);
        try {
            UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel");
        } catch (Exception e) {
        }

        try {
            Toolkit kit = Toolkit.getDefaultToolkit();
            img1 = kit.getImage("indian.png");
            img1 = img1.getScaledInstance(40, 70, Image.SCALE_DEFAULT);

        } catch (Exception eeee) {
        }
        ;

        l1 = new JLabel(new ImageIcon(img1));
        try {
            Toolkit kit = Toolkit.getDefaultToolkit();
            img2 = kit.getImage("sec.png");
            img2 = img2.getScaledInstance(70, 50, Image.SCALE_DEFAULT);

        } catch (Exception eeee) {
        }
        

        ldate = new JLabel();
        lhead = new JLabel(new ImageIcon(img2));
        lhead.setBorder(BorderFactory.createLineBorder(Color.black));
        l2 = new JLabel("INDIAN DRIVING LICENCE");
        
        l2.setFont(new Font("Bookman Old Style", Font.PLAIN, 18));
        //l3 = new JLabel("GOVERNMENT OF BIHAR");
        l3 = new JLabel("GOVERNMENT OF BIHAR");
        l3.setFont(new Font("Bookman Old Style", Font.PLAIN, 14));

        l4 = new JLabel("DL : 122568902");
        l4.setFont(new Font("Arial", Font.PLAIN, 17));
        l4.setForeground(Color.blue);

        l5 = new JLabel("Name :");
        l5.setFont(new Font("Arial", Font.PLAIN, 15));
        l5.setForeground(Color.blue);
        l6 = new JLabel("S/W/D of   :");
        l6.setForeground(Color.blue);
        l6.setFont(new Font("Arial", Font.PLAIN, 15));
        l7 = new JLabel("Address :");
        l7.setForeground(Color.blue);
        l7.setFont(new Font("Arial", Font.PLAIN, 15));
        l11 = new JLabel("D.O.B :");
        l11.setForeground(Color.blue);
        l11.setFont(new Font("Arial", Font.PLAIN, 15));
        l12 = new JLabel("BG :");
        l12.setFont(new Font("Arial", Font.PLAIN, 15));
        l12.setForeground(Color.blue);
        l13 = new JLabel("Type of Vehicle(s) :");
        l13.setFont(new Font("Arial", Font.PLAIN, 15));
        l13.setForeground(Color.blue);
        l14 = new JLabel("Issued On :");
        l14.setFont(new Font("Arial", Font.PLAIN, 15));
        l14.setForeground(Color.blue);
        l15 = new JLabel("Valid Till :");
        l15.setForeground(Color.blue);
        l15.setFont(new Font("Arial", Font.PLAIN, 15));
        lp = new JLabel();
        lp.setBorder(BorderFactory.createLineBorder(Color.black));
        ls = new JLabel();
        ls.setBorder(BorderFactory.createLineBorder(Color.black));

        ll2 = new JLabel("John Right");
        ll2.setFont(new Font("Arial", Font.BOLD, 17));
        ll3 = new JLabel("Johnson Right");
        ll3.setFont(new Font("Arial", Font.BOLD, 17));
        ll4 = new JLabel("New York");
        ll4.setFont(new Font("Arial", Font.PLAIN, 14));
        ll8 = new JLabel("12/02/2001");
        ll8.setFont(new Font("Arial", Font.BOLD, 17));
        ll9 = new JLabel("AB");
        ll9.setFont(new Font("Arial", Font.BOLD, 17));
        ll10 = new JLabel("LMV");
        ll10.setFont(new Font("Arial", Font.BOLD, 17));
        ll11 = new JLabel("12/05/2022");
        ll11.setFont(new Font("Arial", Font.BOLD, 17));
        ll12 = new JLabel("12/05/2044");
        ll12.setFont(new Font("Arial", Font.BOLD, 17));

        b1 = new JButton("PRINT");
        b1.setFont(new Font("Arial", Font.PLAIN, 13));

        l1.setBounds(10, 4, 70, 100);

        l2.setBounds(150, 2, 300, 50);
        sep.setBounds(135, 40, 270, 30);
        l3.setBounds(180, 35, 200, 30);
        l4.setBounds(350, 70, 220, 30);
        lhead.setBounds(20, 20, 70, 50);

        l5.setBounds(110, 10, 100, 30);
        ll2.setBounds(200, 10, 300, 30);
        l6.setBounds(110, 40, 100, 30);
        ll3.setBounds(200, 40, 300, 30);
        l7.setBounds(110, 70, 100, 30);
        ll4.setBounds(200, 70, 300, 30);
        ldate.setBounds(200, 85, 300, 30);
        lp.setBounds(430, 13, 100, 70);
        ls.setBounds(430, 120, 150, 30);
        l11.setBounds(110, 120, 100, 30);
        ll8.setBounds(200, 120, 200, 30);
        l12.setBounds(300, 120, 50, 30);
        ll9.setBounds(335, 120, 50, 30);
        l13.setBounds(110, 150, 200, 30);
        ll10.setBounds(250, 150, 200, 30);
        l14.setBounds(110, 180, 200, 30);
        ll11.setBounds(200, 180, 200, 30);
        l15.setBounds(110, 210, 200, 30);
        ll12.setBounds(200, 210, 200, 30);

        b1.setBounds(410, 380, 100, 30);

        panel2.add(l1);
        panel2.add(l2);
        panel2.add(l3);
        panel2.add(sep);
        panel2.add(l4);
        p1.add(lhead);
        p1.add(l5);
        p1.add(ll2);
        p1.add(l6);
        p1.add(ll3);
        p1.add(l7);
        p1.add(ll4);
        p1.add(ldate);
        p1.add(lp);
        p1.add(ls);
        p1.add(l11);
        p1.add(ll8);
        p1.add(l12);
        p1.add(ll9);
        p1.add(l13);
        p1.add(ll10);
        p1.add(l14);
        p1.add(ll11);
        p1.add(l15);
        p1.add(ll12);

        p1.setBackground(Color.yellow);
        add(panel2);
        add(p1);
        add(b1);
        b1.addActionListener(this);
        b1.addKeyListener(this);
        img = "profile.jpg";
        sig = "sign.jpg";
        setVisible(true);

        try {
            Class.forName("oracle.jdbc.driver.OracleDriver");
            Connection c = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "system", "manish");
            Statement s = c.createStatement();
            String sql = "Select dlnumber,name,husbandname,permanentadd,district,city,dob,bg,vehicletype1,vehicletype2,applydate,photoaddress,signatureaddress,relation,fathername,uptovalid from drivinglicense ORDER BY applicantid";
            ResultSet rs = s.executeQuery(sql);
            if (rs.next()) {
                l4.setText(l4.getText() + rs.getString(1));
                ll2.setText(rs.getString(2));
                hname = (rs.getString(3));
                ll4.setText(rs.getString(4));
                ldate.setText("DIS " + rs.getString(5) + "," + rs.getString(6) + "," + "BIHAR");
                ll8.setText(rs.getString(7));
                ll9.setText(rs.getString(8));
                ll10.setText(rs.getString(9) + "," + rs.getString(10));
                ll11.setText(rs.getString(11));
                ll12.setText(rs.getString(16));
                img = rs.getString(12);
                
                sig = rs.getString(13);

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
                Image ima = im.getScaledInstance(100, 100, Image.SCALE_DEFAULT);
                lp.setSize(100, 100);
                lp.setIcon(new ImageIcon(ima));
            }
            Toolkit kit = Toolkit.getDefaultToolkit();
            Image imm = kit.getImage(sig);

            imm = imm.getScaledInstance(100, 40, Image.SCALE_DEFAULT);
            ls.setSize(100, 40);
            ls.setIcon(new ImageIcon(imm));

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

    // -------------------------------------------------------------------------------------------------------------------------------------------------------------

    smartcard(String get1) {
        setTitle("Driving Licence");
        setSize(550, 450);
        setIconImage(Toolkit.getDefaultToolkit().getImage("hicon.png"));
        setResizable(false);
        setLocationRelativeTo(null);
        setLayout(null);

        p1.setLayout(null);
        panel2.setBounds(0, 0, 550, 100);
        p1.setBounds(0, 100, 550, 260);
        panel2.setLayout(null);
        panel2.setBackground(Color.white);
        try {
            UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel");
        } catch (Exception e) {
        }

        try {
            Toolkit kit = Toolkit.getDefaultToolkit();
            img1 = kit.getImage("indian.png");
            img1 = img1.getScaledInstance(40, 70, Image.SCALE_DEFAULT);

        } catch (Exception eeee) {
        }
        ;

        l1 = new JLabel(new ImageIcon(img1));
        try {
            Toolkit kit = Toolkit.getDefaultToolkit();
            img2 = kit.getImage("sec.png");
            img2 = img2.getScaledInstance(70, 50, Image.SCALE_DEFAULT);

        } catch (Exception eeee) {
        }
        ;

        ldate = new JLabel();
        lhead = new JLabel(new ImageIcon(img2));
        lhead.setBorder(BorderFactory.createLineBorder(Color.black));
        l2 = new JLabel("INDIAN DRIVING LICENCE");
        l2.setFont(new Font("Bookman Old Style", Font.PLAIN, 18));
        l3 = new JLabel("GOVERNMENT OF BIHAR");
        l3.setFont(new Font("Bookman Old Style", Font.PLAIN, 14));

        l4 = new JLabel("DL : ");
        l4.setFont(new Font("Arial", Font.PLAIN, 17));
        l4.setForeground(Color.blue);

        l5 = new JLabel("Name :");
        l5.setFont(new Font("Arial", Font.PLAIN, 15));
        l5.setForeground(Color.blue);
        l6 = new JLabel("S/W/D of   :");
        l6.setForeground(Color.blue);
        l6.setFont(new Font("Arial", Font.PLAIN, 15));
        l7 = new JLabel("Address :");
        l7.setForeground(Color.blue);
        l7.setFont(new Font("Arial", Font.PLAIN, 15));
        l11 = new JLabel("D.O.B :");
        l11.setForeground(Color.blue);
        l11.setFont(new Font("Arial", Font.PLAIN, 15));
        l12 = new JLabel("BG :");
        l12.setFont(new Font("Arial", Font.PLAIN, 15));
        l12.setForeground(Color.blue);
        l13 = new JLabel("Type of Vehicle(s) :");
        l13.setFont(new Font("Arial", Font.PLAIN, 15));
        l13.setForeground(Color.blue);
        l14 = new JLabel("Issued On :");
        l14.setFont(new Font("Arial", Font.PLAIN, 15));
        l14.setForeground(Color.blue);
        l15 = new JLabel("Valid Till :");
        l15.setForeground(Color.blue);
        l15.setFont(new Font("Arial", Font.PLAIN, 15));
        lp = new JLabel();
        lp.setBorder(BorderFactory.createLineBorder(Color.black));
        ls = new JLabel();
        ls.setBorder(BorderFactory.createLineBorder(Color.black));

        ll2 = new JLabel();
        ll2.setFont(new Font("Arial", Font.BOLD, 17));
        ll3 = new JLabel();
        ll3.setFont(new Font("Arial", Font.BOLD, 17));
        ll4 = new JLabel();
        ll4.setFont(new Font("Arial", Font.PLAIN, 14));
        ll8 = new JLabel();
        ll8.setFont(new Font("Arial", Font.BOLD, 17));
        ll9 = new JLabel();
        ll9.setFont(new Font("Arial", Font.BOLD, 17));
        ll10 = new JLabel();
        ll10.setFont(new Font("Arial", Font.BOLD, 17));
        ll11 = new JLabel();
        ll11.setFont(new Font("Arial", Font.BOLD, 17));
        ll12 = new JLabel();
        ll12.setFont(new Font("Arial", Font.BOLD, 17));

        b1 = new JButton("PRINT");
        b1.setFont(new Font("Arial", Font.PLAIN, 13));

        l1.setBounds(10, 4, 70, 100);

        l2.setBounds(150, 2, 300, 50);
        sep.setBounds(135, 40, 270, 30);
        l3.setBounds(180, 35, 200, 30);
        l4.setBounds(350, 70, 220, 30);
        lhead.setBounds(20, 20, 70, 50);

        l5.setBounds(110, 10, 100, 30);
        ll2.setBounds(200, 10, 300, 30);
        l6.setBounds(110, 40, 100, 30);
        ll3.setBounds(200, 40, 300, 30);
        l7.setBounds(110, 70, 100, 30);
        ll4.setBounds(200, 70, 300, 30);
        ldate.setBounds(200, 85, 300, 30);
        lp.setBounds(430, 13, 100, 70);
        ls.setBounds(430, 120, 150, 30);
        l11.setBounds(110, 120, 100, 30);
        ll8.setBounds(200, 120, 200, 30);
        l12.setBounds(300, 120, 50, 30);
        ll9.setBounds(335, 120, 50, 30);
        l13.setBounds(110, 150, 200, 30);
        ll10.setBounds(250, 150, 200, 30);
        l14.setBounds(110, 180, 200, 30);
        ll11.setBounds(200, 180, 200, 30);
        l15.setBounds(110, 210, 200, 30);
        ll12.setBounds(200, 210, 200, 30);

        b1.setBounds(410, 380, 100, 30);

        panel2.add(l1);
        panel2.add(l2);
        panel2.add(l3);
        panel2.add(sep);
        panel2.add(l4);
        p1.add(lhead);
        p1.add(l5);
        p1.add(ll2);
        p1.add(l6);
        p1.add(ll3);
        p1.add(l7);
        p1.add(ll4);
        p1.add(ldate);
        p1.add(lp);
        p1.add(ls);
        p1.add(l11);
        p1.add(ll8);
        p1.add(l12);
        p1.add(ll9);
        p1.add(l13);
        p1.add(ll10);
        p1.add(l14);
        p1.add(ll11);
        p1.add(l15);
        p1.add(ll12);

        p1.setBackground(Color.yellow);
        add(panel2);
        add(p1);
        add(b1);
        b1.addActionListener(this);
        b1.addKeyListener(this);

        setVisible(true);

        try {
            Class.forName("oracle.jdbc.driver.OracleDriver");
            Connection c = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "system", "manish");
            Statement s = c.createStatement();
            String sql = "Select dlnumber,name,husbandname,permanentadd,district,city,dob,bg,vehicletype1,vehicletype2,applydate,photoaddress,signatureaddress,relation,fathername,uptovalid from drivinglicense where learnerlicenseno='"
                    + get1 + "'";
            ResultSet rs = s.executeQuery(sql);
            if (rs.next()) {
                l4.setText(l4.getText() + rs.getString(1));
                ll2.setText(rs.getString(2));
                hname = (rs.getString(3));
                ll4.setText(rs.getString(4));
                ldate.setText("DIS " + rs.getString(5) + "," + rs.getString(6) + "," + "BIHAR");
                ll8.setText(rs.getString(7));
                ll9.setText(rs.getString(8));
                ll10.setText(rs.getString(9) + "," + rs.getString(10));
                ll11.setText(rs.getString(11));
                ll12.setText(rs.getString(16));
                img = rs.getString(12);
                sig = rs.getString(13);

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
                Image ima = im.getScaledInstance(100, 100, Image.SCALE_DEFAULT);
                lp.setSize(100, 100);
                lp.setIcon(new ImageIcon(ima));
            }
            Toolkit kit = Toolkit.getDefaultToolkit();
            Image imm = kit.getImage(sig);

            imm = imm.getScaledInstance(100, 40, Image.SCALE_DEFAULT);
            ls.setSize(100, 40);
            ls.setIcon(new ImageIcon(imm));

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
        new smartcard();
    }
}
