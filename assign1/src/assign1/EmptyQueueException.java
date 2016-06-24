package assign1;

public class EmptyQueueException extends RuntimeException {

    /**
    * Constructs a new <code>EmptyQueueException</code> 
    */
   public EmptyQueueException( String err ) {
        super( err );
   }
} 
