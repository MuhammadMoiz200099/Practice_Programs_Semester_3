
/*
*
*	String Name = System.out.println("MUHAMMAD MOIZ SIDDIQUE");
*	String ID   = System.out.println("FA17 - BSSE - 0087");
*
*	String Section = System.out.println("A-M");
*	
*	String Instructor = System.out.println("SIR YASEEN KHAN");
*
*/




import java.io.*;
import java.util.*;

public class ConsolidatedDictionary {

    private Dictionary<String , List<String>> FinalDictionary;

    public ConsolidatedDictionary() {
        this.FinalDictionary = new Hashtable();
    }

    public void ExtractData(String UrduPath , String EngPath , String HindiPath) {
        try {
            Scanner Urduscan = new Scanner(new FileInputStream(new File(UrduPath)));
            Scanner Englishscan = new Scanner(new FileInputStream(new File(EngPath)));
            Scanner Hindiscan = new Scanner(new FileInputStream(new File(HindiPath)));

            String Urdudata = "" , EnglishData = "" , HindiData = "";
            while (Englishscan.hasNextLine()) {
                List<String> NameList = new ArrayList<>();
                EnglishData = Englishscan.nextLine();
                Urdudata = Urduscan.nextLine();
                HindiData = Hindiscan.nextLine();

                String[] TempU = Urdudata.split("\t");
                String[] TempE = EnglishData.split("\t");
                String[] TempH = HindiData.split("\t");
                NameList.add(TempU[0]+" "+TempH[0]+" "+TempE[0]);
                FinalDictionary.put("\n"+TempE[1] , NameList);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void Print() {
        System.out.println(FinalDictionary);
    }

    public static void main(String[] args) {
        ConsolidatedDictionary dictionary = new ConsolidatedDictionary();
        String urduPath = "src/DsaAss3/rekhta-poets-3.tsv";
        String engPath = "src/DsaAss3/rekhta-poets-1.tsv";
        String hindiPath = "src/DsaAss3/rekhta-poets-2.tsv";
        dictionary.ExtractData(urduPath,engPath,hindiPath);
        dictionary.Print();
    }
}