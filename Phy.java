/** 
* 文 件 名 : 多功能应用计算器__生理期计算
* 创 建 小组：HTSL小组（成员：卯生润，张新龙，侯天童 ）
* 日    期： 2016/9/20  ~  2016/10/7
* 描   述：  这是 软件工程实践课 的小组作业的小组产品【多功能计算器】的部分功能实现生理期计算功能。
*/ 
package mycalculator;

import java.awt.*;
import java.awt.event.*;
import java.text.DecimalFormat;
import javax.swing.*;

public class Phy {    //主类
class PhysiologicalperiodFrame extends Frame implements ActionListener {

 private static final long serialVersionUID = 1L;

 TextField text1, text2, text3, text4, text5, text6, text7, text8; //定义输入
 Button  Enter; //查询
 Label lab1, lab2, lab3, lab4, lab5, lab6, lab7, lab8, lab9, lab10; //几个文本类型的字符串
 int year = 2016, month = 9, day = 20, pjyjq=28, pjxjq=5; //初始化
 DecimalFormat dformat = new DecimalFormat("#.00");
 
 public PhysiologicalperiodFrame() {    //类方法  构建Frame
   
  lab1 = new Label("上次月经时间");  //调用一个方法    new一个对象 
  lab2 = new Label("年");
  lab3 = new Label("月");
  lab4 = new Label("日");
  lab5 = new Label("平均月经周期（天）");
  lab6 = new Label("平均行经周期（天）");
  lab7 = new Label("月经期");
  lab8 = new Label("安全期");
  lab9 = new Label("危险期");
  Enter = new Button("查询");
  text1 = new TextField();
  text2 = new TextField();
  text3 = new TextField();
  text4 = new TextField();
  text5 = new TextField();
  text6 = new TextField();
  text7 = new TextField();
  text8 = new TextField();
  
  Panel pNorth = new Panel();//定义panel
  pNorth.setLayout(null);  
  pNorth.setBounds(0,0,300,900);
  
  lab1.setBounds(170,15,100,20);//设置控件位置
  lab2.setBounds(380,15,20,20);
  lab3.setBounds(460,15,20,20);
  lab4.setBounds(540,15,20,20); 
  lab5.setBounds(170,50,120,20);
  lab6.setBounds(400,50,120,20);
  lab7.setBounds(10,130,50,20);
  lab8.setBounds(10,160,50,20);
  lab9.setBounds(10,190,50,20);
  Enter.setBounds(260,80,300,40);
  text1.setBounds(300,15,80,20);
  text2.setBounds(420,15,40,20);
  text3.setBounds(500,15,40,20);
  text4.setBounds(300,50,80,20);
  text5.setBounds(530,50,80,20);
  text6.setBounds(60,130,810,20);
  text7.setBounds(60,160,810,20);
  text8.setBounds(60,190,810,20);

  Enter.addActionListener(this);  //添加指定的动作侦听器

  pNorth.add(lab1);//添加控件
  pNorth.add(text1);
  pNorth.add(lab2);
  pNorth.add(text2);
  pNorth.add(lab3);
  pNorth.add(text3);
  pNorth.add(lab4);
  pNorth.add(lab5);
  pNorth.add(text4);
  pNorth.add(lab6);
  pNorth.add(text5);
  pNorth.add(Enter);
  pNorth.add(lab7);
  pNorth.add(text6);
  pNorth.add(lab8);
  pNorth.add(text7);
  pNorth.add(lab9);
  pNorth.add(text8);
  add(pNorth);
 }
 
