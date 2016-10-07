/** 
* 文 件 名 : 多功能应用计算器__计时器
* 创 建 小组：HTSL小组（成员：卯生润，张新龙，侯天童 ）
* 日    期： 2016/9/20  ~  2016/10/7
* 描   述：  这是 软件工程实践课 的小组作业的小组产品【多功能计算器】的部分功能实现计时器功能。
*/ 
package mycalculator;

import javax.swing.*;    
import java.awt.*;      
import java.awt.event.*;
import java.util.TimerTask;  

public class Timer extends JFrame {    
   private static final long serialVersionUID = 1L;  
   private static final String finaltime = "00:00:00 000";     // 计数线程  
    
   private CountingThread thread = new CountingThread();         // 记录程序开始时间    
   private long programStart = System.currentTimeMillis();  // 程序一开始就是暂停的       
   private long pauseStart = programStart;    // 程序暂停的总时间        
   
   private long pauseCount = 0;    
   private JLabel label = new JLabel(finaltime);    
   
   private JButton startPauseButton = new JButton("开始");    
   private JButton resetButton = new JButton("清零");    
     
   private ActionListener startPauseButtonListener = new ActionListener() {  //添加“开始暂停”按钮监视器  
        public void actionPerformed(ActionEvent e) {    
            if (thread.stopped) {    
                pauseCount += (System.currentTimeMillis() - pauseStart);    
                thread.stopped = false;    
                startPauseButton.setText("暂停");    
            } else {    
                pauseStart = System.currentTimeMillis();    
                thread.stopped = true;    
                startPauseButton.setText("继续");    
            }    
        }    
    };    
   
    private ActionListener resetButtonListener = new ActionListener() {    //添加清零监视器
        public void actionPerformed(ActionEvent e) {    
            pauseStart = programStart;    
            pauseCount = 0;    
            thread.stopped = true;    
            label.setText(finaltime);    
            startPauseButton.setText("开始");    
        }    
    };    
     
    public Timer(String title) throws HeadlessException {    //界面设计
        super(title);    
       // setDefaultCloseOperation(EXIT_ON_CLOSE);    
        setLocation(300, 300);    
        setResizable(false);    
        
        JPanel contentPane = new JPanel(new BorderLayout());    // 为窗体面板添加边框      
        contentPane.setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));    
        this.setContentPane(contentPane);   
         
        JPanel panel = new JPanel(new FlowLayout());    // 配置按钮       
        panel.add(startPauseButton);    
        panel.add(resetButton);    
        add(panel, BorderLayout.SOUTH); 
        
        label.setHorizontalAlignment(SwingConstants.CENTER);    // 配置标签    
        label.setFont(new Font(label.getFont().getName(), label.getFont().getStyle(), 40));    
        this.add(label, BorderLayout.CENTER); 
                
        startPauseButton.addActionListener(startPauseButtonListener);    
        resetButton.addActionListener(resetButtonListener);    
        thread.start(); // 计数线程一直就运行着    
    }    
  
	private class CountingThread extends Thread {    
     
        public boolean stopped = true;    
     
        private CountingThread() {    
            setDaemon(true);    
        }    
          
    public void run() {    
            while (true) {    
                if (!stopped) {    
                    long elapsed = System.currentTimeMillis() - programStart - pauseCount;    
                    label.setText(format(elapsed));    
                }    
     
                try {    
                    sleep(1);  // 1毫秒更新一次显示  
                } catch (InterruptedException e) {    
                    e.printStackTrace();    
                    System.exit(1);    
                }    
            }    
        }    
     
        // 将毫秒数格式化    
      private String format(long elapsed) {    
            int hour, minute, second, milli;    
     
            milli = (int) (elapsed % 1000);    
            elapsed = elapsed / 1000;    
     
            second = (int) (elapsed % 60);    
            elapsed = elapsed / 60;    
     
            minute = (int) (elapsed % 60);    
            elapsed = elapsed / 60;    
     
            hour = (int) (elapsed % 60);    
     
            return String.format("%02d:%02d:%02d %03d", hour, minute, second, milli);    
        }    
    }  
   
	public Timer() {  //类函数
		
		  Timer Timer = new Timer("计时器");    
	      Timer .pack();    
	      Timer .setVisible(true); 
		
	}
  
    public static void main(String[] args) {    //主函数
    	new Timer();        
    }

	public void schedule(TimerTask timerTask, int i, int j) {
		// TODO Auto-generated method stub
		
	}
   
}   