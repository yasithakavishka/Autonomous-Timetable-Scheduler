package TTGS;

/**
 *
 * @author Group 10
 */

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Insets;
import java.awt.Rectangle;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ContainerEvent;
import java.awt.event.ContainerListener;
import java.io.File;
import java.lang.reflect.Constructor;
import java.net.URL;
import java.util.ArrayList;
import java.util.MissingResourceException;
import java.util.ResourceBundle;

import javax.swing.AbstractAction;
import javax.swing.Action;
import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JDialog;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JToggleButton;
import javax.swing.JToolBar;
import javax.swing.JWindow;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;
import javax.swing.border.EtchedBorder;
import javax.swing.filechooser.FileFilter;

import TTGS.Login.User;
import TTGS.Timetable.OutputGenerator;
import TTGS.Timetable.TTGSGenerator;

import DataSourceKB.DataSet;
import DataSourceKB.OPENKB;
import DataSourceKB.XMLKB;

public class TTGS extends JPanel {
	static TTGS ttgs;
    User user;
	File dir,xdir;
	JFileChooser jf;
	boolean IsAnynewFile, IsAnysaveFile;
	String openedFile="";
	JLabel stats = new JLabel("");

	DataSet MAIN;
	XMLKB toXML;
	TTGSGenerator ttgsGen;
	OutputGenerator og;
	OPENKB okb;


	// List of demos & UIScreens
	private ArrayList<TTGSModule> demosList = new ArrayList<TTGSModule>();

	// A place to hold on to the visible demo
	private TTGSModule currentDemo = null;
	private JPanel demoPanel = null;
	private JPanel sidePanel = null;

	// Status Bar
	private JTextField statusField = null;

	// Tool Bars
	private ToggleButtonToolBar toolbar = null;
	private ButtonToolBar btntoolbar = null;
	private ButtonGroup toolbarGroup = new ButtonGroup();

	// Used only if ttgs is an application
	private JFrame frame = null;

	private JWindow mySplash;

	// The preferred size of the demo
	private static final int PREFERRED_WIDTH = 800;
	private static final int PREFERRED_HEIGHT = 600;

	// Resource bundle for internationalized and accessible text
	private ResourceBundle bundle = null;

	private boolean dragEnabled = false;

	/**
	 * TTGS Main. An main application
	 */
	public static void main(String[] args) {

		// Create SwingSet on the default monitor
		JDialog.setDefaultLookAndFeelDecorated(true);
		JFrame.setDefaultLookAndFeelDecorated(true);

		UIManager.put("swing.boldMetal", Boolean.FALSE);
		ttgs = new TTGS();
		ttgs.showSplashScreen();
		ttgs.hideSplash();
		ttgs.showTTGS();
		ttgs.showAbout();
	}

	/**
	 * TTGS Constructor
	 */

	public TTGS() {
		String hd=System.getenv("HOMEDRIVE");
		String hp=System.getenv("HOMEPATH");
		String tp=hd+hp;

		IsAnynewFile = false;
		IsAnysaveFile = false;
		
		dir = new File(tp+"/My Documents/TTGS");
		if (!dir.isDirectory())	if (dir.mkdir()) {/*System.out.println("Created...");*/}
		xdir = new File(dir.getPath()+"/XML");
		if (!xdir.isDirectory()) if (xdir.mkdir()){/*System.out.println("Created...");*/}
		
		//System.out.println(tp);
        
		MAIN = new DataSet();
		toXML = new XMLKB();
		ttgsGen = new TTGSGenerator();

		frame = createFrame();
		mySplash = new JWindow();

		setLayout(new BorderLayout());

		// set the preferred size
		setPreferredSize(new Dimension(PREFERRED_WIDTH, PREFERRED_HEIGHT));

		initializeDemo();
		preloadFirstDemo();
		initFileChooser();
	}

	/**
	 * Creates Splash Screen & shows it.
	 */

