import io.*;
import services.Shop;
import services.ordering.Clerk;

/**
 * The Toy Block Factory simulates the beginnings of an Order Management System.
 * My design aims to properly generate a list of Block options, so that we may
 * take an order, create the desired objects, then generate cost reports.
 *
 * This program uses the Console Input and Output.
 *
 * This class initializes our input, output and top level Clerk class.
 * Clerk constructs the order based on user input and passes this to the Shop.
 * Shop relays the order to the Factory for construction
 * and co-ordinates the return of the cost of the order,
 * which the Accountant class calculates.
 * Factory oversees the Cutting and Painting of the Blocks,
 * though these objects are not required for output.
 *
 * @author ryan.ebsworth
 *
 */

public class Main {
    public static void main(String[] args) {
        IInput input = new ConsoleInput();
        IOutput output = new ConsoleOutput();
        Clerk clerk = new Clerk(input, output);

        Shop shop = new Shop(clerk);
        shop.startTransaction();
    }
}
