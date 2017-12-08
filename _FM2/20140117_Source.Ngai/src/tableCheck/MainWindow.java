package tableCheck;

/**
 *
 * @author Chris Kemerait
 */
//import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
//import java.awt.Dimension;
import java.awt.Dimension;
//import java.awt.Panel;
//import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.io.File;
import java.util.ArrayList;
//import java.util.List;
import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellRenderer;

public class MainWindow extends JFrame 
{
	/**
	 * 
	 */
	private static final long serialVersionUID = -7675642717309639564L;

	//Master Panel
	JPanel 							panel = new JPanel();
	//Sub Panels
	JPanel 							northPanel = new JPanel();
	JPanel 							midPanel = new JPanel();
	JPanel 							southPanel = new JPanel();
	//North Sub Panels
	JPanel 							NorthPanel1 = new JPanel();
	JButton 						loadButton = new JButton("Load File.");
	JPanel 							NorthPanel2 = new JPanel();
	JCheckBox 						matchingCheckBox = new JCheckBox();
	JLabel    						matchingLabel    = new JLabel("Match ETM rows to CSV columns.");
	//Mid Sub Panels
	JPanel 							WestPanel = new JPanel();
	JPanel 							EastPanel = new JPanel();
	//Mid West Sub Panels
	JPanel 							WestPanel1 = new JPanel();
	JLabel 							westLabel = new JLabel("ETM Table Data");
	//Mid West Sub Panel 2
	JScrollPane 					scrollPaneW = new JScrollPane();
	JTable                          westTable;
	//Mid East Sub Panels		
	JPanel 							EastPanel1 = new JPanel();
	JLabel 							eastLabel = new JLabel("CSV Table Data");
	//Mid East Sub Panel 2
	JScrollPane 					scrollPaneE = new JScrollPane();
	JTable                          eastTable = new JTable();
	//South Sub Panels
	JPanel 							SouthWestPanel = new JPanel();
	JPanel 							SouthEastPanel = new JPanel();
	JTextArea 						southLabel = new JTextArea("This is where the output goes.");
	JScrollPane 					southScroll = new JScrollPane(southLabel);
	//South West Sub Panels
	JPanel 							SouthWestPanel1 = new JPanel();
	JLabel 							etmLabel = new JLabel("Enter common pathway:");
	JPanel 							SouthWestPanel2 = new JPanel();
	private JTextField 				pathwayField = new JTextField(30);
	JPanel 							SouthWestPanel3 = new JPanel();
	JLabel 							csvLabel = new JLabel("Enter common file name:");
	JPanel 							SouthWestPanel4 = new JPanel();
	private JTextField 				fileField = new JTextField(30);
	JPanel 							SouthWestPanel5 = new JPanel();
	private JButton 				CheckTableButton = new JButton("Check table");

	JFileChooser fChooser = new JFileChooser();

	private MainController controller;

