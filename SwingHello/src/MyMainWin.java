
import java.awt.Dimension;
import java.awt.FlowLayout;

import javax.swing.*;

public class MyMainWin extends JFrame {

	private static final long serialVersionUID = 1L;

	public MyMainWin() {
		super();
		initialize();
	}
	
	private void initialize() {
		this.setSize(600, 500);
		this.setTitle("Hello from Swing app");
		this.setContentPane(getJContentPane());
		
	}
	
	private JPanel getJContentPane()
	{
		if (contentPane == null) {
			contentPane = new JPanel();
			contentPane.setLayout(new FlowLayout());
			label = new JLabel("Текст");
			label.setPreferredSize(new Dimension(250, 300));
			
			button = new JButton();
			button.setText("<html>Это <b>моя</b> кнопка");
			button.addActionListener(e->{
				System.out.println("Button pressed");
			});
			
			list = new java.awt.List();
			list.add("1");
			list.add("2");
			list.add("3");
			
			list.addItemListener( e-> {
				System.out.println("item selected");
				
			});
			
			
			contentPane.add(label);
			contentPane.add(list);
			contentPane.add(button);
		}
		
		return contentPane;
			
		
	}
	
	private JPanel contentPane;
	private JLabel label;
	private JButton button;
	private java.awt.List list;
	
	
	public static void main(String[] args) {
		SwingUtilities.invokeLater(()->{
			MyMainWin win = new MyMainWin();
			win.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			win.setVisible(true);
		});

	}

}
