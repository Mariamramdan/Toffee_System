import java.util.Scanner;

public class RegLogUser{
    private Scanner input = new Scanner(System.in);
    private String options ;
    private String name , email , password;

    public void Run()
    {
        boolean flag = true;
        while(flag)
        {
            System.out.println("Plz Enter (l) if u want to login and (r) if u want to regester..");
            options = input.nextLine();

            if (options.contentEquals("l")){
                System.out.println("PLz Enter your email :");
                email = input.nextLine();

                System.out.println("PLz Enter your password :");
                password = input.nextLine();

                Login login = new Login(email, password);
                login.execution();
            }


            else if (options.contentEquals("r")){                
                System.out.println("PLz Enter your name :");
                name = input.nextLine();

                System.out.println("PLz Enter your email :");
                email = input.nextLine();

                System.out.println("PLz Enter your password :");
                password = input.nextLine();

                Register register = new Register(name, email, password);
                register.execution();
            }

            System.out.println("if u want to continue Enter yes else Enter no ..");
            String cont;
            cont = input.nextLine();
            if(cont.contentEquals("no"))
                break;
        }
    }

}
