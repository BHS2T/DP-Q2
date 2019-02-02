package dp.q2;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import javax.swing.*;

public class CustomerView extends JFrame implements ViewAPI, ActionListener {

    private JFrame jFrame;
    private List<Product> products;
    private JLabel executiveLbl, countLbl;
    private int soldQuantity;
    private JTable table;
    private JScrollPane jScrollPane;
    private JTextField jTextField;
    private JButton buyBtn, sortBtn,backBtn;
    int selectedIndex;
    Product selectedProduct;
    Object[][] productData;
    FrontController frontController;

    @Override
    public void DisplayProduct(List<Product> list) {
        productData = new Object[list.size()][2];
        System.out.println(list.get(0).name);
        System.out.println(list.size());
        int i, j = 0;

        for (i = 0; i < productData.length; i++) {
            productData[i][j] = list.get(i).name;
            productData[i][j + 1] = list.get(i).quantity;

        }
        jFrame = new JFrame();
        String[] columns = new String[]{"Products"};

        jFrame.setTitle("Customer View");
        jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//        jFrame.pack();

        //Label
        executiveLbl = new JLabel();
        executiveLbl.setText("Customer View");
        executiveLbl.setFont(new java.awt.Font("Tahoma", 1, 24));
        executiveLbl.setBounds(130, 2, 300, 40);
        jFrame.add(executiveLbl);
        countLbl = new JLabel();
        countLbl.setFont(new java.awt.Font("Tahoma", 0, 24));
//        countLbl.setBounds(50,355,300,40);
        countLbl.setBounds(50, 255, 340, 40);
        jFrame.add(countLbl);
        //Table
        table = new JTable(productData, columns);
        table.setFont(new java.awt.Font("Tahoma", 0, 18));

        jScrollPane = new JScrollPane(table);
        jScrollPane.setBounds(50, 50, 300, 200);
        jFrame.add(jScrollPane);

        //Sort Button
        sortBtn = new JButton("Sort");
        sortBtn.setBounds(390, 290, 70, 35);
        jFrame.add(sortBtn);
        
                
        backBtn = new JButton("Back");
        backBtn.setBounds(0, 0, 70, 40);
        jFrame.add(backBtn);

        //TextField
        jTextField = new JTextField();
        jTextField.setBounds(50, 295, 170, 30);
        jFrame.add(jTextField);

        //Buy Button
        buyBtn = new JButton("Buy");
        buyBtn.setBounds(260, 290, 70, 35);
        jFrame.add(buyBtn);

        jFrame.setLayout(null);
        jFrame.setSize(600, 400);
        jFrame.setVisible(true);
        buyBtn.addActionListener(this);
        sortBtn.addActionListener(this);
        backBtn.addActionListener(this);
        products = list;

    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        frontController = new FrontController();

        if (ae.getSource() == buyBtn) {
            try {
                String s;
                s = jTextField.getText();
                soldQuantity = soldQuantity + Integer.parseInt(s);
                selectedIndex = table.getSelectedRow();
                selectedProduct = products.get(selectedIndex);
                countLbl.setText("Sold Quantity: " + Integer.toString(soldQuantity));
                jTextField.setText("");
                if (soldQuantity > 20000) {
                    jFrame.setVisible(false);
                    frontController.dispatchRequest("customer2");
                }
            } catch (ArrayIndexOutOfBoundsException e) {
                countLbl.setText("Please Select a Product");
//         System.err.println(e);
            } catch (NumberFormatException e) {
                countLbl.setText("Please enter Quantity");
            }

        }
        if (ae.getSource() == sortBtn) {
            jFrame.setVisible(false);
            frontController.dispatchRequest("customerSorted");
        }
        if(ae.getSource() == backBtn){
            jFrame.setVisible(false);
            frontController.dispatchRequest("login");
        }
    }

}
