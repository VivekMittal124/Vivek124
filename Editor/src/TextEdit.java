import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GraphicsEnvironment;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;

import javax.swing.JButton;
import javax.swing.JColorChooser;
import javax.swing.JComboBox;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JScrollPane;
import javax.swing.JSpinner;
import javax.swing.JTextArea;
import javax.swing.ScrollPaneConstants;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import javax.swing.filechooser.FileNameExtensionFilter;

public class TextEdit extends JFrame implements ActionListener
{
	JTextArea area;
	JScrollPane scroll;
	JSpinner fontspinner;
	JLabel fontlabel;
	JButton fontbutton;
	JComboBox fontbox;
	JMenuBar menubar;
	JMenu menu;
	JMenuItem open;
	JMenuItem save;
	JMenuItem exit;
	TextEdit()
	{
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setTitle("My Text Editor");
		setSize(600,600);
		setLayout(new FlowLayout());
		setLocationRelativeTo(null);
		
		area=new JTextArea();
		//area.setPreferredSize(new Dimension(550,550));
		area.setLineWrap(true);
		area.setWrapStyleWord(true);
		area.setFont(new Font("Arial",Font.PLAIN,20));
		
		scroll=new JScrollPane(area);
		scroll.setPreferredSize(new Dimension(550,550));
		scroll.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED);
		
		fontlabel=new JLabel("Font: ");
		
		fontspinner=new JSpinner();
		fontspinner.setPreferredSize(new Dimension(50,25));
		fontspinner.setValue(20);
		fontspinner.addChangeListener(new ChangeListener()
		{
			public void stateChanged(ChangeEvent e) 
			{
				area.setFont(new Font(area.getFont().getFamily(),Font.PLAIN,(int)fontspinner.getValue()));
			}
		});
		
		fontbutton=new JButton("Color");
		fontbutton.addActionListener(this);
		
		String[] fonts=GraphicsEnvironment.getLocalGraphicsEnvironment().getAvailableFontFamilyNames();
		fontbox=new JComboBox(fonts);
		fontbox.addActionListener(this);
		fontbox.setSelectedItem("Arial");
		
		// ---------- menubar -----------------
		
			menubar=new JMenuBar();
			menu=new JMenu("File");
			open=new JMenuItem("Open");
			save=new JMenuItem("Save");
			exit=new JMenuItem("Exit");
			
			open.addActionListener(this);
			save.addActionListener(this);
			exit.addActionListener(this);
			
			menu.add(open);
			menu.add(save);
			menu.add(exit);
			menubar.add(menu);
			
		
		// ---------- menubar -----------------

		
		//add(area);
		setJMenuBar(menubar);	
		add(fontlabel);
		add(fontspinner);
		add(fontbutton);
		add(fontbox);
		add(scroll);
		setVisible(true);
	}
	
	public void actionPerformed(ActionEvent e) 
	{
		if(e.getSource()==fontbutton)
		{
			Color color=JColorChooser.showDialog(null, "Choose a color", Color.BLACK);
			area.setForeground(color);
		}
		
		if(e.getSource()==fontbox)
		{
			area.setFont(new Font((String)fontbox.getSelectedItem(),Font.PLAIN,area.getFont().getSize()));
		}
		
		if(e.getSource()==open)
		{
			JFileChooser filechooser=new JFileChooser();
			filechooser.setCurrentDirectory(new File("."));
			
			FileNameExtensionFilter filter=new FileNameExtensionFilter("Text Files","txt","HTML format");
			filechooser.setFileFilter(filter);
			
			int response=filechooser.showOpenDialog(null);
			
			if(response==JFileChooser.APPROVE_OPTION)
			{
				File file=new File(filechooser.getSelectedFile().getAbsolutePath());
				Scanner filein=null;
				try 
				{
					filein=new Scanner(file);
					if(file.isFile())
					{
						while(filein.hasNextLine())
						{
							String line=filein.nextLine()+"\n";
							area.append(line);
						}
					}
				} 
				catch (FileNotFoundException e1) 
				{
					e1.printStackTrace();
				}
				finally
				{
					filein.close();
				}
			}
		}
		
		if(e.getSource()==save)
		{
			JFileChooser filechooser=new JFileChooser();
			filechooser.setCurrentDirectory(new File("."));
			int response=filechooser.showSaveDialog(null);
			
			if(response==JFileChooser.APPROVE_OPTION)
			{
				File file;
				PrintWriter pw=null;
				
				file=new File(filechooser.getSelectedFile().getAbsolutePath());
				try
				{
					pw=new PrintWriter(file);
					pw.println(area.getText());
				}
				catch(FileNotFoundException ae)
				{
					ae.printStackTrace();
				}
				finally
				{
					pw.close();
				}
			}
		}
		
		if(e.getSource()==exit)
		{
			System.exit(0);
		}
		
	}

}