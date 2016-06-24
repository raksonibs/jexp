// Suggested in the textbook.

// A run-time exception for invalid positions
public class BoundaryViolationException extends RuntimeException {
  public BoundaryViolationException() { }
  public BoundaryViolationException(String err) { super(err); }
}
