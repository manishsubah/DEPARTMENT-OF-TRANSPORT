import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.sql.*;

class admin extends JFrame implements ActionListener, KeyListener {
    JLabel l, l1;
    JPasswordField t1;
    JButton b1, b2;
    JPanel panel1 = new JPanel();
    JPanel panel2 = new JPanel();
    Color color0 = Color.orange;
    Color color1 = Color.orange;
    Color color2 = Color.blue;
    int Duration = 5000;
    long st;
    Animation anim = new Animation();
    Color c = new Color(0, 128, 128);

    admin() {
        setTitle("Administrator");
        setSize(300, 210);
        setIconImage(Toolkit.getDefaultToolkit().getImage("images/hicon.png"));
        setResizable(false);
        setLocationRelativeTo(null);
        setLayout(null);
        panel1.setLayout(null);
        panel2.setBackground(Color.black);
        l = new JLabel("ADMINISTRATOR");
        l.setForeground(Color.white);
        l.setFont(new Font("Book Antiqua", Font.BOLD, 17));
        l1 = new JLabel("Enter Master Password");
        l1.setFont(new Font("Bookman Old Style", Font.PLAIN, 16));
        t1 = new JPasswordField();
        b1 = new JButton("Ok");
        b2 = new JButton("Cancel");
        anim.setBounds(0, 0, 300, 40);
        panel1.setBounds(0, 0, 300, 40);
        l.setBounds(65, 10, 200, 20);
        panel1.add(l);
        panel1.add(anim);
        l1.setBounds(50, 50, 300, 30);
        panel2.setBounds(8, 85, 280, 3);
        t1.setBounds(25, 100, 240, 30);
        b1.setBounds(10, 135, 130, 30);
        b2.setBounds(150, 135, 130, 30);
        add(panel1);
        add(l1);
        add(panel2);
        add(t1);
        add(b1);
        add(b2);
        t1.addActionListener(this);
        t1.addKeyListener(this);
        b1.addActionListener(this);
        b1.addKeyListener(this);
        b2.addActionListener(this);
        b2.addKeyListener(this);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setVisible(true);
        try {
            Timer t = new Timer(5, this);
            t.setInitialDelay(1000);
            st = 1000 + System.nanoTime() / 1000000;
            t.start();
        } catch (Exception e) {
        }
    }

    public void actionPerformed(ActionEvent e) {
        long currentTime = System.nanoTime() / 1000000;
        long totalTime = currentTime - st;
        if (totalTime > Duration) {
            st = currentTime;
        }
        float fraction = (float) totalTime / Duration;
        fraction = Math.min(1.0f, fraction);
        int r = (int) (fraction * color2.getRed() + (1 - fraction) * color1.getRed());
        int g = (int) (fraction * color2.getGreen() + (1 - fraction) * color1.getGreen());
        int b = (int) (fraction * color2.getBlue() + (1 - fraction) * color1.getBlue());
        color0 = new Color(r, g, b);
        anim.repaint();
        if (e.getSource() == b1) {
            if ((t1.getPassword()).equals("") || (t1.getPassword()).equals(null)) {
                JOptionPane.showMessageDialog(this, "Please Enter Master Password.", "Administrator",
                        JOptionPane.ERROR_MESSAGE);
                t1.requestFocus();
            } else {
                try {
                    Class.forName("oracle.jdbc.driver.OracleDriver");
                    Connection c = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "system",
                            "manish");
                    Statement s = c.createStatement();
                    String sql = ("SELECT masterpasswd FROM admintor");
                    ResultSet rs = s.executeQuery(sql);
                    if (rs.next()) {
                        if ((rs.getString("masterpasswd")).equals(t1.getPassword())) {
                            JOptionPane.showMessageDialog(this, "Successfully Connected To Database.", "DTO-CHAPRA",
                                    JOptionPane.INFORMATION_MESSAGE);
                            new createtables();
                            dispose();
                        } else {
                            JOptionPane.showMessageDialog(this, "Not a Valid Password.", "Administrater",
                                    JOptionPane.INFORMATION_MESSAGE);
                            t1.setText("");
                            t1.requestFocus();
                        }
                    } else {
                        JOptionPane.showMessageDialog(this, "Not a Valid Password.", "Administrater",
                                JOptionPane.INFORMATION_MESSAGE);
                        t1.setText("");
                        t1.requestFocus();
                    }
                    c.close();
                } catch (Exception ec) {
                    JOptionPane.showMessageDialog(this, ec.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        }
        if (e.getSource() == b2) {
            dispose();
        }
    }

    public void keyPressed(KeyEvent e) {
        if (e.getKeyCode() == 10) {
            if (e.getSource() == b1) {
                if ((t1.getPassword()).equals("") || (t1.getPassword()).equals(null)) {
                    JOptionPane.showMessageDialog(this, "Please Enter Master Password.", "Administrator",
                            JOptionPane.ERROR_MESSAGE);
                    t1.requestFocus();
                } else {
                    b1.requestFocus();
                }
            } else if (e.getSource() == t1) {
                if ((t1.getPassword()).equals("") || (t1.getPassword()).equals(null)) {
                    JOptionPane.showMessageDialog(this, "Please Enter Master Password.", "Administrator",
                            JOptionPane.ERROR_MESSAGE);
                    t1.requestFocus();
                } else {
                    b1.requestFocus();
                }
            } else if (e.getSource() == b2) {
                dispose();
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

    class Animation extends JLabel {
        private static final long serialVersionUID = 1L;

        public void paintComponent(Graphics g) {
            g.setColor(color0);
            g.fillRect(0, 0, getWidth(), getHeight());
        }
    }

    public static void main(String c[]) {
        new admin();
    }
}