package ri.specialist.calc;

import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.FlowLayout;
import javax.swing.JFormattedTextField;
import javax.swing.JComboBox;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.DefaultComboBoxModel;
import java.awt.Font;
import java.awt.Dimension;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class MainWin {
	
	private JFrame frame;
	private JButton btnNewButton;
	private JLabel labelResult;
	private JFormattedTextField txt2;
	private JFormattedTextField txt1;
	private JComboBox opList;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MainWin window = new MainWin();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public MainWin() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		txt1 = new JFormattedTextField();
		txt1.setPreferredSize(new Dimension(100, 20));
		txt1.setMinimumSize(new Dimension(100, 20));
		txt1.setFont(new Font("Tahoma", Font.PLAIN, 18));
		frame.getContentPane().add(txt1);
		
		opList = new JComboBox();
		opList.setFont(new Font("Tahoma", Font.PLAIN, 18));
		opList.setModel(new DefaultComboBoxModel(new String[] {"+", "-", "*", "/"}));
		frame.getContentPane().add(opList);
		
		txt2 = new JFormattedTextField();
		txt2.setPreferredSize(new Dimension(100, 20));
		txt2.setFont(new Font("Tahoma", Font.PLAIN, 18));
		frame.getContentPane().add(txt2);
		
		btnNewButton = new JButton("==");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try
				{
				int n1 = Integer.parseInt(txt1.getText());
				int n2 = Integer.parseInt(txt2.getText());
				int n = 0;
				switch (opList.getSelectedItem().toString()) {
				case "+": n = n1+n2; break;
				case "-": n = n1-n2; break;
				case "*": n = n1*n2; break;
				case "/": n = n1/n2; break;
				}
				labelResult.setText(String.valueOf(n));
				}
				catch(NumberFormatException ex)
				{
					JOptionPane.showMessageDialog(frame, ex.getMessage(), 
							"Error", JOptionPane.ERROR_MESSAGE);
				}
				
			}
		});
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 18));
		frame.getContentPane().add(btnNewButton);
		
		labelResult = new JLabel("\u0420\u0435\u0437\u0443\u043B\u044C\u0442\u0430\u0442");
		labelResult.setFont(new Font("Tahoma", Font.PLAIN, 18));
		frame.getContentPane().add(labelResult);
	}

}
