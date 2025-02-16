package csc223;

public class DNA {
    public static String countNucleotides(String dna){
        int ACount = 0;
        int CCount = 0;
        int GCount = 0;
        int TCount = 0;
        for (int i = 0; i < dna.length(); i++){
            String currChar = dna.substring(i, i+1);
            if (currChar.equals("A")){
                ACount += 1;
            }
            if (currChar.equals("C")){
                CCount += 1;
            }
            if (currChar.equals("G")){
                GCount += 1;
            }
            if (currChar.equals("T")){
                TCount += 1;
            }
        }
        return Integer.toString(ACount) + " " + Integer.toString(CCount) + " " +  Integer.toString(GCount) + " " +  Integer.toString(TCount);
    }
    public static String transcribe(String dna){
        String rna = "";
        for (int i = 0; i < dna.length(); i++){
            String currChar = dna.substring(i, i+1);
            if (currChar.equals("T")){
                rna = rna + "U";
            }
            else{
                rna = rna + currChar;
            }
        }
        return rna;
    }
    public static String reverseComplement(String dna){
        String reverseComplementStr = "";
        for (int i = dna.length()-1; i >= 0; i--){
            String currChar = dna.substring(i, i+1);
            if (currChar.equals("A")){
                reverseComplementStr = reverseComplementStr + "T";
            }
            else if (currChar.equals("T")){
                reverseComplementStr = reverseComplementStr + "A";
            }
            else if (currChar.equals("C")){
                reverseComplementStr = reverseComplementStr + "G";
            }
            else if (currChar.equals("G")){
                reverseComplementStr = reverseComplementStr + "C";
            }
        }
        return reverseComplementStr;
    }
    public static void main(String[] args){
        
    }
}
