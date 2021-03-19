package Lists_zadachi7;

import javax.swing.*;
import java.awt.event.*;
import java.awt.*;

public class BallControl extends JPanel {
	private BallPanel ballPanel = new BallPanel();
	private JButton jbtSuspend = new JButton("Suspend");
	private JButton jbtResume = new JButton("Resume");
	private JButton jbtAdd = new JButton("+1");
	private JButton jbtSubtract = new JButton("-1");
	private JScrollBar jsbDelay = new JScrollBar();

	public BallControl() {
		// Group buttons in a panel
		JPanel panel = new JPanel();
		panel.add(jbtSuspend);
		panel.add(jbtResume);
		panel.add(jbtAdd);
		panel.add(jbtSubtract);
		// Add ball and buttons to the panel
		ballPanel.setBorder(new javax.swing.border.LineBorder(Color.red));
		jsbDelay.setOrientation(JScrollBar.HORIZONTAL);
		ballPanel.setDelay(jsbDelay.getMaximum());
		setLayout(new BorderLayout());
		add(jsbDelay, BorderLayout.NORTH);
		add(ballPanel, BorderLayout.CENTER);
		add(panel, BorderLayout.SOUTH);
		// Register listeners
		jbtSuspend.addActionListener(new Listener());
		jbtResume.addActionListener(new Listener());
		jbtAdd.addActionListener(new Listener());
		jbtSubtract.addActionListener(new Listener());
		jsbDelay.addAdjustmentListener(new AdjustmentListener() {
			@Override
			public void adjustmentValueChanged(AdjustmentEvent e) {
				ballPanel.setDelay(jsbDelay.getMaximum() - e.getValue());
			}
		});
		
		ballPanel.addMouseListener(new MouseListener() {

			@Override
			public void mouseClicked(MouseEvent e) {
				ballPanel.remove(new Point(e.getX(), e.getY()));
				
		}

			@Override
			public void mousePressed(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void mouseReleased(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void mouseEntered(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void mouseExited(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
		});
	}

	class Listener implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			if (e.getSource() == jbtSuspend)
				ballPanel.suspend();
			else if (e.getSource() == jbtResume)
				ballPanel.resume();
			else if (e.getSource() == jbtAdd)
				ballPanel.add();
			else if (e.getSource() == jbtSubtract)
				ballPanel.subtract();

		}
	}
}