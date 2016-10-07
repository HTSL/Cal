/** 
* �� �� �� : �๦��Ӧ�ü�����__BMI����
* �� �� С�飺HTSLС�飨��Ա��î����������������ͯ ��
* ��    �ڣ� 2016/9/20  ~  2016/10/7
* ��   ����  ���� �������ʵ���� ��С����ҵ��С���Ʒ���๦�ܼ��������Ĳ��ֹ���ʵ��BMI���㹦�ܡ�
*/ 
package mycalculator;

import java.awt.event.*;
import javax.swing.*;
import java.text.*;

public class bmi extends JFrame{       //  �������    
		
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
    
    public bmi(){  //�������촰��        
    	
        lblHeight = new JLabel("���(��/m)");   
        txtHeight = new JTextField(10);
        lblWeight = new JLabel("����(ǧ��/kg)");
        txtWeight = new JTextField(10);
        lblBMI = new JLabel("����ֵ(BMI)");
        txtBMI = new JTextField(10);
        lblResult = new JLabel("��ѯ���");
        txtResult = new JTextField(10);
        btnRun = new JButton("����");
        pnlMain = new JPanel();
        pnlMain.setLayout(null);   
        
        lblHeight.setBounds(100, 50, 80, 25);        //���ô����С
        txtHeight.setBounds(200, 50, 150, 25);
        lblWeight.setBounds(100, 80, 80, 25);
        txtWeight.setBounds(200, 80, 150, 25);
        lblBMI.setBounds(100, 140, 80, 25);
        txtBMI.setBounds(200, 140, 150, 25);
        lblResult.setBounds(100, 170, 80, 25);
        txtResult.setBounds(200, 170, 150, 25);
        btnRun.setBounds(100, 110, 80, 25);

        pnlMain.add(lblHeight); //��ӿؼ�
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
        setTitle("��������");  //���ñ���
        setVisible(true);
        setResizable(true);
   
        //this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);  ��//ע�ͺ���˳��Ӵ��ڣ��������˳�������)
        this.setLocationRelativeTo(null);

        btnRun.addActionListener(new ActionListener() {       //�����¼�������

        	public void actionPerformed(ActionEvent e) {            //��ʼ���Լ�����
                if( txtWeight.getText() == null){
                    JOptionPane.showMessageDialog(null, "���Ϊ�գ�������һ����ֵ��ߣ�");
                    return;
                }
                if( txtHeight.getText() == null){
                    JOptionPane.showMessageDialog(null, "����Ϊ�գ�������һ����ֵ���أ�");
                    return; 
                }
                double weight = Double.valueOf(txtWeight.getText());
                if(weight <= 0 ){
                    JOptionPane.showMessageDialog(null, "���������������������룡");
                    return;
                }
                double height = Double.valueOf(txtHeight.getText());
                if(height <= 0 ){
                    JOptionPane.showMessageDialog(null, "��������������������룡");
                    return;
                }
                double bmi = weight/height/height;
                txtBMI.setText(dformat.format(bmi));  //����BMI
                txtResult.setText(getResult(bmi));   //���ز�ѯ���
            }

        });
    }
    
    private String getResult(double bmi) {           //����BMIֵ��С
    
        if(bmi < 18.5){
            return "���е�ƫ��Ŷ";
        }else if(bmi>=18.5 && bmi < 24){
            return "������ı��к�����Ŷ";
        }else{
            return "���е�ƫ����Ŷ";
        }
    }

    public static void main(String[] args) {  //������
        new bmi();
    }
}