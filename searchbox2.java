import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.table.*;
import java.sql.*;

class searchbox2 extends JFrame implements ActionListener, KeyListener {
    String sql = "", sql1 = "";
    JLabel l, l1, l2, l3, l4, l5, l6, l7, l8;
    JTextField t1, t2, t3, t4, t5;
    JButton b1, b2, b3, b4, b5;
    JCheckBox ch1, ch2, ch3, ch4, ch5, ch;
    List lt1, lt2, lt3, lt4, lt5, lt6, lt7;
    JPanel panel = new JPanel();
    JPanel panel1 = new JPanel();
    JPanel panel2 = new JPanel();
    
    int c1, c2, c3, c4, c5;
    String img1 = "", img2 = "", img3 = "", pp = "", ap = "", bp = "";

    searchbox2() {
        setTitle("Search - Driving Licence ");
        setSize(860, 470);
        setIconImage(Toolkit.getDefaultToolkit().getImage("hicon.png"));
        setResizable(false);
        setLocation(300, 70);
        setLayout(null);
        try {
            UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel");
        } catch (Exception e) {
        }
        panel.setLayout(null);
        panel.setBackground(Color.blue);
        panel1.setLayout(null);
        panel1.setBackground(Color.white);
        l = new JLabel("SEARCH-DRIVING LICENCE");
        l.setFont(new Font("Sans-Serif", Font.BOLD, 20));
        l.setForeground(Color.white);
        ch = new JCheckBox("Search Full Information");
        ch.setFont(new Font("Bookman Old Style", Font.PLAIN, 13));

        ch1 = new JCheckBox("Driving Licence No.");
        ch1.setFont(new Font("Bookman Old Style", Font.PLAIN, 15));
        ch2 = new JCheckBox("Name");
        ch2.setFont(new Font("Bookman Old Style", Font.PLAIN, 15));
        ch3 = new JCheckBox("Father's/Husband's Name");
        ch3.setFont(new Font("Bookman Old Style", Font.PLAIN, 15));
        ch4 = new JCheckBox("Date Of Birth");
        ch4.setFont(new Font("Bookman Old Style", Font.PLAIN, 15));
        ch5 = new JCheckBox("Mobile Number");
        ch5.setFont(new Font("Bookman Old Style", Font.PLAIN, 15));

        l1 = new JLabel("Driving Licence No. :");
        l1.setFont(new Font("Bookman Old Style", Font.PLAIN, 15));
        l2 = new JLabel("Name :");
        l2.setFont(new Font("Bookman Old Style", Font.PLAIN, 15));
        l3 = new JLabel("Father's/Husband's Name :");
        l3.setFont(new Font("Bookman Old Style", Font.PLAIN, 15));
        l4 = new JLabel("Date Of Birth(dd/mm/yyyy) :");
        l4.setFont(new Font("Bookman Old Style", Font.PLAIN, 15));
        l5 = new JLabel("Mobile Number :");
        l5.setFont(new Font("Bookman Old Style", Font.PLAIN, 15));
        l6 = new JLabel("Search By :-");
        l6.setFont(new Font("Bookman Old Style", Font.PLAIN, 17));
        t1 = new JTextField();
        t1.setToolTipText("Enter Driving Licence Number");
        t1.setFont(new Font("Bookman Old Style", Font.PLAIN, 15));
        t2 = new JTextField();
        t2.setToolTipText("Enter Name");
        t2.setFont(new Font("Bookman Old Style", Font.PLAIN, 15));
        t3 = new JTextField();
        t3.setToolTipText("Enter Father's/Husband's Name");
        t3.setFont(new Font("Bookman Old Style", Font.PLAIN, 15));
        t4 = new JTextField();
        t4.setToolTipText("Enter Date of Birth (dd/mm/yyyy) ");
        t4.setFont(new Font("Bookman Old Style", Font.PLAIN, 15));
        t5 = new JTextField();
        t5.setToolTipText("Enter Mobile Number");
        t5.setFont(new Font("Bookman Old Style", Font.PLAIN, 15));
        b1 = new JButton("Search");
        b1.setFont(new Font("Bookman Old Style", Font.PLAIN, 14));
        b2 = new JButton("Reset");
        b2.setFont(new Font("Bookman Old Style", Font.PLAIN, 14));
        b3 = new JButton("Cancel");
        b3.setFont(new Font("Bookman Old Style", Font.PLAIN, 14));
        panel.setBounds(0, 0, 1300, 75);
        l.setBounds(300, 25, 300, 30);
        panel1.setBounds(0, 75, 1300, 300);

        l6.setBounds(50, 30, 150, 30);

        ch.setBounds(170, 30, 250, 30);
        ch.setBackground(Color.white);
        ch1.setBounds(50, 80, 200, 30);
        ch2.setBounds(50, 120, 200, 30);
        ch3.setBounds(50, 160, 200, 30);
        ch4.setBounds(50, 200, 200, 30);
        ch5.setBounds(50, 240, 200, 30);

        l1.setBounds(270, 80, 200, 30);
        t1.setBounds(500, 80, 300, 30);
        l2.setBounds(270, 120, 200, 30);
        t2.setBounds(500, 120, 300, 30);
        l3.setBounds(270, 160, 200, 30);
        t3.setBounds(500, 160, 300, 30);
        l4.setBounds(270, 200, 250, 30);
        t4.setBounds(500, 200, 300, 30);
        l5.setBounds(270, 240, 200, 30);
        t5.setBounds(500, 240, 300, 30);
        b1.setBounds(480, 390, 100, 30);
        b2.setBounds(590, 390, 100, 30);
        b3.setBounds(700, 390, 100, 30);

        // panel2.setLayout(BorderLayout());

        panel.add(l);
        panel1.add(ch);
        panel1.add(l6);
        panel1.add(ch1);
        panel1.add(ch2);
        panel1.add(ch3);
        panel1.add(ch4);
        panel1.add(ch5);
        panel1.add(l1);
        panel1.add(t1);
        panel1.add(l2);
        panel1.add(t2);
        panel1.add(l3);
        panel1.add(t3);
        panel1.add(l4);
        panel1.add(t4);
        panel1.add(l5);
        panel1.add(t5);
        add(b1);
        add(b2);
        add(b3);

        add(panel);
        add(panel1);

        t1.addKeyListener(new KeyAdapter() {
            public void keyTyped(KeyEvent e) {
                char keyChar = e.getKeyChar();
                if (Character.isLowerCase(keyChar)) {
                    e.setKeyChar(Character.toUpperCase(keyChar));
                }
            }
        });
        t2.addKeyListener(new KeyAdapter() {
            public void keyTyped(KeyEvent e) {
                char keyChar = e.getKeyChar();
                if (Character.isLowerCase(keyChar)) {
                    e.setKeyChar(Character.toUpperCase(keyChar));
                }
            }
        });
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
                char c = e.getKeyChar();
                if (t4.getCaretPosition() == 0) {
                    if (!((c == '0') || (c == '1') || (c == '2') || (c == '3') || (c == KeyEvent.VK_BACK_SPACE)
                            || (c == KeyEvent.VK_DELETE) || (c == KeyEvent.VK_ENTER))) {
                        JOptionPane.showMessageDialog(null, "Please Enter Valid Number.");
                        e.consume();
                    }
                }
                if (t4.getCaretPosition() == 1) {
                    if (String.valueOf(t4.getText().charAt(0)).equals("3")) {
                        if (!((c == '0') || (c == '1') || (c == KeyEvent.VK_BACK_SPACE) || (c == KeyEvent.VK_DELETE))) {
                            JOptionPane.showMessageDialog(null, "Please Enter Valid Number.");
                            e.consume();
                        }

                    } else {
                        if (!((c == '0') || (c == '1') || (c == '2') || (c == '3') || (c == '4') || (c == '5')
                                || (c == '6') || (c == '7') || (c == '8') || (c == '9') || (c == KeyEvent.VK_BACK_SPACE)
                                || (c == KeyEvent.VK_DELETE))) {
                            JOptionPane.showMessageDialog(null, "Please Enter Valid Number.");
                            e.consume();
                        }
                    }
                }
                if (t4.getCaretPosition() == 2) {
                    if (!((c == KeyEvent.VK_SLASH) || (c == KeyEvent.VK_BACK_SPACE) || (c == KeyEvent.VK_DELETE))) {
                        JOptionPane.showMessageDialog(null, "Please Enter Slash(/).");
                        e.consume();
                    }
                }
                if (t4.getCaretPosition() == 3) {
                    if (!((c == '0') || (c == '1') || (c == KeyEvent.VK_BACK_SPACE) || (c == KeyEvent.VK_DELETE))) {
                        JOptionPane.showMessageDialog(null, "Please Enter Valid Number.");
                        e.consume();
                    }
                }
                if (t4.getCaretPosition() == 4) {
                    if (!((c == '0') || (c == '1') || (c == '2') || (c == '3') || (c == '4') || (c == '5') || (c == '6')
                            || (c == '7') || (c == '8') || (c == '9') || (c == KeyEvent.VK_BACK_SPACE)
                            || (c == KeyEvent.VK_DELETE))) {
                        JOptionPane.showMessageDialog(null, "Please Enter Valid Number.");
                        e.consume();
                    }
                }
                if (t4.getCaretPosition() == 5) {
                    if (!((c == KeyEvent.VK_SLASH) || (c == KeyEvent.VK_BACK_SPACE) || (c == KeyEvent.VK_DELETE))) {
                        JOptionPane.showMessageDialog(null, "Please Enter Slash(/).");
                        e.consume();
                    }
                }

                if (t4.getCaretPosition() == 6 || t4.getCaretPosition() == 7 || t4.getCaretPosition() == 8
                        || t4.getCaretPosition() == 9) {
                    if (!((c >= '0') && (c <= '9') || (c == KeyEvent.VK_BACK_SPACE) || (c == KeyEvent.VK_DELETE)
                            || (c == KeyEvent.VK_ENTER))) {
                        JOptionPane.showMessageDialog(null, "Please Enter Valid Key or Number.");
                        e.consume();
                    }
                }
                if (t4.getText().length() == 10) {
                    e.consume();
                }
            }
        });
        t5.addKeyListener(new KeyAdapter() {
            public void keyTyped(KeyEvent e) {
                char car = e.getKeyChar();
                if ((car < '0') || (car > '9')) {
                    e.consume();
                }
                if (t5.getText().length() == 10) {
                    e.consume();
                }
            }
        });

        t1.addKeyListener(this);
        t1.addActionListener(this);

        t2.addKeyListener(this);
        t2.addActionListener(this);

        t3.addKeyListener(this);
        t3.addActionListener(this);

        t4.addKeyListener(this);
        t4.addActionListener(this);

        t5.addKeyListener(this);
        t5.addActionListener(this);
        ch1.addKeyListener(this);
        ch1.addActionListener(this);
        ch2.addKeyListener(this);
        ch2.addActionListener(this);
        ch3.addKeyListener(this);
        ch3.addActionListener(this);
        ch4.addKeyListener(this);
        ch4.addActionListener(this);
        ch5.addKeyListener(this);
        ch5.addActionListener(this);
        b1.addActionListener(this);
        b1.addKeyListener(this);
        b2.addActionListener(this);
        b3.addKeyListener(this);
        b3.addActionListener(this);
        b3.addKeyListener(this);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setVisible(true);
        

        t1.requestFocus();
        t2.setEditable(false);
        t3.setEditable(false);
        t4.setEditable(false);
        t5.setEditable(false);
        ch1.setSelected(true);
        c2 = 0;
        c1 = 1;
        c3 = 0;
        c4 = 0;
        c5 = 0;

    }

    public void actionPerformed(ActionEvent e) {
        
        if (e.getSource() == ch1) {
            if (c1 == 1) {
                t1.setEditable(false);
                t1.setText("");
                c1 = 0;
            } else if (c1 == 0) {
                t1.setEditable(true);
                c1 = 1;
            }
        } else if (e.getSource() == ch2) {
            if (c2 == 1) {
                t2.setEditable(false);
                t2.setText("");
                c2 = 0;
            } else if (c2 == 0) {
                t2.setEditable(true);
                c2 = 1;
            }
        } else if (e.getSource() == ch3) {
            if (c3 == 1) {
                t3.setEditable(false);
                t3.setText("");
                c3 = 0;
            } else if (c3 == 0) {
                t3.setEditable(true);
                c3 = 1;
            }
        } else if (e.getSource() == ch4) {
            if (c4 == 1) {
                t4.setEditable(false);
                t4.setText("");
                c4 = 0;
            } else if (c4 == 0) {
                t4.setEditable(true);
                c4 = 1;
            }
        } else if (e.getSource() == ch5) {
            if (c5 == 1) {
                t5.setText("");
                t5.setEditable(false);
                c5 = 0;
            } else if (c5 == 0) {
                t5.setEditable(true);
                c5 = 1;
            }
        } else if (e.getSource() == b1) {
            if (ch.isSelected() == false) {
                if (ch1.isSelected() == false && ch2.isSelected() == false && ch3.isSelected() == false
                        && ch4.isSelected() == false && ch5.isSelected() == false) {
                    JOptionPane.showMessageDialog(this, "Please Check Desired Item(s).", "Learner License-Search",
                            JOptionPane.ERROR_MESSAGE);
                    ch1.requestFocus();
                    ch1.setSelected(true);
                    t1.setEditable(true);
                    t1.setText("");
                    t2.setText("");
                    t3.setText("");
                    t4.setText("");
                    t5.setText("");
                    c1 = 1;
                } else if ((ch1.isSelected() == true) && (t1.getText()).equals("")) {
                    JOptionPane.showMessageDialog(this, "Please Enter Driving License Number.",
                            "Driving License-Search", JOptionPane.ERROR_MESSAGE);
                    t1.requestFocus();
                } else if ((ch2.isSelected() == true) && (t2.getText()).equals("")) {
                    JOptionPane.showMessageDialog(this, "Please Enter Name.", "Driving License-Search",
                            JOptionPane.ERROR_MESSAGE);
                    t2.requestFocus();
                } else if ((ch3.isSelected() == true) && (t3.getText()).equals("")) {
                    JOptionPane.showMessageDialog(this, "Please Enter Father's/Husband's Name.",
                            "Driving License-Search", JOptionPane.ERROR_MESSAGE);
                    t3.requestFocus();
                } else if ((ch4.isSelected() == true) && (t4.getText()).equals("")) {
                    JOptionPane.showMessageDialog(this, "Please Enter D.O.B .", "Driving License-Search",
                            JOptionPane.ERROR_MESSAGE);
                    t4.requestFocus();
                } else if ((ch5.isSelected() == true) && (t5.getText()).equals("")) {
                    JOptionPane.showMessageDialog(this, "Please Enter Mobile Number.", "Driving License-Search",
                            JOptionPane.ERROR_MESSAGE);
                    t5.requestFocus();
                } else {
                    if (ch1.isSelected() == true && ch2.isSelected() == true && ch3.isSelected() == true
                            && ch4.isSelected() == true && ch5.isSelected() == true) {
                        sql = "Select applydate,uptovalid,dlnumber,name,fathername,husbandname,dob,bg,permanentadd,mobile,vehicletype1,vehicletype2,status from drivinglicense WHERE dlnumber='"
                                + t1.getText() + "' AND name='" + t2.getText() + "' AND (fathername='" + t3.getText()
                                + "' OR husbandname='" + t3.getText() + "') AND dob='" + t4.getText() + "' AND mobile='"
                                + t5.getText() + "'";
                        
                    }
                    if (ch1.isSelected() == true) {
                        sql = "Select applydate,uptovalid,dlnumber,name,fathername,husbandname,dob,bg,permanentadd,mobile,vehicletype1,vehicletype2,status from drivinglicense WHERE dlnumber='"
                                + t1.getText() + "'";
                        
                    }
                    if (ch2.isSelected() == true) {
                        sql = "Select applydate,uptovalid,dlnumber,name,fathername,husbandname,dob,bg,permanentadd,mobile,vehicletype1,vehicletype2,status from drivinglicense WHERE name='"
                                + t2.getText() + "'";
                        // sql="Select name from drivinglicense where name='"+t2.getText()+"'";
                    }
                    if (ch3.isSelected() == true) {
                        sql = "Select applydate,uptovalid,dlnumber,name,fathername,husbandname,dob,bg,permanentadd,mobile,vehicletype1,vehicletype2,status from drivinglicense WHERE (fathername='"
                                + t3.getText() + "' OR husbandname='" + t3.getText() + "') ";
                        // sql="Select fhname from drivinglicense where fhname='"+t3.getText()+"'";
                    }
                    if (ch4.isSelected() == true) {
                        sql = "Select applydate,uptovalid,dlnumber,name,fathername,husbandname,dob,bg,permanentadd,mobile,vehicletype1,vehicletype2,status from drivinglicense WHERE dob='"
                                + t4.getText() + "'";
                        // sql="Select dob from drivinglicense where dob='"+t4.getText()+"'";
                    }
                    if (ch5.isSelected() == true) {
                        sql = "Select applydate,uptovalid,dlnumber,name,fathername,husbandname,dob,bg,permanentadd,mobile,vehicletype1,vehicletype2,status from drivinglicense WHERE mobile='"
                                + t5.getText() + "'";
                        // sql="Select mobile from drivinglicense where mobile='"+t5.getText()+"'";
                    }
                    if (ch1.isSelected() == true && ch2.isSelected() == true) {
                        sql = "Select applydate,uptovalid,dlnumber,name,fathername,husbandname,dob,bg,permanentadd,mobile,vehicletype1,vehicletype2,status from drivinglicense WHERE dlnumber='"
                                + t1.getText() + "' AND name='" + t2.getText() + "'";
                        // sql="Select dlnumber,name from drivinglicense where
                        // dlnumber='"+t1.getText()+"' AND name='"+t2.getText()+"'";
                    }
                    if (ch1.isSelected() == true && ch3.isSelected() == true) {
                        sql = "Select applydate,uptovalid,dlnumber,name,fathername,husbandname,dob,bg,permanentadd,mobile,vehicletype1,vehicletype2,status from drivinglicense WHERE dlnumber='"
                                + t1.getText() + "' AND (fathername='" + t3.getText() + "' OR husbandname='"
                                + t3.getText() + "') ";
                        // sql="Select dlnumber,fhname from drivinglicense where
                        // dlnumber='"+t1.getText()+"' AND fhname='"+t3.getText()+"'";
                    }
                    if (ch1.isSelected() == true && ch4.isSelected() == true) {
                        sql = "Select applydate,uptovalid,dlnumber,name,fathername,husbandname,dob,bg,permanentadd,mobile,vehicletype1,vehicletype2,status from drivinglicense WHERE dlnumber='"
                                + t1.getText() + "' AND dob='" + t4.getText() + "'";
                        // sql="Select dlnumber,dob from drivinglicense where
                        // dlnumber='"+t1.getText()+"' AND dob='"+t4.getText()+"'";
                    }
                    if (ch1.isSelected() == true && ch5.isSelected() == true) {
                        sql = "Select applydate,uptovalid,dlnumber,name,fathername,husbandname,dob,bg,permanentadd,mobile,vehicletype1,vehicletype2,status from drivinglicense WHERE dlnumber='"
                                + t1.getText() + "' AND mobile='" + t5.getText() + "'";
                        // sql="Select dlnumber,mobile from drivinglicense where
                        // dlnumber='"+t1.getText()+"' AND mobile='"+t5.getText()+"'";
                    }
                    if (ch2.isSelected() == true && ch3.isSelected() == true) {
                        sql = "Select applydate,uptovalid,dlnumber,name,fathername,husbandname,dob,bg,permanentadd,mobile,vehicletype1,vehicletype2,status from drivinglicense WHERE name='"
                                + t2.getText() + "' AND (fathername='" + t3.getText() + "' OR husbandname='"
                                + t3.getText() + "') ";
                        // sql="Select name,fhname from drivinglicense where name='"+t2.getText()+"' AND
                        // fhname='"+t3.getText()+"'";
                    }
                    if (ch2.isSelected() == true && ch4.isSelected() == true) {
                        sql = "Select applydate,uptovalid,dlnumber,name,fathername,husbandname,dob,bg,permanentadd,mobile,vehicletype1,vehicletype2,status from drivinglicense WHERE name='"
                                + t2.getText() + "' AND dob='" + t4.getText() + "'";
                        // sql="Select name,dob from drivinglicense where name='"+t2.getText()+"' AND
                        // dob='"+t4.getText()+"'";
                    }
                    if (ch2.isSelected() == true && ch5.isSelected() == true) {
                        sql = "Select applydate,uptovalid,dlnumber,name,fathername,husbandname,dob,bg,permanentadd,mobile,vehicletype1,vehicletype2,status from drivinglicense WHERE name='"
                                + t2.getText() + "' AND mobile='" + t5.getText() + "'";
                        // sql="Select name,mobile from drivinglicense where name='"+t2.getText()+"' AND
                        // mobile='"+t5.getText()+"'";
                    }
                    if (ch3.isSelected() == true && ch4.isSelected() == true) {
                        sql = "Select applydate,uptovalid,dlnumber,name,fathername,husbandname,dob,bg,permanentadd,mobile,vehicletype1,vehicletype2,status from drivinglicense WHERE (fathername='"
                                + t3.getText() + "' OR husbandname='" + t3.getText() + "') AND dob='" + t4.getText()
                                + "'";
                        // sql="Select fhname,dob from drivinglicense where fhname='"+t3.getText()+"'
                        // AND dob='"+t4.getText()+"'";
                    }
                    if (ch3.isSelected() == true && ch5.isSelected() == true) {
                        sql = "Select applydate,uptovalid,dlnumber,name,fathername,husbandname,dob,bg,permanentadd,mobile,vehicletype1,vehicletype2,status from drivinglicense WHERE (fathername='"
                                + t3.getText() + "' OR husbandname='" + t3.getText() + "') AND mobile='" + t5.getText()
                                + "'";
                        // sql="Select fhname,mobile from drivinglicense where fhname='"+t3.getText()+"'
                        // AND mobile='"+t5.getText()+"'";
                    }
                    if (ch4.isSelected() == true && ch5.isSelected() == true) {
                        sql = "Select applydate,uptovalid,dlnumber,name,fathername,husbandname,dob,bg,permanentadd,mobile,vehicletype1,vehicletype2,status from drivinglicense WHERE dob='"
                                + t4.getText() + "' AND mobile='" + t5.getText() + "'";
                        // sql="Select dob,mobile from drivinglicense where dob='"+t4.getText()+"' AND
                        // mobile='"+t5.getText()+"'";
                    }
                    if (ch1.isSelected() == true && ch2.isSelected() == true && ch3.isSelected() == true) {
                        sql = "Select applydate,uptovalid,dlnumber,name,fathername,husbandname,dob,bg,permanentadd,mobile,vehicletype1,vehicletype2,status from drivinglicense WHERE dlnumber='"
                                + t1.getText() + "' AND name='" + t2.getText() + "' AND (fathername='" + t3.getText()
                                + "' OR husbandname='" + t3.getText() + "') ";
                        // sql="Select dlnumber,name,fhname from drivinglicense where
                        // dlnumber='"+t1.getText()+"' AND name='"+t2.getText()+"' AND
                        // fhname='"+t3.getText()+"'";
                    }
                    if (ch1.isSelected() == true && ch2.isSelected() == true && ch4.isSelected() == true) {
                        sql = "Select applydate,uptovalid,dlnumber,name,fathername,husbandname,dob,bg,permanentadd,mobile,vehicletype1,vehicletype2,status from drivinglicense WHERE dlnumber='"
                                + t1.getText() + "' AND name='" + t2.getText() + "' AND dob='" + t4.getText() + "'";
                        // sql="Select dlnumber,name,dob from drivinglicense where
                        // dlnumber='"+t1.getText()+"' AND name='"+t2.getText()+"' AND
                        // dob='"+t4.getText()+"'";
                    }
                    if (ch1.isSelected() == true && ch2.isSelected() == true && ch5.isSelected() == true) {
                        sql = "Select applydate,uptovalid,dlnumber,name,fathername,husbandname,dob,bg,permanentadd,mobile,vehicletype1,vehicletype2,status from drivinglicense WHERE dlnumber='"
                                + t1.getText() + "' AND name='" + t2.getText() + "' AND mobile='" + t5.getText() + "'";
                        // sql="Select dlnumber,name,mobile from drivinglicense where
                        // dlnumber='"+t1.getText()+"' AND name='"+t2.getText()+"' AND
                        // mobile='"+t5.getText()+"'";
                    }
                    if (ch1.isSelected() == true && ch3.isSelected() == true && ch4.isSelected() == true) {
                        sql = "Select applydate,uptovalid,dlnumber,name,fathername,husbandname,dob,bg,permanentadd,mobile,vehicletype1,vehicletype2,status from drivinglicense WHERE dlnumber='"
                                + t1.getText() + "' AND (fathername='" + t3.getText() + "' OR husbandname='"
                                + t3.getText() + "') AND dob='" + t4.getText() + "'";
                        // sql="Select dlnumber,fhname,dob from drivinglicense where
                        // dlnumber='"+t1.getText()+"' AND fhname='"+t3.getText()+"' AND
                        // dob='"+t4.getText()+"'";
                    }
                    if (ch1.isSelected() == true && ch3.isSelected() == true && ch5.isSelected() == true) {
                        sql = "Select applydate,uptovalid,dlnumber,name,fathername,husbandname,dob,bg,permanentadd,mobile,vehicletype1,vehicletype2,status from drivinglicense WHERE dlnumber='"
                                + t1.getText() + "' AND (fathername='" + t3.getText() + "' OR husbandname='"
                                + t3.getText() + "') AND mobile='" + t5.getText() + "'";
                        // sql="Select dlnumber,fhname,mobile from drivinglicense where
                        // dlnumber='"+t1.getText()+"' AND fhname='"+t3.getText()+"' AND
                        // mobile='"+t5.getText()+"'";
                    }
                    if (ch1.isSelected() == true && ch4.isSelected() == true && ch5.isSelected() == true) {
                        sql = "Select applydate,uptovalid,dlnumber,name,fathername,husbandname,dob,bg,permanentadd,mobile,vehicletype1,vehicletype2,status from drivinglicense WHERE dlnumber='"
                                + t1.getText() + "' AND dob='" + t4.getText() + "' AND mobile='" + t5.getText() + "'";
                        // sql="Select dlnumber,dob,mobile from drivinglicense where
                        // dlnumber='"+t1.getText()+"' AND dob='"+t4.getText()+"' AND
                        // mobile='"+t5.getText()+"'";
                    }
                    if (ch2.isSelected() == true && ch4.isSelected() == true && ch5.isSelected() == true) {
                        sql = "Select applydate,uptovalid,dlnumber,name,fathername,husbandname,dob,bg,permanentadd,mobile,vehicletype1,vehicletype2,status from drivinglicense WHERE name='"
                                + t2.getText() + "' AND dob='" + t4.getText() + "' AND mobile='" + t5.getText() + "'";
                        // sql="Select name,dob,mobile from drivinglicense where name='"+t2.getText()+"'
                        // AND dob='"+t4.getText()+"' AND mobile='"+t5.getText()+"'";
                    }
                    if (ch2.isSelected() == true && ch3.isSelected() == true && ch4.isSelected() == true) {
                        sql = "Select applydate,uptovalid,dlnumber,name,fathername,husbandname,dob,bg,permanentadd,mobile,vehicletype1,vehicletype2,status from drivinglicense WHERE name='"
                                + t2.getText() + "' AND (fathername='" + t3.getText() + "' OR husbandname='"
                                + t3.getText() + "') AND dob='" + t4.getText() + "'";
                        // sql="Select name,fhname,dob from drivinglicense where name='"+t2.getText()+"'
                        // AND fhname='"+t3.getText()+"' AND dob='"+t4.getText()+"'";
                    }
                    if (ch2.isSelected() == true && ch3.isSelected() == true && ch5.isSelected() == true) {
                        sql = "Select applydate,uptovalid,dlnumber,name,fathername,husbandname,dob,bg,permanentadd,mobile,vehicletype1,vehicletype2,status from drivinglicense WHERE name='"
                                + t2.getText() + "' AND (fathername='" + t3.getText() + "' OR husbandname='"
                                + t3.getText() + "') AND mobile='" + t5.getText() + "'";
                        // sql="Select name,fhname,mobile from drivinglicense where
                        // name='"+t2.getText()+"' AND fhname='"+t3.getText()+"' AND
                        // mobile='"+t5.getText()+"'";
                    }
                    if (ch3.isSelected() == true && ch4.isSelected() == true && ch5.isSelected() == true) {
                        sql = "Select applydate,uptovalid,dlnumber,name,fathername,husbandname,dob,bg,permanentadd,mobile,vehicletype1,vehicletype2,status from drivinglicense WHERE (fathername='"
                                + t3.getText() + "' OR husbandname='" + t3.getText() + "') AND dob='" + t4.getText()
                                + "' AND mobile='" + t5.getText() + "'";
                        // sql="Select fhname,dob,mobile from drivinglicense where
                        // fhname='"+t3.getText()+"' AND dob='"+t4.getText()+"' AND
                        // mobile='"+t5.getText()+"'";
                    }
                    if (ch1.isSelected() == true && ch2.isSelected() == true && ch3.isSelected() == true
                            && ch4.isSelected() == true) {
                        sql = "Select applydate,uptovalid,dlnumber,name,fathername,husbandname,dob,bg,permanentadd,mobile,vehicletype1,vehicletype2,status from drivinglicense WHERE dlnumber='"
                                + t1.getText() + "' AND name='" + t2.getText() + "' AND (fathername='" + t3.getText()
                                + "' OR husbandname='" + t3.getText() + "') AND dob='" + t4.getText() + "'";
                        // sql="Select dlnumber,name,fhname,dob from drivinglicense where
                        // dlnumber='"+t1.getText()+"' AND name='"+t2.getText()+"' AND
                        // fhname='"+t3.getText()+"' AND dob='"+t4.getText()+"'";
                    }
                    if (ch1.isSelected() == true && ch2.isSelected() == true && ch3.isSelected() == true
                            && ch5.isSelected() == true) {
                        sql = "Select applydate,uptovalid,dlnumber,name,fathername,husbandname,dob,bg,permanentadd,mobile,vehicletype1,vehicletype2,status from drivinglicense WHERE dlnumber='"
                                + t1.getText() + "' AND name='" + t2.getText() + "' AND (fathername='" + t3.getText()
                                + "' OR husbandname='" + t3.getText() + "') AND mobile='" + t5.getText() + "'";
                        // sql="Select dlnumber,name,fhname,mobile from drivinglicense where
                        // dlnumber='"+t1.getText()+"' AND name='"+t2.getText()+"' AND
                        // fhname='"+t3.getText()+"' AND mobile='"+t5.getText()+"'";
                    }
                    if (ch1.isSelected() == true && ch3.isSelected() == true && ch4.isSelected() == true
                            && ch5.isSelected() == true) {
                        sql = "Select applydate,uptovalid,dlnumber,name,fathername,husbandname,dob,bg,permanentadd,mobile,vehicletype1,vehicletype2,status from drivinglicense WHERE dlnumber='"
                                + t1.getText() + "' AND (fathername='" + t3.getText() + "' OR husbandname='"
                                + t3.getText() + "') AND dob='" + t4.getText() + "' AND mobile='" + t5.getText() + "'";
                        // sql="Select dlnumber,fhname,dob,mobile from drivinglicense where
                        // dlnumber='"+t1.getText()+"' AND fhname='"+t3.getText()+"' AND
                        // dob='"+t4.getText()+"' AND mobile='"+t5.getText()+"'";
                    }
                    if (ch1.isSelected() == true && ch2.isSelected() == true && ch4.isSelected() == true
                            && ch5.isSelected() == true) {
                        sql = "Select applydate,uptovalid,dlnumber,name,fathername,husbandname,dob,bg,permanentadd,mobile,vehicletype1,vehicletype2,status from drivinglicense WHERE dlnumber='"
                                + t1.getText() + "' AND name='" + t2.getText() + "' AND dob='" + t4.getText()
                                + "' AND mobile='" + t5.getText() + "'";
                        // sql="Select dlnumber,name,dob,mobile from drivinglicense where
                        // dlnumber='"+t1.getText()+"' AND name='"+t2.getText()+"' AND
                        // dob='"+t4.getText()+"' AND mobile='"+t5.getText()+"'";
                    }
                    if (ch2.isSelected() == true && ch3.isSelected() == true && ch4.isSelected() == true
                            && ch5.isSelected() == true) {
                        sql = "Select applydate,uptovalid,dlnumber,name,fathername,husbandname,dob,bg,permanentadd,mobile,vehicletype1,vehicletype2,status from drivinglicense WHERE name='"
                                + t2.getText() + "' AND (fathername='" + t3.getText() + "' OR husbandname='"
                                + t3.getText() + "') AND dob='" + t4.getText() + "' AND mobile='" + t5.getText() + "'";
                        // sql="Select name,fhname,dob,mobile from drivinglicense where
                        // name='"+t2.getText()+"' AND fhname='"+t3.getText()+"' AND
                        // dob='"+t4.getText()+"' AND mobile='"+t5.getText()+"'";
                    }
                    try {
                        Class.forName("oracle.jdbc.driver.OracleDriver");
                        Connection c = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "system",
                                "manish");
                        // Connection c=DriverManager.getConnection("jdbc:odbc:dto","","");
                        Statement s = c.createStatement();
                        ResultSet rs = s.executeQuery(sql);
                        if (rs.next()) {
                            new dialog();
                        } else {
                            JOptionPane.showMessageDialog(this, "Invalid Data.", "Driving Licence-Search",
                                    JOptionPane.ERROR_MESSAGE);
                            if (ch1.isSelected() == true) {
                                t1.requestFocus();
                            } else if (ch2.isSelected() == true) {
                                t2.requestFocus();
                            } else if (ch3.isSelected() == true) {
                                t3.requestFocus();
                            } else if (ch4.isSelected() == true) {
                                t4.requestFocus();
                            } else if (ch5.isSelected() == true) {
                                t5.requestFocus();
                            }
                        }
                        c.close();
                    } catch (Exception ex) {
                        JOptionPane.showMessageDialog(this, ex.getMessage(), "", JOptionPane.INFORMATION_MESSAGE);
                    }
                }

            } else if (ch.isSelected() == true) {
                if (ch1.isSelected() == false && ch2.isSelected() == false && ch3.isSelected() == false
                        && ch4.isSelected() == false && ch5.isSelected() == false) {
                    JOptionPane.showMessageDialog(this, "Please Check Desired Item(s).", "Learner License-Search",
                            JOptionPane.ERROR_MESSAGE);
                    ch1.requestFocus();
                    ch1.setSelected(true);
                    t1.setEditable(true);
                    t1.setText("");
                    t2.setText("");
                    t3.setText("");
                    t4.setText("");
                    t5.setText("");
                    c1 = 1;
                } else if ((ch1.isSelected() == true) && (t1.getText()).equals("")) {
                    JOptionPane.showMessageDialog(this, "Please Enter Driving License Number.",
                            "Driving License-Search", JOptionPane.ERROR_MESSAGE);
                    t1.requestFocus();
                } else if ((ch2.isSelected() == true) && (t2.getText()).equals("")) {
                    JOptionPane.showMessageDialog(this, "Please Enter Name.", "Driving License-Search",
                            JOptionPane.ERROR_MESSAGE);
                    t2.requestFocus();
                } else if ((ch3.isSelected() == true) && (t3.getText()).equals("")) {
                    JOptionPane.showMessageDialog(this, "Please Enter Father's/Husband's Name.",
                            "Driving License-Search", JOptionPane.ERROR_MESSAGE);
                    t3.requestFocus();
                } else if ((ch4.isSelected() == true) && (t4.getText()).equals("")) {
                    JOptionPane.showMessageDialog(this, "Please Enter D.O.B .", "Driving License-Search",
                            JOptionPane.ERROR_MESSAGE);
                    t4.requestFocus();
                } else if ((ch5.isSelected() == true) && (t5.getText()).equals("")) {
                    JOptionPane.showMessageDialog(this, "Please Enter Mobile Number.", "Driving License-Search",
                            JOptionPane.ERROR_MESSAGE);
                    t5.requestFocus();
                } else {
                    if (ch1.isSelected() == true && ch2.isSelected() == true && ch3.isSelected() == true
                            && ch4.isSelected() == true && ch5.isSelected() == true) {
                        sql1 = "Select * from drivinglicense WHERE dlnumber='" + t1.getText() + "' AND name='"
                                + t2.getText() + "' AND (fathername='" + t3.getText() + "' OR husbandname='"
                                + t3.getText() + "') AND dob='" + t4.getText() + "' AND mobile='" + t5.getText() + "'";
                        
                    }
                    if (ch1.isSelected() == true) {
                        sql1 = "Select * from drivinglicense WHERE dlnumber='" + t1.getText() + "'";
                        // sql1="Select dlnumber from drivinglicense WHERE dlnumber='"+t1.getText()+"'";
                    }
                    if (ch2.isSelected() == true) {
                        sql1 = "Select * from drivinglicense WHERE name='" + t2.getText() + "'";
                        // sql1="Select name from drivinglicense where name='"+t2.getText()+"'";
                    }
                    if (ch3.isSelected() == true) {
                        sql1 = "Select * from drivinglicense WHERE (fathername='" + t3.getText() + "' OR husbandname='"
                                + t3.getText() + "') ";
                        // sql1="Select fhname from drivinglicense where fhname='"+t3.getText()+"'";
                    }
                    if (ch4.isSelected() == true) {
                        sql1 = "Select * from drivinglicense WHERE dob='" + t4.getText() + "'";
                        // sql1="Select dob from drivinglicense where dob='"+t4.getText()+"'";
                    }
                    if (ch5.isSelected() == true) {
                        sql1 = "Select * from drivinglicense WHERE mobile='" + t5.getText() + "'";
                        // sql1="Select mobile from drivinglicense where mobile='"+t5.getText()+"'";
                    }
                    if (ch1.isSelected() == true && ch2.isSelected() == true) {
                        sql1 = "Select * from drivinglicense WHERE dlnumber='" + t1.getText() + "' AND name='"
                                + t2.getText() + "'";
                        // sql1="Select dlnumber,name from drivinglicense where
                        // dlnumber='"+t1.getText()+"' AND name='"+t2.getText()+"'";
                    }
                    if (ch1.isSelected() == true && ch3.isSelected() == true) {
                        sql1 = "Select * from drivinglicense WHERE dlnumber='" + t1.getText() + "' AND (fathername='"
                                + t3.getText() + "' OR husbandname='" + t3.getText() + "') ";
                        // sql1="Select dlnumber,fhname from drivinglicense where
                        // dlnumber='"+t1.getText()+"' AND fhname='"+t3.getText()+"'";
                    }
                    if (ch1.isSelected() == true && ch4.isSelected() == true) {
                        sql1 = "Select * from drivinglicense WHERE dlnumber='" + t1.getText() + "' AND dob='"
                                + t4.getText() + "'";
                        // sql1="Select dlnumber,dob from drivinglicense where
                        // dlnumber='"+t1.getText()+"' AND dob='"+t4.getText()+"'";
                    }
                    if (ch1.isSelected() == true && ch5.isSelected() == true) {
                        sql1 = "Select * from drivinglicense WHERE dlnumber='" + t1.getText() + "' AND mobile='"
                                + t5.getText() + "'";
                        // sql1="Select dlnumber,mobile from drivinglicense where
                        // dlnumber='"+t1.getText()+"' AND mobile='"+t5.getText()+"'";
                    }
                    if (ch2.isSelected() == true && ch3.isSelected() == true) {
                        sql1 = "Select * from drivinglicense WHERE name='" + t2.getText() + "' AND (fathername='"
                                + t3.getText() + "' OR husbandname='" + t3.getText() + "') ";
                        // sql1="Select name,fhname from drivinglicense where name='"+t2.getText()+"'
                        // AND fhname='"+t3.getText()+"'";
                    }
                    if (ch2.isSelected() == true && ch4.isSelected() == true) {
                        sql1 = "Select * from drivinglicense WHERE name='" + t2.getText() + "' AND dob='" + t4.getText()
                                + "'";
                        // sql1="Select name,dob from drivinglicense where name='"+t2.getText()+"' AND
                        // dob='"+t4.getText()+"'";
                    }
                    if (ch2.isSelected() == true && ch5.isSelected() == true) {
                        sql1 = "Select * from drivinglicense WHERE name='" + t2.getText() + "' AND mobile='"
                                + t5.getText() + "'";
                        // sql1="Select name,mobile from drivinglicense where name='"+t2.getText()+"'
                        // AND mobile='"+t5.getText()+"'";
                    }
                    if (ch3.isSelected() == true && ch4.isSelected() == true) {
                        sql1 = "Select * from drivinglicense WHERE (fathername='" + t3.getText() + "' OR husbandname='"
                                + t3.getText() + "') AND dob='" + t4.getText() + "'";
                        // sql1="Select fhname,dob from drivinglicense where fhname='"+t3.getText()+"'
                        // AND dob='"+t4.getText()+"'";
                    }
                    if (ch3.isSelected() == true && ch5.isSelected() == true) {
                        sql1 = "Select * from drivinglicense WHERE (fathername='" + t3.getText() + "' OR husbandname='"
                                + t3.getText() + "') AND mobile='" + t5.getText() + "'";
                        // sql1="Select fhname,mobile from drivinglicense where
                        // fhname='"+t3.getText()+"' AND mobile='"+t5.getText()+"'";
                    }
                    if (ch4.isSelected() == true && ch5.isSelected() == true) {
                        sql1 = "Select * from drivinglicense WHERE dob='" + t4.getText() + "' AND mobile='"
                                + t5.getText() + "'";
                        // sql1="Select dob,mobile from drivinglicense where dob='"+t4.getText()+"' AND
                        // mobile='"+t5.getText()+"'";
                    }
                    if (ch1.isSelected() == true && ch2.isSelected() == true && ch3.isSelected() == true) {
                        sql1 = "Select * from drivinglicense WHERE dlnumber='" + t1.getText() + "' AND name='"
                                + t2.getText() + "' AND (fathername='" + t3.getText() + "' OR husbandname='"
                                + t3.getText() + "') ";
                        // sql1="Select dlnumber,name,fhname from drivinglicense where
                        // dlnumber='"+t1.getText()+"' AND name='"+t2.getText()+"' AND
                        // fhname='"+t3.getText()+"'";
                    }
                    if (ch1.isSelected() == true && ch2.isSelected() == true && ch4.isSelected() == true) {
                        sql1 = "Select * from drivinglicense WHERE dlnumber='" + t1.getText() + "' AND name='"
                                + t2.getText() + "' AND dob='" + t4.getText() + "'";
                        // sql1="Select dlnumber,name,dob from drivinglicense where
                        // dlnumber='"+t1.getText()+"' AND name='"+t2.getText()+"' AND
                        // dob='"+t4.getText()+"'";
                    }
                    if (ch1.isSelected() == true && ch2.isSelected() == true && ch5.isSelected() == true) {
                        sql1 = "Select * from drivinglicense WHERE dlnumber='" + t1.getText() + "' AND name='"
                                + t2.getText() + "' AND mobile='" + t5.getText() + "'";
                        // sql1="Select dlnumber,name,mobile from drivinglicense where
                        // dlnumber='"+t1.getText()+"' AND name='"+t2.getText()+"' AND
                        // mobile='"+t5.getText()+"'";
                    }
                    if (ch1.isSelected() == true && ch3.isSelected() == true && ch4.isSelected() == true) {
                        sql1 = "Select * from drivinglicense WHERE dlnumber='" + t1.getText() + "' AND (fathername='"
                                + t3.getText() + "' OR husbandname='" + t3.getText() + "') AND dob='" + t4.getText()
                                + "'";
                        // sql1="Select dlnumber,fhname,dob from drivinglicense where
                        // dlnumber='"+t1.getText()+"' AND fhname='"+t3.getText()+"' AND
                        // dob='"+t4.getText()+"'";
                    }
                    if (ch1.isSelected() == true && ch3.isSelected() == true && ch5.isSelected() == true) {
                        sql1 = "Select * from drivinglicense WHERE dlnumber='" + t1.getText() + "' AND (fathername='"
                                + t3.getText() + "' OR husbandname='" + t3.getText() + "') AND mobile='" + t5.getText()
                                + "'";
                        // sql1="Select dlnumber,fhname,mobile from drivinglicense where
                        // dlnumber='"+t1.getText()+"' AND fhname='"+t3.getText()+"' AND
                        // mobile='"+t5.getText()+"'";
                    }
                    if (ch1.isSelected() == true && ch4.isSelected() == true && ch5.isSelected() == true) {
                        sql1 = "Select * from drivinglicense WHERE dlnumber='" + t1.getText() + "' AND dob='"
                                + t4.getText() + "' AND mobile='" + t5.getText() + "'";
                        // sql1="Select dlnumber,dob,mobile from drivinglicense where
                        // dlnumber='"+t1.getText()+"' AND dob='"+t4.getText()+"' AND
                        // mobile='"+t5.getText()+"'";
                    }
                    if (ch2.isSelected() == true && ch4.isSelected() == true && ch5.isSelected() == true) {
                        sql1 = "Select * from drivinglicense WHERE name='" + t2.getText() + "' AND dob='" + t4.getText()
                                + "' AND mobile='" + t5.getText() + "'";
                        // sql1="Select name,dob,mobile from drivinglicense where
                        // name='"+t2.getText()+"' AND dob='"+t4.getText()+"' AND
                        // mobile='"+t5.getText()+"'";
                    }
                    if (ch2.isSelected() == true && ch3.isSelected() == true && ch4.isSelected() == true) {
                        sql1 = "Select * from drivinglicense WHERE name='" + t2.getText() + "' AND (fathername='"
                                + t3.getText() + "' OR husbandname='" + t3.getText() + "') AND dob='" + t4.getText()
                                + "'";
                        // sql1="Select name,fhname,dob from drivinglicense where
                        // name='"+t2.getText()+"' AND fhname='"+t3.getText()+"' AND
                        // dob='"+t4.getText()+"'";
                    }
                    if (ch2.isSelected() == true && ch3.isSelected() == true && ch5.isSelected() == true) {
                        sql1 = "Select * from drivinglicense WHERE name='" + t2.getText() + "' AND (fathername='"
                                + t3.getText() + "' OR husbandname='" + t3.getText() + "') AND mobile='" + t5.getText()
                                + "'";
                        // sql1="Select name,fhname,mobile from drivinglicense where
                        // name='"+t2.getText()+"' AND fhname='"+t3.getText()+"' AND
                        // mobile='"+t5.getText()+"'";
                    }
                    if (ch3.isSelected() == true && ch4.isSelected() == true && ch5.isSelected() == true) {
                        sql1 = "Select * from drivinglicense WHERE (fathername='" + t3.getText() + "' OR husbandname='"
                                + t3.getText() + "') AND dob='" + t4.getText() + "' AND mobile='" + t5.getText() + "'";
                        // sql1="Select fhname,dob,mobile from drivinglicense where
                        // fhname='"+t3.getText()+"' AND dob='"+t4.getText()+"' AND
                        // mobile='"+t5.getText()+"'";
                    }
                    if (ch1.isSelected() == true && ch2.isSelected() == true && ch3.isSelected() == true
                            && ch4.isSelected() == true) {
                        sql1 = "Select * from drivinglicense WHERE dlnumber='" + t1.getText() + "' AND name='"
                                + t2.getText() + "' AND (fathername='" + t3.getText() + "' OR husbandname='"
                                + t3.getText() + "') AND dob='" + t4.getText() + "'";
                        // sql1="Select dlnumber,name,fhname,dob from drivinglicense where
                        // dlnumber='"+t1.getText()+"' AND name='"+t2.getText()+"' AND
                        // fhname='"+t3.getText()+"' AND dob='"+t4.getText()+"'";
                    }
                    if (ch1.isSelected() == true && ch2.isSelected() == true && ch3.isSelected() == true
                            && ch5.isSelected() == true) {
                        sql1 = "Select * from drivinglicense WHERE dlnumber='" + t1.getText() + "' AND name='"
                                + t2.getText() + "' AND (fathername='" + t3.getText() + "' OR husbandname='"
                                + t3.getText() + "') AND mobile='" + t5.getText() + "'";
                        // sql1="Select dlnumber,name,fhname,mobile from drivinglicense where
                        // dlnumber='"+t1.getText()+"' AND name='"+t2.getText()+"' AND
                        // fhname='"+t3.getText()+"' AND mobile='"+t5.getText()+"'";
                    }
                    if (ch1.isSelected() == true && ch3.isSelected() == true && ch4.isSelected() == true
                            && ch5.isSelected() == true) {
                        sql1 = "Select * from drivinglicense WHERE dlnumber='" + t1.getText() + "' AND (fathername='"
                                + t3.getText() + "' OR husbandname='" + t3.getText() + "') AND dob='" + t4.getText()
                                + "' AND mobile='" + t5.getText() + "'";
                        // sql1="Select dlnumber,fhname,dob,mobile from drivinglicense where
                        // dlnumber='"+t1.getText()+"' AND fhname='"+t3.getText()+"' AND
                        // dob='"+t4.getText()+"' AND mobile='"+t5.getText()+"'";
                    }
                    if (ch1.isSelected() == true && ch2.isSelected() == true && ch4.isSelected() == true
                            && ch5.isSelected() == true) {
                        sql1 = "Select * from drivinglicense WHERE dlnumber='" + t1.getText() + "' AND name='"
                                + t2.getText() + "' AND dob='" + t4.getText() + "' AND mobile='" + t5.getText() + "'";
                        // sql1="Select dlnumber,name,dob,mobile from drivinglicense where
                        // dlnumber='"+t1.getText()+"' AND name='"+t2.getText()+"' AND
                        // dob='"+t4.getText()+"' AND mobile='"+t5.getText()+"'";
                    }
                    if (ch2.isSelected() == true && ch3.isSelected() == true && ch4.isSelected() == true
                            && ch5.isSelected() == true) {
                        sql1 = "Select * from drivinglicense WHERE name='" + t2.getText() + "' AND (fathername='"
                                + t3.getText() + "' OR husbandname='" + t3.getText() + "') AND dob='" + t4.getText()
                                + "' AND mobile='" + t5.getText() + "'";
                        // sql1="Select name,fhname,dob,mobile from drivinglicense where
                        // name='"+t2.getText()+"' AND fhname='"+t3.getText()+"' AND
                        // dob='"+t4.getText()+"' AND mobile='"+t5.getText()+"'";
                    }
                    try {
                        Class.forName("oracle.jdbc.driver.OracleDriver");
                        Connection c = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "system",
                                "manish");
                        // Connection c=DriverManager.getConnection("jdbc:odbc:dto","","");
                        Statement s = c.createStatement();
                        ResultSet rs = s.executeQuery(sql1);
                        if (rs.next()) {
                            img1 = rs.getString("photoaddress");
                            img2 = rs.getString("signatureaddress");
                            img3 = rs.getString("thumbaddress");
                            pp = rs.getString("photoproof");
                            ap = rs.getString("addressproof");
                            bp = rs.getString("bgproof");
                            new dialog1();
                        } else {
                            JOptionPane.showMessageDialog(this, "Invalid Data.", "Driving Licence-Search",
                                    JOptionPane.ERROR_MESSAGE);
                            if (ch1.isSelected() == true) {
                                t1.requestFocus();
                            } else if (ch2.isSelected() == true) {
                                t2.requestFocus();
                            } else if (ch3.isSelected() == true) {
                                t3.requestFocus();
                            } else if (ch4.isSelected() == true) {
                                t4.requestFocus();
                            } else if (ch5.isSelected() == true) {
                                t5.requestFocus();
                            }
                        }
                        c.close();
                    } catch (Exception ex) {
                        JOptionPane.showMessageDialog(this, ex.getMessage(), "", JOptionPane.INFORMATION_MESSAGE);
                    }
                }

            }

        }

        else if (e.getSource() == b3) {
            dispose();

        } else if (e.getSource() == b2) {
            t1.setText("");
            t1.setEditable(true);
            t2.setEditable(false);
            t3.setEditable(false);
            t4.setEditable(false);
            t5.setEditable(false);
            ch2.setSelected(false);
            ch3.setSelected(false);
            ch4.setSelected(false);
            ch5.setSelected(false);
            c2 = 0;
            c3 = 0;
            c4 = 0;
            c5 = 0;
            t2.setText("");
            t3.setText("");
            t4.setText("");
            t5.setText("");
            ch1.setSelected(true);
            t1.requestFocus();
        }
    }

    public void keyPressed(KeyEvent e) {
        if (e.getKeyCode() == 10) {
            if (e.getSource() == b3) {
                dispose();
            } else if (e.getSource() == b2) {
                t1.setText("");
                t1.setEditable(true);
                t2.setEditable(false);
                t3.setEditable(false);
                t4.setEditable(false);
                t5.setEditable(false);
                ch2.setSelected(false);
                ch3.setSelected(false);
                ch4.setSelected(false);
                ch5.setSelected(false);
                c2 = 0;
                c3 = 0;
                c4 = 0;
                c5 = 0;
                t2.setText("");
                t3.setText("");
                t4.setText("");
                t5.setText("");
                ch1.requestFocus();
            } else if (e.getSource() == ch1) {
                if (ch1.isSelected() == true) {
                    ch1.setSelected(false);
                    t1.setEditable(false);
                    t1.setText("");
                    c1 = 0;
                } else {
                    ch1.setSelected(true);
                    t1.setEditable(true);
                    c1 = 1;
                }
            } else if (e.getSource() == ch2) {
                if (ch2.isSelected() == true) {
                    ch2.setSelected(false);
                    t2.setEditable(false);
                    t2.setText("");
                    c2 = 0;
                } else {
                    ch2.setSelected(true);
                    t2.setEditable(true);
                    c2 = 1;
                }
            } else if (e.getSource() == ch3) {
                if (ch3.isSelected() == true) {
                    ch3.setSelected(false);
                    t3.setEditable(false);
                    t3.setText("");
                    c3 = 0;
                } else {
                    ch3.setSelected(true);
                    t3.setEditable(true);
                    c3 = 1;
                }
            } else if (e.getSource() == ch4) {
                if (ch4.isSelected() == true) {
                    ch4.setSelected(false);
                    t4.setEditable(false);
                    t4.setText("");
                    c4 = 0;
                } else {
                    ch4.setSelected(true);
                    t4.setEditable(true);
                    c4 = 1;
                }
            } else if (e.getSource() == ch5) {
                if (ch5.isSelected() == true) {
                    ch5.setSelected(false);
                    t5.setEditable(false);
                    t5.setText("");
                    c5 = 0;
                } else {
                    ch5.setSelected(true);
                    t5.setEditable(true);
                    c5 = 1;
                }
            } else if (e.getSource() == b1) {

            } else if (e.getSource() == t1) {
                if (t1.isEditable() != false) {
                    if ((t1.getText()).equals("") || (t1.getText()).equals(null)) {
                        JOptionPane.showMessageDialog(this, "Please Enter Driving License Number.",
                                "Search-Driving License", JOptionPane.ERROR_MESSAGE);
                        t1.requestFocus();
                    } else {
                        if (ch2.isSelected() == true) {
                            t2.requestFocus();
                        } else if (ch3.isSelected() == true) {
                            t3.requestFocus();
                        } else if (ch4.isSelected() == true) {
                            t4.requestFocus();
                        } else if (ch5.isSelected() == true) {
                            t5.requestFocus();
                        } else {
                            b1.requestFocus();
                        }
                    }
                }
            } else if (e.getSource() == t2) {
                if (t2.isEditable() != false) {
                    if ((t2.getText()).equals("") || (t2.getText()).equals(null)) {
                        JOptionPane.showMessageDialog(this, "Please Enter Name.", "Search-Driving License",
                                JOptionPane.ERROR_MESSAGE);
                        t2.requestFocus();
                    } else {
                        if (ch3.isSelected() == true) {
                            t3.requestFocus();
                        } else if (ch4.isSelected() == true) {
                            t4.requestFocus();
                        } else if (ch5.isSelected() == true) {
                            t5.requestFocus();
                        } else {
                            b1.requestFocus();
                        }
                    }
                }
            } else if (e.getSource() == t3) {
                if (t3.isEditable() != false) {
                    if ((t3.getText()).equals("") || (t3.getText()).equals(null)) {
                        JOptionPane.showMessageDialog(this, "Please Enter Father's/Husband's Name.",
                                "Search-Driving License", JOptionPane.ERROR_MESSAGE);
                        t3.requestFocus();
                    } else {
                        if (ch4.isSelected() == true) {
                            t4.requestFocus();
                        } else if (ch5.isSelected() == true) {
                            t5.requestFocus();
                        } else {
                            b1.requestFocus();
                        }
                    }
                }
            } else if (e.getSource() == t4) {
                if (t4.isEditable() != false) {
                    if ((t4.getText()).equals("") || (t4.getText()).equals(null)) {
                        JOptionPane.showMessageDialog(this, "Please Enter D.O.B .", "Search-Driving License",
                                JOptionPane.ERROR_MESSAGE);
                        t4.requestFocus();
                    } else {
                        if (ch5.isSelected() == true) {
                            t5.requestFocus();
                        } else {
                            b1.requestFocus();
                        }
                    }
                }
            }

            else if (e.getSource() == t5) {
                if (t5.isEditable() != false) {
                    if ((t5.getText()).equals("") || (t5.getText()).equals(null)) {
                        JOptionPane.showMessageDialog(this, "Please Enter Mobile Number.", "Search-Driving License",
                                JOptionPane.ERROR_MESSAGE);
                        t5.requestFocus();
                    } else {
                        b1.requestFocus();
                    }
                }
            }
        } else if (e.getKeyCode() == 38) {
            if (e.getSource() == ch1) {
                ch5.requestFocus();
            } else if (e.getSource() == ch2) {
                ch1.requestFocus();
            } else if (e.getSource() == ch3) {
                ch2.requestFocus();
            } else if (e.getSource() == ch4) {
                ch3.requestFocus();
            } else if (e.getSource() == ch5) {
                ch4.requestFocus();
            }

        } else if (e.getKeyCode() == 40) {
            if (e.getSource() == ch1) {
                ch2.requestFocus();
            } else if (e.getSource() == ch2) {
                ch3.requestFocus();
            } else if (e.getSource() == ch3) {
                ch4.requestFocus();
            } else if (e.getSource() == ch4) {
                ch5.requestFocus();
            } else if (e.getSource() == ch5) {
                ch1.requestFocus();
            }
        }
        // System.out.println(e.getKeyCode());
        else if (e.getKeyCode() == 39) {
            if (e.getSource() == ch1) {
                t1.requestFocus();
            } else if (e.getSource() == ch2) {
                t2.requestFocus();
            } else if (e.getSource() == ch3) {
                t3.requestFocus();
            } else if (e.getSource() == ch4) {
                t4.requestFocus();
            } else if (e.getSource() == ch5) {
                t5.requestFocus();
            }
        } else if (e.getKeyCode() == 37) {
            if (e.getSource() == t1) {
                ch1.requestFocus();
            } else if (e.getSource() == t2) {
                ch2.requestFocus();
            } else if (e.getSource() == t3) {
                ch3.requestFocus();
            } else if (e.getSource() == t4) {
                ch4.requestFocus();
            } else if (e.getSource() == t5) {
                ch5.requestFocus();
            }
        } else if (e.getKeyCode() == 27) {
            dispose();
        }

    }

    public void keyTyped(KeyEvent e) {
    }

    public void keyReleased(KeyEvent e) {
    }

    // --------------------------------------------------------------------------------------------------------------------------------------------------------------------
    private class dialog {
        JDialog dialog = new JDialog((Frame) null, "Search-Driving Licence", true);

        JTable jtable;
        JScrollPane jspane;

        dialog() {
            dialog.setSize(1300, 300);
            try {
                Class.forName("oracle.jdbc.driver.OracleDriver");
                Connection c = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "system", "manish");
                // Connection c=DriverManager.getConnection("jdbc:odbc:dto","","");
                Statement s = c.createStatement();
                // String sql1="Select
                // applydate,uptovalid,learnerlicenseno,name,fathername,husbandname,dob,bg,permanentadd,mobile,vehicletype1,vehicletype2,status
                // from learnerlicense";
                ResultSet rs = s.executeQuery(sql);
                System.out.print(sql);
                if (rs.next()) {
                    String columns[] = { "Apply Date", "Up to Valid", "Learner License No.", "Name", "Father's Name",
                            "Husband's Name", "DOB", "BG", "Permanent Add", "Mobile", "Type of Vehicle1",
                            "Type of Vehicle2", "Status" };
                    Object rows[][] = {
                            { rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5),
                                    rs.getString(6), rs.getString(7), rs.getString(8), rs.getString(9),
                                    rs.getString(10), rs.getString(11), rs.getString(12), rs.getString(13) } };

                    TableModel tmodel = new DefaultTableModel(rows, columns) {
                        public Class getColumnClass(int column) {
                            Class returnValue;
                            if ((column >= 0) && (column < getColumnCount())) {
                                returnValue = getValueAt(0, column).getClass();
                            } else {
                                returnValue = Object.class;
                            }
                            return returnValue;
                        }
                    };
                    jtable = new JTable(rows, columns);
                }
            } catch (Exception dsd) {
            }

            jspane = new JScrollPane(jtable);
            dialog.add(jspane, BorderLayout.CENTER);
            // jw.setSize(1350,200);
            setLocationRelativeTo(null);
            dialog.setVisible(true);
            sql = "";

        }
    }

    // -------------------------------------------------------------------------------------------------------------------------------------------------------------------
    private class dialog1 implements ActionListener, KeyListener {
        JDialog dialog = new JDialog((Frame) null, "Search-Learner Licence", true);
        // JFrame dialog=new JFrame();
        JTable jtable;
        JScrollPane jspane;
        JLabel lp1, lp2, lp3, l, ll, lll;
        JButton b, bb, bbb;

        dialog1() {
            dialog.setSize(1300, 350);
            dialog.setResizable(false);
            dialog.setLocationRelativeTo(null);
            dialog.setLayout(null);

            lp1 = new JLabel();
            lp1.setBorder(BorderFactory.createLineBorder(Color.black));
            Toolkit kit = Toolkit.getDefaultToolkit();
            Image img = kit.getImage(img1);
            img = img.getScaledInstance(185, 185, Image.SCALE_DEFAULT);
            lp1.setIcon(new ImageIcon(img));

            lp2 = new JLabel();
            lp2.setBorder(BorderFactory.createLineBorder(Color.black));
            lp2.setIcon(new ImageIcon(img2));
            lp3 = new JLabel();
            lp3.setBorder(BorderFactory.createLineBorder(Color.black));
            lp3.setIcon(new ImageIcon(img3));
            l = new JLabel();
            l.setIcon(new ImageIcon(pp));
            ll = new JLabel();
            ll.setIcon(new ImageIcon(ap));
            lll = new JLabel();
            lll.setIcon(new ImageIcon(bp));
            b = new JButton("Photo Proof");
            bb = new JButton("Address Proof");
            bbb = new JButton("Blood Group Proof");
            try {
                Class.forName("oracle.jdbc.driver.OracleDriver");
                Connection c = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "system", "manish");
                // Connection c=DriverManager.getConnection("jdbc:odbc:dto","","");
                Statement s = c.createStatement();
                // String sql1="Select
                // applydate,uptovalid,learnerlicenseno,name,fathername,husbandname,dob,bg,permanentadd,presentadd1,addhar,mobile,vehicletype1,vehicletype2,status
                // from learnerlicense";
                ResultSet rs = s.executeQuery(sql1);
                if (rs.next()) {
                    String columns[] = { "Apply Date", "Up to Valid", "Driving License No.", "Name", "Father's Name",
                            "Husband's Name", "DOB", "BG", "Permanent Add", "Present Add", "Addhar", "Mobile No.",
                            "Vehicle Type 1", "Vehicle Type 2", "Status" };
                    Object rows[][] = {
                            { rs.getString("applydate"), rs.getString("uptovalid"), rs.getString("dlnumber"),
                                    rs.getString("name"), rs.getString("fathername"), rs.getString("husbandname"),
                                    rs.getString("dob"), rs.getString("bg"), rs.getString("permanentadd"),
                                    rs.getString("presentadd1"), rs.getString("addhar"), rs.getString("mobile"),
                                    rs.getString("vehicletype1"), rs.getString("vehicletype2"),
                                    rs.getString("Status") } };

                    jtable = new JTable(rows, columns);
                }
            } catch (Exception dsd) {
            }

            jspane = new JScrollPane(jtable);

            jspane.setBounds(0, 0, 1300, 50);
            lp1.setBounds(10, 70, 200, 200);
            lp2.setBounds(230, 70, 200, 200);
            lp3.setBounds(450, 70, 200, 200);
            JPanel p = new JPanel();
            p.setLayout(null);
            p.setBorder(BorderFactory.createTitledBorder(BorderFactory.createEtchedBorder(), "Documents"));
            p.setBounds(670, 70, 200, 200);
            b.setBounds(20, 20, 150, 30);
            bb.setBounds(20, 70, 150, 30);
            bbb.setBounds(20, 120, 150, 30);
            p.add(b);
            p.add(bb);
            p.add(bbb);
            // dialog.add(jspane,BorderLayout.CENTER);
            // dialog.add(b11,BorderLayout.SOUTH);

            dialog.add(jspane);
            dialog.add(lp1);
            dialog.add(lp2);
            dialog.add(lp3);

            dialog.add(p);

            b.addActionListener(this);
            b.addKeyListener(this);
            bb.addActionListener(this);
            bb.addKeyListener(this);
            bbb.addActionListener(this);
            bbb.addKeyListener(this);

            dialog.setVisible(true);
            sql1 = "";

        }

        public void actionPerformed(ActionEvent e) {
            if (e.getSource() == b) {
                JOptionPane.showMessageDialog(null, l, "Photo Proof", JOptionPane.INFORMATION_MESSAGE);
            } else if (e.getSource() == bb) {
                JOptionPane.showMessageDialog(null, ll, "Photo Proof", JOptionPane.INFORMATION_MESSAGE);
            } else if (e.getSource() == bbb) {
                JOptionPane.showMessageDialog(null, lll, "Photo Proof", JOptionPane.INFORMATION_MESSAGE);
            }
        }

        public void keyPressed(KeyEvent e) {
            if (e.getKeyCode() == 10) {
                if (e.getSource() == b) {
                    JOptionPane.showMessageDialog(null, l, "Photo Proof", JOptionPane.INFORMATION_MESSAGE);
                } else if (e.getSource() == bb) {
                    JOptionPane.showMessageDialog(null, ll, "Photo Proof", JOptionPane.INFORMATION_MESSAGE);
                } else if (e.getSource() == bbb) {
                    JOptionPane.showMessageDialog(null, lll, "Photo Proof", JOptionPane.INFORMATION_MESSAGE);
                }
            } else if (e.getKeyCode() == 27) {
                dialog.dispose();
            }

        }

        public void keyTyped(KeyEvent e) {
        }

        public void keyReleased(KeyEvent e) {
        }

    }

    class Animation extends JLabel {
        private static final long serialVersionUID = 1L;

        public void paintComponent(Graphics g) {
            
            g.fillRect(0, 0, getWidth(), getHeight());
        }
    }

    public static void main(String c[]) {
        new searchbox2();

    }
}
