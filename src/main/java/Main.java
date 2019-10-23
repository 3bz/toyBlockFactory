import io.*;
import services.Shop;

/**
 * The Toy Block Factory simulates the beginnings of an Order Management System.
 * My design aims to properly generate a list of Block options, so that we may
 * take an order, create the desired objects, then generate cost reports.
 *
 * This program uses the Console Input and Output.
 *
 * This class initializes our input, output and top level Shop class.
 * Shop is responsible for initialising our I/O class Clerk, and co-ordinating data between sub-level classes.
 * Clerk constructs the order based on user input and passes this to the Shop.
 * Shop relays the order to the Factory for construction,
 * relays the order to Accountant for cost calculation
 * and co-ordinates the return to the user.
 *
 * Factory oversees the Cutting and Painting of the Blocks
 * by first creating separate Cutting orders for block creation,
 * then Painting orders for block mutation.
 * These jobs are carried out by the corresponding sub-departments,
 * though these objects are not required for output.
 *
 * @author ryan.ebsworth
 *
 */

public class Main {
    public static void main(String[] args) {
        Input input = new ConsoleInput();
        Output output = new ConsoleOutput();
        Shop shop = new Shop(input, output);

        shop.startTransaction();
    }
}
