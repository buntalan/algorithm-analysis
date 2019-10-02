package sortingAnalysis;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.Color;

import javax.swing.border.EtchedBorder;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import net.miginfocom.swing.MigLayout;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.Arrays;
import java.awt.event.ActionEvent;
import java.awt.Font;
import javax.swing.border.TitledBorder;
import javax.swing.JTextPane;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.JLabel;


public class AnalysisFrame extends JFrame implements ActionListener{

	private static final long serialVersionUID = 1L;
	private JFrame AnalysisPane;
	private JPanel efficientPanel;
	private JTextPane efficientText;
	private JPanel propertiesPanel;
	private JTextField numberElementsText;
	private JButton createList;
	private JPanel radioMenuPanel;
	private JRadioButton rdbtnInOrder;
	private JRadioButton rdbtnReverseOrder;
	private JRadioButton rdbtnSomeOrder;
	private JRadioButton rdbtnRandom;
	private JPanel buttonPanel;
	private JButton insertionButton;
	private JButton selectionButton;
	private JButton quickButton;
	private JButton mergeButton;
	private JButton heapButton;
	private JButton radixButton;
	private JPanel resultsPanel;
	private JLabel lblN;
	private JTextPane nText;
	private JLabel lblDataType;
	private JTextPane datatypeText;
	private JLabel lblSort;
	private JTextPane sortText;
	private JLabel lblComparisons;
	private JTextPane comparisonsText;
	private JLabel lblMovements;
	private JTextPane movementsText;
	private JLabel lblTotalTime;
	private JTextPane timeText;
	private final ButtonGroup sortGroup = new ButtonGroup();
	private final ButtonGroup listGroup = new ButtonGroup();
	private ListGenerator list;
	private int[] randomList;
	private int[] inOrderList;
	private int[] reverseOrderList;
	private int[] someOrderList;
	private long mostEfficient = 0;;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AnalysisFrame window = new AnalysisFrame();
					window.AnalysisPane.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public AnalysisFrame() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		AnalysisPane = new JFrame();
		AnalysisPane.setBounds(100, 100, 1024, 760);
		AnalysisPane.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[]{0, 350, 0};
		gridBagLayout.rowHeights = new int[]{50, 250, 250, 0};
		gridBagLayout.columnWeights = new double[]{1.0, 1.0, Double.MIN_VALUE};
		gridBagLayout.rowWeights = new double[]{1.0, 1.0, 1.0, Double.MIN_VALUE};
		AnalysisPane.getContentPane().setLayout(gridBagLayout);
		
