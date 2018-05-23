// Debugging Chapter 11: DebugException.java

import java.io.IOException;

public class DebugException {
    public static void main(String args[]) {
        try {
            throw new SpecialIOException();
        } catch (SpecialIOException specialIOException) {
            System.err.println(specialIOException.toString());
        } catch (IOException ioException) {
            System.err.println(ioException.toString());
        } catch (Exception exception) {
            System.err.println(exception.toString());
        }
    }  // end method main
}  // end class DebugException

/**************************************************************************
 * (C) Copyright 1992-2012 by Deitel & Associates, Inc. and               *
 * Pearson Education, Inc. All Rights Reserved.                           *
 *                                                                        *
 * DISCLAIMER: The authors and publisher of this book have used their     *
 * best efforts in preparing the book. These efforts include the          *
 * development, research, and testing of the theories and programs        *
 * to determine their effectiveness. The authors and publisher make       *
 * no warranty of any kind, expressed or implied, with regard to these    *
 * programs or to the documentation contained in these books. The authors *
 * and publisher shall not be liable in any event for incidental or       *
 * consequential damages in connection with, or arising out of, the       *
 * furnishing, performance, or use of these programs.                     *
 *************************************************************************/