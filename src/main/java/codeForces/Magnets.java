package codeForces;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

public class Magnets {

    private final static Logger logger = Logger.getLogger(Magnets.class.getName());

    public static void main(String[] args) {
        int groupOfMagnets = 1;

        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            checkMagnetsNumber(br);

            String magnetFromBehind = null;
            for (String currentMagnet : getMagnetsList(br)) {
                if (magnetFromBehind == null) {
                    magnetFromBehind = currentMagnet;
                }
                if (!currentMagnet.equals(magnetFromBehind)) {
                    groupOfMagnets++;
                    magnetFromBehind = currentMagnet;
                }
            }
            System.out.println(groupOfMagnets);
        } catch (IOException e) {
            logger.info(e.getMessage());
        }
    }

    private static void checkMagnetsNumber(BufferedReader br) throws IOException {
        int magnetsNumber = Integer.parseInt(br.readLine());
        if (magnetsNumber < 1) {
            logger.info("Please insert more magnets.");
        }
    }

    private static List<String> getMagnetsList(BufferedReader br) throws IOException {
        List<String> magnetsList = new ArrayList<>();
        String magnet;
        while (br.ready() && (magnet = br.readLine()) != null) {
            magnetsList.add(magnet);
        }
        return magnetsList;
    }
}
/* Problem 344A - Magnets
 * https://codeforces.com/problemset/problem/344/A
 */
