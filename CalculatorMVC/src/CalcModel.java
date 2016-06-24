import java.math.BigInteger;

public class CalcModel
{
	private BigInteger calcValue;

	/**
	 * Creates a model with no user values and a calculated
	 * value of zero.
	 * 
	 */
	public CalcModel()
	{
		clear();
	}


	/**
	 * Clears the user values and the calculated value.
	 */
	public void clear()
	{
		calcValue = calcValue.ZERO;//BigInteger.ZERO;
	}

	/**
	 * Adds the calculated value by a user value.
	 * 
	 * @param userValue
	 *            The value to add to the current calculated value by.
	 */
	public void sum(BigInteger userValue)
	{
		calcValue = calcValue.add(userValue);
	}
	
	/**
	 * Subtracts the calculated value by a user value.
	 * 
	 * @param userValue
	 *            The value to subtract from the current calculated value by.
	 */
	public void subtract(BigInteger userValue)
	{
		calcValue = calcValue.subtract(userValue);
	}
	
	/**
	 * Multiplies the calculated value by a user value.
	 * 
	 * @param userValue
	 *            The value to multiply the current calculated value by.
	 */
	public void multiply(BigInteger userValue)
	{
		calcValue = calcValue.multiply(userValue);
	}

	/**
	 * Divides the calculated value by a user value.
	 * 
	 * @param userValue
	 *            The value to multiply the current calculated value by.
	 * @pre. userValue is not equivalent to zero.
	 */
	public void divide(BigInteger userValue)
	{
		calcValue = calcValue.divide(userValue);
	}
	
	/**
	 * Get the current calculated value.
	 * 
	 * @return The current calculated value.
	 */
	public BigInteger getCalcValue()
	{
		return calcValue;
	}
}