	public void showSplashScreen() {
		JPanel content = (JPanel) mySplash.getContentPane();
		content.setLayout(new BorderLayout());
		content.setBackground(Color.WHITE);
		Dimension screen = Toolkit.getDefaultToolkit().getScreenSize();
		ImageIcon icn = createImageIcon("TTGS2.png", "");

		int width = icn.getIconWidth();
		int height = 270;
		int x = (screen.width - width) / 2;
		int y = (screen.height - height) / 2;
		mySplash.setBounds(x - 50, y, width + 100, height);

		JLabel label = new JLabel(icn);
		content.add(new JLabel(createImageIcon("WELCOME.GIF", "")),
				BorderLayout.NORTH);
		content.add(label, BorderLayout.CENTER);
		content.add(stats, BorderLayout.SOUTH);

		Color dColor = new Color(120, 122, 124, 255);
		content.setBorder(BorderFactory.createLineBorder(dColor, 10));

		mySplash.setVisible(true);
		setStatusSplash("Loading User Interface");
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

	}

	/**
	 * Hides the Splash Screen
	 */
	public void hideSplash() {
		setStatusSplash("Load completed.. WELCOME");
		mySplash.setVisible(false);
	}

	public void setStatusSplash(String thisStat) {
		if (stats.getText().equals("")) {
			stats.setText(thisStat);
			stats.setIcon(createImageIcon("Loading.gif", ""));
		} else {
			stats.setText(thisStat);
			stats.setIconTextGap(20);
			stats.setIcon(createImageIcon("Finish.gif", ""));
		}
	}

	/**
	 * Bring up the TTGS application by showing the frame
	 */

	public void showTTGS() {
		JFrame f = getFrame();
		f.setTitle(getString("Frame.title"));
		f.getContentPane().add(this, BorderLayout.CENTER);
		f.pack();
		Rectangle screenRect = f.getGraphicsConfiguration().getBounds();
		Insets screenInsets = Toolkit.getDefaultToolkit().getScreenInsets(
				f.getGraphicsConfiguration());

		// Make sure we don't place the demo off the screen.
		int centerWidth = screenRect.width < f.getSize().width ? screenRect.x
				: screenRect.x + screenRect.width / 2 - f.getSize().width / 2;
		int centerHeight = screenRect.height < f.getSize().height ? screenRect.y
				: screenRect.y + screenRect.height / 2 - f.getSize().height / 2;

		centerHeight = centerHeight < screenInsets.top ? screenInsets.top : centerHeight;

		f.setLocation(centerWidth, centerHeight);
		f.setVisible(true);
	}

	// *******************************************************
	// *************** Demo Loading Methods ******************
	// *******************************************************

	/**
	 * Loads a demo from a demos list
	 */
	void loadDemos(User user) {
		this.user=user;	
		if(user.getType().equalsIgnoreCase("admin")){
			loadDemo("MasterData");
			loadDemo("TimetableView");
			MAIN = new DataSet();
		}else{
			JOptionPane.showMessageDialog(null, "Only Administrator can access TTGS" +
					"\n For other users visit:  ");		
		}
	}

	/**
	 * Unloads all demos from a demos list & loads first demo
	 */
	void unloadDemos() {
		demosList.clear();
		toolbar.removeAll();
		toolbar.updateUI();
		preloadFirstDemo();
	}

	/**
	 * Loads a demo from a Class Name
	 */
	void loadDemo(String classname) {
		TTGSModule demo = null;
		try {
			Class demoClass = Class.forName("TTGS." + classname);
			Constructor demoConstructor = demoClass.getConstructor(new Class[] { TTGS.class });
			demo = (TTGSModule) demoConstructor.newInstance(new Object[] { this });
			addDemo(demo);

		} catch (Exception e) {
			System.out.println("Error occurred loading demo: " + classname);
		}
	}

