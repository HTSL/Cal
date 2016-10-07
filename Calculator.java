/** 
* �� �� �� : �๦��Ӧ�ü�����__��ѧ������
* �� �� С�飺HTSLС�飨��Ա��î����������������ͯ ��
* ��    �ڣ� 2016/9/20  ~  2016/10/7
* ��   ����  ���� �������ʵ���� ��С����ҵ��С���Ʒ���๦�ܼ��������Ĳ��ֹ���ʵ�ֿ�ѧ���������ܡ�
*/ 
package mycalculator;

import java.awt.*;

import java.awt.event.*;

import javax.swing.*;

import java.math.*;

import java.util.*;


public class Calculator {

  static JTextField show;//��������������ʾ��

  static double opNum = 0;//��Ų�����

  static String opChar = "=";//��Ų�����

  static boolean flag = true;//���ñ�־

  public static void main(String[] args) {
     new AdvanceFrame();
  }

}


class AdvanceFrame 

{

  static JFrame frame;

  public AdvanceFrame()  //������������ܽ���
  {
    frame = new JFrame("��ѧ������");

    JMenuBar mb = new JMenuBar();//�����˵���
 
    frame.setJMenuBar(mb);//��Ӳ˵���

    Container cp = frame.getContentPane();//��ȡ��ܵ����ݴ���

    cp.add(new AdvanceCalPanel());//��Ӹ߼��������

    frame.pack();//�����ʵ��Ĵ�С

    frame.setVisible(true);//�ɼ�

    frame.addWindowListener(new WindowAdapter() {//��Ӧ�رհ�ť

      public void windowClosing(WindowEvent e) {

    	  frame.dispose();
      }

    });
  }

}

class AdvanceCalPanel extends JPanel//�����߼��������

{

  /**
	 * 
	 */
  private static final long serialVersionUID = 1L;
public AdvanceCalPanel()  
    {
    setLayout(new BorderLayout());//���ò��ַ�ʽ

    Calculator.show = new JTextField("0",27);//��ʾ�ı���

    Calculator.show.setFont(new Font("Dialog",Font.PLAIN,16));//��������

    Calculator.show.setHorizontalAlignment(JTextField.RIGHT);//���ù��λ��

    JPanel ps = new JPanel();//������������ʾ���ı���

    ps.add(Calculator.show);

    JPanel pbl = new  JPanel();//���������ذ�ť

    pbl.setLayout(new GridLayout(7,4,1,1));//���ð�ť���Ĳ���

    pbl.setBorder(BorderFactory.createEtchedBorder());//���ñ߿�

    String[] larr ={//��ť

    	"n!",  "(",")","��",
    	
    	"x��","x^2","x^y","sin", 
    	
    	"cos","tan","ln","log",   

    	"7","8","9", "+",

    	"4","5","6", "-"
,
        "1","2","3", "*",
        "0", ".", "=","/",
                     
       };

     for(int i=0;i<larr.length;i++)

     {

       addButton(pbl,larr[i]);//������ť

     }

    setBorder(BorderFactory.createEtchedBorder());//���ñ߿�

    add(pbl,BorderLayout.CENTER);//�ֱ��������嵽�����

    add(ps,BorderLayout.NORTH);

  }

  private void addButton(Container c,String s)//������ť�����뵽��岢������ť�¼�

  {

    JButton bt = new JButton(s);

    c.add(bt);

    bt.addActionListener(new buttonListener());

  }

}


class buttonListener implements ActionListener//��Ӧ��ť�¼�

{

  public void actionPerformed(ActionEvent e)

