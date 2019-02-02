package dp.q2;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

public class Login extends JFrame implements ActionListener{

    private JFrame jFrame;
    private JLabel loginLbl;
    private JButton execBtn, customerBtn;
    FrontController frontController = new FrontController();

    public void Display() {

        jFrame = new JFrame();
        jFrame.setTitle("Login");
        jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        //Label
        loginLbl = new JLabel();
        loginLbl.setText("Login as: ");
        loginLbl.setFont(new java.awt.Font("Tahoma", 1, 30)); // NOI18N
        loginLbl.setBounds(170, 60, 300, 40);
        jFrame.add(loginLbl);

        //executive Button
        execBtn = new JButton("Executive");
        execBtn.setBounds(260, 149, 125, 40);
        execBtn.setFont(new java.awt.Font("Tahoma",1,16));
        execBtn.addActionListener(this);
        jFrame.add(execBtn);

        //client button
        customerBtn = new JButton("Client");
        customerBtn.setBounds(100, 149, 125, 40);
        customerBtn.setFont(new java.awt.Font("Tahoma",1,16));
        customerBtn.addActionListener(this);
        jFrame.add(customerBtn);
        
        jFrame.setLayout(null);
        jFrame.setSize(500, 400);
        jFrame.setVisible(true);

    }
    
    @Override
    public void actionPerformed(ActionEvent e){
        if(e.getSource() == customerBtn){
            jFrame.setVisible(false);
            frontController.dispatchRequest("customer");
            
        }
        if(e.getSource()== execBtn){
            jFrame.setVisible(false);
            frontController.dispatchRequest("executive");
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                Login et = new Login();
                et.Display();

            }
        });
    }
}