	/**
	 * Adds a demo to a demos list
	 */
	public TTGSModule addDemo(TTGSModule demo) {
		demosList.add(demo);
		if (dragEnabled) {
			demo.updateDragEnabled(true);
		}

		// do the following on the GUI thread
		SwingUtilities.invokeLater(new TTGSRunnable(this, demo) {
			public void run() {

				SwitchToDemoAction action = new SwitchToDemoAction(ttgs,(TTGSModule) obj);
				JToggleButton tb = ttgs.getToggleButtonToolBar().addToggleButton(action);
				ttgs.getToolBarGroup().add(tb);
				if (ttgs.getToolBarGroup().getSelection() == null) {
					tb.setSelected(true);
					tb.setBackground(new Color(2, 255, 255, 255));
				}
				tb.setToolTipText(((TTGSModule) obj).getToolTip());
				tb.setText(null);
				tb.setBackground(new Color(255, 255, 255, 255));
				setStatus(getString("Splash.accessible_description"));
			}
		});
		return demo;
	}

	/**
	 * Load the first demo. This is done separately from the remaining demos so
	 * that we can get TTGS up and available to the user quickly.
	 */
	public void preloadFirstDemo() {
		TTGSModule demo = addDemo(new HomeScreen(this));
		setDemo(demo);
	}

	/**
	 * Loads the another demo. 
     */
	public void initializeDemo() {

		JPanel top = new JPanel();
		top.setLayout(new BorderLayout());
		add(top, BorderLayout.NORTH);

		ToolBarPanel toolbarPanel = new ToolBarPanel();
		toolbar = new ToggleButtonToolBar();
		btntoolbar = new ButtonToolBar();
		toolbarPanel.setLayout(new BorderLayout());
		toolbarPanel.add(toolbar, BorderLayout.CENTER);
		top.add(toolbarPanel, BorderLayout.SOUTH);
		toolbarPanel.addContainerListener(toolbarPanel);

		demoPanel = new JPanel();
		demoPanel.setLayout(new BorderLayout());
		demoPanel.setBorder(new EtchedBorder());
		add(demoPanel, BorderLayout.CENTER);

		sidePanel = new JPanel();
		sidePanel.setLayout(new BorderLayout());
		add(sidePanel, BorderLayout.EAST);

		statusField = new JTextField("");
		statusField.setEditable(false);
		add(statusField, BorderLayout.SOUTH);

	}

	/**
	 * Sets a demo as current demo
	 */
	public void setDemo(TTGSModule demo) {
		setStatus(getString("Splash.accessible_description") +" You are on "+ getString(demo.getName() + ".name"));
		setTitle(getString("Frame.title") +" >>"+ openedFile);
		currentDemo = demo;
		// Ensure panel's UI is current before making visible
		JComponent currentDemoPanel = demo.getDemoPanel();
		SwingUtilities.updateComponentTreeUI(currentDemoPanel);

		btntoolbar.setVisible(false);
		demoPanel.removeAll();
		sidePanel.removeAll();
		btntoolbar.updateUI();
		SwingUtilities.updateComponentTreeUI(demoPanel);
		demoPanel.add(currentDemoPanel, BorderLayout.CENTER);
		getSideButtonPanel(demo);
	}

	public void getSideButtonPanel(TTGSModule demo) {

		ToolBarPanel toolbarsidePanel = new ToolBarPanel();
		btntoolbar = new ButtonToolBar();
		btntoolbar.setOrientation(ButtonToolBar.VERTICAL);
		//System.out.print(demo.getName());
		if (demo.getName().equals("MasterData")) {// "MasterData"
			btntoolbar.addButton(" New", "New.gif");
			btntoolbar.addButton("Open", "Open.gif");
			btntoolbar.addButton("Save", "Save.gif");
			btntoolbar.addButton("Close", "Exit.gif");
		}
		if (demo.getName().equals("TimetableView")) {// "TimetableView"
			btntoolbar.addButton("Export to PDF", "");
			btntoolbar.addButton("Export to HTML", "");
			btntoolbar.addButton("Generate Timetable", "");
			btntoolbar.addButton("Close", "");
		}
		toolbarsidePanel.setLayout(new BorderLayout());
		toolbarsidePanel.add(btntoolbar, BorderLayout.CENTER);
		sidePanel.add(toolbarsidePanel, BorderLayout.NORTH);
		toolbarsidePanel.addContainerListener(toolbarsidePanel);
	}

