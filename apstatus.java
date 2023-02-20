import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.sql.*;

class apstatus extends JFrame implements ActionListener, KeyListener {
    String r = "", fname = "", hname = "";
    String sql = "", post = "";
    JLabel l, l1, l2, l3, l4, l5, l6, l7, l8, l9, l10, l11, l12, l13, l14, l15, l16, l18, l17, l19, l20, l21, l22, l23,
            l24;
    JTextField t1, t2, t3, t4, t5;
    JToggleButton tb1, tb2;
    ButtonGroup group = new ButtonGroup();
    JButton b1, b2, b3, b4, show;
    JCheckBox ch1, ch2, ch3, ch4, ch5;
    JPanel panel = new JPanel();
    JPanel panel1 = new JPanel();
    JPanel panel2 = new JPanel();
    int c1, c2, c3, c4, c5;
    
    apstatus() {
        setTitle("Application Status");
        setSize(1250, 670);
        setIconImage(Toolkit.getDefaultToolkit().getImage("images/hicon.png"));
        setResizable(false);
        setLocationRelativeTo(null);
        setLayout(null);
        try {
            UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel");
        } catch (Exception e) {
        }
        panel.setLayout(null);
        panel.setBackground(Color.blue);
        panel1.setLayout(null);
        panel1.setBackground(Color.white);
        panel2.setLayout(null);
        panel2.setBorder(BorderFactory.createTitledBorder(BorderFactory.createEtchedBorder(), "Result"));
        l = new JLabel("APPLICATION STATUS");
        l.setFont(new Font("Sans-Serif", Font.BOLD, 20));
        l.setForeground(Color.white);

        tb1 = new JToggleButton("Learner Licence");
        tb1.setFont(new Font("Bookman Old Style", Font.PLAIN, 17));
        tb2 = new JToggleButton("Smart Card");
        tb2.setFont(new Font("Bookman Old Style", Font.PLAIN, 17));

        group.add(tb1);
        group.add(tb2);

        ch1 = new JCheckBox("Applicant Id");
        ch1.setFont(new Font("Bookman Old Style", Font.PLAIN, 15));
        
        ch2 = new JCheckBox("Name");
        ch2.setFont(new Font("Bookman Old Style", Font.PLAIN, 15));
        
        ch3 = new JCheckBox("Father's/Husband's Name");
        ch3.setFont(new Font("Bookman Old Style", Font.PLAIN, 15));
        
        ch4 = new JCheckBox("Date Of Birth");
        ch4.setFont(new Font("Bookman Old Style", Font.PLAIN, 15));
        
        ch5 = new JCheckBox("Mobile Number");
        ch5.setFont(new Font("Bookman Old Style", Font.PLAIN, 15));
        
        l1 = new JLabel("Applicant Id :");
        l1.setFont(new Font("Bookman Old Style", Font.PLAIN, 16));
        l2 = new JLabel("Name :");
        l2.setFont(new Font("Bookman Old Style", Font.PLAIN, 16));
        l3 = new JLabel("Father's/Husband's Name :");
        l3.setFont(new Font("Bookman Old Style", Font.PLAIN, 16));
        l4 = new JLabel("Date Of Birth(dd/mm/yyyy) :");
        l4.setFont(new Font("Bookman Old Style", Font.PLAIN, 16));
        l5 = new JLabel("Mobile Number :");
        l5.setFont(new Font("Bookman Old Style", Font.PLAIN, 16));
        l6 = new JLabel("Search By :-");
        l6.setFont(new Font("Bookman Old Style", Font.PLAIN, 16));

        l7 = new JLabel("Date of Apply :");
        l7.setBorder(BorderFactory.createLineBorder(Color.black));
        l7.setFont(new Font("Bookman Old Style", Font.PLAIN, 14));

        l8 = new JLabel("Applicant Id :");
        l8.setFont(new Font("Bookman Old Style", Font.PLAIN, 14));

        l8.setBorder(BorderFactory.createLineBorder(Color.black));

        l9 = new JLabel("Name :");
        l9.setFont(new Font("Bookman Old Style", Font.PLAIN, 14));

        l9.setBorder(BorderFactory.createLineBorder(Color.black));

        l10 = new JLabel("Father's Name :");
        l10.setFont(new Font("Bookman Old Style", Font.PLAIN, 14));
        l10.setBorder(BorderFactory.createLineBorder(Color.black));

        l11 = new JLabel("D.O.B :");
        l11.setFont(new Font("Bookman Old Style", Font.PLAIN, 14));

        l11.setBorder(BorderFactory.createLineBorder(Color.black));
        l12 = new JLabel("Mobile No. :");
        l12.setFont(new Font("Bookman Old Style", Font.PLAIN, 14));

        l12.setBorder(BorderFactory.createLineBorder(Color.black));

        l13 = new JLabel("Vehicle Type1 :");
        l13.setFont(new Font("Bookman Old Style", Font.PLAIN, 14));
        l13.setBorder(BorderFactory.createLineBorder(Color.black));

        l23 = new JLabel("Vehicle Type2 :");
        l23.setFont(new Font("Bookman Old Style", Font.PLAIN, 14));
        l23.setBorder(BorderFactory.createLineBorder(Color.black));

        l14 = new JLabel("Status :");
        l14.setFont(new Font("Bookman Old Style", Font.PLAIN, 14));
        l14.setBorder(BorderFactory.createLineBorder(Color.black));

        l15 = new JLabel();
        l15.setBorder(BorderFactory.createLineBorder(Color.black));
        l15.setFont(new Font("Bookman Old Style", Font.PLAIN, 14));

        l16 = new JLabel();
        l16.setFont(new Font("Bookman Old Style", Font.PLAIN, 14));

        l16.setBorder(BorderFactory.createLineBorder(Color.black));
        l17 = new JLabel();
        l17.setFont(new Font("Bookman Old Style", Font.PLAIN, 14));

        l17.setBorder(BorderFactory.createLineBorder(Color.black));

        l18 = new JLabel();
        l18.setFont(new Font("Bookman Old Style", Font.PLAIN, 14));
        l18.setBorder(BorderFactory.createLineBorder(Color.black));

        l19 = new JLabel();
        l19.setFont(new Font("Bookman Old Style", Font.PLAIN, 14));
        l19.setBorder(BorderFactory.createLineBorder(Color.black));

        l20 = new JLabel();
        l20.setFont(new Font("Bookman Old Style", Font.PLAIN, 14));
        l20.setBorder(BorderFactory.createLineBorder(Color.black));

        l21 = new JLabel();
        l21.setFont(new Font("Bookman Old Style", Font.PLAIN, 14));
        l21.setBorder(BorderFactory.createLineBorder(Color.black));

        l22 = new JLabel();
        l22.setFont(new Font("Bookman Old Style", Font.PLAIN, 14));
        l22.setBorder(BorderFactory.createLineBorder(Color.black));

        l24 = new JLabel();
        l24.setFont(new Font("Bookman Old Style", Font.PLAIN, 14));
        l24.setBorder(BorderFactory.createLineBorder(Color.black));
        t1 = new JTextField();
        t1.setFont(new Font("Bookman Old Style", Font.PLAIN, 15));
        t2 = new JTextField();
        t2.setFont(new Font("Bookman Old Style", Font.PLAIN, 15));
        t3 = new JTextField();
        t3.setFont(new Font("Bookman Old Style", Font.PLAIN, 15));
        t4 = new JTextField();
        t4.setFont(new Font("Bookman Old Style", Font.PLAIN, 15));
        t5 = new JTextField();
        t5.setFont(new Font("Bookman Old Style", Font.PLAIN, 15));
        b1 = new JButton("Search");
        b1.setFont(new Font("Bookman Old Style", Font.PLAIN, 14));
        b2 = new JButton("Reset");
        b2.setFont(new Font("Bookman Old Style", Font.PLAIN, 14));
        b3 = new JButton("Cancel");
        b3.setFont(new Font("Bookman Old Style", Font.PLAIN, 14));
        b4 = new JButton("Other");
        b4.setFont(new Font("Bookman Old Style", Font.PLAIN, 14));
        show = new JButton("Show");
        show.setFont(new Font("Arial", Font.PLAIN, 14));
        panel.setBounds(0, 0, 1300, 75);
        l.setBounds(500, 25, 300, 30);
        panel1.setBounds(0, 75, 1300, 500);

        tb1.setBounds(50, 30, 350, 30);
        tb2.setBounds(420, 30, 350, 30);

        l6.setBounds(50, 100, 150, 30);
        ch1.setBounds(50, 150, 230, 30);
        ch2.setBounds(50, 200, 230, 30);
        ch3.setBounds(50, 250, 230, 30);
        ch4.setBounds(50, 300, 230, 30);
        ch5.setBounds(50, 350, 230, 30);

        panel2.setBounds(800, 30, 410, 450);
        l7.setBounds(10, 20, 180, 30);
        l15.setBounds(200, 20, 200, 30);
        l8.setBounds(10, 50, 180, 30);
        l16.setBounds(200, 50, 200, 30);
        l9.setBounds(10, 80, 180, 30);
        l17.setBounds(200, 80, 200, 30);
        l10.setBounds(10, 110, 180, 30);
        l18.setBounds(200, 110, 200, 30);
        l11.setBounds(10, 140, 180, 30);
        l19.setBounds(200, 140, 200, 30);
        l12.setBounds(10, 170, 180, 30);
        l20.setBounds(200, 170, 200, 30);
        l13.setBounds(10, 200, 180, 30);
        l21.setBounds(200, 200, 200, 30);
        l23.setBounds(10, 230, 180, 30);
        l24.setBounds(200, 230, 200, 30);
        l14.setBounds(10, 260, 180, 30);
        l22.setBounds(200, 260, 200, 30);
        show.setBounds(300, 320, 100, 25);

        l1.setBounds(285, 150, 250, 30);
        t1.setBounds(520, 150, 250, 30);
        l2.setBounds(285, 200, 250, 30);
        t2.setBounds(520, 200, 250, 30);
        l3.setBounds(285, 250, 250, 30);
        t3.setBounds(520, 250, 250, 30);
        l4.setBounds(285, 300, 250, 30);
        t4.setBounds(520, 300, 250, 30);
        l5.setBounds(285, 350, 250, 30);
        t5.setBounds(520, 350, 250, 30);

        b1.setBounds(340, 590, 100, 30);
        b4.setBounds(450, 590, 100, 30);
        b2.setBounds(560, 590, 100, 30);
        b3.setBounds(670, 590, 100, 30);

        panel.add(l);
        panel2.add(l7);
        panel2.add(l15);
        panel2.add(l8);
        panel2.add(l16);
        panel2.add(l9);
        panel2.add(l17);
        panel2.add(l10);
        panel2.add(l18);
        panel2.add(l11);
        panel2.add(l19);
        panel2.add(l12);
        panel2.add(l20);
        panel2.add(l13);
        panel2.add(l21);
        panel2.add(l23);
        panel2.add(l24);
        panel2.add(l14);
        panel2.add(l22);
        panel2.add(show);

        panel1.add(tb1);
        panel1.add(tb2);
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
        panel1.add(panel2);
        add(b1);
        add(b2);
        add(b3);
        add(b4);

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
                            || (c == KeyEvent.VK_DELETE))) {
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

        tb1.addActionListener(this);
        tb2.addActionListener(this);
        tb1.addKeyListener(this);
        tb2.addKeyListener(this);
        b1.addActionListener(this);
        b2.addActionListener(this);
        b3.addActionListener(this);
        b4.addActionListener(this);
        b1.addKeyListener(this);
        b2.addKeyListener(this);
        b3.addKeyListener(this);
        b4.addKeyListener(this);
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
        t1.addKeyListener(this);
        t2.addKeyListener(this);
        t3.addKeyListener(this);
        t4.addKeyListener(this);
        t5.addKeyListener(this);
        show.addActionListener(this);
        show.addKeyListener(this);

        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        setVisible(true);
        

        t1.requestFocus();
        tb1.setSelected(true);
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
            if (ch1.isSelected() == false && ch2.isSelected() == false && ch3.isSelected() == false
                    && ch4.isSelected() == false && ch5.isSelected() == false) {
                JOptionPane.showMessageDialog(this, "Please Check Desired Item(s).", "Search",
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
            } else {
                if (tb1.isSelected() == true) {
                    if ((ch1.isSelected() == true) && (t1.getText()).equals("")
                            && (ch1.getText()).equals("Learner Licence No.")) {
                        JOptionPane.showMessageDialog(this, "Please Enter Learner Licence Number.",
                                "Learner Licence-Search", JOptionPane.ERROR_MESSAGE);
                        t1.requestFocus();
                    } else if ((ch1.isSelected() == true) && (t1.getText()).equals("")
                            && (ch1.getText()).equals("Applicant Id")) {
                        JOptionPane.showMessageDialog(this, "Please Enter Applicant Id.", "Search",
                                JOptionPane.ERROR_MESSAGE);
                        t1.requestFocus();
                    } else if ((ch2.isSelected() == true) && (t2.getText()).equals("")) {
                        JOptionPane.showMessageDialog(this, "Please Enter Name.", "Search", JOptionPane.ERROR_MESSAGE);
                        t2.requestFocus();
                    } else if ((ch3.isSelected() == true) && (t3.getText()).equals("")) {
                        JOptionPane.showMessageDialog(this, "Please Enter Father's/Husband's Name.", "Search",
                                JOptionPane.ERROR_MESSAGE);
                        t3.requestFocus();
                    } else if ((ch4.isSelected() == true) && (t4.getText()).equals("")) {
                        JOptionPane.showMessageDialog(this, "Please Enter D.O.B .", "Search",
                                JOptionPane.ERROR_MESSAGE);
                        t4.requestFocus();
                    } else if ((ch5.isSelected() == true) && (t5.getText()).equals("")) {
                        JOptionPane.showMessageDialog(this, "Please Enter Mobile Number.", "Search",
                                JOptionPane.ERROR_MESSAGE);
                        t5.requestFocus();
                    } else {
                        if (ch1.isSelected() == true && ch2.isSelected() == true && ch3.isSelected() == true
                                && ch4.isSelected() == true && ch5.isSelected() == true) {
                            
                            sql = "Select applydate,applicantid,name,relation,fathername,husbandname,dob,mobile,vehicletype1,vehicletype2,status from applicationlearner WHERE applicantid='"
                                    + t1.getText() + "' AND name='" + t2.getText() + "' AND dob='" + t4.getText()
                                    + "' AND mobile='" + t5.getText() + "' AND (fathername='" + t3.getText()
                                    + "' OR husbandname='" + t3.getText() + "')";
                            }
                        if (ch1.isSelected() == true) {
                            
                            sql = "Select applydate,applicantid,name,relation,fathername,husbandname,dob,mobile,vehicletype1,vehicletype2,status from applicationlearner WHERE  applicantid='"
                                    + t1.getText() + "'";
                            
                        }
                        if (ch2.isSelected() == true) {
                            sql = "Select applydate,applicantid,name,relation,fathername,husbandname,dob,mobile,vehicletype1,vehicletype2,status from applicationlearner WHERE name='"
                                    + t2.getText() + "'";
                            }
                        if (ch3.isSelected() == true) {
                            sql = "Select applydate,applicantid,name,relation,fathername,husbandname,dob,mobile,vehicletype1,vehicletype2,status from applicationlearner WHERE  (fathername='"
                                    + t3.getText() + "' OR husbandname='" + t3.getText() + "') ";
                        }
                        if (ch4.isSelected() == true) {
                            sql = "Select applydate,applicantid,name,relation,fathername,husbandname,dob,mobile,vehicletype1,vehicletype2,status from applicationlearner WHERE  dob='"
                                    + t4.getText() + "'";
                            }
                        if (ch5.isSelected() == true) {
                            sql = "Select applydate,applicantid,name,relation,fathername,husbandname,dob,mobile,vehicletype1,vehicletype2,status from applicationlearner WHERE  mobile='"
                                    + t5.getText() + "'";
                            }
                        if (ch1.isSelected() == true && ch2.isSelected() == true) {
                            sql = "Select applydate,applicantid,name,relation,fathername,husbandname,dob,mobile,vehicletype1,vehicletype2,status from applicationlearner WHERE applicantid='"
                                    + t1.getText() + "' AND name='" + t2.getText() + "'";
                            }
                        if (ch1.isSelected() == true && ch3.isSelected() == true) {
                            sql = "Select applydate,applicantid,name,relation,fathername,husbandname,dob,mobile,vehicletype1,vehicletype2,status from applicationlearner WHERE applicantid='"
                                    + t1.getText() + "' AND (husbandname='" + t3.getText() + "' OR fathername='"
                                    + t3.getText() + "') ";

                            }
                        if (ch1.isSelected() == true && ch4.isSelected() == true) {
                            sql = "Select applydate,applicantid,name,relation,fathername,husbandname,dob,mobile,vehicletype1,vehicletype2,status from applicationlearner WHERE applicantid='"
                                    + t1.getText() + "' AND dob='" + t4.getText() + "'";
                            }
                        if (ch1.isSelected() == true && ch5.isSelected() == true) {
                            sql = "Select applydate,applicantid,name,relation,fathername,husbandname,dob,mobile,vehicletype1,vehicletype2,status from applicationlearner WHERE applicantid='"
                                    + t1.getText() + "' AND mobile='" + t5.getText() + "'";
                            }
                        if (ch2.isSelected() == true && ch3.isSelected() == true) {
                            sql = "Select applydate,applicantid,name,relation,fathername,husbandname,dob,mobile,vehicletype1,vehicletype2,status from applicationlearner WHERE name='"
                                    + t2.getText() + "' AND (husbandname='" + t3.getText() + "' OR fathername='"
                                    + t3.getText() + "') ";
                            }
                        if (ch2.isSelected() == true && ch4.isSelected() == true) {
                            sql = "Select applydate,applicantid,name,relation,fathername,husbandname,dob,mobile,vehicletype1,vehicletype2,status from applicationlearner WHERE name='"
                                    + t2.getText() + "' AND dob='" + t4.getText() + "'";
                            }
                        if (ch2.isSelected() == true && ch5.isSelected() == true) {
                            sql = "Select applydate,applicantid,name,relation,fathername,husbandname,dob,mobile,vehicletype1,vehicletype2,status from applicationlearner WHERE name='"
                                    + t2.getText() + "' AND mobile='" + t5.getText() + "'";
                            }
                        if (ch3.isSelected() == true && ch4.isSelected() == true) {
                            sql = "Select applydate,applicantid,name,relation,fathername,husbandname,dob,mobile,vehicletype1,vehicletype2,status from applicationlearner WHERE dob='"
                                    + t4.getText() + "' AND (fathername='" + t3.getText() + "' OR husbandname='"
                                    + t3.getText() + "') ";
                            }
                        if (ch3.isSelected() == true && ch5.isSelected() == true) {
                            sql = "Select applydate,applicantid,name,relation,fathername,husbandname,dob,mobile,vehicletype1,vehicletype2,status from applicationlearner WHERE mobile='"
                                    + t5.getText() + "' AND (fathername='" + t3.getText() + "' OR husbandname='"
                                    + t3.getText() + "')";
                            }
                        if (ch4.isSelected() == true && ch5.isSelected() == true) {
                            sql = "Select applydate,applicantid,name,relation,fathername,husbandname,dob,mobile,vehicletype1,vehicletype2,status from applicationlearner WHERE dob='"
                                    + t4.getText() + "' AND mobile='" + t5.getText() + "' ";
                            }
                        if (ch1.isSelected() == true && ch2.isSelected() == true && ch3.isSelected() == true) {
                            sql = "Select applydate,applicantid,name,relation,fathername,husbandname,dob,mobile,vehicletype1,vehicletype2,status from applicationlearner WHERE applicantid='"
                                    + t1.getText() + "' AND name='" + t2.getText() + "' AND (fathername='"
                                    + t3.getText() + "' OR husbandname='" + t3.getText() + "') ";
                            }
                        if (ch1.isSelected() == true && ch2.isSelected() == true && ch4.isSelected() == true) {
                            sql = "Select applydate,applicantid,name,relation,fathername,husbandname,dob,mobile,vehicletype1,vehicletype2,status from applicationlearner WHERE applicantid='"
                                    + t1.getText() + "' AND name='" + t2.getText() + "' AND dob='" + t4.getText() + "'";
                            }
                        if (ch1.isSelected() == true && ch2.isSelected() == true && ch5.isSelected() == true) {
                            sql = "Select applydate,applicantid,name,relation,fathername,husbandname,dob,mobile,vehicletype1,vehicletype2,status from applicationlearner WHERE applicantid='"
                                    + t1.getText() + "' AND name='" + t2.getText() + "' AND mobile='" + t5.getText()
                                    + "'";
                            }
                        if (ch1.isSelected() == true && ch3.isSelected() == true && ch4.isSelected() == true) {
                            sql = "Select applydate,applicantid,name,relation,fathername,husbandname,dob,mobile,vehicletype1,vehicletype2,status from applicationlearner WHERE applicantid='"
                                    + t1.getText() + "' AND dob='" + t4.getText() + "' AND (husbandname='"
                                    + t3.getText() + "' OR fathername='" + t3.getText() + "') ";
                            }
                        if (ch1.isSelected() == true && ch3.isSelected() == true && ch5.isSelected() == true) {
                            sql = "Select applydate,applicantid,name,relation,fathername,husbandname,dob,mobile,vehicletype1,vehicletype2,status from applicationlearner WHERE applicantid='"
                                    + t1.getText() + "' AND mobile='" + t5.getText() + "' AND (fathername='"
                                    + t3.getText() + "' OR husbandname='" + t3.getText() + "')  ";
                            }
                        if (ch1.isSelected() == true && ch4.isSelected() == true && ch5.isSelected() == true) {
                            sql = "Select applydate,applicantid,name,relation,fathername,husbandname,dob,mobile,vehicletype1,vehicletype2,status from applicationlearner WHERE applicantid='"
                                    + t1.getText() + "' AND dob='" + t4.getText() + "' AND mobile='" + t5.getText()
                                    + "'";
                            }
                        if (ch2.isSelected() == true && ch4.isSelected() == true && ch5.isSelected() == true) {
                            sql = "Select applydate,applicantid,name,relation,fathername,husbandname,dob,mobile,vehicletype1,vehicletype2,status from applicationlearner WHERE name='"
                                    + t2.getText() + "' AND dob='" + t4.getText() + "' AND mobile='" + t5.getText()
                                    + "'";
                            }
                        if (ch2.isSelected() == true && ch3.isSelected() == true && ch4.isSelected() == true) {
                            sql = "Select applydate,applicantid,name,relation,fathername,husbandname,dob,mobile,vehicletype1,vehicletype2,status from applicationlearner WHERE name='"
                                    + t2.getText() + "' AND dob='" + t4.getText() + "' AND (fathername='" + t3.getText()
                                    + "' OR husbandname='" + t3.getText() + "')";
                            }
                        if (ch2.isSelected() == true && ch3.isSelected() == true && ch5.isSelected() == true) {
                            sql = "Select applydate,applicantid,name,relation,fathername,husbandname,dob,mobile,vehicletype1,vehicletype2,status from applicationlearner WHERE name='"
                                    + t2.getText() + "' AND mobile='" + t5.getText() + "' AND (fathername='"
                                    + t3.getText() + "' OR husbandname='" + t3.getText() + "') ";
                            }
                        if (ch3.isSelected() == true && ch4.isSelected() == true && ch5.isSelected() == true) {
                            sql = "Select applydate,applicantid,name,relation,fathername,husbandname,dob,mobile,vehicletype1,vehicletype2,status from applicationlearner WHERE dob='"
                                    + t4.getText() + "' AND mobile='" + t5.getText() + "' (fathername='" + t3.getText()
                                    + "' OR husbandname='" + t3.getText() + "')";
                            }
                        if (ch1.isSelected() == true && ch2.isSelected() == true && ch3.isSelected() == true
                                && ch4.isSelected() == true) {
                            sql = "Select applydate,applicantid,name,relation,fathername,husbandname,dob,mobile,vehicletype1,vehicletype2,status from applicationlearner WHERE applicantid='"
                                    + t1.getText() + "' AND name='" + t2.getText() + "' AND dob='" + t4.getText()
                                    + "' AND (fathername='" + t3.getText() + "' OR husbandname='" + t3.getText()
                                    + "') ";
                            }
                        if (ch1.isSelected() == true && ch2.isSelected() == true && ch3.isSelected() == true
                                && ch5.isSelected() == true) {
                            sql = "Select applydate,applicantid,name,relation,fathername,husbandname,dob,mobile,vehicletype1,vehicletype2,status from applicationlearner WHERE applicantid='"
                                    + t1.getText() + "' AND name='" + t2.getText() + "' AND mobile='" + t5.getText()
                                    + "' AND (fathername='" + t3.getText() + "' OR husbandname='" + t3.getText() + "')";
                            }
                        if (ch1.isSelected() == true && ch3.isSelected() == true && ch4.isSelected() == true
                                && ch5.isSelected() == true) {
                            sql = "Select applydate,applicantid,name,relation,fathername,husbandname,dob,mobile,vehicletype1,vehicletype2,status from applicationlearner WHERE applicantid='"
                                    + t1.getText() + "' AND dob='" + t4.getText() + "' AND mobile='" + t5.getText()
                                    + "' AND (fathername='" + t3.getText() + "' OR husbandname='" + t3.getText()
                                    + "') ";
                            }
                        if (ch1.isSelected() == true && ch2.isSelected() == true && ch4.isSelected() == true
                                && ch5.isSelected() == true) {
                            sql = "Select applydate,applicantid,name,relation,fathername,husbandname,dob,mobile,vehicletype1,vehicletype2,status from applicationlearner WHERE applicantid='"
                                    + t1.getText() + "' AND name='" + t2.getText() + "' AND dob='" + t4.getText()
                                    + "' AND mobile='" + t5.getText() + "'";
                            }
                        if (ch2.isSelected() == true && ch3.isSelected() == true && ch4.isSelected() == true
                                && ch5.isSelected() == true) {
                            sql = "Select applydate,applicantid,name,relation,fathername,husbandname,dob,mobile,vehicletype1,vehicletype2,status from applicationlearner WHERE name='"
                                    + t2.getText() + "' AND dob='" + t4.getText() + "' AND mobile='" + t5.getText()
                                    + "' AND (fathername='" + t3.getText() + "' OR husbandname='" + t3.getText()
                                    + "') ";
                            }
                        try {
                            Class.forName("oracle.jdbc.driver.OracleDriver");
                            Connection c = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "system",
                                    "manish");
                            Statement s = c.createStatement();
                            ResultSet rs = s.executeQuery(sql);
                            if (rs.next()) {
                                l15.setText(rs.getString(1));
                                l16.setText(rs.getString(2));
                                l17.setText(rs.getString(3));
                                r = rs.getString(4);
                                fname = (rs.getString(5));
                                hname = (rs.getString(6));
                                l19.setText(rs.getString(7));
                                l20.setText(rs.getString(8));
                                l21.setText(rs.getString(9));
                                l24.setText(rs.getString(10));
                                l22.setText(rs.getString(11));
                            } else {
                                JOptionPane.showMessageDialog(this, "Invalid Data.", "Driving Licence-Search",
                                        JOptionPane.ERROR_MESSAGE);
                                l15.setText("");
                                l16.setText("");
                                l17.setText("");
                                l18.setText("");
                                l19.setText("");
                                l20.setText("");
                                l21.setText("");
                                l24.setText("");
                                l22.setText("");
                                fname = "";
                                hname = "";
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
                        if (r.equals("S/O") || (r.equals("D/O"))) {
                            l10.setText("Father's Name :");
                            l18.setText(fname);
                        }
                        if (r.equals("W/O")) {
                            l10.setText("Husband's Name :");
                            l18.setText(hname);
                        }
                    }

                } else if (tb2.isSelected() == true) {
                    if ((ch1.isSelected() == true) && (t1.getText()).equals("")
                            && (ch1.getText()).equals("Learner Licence No.")) {
                        JOptionPane.showMessageDialog(this, "Please Enter Learner Licence Number.",
                                "Learner Licence-Search", JOptionPane.ERROR_MESSAGE);
                        t1.requestFocus();
                    } else if ((ch1.isSelected() == true) && (t1.getText()).equals("")
                            && (ch1.getText()).equals("Applicant Id")) {
                        JOptionPane.showMessageDialog(this, "Please Enter Applicant Id.", "Search",
                                JOptionPane.ERROR_MESSAGE);
                        t1.requestFocus();
                    } else if ((ch2.isSelected() == true) && (t2.getText()).equals("")) {
                        JOptionPane.showMessageDialog(this, "Please Enter Name.", "Search", JOptionPane.ERROR_MESSAGE);
                        t2.requestFocus();
                    } else if ((ch3.isSelected() == true) && (t3.getText()).equals("")) {
                        JOptionPane.showMessageDialog(this, "Please Enter Father's/Husband's Name.", "Search",
                                JOptionPane.ERROR_MESSAGE);
                        t3.requestFocus();
                    } else if ((ch4.isSelected() == true) && (t4.getText()).equals("")) {
                        JOptionPane.showMessageDialog(this, "Please Enter D.O.B .", "Search",
                                JOptionPane.ERROR_MESSAGE);
                        t4.requestFocus();
                    } else if ((ch5.isSelected() == true) && (t5.getText()).equals("")) {
                        JOptionPane.showMessageDialog(this, "Please Enter Mobile Number.", "Search",
                                JOptionPane.ERROR_MESSAGE);
                        t5.requestFocus();
                    } else {
                        if (ch1.isSelected() == true && ch2.isSelected() == true && ch3.isSelected() == true
                                && ch4.isSelected() == true && ch5.isSelected() == true) {
                            sql = "Select applydate,learnerlicense,name,relation,fathername,husbandname,dob,mobile,vehicletype1,vehicletype2,status from applicationdl WHERE learnerlicense='"
                                    + t1.getText() + "' AND name='" + t2.getText() + "' AND dob='" + t4.getText()
                                    + "' AND mobile='" + t5.getText() + "' AND (fathername='" + t3.getText()
                                    + "' OR husbandname='" + t3.getText() + "') ";
                            }
                        if (ch1.isSelected() == true) {
                            sql = "Select applydate,learnerlicense,name,relation,fathername,husbandname,dob,mobile,vehicletype1,vehicletype2,status from applicationdl WHERE  learnerlicense='"
                                    + t1.getText() + "'";
                            }
                        if (ch2.isSelected() == true) {
                            sql = "Select applydate,learnerlicense,name,relation,fathername,husbandname,dob,mobile,vehicletype1,vehicletype2,status from applicationdl WHERE name='"
                                    + t2.getText() + "'";
                            }
                        if (ch3.isSelected() == true) {
                            sql = "Select applydate,learnerlicense,name,relation,fathername,husbandname,dob,mobile,vehicletype1,vehicletype2,status from applicationdl WHERE  (fathername='"
                                    + t3.getText() + "' OR husbandname='" + t3.getText() + "') ";
                        }
                        if (ch4.isSelected() == true) {
                            sql = "Select applydate,learnerlicense,name,relation,fathername,husbandname,dob,mobile,vehicletype1,vehicletype2,status from applicationdl WHERE  dob='"
                                    + t4.getText() + "'";
                            }
                        if (ch5.isSelected() == true) {
                            sql = "Select applydate,learnerlicense,name,relation,fathername,husbandname,dob,mobile,vehicletype1,vehicletype2,status from applicationdl WHERE  mobile='"
                                    + t5.getText() + "'";
                            }
                        if (ch1.isSelected() == true && ch2.isSelected() == true) {
                            sql = "Select applydate,learnerlicense,name,relation,fathername,husbandname,dob,mobile,vehicletype1,vehicletype2,status from applicationdl WHERE learnerlicense='"
                                    + t1.getText() + "' AND name='" + t2.getText() + "'";
                            }
                        if (ch1.isSelected() == true && ch3.isSelected() == true) {
                            sql = "Select applydate,learnerlicense,name,relation,fathername,husbandname,dob,mobile,vehicletype1,vehicletype2,status from applicationdl WHERE learnerlicense='"
                                    + t1.getText() + "' AND (husbandname='" + t3.getText() + "' OR fathername='"
                                    + t3.getText() + "') ";

                            }
                        if (ch1.isSelected() == true && ch4.isSelected() == true) {
                            sql = "Select applydate,learnerlicense,name,relation,fathername,husbandname,dob,mobile,vehicletype1,vehicletype2,status from applicationdl WHERE learnerlicense='"
                                    + t1.getText() + "' AND dob='" + t4.getText() + "'";
                            }
                        if (ch1.isSelected() == true && ch5.isSelected() == true) {
                            sql = "Select applydate,learnerlicense,name,relation,fathername,husbandname,dob,mobile,vehicletype1,vehicletype2,status from applicationdl WHERE learnerlicense='"
                                    + t1.getText() + "' AND mobile='" + t5.getText() + "'";
                            }
                        if (ch2.isSelected() == true && ch3.isSelected() == true) {
                            sql = "Select applydate,learnerlicense,name,relation,fathername,husbandname,dob,mobile,vehicletype1,vehicletype2,status from applicationdl WHERE name='"
                                    + t2.getText() + "' AND (husbandname='" + t3.getText() + "' OR fathername='"
                                    + t3.getText() + "') ";
                            }
                        if (ch2.isSelected() == true && ch4.isSelected() == true) {
                            sql = "Select applydate,learnerlicense,name,relation,fathername,husbandname,dob,mobile,vehicletype1,vehicletype2,status from applicationdl WHERE name='"
                                    + t2.getText() + "' AND dob='" + t4.getText() + "'";
                            }
                        if (ch2.isSelected() == true && ch5.isSelected() == true) {
                            sql = "Select applydate,learnerlicense,name,relation,fathername,husbandname,dob,mobile,vehicletype1,vehicletype2,status from applicationdl WHERE name='"
                                    + t2.getText() + "' AND mobile='" + t5.getText() + "'";
                            }
                        if (ch3.isSelected() == true && ch4.isSelected() == true) {
                            sql = "Select applydate,learnerlicense,name,relation,fathername,husbandname,dob,mobile,vehicletype1,vehicletype2,status from applicationdl WHERE dob='"
                                    + t4.getText() + "' AND (fathername='" + t3.getText() + "' OR husbandname='"
                                    + t3.getText() + "')";
                            }
                        if (ch3.isSelected() == true && ch5.isSelected() == true) {
                            sql = "Select applydate,learnerlicense,name,relation,fathername,husbandname,dob,mobile,vehicletype1,vehicletype2,status from applicationdl WHERE mobile='"
                                    + t5.getText() + "' AND (fathername='" + t3.getText() + "' OR husbandname='"
                                    + t3.getText() + "')";
                            }
                        if (ch4.isSelected() == true && ch5.isSelected() == true) {
                            sql = "Select applydate,learnerlicense,name,relation,fathername,husbandname,dob,mobile,vehicletype1,vehicletype2,status from applicationdl WHERE dob='"
                                    + t4.getText() + "' AND mobile='" + t5.getText() + "' ";
                            }
                        if (ch1.isSelected() == true && ch2.isSelected() == true && ch3.isSelected() == true) {
                            sql = "Select applydate,learnerlicense,name,relation,fathername,husbandname,dob,mobile,vehicletype1,vehicletype2,status from applicationdl WHERE learnerlicense='"
                                    + t1.getText() + "' AND name='" + t2.getText() + "' AND (fathername='"
                                    + t3.getText() + "' OR husbandname='" + t3.getText() + "') ";
                            }
                        if (ch1.isSelected() == true && ch2.isSelected() == true && ch4.isSelected() == true) {
                            sql = "Select applydate,learnerlicense,name,relation,fathername,husbandname,dob,mobile,vehicletype1,vehicletype2,status from applicationdl WHERE learnerlicense='"
                                    + t1.getText() + "' AND name='" + t2.getText() + "' AND dob='" + t4.getText() + "'";
                            }
                        if (ch1.isSelected() == true && ch2.isSelected() == true && ch5.isSelected() == true) {
                            sql = "Select applydate,learnerlicense,name,relation,fathername,husbandname,dob,mobile,vehicletype1,vehicletype2,status from applicationdl WHERE learnerlicense='"
                                    + t1.getText() + "' AND name='" + t2.getText() + "' AND mobile='" + t5.getText()
                                    + "'";
                            }
                        if (ch1.isSelected() == true && ch3.isSelected() == true && ch4.isSelected() == true) {
                            sql = "Select applydate,learnerlicense,name,relation,fathername,husbandname,dob,mobile,vehicletype1,vehicletype2,status from applicationdl WHERE learnerlicense='"
                                    + t1.getText() + "' AND dob='" + t4.getText() + "' AND (husbandname='"
                                    + t3.getText() + "' OR fathername='" + t3.getText() + "') ";
                            }
                        if (ch1.isSelected() == true && ch3.isSelected() == true && ch5.isSelected() == true) {
                            sql = "Select applydate,learnerlicense,name,relation,fathername,husbandname,dob,mobile,vehicletype1,vehicletype2,status from applicationdl WHERE learnerlicense='"
                                    + t1.getText() + "' AND mobile='" + t5.getText() + "' AND (fathername='"
                                    + t3.getText() + "' OR husbandname='" + t3.getText() + "') ";
                            }
                        if (ch1.isSelected() == true && ch4.isSelected() == true && ch5.isSelected() == true) {
                            sql = "Select applydate,learnerlicense,name,relation,fathername,husbandname,dob,mobile,vehicletype1,vehicletype2,status from applicationdl WHERE learnerlicense='"
                                    + t1.getText() + "' AND dob='" + t4.getText() + "' AND mobile='" + t5.getText()
                                    + "'";
                            }
                        if (ch2.isSelected() == true && ch4.isSelected() == true && ch5.isSelected() == true) {
                            sql = "Select applydate,learnerlicense,name,relation,fathername,husbandname,dob,mobile,vehicletype1,vehicletype2,status from applicationdl WHERE name='"
                                    + t2.getText() + "' AND dob='" + t4.getText() + "' AND mobile='" + t5.getText()
                                    + "'";
                            }
                        if (ch2.isSelected() == true && ch3.isSelected() == true && ch4.isSelected() == true) {
                            sql = "Select applydate,learnerlicense,name,relation,fathername,husbandname,dob,mobile,vehicletype1,vehicletype2,status from applicationdl WHERE name='"
                                    + t2.getText() + "' AND dob='" + t4.getText() + "' AND (fathername='" + t3.getText()
                                    + "' OR husbandname='" + t3.getText() + "') ";
                            }
                        if (ch2.isSelected() == true && ch3.isSelected() == true && ch5.isSelected() == true) {
                            sql = "Select applydate,learnerlicense,name,relation,fathername,husbandname,dob,mobile,vehicletype1,vehicletype2,status from applicationdl WHERE name='"
                                    + t2.getText() + "' AND mobile='" + t5.getText() + "' AND (fathername='"
                                    + t3.getText() + "' OR husbandname='" + t3.getText() + "') ";
                            }
                        if (ch3.isSelected() == true && ch4.isSelected() == true && ch5.isSelected() == true) {
                            sql = "Select applydate,learnerlicense,name,relation,fathername,husbandname,dob,mobile,vehicletype1,vehicletype2,status from applicationdl WHERE dob='"
                                    + t4.getText() + "' AND mobile='" + t5.getText() + "' AND (fathername='"
                                    + t3.getText() + "' OR husbandname='" + t3.getText() + "')";
                            }
                        if (ch1.isSelected() == true && ch2.isSelected() == true && ch3.isSelected() == true
                                && ch4.isSelected() == true) {
                            sql = "Select applydate,learnerlicense,name,relation,fathername,husbandname,dob,mobile,vehicletype1,vehicletype2,status from applicationdl WHERE learnerlicense='"
                                    + t1.getText() + "' AND name='" + t2.getText() + "' AND dob='" + t4.getText()
                                    + "' AND (fathername='" + t3.getText() + "' OR husbandname='" + t3.getText()
                                    + "') ";
                            }
                        if (ch1.isSelected() == true && ch2.isSelected() == true && ch3.isSelected() == true
                                && ch5.isSelected() == true) {
                            sql = "Select applydate,learnerlicense,name,relation,fathername,husbandname,dob,mobile,vehicletype1,vehicletype2,status from applicationdl WHERE learnerlicense='"
                                    + t1.getText() + "' AND name='" + t2.getText() + "' AND mobile='" + t5.getText()
                                    + "' AND (fathername='" + t3.getText() + "' OR husbandname='" + t3.getText()
                                    + "') ";
                            }
                        if (ch1.isSelected() == true && ch3.isSelected() == true && ch4.isSelected() == true
                                && ch5.isSelected() == true) {
                            sql = "Select applydate,learnerlicense,name,relation,fathername,husbandname,dob,mobile,vehicletype1,vehicletype2,status from applicationdl WHERE learnerlicense='"
                                    + t1.getText() + "' AND dob='" + t4.getText() + "' AND mobile='" + t5.getText()
                                    + "' AND (fathername='" + t3.getText() + "' OR husbandname='" + t3.getText()
                                    + "') ";
                            }
                        if (ch1.isSelected() == true && ch2.isSelected() == true && ch4.isSelected() == true
                                && ch5.isSelected() == true) {
                            sql = "Select applydate,learnerlicense,name,relation,fathername,husbandname,dob,mobile,vehicletype1,vehicletype2,status from applicationdl WHERE learnerlicense='"
                                    + t1.getText() + "' AND name='" + t2.getText() + "' AND dob='" + t4.getText()
                                    + "' AND mobile='" + t5.getText() + "'";
                            }
                        if (ch2.isSelected() == true && ch3.isSelected() == true && ch4.isSelected() == true
                                && ch5.isSelected() == true) {
                            sql = "Select applydate,learnerlicense,name,relation,fathername,husbandname,dob,mobile,vehicletype1,vehicletype2,status from applicationdl WHERE name='"
                                    + t2.getText() + "' AND dob='" + t4.getText() + "' AND mobile='" + t5.getText()
                                    + "' AND (fathername='" + t3.getText() + "' OR husbandname='" + t3.getText()
                                    + "') ";
                            }

                        try {
                            Class.forName("oracle.jdbc.driver.OracleDriver");
                            Connection c = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "system",
                                    "manish");
                            Statement s = c.createStatement();

                            ResultSet rs = s.executeQuery(sql);
                            if (rs.next()) {
                                l15.setText(rs.getString(1));
                                l16.setText(rs.getString(2));
                                l17.setText(rs.getString(3));
                                r = rs.getString(4);
                                fname = (rs.getString(5));
                                hname = (rs.getString(6));
                                l19.setText(rs.getString(7));
                                l20.setText(rs.getString(8));
                                l21.setText(rs.getString(9));
                                l24.setText(rs.getString(10));
                                l22.setText(rs.getString(11));

                            } else {
                                JOptionPane.showMessageDialog(this, "Invalid Data.", "Driving Licence-Search",
                                        JOptionPane.ERROR_MESSAGE);
                                l15.setText("");
                                l16.setText("");
                                l17.setText("");
                                l18.setText("");
                                l19.setText("");
                                l20.setText("");
                                l21.setText("");
                                l24.setText("");
                                l22.setText("");
                                fname = "";
                                hname = "";
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
                        if (r.equals("S/O") || (r.equals("D/O"))) {
                            l10.setText("Father's Name :");
                            l18.setText(fname);
                        }
                        if (r.equals("W/O")) {
                            l10.setText("Husband's Name :");
                            l18.setText(hname);
                        }

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
            c1 = 1;
            t2.setText("");
            t3.setText("");
            t4.setText("");
            t5.setText("");
            t1.requestFocus();
            ch1.setSelected(true);
            l15.setText("");
            l16.setText("");
            l17.setText("");
            l18.setText("");
            l19.setText("");
            l20.setText("");
            l21.setText("");
            l24.setText("");
            l22.setText("");
        } else if (e.getSource() == b4) {
            t1.setText("");
            t2.setText("");
            t3.setText("");
            t4.setText("");
            t5.setText("");
            l15.setText("");
            l16.setText("");
            l17.setText("");
            l18.setText("");
            l19.setText("");
            l20.setText("");
            l21.setText("");
            l22.setText("");
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

        } else if (e.getSource() == tb2) {
            ch1.setText("Learner Licence No.");
            l1.setText("Learner Licence Number :");
            l8.setText("Learner Licence No. :");
            t2.setText("");
            t3.setText("");
            t4.setText("");
            t5.setText("");
            t1.setText("");
            l15.setText("");
            l16.setText("");
            l17.setText("");
            l18.setText("");
            l19.setText("");
            l20.setText("");
            l21.setText("");
            l24.setText("");
            l22.setText("");
            t1.requestFocus();
        } else if (e.getSource() == tb1) {
            ch1.setText("Applicant Id");
            l1.setText("Applicant Id :");
            l8.setText("Applicant Id :");
            t2.setText("");
            t3.setText("");
            t4.setText("");
            t5.setText("");
            t1.setText("");
            l15.setText("");
            l16.setText("");
            l17.setText("");
            l18.setText("");
            l19.setText("");
            l20.setText("");
            l21.setText("");
            l24.setText("");
            l22.setText("");
            t1.requestFocus();
        }

        else if (e.getSource() == show) {
            if (l8.getText().equals("Applicant Id :")) {
                if (l22.getText().equals("APPROVED")) {
                    post = l16.getText();
                    System.out.print(post);
                    new learnerform(post);
                } else if (l22.getText().equals("DISAPPROVED") || l22.getText().equals("PENDING")) {
                    JOptionPane.showMessageDialog(this, "Do not allow in a Disapproved Form or Pending Form.", "Search",
                            JOptionPane.ERROR_MESSAGE);
                }
            } else if (l8.getText().equals("Learner Licence No. :")) {
                if (l22.getText().equals("APPROVED")) {
                    post = l16.getText();
                    System.out.print(post);
                    new smartcard(post);
                    
                } else if (l22.getText().equals("DISAPPROVED") || l22.getText().equals("PENDING")) {
                    JOptionPane.showMessageDialog(this, "Do not allow in a Disapproved Form or Pending Form.", "Search",
                            JOptionPane.ERROR_MESSAGE);
                }
            }

            post = "";
        }

    }

    public void keyPressed(KeyEvent e) {

        if (e.getKeyCode() == 10) {
            if (e.getSource() == ch1) {
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
            } else if (e.getSource() == t1) {
                if (t1.isEditable() != false) {
                    if ((t1.getText()).equals("") && (ch1.getText()).equals("Learner Licence No.")) {
                        JOptionPane.showMessageDialog(this, "Please Enter Learner Licence.", "Search",
                                JOptionPane.ERROR_MESSAGE);
                        t1.requestFocus();
                    } else if ((t1.getText()).equals("") && (ch1.getText()).equals("Applicant Id")) {
                        JOptionPane.showMessageDialog(this, "Please Enter Applicant Id.", "Search",
                                JOptionPane.ERROR_MESSAGE);
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
                        JOptionPane.showMessageDialog(this, "Please Enter Name.", "Search", JOptionPane.ERROR_MESSAGE);
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
                        JOptionPane.showMessageDialog(this, "Please Enter Father's/Husband's Name.", "Search",
                                JOptionPane.ERROR_MESSAGE);
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
                        JOptionPane.showMessageDialog(this, "Please Enter D.O.B .", "Search",
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
            } else if (e.getSource() == t5) {
                if (t5.isEditable() != false) {
                    if ((t5.getText()).equals("") || (t5.getText()).equals(null)) {
                        JOptionPane.showMessageDialog(this, "Please Enter Mobile Number.", "Search",
                                JOptionPane.ERROR_MESSAGE);
                        t5.requestFocus();
                    } else {
                        b1.requestFocus();
                    }
                }
            } else if (e.getSource() == tb1) {
                tb1.setSelected(true);
                ch1.setText("Applicant Id");
                l1.setText("Applicant Id :");
                l8.setText("Applicant Id :");
                t1.setText("");
                t2.setText("");
                t4.setText("");
                t3.setText("");
                t5.setText("");
                l13.setText("");
                l14.setText("");
                l15.setText("");
                l16.setText("");
                l17.setText("");
                l18.setText("");
                t1.requestFocus();
            } else if (e.getSource() == tb2) {
                tb2.setSelected(true);
                ch1.setText("Learner Licence No.");
                l1.setText("Learner Licence Number :");
                l8.setText("Learner Licence No. :");
                t1.setText("");
                t2.setText("");
                t4.setText("");
                t3.setText("");
                t5.setText("");
                l13.setText("");
                l14.setText("");
                l15.setText("");
                l16.setText("");
                l17.setText("");
                l18.setText("");
                t1.requestFocus();
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
        } else if (e.getKeyCode() == 39) {
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
        }
        if (e.getKeyCode() == 27) {
            dispose();
        }

    }

    public void keyTyped(KeyEvent e) {
    }

    public void keyReleased(KeyEvent e) {
    }

    

    public static void main(String c[]) {
        new apstatus();
    }
}
