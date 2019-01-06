import javax.swing.*;
import java.io.*;
import java.util.*;

public class Assignment2 {

    private List<String> UrduDataList;
    private List<String> EngDataList;
    private List<String> Corpus;
    private boolean[][] Tdi_Matrix;

    public Assignment2() {
        UrduDataList = new ArrayList<String>();
        EngDataList = new ArrayList<String>();
        Corpus = new ArrayList<String>();
    }

    public void printListUrdu() {
        Collections.sort(UrduDataList);
        for (String print: UrduDataList) {
            System.out.println(print);
        }
    }

    public void printListEnglish() {
        Collections.sort(EngDataList);
        for (String print: EngDataList) {
            System.out.println(print);
        }
    }

    public void ExtractData(File file) throws IOException {
        String string = "" , words = "";
        BufferedReader buffScan = new BufferedReader(new InputStreamReader(new FileInputStream(file), "UTF8"));
        while ((string = buffScan.readLine()) != null) {
            Scanner scan = new Scanner(string);
            while (scan.hasNext()) {
                words = scan.next();
                Corpus.add(words);
                String ur_word = words.trim().toLowerCase().replaceAll("[^ا-ے\']+", "");
                String en_words = words.trim().toLowerCase().replaceAll("[^A-Za-z\']+", "");
                UrduDataList.add(ur_word);
                EngDataList.add(en_words);
            }
        }
        Duplicates(UrduDataList);
        Duplicates(EngDataList);
        buffScan.close();
    }

    public void Duplicates(List data) {
        List<String> check = new ArrayList<>();
        Iterator<String> itr = data.iterator();
        while(itr.hasNext()) {
            String nextWord = itr.next();
            if(check.contains(nextWord)) {
                itr.remove();
            } else {
                check.add(nextWord);
            }
        }
    }

    // Making Term Incidence Document

    public void TDI() {
        Tdi_Matrix = new boolean[Corpus.size()][UrduDataList.size()];
        for (int i = 0 ; i < Corpus.size() ; i++) {
            for (int j = 0 ; j < UrduDataList.size() ;j++) {
                if (UrduDataList.get(j).equals(Corpus.get(i))) {
                    Tdi_Matrix[i][j] = true;
                } else {
                    Tdi_Matrix[i][j] = false;
                }
            }
        }
    }

    public void print() {
        System.out.println("\t\t"+UrduDataList);
        System.out.println();
        for (int i = 0 ; i < UrduDataList.size(); i++) {
            System.out.print("D"+i+"\t\t");
            for (int j = 0 ; j < UrduDataList.size() ; j++) {
                System.out.print(Tdi_Matrix[i][j]+" \t");
            }
            System.out.println();
         }
    }


    public static void main(String[] args) throws IOException {

        Scanner scan = new Scanner(System.in);
        Assignment2 assi = new Assignment2();

        File file = new File("src/UrduDataSet.txt");
        assi.ExtractData(file);

        System.out.println("If you want to show the entire list then press L and if you want to show the matrix press M: ");
        char choose = scan.next().charAt(0);
        if (choose == 'L' || choose == 'l') {
            System.out.println("Press U for urdu words list and E of Englist word List: ");
            char select = scan.next().charAt(0);

            if (select == 'U' || select == 'u') {
                assi.printListUrdu();
            } else if (select == 'E' || select == 'e') {
                assi.printListEnglish();
            } else {
                JOptionPane.showMessageDialog(null, "Invalid Selection...");
            }
        } else if (choose == 'M' || choose == 'm') {
            System.out.println("\npress p for print the matrix: ");
            char ch = scan.next().charAt(0);
            if (ch == 'p' || ch == 'P') {
                assi.TDI();
                assi.print();
            } else {
                System.out.println("Invalid Selection...");
            }
        } else {
            JOptionPane.showMessageDialog(null, "Invalid Selection...");
        }
    }

}