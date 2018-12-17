package TTGS;

/**
 *
 * @author Group 10
 */

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTabbedPane;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

public class ReportScreen extends TTGSModule implements ActionListener {

	JTabbedPane tabbedpane;

	
	public ReportScreen(TTGS ttgs) {
		
		super(ttgs, "ReportScreen", "toolbar/Repo16.png");
		
		// create tab
		tabbedpane = new JTabbedPane();
		getDemoPanel().add(tabbedpane, BorderLayout.CENTER);

		String name = getString("ReportScreen.dept");
		JLabel pix = new JLabel("");
		tabbedpane.add(name, pix);

		name = getString("ReportScreen.tch");
		pix = new JLabel("");
		tabbedpane.add(name, pix);

		name = getString("ReportScreen.stud");
		pix = new JLabel("");
		tabbedpane.add(name, pix);

		name = getString("ReportScreen.subj");
		pix = new JLabel("");
		tabbedpane.add(name, pix);

		name = getString("ReportScreen.room");
		pix = new JLabel("");
		tabbedpane.add(name, pix);

		tabbedpane.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent arg0) {
				JOptionPane.showMessageDialog(null, "You have selected tabbed "
						+ tabbedpane.getSelectedIndex(), "You Are in "
						+ tabbedpane.getSelectedIndex() + "Tab",
						JOptionPane.PLAIN_MESSAGE);
			}
		});
	}

	public void actionPerformed(ActionEvent arg0) {

	}

}
