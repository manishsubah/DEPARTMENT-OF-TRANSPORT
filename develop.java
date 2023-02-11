import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

class develop extends JDialog implements ActionListener, KeyListener {
    JDialog dialog = new JDialog((Frame) null, "About Developer", true);
    JLabel l1, l2, l3, l4;
    JButton b1;
    JSeparator sep = new JSeparator(JSeparator.HORIZONTAL);

    develop() {
        dialog.setSize(650, 350);
        dialog.setResizable(false);
        dialog.setLocationRelativeTo(null);
        dialog.setLayout(null);
        try {
            UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel");
        } catch (Exception e) {
        }
        l1 = new JLabel("DISTRICT TRANSPORT OFFICE AUTOMATION SYSTEM");
        l1.setFont(new Font("Sans-Serif", Font.BOLD, 20));
        l2 = new JLabel("Developed by - Manish Ranjan");
        l2.setFont(new Font("Bookman Old Style", Font.PLAIN, 16));
        l3 = new JLabel("Email Id - manishranjan.soft@gmail.com");
        l3.setFont(new Font("Bookman Old Style", Font.PLAIN, 16));
        l4 = new JLabel("Copyright � 2022 MANISH RANJAN. All right reserved.");
        l4.setFont(new Font("Bookman Old Style", Font.PLAIN, 16));
        b1 = new JButton("Ok");

        l1.setBounds(55, 20, 700, 40);
        sep.setBounds(30, 80, 575, 10);
        l2.setBounds(40, 100, 400, 30);
        l3.setBounds(40, 150, 400, 30);
        l4.setBounds(40, 200, 500, 30);
        b1.setBounds(550, 280, 80, 30);

        dialog.add(l1);
        dialog.add(sep);
        dialog.add(l2);
        dialog.add(l3);
        dialog.add(l4);

        dialog.add(b1);

        b1.addActionListener(this);
        b1.addKeyListener(this);

        dialog.setVisible(true);

    }

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == b1) {
            dialog.dispose();
        }

    }

    public void keyPressed(KeyEvent e) {
        if (e.getKeyCode() == 10) {
            if (e.getSource() == b1) {
                dialog.dispose();
            }
        }
        if (e.getKeyCode() == 27) {
            dialog.dispose();
        }

    }

    public void keyTyped(KeyEvent e) {
    }

    public void keyReleased(KeyEvent e) {
    }

    public static void main(String c[]) {
        new develop();
    }
}