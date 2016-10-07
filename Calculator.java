/** 
* 文 件 名 : 多功能应用计算器__科学计算器
* 创 建 小组：HTSL小组（成员：卯生润，张新龙，侯天童 ）
* 日    期： 2016/9/20  ~  2016/10/7
* 描   述：  这是 软件工程实践课 的小组作业的小组产品【多功能计算器】的部分功能实现科学计算器功能。
*/ 
package mycalculator;

import java.awt.*;

import java.awt.event.*;

import javax.swing.*;

import java.math.*;

import java.util.*;


public class Calculator {

  static JTextField show;//设置输入区，显示区

  static double opNum = 0;//存放操作数

  static String opChar = "=";//存放操作符

  static boolean flag = true;//设置标志

  public static void main(String[] args) {
     new AdvanceFrame();
  }

}


class AdvanceFrame 

{

  static JFrame frame;

  public AdvanceFrame()  //构建计算器框架界面
  {
    frame = new JFrame("科学计算器");

    JMenuBar mb = new JMenuBar();//创建菜单栏
 
    frame.setJMenuBar(mb);//添加菜单栏

    Container cp = frame.getContentPane();//获取框架的内容窗格

    cp.add(new AdvanceCalPanel());//添加高级计算面板

    frame.pack();//设置适当的大小

    frame.setVisible(true);//可见

    frame.addWindowListener(new WindowAdapter() {//响应关闭按钮

      public void windowClosing(WindowEvent e) {

    	  frame.dispose();
      }

    });
  }

}

class AdvanceCalPanel extends JPanel//创建高级计算面板

{

  /**
	 * 
	 */
  private static final long serialVersionUID = 1L;
public AdvanceCalPanel()  
    {
    setLayout(new BorderLayout());//设置布局方式

    Calculator.show = new JTextField("0",27);//显示文本区

    Calculator.show.setFont(new Font("Dialog",Font.PLAIN,16));//设置字体

    Calculator.show.setHorizontalAlignment(JTextField.RIGHT);//设置光标位置

    JPanel ps = new JPanel();//创建面板加载显示区文本框

    ps.add(Calculator.show);

    JPanel pbl = new  JPanel();//创建面板加载按钮

    pbl.setLayout(new GridLayout(7,4,1,1));//设置按钮面板的布局

    pbl.setBorder(BorderFactory.createEtchedBorder());//设置边框

    String[] larr ={//按钮

    	"n!",  "(",")","√",
    	
    	"x√","x^2","x^y","sin", 
    	
    	"cos","tan","ln","log",   

    	"7","8","9", "+",

    	"4","5","6", "-"
,
        "1","2","3", "*",
        "0", ".", "=","/",
                     
       };

     for(int i=0;i<larr.length;i++)

     {

       addButton(pbl,larr[i]);//创建按钮

     }

    setBorder(BorderFactory.createEtchedBorder());//设置边框

    add(pbl,BorderLayout.CENTER);//分别添加两面板到框架中

    add(ps,BorderLayout.NORTH);

  }

  private void addButton(Container c,String s)//创建按钮，加入到面板并监听按钮事件

  {

    JButton bt = new JButton(s);

    c.add(bt);

    bt.addActionListener(new buttonListener());

  }

}


class buttonListener implements ActionListener//响应按钮事件

{

  public void actionPerformed(ActionEvent e)

  {

    String s = e.getActionCommand();//获取命令

    if('0'<=s.charAt(0) && s.charAt(0)<='9' || s.equals("."))//该命令为正操作数

    {

      if(Calculator.flag)//若初次输入该操作数（如：输入“123”中的“1”）

        Calculator.show.setText(s);

      else//（如：输入“123”中的"2"或"3"）

        Calculator.show.setText(Calculator.show.getText()+s);

      Calculator.flag = false;//修改标志

    }

    else//命令为操作数为负数或操作符

    {

      if(Calculator.flag)//初次输入

      {

        if (s.equals("-")) {//为负数

          Calculator.show.setText(s);

          Calculator.flag = false;

        }

        else{//连续输入几个操作符

          Calculator.opChar = s; ///

        }

      }

      else   //为操作符

      {

        calculate cal = new calculate();//创建计算类实例

        double x = Double.parseDouble(Calculator.show.getText());//将输入的操作数转换为double型

        cal.calopr1(x);//双目运算及处理单目运算的操作数

        Calculator.opChar = s;//保存运算符

        if (Calculator.opChar.equals("!")||Calculator.opChar.equals("√")//操作数必须为正的单目运算

            ||Calculator.opChar.equals("n!"))

        {

          if(Calculator.opNum < 0)

            Calculator.show.setText("不能执行此操作！！");

          else

          cal.calopr2((int)Calculator.opNum,Calculator.opChar);//单目运算

          Calculator.opChar = "=";//保存符号为下一次运算做准备

        }

        else if (Calculator.opChar.equals("1/x")||Calculator.opChar.equals("x^2")

            ||Calculator.opChar.equals("ln")||Calculator.opChar.equals("log")

            ||Calculator.opChar.equals("sin")||Calculator.opChar.equals("cos")

            ||Calculator.opChar.equals("tan")||Calculator.opChar.equals("Exp"))//普通单目运算

        {

          cal.calopr2((int)Calculator.opNum,Calculator.opChar);//单目运算

          Calculator.opChar = "=";//保存符号为下一次运算做准备

        }

        Calculator.flag = true;//设置标志为下一次运算做准备

      }

    }

  }

}

 

class calculate//计算处理

{

  public void calopr1(double n)//处理双目运算及单目运算的操作数

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

        str = "除数为0！！！";

      else

        Calculator.opNum /= n;

    }

    else if (Calculator.opChar.equals("^")||Calculator.opChar.equals("x^y")) {

      Calculator.opNum = Math.pow(Calculator.opNum,n);

    }

    else if (Calculator.opChar.equals("x√")) {

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

  public void calopr2(int n,String opChar)//处理单目运算

  {

   if (opChar.equals("!")||opChar.equals("n!")) {

     new Factorial();
	Calculator.show.setText(

  Factorial.factorial((int)Calculator.opNum).toString());

   }

   else if (opChar.equals("√")) {

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

class Factorial//计算大数阶乘

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

