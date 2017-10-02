package com.cooksys.assessment;

import java.awt.Component;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;

import java.awt.BorderLayout;

import javax.swing.JButton;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import javax.swing.DefaultListModel;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JScrollPane;
import javax.swing.JMenu;
import javax.swing.JList;
import javax.swing.JTextField;
import javax.swing.ListModel;

import java.awt.GridLayout;

import javax.swing.JLabel;
import javax.swing.BoxLayout;
import javax.swing.AbstractListModel;
import javax.swing.text.Document;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;


public class Window {

	private JFrame frame;

	/**
	 * Launch the application. The main method is the entry point to a Java application. 
	 * For this assessment, you shouldn't have to add anything to this.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Window window = new Window();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application. This is the constructor for this Window class.
	 * All of the code here will be executed as soon as a Window object is made.
	 */
	public Window() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame. This is where Window Builder
	 * will generate its code.
	 */
	public void initialize() 
	{
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 442);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(new BoxLayout(frame.getContentPane(), BoxLayout.X_AXIS));
		
		JPanel panel_7 = new JPanel();
		frame.getContentPane().add(panel_7);
		
		final JList<String> list1 = new JList<String>();
		list1.setModel
		(
			new AbstractListModel() 
			{
				String[] values = new String[] {"Case", "Motherboard", "CPU", "GPU", "PSU", "RAM", "HDD"};
				public int getSize() 
				{
					return values.length;
				}
				public Object getElementAt(int index) 
				{
					return values[index];
				}
			}
		);
		panel_7.add(list1);
		
		JPanel panel = new JPanel();
		frame.getContentPane().add(panel);
		panel.setLayout(new GridLayout(1, 1, 0, 0));
		
		JPanel panel_1 = new JPanel();
		panel.add(panel_1);
		panel_1.setLayout(new GridLayout(0, 1, 0, 0));
		
		JPanel panel_2 = new JPanel();
		panel_1.add(panel_2);
		
		JPanel panel_4 = new JPanel();
		panel_1.add(panel_4);
		
		JButton button1 = new JButton(">>");		
		panel_1.add(button1);
		
		JButton button2 = new JButton("<<");
		panel_1.add(button2);
		
		JPanel panel_5 = new JPanel();
		panel_1.add(panel_5);
		
		JPanel panel_3 = new JPanel();
		panel_1.add(panel_3);
		
		JPanel panel_8 = new JPanel();
		frame.getContentPane().add(panel_8);
		
		final JList<String> list2 = new JList<String>();
		panel_8.add(list2);
		
		JLabel label = new JLabel("");
		frame.getContentPane().add(label);
		
		JLabel label_1 = new JLabel("");
		frame.getContentPane().add(label_1);
		
		JMenuBar menuBar = new JMenuBar();
		frame.setJMenuBar(menuBar);
		
		JMenu mnFile = new JMenu("File");
		menuBar.add(mnFile);
		