	/**
	 * 
	 */
	public MainWindow() 
	{
		controller = new MainController();// (manager);
		int MasterWidth = 1280;
		int MasterHeight = 800;
		int NorthWidth = MasterWidth;
		int NorthHeight = MasterHeight/10;
		int NorthWidth1 = NorthWidth;
		int NorthHeight1 = NorthHeight/2;
		int NorthWidth2 = NorthWidth;
		int NorthHeight2 = NorthHeight/2;
		int MidWidth = MasterWidth;
		int MidHeight = MasterHeight/2;
		int WestWidth = MidWidth/2;
		int WestHeight = MidHeight;
		int WestWidth1 = WestWidth;
		int WestHeight1 = WestHeight/20;
		int WestWidth2 = WestWidth-7;
		int WestHeight2 = (WestHeight/20)*19;
		int EastWidth = MidWidth/2;
		int EastHeight = MidHeight;
		int EastWidth1 = EastWidth;
		int EastHeight1 = EastHeight/20;
		int EastWidth2 = EastWidth-7;
		int EastHeight2 = (EastHeight/20)*19;
		int SouthWidth = MasterWidth;
		int SouthHeight = MasterHeight/5;
		int SouthWestWidth = SouthWidth/3;
		int SouthWestHeight = SouthHeight/5;
		int SouthWestWidth1 = SouthWestWidth;
		int SouthWestHeight1 = SouthWestHeight/5;
		int SouthWestWidth2 = SouthWestWidth;
		int SouthWestHeight2 = SouthWestHeight/5;
		int SouthWestWidth3 = SouthWestWidth;
		int SouthWestHeight3 = SouthWestHeight/5;
		int SouthWestWidth4 = SouthWestWidth;
		int SouthWestHeight4 = SouthWestHeight/5;
		int SouthWestWidth5 = SouthWestWidth;
		int SouthWestHeight5 = SouthWestHeight/5;
		int SouthEastWidth = (SouthWidth/3)*2;
		int SouthEastHeight = SouthHeight;

		//Add Panels
		NorthPanel1.add(loadButton);
		NorthPanel2.add(matchingCheckBox);
		NorthPanel2.add(matchingLabel);
		northPanel.add(NorthPanel1);
		northPanel.add(NorthPanel2);
		WestPanel1.add(westLabel);
		WestPanel.add(WestPanel1);
		WestPanel.add(scrollPaneW);
		EastPanel1.add(eastLabel);
		EastPanel.add(EastPanel1);
		EastPanel.add(scrollPaneE);
		midPanel.add(WestPanel);
		midPanel.add(EastPanel);
		SouthWestPanel1.add(etmLabel);
		SouthWestPanel2.add(pathwayField);
		SouthWestPanel3.add(csvLabel);
		SouthWestPanel4.add(fileField);
		SouthWestPanel5.add(CheckTableButton);
		SouthWestPanel.add(SouthWestPanel1);
		SouthWestPanel.add(SouthWestPanel2);
		SouthWestPanel.add(SouthWestPanel3);
		SouthWestPanel.add(SouthWestPanel4);
		SouthWestPanel.add(SouthWestPanel5);
		southPanel.add(SouthWestPanel);
		SouthEastPanel.add(southScroll);
		southPanel.add(SouthEastPanel);
		panel.add(northPanel);
		panel.add(midPanel);
		panel.add(southPanel);
		add(panel);

		//Layouts
		panel.setLayout(new BoxLayout(panel,BoxLayout.Y_AXIS));
		northPanel.setLayout(new BoxLayout(northPanel,BoxLayout.Y_AXIS));
		midPanel.setLayout(new BoxLayout(midPanel,BoxLayout.X_AXIS));
		WestPanel.setLayout(new BoxLayout(WestPanel,BoxLayout.Y_AXIS));
		EastPanel.setLayout(new BoxLayout(EastPanel,BoxLayout.Y_AXIS));
		southPanel.setLayout(new BoxLayout(southPanel,BoxLayout.X_AXIS));
		SouthWestPanel.setLayout(new BoxLayout(SouthWestPanel,BoxLayout.Y_AXIS));
		SouthEastPanel.setLayout(new BoxLayout(SouthEastPanel,BoxLayout.Y_AXIS));

		//Size Panels
		setSize(new Dimension(MasterWidth, MasterHeight));
		setPreferredSize(new Dimension(MasterWidth, MasterHeight));
		northPanel.setSize(new Dimension(NorthWidth,NorthHeight));
		northPanel.setPreferredSize(new Dimension(NorthWidth,NorthHeight));
		NorthPanel1.setSize(new Dimension(NorthWidth1,NorthHeight1));
		NorthPanel1.setPreferredSize(new Dimension(NorthWidth1,NorthHeight1));
		NorthPanel2.setSize(new Dimension(NorthWidth2,NorthHeight2));
		NorthPanel2.setPreferredSize(new Dimension(NorthWidth2,NorthHeight2));
		midPanel.setSize(new Dimension(MidWidth,MidHeight));
		midPanel.setPreferredSize(new Dimension(MidWidth,MidHeight));
		WestPanel.setSize(new Dimension(WestWidth,WestHeight));
		WestPanel.setPreferredSize(new Dimension(WestWidth,WestHeight));
		WestPanel1.setSize(new Dimension(WestWidth1,WestHeight1));
		WestPanel1.setPreferredSize(new Dimension(WestWidth1,WestHeight1));
		scrollPaneW.setSize(new Dimension(WestWidth2,WestHeight2));
		scrollPaneW.setPreferredSize(new Dimension(WestWidth2,WestHeight2));
		EastPanel.setSize(new Dimension(EastWidth,EastHeight));
		EastPanel.setPreferredSize(new Dimension(EastWidth,EastHeight));
		EastPanel1.setSize(new Dimension(EastWidth1,EastHeight1));
		EastPanel1.setPreferredSize(new Dimension(EastWidth1,EastHeight1));
		scrollPaneE.setSize(new Dimension(EastWidth2,EastHeight2));
		scrollPaneE.setPreferredSize(new Dimension(EastWidth2,EastHeight2));
		southPanel.setSize(new Dimension(SouthWidth,SouthHeight));
		southPanel.setPreferredSize(new Dimension(SouthWidth,SouthHeight));
		SouthWestPanel.setSize(new Dimension(SouthWestWidth,SouthWestHeight));
		SouthWestPanel.setPreferredSize(new Dimension(SouthWestWidth,SouthWestHeight));
		SouthWestPanel1.setSize(new Dimension(SouthWestWidth1,SouthWestHeight1));
		SouthWestPanel1.setPreferredSize(new Dimension(SouthWestWidth1,SouthWestHeight1));
		SouthWestPanel2.setSize(new Dimension(SouthWestWidth2,SouthWestHeight2));
		SouthWestPanel2.setPreferredSize(new Dimension(SouthWestWidth2,SouthWestHeight2));
		SouthWestPanel3.setSize(new Dimension(SouthWestWidth3,SouthWestHeight3));
		SouthWestPanel3.setPreferredSize(new Dimension(SouthWestWidth3,SouthWestHeight3));
		SouthWestPanel4.setSize(new Dimension(SouthWestWidth4,SouthWestHeight4));
		SouthWestPanel4.setPreferredSize(new Dimension(SouthWestWidth4,SouthWestHeight4));
		SouthWestPanel5.setSize(new Dimension(SouthWestWidth5,SouthWestHeight5));
		SouthWestPanel5.setPreferredSize(new Dimension(SouthWestWidth5,SouthWestHeight5));
		SouthEastPanel.setSize(new Dimension(SouthEastWidth,SouthEastHeight));
		SouthEastPanel.setPreferredSize(new Dimension(SouthEastWidth,SouthEastHeight));
		southScroll.setSize(new Dimension(SouthEastWidth,SouthEastHeight));
		southScroll.setPreferredSize(new Dimension(SouthEastWidth,SouthEastHeight));

		//Panel Settings
		setVisible(true);
		panel.setBackground(Color.white);
		northPanel.setOpaque(true);
		NorthPanel1.setOpaque(true);
		NorthPanel2.setOpaque(true);
		southPanel.setOpaque(true);
		SouthWestPanel.setOpaque(true);
		SouthWestPanel1.setOpaque(true);
		SouthWestPanel2.setOpaque(true);
		SouthWestPanel3.setOpaque(true);
		SouthWestPanel4.setOpaque(true);
		SouthWestPanel5.setOpaque(true);
		SouthEastPanel.setOpaque(true);

		//Objects
		southLabel.setOpaque(true);
		southLabel.setVisible(true);
		southLabel.setEditable(true);
		loadButton.addActionListener(new TauListener());
		matchingCheckBox.setSelected(true);
		matchingCheckBox.addItemListener(new CheckBoxListener());
		pathwayField.setText(controller.GetLineFromFile(0));
		pathwayField.addActionListener(new etmFieldListener());
		fileField.setText(controller.GetLineFromFile(1));
		fileField.addActionListener(new csvFieldListener());
		CheckTableButton.addActionListener(new ButtonListener());
	}

