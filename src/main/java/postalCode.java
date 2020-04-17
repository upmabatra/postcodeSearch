import java.io.FileNotFoundException;
import java.util.*;

public class postalCode{
    int code;
    String city;
    public postalCode(int postCode) { this.code = postCode;}
    public postalCode(String city){
        this.city = city;
    }
   /* public postalCode(String postalCity){
        this.city=postalCity;
    }*/
    public int find() throws FileNotFoundException {
    //readFile rdFile = new readFile("codes.txt");
        readFile rdFile = new readFile();
    rdFile.scanFile();
    String[] countyInFile = rdFile.readSecondColumn();
    int j = 0;
    for(int i=0;i<countyInFile.length;i++)
    {
        j = i;
        if(this.city.equals(countyInFile[i]))
            break;
    }
    this.code=rdFile.getLineCode(j);
    return this.code;
    }
    public String findCounty() throws FileNotFoundException {
     //readFile rdFile = new readFile("codes.txt");
        readFile rdFile = new readFile();
     rdFile.scanFile();
     int[] postcodeInFile = rdFile.readFirstColumn();
     int j=0;
     for(int i =0 ; i<postcodeInFile.length; i++)
     {
         j=i;
         if(this.code==postcodeInFile[i])
             break;
     }
    this.city=rdFile.getLineCounty(j);
     return this.city;
    }

    @Override
    public String toString() {
        return "postalCode{" +
                "code='" + code + '\'' +
                ", city='" + city + '\'' +
                '}';
    }
}