import java.io.*;
import java.util.Scanner;

public class AdventureTime {

    /** This is the main method and it is where you will test your implementations for challengeOne, challengeTwo, etc.
     *
     * @param args
     * @throws IOException
     */
    public static void main(String[] args) throws IOException {
//        System.out.println(challengeOne("testInputOneTwo.txt")); // ans = 7
        System.out.println(challengeOne("inputOneTwo.txt")); //ans: 1655
        System.out.println(challengeTwo("testInputOneTwo.txt")); // ans = 5
        System.out.println(challengeTwo("InputOneTwo.txt")); // ans = 1683
        System.out.println(challengeThree("testInputThreeFour.txt")); // ans = 150
        System.out.println(challengeThree("InputThreeFour.txt")); // ans = 1524750
        System.out.println(challengeFour("testInputThreeFour.txt")); //ans = 900
        System.out.println(challengeFour("InputThreeFour.txt")); //ans = 1592426537

    }

    /** TODO 1
     *
     * Challenge 1
     *
     * @param fileName
     * @return Answer to Challenge 1
     * @throws IOException
     */
    public static int challengeOne(String fileName) throws IOException {
        int[] arr = new int[countLinesInFile(fileName)];
        arr = readFile(fileName);
        int count = 0;
        for(int i = 1; i < arr.length; i++){
            if(arr[i] > arr[i-1]){
                count++;
            }
        }
        return count;
    }

    /** TODO 2
     *
     * Challenge 2
     *
     * @param fileName
     * @return Answer to Challenge 2
     * @throws FileNotFoundException
     */
    public static int challengeTwo(String fileName) throws FileNotFoundException {
        int[] arr = new int[countLinesInFile(fileName)];
        arr = readFile(fileName);
        int count = 0;
        for(int i = 1; i < arr.length-2; i++){
            if(arr[i+2]  > arr[i-1]){ // arr[i] + arr[i+1] + arr[i+2] > arr[i] + arr[i-1] + arr[i+1] simplifies to arr[i+2] > arr[i-1]
                count++;
            }
        }
        return count;
    }

    /** TODO 3
     *
     * Challenge 3
     *
     * @param fileName
     * @return Answer to Challenge 3
     * @throws FileNotFoundException
     */
    public static int challengeThree(String fileName) throws FileNotFoundException {
        countLinesInFile(fileName);
        String[] arr;
        arr = readFileStr(fileName);
        int xval = 0;
        int yval = 0;
        for(int i = 0; i < arr.length; i++){
            if(arr[i].charAt(0) == 'd'){
                yval -= Integer.parseInt(arr[i].substring(5));
            }
            if(arr[i].charAt(0) == 'u'){
                yval += Integer.parseInt(arr[i].substring(3));
            }
            if(arr[i].charAt(0) == 'f'){
                xval += Integer.parseInt(arr[i].substring(8));
            }
        }
        return Math.abs(xval * yval);
    }

    /** TODO 4
     *
     * Challenge 4
     *
     * @param filename
     * @return Answer to Challenge 4
     * @throws FileNotFoundException
     */
    public static int challengeFour(String filename) throws FileNotFoundException {
        countLinesInFile(filename);
        String[] arr;
        arr = readFileStr(filename);
        int xval = 0;
        int yval = 0;
        int aim = 0;
        for(int i = 0; i < arr.length; i++){
            if(arr[i].charAt(0) == 'd'){
                aim += Integer.parseInt(arr[i].substring(5));
            }
            if(arr[i].charAt(0) == 'u'){
                aim -= Integer.parseInt(arr[i].substring(3));
            }
            if(arr[i].charAt(0) == 'f'){
                xval += Integer.parseInt(arr[i].substring(8));
                yval += Integer.parseInt(arr[i].substring(8))*aim;
            }
        }
        return Math.abs(xval * yval);
    }

    /** This method will write the values passed as challengeOne, challengeTwo, challengeThree, and challengeFour to a text file.
     * Do not edit this method.
     */
    private static void writeFileAllAnswers(String outPutFilename, int challengeOne, int challengeTwo, int challengeThree, int challengeFour) throws IOException {
        File file = new File(outPutFilename);
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(file));
        bufferedWriter.write("Challenge 1: " + "\t" + challengeOne + "\n");
        bufferedWriter.write("Challenge 2: " + "\t" + challengeTwo + "\n");
        bufferedWriter.write("Challenge 3: " + "\t" + challengeThree + "\n");
        bufferedWriter.write("Challenge 4: " + "\t" + challengeFour + "\n");
        bufferedWriter.close();
    }

    /** This method will read the values in inputFilename into an array of integers, which it will return.
     * Do not edit this method.
     */
    private static int[] readFile(String inputFilename) throws FileNotFoundException {
        File file = new File(inputFilename);
        Scanner scanner = new Scanner(file);
        int numberOfLinesInFile = countLinesInFile(inputFilename);
        int[] data = new int[numberOfLinesInFile];
        int index = 0;
        while (scanner.hasNextLine()) {
            data[index++] = scanner.nextInt();
        }
        scanner.close();
        return data;
    }
    private static String[] readFileStr(String inputFilename) throws FileNotFoundException {
        File file = new File(inputFilename);
        Scanner scanner = new Scanner(file);
        int numberOfLinesInFile = countLinesInFile(inputFilename);
        String[] data = new String[numberOfLinesInFile];
        int index = 0;
        while (scanner.hasNextLine()) {
            data[index++] = scanner.nextLine();
        }
        scanner.close();
        return data;
    }

    /** This method will count the number of lines in a text file, which it will return.
     * Do not edit this method.
     */
    private static int countLinesInFile(String inputFilename) throws FileNotFoundException {
        File file = new File(inputFilename);
        Scanner scanner = new Scanner(file);
        int lineCount = 0;
        while (scanner.hasNextLine()) {
            lineCount++;
            scanner.nextLine();
        }
        scanner.close();
        return lineCount;
    }

}