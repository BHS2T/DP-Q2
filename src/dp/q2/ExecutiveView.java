package dp.q2;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import javax.swing.*;

public class ExecutiveView extends JFrame implements ViewAPI, ActionListener {

    private JFrame jFrame;
    private JLabel executiveLbl;
    private JTable table;
    private JScrollPane jScrollPane;
    private JButton sortBtn,backBtn;
    FrontController frontController;
    Object[][] productData;

    @Override
    public void DisplayProduct(List<Product> list) {
        productData = new Object[list.size()][2];
        System.out.println(list.get(0).name);
        System.out.println(list.size());
        int i, j = 0;

        for (i = 0; i < productData.length; i++) {
            productData[i][j] = list.get(i).name;
            productData[i][j+1] = list.get(i).quantityShipped;

        }
        jFrame = new JFrame();
        String[] columns = new String[]{"Products", "Quantity Shipped"};

        jFrame.setTitle("Executive View");
        jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//        jFrame.pack();

        //Label
        executiveLbl = new JLabel();
        executiveLbl.setText("Executive View");
        executiveLbl.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        executiveLbl.setBounds(130, 2, 300, 40);
        jFrame.add(executiveLbl);

        //Table
        table = new JTable(productData, columns);
        table.setFont(new java.awt.Font("Tahoma", 0, 18));

        jScrollPane = new JScrollPane(table);
        jScrollPane.setBounds(50, 50, 350, 230);
        jFrame.add(jScrollPane);

        //Sort Button
        sortBtn = new JButton("Sort");
        sortBtn.setBounds(270, 300, 70, 40);
        jFrame.add(sortBtn);
        
        backBtn = new JButton("Back");
        backBtn.setBounds(0, 0, 70, 40);
        jFrame.add(backBtn);

        jFrame.setLayout(null);
        jFrame.setSize(500, 400);
        jFrame.setVisible(true);
        sortBtn.addActionListener(this);
        backBtn.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        frontController = new FrontController();
        jFrame.setVisible(false);
        if(ae.getSource() == sortBtn){
            frontController.dispatchRequest("executiveSorted");
        }
        if(ae.getSource() == backBtn){
            jFrame.setVisible(false);
            frontController.dispatchRequest("login");
        }
    }

}
