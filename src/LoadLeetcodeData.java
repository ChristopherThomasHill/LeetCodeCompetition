import java.io.*;
import java.net.URL;
import java.util.Scanner;

public class LoadLeetcodeData {
    public void loadStartingData() throws IOException {
        Scanner leetcodeUsernames = new Scanner(new File("src/LeetcodeUsernames"));
        String output = "";

        while(leetcodeUsernames.hasNext()){
            String username = leetcodeUsernames.next();

            URL url = new URL("https://leetcode-stat-api.herokuapp.com/" + username);

            BufferedReader in = new BufferedReader(new InputStreamReader(url.openStream()));

            String line = in.readLine();
            in.close();

            String easyText = line.substring(line.indexOf("Easy"));
            for(int i = 0; i < 2; i++){
                easyText = easyText.substring(easyText.indexOf('>')+1);
            }
            easyText = easyText.substring(0,easyText.indexOf('<'));

            String mediumText = line.substring(line.indexOf("Medium"));
            for(int i = 0; i < 2; i++){
                mediumText = mediumText.substring(mediumText.indexOf('>')+1);
            }
            mediumText = mediumText.substring(0,mediumText.indexOf('<'));

            String hardText = line.substring(line.indexOf("Hard"));
            for(int i = 0; i < 2; i++){
                hardText = hardText.substring(hardText.indexOf('>')+1);
            }
            hardText = hardText.substring(0,hardText.indexOf('<'));

            output += easyText+" "+mediumText+ " " + hardText + "\n";
        }

        FileWriter fw = new FileWriter("src/StartingData");
        fw.write(output);
        fw.close();
    }

    public void loadChangeInData() throws IOException{
        Scanner leetcodeUsernames = new Scanner(new File("src/LeetcodeUsernames"));
        Scanner startingValues = new Scanner(new File("src/StartingData"));
        String output = "";

        while(leetcodeUsernames.hasNext()){
            String username = leetcodeUsernames.next();
            String beginningValues = startingValues.nextLine();

            int startingEasy = Integer.parseInt(beginningValues.split(" ")[0]);
            int startingMedium = Integer.parseInt(beginningValues.split(" ")[1]);
            int startingHard = Integer.parseInt(beginningValues.split(" ")[2]);

            URL url = new URL("https://leetcode-stat-api.herokuapp.com/" + username);

            BufferedReader in = new BufferedReader(new InputStreamReader(url.openStream()));

            String line = in.readLine();
            in.close();

            String easyText = line.substring(line.indexOf("Easy"));
            for(int i = 0; i < 2; i++){
                easyText = easyText.substring(easyText.indexOf('>')+1);
            }
            easyText = easyText.substring(0,easyText.indexOf('<'));
            easyText = "" + (startingEasy - Integer.parseInt(easyText));

            String mediumText = line.substring(line.indexOf("Medium"));
            for(int i = 0; i < 2; i++){
                mediumText = mediumText.substring(mediumText.indexOf('>')+1);
            }
            mediumText = mediumText.substring(0,mediumText.indexOf('<'));
            mediumText = "" + (startingMedium - Integer.parseInt(mediumText));


            String hardText = line.substring(line.indexOf("Hard"));
            for(int i = 0; i < 2; i++){
                hardText = hardText.substring(hardText.indexOf('>')+1);
            }
            hardText = hardText.substring(0,hardText.indexOf('<'));
            hardText = "" + (startingHard - Integer.parseInt(hardText));


            output += easyText+" "+mediumText+ " " + hardText + "\n";
        }

        FileWriter fw = new FileWriter("src/ChangeInData");
        fw.write(output);
        fw.close();
    }
}
