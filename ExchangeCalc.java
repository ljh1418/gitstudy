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
	private static float usd = 1225.60f; //float 라서 숫자 뒤에 f 가 붙음
	private static float jyp = 1137.92f;
	private static float eur = 1363.66f;  //static 쓴이유 ?
	private static float cny = 171.89f; 
	private static float gbp = 1529.67f;
	
	JComboBox<String> combo;
	String[]money = {"달러","엔","유로","위안","파운드"};
	JPanel pane1;
	JPanel pane2;
	JLabel lbl;
	JTextField txt;
	JButton btn;
	
	public ExchangeCalc() {
		
		setTitle("환율 계산기");
		
		pane1 = new JPanel();
		pane2 = new JPanel();
		
		txt = new JTextField(10);
		combo = new JComboBox<>(money);
		btn = new JButton("변환");
		
		lbl = new JLabel("변환 결과");  //pane2
		
		
		
		pane1.add(new JLabel("원화"));
		pane1.add(txt);
		pane1.add(combo);
		pane1.add(btn);
		
		pane2.add(lbl);
		
		getContentPane().add(pane1, "North"); //자리 배치 (BorderLayout)
		getContentPane().add(pane2, "Center");//자리 배치 (BorderLayout)
		
		
		setBounds(300, 300, 350, 200); //x좌표 y좌표  width height
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
		
		if(money.equals("달러")) {
			result = String.format("%.2f", won / usd);  //왼쪽이 문자열 오른쪽이 변수
		}else if(money.equals("엔")) {
			result = String.format("%.1f", won / jyp);
		}else if(money.equals("유로")) {
			result = String.format("%.2f", won / eur);
		}else if (money.equals("위안")) {
			result = String.format("%.2f", won / cny);
		}else if(money.equals("파운드")) {
			result = String.format("%.2f", won / gbp);
		}
		lbl.setText(result);

	}

}
