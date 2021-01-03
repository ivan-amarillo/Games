//Iván Amarillo Rico
import java.util.Scanner;

public class Games{
    public static void main(String[] args)
    {
        int[] winner = new int[6];
        int[] user = new int[6];
        switch (args[0]){
            case "lottery": playLottery(winner, user); break;
            //case "nim" : 
    }
    public static void playLottery(int[] winner, int[] user){
        Scanner sc = new Scanner(System.in);
        String numbers;
        String[] numbers1 = new String[6];
        
        //Enter your number between 1 and 49, both include
        System.out.println("Enter 6 numbers between 1 and 49 separered by a " +
        "space:");
        for(int i= 0; i<user.length; i++)        {
            user[i] = sc.nextInt();
        }
        
        System.out.println("This is the winner combination:");
        generateLottery(winner);
        System.out.println();
        checkLottery(user, winner);
        sc.close();
    }
    public static int generateNumber(int min, int max){
        int randomNumber = (min) + (int) (Math.random() * max);
        return randomNumber;
    }
    //Generate the winner combination
    public static void generateLottery(int[] winner){
        int min = 1;
        int max = 50;
        
        for (int i = 0; i < winner.length; i++){
            winner[i] = generateNumber(min, max);
            for(int j = i + 1; j < winner.length; j++){
                if(winner[i] == winner[j]){
                    i--;
                }
            }
        }
        //Sort the numbers of the winner combination
        for(int i = 0; i < winner.length; i++){
            for (int j = i + 1; j < winner.length; j++){
                if (winner[i] > winner[j]){
                    int dateTemporary = winner[i];
                    winner[i] = winner[j];
                    winner[j] = dateTemporary;
                }
            }
        }
        for(int i = 0; i < winner.length; i++)
        {
            System.out.print(winner[i] + " ");
        }
    }
    //Function to check the user numbers with the winner combination
    public static void checkLottery(int[] winner, int[] user){
        int hits = 0;
        for (int i = 0; i < user.length; i++) {
            for (int j = 0; j < winner.length; j++) {
                if (user[i] == winner[j]) {
                    hits++;
                }
            }
        }
        System.out.printf("You have %d hits.", hits);
    }
}

