package swingsample.combobox;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class ExchangeCalc extends JFrame implements ActionListener{
	private static float usd = 1225.60f; //float �� ���� �ڿ� f �� ����
	private static float jyp = 1137.92f;
	private static float eur = 1363.66f;  //static ������ ?
	private static float cny = 171.89f; 
	private static float gbp = 1529.67f;
	
	JComboBox<String> combo;
	String[]money = {"�޷�","��","����","����","�Ŀ��"};
	JPanel pane1;
	JPanel pane2;
	JLabel lbl;
	JTextField txt;
	JButton btn;
	
	public ExchangeCalc() {
		
		setTitle("ȯ�� ����");
		
		pane1 = new JPanel();
		pane2 = new JPanel();
		
		txt = new JTextField(10);
		combo = new JComboBox<>(money);
		btn = new JButton("��ȯ");
		
		lbl = new JLabel("��ȯ ���");  //pane2
		
		
		
		pane1.add(new JLabel("��ȭ"));
		pane1.add(txt);
		pane1.add(combo);
		pane1.add(btn);
		
		pane2.add(lbl);
		
		getContentPane().add(pane1, "North"); //�ڸ� ��ġ (BorderLayout)
		getContentPane().add(pane2, "Center");//�ڸ� ��ġ (BorderLayout)
		
		
		setBounds(300, 300, 350, 200); //x��ǥ y��ǥ  width height
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
		btn.addActionListener(this);
		
		
	
	}
	

	public static void main(String[] args) {
		new ExchangeCalc();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
			calculate();
		}
	public void calculate() {
		float won = Float.parseFloat(txt.getText());
		String result = null;
		String money = combo.getSelectedItem().toString();
		
		if(money.equals("�޷�")) {
			result = String.format("%.2f", won / usd);  //������ ���ڿ� �������� ����
		}else if(money.equals("��")) {
			result = String.format("%.1f", won / jyp);
		}else if(money.equals("����")) {
			result = String.format("%.2f", won / eur);
		}else if (money.equals("����")) {
			result = String.format("%.2f", won / cny);
		}else if(money.equals("�Ŀ��")) {
			result = String.format("%.2f", won / gbp);
		}
		lbl.setText(result);

	}

}
