public class Register extends Form{
    private String name;

    public Register(String name, String email, String password) {
        super(email, password);
        this.name = name;
    }
    
    public String getName() {
        return this.name;
    }
    

    @Override
    public void execution() {
        if(getDatabase().IsUserRegistered(getUserEmail(), getUserPassword())){
            System.out.println( "Sorry ,This user already exists.");
        }
        else{
            User newUser = new User(getName(), getUserEmail(), getUserPassword());
            getDatabase().AddToDatabase(newUser);
            System.out.println( "successfully registered!");
            System.out.println("hello " + newUser.getName() );}
        
    }

    
}