	private class etmFieldListener implements ActionListener {

		public void actionPerformed(ActionEvent e) 
		{
			String name = pathwayField.getText();
			File alpha = new File(name);
			if (name.equals(null))
				JOptionPane.showMessageDialog(null, "empty etm - try again");
			else 
			{
				// check if file exists
				if (!alpha.exists()) 
				{
					// then output "cannot find etm - try again"
					JOptionPane.showMessageDialog(null,	"cannot find etm - try again");
				}
			}
		}

	}

	private class csvFieldListener implements ActionListener 
	{

		public void actionPerformed(ActionEvent e) 
		{
			String name = fileField.getText();
			File alpha = new File(name);
			if (name.equals(""))
				JOptionPane.showMessageDialog(null, "empty csv - try again");
			else 
			{
				// check if file exists
				if (!alpha.exists()) 
				{
					// then output "cannot find csv - try again"
					JOptionPane.showMessageDialog(null,
					"cannot find csv - try again");
				}
			}
		}

	}

	private class ButtonListener implements ActionListener 
	{

		public void actionPerformed(ActionEvent e) 
		{
			String alpha = pathwayField.getText();
			String beta = fileField.getText();
			if(alpha.charAt(alpha.length()-1) != '\\')
			{
				alpha += "\\";
				pathwayField.setText(alpha);
			}
			String delta = controller.ProcessTable(alpha+beta+".etm", alpha+beta+".csv");

			controller.ClearFile();
			controller.SaveLineToFile(alpha+"\n"+beta);

			//This will display the tables even when there is an error 
			if(!delta.startsWith("There is a problem")){
				updateWestTable();
				updateEastTable();
			}

			//eastTable = AddEastTable(controller.getETM());


			if(delta.equals("PASS"))
			{
				//westPanel.remove(westLabel);
				//eastPanel.remove(eastLabel);

				southLabel.setText("No error was returned.  Your table checks out.");
			}
			else
			{
				//southLabel.setText("An error occurred involving your entered data. \n Please ensure that the .etm and .csv files exist.");
				southLabel.setText(delta);
			}
		}

	}

	private class TauListener implements ActionListener 
	{