		// Efficient Panel
		efficientPanel = new JPanel();
		efficientPanel.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), "Winning Algorithm", TitledBorder.CENTER, TitledBorder.TOP, null, new Color(0, 0, 0)));
		GridBagConstraints gbc_efficientPanel = new GridBagConstraints();
		gbc_efficientPanel.insets = new Insets(0, 0, 5, 0);
		gbc_efficientPanel.fill = GridBagConstraints.BOTH;
		gbc_efficientPanel.gridx = 1;
		gbc_efficientPanel.gridy = 0;
		AnalysisPane.getContentPane().add(efficientPanel, gbc_efficientPanel);
		GridBagLayout gbl_efficientPanel = new GridBagLayout();
		gbl_efficientPanel.columnWidths = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 25, 0, 0, 0};
		gbl_efficientPanel.rowHeights = new int[]{0, 0, 0, 0, 0, 25, 0};
		gbl_efficientPanel.columnWeights = new double[]{0.0, 0.0, 0.0, 1.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		gbl_efficientPanel.rowWeights = new double[]{0.0, 1.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		efficientPanel.setLayout(gbl_efficientPanel);
		
		efficientText = new JTextPane();
		efficientText.setText("Enter value into the text box below");
		GridBagConstraints gbc_efficientText = new GridBagConstraints();
		gbc_efficientText.insets = new Insets(0, 0, 5, 5);
		gbc_efficientText.gridheight = 3;
		gbc_efficientText.gridwidth = 9;
		gbc_efficientText.fill = GridBagConstraints.BOTH;
		gbc_efficientText.gridx = 3;
		gbc_efficientText.gridy = 1;
		efficientPanel.add(efficientText, gbc_efficientText);
		
		// Properties Panel
		propertiesPanel = new JPanel();
		propertiesPanel.setBorder(new TitledBorder(null, "List Properties", TitledBorder.CENTER, TitledBorder.TOP, null, null));
		GridBagConstraints gbc_propertiesPanel = new GridBagConstraints();
		gbc_propertiesPanel.insets = new Insets(0, 0, 5, 0);
		gbc_propertiesPanel.fill = GridBagConstraints.BOTH;
		gbc_propertiesPanel.gridx = 1;
		gbc_propertiesPanel.gridy = 1;
		AnalysisPane.getContentPane().add(propertiesPanel, gbc_propertiesPanel);
		GridBagLayout gbl_propertiesPanel = new GridBagLayout();
		gbl_propertiesPanel.columnWidths = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
		gbl_propertiesPanel.rowHeights = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
		gbl_propertiesPanel.columnWeights = new double[]{0.0, 0.0, 1.0, 1.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		gbl_propertiesPanel.rowWeights = new double[]{0.0, 1.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		propertiesPanel.setLayout(gbl_propertiesPanel);
		
		radioMenuPanel = new JPanel();
		radioMenuPanel.setBorder(null);
		GridBagConstraints gbc_radioMenuPanel = new GridBagConstraints();
		gbc_radioMenuPanel.gridheight = 3;
		gbc_radioMenuPanel.gridwidth = 5;
		gbc_radioMenuPanel.insets = new Insets(0, 0, 5, 5);
		gbc_radioMenuPanel.fill = GridBagConstraints.BOTH;
		gbc_radioMenuPanel.gridx = 2;
		gbc_radioMenuPanel.gridy = 1;
		propertiesPanel.add(radioMenuPanel, gbc_radioMenuPanel);
		
		rdbtnInOrder = new JRadioButton("InOrder");
		listGroup.add(rdbtnInOrder);
		rdbtnInOrder.addActionListener(this);
		radioMenuPanel.add(rdbtnInOrder);
		
		rdbtnReverseOrder = new JRadioButton("ReverseOrder");
		listGroup.add(rdbtnReverseOrder);
		rdbtnReverseOrder.addActionListener(this);
		radioMenuPanel.add(rdbtnReverseOrder);
		
		rdbtnSomeOrder = new JRadioButton("SomeOrder");
		listGroup.add(rdbtnSomeOrder);
		rdbtnSomeOrder.addActionListener(this);
		radioMenuPanel.add(rdbtnSomeOrder);
		
		rdbtnRandom = new JRadioButton("Random");
		listGroup.add(rdbtnRandom);
		rdbtnRandom.addActionListener(this);
		radioMenuPanel.add(rdbtnRandom);
		
		
		numberElementsText = new JTextField();
		numberElementsText.setText("0");
		GridBagConstraints gbc_numberElementsText = new GridBagConstraints();
		gbc_numberElementsText.gridwidth = 5;
		gbc_numberElementsText.insets = new Insets(0, 0, 5, 5);
		gbc_numberElementsText.fill = GridBagConstraints.HORIZONTAL;
		gbc_numberElementsText.gridx = 2;
		gbc_numberElementsText.gridy = 5;
		propertiesPanel.add(numberElementsText, gbc_numberElementsText);
		numberElementsText.setColumns(10);
		
		createList = new JButton("CreateList");
		createList.addActionListener(this);
		createList.setFont(new Font("Tahoma", Font.PLAIN, 15));
		GridBagConstraints gbc_createList = new GridBagConstraints();
		gbc_createList.gridheight = 3;
		gbc_createList.fill = GridBagConstraints.BOTH;
		gbc_createList.gridwidth = 5;
		gbc_createList.insets = new Insets(0, 0, 0, 5);
		gbc_createList.gridx = 2;
		gbc_createList.gridy = 6;
		propertiesPanel.add(createList, gbc_createList);
		
		
		// Button Panel
		buttonPanel = new JPanel();
		buttonPanel.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		GridBagConstraints gbc_buttonPanel = new GridBagConstraints();
		gbc_buttonPanel.gridheight = 3;
		gbc_buttonPanel.insets = new Insets(0, 0, 0, 5);
		gbc_buttonPanel.fill = GridBagConstraints.BOTH;
		gbc_buttonPanel.gridx = 0;
		gbc_buttonPanel.gridy = 0;
		AnalysisPane.getContentPane().add(buttonPanel, gbc_buttonPanel);
		buttonPanel.setLayout(new MigLayout("", "[25][100][100][100][100][25]", "[25][100.00][100.00][100.00][100.00][100][100][25]"));
		
		insertionButton = new JButton("Insertion Sort");
		sortGroup.add(insertionButton);
		insertionButton.addActionListener(this);
		insertionButton.setFont(new Font("Tahoma", Font.PLAIN, 20));
		buttonPanel.add(insertionButton, "cell 1 1 4 1,grow");
		
		selectionButton = new JButton("Selection Sort");
		sortGroup.add(selectionButton);
		selectionButton.addActionListener(this);
		selectionButton.setFont(new Font("Tahoma", Font.PLAIN, 20));
		buttonPanel.add(selectionButton, "cell 1 2 4 1,grow");
		
		quickButton = new JButton("Quick Sort");
		sortGroup.add(quickButton);
		quickButton.addActionListener(this);
		quickButton.setFont(new Font("Tahoma", Font.PLAIN, 20));
		buttonPanel.add(quickButton, "cell 1 3 4 1,grow");
		
		mergeButton = new JButton("Merge Sort");
		sortGroup.add(mergeButton);
		mergeButton.addActionListener(this);
		mergeButton.setFont(new Font("Tahoma", Font.PLAIN, 20));
		buttonPanel.add(mergeButton, "cell 1 4 4 1,grow");
		
		heapButton = new JButton("Heap Sort");
		sortGroup.add(heapButton);
		heapButton.addActionListener(this);
		heapButton.setFont(new Font("Tahoma", Font.PLAIN, 20));
		buttonPanel.add(heapButton, "cell 1 5 4 1,grow");
		
		radixButton = new JButton("Radix Sort");
		sortGroup.add(radixButton);
		radixButton.addActionListener(this);
		radixButton.setFont(new Font("Tahoma", Font.PLAIN, 20));
		buttonPanel.add(radixButton, "cell 1 6 4 1,grow");
		
		
		// Results Panel
		resultsPanel = new JPanel();
		resultsPanel.setBorder(new TitledBorder(null, "Experimental Results", TitledBorder.CENTER, TitledBorder.TOP, null, null));
		GridBagConstraints gbc_resultsPanel = new GridBagConstraints();
		gbc_resultsPanel.fill = GridBagConstraints.BOTH;
		gbc_resultsPanel.gridx = 1;
		gbc_resultsPanel.gridy = 2;
		AnalysisPane.getContentPane().add(resultsPanel, gbc_resultsPanel);
		GridBagLayout gbl_resultsPanel = new GridBagLayout();
		gbl_resultsPanel.columnWidths = new int[]{0, 0, 0, 0, 0, 0, 0, 150, 0, 0};
		gbl_resultsPanel.rowHeights = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0};
		gbl_resultsPanel.columnWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 1.0, Double.MIN_VALUE};
		gbl_resultsPanel.rowWeights = new double[]{0.0, 0.0, 1.0, 1.0, 1.0, 1.0, 1.0, 0.0, Double.MIN_VALUE};
		resultsPanel.setLayout(gbl_resultsPanel);
		
		lblN = new JLabel("N:");
		lblN.setFont(new Font("Tahoma", Font.PLAIN, 14));
		GridBagConstraints gbc_lblN = new GridBagConstraints();
		gbc_lblN.anchor = GridBagConstraints.EAST;
		gbc_lblN.insets = new Insets(0, 0, 5, 5);
		gbc_lblN.gridx = 6;
		gbc_lblN.gridy = 1;
		resultsPanel.add(lblN, gbc_lblN);
		
		nText = new JTextPane();
		GridBagConstraints gbc_nText = new GridBagConstraints();
		gbc_nText.insets = new Insets(0, 0, 5, 5);
		gbc_nText.fill = GridBagConstraints.BOTH;
		gbc_nText.gridx = 7;
		gbc_nText.gridy = 1;
		resultsPanel.add(nText, gbc_nText);
		
		lblDataType = new JLabel("DataType:");
		lblDataType.setFont(new Font("Tahoma", Font.PLAIN, 14));
		GridBagConstraints gbc_lblDataType = new GridBagConstraints();
		gbc_lblDataType.anchor = GridBagConstraints.EAST;
		gbc_lblDataType.insets = new Insets(0, 0, 5, 5);
		gbc_lblDataType.gridx = 6;
		gbc_lblDataType.gridy = 2;
		resultsPanel.add(lblDataType, gbc_lblDataType);
		
		datatypeText = new JTextPane();
		GridBagConstraints gbc_datatypeText = new GridBagConstraints();
		gbc_datatypeText.insets = new Insets(0, 0, 5, 5);
		gbc_datatypeText.fill = GridBagConstraints.BOTH;
		gbc_datatypeText.gridx = 7;
		gbc_datatypeText.gridy = 2;
		resultsPanel.add(datatypeText, gbc_datatypeText);
		
		lblSort = new JLabel("Sort:");
		lblSort.setFont(new Font("Tahoma", Font.PLAIN, 14));
		GridBagConstraints gbc_lblSort = new GridBagConstraints();
		gbc_lblSort.anchor = GridBagConstraints.EAST;
		gbc_lblSort.insets = new Insets(0, 0, 5, 5);
		gbc_lblSort.gridx = 6;
		gbc_lblSort.gridy = 3;
		resultsPanel.add(lblSort, gbc_lblSort);
		
		sortText = new JTextPane();
		GridBagConstraints gbc_sortText = new GridBagConstraints();
		gbc_sortText.insets = new Insets(0, 0, 5, 5);
		gbc_sortText.fill = GridBagConstraints.BOTH;
		gbc_sortText.gridx = 7;
		gbc_sortText.gridy = 3;
		resultsPanel.add(sortText, gbc_sortText);
		
		lblComparisons = new JLabel("Comparisons:");
		lblComparisons.setFont(new Font("Tahoma", Font.PLAIN, 14));
		GridBagConstraints gbc_lblComparisons = new GridBagConstraints();
		gbc_lblComparisons.anchor = GridBagConstraints.EAST;
		gbc_lblComparisons.insets = new Insets(0, 0, 5, 5);
		gbc_lblComparisons.gridx = 6;
		gbc_lblComparisons.gridy = 4;
		resultsPanel.add(lblComparisons, gbc_lblComparisons);
		
		comparisonsText = new JTextPane();
		GridBagConstraints gbc_comparisonsText = new GridBagConstraints();
		gbc_comparisonsText.insets = new Insets(0, 0, 5, 5);
		gbc_comparisonsText.fill = GridBagConstraints.BOTH;
		gbc_comparisonsText.gridx = 7;
		gbc_comparisonsText.gridy = 4;
		resultsPanel.add(comparisonsText, gbc_comparisonsText);
		
		lblMovements = new JLabel("Movements:");
		lblMovements.setFont(new Font("Tahoma", Font.PLAIN, 14));
		GridBagConstraints gbc_lblMovements = new GridBagConstraints();
		gbc_lblMovements.anchor = GridBagConstraints.EAST;
		gbc_lblMovements.insets = new Insets(0, 0, 5, 5);
		gbc_lblMovements.gridx = 6;
		gbc_lblMovements.gridy = 5;
		resultsPanel.add(lblMovements, gbc_lblMovements);
		
		movementsText = new JTextPane();
		GridBagConstraints gbc_movementsText = new GridBagConstraints();
		gbc_movementsText.insets = new Insets(0, 0, 5, 5);
		gbc_movementsText.fill = GridBagConstraints.BOTH;
		gbc_movementsText.gridx = 7;
		gbc_movementsText.gridy = 5;
		resultsPanel.add(movementsText, gbc_movementsText);
		
		lblTotalTime = new JLabel("Total Time:");
		lblTotalTime.setFont(new Font("Tahoma", Font.PLAIN, 14));
		GridBagConstraints gbc_lblTotalTime = new GridBagConstraints();
		gbc_lblTotalTime.anchor = GridBagConstraints.EAST;
		gbc_lblTotalTime.insets = new Insets(0, 0, 5, 5);
		gbc_lblTotalTime.gridx = 6;
		gbc_lblTotalTime.gridy = 6;
		resultsPanel.add(lblTotalTime, gbc_lblTotalTime);
		
		timeText = new JTextPane();
		GridBagConstraints gbc_timeText = new GridBagConstraints();
		gbc_timeText.insets = new Insets(0, 0, 5, 5);
		gbc_timeText.fill = GridBagConstraints.BOTH;
		gbc_timeText.gridx = 7;
		gbc_timeText.gridy = 6;
		resultsPanel.add(timeText, gbc_timeText);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// Properties Panel
		// Create List Button
		if (e.getSource() == createList)
		{
			if (numberElementsText.getText().contentEquals("0") || numberElementsText.getText().isEmpty())
			{
				// Do nothing when no elements specified
			}
			else
			{
				efficientText.setText("Select a sorting algorithm and number list");
				mostEfficient = 0;
				
				// Create list
				list = new ListGenerator(Integer.parseInt(numberElementsText.getText()));
				inOrderList = list.sortAscending();
				reverseOrderList = list.sortDescending();
				someOrderList = list.sortTwenty();
				randomList = list.getNumberList();
			}
		}
		
		// Button Panel
		// Insertion Button
		if (e.getSource() == insertionButton)
		{
			if (ListGenerator.getInstances() > 0)
			{
				if (rdbtnInOrder.isSelected())
				{
					int[] numberList = Arrays.copyOf(inOrderList, inOrderList.length);
					
					long startTime = System.nanoTime();
					InsertionSort.insertionSort(numberList);
					long endTime = System.nanoTime();

					nText.setText((numberList.length) + "");
					datatypeText.setText(rdbtnInOrder.getText());
					sortText.setText("Insertion Sort");
					comparisonsText.setText(InsertionSort.getComparisons() + "");
					movementsText.setText(InsertionSort.getMovements() + "");
					timeText.setText((endTime - startTime) + "ns");
					
					if (mostEfficient == 0)
					{
						mostEfficient = endTime - startTime;
					}
					else if (mostEfficient > (endTime-startTime))
					{
						mostEfficient = endTime-startTime;
						efficientText.setText("Insertion Sort");
					}
				}
				else if (rdbtnReverseOrder.isSelected())
				{
					int[] numberList = Arrays.copyOf(reverseOrderList, reverseOrderList.length);
					
					long startTime = System.nanoTime();
					InsertionSort.insertionSort(numberList);
					long endTime = System.nanoTime();

					nText.setText((numberList.length) + "");
					datatypeText.setText(rdbtnReverseOrder.getText());
					sortText.setText("Insertion Sort");
					comparisonsText.setText(InsertionSort.getComparisons() + "");
					movementsText.setText(InsertionSort.getMovements() + "");
					timeText.setText((endTime - startTime) + "ns");
					
					if (mostEfficient == 0)
					{
						mostEfficient = endTime - startTime;
					}
					else if (mostEfficient > (endTime-startTime))
					{
						mostEfficient = endTime-startTime;
						efficientText.setText("Insertion Sort");
					}
				}
				else if (rdbtnSomeOrder.isSelected())
				{
					int[] numberList = Arrays.copyOf(someOrderList, someOrderList.length);
					
					long startTime = System.nanoTime();
					InsertionSort.insertionSort(numberList);
					long endTime = System.nanoTime();

					nText.setText((numberList.length) + "");
					datatypeText.setText(rdbtnSomeOrder.getText());
					sortText.setText("Insertion Sort");
					comparisonsText.setText(InsertionSort.getComparisons() + "");
					movementsText.setText(InsertionSort.getMovements() + "");
					timeText.setText((endTime - startTime) + "ns");
					
					if (mostEfficient == 0)
					{
						mostEfficient = endTime - startTime;
					}
					else if (mostEfficient > (endTime-startTime))
					{
						mostEfficient = endTime-startTime;
						efficientText.setText("Insertion Sort");
					}
				}
				else if (rdbtnRandom.isSelected())
				{
					int[] numberList = Arrays.copyOf(randomList, randomList.length);
					
					long startTime = System.nanoTime();
					InsertionSort.insertionSort(numberList);
					long endTime = System.nanoTime();

					nText.setText((numberList.length) + "");
					datatypeText.setText(rdbtnRandom.getText());
					sortText.setText("Insertion Sort");
					comparisonsText.setText(InsertionSort.getComparisons() + "");
					movementsText.setText(InsertionSort.getMovements() + "");
					timeText.setText((endTime - startTime) + "ns");
					
					if (mostEfficient == 0)
					{
						mostEfficient = endTime - startTime;
					}
					else if (mostEfficient > (endTime-startTime))
					{
						mostEfficient = endTime-startTime;
						efficientText.setText("Insertion Sort");
					}
				}
			}
			else
			{
				// Do nothing if no instances of List is created
			}
		}
		
		// SelectionSort button
		else if (e.getSource() == selectionButton)
		{
			if (ListGenerator.getInstances() > 0)
			{
				if (rdbtnInOrder.isSelected()) 
				{
					int[] numberList = Arrays.copyOf(inOrderList, inOrderList.length);
					
					long startTime = System.nanoTime();
					SelectionSort.selectionSort(numberList);
					long endTime = System.nanoTime();
					

					nText.setText((numberList.length) + "");
					datatypeText.setText(rdbtnInOrder.getText());
					sortText.setText("Selection Sort");
					comparisonsText.setText(SelectionSort.getComparisons() + "");
					movementsText.setText(SelectionSort.getMovements() + "");
					timeText.setText((endTime - startTime) + "ns");
					
					if (mostEfficient == 0)
					{
						mostEfficient = endTime - startTime;
					}
					else if (mostEfficient > (endTime-startTime))
					{
						mostEfficient = endTime-startTime;
						efficientText.setText("Selection Sort");
					}
				}
				else if (rdbtnReverseOrder.isSelected())
				{
					int[] numberList = Arrays.copyOf(reverseOrderList, reverseOrderList.length);
					
					long startTime = System.nanoTime();
					SelectionSort.selectionSort(numberList);
					long endTime = System.nanoTime();
					

					nText.setText((numberList.length) + "");
					datatypeText.setText(rdbtnReverseOrder.getText());
					sortText.setText("Selection Sort");
					comparisonsText.setText(SelectionSort.getComparisons() + "");
					movementsText.setText(SelectionSort.getMovements() + "");
					timeText.setText((endTime - startTime) + "ns");
					
					if (mostEfficient == 0)
					{
						mostEfficient = endTime - startTime;
					}
					else if (mostEfficient > (endTime-startTime))
					{
						mostEfficient = endTime-startTime;
						efficientText.setText("Selection Sort");
					}
				}
				else if (rdbtnSomeOrder.isSelected())
				{
					int[] numberList = Arrays.copyOf(someOrderList, someOrderList.length);
					
					long startTime = System.nanoTime();
					SelectionSort.selectionSort(numberList);
					long endTime = System.nanoTime();
					

					nText.setText((numberList.length) + "");
					datatypeText.setText(rdbtnSomeOrder.getText());
					sortText.setText("Selection Sort");
					comparisonsText.setText(SelectionSort.getComparisons() + "");
					movementsText.setText(SelectionSort.getMovements() + "");
					timeText.setText((endTime - startTime) + "ns");
					
					if (mostEfficient == 0)
					{
						mostEfficient = endTime - startTime;
					}
					else if (mostEfficient > (endTime-startTime))
					{
						mostEfficient = endTime-startTime;
						efficientText.setText("Selection Sort");
					}
				}
				else if (rdbtnRandom.isSelected())
				{
					int[] numberList = Arrays.copyOf(randomList, randomList.length);
					
					long startTime = System.nanoTime();
					SelectionSort.selectionSort(numberList);
					long endTime = System.nanoTime();
					

					nText.setText((numberList.length) + "");
					datatypeText.setText(rdbtnRandom.getText());
					sortText.setText("Selection Sort");
					comparisonsText.setText(SelectionSort.getComparisons() + "");
					movementsText.setText(SelectionSort.getMovements() + "");
					timeText.setText((endTime - startTime) + "ns");
					
					if (mostEfficient == 0)
					{
						mostEfficient = endTime - startTime;
					}
					else if (mostEfficient > (endTime-startTime))
					{
						mostEfficient = endTime-startTime;
						efficientText.setText("Selection Sort");
					}
				}
			}
			else
			{
				// Do nothing if no instances of ListGenerator is created
			}
		}
		
		
		// Quick Sort button
		else if (e.getSource() == quickButton)
		{
			if (ListGenerator.getInstances() > 0)
			{
				if (rdbtnInOrder.isSelected()) 
				{
					int[] numberList = Arrays.copyOf(inOrderList, inOrderList.length);
					
					long startTime = System.nanoTime();
					QuickSort.quickSort(numberList);
					long endTime = System.nanoTime();
					

					nText.setText((numberList.length) + "");
					datatypeText.setText(rdbtnInOrder.getText());
					sortText.setText("Quick Sort");
					comparisonsText.setText(QuickSort.getComparisons() + "");
					movementsText.setText(QuickSort.getMovements() + "");
					timeText.setText((endTime - startTime) + "ns");
					
					if (mostEfficient == 0)
					{
						mostEfficient = endTime - startTime;
					}
					else if (mostEfficient > (endTime-startTime))
					{
						mostEfficient = endTime-startTime;
						efficientText.setText("Quick Sort");
					}
				}
				else if (rdbtnReverseOrder.isSelected())
				{
					int[] numberList = Arrays.copyOf(reverseOrderList, reverseOrderList.length);
					
					long startTime = System.nanoTime();
					QuickSort.quickSort(numberList);
					long endTime = System.nanoTime();
					

					nText.setText((numberList.length) + "");
					datatypeText.setText(rdbtnReverseOrder.getText());
					sortText.setText("Quick Sort");
					comparisonsText.setText(QuickSort.getComparisons() + "");
					movementsText.setText(QuickSort.getMovements() + "");
					timeText.setText((endTime - startTime) + "ns");
					
					if (mostEfficient == 0)
					{
						mostEfficient = endTime - startTime;
					}
					else if (mostEfficient > (endTime-startTime))
					{
						mostEfficient = endTime-startTime;
						efficientText.setText("Quick Sort");
					}
				}
				else if (rdbtnSomeOrder.isSelected())
				{
					int[] numberList = Arrays.copyOf(someOrderList, someOrderList.length);
					
					long startTime = System.nanoTime();
					QuickSort.quickSort(numberList);
					long endTime = System.nanoTime();
					

					nText.setText((numberList.length) + "");
					datatypeText.setText(rdbtnSomeOrder.getText());
					sortText.setText("Quick Sort");
					comparisonsText.setText(QuickSort.getComparisons() + "");
					movementsText.setText(QuickSort.getMovements() + "");
					timeText.setText((endTime - startTime) + "ns");
					
					if (mostEfficient == 0)
					{
						mostEfficient = endTime - startTime;
					}
					else if (mostEfficient > (endTime-startTime))
					{
						mostEfficient = endTime-startTime;
						efficientText.setText("Quick Sort");
					}
				}
				else if (rdbtnRandom.isSelected())
				{
					int[] numberList = Arrays.copyOf(randomList, randomList.length);
					
					long startTime = System.nanoTime();
					QuickSort.quickSort(numberList);
					long endTime = System.nanoTime();
					

					nText.setText((numberList.length) + "");
					datatypeText.setText(rdbtnRandom.getText());
					sortText.setText("Quick Sort");
					comparisonsText.setText(QuickSort.getComparisons() + "");
					movementsText.setText(QuickSort.getMovements() + "");
					timeText.setText((endTime - startTime) + "ns");
					
					if (mostEfficient == 0)
					{
						mostEfficient = endTime - startTime;
					}
					else if (mostEfficient > (endTime-startTime))
					{
						mostEfficient = endTime-startTime;
						efficientText.setText("Quick Sort");
					}
				}
			}
			else
			{
				// Do nothing if no instances of ListGenerator is created
			}
		}
		
		// Merge button
		else if (e.getSource() == mergeButton)
		{
			if (ListGenerator.getInstances() > 0)
			{
				if (rdbtnInOrder.isSelected()) 
				{
					int[] numberList = Arrays.copyOf(inOrderList, inOrderList.length);
					
					long startTime = System.nanoTime();
					MergeSort.mergeSort(numberList);
					long endTime = System.nanoTime();
					

					nText.setText((numberList.length) + "");
					datatypeText.setText(rdbtnInOrder.getText());
					sortText.setText("Merge Sort");
					comparisonsText.setText(MergeSort.getComparisons() + "");
					movementsText.setText(MergeSort.getMovements() + "");
					timeText.setText((endTime - startTime) + "ns");
					
					if (mostEfficient == 0)
					{
						mostEfficient = endTime - startTime;
					}
					else if (mostEfficient > (endTime-startTime))
					{
						mostEfficient = endTime-startTime;
						efficientText.setText("Merge Sort");
					}
				}
				else if (rdbtnReverseOrder.isSelected())
				{
					int[] numberList = Arrays.copyOf(reverseOrderList, reverseOrderList.length);
					
					long startTime = System.nanoTime();
					MergeSort.mergeSort(numberList);
					long endTime = System.nanoTime();
					

					nText.setText((numberList.length) + "");
					datatypeText.setText(rdbtnReverseOrder.getText());
					sortText.setText("Merge Sort");
					comparisonsText.setText(MergeSort.getComparisons() + "");
					movementsText.setText(MergeSort.getMovements() + "");
					timeText.setText((endTime - startTime) + "ns");
					
					if (mostEfficient == 0)
					{
						mostEfficient = endTime - startTime;
					}
					else if (mostEfficient > (endTime-startTime))
					{
						mostEfficient = endTime-startTime;
						efficientText.setText("Merge Sort");
					}
				}
				else if (rdbtnSomeOrder.isSelected())
				{
					int[] numberList = Arrays.copyOf(someOrderList, someOrderList.length);
					
					long startTime = System.nanoTime();
					MergeSort.mergeSort(numberList);
					long endTime = System.nanoTime();
					

					nText.setText((numberList.length) + "");
					datatypeText.setText(rdbtnSomeOrder.getText());
					sortText.setText("Merge Sort");
					comparisonsText.setText(MergeSort.getComparisons() + "");
					movementsText.setText(MergeSort.getMovements() + "");
					timeText.setText((endTime - startTime) + "ns");
					
					if (mostEfficient == 0)
					{
						mostEfficient = endTime - startTime;
					}
					else if (mostEfficient > (endTime-startTime))
					{
						mostEfficient = endTime-startTime;
						efficientText.setText("Merge Sort");
					}
				}
				else if (rdbtnRandom.isSelected())
				{
					int[] numberList = Arrays.copyOf(randomList, randomList.length);
					
					long startTime = System.nanoTime();
					MergeSort.mergeSort(numberList);
					long endTime = System.nanoTime();
					

					nText.setText((numberList.length) + "");
					datatypeText.setText(rdbtnRandom.getText());
					sortText.setText("Merge Sort");
					comparisonsText.setText(MergeSort.getComparisons() + "");
					movementsText.setText(MergeSort.getMovements() + "");
					timeText.setText((endTime - startTime) + "ns");
					
					if (mostEfficient == 0)
					{
						mostEfficient = endTime - startTime;
					}
					else if (mostEfficient > (endTime-startTime))
					{
						mostEfficient = endTime-startTime;
						efficientText.setText("Merge Sort");
					}
				}
			}
			else
			{
				// Do nothing if no instances of ListGenerator is created
			}
		}
		
		// Heap button
		else if (e.getSource() == heapButton)
		{
			if (ListGenerator.getInstances() > 0)
			{
				if (rdbtnInOrder.isSelected()) 
				{
					Integer[] numberList = Arrays.stream(inOrderList).boxed().toArray(Integer[]::new);
					
					long startTime = System.nanoTime();
					HeapSort.heapSort(numberList);
					long endTime = System.nanoTime();

					nText.setText((numberList.length) + "");
					datatypeText.setText(rdbtnInOrder.getText());
					sortText.setText("Heap Sort");
					comparisonsText.setText(HeapSort.getComparisons() + "");
					movementsText.setText(HeapSort.getMovements() + "");
					timeText.setText((endTime - startTime) + "ns");
					
					if (mostEfficient == 0)
					{
						mostEfficient = endTime - startTime;
					}
					else if (mostEfficient > (endTime-startTime))
					{
						mostEfficient = endTime-startTime;
						efficientText.setText("Heap Sort");
					}
				}
				else if (rdbtnReverseOrder.isSelected())
				{
					Integer[] numberList = Arrays.stream(reverseOrderList).boxed().toArray(Integer[]::new);
					
					long startTime = System.nanoTime();
					HeapSort.heapSort(numberList);
					long endTime = System.nanoTime();

					nText.setText((numberList.length) + "");
					datatypeText.setText(rdbtnReverseOrder.getText());
					sortText.setText("Heap Sort");
					comparisonsText.setText(HeapSort.getComparisons() + "");
					movementsText.setText(HeapSort.getMovements() + "");
					timeText.setText((endTime - startTime) + "ns");
					
					if (mostEfficient == 0)
					{
						mostEfficient = endTime - startTime;
					}
					else if (mostEfficient > (endTime-startTime))
					{
						mostEfficient = endTime-startTime;
						efficientText.setText("Heap Sort");
					}
				}
				else if (rdbtnSomeOrder.isSelected())
				{
					Integer[] numberList = Arrays.stream(someOrderList).boxed().toArray(Integer[]::new);
					
					long startTime = System.nanoTime();
					HeapSort.heapSort(numberList);
					long endTime = System.nanoTime();

					nText.setText((numberList.length) + "");
					datatypeText.setText(rdbtnSomeOrder.getText());
					sortText.setText("Heap Sort");
					comparisonsText.setText(HeapSort.getComparisons() + "");
					movementsText.setText(HeapSort.getMovements() + "");
					timeText.setText((endTime - startTime) + "ns");
					
					if (mostEfficient == 0)
					{
						mostEfficient = endTime - startTime;
					}
					else if (mostEfficient > (endTime-startTime))
					{
						mostEfficient = endTime-startTime;
						efficientText.setText("Heap Sort");
					}
				}
				else if (rdbtnRandom.isSelected())
				{
					Integer[] numberList = Arrays.stream(randomList).boxed().toArray(Integer[]::new);
					
					long startTime = System.nanoTime();
					HeapSort.heapSort(numberList);
					long endTime = System.nanoTime();

					nText.setText((numberList.length) + "");
					datatypeText.setText(rdbtnRandom.getText());
					sortText.setText("Heap Sort");
					comparisonsText.setText(HeapSort.getComparisons() + "");
					movementsText.setText(HeapSort.getMovements() + "");
					timeText.setText((endTime - startTime) + "ns");
					
					if (mostEfficient == 0)
					{
						mostEfficient = endTime - startTime;
					}
					else if (mostEfficient > (endTime-startTime))
					{
						mostEfficient = endTime-startTime;
						efficientText.setText("Heap Sort");
					}
				}
			}
			else
			{
				// Do nothing if no instances of ListGenerator is created
			}
		}
		
		// Radix button
		else if (e.getSource() == radixButton)
		{
			if (ListGenerator.getInstances() > 0)
			{
				if (rdbtnInOrder.isSelected()) 
				{
					int[] numberList = Arrays.copyOf(inOrderList, inOrderList.length);
					
					long startTime = System.nanoTime();
					BucketSort.radixSort(numberList, numberList.length);
					long endTime = System.nanoTime();
					

					nText.setText((numberList.length) + "");
					datatypeText.setText(rdbtnInOrder.getText());
					sortText.setText("Radix Sort");
					comparisonsText.setText(BucketSort.getComparisons() + "");
					movementsText.setText(BucketSort.getMovements() + "");
					timeText.setText((endTime - startTime) + "ns");
					
					if (mostEfficient == 0)
					{
						mostEfficient = endTime - startTime;
					}
					else if (mostEfficient > (endTime-startTime))
					{
						mostEfficient = endTime-startTime;
						efficientText.setText("Bucket Sort");
					}
				}
				else if (rdbtnReverseOrder.isSelected())
				{
					int[] numberList = Arrays.copyOf(reverseOrderList, reverseOrderList.length);
					
					long startTime = System.nanoTime();
					BucketSort.radixSort(numberList, numberList.length);
					long endTime = System.nanoTime();
					

					nText.setText((numberList.length) + "");
					datatypeText.setText(rdbtnReverseOrder.getText());
					sortText.setText("Radix Sort");
					comparisonsText.setText(BucketSort.getComparisons() + "");
					movementsText.setText(BucketSort.getMovements() + "");
					timeText.setText((endTime - startTime) + "ns");
					
					if (mostEfficient == 0)
					{
						mostEfficient = endTime - startTime;
					}
					else if (mostEfficient > (endTime-startTime))
					{
						mostEfficient = endTime-startTime;
						efficientText.setText("Bucket Sort");
					}
				}
				else if (rdbtnSomeOrder.isSelected())
				{
					int[] numberList = Arrays.copyOf(someOrderList, someOrderList.length);
					
					long startTime = System.nanoTime();
					BucketSort.radixSort(numberList, numberList.length);
					long endTime = System.nanoTime();
					

					nText.setText((numberList.length) + "");
					datatypeText.setText(rdbtnSomeOrder.getText());
					sortText.setText("Radix Sort");
					comparisonsText.setText(BucketSort.getComparisons() + "");
					movementsText.setText(BucketSort.getMovements() + "");
					timeText.setText((endTime - startTime) + "ns");
					
					if (mostEfficient == 0)
					{
						mostEfficient = endTime - startTime;
					}
					else if (mostEfficient > (endTime-startTime))
					{
						mostEfficient = endTime-startTime;
						efficientText.setText("Bucket Sort");
					}
				}
				else if (rdbtnRandom.isSelected())
				{
					int[] numberList = Arrays.copyOf(randomList, randomList.length);
					
					long startTime = System.nanoTime();
					BucketSort.radixSort(numberList, numberList.length);
					long endTime = System.nanoTime();
					

					nText.setText((numberList.length) + "");
					datatypeText.setText(rdbtnRandom.getText());
					sortText.setText("Radix Sort");
					comparisonsText.setText(BucketSort.getComparisons() + "");
					movementsText.setText(BucketSort.getMovements() + "");
					timeText.setText((endTime - startTime) + "ns");
					
					if (mostEfficient == 0)
					{
						mostEfficient = endTime - startTime;
					}
					else if (mostEfficient > (endTime-startTime))
					{
						mostEfficient = endTime-startTime;
						efficientText.setText("Bucket Sort");
					}
				}
			}
			else
			{
				// Do nothing if no instances of ListGenerator is created
			}
		}
	}
		
}
