/** 
* �� �� �� : �๦��Ӧ�ü�����
* �� �� С�飺HTSLС�飨��Ա��î����������������ͯ ��
* ��    �ڣ� 2016/9/20  ~  2016/10/7
* ��   ����  ���� �������ʵ���� ��С����ҵ��С���Ʒ��Ŀ����ʵ�ֳ��������������������ʮ������ܣ�
*		 ������ѧ�������Ĳ��ֹ��ܣ��Լ���BMI���㡿������Ҵ�Сдת������������ѯ������ʱ����
*		������������ڼ��㡿�������ܡ�
*/ 		
package mycalculator;

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
JButton jButton5 = new JButton("��ʱ��&���"); //��ť
JButton jButton6 = new JButton("�����ڼ���");

public menu() {
	
	frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	frame.setLayout(new GridLayout(6, 2, 1, 1));

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
		 
	frame.getContentPane().add(jButton1);
	frame.getContentPane().add(jButton2);
	frame.getContentPane().add(jButton3);
	frame.getContentPane().add(jButton4);
	frame.getContentPane().add(jButton5);
	frame.getContentPane().add(jButton6);

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