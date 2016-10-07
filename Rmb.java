/** 
* 文 件 名 : 多功能应用计算器__人民币大小写转换
* 创 建 小组：HTSL小组（成员：卯生润，张新龙，侯天童 ）
* 日    期： 2016/9/20  ~  2016/10/7
* 描   述：  这是 软件工程实践课 的小组作业的小组产品   【多功能计算器】的部分功能实现人民币大小写转换功能。
*/ 
package mycalculator;

import java.awt.event.*;
import javax.swing.*;
import java.text.*;

public class Rmb extends JFrame
{

	private static final long serialVersionUID = 1L;
	
/*框架的内容*/
	private JLabel lblNum;
    private JTextField txtNum;
    private JButton btnRun;
    private JLabel lblChn;
    private JTextField txtChn;
    private JPanel pnlMain;
    DecimalFormat dformat = new DecimalFormat("#.00");
 
    /**
   *人民币的基本信息和操作
   */
    double number;     //人民币的数量
    private String[] hanArr = {"零", "壹", "贰", "叁", "肆", "伍", "陆", "柒", "捌", "玖" };//汉字计数符号
    private String[] unitArr = {"", "拾", "佰", "仟"};//汉字计数单位
    private String[] unitArrs = {"万", "亿", "万", "兆", "万", "亿", "万", "圆"}; //顺序添加单位
    //private String[] unitsArr = {"万", "亿"}; //汉字计数大单位

    public Rmb(double number){        //构造器初始化人民币数量
	  this.number = number;
  }
  /**
   *把一个浮点数分解成long型部分和小数部分字符串，把人民币换成了整数，浮点数在取小数部分时临界值有误差
   *返回分解后的字符串数组，第一个数组元素是整数部分，第二个是小数部分字符串
  */
  public String[] divideNum(){
    double num = Math.round(number*100);           //对number进行四舍五入取整
    long integerPart = (long)num;             //连同小数点后两位取成整数 ，避免使用减法
    //double decimalsPart = num-integerPart;//小数部分，临界时产生了误差
    String decimalsPartStr;                   //返回小数点第一位和第二位的字符串
    long b = integerPart % 10;          //小数点后第二位
    long a = (integerPart/10) % 10;          //小数点后第一位
    integerPart /= 100;               //去掉保留的两位小数
    if(a==0 && b==0){                //判断四舍五入后的第一位和第二位小数是否为零
      decimalsPartStr = null;  
    }else{
      decimalsPartStr = "" + a + b;
    }
    return new String[] {String.valueOf(integerPart) , decimalsPartStr};         //返回两位数组  前面为整数  后面为小数后两位
  }
  
  /**
   *把一个数字字符转换成汉语的人民币读法
   * 返回汉语人民币读法的字符串形式
  */
  public String toHanStr(){
    String[] results = new String[9];        //用来暂时存储每四位分段后的数字字符串
    String[] resultStrs = new String[9];          //用来暂时存储每四位分段后转换成的人民币读法
    String result = "";        //最终的转换结果 
    String[] divideStr = divideNum();     //得到浮点数分解成的long型部分和小数部分字符串，第一个数组元素是整数部分字符串，第二个是小数部分字符串
    results[8] = divideStr[1];  //把小数部分存到result[8]
    for (int i=divideStr[0].length(), j=8; i>0&&j>0 ; i-=4,j--){
      try{
        results[j-1] = divideStr[0].substring(i-4, i);   //小数点前每四位存为一个元素
      }catch(Exception e){
        results[j-1] = divideStr[0].substring(0, i);		//不足四位的部分也做一位元素
        break;
      }
    } 
    if(results[8] == null){  	//小数部分为0
      resultStrs[8] = "整";
    }else if(results[8].charAt(1) == '0'){
      resultStrs[8] = hanArr[results[8].charAt(0) - 48] + "角"; //根据ASCII码和hanArr数组吧数字改成汉语大写
    }else{
      resultStrs[8] = hanArr[results[8].charAt(0) - 48] + "角" + hanArr[results[8].charAt(1) - 48] + "分"; 
    }          //results[8].charAt[1]是字符串的第二个字符
    
    for(int i=0; i<8; i++){					//设置总的整数位数 7*4=28位
      if(results[i] != null){
        resultStrs[i] = "";         //当最高4位为空时，往下推
        resultStrs[i] += hanArr[results[i].charAt(0) - 48] + unitArr[results[i].length() - 1]; //根据ASCII码和数组长度选择数的单位
        for (int j=1; j<results[i].length(); j++ )
          if(results[i].charAt(j-1) == '0' && results[i].charAt(j) != '0')    //当四位中有高位为0   就读作多少零多少
            resultStrs[i] += "零" + hanArr[results[i].charAt(j) - 48] + unitArr[results[i].length() - 1 - j];  //根据ASCII码和数组长度选择数的单位
          else if(results[i].charAt(j) != '0' )
            resultStrs[i] += hanArr[results[i].charAt(j) - 48] + unitArr[results[i].length() - 1 - j];   //组合输出
      }
    }
    for (int i=0; i<8; i++ ){
      if(resultStrs[i] != null){
        result += resultStrs[i] + unitArrs[i];
      }
    }
    result += resultStrs[8];
    return result;
  }
  
  public  Rmb()
  {
	  /*初始化框架*/
		lblNum = new JLabel("阿拉伯数字");
		txtNum= new JTextField();
		btnRun = new JButton("转换");
		lblChn = new JLabel("汉字大写");
		txtChn= new JTextField();
		pnlMain = new JPanel();
		pnlMain.setLayout(null);
     
		lblNum.setBounds(100, 50 , 80, 25);  //设置label Button 的位置
		txtNum.setBounds(200, 50, 300, 25);
		lblChn.setBounds(100, 140, 80, 25);
		txtChn.setBounds(200, 140, 300, 25);
		btnRun.setBounds(100, 90, 80, 40);
      
      	 pnlMain.add(lblNum);
	     pnlMain.add(txtNum);
	  	 pnlMain.add(lblChn);
	     pnlMain.add(txtChn);
	     pnlMain.add(btnRun);
	     
	     this.setContentPane(pnlMain);
	        setSize(600,300);
	        setTitle("人民币大写转换");
	        setVisible(true);
	        setResizable(true);
	        //this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	        this.setLocationRelativeTo(null);
      
  	btnRun.addActionListener(new ActionListener() {  //Button 的事件响应   就是把阿拉伯数字转换为大写金额
		public void actionPerformed(ActionEvent ae) {
		if(txtNum.getText()!= null){
			double num = Double.valueOf(txtNum.getText());          //不为空时 读取金额
			  Rmb r =new Rmb(num);
			  txtChn.setText(r.toHanStr());				//转化并输入大写汉字
		}
		else{            //输入为空的报错
			JOptionPane.showMessageDialog(null, "输入为空，请输入正确金额！");
			return;
		}
	}
	});
 }
  
  public static void main(String[] args) {
   new Rmb();

  }
}

