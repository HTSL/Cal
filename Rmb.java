/** 
* �� �� �� : �๦��Ӧ�ü�����__����Ҵ�Сдת��
* �� �� С�飺HTSLС�飨��Ա��î����������������ͯ ��
* ��    �ڣ� 2016/9/20  ~  2016/10/7
* ��   ����  ���� �������ʵ���� ��С����ҵ��С���Ʒ   ���๦�ܼ��������Ĳ��ֹ���ʵ������Ҵ�Сдת�����ܡ�
*/ 
package mycalculator;

import java.awt.event.*;
import javax.swing.*;
import java.text.*;

public class Rmb extends JFrame
{

	private static final long serialVersionUID = 1L;
	
/*��ܵ�����*/
	private JLabel lblNum;
    private JTextField txtNum;
    private JButton btnRun;
    private JLabel lblChn;
    private JTextField txtChn;
    private JPanel pnlMain;
    DecimalFormat dformat = new DecimalFormat("#.00");
 
    /**
   *����ҵĻ�����Ϣ�Ͳ���
   */
    double number;     //����ҵ�����
    private String[] hanArr = {"��", "Ҽ", "��", "��", "��", "��", "½", "��", "��", "��" };//���ּ�������
    private String[] unitArr = {"", "ʰ", "��", "Ǫ"};//���ּ�����λ
    private String[] unitArrs = {"��", "��", "��", "��", "��", "��", "��", "Բ"}; //˳����ӵ�λ
    //private String[] unitsArr = {"��", "��"}; //���ּ�����λ

    public Rmb(double number){        //��������ʼ�����������
	  this.number = number;
  }
  /**
   *��һ���������ֽ��long�Ͳ��ֺ�С�������ַ�����������һ�������������������ȡС������ʱ�ٽ�ֵ�����
   *���طֽ����ַ������飬��һ������Ԫ�����������֣��ڶ�����С�������ַ���
  */
  public String[] divideNum(){
    double num = Math.round(number*100);           //��number������������ȡ��
    long integerPart = (long)num;             //��ͬС�������λȡ������ ������ʹ�ü���
    //double decimalsPart = num-integerPart;//С�����֣��ٽ�ʱ���������
    String decimalsPartStr;                   //����С�����һλ�͵ڶ�λ���ַ���
    long b = integerPart % 10;          //С�����ڶ�λ
    long a = (integerPart/10) % 10;          //С������һλ
    integerPart /= 100;               //ȥ����������λС��
    if(a==0 && b==0){                //�ж����������ĵ�һλ�͵ڶ�λС���Ƿ�Ϊ��
      decimalsPartStr = null;  
    }else{
      decimalsPartStr = "" + a + b;
    }
    return new String[] {String.valueOf(integerPart) , decimalsPartStr};         //������λ����  ǰ��Ϊ����  ����ΪС������λ
  }
  
  /**
   *��һ�������ַ�ת���ɺ��������Ҷ���
   * ���غ�������Ҷ������ַ�����ʽ
  */
  public String toHanStr(){
    String[] results = new String[9];        //������ʱ�洢ÿ��λ�ֶκ�������ַ���
    String[] resultStrs = new String[9];          //������ʱ�洢ÿ��λ�ֶκ�ת���ɵ�����Ҷ���
    String result = "";        //���յ�ת����� 
    String[] divideStr = divideNum();     //�õ��������ֽ�ɵ�long�Ͳ��ֺ�С�������ַ�������һ������Ԫ�������������ַ������ڶ�����С�������ַ���
    results[8] = divideStr[1];  //��С�����ִ浽result[8]
    for (int i=divideStr[0].length(), j=8; i>0&&j>0 ; i-=4,j--){
      try{
        results[j-1] = divideStr[0].substring(i-4, i);   //С����ǰÿ��λ��Ϊһ��Ԫ��
      }catch(Exception e){
        results[j-1] = divideStr[0].substring(0, i);		//������λ�Ĳ���Ҳ��һλԪ��
        break;
      }
    } 
    if(results[8] == null){  	//С������Ϊ0
      resultStrs[8] = "��";
    }else if(results[8].charAt(1) == '0'){
      resultStrs[8] = hanArr[results[8].charAt(0) - 48] + "��"; //����ASCII���hanArr��������ָĳɺ����д
    }else{
      resultStrs[8] = hanArr[results[8].charAt(0) - 48] + "��" + hanArr[results[8].charAt(1) - 48] + "��"; 
    }          //results[8].charAt[1]���ַ����ĵڶ����ַ�
    
    for(int i=0; i<8; i++){					//�����ܵ�����λ�� 7*4=28λ
      if(results[i] != null){
        resultStrs[i] = "";         //�����4λΪ��ʱ��������
        resultStrs[i] += hanArr[results[i].charAt(0) - 48] + unitArr[results[i].length() - 1]; //����ASCII������鳤��ѡ�����ĵ�λ
        for (int j=1; j<results[i].length(); j++ )
          if(results[i].charAt(j-1) == '0' && results[i].charAt(j) != '0')    //����λ���и�λΪ0   �Ͷ������������
            resultStrs[i] += "��" + hanArr[results[i].charAt(j) - 48] + unitArr[results[i].length() - 1 - j];  //����ASCII������鳤��ѡ�����ĵ�λ
          else if(results[i].charAt(j) != '0' )
            resultStrs[i] += hanArr[results[i].charAt(j) - 48] + unitArr[results[i].length() - 1 - j];   //������
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
	  /*��ʼ�����*/
		lblNum = new JLabel("����������");
		txtNum= new JTextField();
		btnRun = new JButton("ת��");
		lblChn = new JLabel("���ִ�д");
		txtChn= new JTextField();
		pnlMain = new JPanel();
		pnlMain.setLayout(null);
     
		lblNum.setBounds(100, 50 , 80, 25);  //����label Button ��λ��
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
	        setTitle("����Ҵ�дת��");
	        setVisible(true);
	        setResizable(true);
	        //this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	        this.setLocationRelativeTo(null);
      
  	btnRun.addActionListener(new ActionListener() {  //Button ���¼���Ӧ   ���ǰѰ���������ת��Ϊ��д���
		public void actionPerformed(ActionEvent ae) {
		if(txtNum.getText()!= null){
			double num = Double.valueOf(txtNum.getText());          //��Ϊ��ʱ ��ȡ���
			  Rmb r =new Rmb(num);
			  txtChn.setText(r.toHanStr());				//ת���������д����
		}
		else{            //����Ϊ�յı���
			JOptionPane.showMessageDialog(null, "����Ϊ�գ���������ȷ��");
			return;
		}
	}
	});
 }
  
  public static void main(String[] args) {
   new Rmb();

  }
}

