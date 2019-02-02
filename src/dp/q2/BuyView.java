package dp.q2;

import java.awt.Choice;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import javax.swing.*;

public class BuyView extends JFrame implements ViewAPI, ActionListener {

    Choice choice;
    JFrame jFrame;
    JButton jButton;
    JLabel jLbl, jLblProduct,jLblQuantity;
    JTextField jTextField;
    int quantitySold;
    FrontController frontController;
    @Override
    public void DisplayProduct(List<Product> products) {
        int i;        
        jFrame = new JFrame();
        jFrame.setTitle("Buy View");
        jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        //Label
        jLbl = new JLabel();
        jLbl.setText("Buy Product");
        jLbl.setFont(new java.awt.Font("Tahoma", 1, 24));
        jLbl.setBounds(200, 30, 300, 40);
        
        jLblProduct = new JLabel();
        jLblProduct.setText("Product: ");
        jLblProduct.setFont(new java.awt.Font("Tahoma", 0, 24));
        jLblProduct.setBounds(70, 90, 100, 40);
        
        
        //Choice
        choice = new Choice();
        for (i = 0; i < products.size(); i++) {
            choice.add(products.get(i).name);
        }
        choice.setBounds(190, 100, 170, 150);
        choice.setFont(new java.awt.Font("Tahoma", 0, 18));
        
        jLblQuantity = new JLabel();
        jLblQuantity.setText("Quantity: ");
        jLblQuantity.setFont(new java.awt.Font("Tahoma", 0, 24));
        jLblQuantity.setBounds(70, 135, 120, 40);
        
        //TextField
        jTextField = new JTextField();
        jTextField.setBounds(190,140,170,30);
        

        jButton = new JButton("Buy");
        jButton.setBounds(230,200,90,40);
        jButton.setFont(new java.awt.Font("Tahoma",0,18));
        
        //Add
        jFrame.add(jLbl);
        jFrame.add(jLblProduct);
        jFrame.add(choice);
        jFrame.add(jLblQuantity);
        jFrame.add(jTextField);
        jFrame.add(jButton);

        jFrame.setLayout(null);
        jFrame.setSize(600, 400);
        jFrame.setVisible(true);
        jButton.addActionListener(this);
        choice.addItemListener(null);
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        frontController = new FrontController();
        if(ae.getSource() == jButton){
            String a = choice.getItem(choice.getSelectedIndex());
            System.out.println(a);
            String b = jTextField.getText();
            int c = Integer.parseInt(b);
            quantitySold = quantitySold+c;
            System.out.println(quantitySold);
            if(quantitySold >=1000){
                jFrame.setVisible(false);
                frontController.dispatchRequest("customer2");
            }
        }
    }

}
