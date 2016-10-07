/** 
* 文 件 名 : 多功能应用计算器__秒表
* 创 建 小组：HTSL小组（成员：卯生润，张新龙，侯天童 ）
* 日    期： 2016/9/20  ~  2016/10/7
* 描   述：  这是 软件工程实践课 的小组作业的小组产品【多功能计算器】的部分功能实现秒表功能。
*/ 
package mycalculator;

import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;
import java.util.Timer;
import java.util.TimerTask;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class CountDown extends JFrame {

	private static final long serialVersionUID = 1L;

		private JLabel label1;
	
		private JLabel lblHeight;
	 	  
	    private JLabel lblResult;

	    private JButton btnRun;
	    private JPanel pnlMain;
	    private JTextField txtHeight;
	    
	       
	    private JTextField txtResult;
	    DecimalFormat dformat = new DecimalFormat("#.00");
    
    public CountDown(){
    countDown();
    }
    
    public void countDown(){
    	
    	
    	  lblHeight = new JLabel("请输入时长");   
          txtHeight = new JTextField(10);
       
          lblResult = new JLabel("倒计时");
          txtResult = new JTextField(10);
          btnRun = new JButton("开始");
          pnlMain = new JPanel();
          pnlMain.setLayout(null);            
          lblHeight.setBounds(100, 50, 80, 25);        //设置窗体大小
          txtHeight.setBounds(200, 50, 150, 25);
         
          lblResult.setBounds(100, 170, 80, 25);
          txtResult.setBounds(200, 170, 150, 25);
          btnRun.setBounds(100, 110, 80, 25);

          pnlMain.add(lblHeight);
          pnlMain.add(txtHeight);
         
        
          pnlMain.add(lblResult);
          pnlMain.add(txtResult);
          pnlMain.add(btnRun);
          
          this.setContentPane(pnlMain);
          setSize(400,300);
          setTitle("秒表");                                     //设置标题
          setVisible(true);
          setResizable(true); 	
          this.setLocationRelativeTo(null);
          
          
          
          btnRun.addActionListener(new ActionListener() {       //设置事件监听器

              public void actionPerformed(ActionEvent e) {            //初始化以及报错
                  
                     
                     double height = Double.valueOf(txtHeight.getText());
                     if(height <= 0 ){
                         JOptionPane.showMessageDialog(null, "输入错误");
                         return;
                     }
                     
          
              }
          });
          
    //创建窗体对象倒计时的内容将显示在该窗体上面
   JFrame frame=new JFrame();
   frame.setSize(400,150);
   frame.setLocationRelativeTo(null);
   frame.setResizable(false);
   frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
   
    
   label1=new JLabel("",JLabel.CENTER);
   frame.setLayout(new BorderLayout());
   frame.add(label1,BorderLayout.CENTER);  //将倒计时字幕显示在正中间
   
    
   
   frame.setVisible(false);
    
 
        /* * 设置倒计时的时间长度
         * 创建timer对象，再根据timer的schedule方法创键匿名内部类
         * 并实现线程
         */
 
      btnRun.addActionListener(new ActionListener() {
    		public void actionPerformed(ActionEvent e) {
    			 Scanner input=new Scanner(txtHeight.getText());
    			 int i=input.nextInt();
    	    	   
    	         final long end=System.currentTimeMillis()+i*1000*60;
    	     Timer timer=new Timer();
    	     
    	     timer.schedule(new TimerTask() {  
    	     public void run() {                    //获取剩余的倒计时长  
    	 		long sub=end-System.currentTimeMillis();
    	 	if(sub<0){
    	 		    return;     }
    	 		  updateTimer(sub);
    	 		   }
    	    },0,1000 );
    	     input.close();
    		}
    		});
 
    }
    
    public void updateTimer(long sub){   //显示成HH：mm：ss样的格式，刷新剩余的时长
    	int h=(int)(sub/1000/60/60);
    	int m=(int)(sub/1000/60%60);
    	int s=(int)(sub/1000%60);
    	String str=h+":"+m+":"+s;
    
    	SimpleDateFormat sdf=new SimpleDateFormat("HH:mm:ss"); //将String类型转换成Date类型的格式
    	Date date=new Date();
    	Font font=new Font("Default", Font.PLAIN, 40);
    	label1.setFont(font);  try{
    		date=sdf.parse(str);
    	}catch(Exception e){
    	e.printStackTrace();
    	}
    	label1.setText(sdf.format(date)); //将Date类型的数设置成想要显示的时间格式,并写入JLable中
    	
    	//System.out.println(sdf.format(date));//将其打印出来
    
    	txtResult.setText(sdf.format(date));
    }
    
    public static void main(String[]args){
    	new CountDown(); 
    }

	
        
}
