import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.sql.*;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.*;
import javax.swing.Timer;
import javax.swing.table.*;

class feereport extends JFrame implements ActionListener, KeyListener {
    DateFormat df = new SimpleDateFormat("MM/yyyy");
    Date date = new Date();
    String sql = "";
    JLabel l1, l2, l3;
    JTextField t1;
    JButton b1, b2;
    JCheckBox ch1, ch2, ch3, ch4;
    JPanel panel1 = new JPanel();
    JPanel panel2 = new JPanel();
    ButtonGroup g = new ButtonGroup();
    ButtonGroup g1 = new ButtonGroup();
    
    feereport() {
        setTitle("Fees Report");
        setIconImage(Toolkit.getDefaultToolkit().getImage("hicon.png"));
        setSize(600, 430);
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

        l1 = new JLabel("FEE-REPORT");
        l1.setFont(new Font("Sans-Serif", Font.BOLD, 20));
        l1.setForeground(Color.white);

        l2 = new JLabel("Searching Options:-");
        l2.setFont(new Font("Bookman Old Style", Font.PLAIN, 17));
        l3 = new JLabel("Enter Date (dd/mm/yyyy) :");
        l3.setFont(new Font("Bookman Old Style", Font.PLAIN, 17));

        b1 = new JButton("Ok");
        b2 = new JButton("Cancel");

        t1 = new JTextField();
        t1.setFont(new Font("Bookman Old Style", Font.PLAIN, 15));

        ch1 = new JCheckBox("Learner Licence Fee Report");
        ch1.setFont(new Font("Bookman Old Style", Font.PLAIN, 15));
        ch2 = new JCheckBox("Full Report");
        ch2.setFont(new Font("Bookman Old Style", Font.PLAIN, 15));
        ch3 = new JCheckBox("Particular Report");
        ch3.setFont(new Font("Bookman Old Style", Font.PLAIN, 15));
        ch4 = new JCheckBox("Driving Licence Fee Report");
        ch4.setFont(new Font("Bookman Old Style", Font.PLAIN, 15));

        g.add(ch1);
        g.add(ch4);
        g1.add(ch2);
        g1.add(ch3);
        panel1.setBounds(0, 0, 1300, 75);
        l1.setBounds(250, 25, 300, 30);

        panel2.setBounds(0, 75, 1300, 270);

        l2.setBounds(50, 30, 300, 30);
        ch1.setBounds(60, 70, 250, 30);
        ch2.setBounds(60, 120, 200, 30);
        ch3.setBounds(60, 170, 200, 30);
        ch4.setBounds(330, 70, 250, 30);

        l3.setBounds(60, 220, 250, 30);
        t1.setBounds(300, 220, 200, 30);

        b1.setBounds(330, 352, 100, 30);
        b2.setBounds(450, 352, 100, 30);

        panel1.add(l1);
        panel2.add(l2);
        panel2.add(ch1);
        panel2.add(ch2);
        panel2.add(ch3);
        panel2.add(ch4);
        panel2.add(l3);
        panel2.add(t1);

        add(panel1);
        add(panel2);
        add(b1);
        add(b2);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        b1.addActionListener(this);
        b1.addKeyListener(this);
        b2.addActionListener(this);
        b2.addKeyListener(this);
        t1.addKeyListener(this);
        ch1.addKeyListener(this);
        ch2.addKeyListener(this);
        ch3.addKeyListener(this);
        ch1.addActionListener(this);
        ch2.addActionListener(this);
        ch3.addActionListener(this);
        ch4.addActionListener(this);
        ch4.addKeyListener(this);
        t1.addKeyListener(new KeyAdapter() {
            public void keyTyped(KeyEvent e) {
                char c = e.getKeyChar();
                if (t1.getCaretPosition() == 0) {
                    if (!((c == '0') || (c == '1') || (c == '2') || (c == '3') || (c == KeyEvent.VK_BACK_SPACE)
                            || (c == KeyEvent.VK_DELETE))) {
                        JOptionPane.showMessageDialog(null, "Please Enter Valid Number.");
                        e.consume();
                    }
                }
                if (t1.getCaretPosition() == 1) {
                    if (!((c == '0') || (c == '1') || (c == '2') || (c == '3') || (c == '4') || (c == '5') || (c == '6')
                            || (c == '7') || (c == '8') || (c == '9') || (c == KeyEvent.VK_BACK_SPACE)
                            || (c == KeyEvent.VK_DELETE))) {
                        JOptionPane.showMessageDialog(null, "Please Enter Valid Number.");
                        e.consume();
                    }
                }
                if (t1.getCaretPosition() == 2) {
                    if (!((c == KeyEvent.VK_SLASH) || (c == KeyEvent.VK_BACK_SPACE) || (c == KeyEvent.VK_DELETE))) {
                        JOptionPane.showMessageDialog(null, "Please Enter Slash(/).");
                        e.consume();
                    }
                }
                if (t1.getCaretPosition() == 3) {
                    if (!((c == '0') || (c == '1') || (c == KeyEvent.VK_BACK_SPACE) || (c == KeyEvent.VK_DELETE))) {
                        JOptionPane.showMessageDialog(null, "Please Enter Valid Number.");
                        e.consume();
                    }
                }
                if (t1.getCaretPosition() == 4) {
                    if (!((c == '0') || (c == '1') || (c == '2') || (c == '3') || (c == '4') || (c == '5') || (c == '6')
                            || (c == '7') || (c == '8') || (c == '9') || (c == KeyEvent.VK_BACK_SPACE)
                            || (c == KeyEvent.VK_DELETE))) {
                        JOptionPane.showMessageDialog(null, "Please Enter Valid Number.");
                        e.consume();
                    }
                }
                if (t1.getCaretPosition() == 5) {
                    if (!((c == KeyEvent.VK_SLASH) || (c == KeyEvent.VK_BACK_SPACE) || (c == KeyEvent.VK_DELETE))) {
                        JOptionPane.showMessageDialog(null, "Please Enter Slash(/).");
                        e.consume();
                    }
                }

                if (t1.getCaretPosition() == 6 || t1.getCaretPosition() == 7 || t1.getCaretPosition() == 8
                        || t1.getCaretPosition() == 9) {
                    if (!((c >= '0') && (c <= '9') || (c == KeyEvent.VK_BACK_SPACE) || (c == KeyEvent.VK_DELETE)
                            || (c == KeyEvent.VK_SLASH) || (c == KeyEvent.VK_ENTER))) {
                        JOptionPane.showMessageDialog(null, "Please Enter Valid Key or Number.");
                        e.consume();
                    }
                }
                if (t1.getText().length() == 10) {
                    e.consume();
                }
            }
        });

        setVisible(true);
        

        t1.setEditable(false);
    }

