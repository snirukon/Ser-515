import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class Facade {
    ArrayList<String> pName=new ArrayList<>();
    String username;
    String pass;
    Person person;
    int type;

    public void login()
    {
        System.out.println("Facade");
        try {
            String string;
            Scanner sc1=new Scanner(System.in);
            System.out.println("Enter username");
            this.username=sc1.next();
            System.out.println("Enter password");
            this.pass=sc1.next();

            File buyer = new File("BuyerInfo.txt");
            FileReader fb = new FileReader(buyer);
            BufferedReader bb = new BufferedReader(fb);
            while((string=bb.readLine())!=null)
            {
                String[] x = string.split(":");
                if((x[0].equals(username)) && (x[1].equals(pass)))
                {
                    type=0;
                    System.out.println("This is a Buyer");
                }
            }

            File seller = new File("SellerInfo.txt");
            FileReader fs = new FileReader(seller);
            BufferedReader bs = new BufferedReader(fs);
            while((string=bs.readLine())!=null)
            {

                String[] x = string.split(":");
                if((x[0].equals(username)) && (x[1].equals(pass)))
                {
                    type=1;
                    System.out.println("This is a Seller");
                }
            }
            createUser();
        }
        catch(IOException e) {
            e.printStackTrace();
        }

    }
    public void createUser()
    {
        if(type==0) {
            person = new Buyer();

        }
        else if(type==1) {
            person = new Seller();
            
        }

    }
    public void createproducts() {


    }


}
