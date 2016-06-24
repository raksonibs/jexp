import java.awt.FlowLayout;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import java.math.BigInteger;

public class CalcView extends JFrame
{
	private static final long serialVersionUID = -8730447125113729547L;
	
	private JTextField userValueText;
	private JTextField calcText;
	
	@SuppressWarnings("serial")
	public CalcView(final CalcController theController)
	{
		super("Simple Calculator");		
		userValueText = new JTextField(5);
		
		calcText = new JTextField(20);
		calcText.setEditable(false);
		
		setLayout(new FlowLayout());
		add(new JLabel("Calculated Value"));
		add(calcText);
		add(new JLabel("Input"));
		add(userValueText);
		
		
		add(new ButtonAdapter("Sum") {
		       public void pressed(){ theController.sum(getUserValue());}});
		add(new ButtonAdapter("Subtract") {
		       public void pressed(){ theController.subtract(getUserValue());}});
		add(new ButtonAdapter("Multiply") {
		       public void pressed(){ theController.multiply(getUserValue());}});
		add(new ButtonAdapter("Divide") {
		       public void pressed(){ theController.divide(getUserValue());}});
		add(new ButtonAdapter("Clear") {
		       public void pressed(){ theController.clear();}});
		pack();
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
	/**
	 * Get the string value of the user input text field.
	 * 
	 * @return The string in the user input text field.
	 */
	public BigInteger getUserValue()
	{
		return new BigInteger(userValueText.getText());
	}
	
	/**
	 * Set the string for the user input text field.
	 * 
	 * @param value The new value for the user input text field.
	 * @pre. value is not null
	 */
	public void setUserValue(String value)
	{
		userValueText.setText(value);
	}
	
	/**
	 * Set the string for the calculated value text field.
	 * 
	 * @param value The new value for the calculated value text field.
	 * @pre. value is not null
	 */
	public void setCalcValue(String value)
	{
		calcText.setText(value);
	}

}
