package mycalculator;

/** 
* �� �� �� : �๦��Ӧ�ü�����__BMI����
* �� �� С�飺HTSLС�飨��Ա��î����������������ͯ ��
* ��    �ڣ� 2016/9/20  ~  2016/10/7
* ��   ����  ���� �������ʵ���� ��С����ҵ��С���Ʒ���๦�ܼ��������Ĳ��ֹ���ʵ�ֳ���ϵͳ���ߵ��á�
*/

import javax.swing.*;


import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.Toolkit;
import java.awt.event.*;



public class menu {
	
JFrame frame = new JFrame("�๦�ܼ�����");
Dimension dsSize;//�Ǵ�������ã�����Ƕ������һ����������Բ�ʹ��
Toolkit toolkit=Toolkit.getDefaultToolkit();
JButton jButton1 = new JButton("BMI����"); //��ť
JButton jButton2 = new JButton("��ѧ������"); //��ť
JButton jButton3 = new JButton("����Ҵ�Сдת��"); //��ť
JButton jButton4 = new JButton("����"); //��ť
JButton jButton5 = new JButton("��ʱ��"); //��ť
JButton jButton6 = new JButton("�����ڼ���");
JButton jButton7 = new JButton("���"); //��ť
JButton jButton8 = new JButton("ϵͳ����");


public menu() {
	
	frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	frame.setLayout(new GridLayout(4, 0, 1, 1));

	jButton1.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent ae) {
			new bmi();
		}
	});
	
	jButton2.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent ae) {
			new AdvanceFrame();
		}
	});
	
	jButton3.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent ae) {
			new Rmb();
		}
	});
	
	jButton4.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent ae) {
			new CalendarMainClass();
		}
	});
	
	jButton5.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent ae) {
			new Timer();
		}
	});
	jButton6.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent ae) {
			new Phy(); 
		}
	});
	
	jButton7.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent ae) {
			new CountDown(); 
		}
	});
	
	jButton8.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent ae) {
			SysTool tb = new SysTool();
			tb.show();
		}
	});
	
	
	frame.getContentPane().add(jButton1);
	frame.getContentPane().add(jButton2);
	frame.getContentPane().add(jButton3);
	frame.getContentPane().add(jButton4);
	frame.getContentPane().add(jButton5);
	frame.getContentPane().add(jButton6);
	frame.getContentPane().add(jButton7);
	frame.getContentPane().add(jButton8);

	frame.setBounds(380, 220, 500, 500);

}
@SuppressWarnings("deprecation")
public void show() {
	frame.show();
}
public static void main(String[] args) {
	menu tb = new menu();
	tb.show();
}
}