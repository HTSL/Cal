/** 
* 文 件 名 : 多功能应用计算器
* 创 建 小组：HTSL小组（成员：卯生润，张新龙，侯天童 ）
* 日    期： 2016/9/20  ~  2016/10/7
* 描   述：  这是 软件工程实践课 的小组作业的小组产品，目的是实现除计算器基本功能以外的十五个功能，
*		 包括科学计算器的部分功能，以及【BMI计算】【人民币大小写转换】【日历查询】【计时器】
*		【秒表】【生理期计算】六个功能。
*/ 		
package mycalculator;

import javax.swing.*;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.Toolkit;
import java.awt.event.*;

public class menu {
	
JFrame frame = new JFrame("多功能计算器");
Dimension dsSize;//是窗体的设置，可以嵌套在另一个框体里，可以不使用
Toolkit toolkit=Toolkit.getDefaultToolkit();
JButton jButton1 = new JButton("BMI计算"); //按钮
JButton jButton2 = new JButton("科学计算器"); //按钮
JButton jButton3 = new JButton("人民币大小写转换"); //按钮
JButton jButton4 = new JButton("日历"); //按钮
JButton jButton5 = new JButton("计时器&秒表"); //按钮
JButton jButton6 = new JButton("生理期计算");

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