 public void actionPerformed(ActionEvent e) {
  if (e.getSource() == Enter) { //点击查询
   String yea = text1.getText();
   String mon = text2.getText();
   String da  = text3.getText();
   String pjyj  = text4.getText();
   String pjxj = text5.getText();
   try {      //把string转成int类型 并检查是否报错
    year = Integer.parseInt(yea); 
    month = Integer.parseInt(mon);
    day = Integer.parseInt(da);
    /*
     * 检查时间是否正确代码
     * */
    int[] DAY = new int[12]; 
    int[] DAY1 = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
    int[] DAY2 = {31, 29, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
    	  if (month == 2) {
    	   if (((year % 4 == 0) && (year % 100 != 0)) || (year % 400 == 0)) {
    	    System.arraycopy(DAY2, 0, DAY, 0, 12);
    	   } 
    	  }
    	  System.arraycopy(DAY1, 0, DAY, 0, 12);
    	  
    if (month > 12 || month < 1 || year < 1) {     //错误月份输入的处理
     JOptionPane.showMessageDialog(null, "请输入正确的日期"); 
     return;
    } 
  
    if(day<1 || day>DAY[month-1]){ //错误日期输入的处理
    	JOptionPane.showMessageDialog(null,"请输入正确的日期");
    }
    
   } catch (NumberFormatException ee) {    //输入日期对处理 主要为不是int的输入检测
    JOptionPane.showMessageDialog(null, "请输入正确的日期");
   }
   
   try{   //检查平均月经期和平均行经期是不是输入正确，以及输入的值超出正常的提示
	   pjyjq = Integer.parseInt(pjyj);
	   pjxjq =Integer.parseInt(pjxj);
	   
	   if(pjyjq<21 || pjyjq>35){  //月经周期正常范围为21~35天
		   JOptionPane.showMessageDialog(null, "您的月经周期不在正常范围内，建议您去妇科医院检查！");
	   }
	   if(pjxjq<3 || pjxjq>7){   //行经周期正常范围为3~7天  
		   JOptionPane.showMessageDialog(null, "您的行经周期不在正常范围内，建议您去妇科医院检查！");
	   }
	   
   }catch (NumberFormatException ee){  //检测输入是否为int
	   JOptionPane.showMessageDialog(null, "请输入正确的月经周期或行经周期");
   		} 
  	}
  text6.setText(yjq1(year, month, day)+" 和 "+yjq2(year, month, day));	//输出月经期
  text7.setText(aqq1(year, month, day)+" 和 "+aqq2(year, month, day));	//输出安全期
  text8.setText(plq1(year, month, day)+" 和 "+plq2(year, month, day));	//输出危险期
 }
 
 
public String yjq1 (int y, int m, int d) { //上次月经的日期输出
	 /*
     * 检查时间是否正确代码
     * */
	 int[] DAY = new int[12];
	    int[] DAY1 = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
	    int[] DAY2 = {31, 29, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
	    	  if (m == 2) {
	    	   if (((y % 4 == 0) && (y % 100 != 0)) || (y % 400 == 0)) {
	    	    System.arraycopy(DAY2, 0, DAY, 0, 12);
	    	   } 
	    	  }
	    	  System.arraycopy(DAY1, 0, DAY, 0, 12);
	    	  
	  if(d+pjxjq>DAY[m-1]){ //月经持续到下个月
	    	if(m+1>12){  //月经跨年
	    		return(y+"年"+m+"月"+d+"日"+"到"+(y+1)+"年"+"1月"+(pjxjq-DAY[m-1]+d-1)+"日");//跨年
	    	}
	    	else return(y+"年"+m+"月"+d+"日"+"到"+y+"年"+(m+1)+"月"+(pjxjq-DAY[m-1]+d-1)+"日");//跨月
	    }
	  else return(y+"年"+m+"月"+d+"日"+"到"+(y)+"年"+m+"月"+(pjxjq+d-1)+"日");//没有跨月
 }
public String yjq2(int y, int m, int d) {//下次月经的输出，主要是调用yjq1
	 /*
     * 检查时间是否正确代码
     * */
	 int[] DAY = new int[12];
	    int[] DAY1 = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
	    int[] DAY2 = {31, 29, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
	    	  if (m == 2) {
	    	   if (((y % 4 == 0) && (y % 100 != 0)) || (y % 400 == 0)) {
	    	    System.arraycopy(DAY2, 0, DAY, 0, 12);
	    	   } 
	    	  }
	    	  System.arraycopy(DAY1, 0, DAY, 0, 12);
	    	  
	 String Buff = ""; //储存yjq1的返回值
	 if(d+pjyjq>DAY[m-1]){  //判断是否跨年跨月
		 if(m+1>12){
			Buff = yjq1(y+1, 1, pjyjq+d-DAY[m-1]); 
		 }
		 else Buff = yjq1(y, m+1, pjyjq+d-DAY[m-1]);
	 }
	 else Buff = yjq1(y, m, pjyjq+d);
	 return Buff;
 }
 
public String aqq1 (int y, int m, int d) { 	//上次月经后的安全期
	 /*
     * 检查时间是否正确代码
     * */
	 int[] DAY = new int[12];
	    int[] DAY1 = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
	    int[] DAY2 = {31, 29, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
	    	  if (m == 2) {
	    	   if (((y % 4 == 0) && (y % 100 != 0)) || (y % 400 == 0)) {
	    	    System.arraycopy(DAY2, 0, DAY, 0, 12);
	    	   } 
	    	  }
	    	  System.arraycopy(DAY1, 0, DAY, 0, 12);
	   int i; //排卵期开始
	   int j;//排卵期结束
	   int tem = d+pjyjq-14; //排卵期距上次月经时间（天）
	   i = tem - 5;
	   j = tem + 4;
		  if(i	<= DAY[m-1] && j > DAY[m-1] ){ //判断安全期是否跨年 跨月  然后输出
		    	if(m+1>12){	    		
		    		return((y+1)+"年"+"1月"+(pjxjq-DAY[m-1]+d)+"日"+"到"+y+"年"+m+"月"+(i-1)+"日"+" 和 "
		    	+(y+1)+"年"+"1月"+(j-DAY[m-1]+1)+"日"+"到"+(y+1)+"年"+"1月"+(d+pjyjq-DAY[m-1])+"日");
		    	}
		    	else return(y+"年"+(m+1)+"月"+(pjxjq-DAY[m-1]+d)+"日"+"到"+y+"年"+m+"月"+(i-1)+"日"+" 和 "
		    	+y+"年"+(m)+"月"+(j-DAY[m-1]+1)+"日"+"到"+y+"年"+(m)+"月"+(d+pjyjq-DAY[m-1])+"日");
		    }
		  else if(i	> DAY[m-1]){
			  if(m+1>12){	    		
		    		return((y+1)+"年"+"1月"+(pjxjq-DAY[m-1]+d)+"日"+"到"+(y+1)+"年"+"1月"+(i-DAY[m-1]-1)+"日"+" 和 "
			  +(y+1)+"年"+"1月"+(j-DAY[m-1]+1)+"日"+"到"+(y+1)+"年"+"1月"+(d+pjyjq-DAY[m-1])+"日");
		    	}
		    	else return(y+"年"+(m+1)+"月"+(pjxjq-DAY[m-1]+d)+"日"+"到"+y+y+"年"+(m+1)+"月"+(i-DAY[m-1]-1)+"日"+" 和 "
		    	+y+"年"+(m)+"月"+(j-DAY[m-1]+1)+"日"+"到"+y+"年"+(m)+"月"+(d+pjyjq-DAY[m-1])+"日");
		  } 
		  else return((y)+"年"+m+"月"+(pjxjq+d)+"日"+"到"+y+"年"+m+"月"+(i-1)+"日"+" 和 "
		  +y+"年"+(m)+"月"+(j+1)+"日"+"到"+y+"年"+(m)+"月"+(d+pjyjq-1)+"日");

}
public String aqq2(int y, int m, int d) {//下次月经后的安全期，主要调用aqq1
	 /*
     * 检查时间是否正确代码
     * */
	 int[] DAY = new int[12];
	    int[] DAY1 = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
	    int[] DAY2 = {31, 29, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
	    	  if (m == 2) {
	    	   if (((y % 4 == 0) && (y % 100 != 0)) || (y % 400 == 0)) {
	    	    System.arraycopy(DAY2, 0, DAY, 0, 12);
	    	   } 
	    	  }
	    	  System.arraycopy(DAY1, 0, DAY, 0, 12);
	 String Buff = "";
	 if(d+pjyjq>DAY[m-1]){
		 if(m+1>12){
			Buff = aqq1(y+1, 1, pjyjq+d-DAY[m-1]);
		 }
		 else Buff = aqq1(y, m+1, pjyjq+d-DAY[m-1]);
	 }
	 else Buff = aqq1(y, m, pjyjq+d);
	 return Buff;
}

public String plq1 (int y, int m, int d) { 	//上次月经后的排卵期
	 /*
     * 检查时间是否正确代码
     * */
	 int[] DAY = new int[12];
	    int[] DAY1 = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
	    int[] DAY2 = {31, 29, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
	    	  if (m == 2) {
	    	   if (((y % 4 == 0) && (y % 100 != 0)) || (y % 400 == 0)) {
	    	    System.arraycopy(DAY2, 0, DAY, 0, 12);
	    	   } 
	    	  }
	    	  System.arraycopy(DAY1, 0, DAY, 0, 12);
	   int i; //排卵期开始
	   int j;//排卵期结束
	   int tem = d+pjyjq-14; //排卵期距上次月经时间（天）
	   i = tem - 5;
	   j = tem + 4;
	   if(i	<= DAY[m-1] && j > DAY[m-1] ){
	    	if(m+1>12){	    		
	    		return(y+"年"+m+"月"+i+"日"+"到"+(y+1)+"年"+"1月"+(j-DAY[m-1])+"日");
	    	}
	    	else return(y+"年"+m+"月"+i+"日"+"到"+y+"年"+(m+1)+"月"+(j-DAY[m-1])+"日");
	    }
	  else if(i	> DAY[m-1]){
		  if(m+1>12){	    		
	    		return((y+1)+"年"+"1月"+(i-DAY[m-1])+"日"+"到"+(y+1)+"年"+"1月"+(j-DAY[m-1])+"日");
	    	}
	    	else return(y+"年"+(m+1)+"月"+(i-DAY[m-1])+"日"+"到"+y+"年"+(m+1)+"月"+(j-DAY[m-1])+"日");
	  } 
	  else return(y+"年"+m+"月"+i+"日"+"到"+y+"年"+(m)+"月"+j+"日");

}
public String plq2(int y, int m, int d) {//下次月经后的排卵期，主要调用plq1
	 /*
     * 检查时间是否正确代码
     * */
	 int[] DAY = new int[12];
	    int[] DAY1 = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
	    int[] DAY2 = {31, 29, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
	    	  if (m == 2) {
	    	   if (((y % 4 == 0) && (y % 100 != 0)) || (y % 400 == 0)) {
	    	    System.arraycopy(DAY2, 0, DAY, 0, 12);
	    	   } 
	    	  }
	    	  System.arraycopy(DAY1, 0, DAY, 0, 12);
	 String Buff = "";
	 if(d+pjyjq>DAY[m-1]){
		 if(m+1>12){
			Buff = plq1(y+1, 1, pjyjq+d-DAY[m-1]);
		 }
		 else Buff = plq1(y, m+1, pjyjq+d-DAY[m-1]);
	 }
	 else Buff = plq1(y, m, pjyjq+d);
	 return Buff;
}

}
public  Phy() {//类函数

  PhysiologicalperiodFrame frame = new PhysiologicalperiodFrame();
  frame.setTitle("生理期计算");
  frame.setBounds(250,250,900,280);//大小
  frame.setVisible(true);  //显示窗口
  frame.validate(); //使生效
  frame.addWindowListener(new java.awt.event.WindowAdapter() {  //点击叉号关闭frame程序
   public void windowClosing(java.awt.event.WindowEvent e) {
	   frame.dispose(); 
   }
  });
 }

public static void main(String args[]) {//主函数
	new Phy();     
}
}