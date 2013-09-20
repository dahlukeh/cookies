package andrew.cookies.ui;

import java.awt.Color;
import java.awt.Frame;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.ParallelGroup;
import javax.swing.GroupLayout.SequentialGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.Timer;

import andrew.cookies.buildings.Building;
import andrew.cookies.buildings.BuildingFactory;
import andrew.cookies.game.Definitions;
import andrew.cookies.game.GameState;

public class MainScreen extends JFrame implements ActionListener {

	private static final long serialVersionUID = 6362354475690588421L;
	private static final String DEFAULT_TITLE = "";
	private static final int DEFAULT_WIDTH = 1280;
	private static final int DEFAULT_HEIGHT = 800;

	private GameState gs;
	private JButton cookie;
	private JButton[] buildings;
	private Building[] baseBuildings;
	private Timer t;

	public MainScreen(GameState gs) {
		super(DEFAULT_TITLE);
		setBackground(Color.BLACK);
		setBounds(10, 10, DEFAULT_WIDTH, DEFAULT_HEIGHT);
		setExtendedState(Frame.NORMAL);
		setUndecorated(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.gs = gs;
		setUp();
		t = new Timer(100, this);
		t.setActionCommand("tick");
		t.start();
	}

	private void setUp() {
		GroupLayout gl = new GroupLayout(getContentPane());
		setLayout(gl);
		gl.setAutoCreateContainerGaps(true);
		gl.setAutoCreateGaps(true);

		cookie = new JButton("");
		cookie.setActionCommand("click");
		cookie.addActionListener(this);

		baseBuildings = new BuildingFactory().getAllBuilding();
		buildings = new JButton[Definitions.AMOUNT_BUILDINGS];
		SequentialGroup buildingGroVer = gl.createSequentialGroup();
		ParallelGroup buildingGroHor = gl.createParallelGroup();
		for (int i = 0; i < Definitions.AMOUNT_BUILDINGS; i++) {
			buildings[i] = new JButton();
			buildings[i].setActionCommand("build " + i);
			buildings[i].addActionListener(this);
			buildingGroVer.addComponent(buildings[i]);
			buildingGroHor.addComponent(buildings[i]);
		}

		gl.setHorizontalGroup(gl.createSequentialGroup().addComponent(cookie).addGroup(buildingGroHor));
		gl.setVerticalGroup(gl.createParallelGroup().addComponent(cookie).addGroup(buildingGroVer));
	}

	public void tickOc() {
		gs.tick();
		setText();
		repaint();
	}

	private void setText() {
		cookie.setText(gs.getCurrentCookies() + " cookies\nper second" + gs.getTotalCPS() + "\nCLICK ME");
		for (int i = 0; i < Definitions.AMOUNT_BUILDINGS; i++) {
			buildings[i].setText(baseBuildings[i].getType().getName() + ": "
					+ gs.getCostOfBuilding(baseBuildings[i].getType()) + " - "
					+ gs.howManyOfBuilding(baseBuildings[i].getType()));
		}
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		String s = e.getActionCommand();
		if (s.equals("click")) {
			gs.clickCookie();
		} else if (s.equals("tick")) {
			tickOc();
		} else {
			String sp[] = s.split(" ");
			if (sp[0].equals("build")) {
				gs.buyBuilding(baseBuildings[Integer.parseInt(sp[1])].getType());
			}
		}
	}

}
