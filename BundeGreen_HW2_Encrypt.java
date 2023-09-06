import java.util.Scanner;

public class BundeGreen_HW2_Encrypt{
    
    public static void main(String[] args){
        int deltaOne = 0x11111111;
        int deltaTwo = 0x22222222;
        int[] K = new int[4];
        int[] L = new int[3];
        int[] R = new int[3];
        Scanner keyboard = new Scanner(System.in);
        
        for(int i = 0; i < 4; i++){
            System.out.println("Please enter your hex string K[" + i + "] without the '0x'");
            K[i] = Integer.parseUnsignedInt(keyboard.nextLine(), 16);
        }

        System.out.println("Please enter your hex string for L[0] without the '0x'");
        L[0] = Integer.parseUnsignedInt(keyboard.nextLine(), 16);
        System.out.println("Please enter your hex string for R[0] without the '0x'");
        R[0] = Integer.parseUnsignedInt(keyboard.nextLine(), 16);
        L[1] = R[0];
        int f = ((R[0] << 4) + K[0]) ^ (R[0] + deltaOne) ^ ((R[0] >>> 5) + K[1]);
        R[1] = L[0] + f;
        L[2] = R[1];
        int g = ((R[1] << 4) + K[2]) ^ (R[1] + deltaTwo) ^ ((R[1] >>> 5) + K[3]);
        R[2] = L[1] + g;
        
        for(int i = 0; i < 4; i++){
            System.out.println("K[" + i + "]: " + Integer.toUnsignedString(K[i]));
        }
        for(int i = 0; i < 3; i++){
            System.out.printf("R[%d] = 0x%08X%n", i, R[i]);
        }
        for(int i = 0; i < 3; i++){
            System.out.printf("L[%d] = 0x%08X%n", i, L[i]);
        }
    }
}