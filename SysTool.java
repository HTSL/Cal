
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

import java.io.BufferedInputStream;  
import java.io.BufferedReader;  
import java.io.InputStreamReader;  

public class SysTool {
	
	JFrame frame = new JFrame("ϵͳ����");
	Dimension dsSize;//�Ǵ�������ã�����Ƕ������һ����������Բ�ʹ��
	Toolkit toolkit=Toolkit.getDefaultToolkit();
	JButton jButton1 = new JButton("��ͼ����"); //��ť
	JButton jButton2 = new JButton("¼��"); //��ť
	JButton jButton3 = new JButton("��ǩ"); //��ť
	JButton jButton4 = new JButton("������"); //��ť
	JButton jButton5 = new JButton("д�ְ�"); //��ť


	public SysTool() {
		
		//frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLayout(new GridLayout(0, 1, 1, 1));

		jButton1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ae) {	
			
		        Runtime run = Runtime.getRuntime();//�����뵱ǰ Java Ӧ�ó�����ص�����ʱ����  
		        try {  
		            Process p = run.exec("C:\\WINDOWS\\system32\\SnippingTool.exe");// ������һ��������ִ������  
		            BufferedInputStream in = new BufferedInputStream(p.getInputStream());  
		            BufferedReader inBr = new BufferedReader(new InputStreamReader(in));  
		            String lineStr;  
		            while ((lineStr = inBr.readLine()) != null)  
		                //�������ִ�к��ڿ���̨�������Ϣ  
		                System.out.println(lineStr);// ��ӡ�����Ϣ  
		            //��������Ƿ�ִ��ʧ�ܡ�  
		            if (p.waitFor() != 0) {  
		                if (p.exitValue() == 1)//p.exitValue()==0��ʾ����������1������������  
		                    System.err.println("����ִ��ʧ��!");  
		            }  
		            inBr.close();  
		            in.close();  
		        } catch (Exception e) {  
		            e.printStackTrace();  
		        }  
		        
			}
		});
		
		jButton2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ae) {
			    Runtime run = Runtime.getRuntime();//�����뵱ǰ Java Ӧ�ó�����ص�����ʱ����  
		        try {  
		            Process p = run.exec("C:\\WINDOWS\\system32\\SoundRecorder.exe");// ������һ��������ִ������  
		            BufferedInputStream in = new BufferedInputStream(p.getInputStream());  
		            BufferedReader inBr = new BufferedReader(new InputStreamReader(in));  
		            String lineStr;  
		            while ((lineStr = inBr.readLine()) != null)  
		                //�������ִ�к��ڿ���̨�������Ϣ  
		                System.out.println(lineStr);// ��ӡ�����Ϣ  
		            //��������Ƿ�ִ��ʧ�ܡ�  
		            if (p.waitFor() != 0) {  
		                if (p.exitValue() == 1)//p.exitValue()==0��ʾ����������1������������  
		                    System.err.println("����ִ��ʧ��!");  
		            }  
		            inBr.close();  
		            in.close();  
		        } catch (Exception e) {  
		            e.printStackTrace();  
		        } 
			}
		});
		
		jButton3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ae) {
			    Runtime run = Runtime.getRuntime();//�����뵱ǰ Java Ӧ�ó�����ص�����ʱ����  
		        try {  
		            Process p = run.exec("C:\\WINDOWS\\system32\\StikyNot.exe");// ������һ��������ִ������  
		            BufferedInputStream in = new BufferedInputStream(p.getInputStream());  
		            BufferedReader inBr = new BufferedReader(new InputStreamReader(in));  
		            String lineStr;  
		            while ((lineStr = inBr.readLine()) != null)  
		                //�������ִ�к��ڿ���̨�������Ϣ  
		                System.out.println(lineStr);// ��ӡ�����Ϣ  
		            //��������Ƿ�ִ��ʧ�ܡ�  
		            if (p.waitFor() != 0) {  
		                if (p.exitValue() == 1)//p.exitValue()==0��ʾ����������1������������  
		                    System.err.println("����ִ��ʧ��!");  
		            }  
		            inBr.close();  
		            in.close();  
		        } catch (Exception e) {  
		            e.printStackTrace();  
		        } 
			}
		});
		
		jButton4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ae) {
			    Runtime run = Runtime.getRuntime();//�����뵱ǰ Java Ӧ�ó�����ص�����ʱ����  
		        try {  
		            Process p = run.exec("C:\\WINDOWS\\system32\\calc.exe");// ������һ��������ִ������  
		            BufferedInputStream in = new BufferedInputStream(p.getInputStream());  
		            BufferedReader inBr = new BufferedReader(new InputStreamReader(in));  
		            String lineStr;  
		            while ((lineStr = inBr.readLine()) != null)  
		                //�������ִ�к��ڿ���̨�������Ϣ  
		                System.out.println(lineStr);// ��ӡ�����Ϣ  
		            //��������Ƿ�ִ��ʧ�ܡ�  
		            if (p.waitFor() != 0) {  
		                if (p.exitValue() == 1)//p.exitValue()==0��ʾ����������1������������  
		                    System.err.println("����ִ��ʧ��!");  
		            }  
		            inBr.close();  
		            in.close();  
		        } catch (Exception e) {  
		            e.printStackTrace();  
		        } 
			}
		});
		
		jButton5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ae) {
			    Runtime run = Runtime.getRuntime();//�����뵱ǰ Java Ӧ�ó�����ص�����ʱ����  
		        try {  
		            Process p = run.exec("C:\\Program Files\\Windows NT\\Accessories\\wordpad.exe");// ������һ��������ִ������  
		            BufferedInputStream in = new BufferedInputStream(p.getInputStream());  
		            BufferedReader inBr = new BufferedReader(new InputStreamReader(in));  
		            String lineStr;  
		            while ((lineStr = inBr.readLine()) != null)  
		                //�������ִ�к��ڿ���̨�������Ϣ  
		                System.out.println(lineStr);// ��ӡ�����Ϣ  
		            //��������Ƿ�ִ��ʧ�ܡ�  
		            if (p.waitFor() != 0) {  
		                if (p.exitValue() == 1)//p.exitValue()==0��ʾ����������1������������  
		                    System.err.println("����ִ��ʧ��!");  
		            }  
		            inBr.close();  
		            in.close();  
		        } catch (Exception e) {  
		            e.printStackTrace();  
		        } 
			}
		});
	
			 
		frame.getContentPane().add(jButton1);
		frame.getContentPane().add(jButton2);
		frame.getContentPane().add(jButton3);
		frame.getContentPane().add(jButton4);
		frame.getContentPane().add(jButton5);

		frame.setBounds(380, 220, 500, 500);

	}
	@SuppressWarnings("deprecation")
	public void show() {
		frame.show();
	}
	public static void main(String[] args) {
		SysTool tb = new SysTool();
		tb.show();
	
	}
}
