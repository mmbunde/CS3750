import java.util.Scanner;

public class BundeGreen_HW2_Decrypt{
    
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

        System.out.println("Please enter your hex string for L[2] without the '0x'");
        L[2] = Integer.parseUnsignedInt(keyboard.nextLine(), 16);
        System.out.println("Please enter your hex string for R[2] without the '0x'");
        R[2] = Integer.parseUnsignedInt(keyboard.nextLine(), 16);
        R[1] = L[2];
        int f = ((L[2] << 4) + K[2]) ^ (L[2] + deltaTwo) ^ ((L[2] >>> 5) + K[3]);
        L[1] = R[2] - f;
        int g = ((L[1] << 4) + K[0]) ^ (L[1] + deltaOne) ^ ((L[1] >>> 5) + K[1]);
        L[0] = R[1] - g;
        R[0] = L[1];

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