	// *******************************************************
	// ****************** Utility Methods ********************
	// *******************************************************
	
	public void initFileChooser(){
		jf = new JFileChooser();
		jf.setCurrentDirectory(xdir);
		jf.setFileFilter(new FileFilter() {
			public boolean accept(File f) {
				return f.getName().toLowerCase().endsWith(XMLKB.ext) || f.isDirectory();
			}
			public String getDescription() {
				return "TTGS (XML) Files";
			}
		});
	}
	/**
	 * Returns the frame instance
	 */
	public JFrame getFrame() {
		return frame;
	}

	/**
	 * Create a frame for TTGS to reside in if brought up as an application.
	 */
	public static JFrame createFrame() {
		JFrame frame = new JFrame();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		return frame;
	}

	/**
	 * Set the Title
	 */
	public void setTitle(String s) {
		// do the following on the gui thread
		SwingUtilities.invokeLater(new TTGSRunnable(this, s) {
			public void run() {
				ttgs.frame.setTitle((String) obj);
			}
		});
	}

	/**
	 * Set the status
	 */
	public void setStatus(String s) {
		// do the following on the gui thread
		SwingUtilities.invokeLater(new TTGSRunnable(this, s) {
			public void run() {
				ttgs.statusField.setText((String) obj);
			}
		});
	}

	
	public ToggleButtonToolBar getToggleButtonToolBar() {
		return toolbar;
	}

	
	public ButtonGroup getToolBarGroup() {
		return toolbarGroup;
	}

	
	public String getString(String key) {
		String value = null;
		try {
			value = getResourceBundle().getString(key);
		} catch (MissingResourceException e) {
			System.out
					.println("java.util.MissingResourceException: Couldn't find value for: "
							+ key);
		}
		if (value == null) {
			value = "Could not find resource: " + key + "  ";
		}
		return value;
	}

	/**
	 * Returns the resource bundle associated with this demo. 
	 * Used to get accessible and internationalized strings.
	 */
	public ResourceBundle getResourceBundle() {
		if (bundle == null) {
			bundle = ResourceBundle.getBundle("resources.ttgs");
		}
		return bundle;
	}

	/**
	 * Returns a mnemonic from the resource bundle. 
	 * Typically used as keyboard shortcuts in menu items.
	 */
	public char getMnemonic(String key) {
		return (getString(key)).charAt(0);
	}

	/**
	 * Creates an icon from an image contained in the "images" directory.
	 */
	public ImageIcon createImageIcon(String filename, String description) {
		String path = "/resources/images/" + filename;
		return new ImageIcon(this.getClass().getResource(path));
	}

	// *******************************************************
	// ************** ToggleButtonToolbar ********************
	// **************    ButtonToolbar ***********************
	// *******************************************************

	static Insets zeroInsets = new Insets(1, 1, 1, 1);

	protected class ToggleButtonToolBar extends JToolBar {
		public ToggleButtonToolBar() {
			super();
		}

		JToggleButton addToggleButton(Action a) {
			JToggleButton tb = new JToggleButton((String) a
					.getValue(Action.NAME), (Icon) a
					.getValue(Action.SMALL_ICON));
			tb.setMargin(zeroInsets);
			tb.setText(null);
			tb.setEnabled(a.isEnabled());
			tb.setToolTipText((String) a.getValue(Action.SHORT_DESCRIPTION));
			tb.setAction(a);
			add(tb);
			return tb;
		}

	}

	protected class ButtonToolBar extends JToolBar {
		public ButtonToolBar() {
			super();
		}

