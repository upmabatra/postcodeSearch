import java.io.FileNotFoundException;
import java.util.*;

public class Find{
public static void main(String[] args) throws FileNotFoundException {
    System.out.println("Enter the zip code or county for which you wish to search");
    Scanner input = new Scanner(System.in);
    String userInput;
    String userOutput = "";
    int userCode;
    userInput = input.nextLine();
    postalCode postCode;//postalCode(input.nextLine());
    try {
        userCode = Integer.parseInt(userInput);
        postCode = new postalCode(userCode);
        userOutput = postCode.findCounty();
    } catch (Exception e) {
        System.out.println("Input is not a county");//when input is not an integer 
        postCode = new postalCode(userInput);
        int zipCode;
        zipCode = postCode.find();
        userInput = String.valueOf(zipCode);
    }
    System.out.println("The zip code and county for " + userInput + " is " + postCode.toString());

}
}