		public void actionPerformed(ActionEvent e) 
		{
			String alpha = "";
			String beta = "";

			//Handle open button action.
			if (e.getSource() == loadButton) 
			{
				File Bulbasaur = new File(controller.GetLineFromFile(0)+controller.GetLineFromFile(1));

				fChooser.setSelectedFile(Bulbasaur);

				int returnVal = fChooser.showOpenDialog(fChooser);

				if (returnVal == JFileChooser.APPROVE_OPTION) 
				{
					alpha = fChooser.getSelectedFile().getPath();
					beta = fChooser.getSelectedFile().getName();

					alpha = alpha.substring(0,alpha.length()-beta.length());
					beta = beta.substring(0, beta.length()-4);

					pathwayField.setText(alpha);
					fileField.setText(beta);
					//This is where a real application would open the file.

				} 
			}
		}

	}

	private class CheckBoxListener implements ItemListener 
	{

		@Override
		public void itemStateChanged(ItemEvent e) 
		{
			// TODO Auto-generated method stub

			if(matchingCheckBox.getSelectedObjects() == null)
			{
				controller.setMatchETMRowsToCSVColumns(false);
			}
			else
			{
				controller.setMatchETMRowsToCSVColumns(true);
			}

		}
	}

	private void updateWestTable()
	{
		ArrayList<ArrayList<String>> etmTable = controller.getETM();
		ArrayList<ArrayList<String>> etmRawTable = controller.getRawETMData();
		String[]headerArray = controller.getETMHeader();
		int[] colChar = new int[headerArray.length];
		for(int i = 0; i<colChar.length; i++){
			colChar[i] = headerArray[i].length();
		}

		String[][] data = new String[etmTable.size()][etmTable.get(0).size()];

		for(int x=0; x < data.length; x++)
		{
			for(int y=0; y < data[x].length; y++)
			{
				String aPieceOfData = etmTable.get(x).get(y);
				data[x][y] = aPieceOfData;
				if(etmRawTable.get(x).get(y).length() > colChar[y]){
					colChar[y] = etmRawTable.get(x).get(y).length();
				}
			}

		}

		westTable = new JTable(data, headerArray);
		for (int i = 0; i<westTable.getColumnCount(); i++){
			westTable.getColumnModel().getColumn(i).setPreferredWidth(colChar[i]*10);
		}
		westTable.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
		scrollPaneW.add(westTable);
		scrollPaneW.setOpaque(true);
		scrollPaneW.setViewportView(westTable);
		scrollPaneW.setBorder(BorderFactory.createLineBorder(Color.black));
		scrollPaneW.setBackground(Color.white);
	}

	private void updateEastTable()
	{
		ArrayList<ArrayList<String>> csvTable = controller.getCSV();
		ArrayList<ArrayList<String>> csvComments = controller.getCSVComments();
		int commentNum = csvComments.size();
		ArrayList<ArrayList<String>> dataToInsert = new ArrayList<ArrayList<String>>(controller.getCSVComments());
		dataToInsert.addAll(csvTable);
		String[]headerArray = controller.getCSVHeader();
		String[][] data = new String[csvTable.size()+csvComments.size()][csvTable.get(0).size()+1];

		for(int row=0; row < data.length; row++)
		{
			for(int col=0; col < data[row].length; col++)
			{
				if(col==0){
					if(row<commentNum){
						data[row][col] = "";
					}else{
						data[row][col] = "Row "+(row-commentNum+1);
					}
				}else{
					if(row < dataToInsert.size() && (col-1) < dataToInsert.get(row).size()){
						data[row][col] = dataToInsert.get(row).get(col-1);
					}else{
						System.out.println("blah");
					}
				}
			}


		}
		eastTable = new csvTable(commentNum);
		eastTable.setAutoCreateRowSorter(false);
		//final JTableHeader header = eastTable.getTableHeader();
		//header.setDefaultRenderer(new HeaderRenderer(eastTable));
		eastTable.setModel(new DefaultTableModel(data,headerArray));
		//eastTable = new JTable(data, headerArray);
		eastTable.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);

		scrollPaneE.add(eastTable);
		scrollPaneE.setOpaque(true);
		scrollPaneE.setViewportView(eastTable);
		scrollPaneE.setBorder(BorderFactory.createLineBorder(Color.black));
		scrollPaneE.setBackground(Color.white);
	}


	
	private class csvTable extends JTable{
		/**
		 * 
		 */
		private static final long serialVersionUID = -5999208960592946893L;
		private int numOfComment;
		public csvTable(int numOfComment){
			super();
			this.numOfComment = numOfComment;
			
		}
		
		@Override
		public Component prepareRenderer(
				TableCellRenderer renderer, int row, int col) {
			if (col == 0 || row < numOfComment) {
				return this.getTableHeader().getDefaultRenderer()
				.getTableCellRendererComponent(this, this.getValueAt(
						row, col), false, false, row, col);
			} else {
				return super.prepareRenderer(renderer, row, col);
			}
		}
	}
	



}