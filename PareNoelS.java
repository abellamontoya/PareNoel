package PareNoel;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class PareNoelS {
    public static void main(String[] args) throws IOException {
        FileReader fr = new FileReader("santako.txt");
        BufferedReader br = new BufferedReader(fr);

        String line;
        while ((line = br.readLine()) != null) {
            printResults(line);
        }

        br.close();
        fr.close();
    }

    private static void printResults(String line) {
        int cp1 = countOccurrences(line, "\\*<]:-DOo");
        int cp2 = countOccurrences(line, ">:o\\)");
        int cp3 = countOccurrences(line, "<]:-D");

        if (cp1 > 0) {
            System.out.print("Pare Noel (" + cp1 + ") ");
        }

        if (cp2 > 0) {
            System.out.print("Rens (" + cp2 + ") ");
        }

        if (cp3 > 0 && cp2 == 0) {
            System.out.print("Follets (" + cp3 + ") ");
        }

        System.out.println();
    }

    private static int countOccurrences(String line, String pattern) {
        Pattern p = Pattern.compile(pattern);
        Matcher m = p.matcher(line);

        int count = 0;
        while (m.find()) {
            count++;
        }
        return count;
    }
}
