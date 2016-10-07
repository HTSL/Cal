/** 
* �� �� �� : �๦��Ӧ�ü�����__���
* �� �� С�飺HTSLС�飨��Ա��î����������������ͯ ��
* ��    �ڣ� 2016/9/20  ~  2016/10/7
* ��   ����  ���� �������ʵ���� ��С����ҵ��С���Ʒ���๦�ܼ��������Ĳ��ֹ���ʵ������ܡ�
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
    	
    	
    	  lblHeight = new JLabel("������ʱ��");   
          txtHeight = new JTextField(10);
       
          lblResult = new JLabel("����ʱ");
          txtResult = new JTextField(10);
          btnRun = new JButton("��ʼ");
          pnlMain = new JPanel();
          pnlMain.setLayout(null);            
          lblHeight.setBounds(100, 50, 80, 25);        //���ô����С
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
          setTitle("���");                                     //���ñ���
          setVisible(true);
          setResizable(true); 	
          this.setLocationRelativeTo(null);
          
          
          
          btnRun.addActionListener(new ActionListener() {       //�����¼�������

              public void actionPerformed(ActionEvent e) {            //��ʼ���Լ�����
                  
                     
                     double height = Double.valueOf(txtHeight.getText());
                     if(height <= 0 ){
                         JOptionPane.showMessageDialog(null, "�������");
                         return;
                     }
                     
          
              }
          });
          
    //����������󵹼�ʱ�����ݽ���ʾ�ڸô�������
   JFrame frame=new JFrame();
   frame.setSize(400,150);
   frame.setLocationRelativeTo(null);
   frame.setResizable(false);
   frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
   
    
   label1=new JLabel("",JLabel.CENTER);
   frame.setLayout(new BorderLayout());
   frame.add(label1,BorderLayout.CENTER);  //������ʱ��Ļ��ʾ�����м�
   
    
   
   frame.setVisible(false);
    
 
        /* * ���õ���ʱ��ʱ�䳤��
         * ����timer�����ٸ���timer��schedule�������������ڲ���
         * ��ʵ���߳�
         */
 
      btnRun.addActionListener(new ActionListener() {
    		public void actionPerformed(ActionEvent e) {
    			 Scanner input=new Scanner(txtHeight.getText());
    			 int i=input.nextInt();
    	    	   
    	         final long end=System.currentTimeMillis()+i*1000*60;
    	     Timer timer=new Timer();
    	     
    	     timer.schedule(new TimerTask() {  
    	     public void run() {                    //��ȡʣ��ĵ���ʱ��  
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
    
    public void updateTimer(long sub){   //��ʾ��HH��mm��ss���ĸ�ʽ��ˢ��ʣ���ʱ��
    	int h=(int)(sub/1000/60/60);
    	int m=(int)(sub/1000/60%60);
    	int s=(int)(sub/1000%60);
    	String str=h+":"+m+":"+s;
    
    	SimpleDateFormat sdf=new SimpleDateFormat("HH:mm:ss"); //��String����ת����Date���͵ĸ�ʽ
    	Date date=new Date();
    	Font font=new Font("Default", Font.PLAIN, 40);
    	label1.setFont(font);  try{
    		date=sdf.parse(str);
    	}catch(Exception e){
    	e.printStackTrace();
    	}
    	label1.setText(sdf.format(date)); //��Date���͵������ó���Ҫ��ʾ��ʱ���ʽ,��д��JLable��
    	
    	//System.out.println(sdf.format(date));//�����ӡ����
    
    	txtResult.setText(sdf.format(date));
    }
    
    public static void main(String[]args){
    	new CountDown(); 
    }

	
        
}