		JMenuItem mntmLoad = new JMenuItem("Load");
		mntmLoad.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) 
			{
				File file1 = new File("C:\\House\\LeftList.xml");
				File file2 = new File("C:\\House\\RightList.xml");
				
				itemList test1 = new itemList();
				itemList test2 = new itemList();
				
				try
				{
					JAXBContext jaxbContext = JAXBContext.newInstance(itemList.class);
					Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();
					
					test1 = (itemList) jaxbUnmarshaller.unmarshal(file1);
					test2 = (itemList) jaxbUnmarshaller.unmarshal(file2);
				}
				catch (JAXBException e1)
				{
					e1.printStackTrace();
				}
				
				//Get size of itemLists
				int list1Size = test1.getModel().size();
				int list2Size = test2.getModel().size();
				
				//declare List Models to use to manipulate JList data 
				final DefaultListModel<String> model1 = new DefaultListModel();
				final DefaultListModel<String> model2 = new DefaultListModel();
				
				//walk through arrays and add elements to models
				for(int x = 0; x < list1Size; x++)
				{
					model1.addElement(test1.getModel().get(x));
				}
				for(int x = 0; x < list2Size; x++)
				{
					model2.addElement(test2.getModel().get(x));
				}
				
				//Update first JList
				list1.setModel(model1);
				//Update second JList
				list2.setModel(model2);
				
				
				
			}
		});
		mnFile.add(mntmLoad);
		
		JMenuItem mntmSave = new JMenuItem("Save");
		mntmSave.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) 
			{
				itemList test1 = new itemList(list1.getModel());
				itemList test2 = new itemList(list2.getModel());
				
				test1.setId(100);
				test2.setId(200);
				
				File file1 = new File("C:\\House\\LeftList.xml");
				File file2 = new File("C:\\House\\RightList.xml");
				
				try
				{
					JAXBContext jaxbContext = JAXBContext.newInstance(itemList.class);
					Marshaller jaxbMarshaller = jaxbContext.createMarshaller();
					
					jaxbMarshaller.marshal(test1, file1);
					jaxbMarshaller.marshal(test2, file2);
				}
				catch (JAXBException e1)
				{
					e1.printStackTrace();
				}
			}
		});
		mnFile.add(mntmSave);
		
		JMenuItem mntmExit = new JMenuItem("Exit");
		mntmExit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		mnFile.add(mntmExit);
		
			
		button1.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent e) 
			{
				if(list1.getSelectedIndex()>=0)
				{
					//declare List Models to use to manipulate JList data 
					final DefaultListModel<String> model1 = new DefaultListModel();
					final DefaultListModel<String> model2 = new DefaultListModel();
					
					//Get size of JLists
					int list1Size = list1.getModel().getSize();
					int list2Size = list2.getModel().getSize();
					
					//Walk through JLists to populate List Models
					for(int x = 0; x < list1Size; x++)
					{
						model1.addElement(list1.getModel().getElementAt(x).toString());
					}
					for(int x = 0; x < list2Size; x++)
					{
						model2.addElement(list2.getModel().getElementAt(x).toString());
					}
					
					//save selected index
					int selectedIndex = list1.getSelectedIndex();
					
					//add element to second List Model
					model2.add(model2.getSize(), model1.getElementAt(list1.getSelectedIndex()));
					//Update second JList
					list2.setModel(model2);
					
					//remove element from first List Model
					model1.remove(list1.getSelectedIndex());
					//Update first JList
					list1.setModel(model1);
					
					if(selectedIndex >= model1.getSize())
					{
						selectedIndex--;
					}

					//reset focus in first list
					list1.setSelectedIndex(selectedIndex);
				}
				
			}
		}
		);
		
		button2.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent e) 
			{
				if(list2.getSelectedIndex()>=0)
				{
					//declare List Models to use to manipulate JList data 
					final DefaultListModel<String> model1 = new DefaultListModel();
					final DefaultListModel<String> model2 = new DefaultListModel();
					
					//Get size of JLists
					int list1Size = list1.getModel().getSize();
					int list2Size = list2.getModel().getSize();
					
					//Walk through JLists to populate List Models
					for(int x = 0; x < list1Size; x++)
					{
						model1.addElement(list1.getModel().getElementAt(x).toString());
					}
					for(int x = 0; x < list2Size; x++)
					{
						model2.addElement(list2.getModel().getElementAt(x).toString());
					}
					
					//save selected index
					int selectedIndex = list2.getSelectedIndex();
					
					//add element to second List Model
					model1.add(model1.getSize(), model2.getElementAt(list2.getSelectedIndex()));
					//Update second JList
					list1.setModel(model1);
					
					//remove element from first List Model
					model2.remove(list2.getSelectedIndex());
					//Update first JList
					list2.setModel(model2);
					
					if(selectedIndex >= model2.getSize())
					{
						selectedIndex--;
					}

					//reset focus in first list
					list2.setSelectedIndex(selectedIndex);
				}
				
			}
		}
		);
		
		
	}


	@XmlRootElement
	public static class itemList
	{
		List<String> model = new ArrayList<String>();
		int id;
		
		
		
		public itemList()
		{
			
		}
		
		public itemList(ListModel<String> listModel)
		{
			String test = "";
			
			for(int x = 0; x < listModel.getSize(); x++)
			{
				test = listModel.getElementAt(x).toString();
				model.add(test);
			}
		}
		
		public List<String> getModel() {
			return model;
		}

		@XmlElement
		public void setModel(List<String> base) {
			model = base;
		}
		
		public int getId() {
			return id;
		}

		@XmlAttribute
		public void setId(int id) {
			this.id = id;
		}
		
	}
}