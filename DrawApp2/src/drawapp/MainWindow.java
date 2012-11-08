package drawapp;


import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

public class MainWindow 
{
	Group root;
	Group gui;
	TextArea text;

	public static final int DEFAULT_WIDTH = 600;
	public static final int DEFAULT_HEIGHT = 300;

	private int width;
	private int height;

	public MainWindow(Group root)
	{
		this(root, DEFAULT_WIDTH, DEFAULT_HEIGHT);
	}

	public MainWindow(Group root, int width, int height)
	{
		this.root = root;
		this.width = width;
		this.height = height;
		setGUIGroup();
	}

	public void setGUIGroup()
	{
		gui = new Group();
		gui.setTranslateY(height - 150);
		gui.toFront();
		root.getChildren().add(gui);
	}

	public void buildGUI()
	{
		Rectangle rect = new Rectangle(width, 150);
		rect.setFill(Color.LIGHTGRAY);
		gui.getChildren().add(rect);
		
		text = new TextArea();
		text.setStyle("-fx-background-color: lightgray;");
		text.setWrapText(true);
		text.setPrefHeight(120);
		text.setPrefWidth(width);
		text.setEditable(false);
		
		Button button = new Button("Close");
		button.setPrefHeight(20);
		System.out.println(button.getPrefHeight());
		button.setLayoutY(150 - button.getPrefHeight() - 10);
		button.toFront();
		EventHandler<ActionEvent> close = new EventHandler<ActionEvent>() {
		
			@Override
			public void handle(ActionEvent event) {
				System.out.println("Close application");
				Platform.exit();		
			}
		};
		button.setOnAction(close);
		gui.getChildren().addAll(text, button);
		gui.toFront();
	}
	
	public void setText(String s)
	{
		
	}

	public void postMessage(String s) {
		text.setText(s);
		
	}


	/*

  private ImagePanel imagePanel;
  private JTextArea messageView;
  private JButton quitButton;

  public MainWindow()
  {
    this(DEFAULT_WIDTH, DEFAULT_HEIGHT);
  }

  public MainWindow(int width, int height)
  {
    super("Draw App");
    this.width = width;
    this.height = height;
    buildGUI();
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    this.pack();
    this.setVisible(true);
  }

  private void buildGUI()
  {
    JPanel backPanel = new JPanel();
    backPanel.setLayout(new BorderLayout());
    imagePanel = new ImagePanel(width, height);
    backPanel.add(imagePanel,BorderLayout.CENTER);

    messageView = new JTextArea();
    messageView.setRows(6);
    messageView.setEditable(false);
    JScrollPane scrollPane = new JScrollPane(messageView);

    JPanel lowerPanel = new JPanel();
    lowerPanel.setLayout(new BorderLayout());
    lowerPanel.add(scrollPane,BorderLayout.CENTER);

    JPanel buttonPanel = new JPanel();
    buttonPanel.setLayout(new FlowLayout());
    quitButton = new JButton("Close Window");
    buttonPanel.add(quitButton);
    quitButton.addActionListener(this);
    lowerPanel.add(buttonPanel,BorderLayout.SOUTH);

    backPanel.add(lowerPanel,BorderLayout.SOUTH);
    this.add(backPanel);
  }

  public ImagePanel getImagePanel()
  {
    return imagePanel;
  }

  public void postMessage(final String s)
  {
     SwingUtilities.invokeLater(
        new Runnable()
        {
          public void run()
          {
            messageView.append(s);
            messageView.repaint();
          }
        });
  }

  public void actionPerformed(ActionEvent actionEvent)
  {
    setVisible(false);
    dispose();
    System.exit(0);
  }*/
}