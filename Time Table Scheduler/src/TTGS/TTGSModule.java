package TTGS;

/**
 *
 * @author Group 10
 */

import java.awt.BorderLayout;
import java.util.MissingResourceException;
import java.util.ResourceBundle;

import javax.swing.Icon;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.UIManager;

import DataSourceKB.DataSet;
import TTGS.Timetable.TTGSGenerator;

/**
 * A generic com.TTGS demo module
 * 
 * @version 1.21 03/25/05
 * @author Jeff Dinkins
 */
public class TTGSModule{
 
	protected TTGS ttgs = null;
	private JPanel panel = null;
	private String resourceName = null;
	private String iconPath = null;

	// Resource bundle for internationalized and accessible text
	private ResourceBundle bundle = null;

	public TTGSModule(TTGS ttgs) {
		this(ttgs, null, null);
	}

	public TTGSModule(TTGS ttgs, String resourceName, String iconPath) {
		UIManager.put("swing.boldMetal", Boolean.FALSE);
		panel = new JPanel();
		panel.setLayout(new BorderLayout());

		this.resourceName = resourceName;
		this.iconPath = iconPath;
		this.ttgs = ttgs;
	}

	public String getResourceName() {
		return resourceName;
	}

	public JPanel getDemoPanel() {
		return panel;
	}

	public TTGS getTTGS() {
		return ttgs;
	}

	public DataSet getTTGSData() {
		return ttgs.MAIN;
	}

	public TTGSGenerator getTTGSGenerator() {
		ttgs.ttgsGen.SetData(getTTGSData());
		return ttgs.ttgsGen;
	}

	public void setTTGSData() {
		ttgs.MAIN = new DataSet();
	}

	public String getString(String key) {
		String value = "nada";
		if (bundle == null) {
			if (getTTGS() != null) {
				bundle = getTTGS().getResourceBundle();
			} else {
				bundle = ResourceBundle.getBundle("TTGS.resources.ttgs");
			}
		}
		try {
			value = bundle.getString(key);
		} catch (MissingResourceException e) {
			System.out.println("java.util.MissingResourceException: Couldn't find value for: "
							+ key);
		}
		return value;
	}

	public char getMnemonic(String key) {
		return (getString(key)).charAt(0);
	}

	public String getName() {
		return getString(getResourceName() + ".name");
	};

	public Icon getIcon() {
		return getTTGS().createImageIcon(iconPath, getResourceName() + ".name");
	};

	public String getToolTip() {
		return getString(getResourceName() + ".tooltip");
	};

	void updateDragEnabled(boolean dragEnabled) {
	}
	
	public void MSGBOX(String title, String msg,int type){
		JOptionPane.showMessageDialog(null,  msg, title, type);		
	}
}