		JButton addButton(String name, String icon_name) {
			JButton tb = new JButton(name, createImageIcon(icon_name, ""));
			tb.setMargin(zeroInsets);
			tb.setBorderPainted(false);
			tb.setText(name);
			tb.setToolTipText(name);
			if (name.contains("Close")) {
				tb.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent arg0) {
						if(openedFile!="")
						if (JOptionPane.YES_OPTION == JOptionPane.showConfirmDialog(null,
							"Are You Want To Close? file:"+openedFile, "Close!!!",JOptionPane.YES_NO_OPTION))
							CLOSEFILE();
						setTitle(getString("Frame.title") +" >>"+ openedFile);
					}
				});
			} else if (name.contains("New")) {
				tb.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent arg0) {
						CREATEFILE();
						setTitle(getString("Frame.title") +" >>"+ openedFile);
					}
				});
			} else if (name.contains("Open")) {
				tb.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent arg0) {
						OPENFILE();
						setTitle(getString("Frame.title") +" >>"+ openedFile);
					}
				});
			} else if (name.contains("Save")) {
				tb.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent arg0) {
						SAVEFILE();
					}
				});
			} else if (name.contains("PDF")) {
				tb.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent arg0) {
						og = new OutputGenerator(dir.getPath());
						og.SetData(MAIN, ttgsGen);
						og.AllPDF(ttgs.getFrame());
					}
				});
			} else if (name.contains("HTML")) {
				tb.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent arg0) {
						og = new OutputGenerator(dir.getPath());
						og.SetData(MAIN, ttgsGen);
						og.AllHTML(ttgs.getFrame());
					}
				});
			} else if (name.contains("Generate")) {
				tb.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent arg0) {
						// ttgsGen.SetData(MAIN);
						// ttgsGen.GenerateActivities();
						if (ttgsGen.isActivitiesGenerated()) {
							ttgsGen.MainAlgo(ttgs.getFrame());
						} else
							JOptionPane.showMessageDialog(null,"Generate Activities first!");

					}
				});
			}
			add(tb);
			return tb;
		}

	}

	// *******************************************************
	// ********* ToolBar Panel / Docking Listener ***********
	// *******************************************************

	class ToolBarPanel extends JPanel implements ContainerListener {

		public boolean contains(int x, int y) {
			Component c = getParent();
			if (c != null) {
				Rectangle r = c.getBounds();
				return (x >= 0) && (x < r.width) && (y >= 0) && (y < r.height);
			} else {
				return super.contains(x, y);
			}
		}

		public void componentAdded(ContainerEvent e) {
			Container c = e.getContainer().getParent();
			if (c != null) {
				c.getParent().validate();
				c.getParent().repaint();
			}
		}

		public void componentRemoved(ContainerEvent e) {
			Container c = e.getContainer().getParent();
			if (c != null) {
				c.getParent().validate();
				c.getParent().repaint();
			}
		}
	}

	
	class TTGSRunnable implements Runnable {
		protected TTGS ttgs;
		protected Object obj;

		public TTGSRunnable(TTGS ttgs, Object obj) {
			this.ttgs = ttgs;
			this.obj = obj;
		}

		public void run() {
		}
	}

	public class SwitchToDemoAction extends AbstractAction {
		TTGS ttgs;
		TTGSModule demo;

		public SwitchToDemoAction(TTGS ttgs, TTGSModule demo) {
			super(demo.getName(), demo.getIcon());
			this.ttgs = ttgs;
			this.demo = demo;
		}

		public void actionPerformed(ActionEvent e) {
			ttgs.setDemo(demo);
		}
	}


	// *******************************************************
	// ********* Create/Open/Save Files **********************
	// *******************************************************
	public void CLOSEFILE() {
		MAIN = new DataSet();
		toXML = new XMLKB();
		ttgsGen.SetData(MAIN);
		IsAnynewFile = false;
		IsAnysaveFile = false;
		openedFile="";
		
		if (JOptionPane.YES_OPTION == JOptionPane.showConfirmDialog(null,
			"Are You Want To Exit?"+openedFile, "Exit!!!",JOptionPane.YES_NO_OPTION))
				System.exit(0);
		
	}

	public void CREATEFILE() {
		if (!IsAnynewFile && !IsAnysaveFile && openedFile=="") {
			MAIN = new DataSet();
			toXML = new XMLKB();
			ttgsGen.SetData(MAIN);
			toXML.NewKB();
			IsAnynewFile = true;
			openedFile=new File(xdir.getPath()+"/temp"+XMLKB.ext).getPath();
 		    jf.setSelectedFile(new File(openedFile));
		} else if (openedFile!=""){
			JOptionPane.showMessageDialog(null,"Close first ! \nCan't Create New File", 
					"New File-Error",JOptionPane.ERROR_MESSAGE);
		}else if (!IsAnysaveFile){
			JOptionPane.showMessageDialog(null,"Save first ! \nCan't Create New File", 
					"New File-Error",JOptionPane.ERROR_MESSAGE);
		}
	}

	public void OPENFILE() {
		String openFile;
		if (openedFile=="") {
			int returnVal = jf.showOpenDialog(null);
			if (returnVal == JFileChooser.APPROVE_OPTION) {
				openFile = jf.getSelectedFile().getPath();
				if (isXmlFileExist(openFile)) {
					okb = new OPENKB(ttgs);
					openedFile = openFile;
					okb.readData(openFile);
					ttgsGen.SetData(MAIN);
					setDemo(new MasterData(ttgs));
				} else {
					JOptionPane.showMessageDialog(null, "Can't Open File :"	+ openFile, 
							"Open File-Error",JOptionPane.ERROR_MESSAGE);
				}
			}
		}else {
			JOptionPane.showMessageDialog(null, "Close Opened File :"	+ openedFile, 
					"Close File First",JOptionPane.ERROR_MESSAGE);
		}
		ttgs.updateUI();
	}

	public void SAVEFILE() {
		String saveFile;
		if (IsAnynewFile && !IsAnysaveFile) {
			int returnVal = jf.showSaveDialog(null);
			if (returnVal == JFileChooser.APPROVE_OPTION) {
				saveFile = jf.getSelectedFile().getPath();
				toXML.SaveKB(saveFile, MAIN);
				IsAnysaveFile = true;
			    MAIN.setStatus(true);
			    JOptionPane.showMessageDialog(null, "File saved successfully!"	, 
						"Saved File",JOptionPane.INFORMATION_MESSAGE);
			}
		}else if (!MAIN.getStatus() && openedFile!=""){
			toXML.NewKB();
			toXML.SaveKB(openedFile, MAIN);
			IsAnysaveFile = true;
		    MAIN.setStatus(true);
		    JOptionPane.showMessageDialog(null, "File saved successfully!"	, 
					"Saved File",JOptionPane.INFORMATION_MESSAGE);
		}else if (openedFile==""){
			JOptionPane.showMessageDialog(null, "No opened file to save"	, 
					"Save File Error",JOptionPane.ERROR_MESSAGE);
		}			
	}

	public boolean isXmlFileExist(String xmlfile) {
		return (new File(xmlfile).exists());
	}

	public void showAbout() {
		// About Box
		URL img = getClass().getResource("/resources/images/toolbar/Abo32.png");
		URL img1 = getClass().getResource("/resources/images/Logo2.gif");

		String s0 = "<html><body bgcolor=\"#ffffff\"><img src=\"" + img + "\">";
		String s1 = "<table border=0 ><tr><td align=\"center\"><img src=\""
				+ img1 + "\">";
		String s2 = "<table border=0><tr><td>The TTGS Team : </td><td>Group 10 </td></tr>";
		String s3 = "<tr><td>Jazeel Ismail (E/14/144)<br>Kavishka Karunasinghe (E/14/178)<br>Hashan Kavinda (E/14/181)<br>"
                        + "Nethmal Warusamana (E/14/364)</td>";
		String s4 = "<td></td></tr></table></td></tr></table>"
				//+ getString("AboutBox.accessible_description")
				+ "</body></html>";

		String ABOUTMSG = s0 + s1 + s2 + s3 + s4;

		JOptionPane.showMessageDialog(null, ABOUTMSG,
				getString("AboutBox.title"), JOptionPane.PLAIN_MESSAGE);

	}
}
