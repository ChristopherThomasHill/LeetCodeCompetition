import java.io.IOException;

public class Runner {
    public static void main(String[] args) throws IOException {
        LoadLeetcodeData lld = new LoadLeetcodeData();
        lld.loadStartingData();
        lld.loadChangeInData();
    }
}