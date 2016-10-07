/** 
* �� �� �� : �๦��Ӧ�ü�����__��ʱ��
* �� �� С�飺HTSLС�飨��Ա��î����������������ͯ ��
* ��    �ڣ� 2016/9/20  ~  2016/10/7
* ��   ����  ���� �������ʵ���� ��С����ҵ��С���Ʒ���๦�ܼ��������Ĳ��ֹ���ʵ�ּ�ʱ�����ܡ�
*/ 
package mycalculator;

import javax.swing.*;    
import java.awt.*;      
import java.awt.event.*;
import java.util.TimerTask;  

public class Timer extends JFrame {    
   private static final long serialVersionUID = 1L;  
   private static final String finaltime = "00:00:00 000";     // �����߳�  
    
   private CountingThread thread = new CountingThread();         // ��¼����ʼʱ��    
   private long programStart = System.currentTimeMillis();  // ����һ��ʼ������ͣ��       
   private long pauseStart = programStart;    // ������ͣ����ʱ��        
   
   private long pauseCount = 0;    
   private JLabel label = new JLabel(finaltime);    
   
   private JButton startPauseButton = new JButton("��ʼ");    
   private JButton resetButton = new JButton("����");    
     
   private ActionListener startPauseButtonListener = new ActionListener() {  //��ӡ���ʼ��ͣ����ť������  
        public void actionPerformed(ActionEvent e) {    
            if (thread.stopped) {    
                pauseCount += (System.currentTimeMillis() - pauseStart);    
                thread.stopped = false;    
                startPauseButton.setText("��ͣ");    
            } else {    
                pauseStart = System.currentTimeMillis();    
                thread.stopped = true;    
                startPauseButton.setText("����");    
            }    
        }    
    };    
   
    private ActionListener resetButtonListener = new ActionListener() {    //������������
        public void actionPerformed(ActionEvent e) {    
            pauseStart = programStart;    
            pauseCount = 0;    
            thread.stopped = true;    
            label.setText(finaltime);    
            startPauseButton.setText("��ʼ");    
        }    
    };    
     
    public Timer(String title) throws HeadlessException {    //�������
        super(title);    
       // setDefaultCloseOperation(EXIT_ON_CLOSE);    
        setLocation(300, 300);    
        setResizable(false);    
        
        JPanel contentPane = new JPanel(new BorderLayout());    // Ϊ���������ӱ߿�      
        contentPane.setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));    
        this.setContentPane(contentPane);   
         
        JPanel panel = new JPanel(new FlowLayout());    // ���ð�ť       
        panel.add(startPauseButton);    
        panel.add(resetButton);    
        add(panel, BorderLayout.SOUTH); 
        
        label.setHorizontalAlignment(SwingConstants.CENTER);    // ���ñ�ǩ    
        label.setFont(new Font(label.getFont().getName(), label.getFont().getStyle(), 40));    
        this.add(label, BorderLayout.CENTER); 
                
        startPauseButton.addActionListener(startPauseButtonListener);    
        resetButton.addActionListener(resetButtonListener);    
        thread.start(); // �����߳�һֱ��������    
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
                    sleep(1);  // 1�������һ����ʾ  
                } catch (InterruptedException e) {    
                    e.printStackTrace();    
                    System.exit(1);    
                }    
            }    
        }    
     
        // ����������ʽ��    
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
   
	public Timer() {  //�ຯ��
		
		  Timer Timer = new Timer("��ʱ��");    
	      Timer .pack();    
	      Timer .setVisible(true); 
		
	}
  
    public static void main(String[] args) {    //������
    	new Timer();        
    }

	public void schedule(TimerTask timerTask, int i, int j) {
		// TODO Auto-generated method stub
		
	}
   
}   