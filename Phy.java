/** 
* �� �� �� : �๦��Ӧ�ü�����__�����ڼ���
* �� �� С�飺HTSLС�飨��Ա��î����������������ͯ ��
* ��    �ڣ� 2016/9/20  ~  2016/10/7
* ��   ����  ���� �������ʵ���� ��С����ҵ��С���Ʒ���๦�ܼ��������Ĳ��ֹ���ʵ�������ڼ��㹦�ܡ�
*/ 
package mycalculator;

import java.awt.*;
import java.awt.event.*;
import java.text.DecimalFormat;
import javax.swing.*;

public class Phy {    //����
class PhysiologicalperiodFrame extends Frame implements ActionListener {

 private static final long serialVersionUID = 1L;

 TextField text1, text2, text3, text4, text5, text6, text7, text8; //��������
 Button  Enter; //��ѯ
 Label lab1, lab2, lab3, lab4, lab5, lab6, lab7, lab8, lab9, lab10; //�����ı����͵��ַ���
 int year = 2016, month = 9, day = 20, pjyjq=28, pjxjq=5; //��ʼ��
 DecimalFormat dformat = new DecimalFormat("#.00");
 
 public PhysiologicalperiodFrame() {    //�෽��  ����Frame
   
  lab1 = new Label("�ϴ��¾�ʱ��");  //����һ������    newһ������ 
  lab2 = new Label("��");
  lab3 = new Label("��");
  lab4 = new Label("��");
  lab5 = new Label("ƽ���¾����ڣ��죩");
  lab6 = new Label("ƽ���о����ڣ��죩");
  lab7 = new Label("�¾���");
  lab8 = new Label("��ȫ��");
  lab9 = new Label("Σ����");
  Enter = new Button("��ѯ");
  text1 = new TextField();
  text2 = new TextField();
  text3 = new TextField();
  text4 = new TextField();
  text5 = new TextField();
  text6 = new TextField();
  text7 = new TextField();
  text8 = new TextField();
  
  Panel pNorth = new Panel();//����panel
  pNorth.setLayout(null);  
  pNorth.setBounds(0,0,300,900);
  
  lab1.setBounds(170,15,100,20);//���ÿؼ�λ��
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

  Enter.addActionListener(this);  //���ָ���Ķ���������

  pNorth.add(lab1);//��ӿؼ�
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
  if (e.getSource() == Enter) { //�����ѯ
   String yea = text1.getText();
   String mon = text2.getText();
   String da  = text3.getText();
   String pjyj  = text4.getText();
   String pjxj = text5.getText();
   try {      //��stringת��int���� ������Ƿ񱨴�
    year = Integer.parseInt(yea); 
    month = Integer.parseInt(mon);
    day = Integer.parseInt(da);
    /*
     * ���ʱ���Ƿ���ȷ����
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
    	  
    if (month > 12 || month < 1 || year < 1) {     //�����·�����Ĵ���
     JOptionPane.showMessageDialog(null, "��������ȷ������"); 
     return;
    } 
  
    if(day<1 || day>DAY[month-1]){ //������������Ĵ���
    	JOptionPane.showMessageDialog(null,"��������ȷ������");
    }
    
   } catch (NumberFormatException ee) {    //�������ڶԴ��� ��ҪΪ����int��������
    JOptionPane.showMessageDialog(null, "��������ȷ������");
   }
   
   try{   //���ƽ���¾��ں�ƽ���о����ǲ���������ȷ���Լ������ֵ������������ʾ
	   pjyjq = Integer.parseInt(pjyj);
	   pjxjq =Integer.parseInt(pjxj);
	   
	   if(pjyjq<21 || pjyjq>35){  //�¾�����������ΧΪ21~35��
		   JOptionPane.showMessageDialog(null, "�����¾����ڲ���������Χ�ڣ�������ȥ����ҽԺ��飡");
	   }
	   if(pjxjq<3 || pjxjq>7){   //�о�����������ΧΪ3~7��  
		   JOptionPane.showMessageDialog(null, "�����о����ڲ���������Χ�ڣ�������ȥ����ҽԺ��飡");
	   }
	   
   }catch (NumberFormatException ee){  //��������Ƿ�Ϊint
	   JOptionPane.showMessageDialog(null, "��������ȷ���¾����ڻ��о�����");
   		} 
  	}
  text6.setText(yjq1(year, month, day)+" �� "+yjq2(year, month, day));	//����¾���
  text7.setText(aqq1(year, month, day)+" �� "+aqq2(year, month, day));	//�����ȫ��
  text8.setText(plq1(year, month, day)+" �� "+plq2(year, month, day));	//���Σ����
 }
 
 
public String yjq1 (int y, int m, int d) { //�ϴ��¾����������
	 /*
     * ���ʱ���Ƿ���ȷ����
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
	    	  
	  if(d+pjxjq>DAY[m-1]){ //�¾��������¸���
	    	if(m+1>12){  //�¾�����
	    		return(y+"��"+m+"��"+d+"��"+"��"+(y+1)+"��"+"1��"+(pjxjq-DAY[m-1]+d-1)+"��");//����
	    	}
	    	else return(y+"��"+m+"��"+d+"��"+"��"+y+"��"+(m+1)+"��"+(pjxjq-DAY[m-1]+d-1)+"��");//����
	    }
	  else return(y+"��"+m+"��"+d+"��"+"��"+(y)+"��"+m+"��"+(pjxjq+d-1)+"��");//û�п���
 }
public String yjq2(int y, int m, int d) {//�´��¾����������Ҫ�ǵ���yjq1
	 /*
     * ���ʱ���Ƿ���ȷ����
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
	    	  
	 String Buff = ""; //����yjq1�ķ���ֵ
	 if(d+pjyjq>DAY[m-1]){  //�ж��Ƿ�������
		 if(m+1>12){
			Buff = yjq1(y+1, 1, pjyjq+d-DAY[m-1]); 
		 }
		 else Buff = yjq1(y, m+1, pjyjq+d-DAY[m-1]);
	 }
	 else Buff = yjq1(y, m, pjyjq+d);
	 return Buff;
 }
 
public String aqq1 (int y, int m, int d) { 	//�ϴ��¾���İ�ȫ��
	 /*
     * ���ʱ���Ƿ���ȷ����
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
	   int i; //�����ڿ�ʼ
	   int j;//�����ڽ���
	   int tem = d+pjyjq-14; //�����ھ��ϴ��¾�ʱ�䣨�죩
	   i = tem - 5;
	   j = tem + 4;
		  if(i	<= DAY[m-1] && j > DAY[m-1] ){ //�жϰ�ȫ���Ƿ���� ����  Ȼ�����
		    	if(m+1>12){	    		
		    		return((y+1)+"��"+"1��"+(pjxjq-DAY[m-1]+d)+"��"+"��"+y+"��"+m+"��"+(i-1)+"��"+" �� "
		    	+(y+1)+"��"+"1��"+(j-DAY[m-1]+1)+"��"+"��"+(y+1)+"��"+"1��"+(d+pjyjq-DAY[m-1])+"��");
		    	}
		    	else return(y+"��"+(m+1)+"��"+(pjxjq-DAY[m-1]+d)+"��"+"��"+y+"��"+m+"��"+(i-1)+"��"+" �� "
		    	+y+"��"+(m)+"��"+(j-DAY[m-1]+1)+"��"+"��"+y+"��"+(m)+"��"+(d+pjyjq-DAY[m-1])+"��");
		    }
		  else if(i	> DAY[m-1]){
			  if(m+1>12){	    		
		    		return((y+1)+"��"+"1��"+(pjxjq-DAY[m-1]+d)+"��"+"��"+(y+1)+"��"+"1��"+(i-DAY[m-1]-1)+"��"+" �� "
			  +(y+1)+"��"+"1��"+(j-DAY[m-1]+1)+"��"+"��"+(y+1)+"��"+"1��"+(d+pjyjq-DAY[m-1])+"��");
		    	}
		    	else return(y+"��"+(m+1)+"��"+(pjxjq-DAY[m-1]+d)+"��"+"��"+y+y+"��"+(m+1)+"��"+(i-DAY[m-1]-1)+"��"+" �� "
		    	+y+"��"+(m)+"��"+(j-DAY[m-1]+1)+"��"+"��"+y+"��"+(m)+"��"+(d+pjyjq-DAY[m-1])+"��");
		  } 
		  else return((y)+"��"+m+"��"+(pjxjq+d)+"��"+"��"+y+"��"+m+"��"+(i-1)+"��"+" �� "
		  +y+"��"+(m)+"��"+(j+1)+"��"+"��"+y+"��"+(m)+"��"+(d+pjyjq-1)+"��");

}
public String aqq2(int y, int m, int d) {//�´��¾���İ�ȫ�ڣ���Ҫ����aqq1
	 /*
     * ���ʱ���Ƿ���ȷ����
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

public String plq1 (int y, int m, int d) { 	//�ϴ��¾����������
	 /*
     * ���ʱ���Ƿ���ȷ����
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
	   int i; //�����ڿ�ʼ
	   int j;//�����ڽ���
	   int tem = d+pjyjq-14; //�����ھ��ϴ��¾�ʱ�䣨�죩
	   i = tem - 5;
	   j = tem + 4;
	   if(i	<= DAY[m-1] && j > DAY[m-1] ){
	    	if(m+1>12){	    		
	    		return(y+"��"+m+"��"+i+"��"+"��"+(y+1)+"��"+"1��"+(j-DAY[m-1])+"��");
	    	}
	    	else return(y+"��"+m+"��"+i+"��"+"��"+y+"��"+(m+1)+"��"+(j-DAY[m-1])+"��");
	    }
	  else if(i	> DAY[m-1]){
		  if(m+1>12){	    		
	    		return((y+1)+"��"+"1��"+(i-DAY[m-1])+"��"+"��"+(y+1)+"��"+"1��"+(j-DAY[m-1])+"��");
	    	}
	    	else return(y+"��"+(m+1)+"��"+(i-DAY[m-1])+"��"+"��"+y+"��"+(m+1)+"��"+(j-DAY[m-1])+"��");
	  } 
	  else return(y+"��"+m+"��"+i+"��"+"��"+y+"��"+(m)+"��"+j+"��");

}
public String plq2(int y, int m, int d) {//�´��¾���������ڣ���Ҫ����plq1
	 /*
     * ���ʱ���Ƿ���ȷ����
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
public  Phy() {//�ຯ��

  PhysiologicalperiodFrame frame = new PhysiologicalperiodFrame();
  frame.setTitle("�����ڼ���");
  frame.setBounds(250,250,900,280);//��С
  frame.setVisible(true);  //��ʾ����
  frame.validate(); //ʹ��Ч
  frame.addWindowListener(new java.awt.event.WindowAdapter() {  //�����Źر�frame����
   public void windowClosing(java.awt.event.WindowEvent e) {
	   frame.dispose(); 
   }
  });
 }

public static void main(String args[]) {//������
	new Phy();     
}
}