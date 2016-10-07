/** 
* 文 件 名 : 多功能应用计算器__BMI计算
* 创 建 小组：HTSL小组（成员：卯生润，张新龙，侯天童 ）
* 日    期： 2016/9/20  ~  2016/10/7
* 描   述：  这是 软件工程实践课 的小组作业的小组产品【多功能计算器】的部分功能实现BMI计算功能。
*/ 
package mycalculator;

import java.awt.event.*;
import javax.swing.*;
import java.text.*;

public class bmi extends JFrame{       //  界面设计    
		
	private static final long serialVersionUID = 1L;
	

    private JLabel lblHeight;
    private JLabel lblWeight;
    private JLabel lblBMI;
    private JLabel lblResult;

    private JButton btnRun;
    private JPanel pnlMain;
    private JTextField txtHeight;
    private JTextField txtWeight;
    private JTextField txtBMI;
    private JTextField txtResult;
    DecimalFormat dformat = new DecimalFormat("#.00");
    
    public bmi(){  //方法构造窗体        
    	
        lblHeight = new JLabel("身高(米/m)");   
        txtHeight = new JTextField(10);
        lblWeight = new JLabel("体重(千克/kg)");
        txtWeight = new JTextField(10);
        lblBMI = new JLabel("健康值(BMI)");
        txtBMI = new JTextField(10);
        lblResult = new JLabel("查询结果");
        txtResult = new JTextField(10);
        btnRun = new JButton("评估");
        pnlMain = new JPanel();
        pnlMain.setLayout(null);   
        
        lblHeight.setBounds(100, 50, 80, 25);        //设置窗体大小
        txtHeight.setBounds(200, 50, 150, 25);
        lblWeight.setBounds(100, 80, 80, 25);
        txtWeight.setBounds(200, 80, 150, 25);
        lblBMI.setBounds(100, 140, 80, 25);
        txtBMI.setBounds(200, 140, 150, 25);
        lblResult.setBounds(100, 170, 80, 25);
        txtResult.setBounds(200, 170, 150, 25);
        btnRun.setBounds(100, 110, 80, 25);

        pnlMain.add(lblHeight); //添加控件
        pnlMain.add(txtHeight);
        pnlMain.add(lblWeight);
        pnlMain.add(txtWeight);
        pnlMain.add(lblBMI);
        pnlMain.add(txtBMI);
        pnlMain.add(lblResult);
        pnlMain.add(txtResult);
        pnlMain.add(btnRun);
        this.setContentPane(pnlMain);
        setSize(400,300);
        setTitle("健康评估");  //设置标题
        setVisible(true);
        setResizable(true);
   
        //this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);  （//注释后会退出子窗口，但不会退出父窗口)
        this.setLocationRelativeTo(null);

        btnRun.addActionListener(new ActionListener() {       //设置事件监听器

        	public void actionPerformed(ActionEvent e) {            //初始化以及报错
                if( txtWeight.getText() == null){
                    JOptionPane.showMessageDialog(null, "身高为空，请输入一个正值身高！");
                    return;
                }
                if( txtHeight.getText() == null){
                    JOptionPane.showMessageDialog(null, "体重为空，请输入一个正值体重！");
                    return; 
                }
                double weight = Double.valueOf(txtWeight.getText());
                if(weight <= 0 ){
                    JOptionPane.showMessageDialog(null, "体重输入有误，请重新输入！");
                    return;
                }
                double height = Double.valueOf(txtHeight.getText());
                if(height <= 0 ){
                    JOptionPane.showMessageDialog(null, "身高输入有误，请重新输入！");
                    return;
                }
                double bmi = weight/height/height;
                txtBMI.setText(dformat.format(bmi));  //返回BMI
                txtResult.setText(getResult(bmi));   //返回查询结果
            }

        });
    }
    
    private String getResult(double bmi) {           //分析BMI值大小
    
        if(bmi < 18.5){
            return "您有点偏瘦哦";
        }else if(bmi>=18.5 && bmi < 24){
            return "您的身材比列很完美哦";
        }else{
            return "您有点偏胖了哦";
        }
    }

    public static void main(String[] args) {  //主函数
        new bmi();
    }
}