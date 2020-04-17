import java.io.*;
import java.util.*;

public class readFile {
 File file = new File("src\\main\\resources\\codes.txt");
  ArrayList<String> text = new ArrayList<String>();
  ArrayList<String> zipcode = new ArrayList<String>();
  int sizeOfFile ;
  int count=0;
    public readFile() {this.file = file;}
     public readFile(String path) {
         this.file = new File(path);
     }

     public void scanFile() throws FileNotFoundException {
            Scanner reader = new Scanner(file);
            while (reader.hasNextLine())
            {
                count++;
                String row = reader.nextLine();
                parseLine(row);
               /* this.zipcode.add(reader.next());*/
               // while(reader.hasNext("\t\t\t")) {
                 //   this.text.add(reader.nextLine());
                }

            //}
            this.sizeOfFile = text.size();
            /*System.out.println("no of lines"+count);
            for(int i=0; i<count-1;i++)
            System.out.println("inside readFile method "+text.get(i));
            for(int i=0;i<count-1;i++)
            System.out.println("zip codes "+zipcode.get(i));
            */
        }

public void parseLine(String str) {
    Scanner prsLn = new Scanner(str);
    prsLn.useDelimiter(",");
    while (prsLn.hasNext()) {
        this.zipcode.add(prsLn.next());
        while(prsLn.hasNext())
        {
            this.text.add(prsLn.next());
         }
    }
    //System.out.println("return from parseLine");
    prsLn.close();
}

 public int[] readFirstColumn() throws FileNotFoundException {
      int[] postCodes = new int[count];
      int j=0; //if there is a header than j=1
      int i=0;
    while(!this.zipcode.isEmpty()) {
          if (j<count){
                postCodes[i] = Integer.parseInt(this.zipcode.get(j));
                //postCodes[i]=this.zipcode.get(j); if fist column is string
                j++;//j = j + 3;
                i++;
            } else break;
       }
    /*for(int k=0;k<postCodes.length;k++)
    System.out.println("inside read first column "+k+" "+postCodes[k]);
     */
     return postCodes;
 }

 public String[] readSecondColumn() throws FileNotFoundException {
    String[] county = new String[sizeOfFile];
    int j=0;
    int i=0;
    while (!this.text.isEmpty()){
        if(j<count) {
            county[i] = this.text.get(j);
            i++;
            j++;
        }
            else
                break;
        }
    /*for(int k=0;k<county.length;k++)
    System.out.println("county "+county[k]);
     */
    return county;
    }

   public String getLineCounty(int index){
     String getCounty="";
     getCounty=(this.text.get(index));
     //System.out.println("inside getLineCounty "+index+" "+getCounty);
       return getCounty;
   }
   public int getLineCode(int index){
     int getCode=0;
     getCode=Integer.parseInt(this.zipcode.get(index));
     //System.out.println("inside getLineCode "+index+" "+getCode);
     return getCode;
   }
}