  {

    String s = e.getActionCommand();//��ȡ����

    if('0'<=s.charAt(0) && s.charAt(0)<='9' || s.equals("."))//������Ϊ��������

    {

      if(Calculator.flag)//����������ò��������磺���롰123���еġ�1����

        Calculator.show.setText(s);

      else//���磺���롰123���е�"2"��"3"��

        Calculator.show.setText(Calculator.show.getText()+s);

      Calculator.flag = false;//�޸ı�־

    }

    else//����Ϊ������Ϊ�����������

    {

      if(Calculator.flag)//��������

      {

        if (s.equals("-")) {//Ϊ����

          Calculator.show.setText(s);

          Calculator.flag = false;

        }

        else{//�������뼸��������

          Calculator.opChar = s; ///

        }

      }

      else   //Ϊ������

      {

        calculate cal = new calculate();//����������ʵ��

        double x = Double.parseDouble(Calculator.show.getText());//������Ĳ�����ת��Ϊdouble��

        cal.calopr1(x);//˫Ŀ���㼰����Ŀ����Ĳ�����

        Calculator.opChar = s;//���������

        if (Calculator.opChar.equals("!")||Calculator.opChar.equals("��")//����������Ϊ���ĵ�Ŀ����

            ||Calculator.opChar.equals("n!"))

        {

          if(Calculator.opNum < 0)

            Calculator.show.setText("����ִ�д˲�������");

          else

          cal.calopr2((int)Calculator.opNum,Calculator.opChar);//��Ŀ����

          Calculator.opChar = "=";//�������Ϊ��һ��������׼��

        }

        else if (Calculator.opChar.equals("1/x")||Calculator.opChar.equals("x^2")

            ||Calculator.opChar.equals("ln")||Calculator.opChar.equals("log")

            ||Calculator.opChar.equals("sin")||Calculator.opChar.equals("cos")

            ||Calculator.opChar.equals("tan")||Calculator.opChar.equals("Exp"))//��ͨ��Ŀ����

        {

          cal.calopr2((int)Calculator.opNum,Calculator.opChar);//��Ŀ����

          Calculator.opChar = "=";//�������Ϊ��һ��������׼��

        }

        Calculator.flag = true;//���ñ�־Ϊ��һ��������׼��

      }

    }

  }

}

 

class calculate//���㴦��

{

  public void calopr1(double n)//����˫Ŀ���㼰��Ŀ����Ĳ�����

  {

    String str  = "";

    if (Calculator.opChar.equals("+")) {

      Calculator.opNum += n;

    }

    else if (Calculator.opChar.equals("-")) {

      Calculator.opNum -= n;

    }

    else if (Calculator.opChar.equals("*")) {

      Calculator.opNum *= n;

    }

    else if (Calculator.opChar.equals("/")) {

      if(n == 0)

        str = "����Ϊ0������";

      else

        Calculator.opNum /= n;

    }

    else if (Calculator.opChar.equals("^")||Calculator.opChar.equals("x^y")) {

      Calculator.opNum = Math.pow(Calculator.opNum,n);

    }

    else if (Calculator.opChar.equals("x��")) {

      Calculator.opNum = Math.pow(n,1/Calculator.opNum);

    }

    else if (Calculator.opChar.equals("=")) {

      Calculator.opNum = n;

    }

    else if (Calculator.opChar.equals("Mod")) {

      Calculator.opNum = Math.abs(Math.IEEEremainder(Calculator.opNum,n));

    }

    Calculator.show.setText(str+Calculator.opNum);

  }

  public void calopr2(int n,String opChar)//����Ŀ����

  {

   if (opChar.equals("!")||opChar.equals("n!")) {

     new Factorial();
	Calculator.show.setText(

  Factorial.factorial((int)Calculator.opNum).toString());

   }

   else if (opChar.equals("��")) {

     Calculator.show.setText(""+Math.sqrt(n));

   }

   else if (opChar.equals("1/x")) {

     Calculator.show.setText(""+(1.0/n));

   }

   else if (opChar.equals("x^2")) {

     Calculator.show.setText(""+Math.pow(n, 2));

   }

   else if (opChar.equals("ln")) {

     Calculator.show.setText(""+Math.log(n));

   }

   else if (opChar.equals("log")) {

     Calculator.show.setText("" + Math.log10(n));

   }

   else if (opChar.equals("sin")) {

     Calculator.show.setText(""+Math.sin(Math.toRadians(n)));

   }

   else if (opChar.equals("cos")) {

     Calculator.show.setText(""+Math.cos(Math.toRadians(n)));

   }

   else if (opChar.equals("tan")) {

     Calculator.show.setText(""+Math.tan(Math.toRadians(n)));

   }

   else if (opChar.equals("e")) {

    Calculator.show.setText(""+Math.exp(n));

       }
    }
}

class Factorial//��������׳�

{
   protected static ArrayList<BigInteger> table=new ArrayList<BigInteger>();

   static

   {

      table.add(BigInteger.valueOf(1));

   }

   /** Creates a new instance of factorial */

   public static synchronized BigInteger factorial(int x)

   {

       if(x<0) throw new IllegalArgumentException("x must be non-negative.");

       for(int size=table.size();size<=x;size++)

       {

           BigInteger lastfact=(BigInteger)table.get(size-1);

           BigInteger nextfact=lastfact.multiply(BigInteger.valueOf(size));

           table.add(nextfact);

       }

       return (BigInteger) table.get(x);

   }

}

