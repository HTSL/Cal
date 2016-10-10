
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

import java.io.BufferedInputStream;  
import java.io.BufferedReader;  
import java.io.InputStreamReader;  

public class SysTool {
	
	JFrame frame = new JFrame("系统工具");
	Dimension dsSize;//是窗体的设置，可以嵌套在另一个框体里，可以不使用
	Toolkit toolkit=Toolkit.getDefaultToolkit();
	JButton jButton1 = new JButton("截图工具"); //按钮
	JButton jButton2 = new JButton("录音"); //按钮
	JButton jButton3 = new JButton("便签"); //按钮
	JButton jButton4 = new JButton("计算器"); //按钮
	JButton jButton5 = new JButton("写字板"); //按钮


	public SysTool() {
		
		//frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLayout(new GridLayout(0, 1, 1, 1));

		jButton1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ae) {	
			
		        Runtime run = Runtime.getRuntime();//返回与当前 Java 应用程序相关的运行时对象  
		        try {  
		            Process p = run.exec("C:\\WINDOWS\\system32\\SnippingTool.exe");// 启动另一个进程来执行命令  
		            BufferedInputStream in = new BufferedInputStream(p.getInputStream());  
		            BufferedReader inBr = new BufferedReader(new InputStreamReader(in));  
		            String lineStr;  
		            while ((lineStr = inBr.readLine()) != null)  
		                //获得命令执行后在控制台的输出信息  
		                System.out.println(lineStr);// 打印输出信息  
		            //检查命令是否执行失败。  
		            if (p.waitFor() != 0) {  
		                if (p.exitValue() == 1)//p.exitValue()==0表示正常结束，1：非正常结束  
		                    System.err.println("命令执行失败!");  
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
			    Runtime run = Runtime.getRuntime();//返回与当前 Java 应用程序相关的运行时对象  
		        try {  
		            Process p = run.exec("C:\\WINDOWS\\system32\\SoundRecorder.exe");// 启动另一个进程来执行命令  
		            BufferedInputStream in = new BufferedInputStream(p.getInputStream());  
		            BufferedReader inBr = new BufferedReader(new InputStreamReader(in));  
		            String lineStr;  
		            while ((lineStr = inBr.readLine()) != null)  
		                //获得命令执行后在控制台的输出信息  
		                System.out.println(lineStr);// 打印输出信息  
		            //检查命令是否执行失败。  
		            if (p.waitFor() != 0) {  
		                if (p.exitValue() == 1)//p.exitValue()==0表示正常结束，1：非正常结束  
		                    System.err.println("命令执行失败!");  
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
			    Runtime run = Runtime.getRuntime();//返回与当前 Java 应用程序相关的运行时对象  
		        try {  
		            Process p = run.exec("C:\\WINDOWS\\system32\\StikyNot.exe");// 启动另一个进程来执行命令  
		            BufferedInputStream in = new BufferedInputStream(p.getInputStream());  
		            BufferedReader inBr = new BufferedReader(new InputStreamReader(in));  
		            String lineStr;  
		            while ((lineStr = inBr.readLine()) != null)  
		                //获得命令执行后在控制台的输出信息  
		                System.out.println(lineStr);// 打印输出信息  
		            //检查命令是否执行失败。  
		            if (p.waitFor() != 0) {  
		                if (p.exitValue() == 1)//p.exitValue()==0表示正常结束，1：非正常结束  
		                    System.err.println("命令执行失败!");  
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
			    Runtime run = Runtime.getRuntime();//返回与当前 Java 应用程序相关的运行时对象  
		        try {  
		            Process p = run.exec("C:\\WINDOWS\\system32\\calc.exe");// 启动另一个进程来执行命令  
		            BufferedInputStream in = new BufferedInputStream(p.getInputStream());  
		            BufferedReader inBr = new BufferedReader(new InputStreamReader(in));  
		            String lineStr;  
		            while ((lineStr = inBr.readLine()) != null)  
		                //获得命令执行后在控制台的输出信息  
		                System.out.println(lineStr);// 打印输出信息  
		            //检查命令是否执行失败。  
		            if (p.waitFor() != 0) {  
		                if (p.exitValue() == 1)//p.exitValue()==0表示正常结束，1：非正常结束  
		                    System.err.println("命令执行失败!");  
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
			    Runtime run = Runtime.getRuntime();//返回与当前 Java 应用程序相关的运行时对象  
		        try {  
		            Process p = run.exec("C:\\Program Files\\Windows NT\\Accessories\\wordpad.exe");// 启动另一个进程来执行命令  
		            BufferedInputStream in = new BufferedInputStream(p.getInputStream());  
		            BufferedReader inBr = new BufferedReader(new InputStreamReader(in));  
		            String lineStr;  
		            while ((lineStr = inBr.readLine()) != null)  
		                //获得命令执行后在控制台的输出信息  
		                System.out.println(lineStr);// 打印输出信息  
		            //检查命令是否执行失败。  
		            if (p.waitFor() != 0) {  
		                if (p.exitValue() == 1)//p.exitValue()==0表示正常结束，1：非正常结束  
		                    System.err.println("命令执行失败!");  
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
