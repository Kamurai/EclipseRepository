	package colourpick;
	 
	import java.awt.Color;
	import java.awt.event.ActionListener;
	import java.awt.event.ActionEvent;
	import javax.swing.JButton;
	import java.awt.Container;
	import javax.swing.JSlider;
	import javax.swing.JLabel;
	import javax.swing.JFrame;
	import javax.swing.JPanel;
	import javax.swing.event.ChangeEvent;
	import javax.swing.event.ChangeListener;
	import java.awt.Font;
	import javax.swing.BorderFactory;
	import javax.swing.JTextField;
	import javax.swing.text.Highlighter;
	//These are my imports
	 
	public class Colourpick extends JFrame implements ActionListener, ChangeListener 
	{
	 
	    private JPanel mypanel;
	    private JPanel colourpatch;
	    private JButton button;
	    private JButton button2;
	    private JButton button3;
	    private JButton resetall;
	    private JButton copytoclip;
	    private JSlider myslider;
	    private JSlider myslider2;
	    private JSlider myslider3;
	    private JLabel mylabels;
	    private JLabel mylabels2;
	    private JLabel mylabels3;
	    private JLabel hexcolour;
	    private JTextField hex;
	    private Font panelfont;
	    private Color colour;
	//These are my variables. These are named to my choice
	    public static void main(String[] args) {
	 
	        Colourpick drawingFrame = new Colourpick();
	        drawingFrame.setSize(600, 600);
	        drawingFrame.createGUI();
	        drawingFrame.setVisible(true);
	        drawingFrame.setTitle("Colour Picker");
	//This creates the frame of the graphical user interface
	    }
	 
	    public void createGUI() {
	 
	        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
	        Container window = this.getContentPane();
	 
	 
	        panelfont = new Font("TIMES", Font.PLAIN, 15);
	        colour = new Color(242,242,242);
	 
	 
	 
	        mypanel = new JPanel();
	        mypanel.setLayout(null);
	        mypanel.setBounds(0, 0, 600, 140);
	        mypanel.setBackground(colour);
	        mypanel.setFont(panelfont);
	        window.add(mypanel);
	 
	        //My custom panel is created here and added to the window.
	 
	        button = new JButton("Reset Red");
	        button.setBounds(20, 40, 120, 30);
	        button.setBackground(Color.RED);
	        button.setFont(panelfont);
	        mypanel.add(button);
	        //The button that moves the red slider is created here and added to "mypanel"
	 
	        button2 = new JButton("Reset Green");
	        button2.setBounds(20, 110, 120, 30);
	        button2.setBackground(Color.GREEN);
	        button2.setFont(panelfont);
	        mypanel.add(button2);
	        //The button that moves the red slider is created here and added to "mypanel"
	 
	        button3 = new JButton("Reset Blue");
	        button3.setBounds(20, 180, 120, 30);
	        button3.setBackground(Color.CYAN);
	        button3.setFont(panelfont);
	        mypanel.add(button3);
	        //The button that moves the red slider is created here and added to "mypanel"
	 
	        resetall = new JButton("Reset All");
	        resetall.setBounds(20, 300, 120, 30);
	        resetall.setBackground(Color.WHITE);
	        resetall.setFont(panelfont);
	        mypanel.add(resetall);
	 
	        myslider = new JSlider(JSlider.HORIZONTAL, 0, 255, 0);
	        myslider.setBounds(150, 30, 300, 50);
	        myslider.setBackground(colour);
	        myslider.setMajorTickSpacing(50);
	        myslider.setMinorTickSpacing(5);
	        myslider.setPaintTicks(true);
	        myslider.setPaintLabels(true);
	        myslider.setFont(panelfont);
	        mypanel.add(myslider);
	        //The slider that controls the density of red is created here and added to "mypanel"
	 
	        myslider2 = new JSlider(JSlider.HORIZONTAL, 0, 255, 0);
	        myslider2.setBounds(150, 90, 300, 80);
	        myslider2.setBackground(colour);
	        myslider2.setMajorTickSpacing(50);
	        myslider2.setMinorTickSpacing(5);
	        myslider2.setPaintTicks(true);
	        myslider2.setPaintLabels(true);
	        myslider2.setFont(panelfont);
	        mypanel.add(myslider2);
	        //The slider that controls the density of green is created here and added to "mypanel"
	 
	        myslider3 = new JSlider(JSlider.HORIZONTAL, 0, 255, 0);
	        myslider3.setBounds(150, 150, 300, 110);
	        myslider3.setBackground(colour);
	        mypanel.add(myslider3);
	        myslider3.setMajorTickSpacing(50);
	        myslider3.setMinorTickSpacing(5);
	        myslider3.setPaintTicks(true);
	        myslider3.setPaintLabels(true);
	        myslider3.setFont(panelfont);
	        //The slider that controls the density of blue is created here and added to "mypanel"
	 
	        mylabels = new JLabel();
	        mylabels.setBounds(460, 45, 75, 30);
	        mylabels.setText("Colour: 00");
	        mypanel.add(mylabels);
	        mylabels.setFont(panelfont);
	        //The label that reset's the red slider is created and added to "mypanel"
	 
	        mylabels2 = new JLabel();
	        mylabels2.setBounds(460, 115, 75, 30);
	        mylabels2.setText("Colour: 00");
	        mypanel.add(mylabels2);
	        mylabels2.setFont(panelfont);
	        //The label that reset's the green slider is created and added to "mypanel"
	 
	        mylabels3 = new JLabel();
	        mylabels3.setBounds(460, 185, 75, 30);
	        mylabels3.setText("Colour: 00");
	        mypanel.add(mylabels3);
	        mylabels3.setFont(panelfont);
	        //The label that reset's the blue slider is created and added to "mypanel"
	 
	        hexcolour = new JLabel();
	        hexcolour.setBounds(170, 520, 70, 20);
	        hexcolour.setText("Colour: ");
	        mypanel.add(hexcolour);
	        hexcolour.setFont(panelfont);
	 
	        copytoclip = new JButton();
	        copytoclip.setBounds(300, 520, 120, 30);
	        copytoclip.setText("Copy Hex");
	        mypanel.add(copytoclip);
	        copytoclip.setFont(panelfont);
	        getRootPane().setDefaultButton(copytoclip);
	        copytoclip.setBackground(Color.WHITE);
	 
	        hex = new JTextField();
	        hex.setBounds(220, 520, 70, 20);
	        hex.setText(" ");
	        hex.setBackground(colour);
	        hex.setBorder(BorderFactory.createLineBorder(colour));
	        hex.copy();
	        mypanel.add(hex);
	        hex.setFont(panelfont);
	        hex.setBorder(BorderFactory.createMatteBorder(0, 0, 0, 0, Color.black));
	        //The label that shows the total hex colour is created and added to "mypanel"
	 
	        colourpatch = new JPanel();
	        colourpatch.setBounds(170, 270, 250, 250);
	        colourpatch.setBackground(Color.BLACK);
	        colourpatch.setBorder(BorderFactory.createLineBorder(Color.black));
	        mypanel.add(colourpatch);
	        colourpatch.setFont(panelfont);
	        //The panel in which projects the total colour is created and added to "mypanel"
	 
	        myslider.addChangeListener(this);
	        myslider2.addChangeListener(this);
	        myslider3.addChangeListener(this);
	        //Adding all 3 sliders to the change listener
	 
	        button.addActionListener(this);
	        button2.addActionListener(this);
	        button3.addActionListener(this);
	        resetall.addActionListener(this);
	        copytoclip.addActionListener(this);
	        //Adding all 3 buttons to the action listener
	 
	 
	    }
	 
	    public void actionPerformed(ActionEvent event) {
	 
	        if (event.getSource()==copytoclip) {
	        hex.copy();
	        hex.selectAll();
	        //!! hex.setHighlighter((Highlighter) Color.CYAN);
	        hex.requestFocusInWindow(); //!!
	        }
	         
	        if (event.getSource() == button) {
	            myslider.setValue(0);
	        }
	        //If "button" is pressed, "myslider" Value reset's to 0
	 
	        if (event.getSource() == button2) {
	            myslider2.setValue(0);
	        }
	        //If "button2" is pressed, "myslider2" Value reset's to 0
	 
	        if (event.getSource() == button3) {
	            myslider3.setValue(0);
	        }
	        ////If "button3" is pressed, "myslider3" Value reset's to 0
	 
	        if (event.getSource() == resetall){
	            myslider.setValue  (0);
	            myslider2.setValue (0);
	            myslider3.setValue (0);
	        }
	    }
	    public void stateChanged (ChangeEvent e) {
	 
	        int red;
	        int blue;
	        int green;
	        int reset;
	 
	        if (e.getSource() == myslider);
	 
	        red = (int) myslider.getValue();
	        blue = (int) myslider2.getValue();
	        green = (int) myslider3.getValue();
	        reset = (int) myslider.getValue();
	        reset = (int) myslider2.getValue();
	        reset = (int) myslider3.getValue();
	        //Storing the value's of each slider
	 
	        colourpatch.setBackground(new Color(red, blue, green));
	        //The panel where the created colour will be shown
	        mylabels.setText("Colour: " + myslider.getValue());
	        mylabels2.setText("Colour: " + myslider2.getValue());
	        mylabels3.setText("Colour: " + myslider3.getValue());
	        //Labels showing the colour of each slider
	        hex.setText("#" + Integer.toHexString(red) + Integer.toHexString(green) + Integer.toHexString(blue));
	        //Label showing the final colour as a Hexidecimal value
	    }
	}