    public void actionPerformed(ActionEvent e) {
        
        if (e.getSource() == b1) {
            if (ch1.isSelected() == false && ch4.isSelected() == false) {
                JOptionPane.showMessageDialog(this,
                        "Please Check Learner License Fee Report or Driving Licence Fee Report.", "Fee-Report",
                        JOptionPane.ERROR_MESSAGE);
                ch1.requestFocus();
            } else {
                if (ch1.isSelected() == true) {
                    if (ch2.isSelected() == true) {
                        try {
                            Class.forName("oracle.jdbc.driver.OracleDriver");
                            Connection c = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "system",
                                    "manish");
                            Statement s = c.createStatement();
                            sql = "Select applydate,applicantid,name,dob,vehicletype1,vehicletype2,fee from feeparticulardescription order by applydate";
                            c.close();
                        } catch (Exception eee) {
                        }
                        new dialog();
                    } else if (ch3.isSelected() == true && t1.isEnabled() == true) {
                        try {
                            Class.forName("oracle.jdbc.driver.OracleDriver");
                            Connection c = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "system",
                                    "manish");
                            Statement s = c.createStatement();
                            sql = "Select applydate,applicantid,name,dob,vehicletype1,vehicletype2,fee from feeparticulardescription where applydate='"
                                    + t1.getText() + "' ORDER BY applicantid";
                            ResultSet rs = s.executeQuery(sql);
                            if (rs.next()) {
                                new dialog();
                            } else {
                                JOptionPane.showMessageDialog(this, "Invalid Input.", "Fee-Report",
                                        JOptionPane.ERROR_MESSAGE);
                            }

                            c.close();
                        } catch (Exception eee) {
                        }

                    } else {
                        JOptionPane.showMessageDialog(this, "Please Check Full Report or Particular Report.",
                                "Fee-Report", JOptionPane.ERROR_MESSAGE);
                        ch2.requestFocus();
                    }
                }

                else if (ch4.isSelected() == true) {
                    if (ch2.isSelected() == true) {
                        try {
                            Class.forName("oracle.jdbc.driver.OracleDriver");
                            Connection c = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "system",
                                    "manish");
                            
                            Statement s = c.createStatement();
                            sql = "Select applydate,applicantid,name,dob,vehicletype1,vehicletype2,fee from feeappdl order by applydate";
                            c.close();
                        } catch (Exception eee) {
                        }
                        new dialog();
                    } else if (ch3.isSelected() == true && t1.isEnabled() == true) {
                        try {
                            Class.forName("oracle.jdbc.driver.OracleDriver");
                            Connection c = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "system",
                                    "manish");
                            // Connection c=DriverManager.getConnection("jdbc:odbc:dto","","");
                            Statement s = c.createStatement();
                            sql = "Select applydate,applicantid,name,dob,vehicletype1,vehicletype2,fee from feeappdl where applydate='"
                                    + t1.getText() + "' ORDER BY applicantid";
                            ResultSet rs = s.executeQuery(sql);
                            if (rs.next()) {
                                new dialog();
                            } else {
                                JOptionPane.showMessageDialog(this, "Invalid Input.", "Fee-Report",
                                        JOptionPane.ERROR_MESSAGE);
                            }

                            c.close();
                        } catch (Exception eee) {
                        }

                    } else {
                        JOptionPane.showMessageDialog(this, "Please Check Full Report or Particular Report.",
                                "Fee-Report", JOptionPane.ERROR_MESSAGE);
                    }
                }

            }
        }

        else if (e.getSource() == b2) {
            dispose();
        } else if (e.getSource() == ch3) {
            if (ch3.isSelected() == true) {
                t1.setEditable(true);
                t1.requestFocus(true);
            } else {
                t1.setEditable(false);
            }
        } else if (e.getSource() == ch1) {
            if (ch1.isSelected() == true) {
                t1.setText("");
                t1.setEditable(false);
                ch2.requestFocus();
            }
        } else if (e.getSource() == ch2) {
            if (ch2.isSelected() == true) {
                t1.setText("");
                t1.setEditable(false);
                ch2.requestFocus();
            }
        }

    }

    public void keyPressed(KeyEvent e) {
        if (e.getKeyCode() == 10) {
            if (e.getSource() == t1) {
                if (t1.isEditable() == true) {
                    if ((t1.getText()).equals("") || (t1.getText()).equals(null)) {
                        JOptionPane.showMessageDialog(this, "Please Enter Date.", "Fee-Report",
                                JOptionPane.ERROR_MESSAGE);
                        t1.requestFocus();
                    } else {
                        b1.requestFocus();
                    }
                }
            } else if (e.getSource() == ch1) {
                if (ch1.isSelected() == false) {
                    ch1.setSelected(true);
                    ch2.requestFocus();
                    t1.setText("");
                    t1.setEditable(false);
                }
            } else if (e.getSource() == ch2) {
                if (ch2.isSelected() == false) {
                    ch2.setSelected(true);
                    b1.requestFocus();
                    t1.setText("");
                    t1.setEditable(false);
                }
            } else if (e.getSource() == ch3) {
                if (ch3.isSelected() == false) {
                    ch3.setSelected(true);
                    t1.setEditable(true);
                    t1.requestFocus(true);
                }
            } else if (e.getSource() == ch4) {
                if (ch4.isSelected() == false) {
                    ch4.setSelected(true);
                    ch2.requestFocus();
                    t1.setText("");
                    t1.setEditable(false);
                }
            }

        } else if (e.getKeyCode() == 40) {
            if (e.getSource() == ch1) {
                ch2.requestFocus();
            } else if (e.getSource() == ch2) {
                ch3.requestFocus();
            } else if (e.getSource() == ch3) {
                ch1.requestFocus();
            }
        } else if (e.getKeyCode() == 38) {
            if (e.getSource() == ch1) {
                ch3.requestFocus();
            } else if (e.getSource() == ch2) {
                ch1.requestFocus();
            } else if (e.getSource() == ch3) {
                ch2.requestFocus();
            }
        } else if (e.getKeyCode() == 39) {
            if (e.getSource() == ch1) {
                ch4.requestFocus();
            }
        } else if (e.getKeyCode() == 37) {
            if (e.getSource() == ch4) {
                ch1.requestFocus();
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

    private class dialog extends JFrame {
        JPanel p1 = new JPanel();
        int c1 = 1;
        JTable jtable;
        final ResultSetTableModel model = new ResultSetTableModel();
        JLabel ll1, ll2;
        JScrollPane jspane;

        dialog() {
            setTitle("Result-Fee Report");
            setSize(1300, 300);
            setLayout(null);
            p1.setLayout(new GridLayout(10, 8));
            String columns[] = { "Apply Date", "Name", "Birthdate", "Type of Vehicle1", "Type of Vehicle2", "Fee" };
            ll1 = new JLabel("Learner Licence Fee Report");

            // String columns[]={"Apply Date","Name","Birthdate","Type of Vehicle1","Type of
            // Vehicle2","Fee"};

            try {
                Class.forName("oracle.jdbc.driver.OracleDriver");
                Connection c = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "system", "manish");
                Statement s = c.createStatement();
                ResultSet rs = s.executeQuery(sql);
                model.setResultSet(rs);

            } catch (Exception dsd) {
            }

            jtable = new JTable(model);

            jspane = new JScrollPane(jtable);

            jspane.setBounds(0, 0, 1280, 200);

            add(jspane);

            sql = "";

            setVisible(true);
        }
    }

    class Animation extends JLabel {
        private static final long serialVersionUID = 1L;

        public void paintComponent(Graphics g) {
            
            g.fillRect(0, 0, getWidth(), getHeight());
        }
    }

    public static void main(String c[]) {
        new feereport();
    }
}

class ResultSetTableModel extends AbstractTableModel {
    private ResultSet rs;
    private ResultSetMetaData rsMeta;

    private int columnCount;
    private final Vector<String> columnNames = new Vector<String>();
    private final Object column[] = { "Apply Date", "Name", "DOB", "V1", "V2", "Fee" };
    private final Vector<Object[]> cache = new Vector<Object[]>();

    public void setResultSet(ResultSet rs) throws SQLException {
        if (this.rs != null)
            this.rs.close();
        cache.clear();
        rsMeta = rs.getMetaData();
        columnCount = rsMeta.getColumnCount();
        columnNames.clear();

        for (int col = 1; col <= columnCount; col++) {

            columnNames.add(rsMeta.getColumnName(col));

        }

        while (rs.next()) {
            Object rowData[] = new Object[columnCount];
            for (int col = columnCount; col > 0; col--)
                rowData[col - 1] = rs.getObject(col);
            cache.add(rowData);
        }
        fireTableStructureChanged();
    }

    public void close() throws SQLException {
        rs.close();
    }

    public String getColumnName(int column) {
        return columnNames.get(column);
    }

    public Object getValueAt(int rowIndex, int columnIndex) {
        Object[] row = cache.get(rowIndex);
        return row[columnIndex];
    }

    public int getRowCount() {
        return cache.size();
    }

    public int getColumnCount() {
        return columnCount;
    }
}
