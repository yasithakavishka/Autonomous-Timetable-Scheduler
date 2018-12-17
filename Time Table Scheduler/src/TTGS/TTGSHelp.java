package TTGS;

/**
 *
 * @author Group 10
 */

import javax.swing.*;
import java.awt.*;
import java.net.URL;
import java.net.MalformedURLException;
import java.io.*;
import javax.swing.text.*;
import javax.swing.event.*;

//Class : TTGSHelp
//Use   : Displays Help

public class TTGSHelp extends JDialog {

	public TTGSHelp(JFrame f) {
		super(f, "Help : com.TTGS	", true);
		setBounds(200, 100, 550, 400);
		HtmlPane html = new HtmlPane();
		setContentPane(html);
	}
}

class HtmlPane extends JScrollPane implements HyperlinkListener {
	JEditorPane html;

	public HtmlPane() {
		try {
			URL url = getClass().getResource("/resources/HelpFiles/index.html");
			html = new JEditorPane(url);
			html.setEditable(false);
			html.addHyperlinkListener(this);
			JViewport vp = getViewport();
			vp.add(html);
		} catch (MalformedURLException e) {
			System.out.println("Malformed URL: " + e);
		} catch (IOException e) {
			System.out.println("IOException: " + e);
		}
	}

	// Notification of a change relative to a
	// hyperlink.

	public void hyperlinkUpdate(HyperlinkEvent e) {
		if (e.getEventType() == HyperlinkEvent.EventType.ACTIVATED) {
			linkActivated(e.getURL());
		}
	}



	protected void linkActivated(URL u) {
		Cursor c = html.getCursor();
		Cursor waitCursor = Cursor.getPredefinedCursor(Cursor.WAIT_CURSOR);
		html.setCursor(waitCursor);
		SwingUtilities.invokeLater(new PageLoader(u, c));
	}

	class PageLoader implements Runnable {

		PageLoader(URL u, Cursor c) {
			url = u;
			cursor = c;
		}

		public void run() {
			if (url == null) {

				// restore the original cursor

				html.setCursor(cursor);

				// PENDING(prinz) remove this hack when
				// automatic validation is activated.

				Container parent = html.getParent();
				parent.repaint();
			} else {
				Document doc = html.getDocument();
				try {
					html.setPage(url);
				} catch (IOException ioe) {
					html.setDocument(doc);
					getToolkit().beep();
				} finally {

					// schedule the cursor to revert after
					// the paint has happended.

					url = null;
					SwingUtilities.invokeLater(this);
				}
			}
		}

		URL url;
		Cursor cursor;
	}

}
