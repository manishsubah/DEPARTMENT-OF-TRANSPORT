import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.sql.*;

class createtables extends JFrame implements ActionListener, KeyListener {
    JButton createTables, chgPassword, deleteRecord, close, deleteTables;
    TextArea ta;

    createtables() {
        setTitle("Database");
        setSize(400, 300);
        setIconImage(Toolkit.getDefaultToolkit().getImage("hicon.png"));
        setResizable(false);
        setLocationRelativeTo(null);
        try {
            UIManager.setLookAndFeel("com.sun.java.swing.plaf.nimbus.NimbusLookAndFeel");
            // UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel");
        } catch (Exception e) {
            System.out.print("manish");
        }
        setLayout(new GridLayout(3, 1));
        createTables = new JButton("Create Tables");
        add(createTables);
        createTables.setFont(new Font("Book Antiqua", Font.BOLD, 13));
        createTables.setForeground(new Color(0, 98, 143));
        deleteTables = new JButton("deleteTables");
        add(deleteTables);
        deleteTables.setFont(new Font("Book Antiqua", Font.BOLD, 13));
        deleteTables.setForeground(new Color(0, 98, 143));
        chgPassword = new JButton("Change Master Password");
        add(chgPassword);
        chgPassword.setFont(new Font("Book Antiqua", Font.BOLD, 13));
        chgPassword.setForeground(new Color(0, 98, 143));
        deleteRecord = new JButton("Delete Full Records");
        add(deleteRecord);
        deleteRecord.setFont(new Font("Book Antiqua", Font.BOLD, 13));
        deleteRecord.setForeground(new Color(0, 98, 143));
        close = new JButton("Close");
        add(close);
        close.setFont(new Font("Book Antiqua", Font.BOLD, 13));
        close.setForeground(new Color(0, 98, 143));
        ta = new TextArea();
        add(ta);
        ta.setEditable(false);
        createTables.addActionListener(this);
        createTables.addKeyListener(this);
        chgPassword.addActionListener(this);
        chgPassword.addKeyListener(this);
        deleteRecord.addActionListener(this);
        deleteRecord.addKeyListener(this);
        close.addActionListener(this);
        close.addKeyListener(this);
        deleteTables.addActionListener(this);
        deleteTables.addKeyListener(this);
        ta.addKeyListener(this);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {
        try {
            Class.forName("oracle.jdbc.driver.OracleDriver");
            Connection c=
            DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","manish");
            ta.setText("Connecting...");
            Statement s = c.createStatement();
            if (e.getSource() == createTables) {
                
                ta.setText(ta.getText() + "\nCreating Tables...");
                s.executeUpdate(
                        "CREATE TABLE admintor(masterpasswd VARCHAR(100),red INTEGER,green INTEGER,blue INTEGER)");
                ta.setText(ta.getText() + "\nTable1 created successfully...");
                s.executeUpdate(
                        "CREATE TABLE nuser(createdate VARCHAR(255)," + "staffid VARCHAR(255)," + "name VARCHAR(255),"
                                + "mobile VARCHAR(255)," + "password VARCHAR(255)," + "photoaddress VARCHAR(255))");
                ta.setText(ta.getText() + "\nTable2 created successfully...");
                s.executeUpdate(
                        "CREATE TABLE login(serialno varchar(4),ldate VARCHAR(255),staffid VARCHAR(255),staffusername VARCHAR(255))");
                ta.setText(ta.getText() + "\nTable3 created successfully...");
                s.executeUpdate(
                        "CREATE TABLE feeparticulardescription(applydate VARCHAR(255),applicantid VARCHAR(255),name VARCHAR(255),dob VARCHAR(255),feeoption VARCHAR(255),fee VARCHAR(255),vehicletype1 VARCHAR(255),vehicletype2 VARCHAR(255))");
                ta.setText(ta.getText() + "\nTable4 created successfully...");
                s.executeUpdate(
                        "CREATE TABLE feeappdl(applydate VARCHAR(255),applicantid VARCHAR(255),learnerlicense VARCHAR(255),feeoption VARCHAR(255),fee VARCHAR(255),name VARCHAR(255),swd VARCHAR(255),dob VARCHAR(255),vehicletype1 VARCHAR(255),vehicletype2 VARCHAR(255))");
                ta.setText(ta.getText() + "\nTable5 created successfully...");
                s.executeUpdate(
                        "CREATE TABLE applicationlearner(formno VARCHAR(255),applydate VARCHAR(255),applicantid VARCHAR(255),name VARCHAR(255),sex VARCHAR(255),relation VARCHAR(255),husbandname VARCHAR(255),fathername VARCHAR(255),dob VARCHAR(255),bg VARCHAR(255),permanentadd VARCHAR(255),villtown VARCHAR(255),district VARCHAR(255),city VARCHAR(255),pin1 VARCHAR(255),identity1 VARCHAR(255),identity2 VARCHAR(255),photoproof VARCHAR(255),addressproof VARCHAR(255),bgproof VARCHAR(255),presentadd1 VARCHAR(255),presentadd2 VARCHAR(255),pin2 VARCHAR(255),email VARCHAR(255),addhar VARCHAR(255),mobile VARCHAR(255),vehicletype1 VARCHAR(255),vehicletype2 VARCHAR(255),photoaddress VARCHAR(255),signatureaddress VARCHAR(255),thumbaddress VARCHAR(255),status VARCHAR(255))");
                ta.setText(ta.getText() + "\nTable6 created successfully...");
                s.executeUpdate("CREATE TABLE applicationdl(formno VARCHAR(255)," + "applydate VARCHAR(255),"
                        + "applicantid VARCHAR(255)," + "name VARCHAR(255)," + "sex VARCHAR(255),"
                        + "relation VARCHAR(255)," + "husbandname VARCHAR(255)," + "fathername VARCHAR(255),"
                        + "dob VARCHAR(255)," + "bg VARCHAR(255)," + "permanentadd VARCHAR(255),"
                        + "villtown VARCHAR(255)," + "district VARCHAR(255)," + "city VARCHAR(255),"
                        + "pin1 VARCHAR(255),learnerlicense VARCHAR(255)," + "identity1 VARCHAR(255),"
                        + "identity2 VARCHAR(255)," + "photoproof VARCHAR(255)," + "addressproof VARCHAR(255),"
                        + "bgproof VARCHAR(255)," + "presentadd1 VARCHAR(255)," + "presentadd2 VARCHAR(255),"
                        + "pin2 VARCHAR(255)," + "email VARCHAR(255)," + "addhar VARCHAR(255)," + "mobile VARCHAR(255),"
                        + "vehicletype1 VARCHAR(255),vehicletype2 VARCHAR(255)," + "photoaddress VARCHAR(255),"
                        + "signatureaddress VARCHAR(255)," + "thumbaddress VARCHAR(255),status VARCHAR(255))");
                ta.setText(ta.getText() + "\nTable7 created successfully...");
                s.executeUpdate("CREATE TABLE learnerlicense(formno VARCHAR(255)," + "applydate VARCHAR(255),"
                        + "applicantid VARCHAR(255)," + "name VARCHAR(255)," + "sex VARCHAR(255),"
                        + "relation VARCHAR(255)," + "husbandname VARCHAR(255)," + "fathername VARCHAR(255),"
                        + "dob VARCHAR(255)," + "bg VARCHAR(255)," + "permanentadd VARCHAR(255),"
                        + "villtown VARCHAR(255)," + "district VARCHAR(255)," + "city VARCHAR(255),"
                        + "pin1 VARCHAR(255)," + "identity1 VARCHAR(255)," + "identity2 VARCHAR(255),"
                        + "photoproof VARCHAR(255)," + "addressproof VARCHAR(255)," + "bgproof VARCHAR(255),"
                        + "presentadd1 VARCHAR(255)," + "presentadd2 VARCHAR(255)," + "pin2 VARCHAR(255),"
                        + "email VARCHAR(255)," + "addhar VARCHAR(255)," + "mobile VARCHAR(255),"
                        + "vehicletype1 VARCHAR(255),vehicletype2 VARCHAR(255)," + "photoaddress VARCHAR(255),"
                        + "signatureaddress VARCHAR(255),"
                        + "thumbaddress VARCHAR(255),uptovalid VARCHAR(255),learnerlicenseno VARCHAR(255),status VARCHAR(255))");
                ta.setText(ta.getText() + "\nTable8 created successfully...");
                s.executeUpdate("CREATE TABLE drivinglicense(formno VARCHAR(255)," + "applydate VARCHAR(255),"
                        + "applicantid VARCHAR(255)," + "name VARCHAR(255)," + "sex VARCHAR(255),"
                        + "relation VARCHAR(255)," + "husbandname VARCHAR(255)," + "fathername VARCHAR(255),"
                        + "dob VARCHAR(255)," + "bg VARCHAR(255)," + "permanentadd VARCHAR(255),"
                        + "villtown VARCHAR(255)," + "district VARCHAR(255)," + "city VARCHAR(255),"
                        + "pin1 VARCHAR(255)," + "learnerlicenseno VARCHAR(255)," + "identity1 VARCHAR(255),"
                        + "identity2 VARCHAR(255)," + "photoproof VARCHAR(255)," + "addressproof VARCHAR(255),"
                        + "bgproof VARCHAR(255)," + "presentadd1 VARCHAR(255)," + "presentadd2 VARCHAR(255),"
                        + "pin2 VARCHAR(255)," + "email VARCHAR(255)," + "addhar VARCHAR(255)," + "mobile VARCHAR(255),"
                        + "vehicletype1 VARCHAR(255),vehicletype2 VARCHAR(255)," + "photoaddress VARCHAR(255),"
                        + "signatureaddress VARCHAR(255),"
                        + "thumbaddress VARCHAR(255),uptovalid VARCHAR(255),dlnumber VARCHAR(255),status VARCHAR(255))");
                ta.setText(ta.getText() + "\nTable9 created successfully...");
                s.executeUpdate("CREATE TABLE passwordupdation(staffid VARCHAR(255)," + "changedate VARCHAR(255),"
                        + "oldpassword VARCHAR(255)," + "newpassword VARCHAR(255))");
                ta.setText(ta.getText() + "\nTable10 created successfully...");
                s.executeUpdate(
                        "CREATE TABLE applearnerstatus(applicantid VARCHAR(100),applydate VARCHAR(100),name VARCHAR(100),husbandname VARCHAR(100),fathername VARCHAR(100),dob VARCHAR(100),bg VARCHAR(100),mobile VARCHAR(100),status VARCHAR(100))");
                ta.setText(ta.getText() + "\nTable11 created successfully...");
                s.executeUpdate(
                        "CREATE TABLE appdlstatus(applicantid VARCHAR(100),applydate VARCHAR(100),name VARCHAR(100),husbandname VARCHAR(100),fathername VARCHAR(100),dob VARCHAR(100),bg VARCHAR(100),mobile VARCHAR(100),status VARCHAR(100))");
                ta.setText(ta.getText() + "\nTable12 created successfully...");
                JOptionPane.showMessageDialog(this, "Tables are created successfully.", "Administer",
                        JOptionPane.INFORMATION_MESSAGE);
                s.executeUpdate("insert into admintor values('manish',255,255,255)");
            } else if (e.getSource() == chgPassword) {
                String result = JOptionPane.showInputDialog(this, "Enter the master password :",
                        "Change Master Password", JOptionPane.PLAIN_MESSAGE);
                if (!((result.equals(null)) || (result.equals("")))) {
                    s.executeUpdate("UPDATE admintor SET masterpasswd='" + result + "' ");
                } else if (result.equals("")) {
                    JOptionPane.showMessageDialog(this, "Please Enter Password or Blank Field is not accepted.",
                            "Administer", JOptionPane.INFORMATION_MESSAGE);
                }
            } else if (e.getSource() == deleteRecord) {
                s.executeUpdate("DELETE FROM feeappdl");
                s.executeUpdate("DELETE FROM feeparticulardescription");
                s.executeUpdate("DELETE FROM login");
                s.executeUpdate("DELETE FROM passwordupdation");
                s.executeUpdate("DELETE FROM applicationdl");
                s.executeUpdate("DELETE FROM drivinglicense");
                s.executeUpdate("DELETE FROM learnerlicense");
                s.executeUpdate("DELETE FROM applicationlearner");
                s.executeUpdate("DELETE FROM nuser");
                s.executeUpdate("DELETE FROM applearnerstatus");
                s.executeUpdate("DELETE FROM appdlstatus");
                JOptionPane.showMessageDialog(this, "All Records Deleted.", "Administer",
                        JOptionPane.INFORMATION_MESSAGE);
            } else if (e.getSource() == deleteTables) {
                ta.setText("Dropping Tables...");
                s.executeUpdate("DROP TABLE admintor");
                ta.setText(ta.getText() + "\nTable1 dropped successfully...");
                s.executeUpdate("DROP TABLE nuser");
                ta.setText(ta.getText() + "\nTable2 dropped successfully...");
                s.executeUpdate("DROP TABLE login");
                ta.setText(ta.getText() + "\nTable3 dropped successfully...");
                s.executeUpdate("DROP TABLE feeparticulardescription");
                ta.setText(ta.getText() + "\nTable4 dropped successfully...");
                s.executeUpdate("DROP TABLE feeappdl");
                ta.setText(ta.getText() + "\nTable5 dropped successfully...");
                s.executeUpdate("DROP TABLE applicationlearner");
                ta.setText(ta.getText() + "\nTable6 dropped successfully...");
                s.executeUpdate("DROP TABLE applicationdl");
                ta.setText(ta.getText() + "\nTable7 dropped successfully...");
                s.executeUpdate("DROP TABLE learnerlicense");
                ta.setText(ta.getText() + "\nTable8 dropped successfully...");
                s.executeUpdate("DROP TABLE drivinglicense");
                ta.setText(ta.getText() + "\nTable9 dropped successfully...");
                s.executeUpdate("DROP TABLE passwordupdation");
                ta.setText(ta.getText() + "\nTable10 dropped successfully...");
                s.executeUpdate("DROP TABLE applearnerstatus");
                ta.setText(ta.getText() + "\nTable11 dropped successfully...");
                s.executeUpdate("DROP TABLE appdlstatus");
                ta.setText(ta.getText() + "\nTable12 dropped successfully...");
            } else if (e.getSource() == close) {
                dispose();
            }
            c.close();
        } catch (Exception ec) {
            System.out.print(ec.getMessage());
        }
    }

    public void keyPressed(KeyEvent e) {
        if (e.getKeyCode() == 10) {
            if (e.getSource() == close) {
                dispose();
            }
        }
        if (e.getKeyCode() == 27) {
            dispose();
        }
    }

    public void keyTyped(KeyEvent e) {
        if (e.getSource() == ta) {
            e.consume();
        }
    }

    public void keyReleased(KeyEvent e) {
    }

    public static void main(String c[]) {
        new createtables();
    }
}
