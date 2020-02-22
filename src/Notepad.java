import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

import java.io.*;

public class Notepad extends JFrame {

	private static final long serialVersionUID = 1L;
	
	public Notepad()
	{
		JMenuBar menuBar = new JMenuBar();
		JMenu file = new JMenu("File");
		JMenu exit = new JMenu("Exit");
		JMenuItem open = new JMenuItem("Open");
		JMenuItem save = new JMenuItem("Save");
		file.add(open);
		file.add(save);
		menuBar.add(file);
		menuBar.add(exit);
		this.setJMenuBar(menuBar);
		
		JTextArea textArea = new JTextArea();
		JScrollPane pane = new JScrollPane(textArea);
		this.add(pane);
		this.setSize(800, 500);
		this.setTitle("Notepad");
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setVisible(true);
		
		ActionListener eventListener = new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				if (e.getSource() == open)
				{
					try
					{
						InputStreamReader fr = new InputStreamReader(new FileInputStream("D:\\voca.txt"), "utf-8");
						BufferedReader bf = new BufferedReader(fr);
						String lineContent = bf.readLine();
						String allContent = "";
						while (lineContent != null)
						{
							allContent += lineContent + "\r\n";
							lineContent = bf.readLine();
						}
						textArea.setText(allContent);
						bf.close();
					}catch (IOException ex)
					{
						JOptionPane.showMessageDialog(null, ex.getMessage());
					}
				}else if (e.getSource() == save)
				{
					JOptionPane.showMessageDialog(null, "button save clicked");
				}else if (e.getSource() == exit)
				{
					JOptionPane.showMessageDialog(null, "button exit clicked");
				}
			}
		};
		
		open.addActionListener(eventListener);
	}
	
	public static void main(String[] args)
	{
		Notepad pad = new Notepad();
	}
}
