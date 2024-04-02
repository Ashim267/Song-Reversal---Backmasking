// File name: reverse.java
// Author: Ashim Chand
// VUnetid: chanda
// Email: ashimchand@vanderbilt.edu
// Class: 3
// Assignment Number: 5
// Honor Statement: Will not use unfair means.
// Description:
// Reverse a sound data file by reading in all the data samples,
// pushing them onto stacks, and then creating a new sound data
// file while popping values off the stacks.

import java.io.*;
import java.util.Scanner;


public class reverse {

    public static void main(String[] args) throws FileNotFoundException {

        // open input & output data files
        Scanner keyboard = new Scanner(System.in);
        Scanner infile = openInputFile(keyboard);
        PrintStream outfile = openOutputFile(keyboard);

        System.out.println("Reading the input file...");

        // read in the data on the first two lines of the file
        String firstLine, secondLine;

        firstLine = infile.nextLine();   // read in the first line
        secondLine = infile.nextLine();  // read in the second line

        // TODO
        // Your job is to read the rest of the input file and
        // process the data. Hint: use the nextDouble() method of the Scanner class.
        // Read values in pairs.

        DblStack timeStack = new DblStack();
        DblStack soundStack = new DblStack();

        int count = 0;
        while (infile.hasNextDouble()) {
            double time = infile.nextDouble();
            if (infile.hasNextDouble()) {
                double sound = infile.nextDouble();
                timeStack.push(time);
                soundStack.push(sound);
                count++;
            }
        }

        System.out.println("There were " + count + " samples in the file.");  // TODO: replace "???"
        System.out.println("Creating output file... wait for Done message.");

        // TODO
        // Process the data that you have read in whatever manner is necessary.

        DblStack MaintimeStack = new DblStack();


        while (!timeStack.isEmpty()){
            MaintimeStack.push(timeStack.top());
            timeStack.pop();

        }



        //
        // Now we are ready to output the data values to output file.
        // But first, we need to output the header lines
        //
        outfile.println(firstLine);;
        outfile.println(secondLine);;

        // TODO
        // Your job is to write the rest of the output file.
        // Each line should start with two blanks, then the time-step
        // value, then a single tab character '\t', then the sound data value.

        while (!MaintimeStack.isEmpty()){
            outfile.printf("  %14.8g\t%10.6g\n", MaintimeStack.top(), soundStack.top());
            MaintimeStack.pop();
            soundStack.pop();
        }

        // close the files
        infile.close();
        outfile.close();

        System.out.println("Done");
    }


    /**
     * openInputFile -- open input file
     * @param keyboard -- Scanner object to read in file name
     * @return Scanner object opened on input file
     * @throws FileNotFoundException
     * pre: user is prepared to enter file name at the keyboard
     * post: file have been opened
     */
    private static Scanner openInputFile (Scanner keyboard) throws FileNotFoundException {

        // open input data file
        String inFileName;
        System.out.print("Enter the name of the input file: ");
        inFileName = keyboard.nextLine();
        File f = new File(inFileName);
        while (!f.canRead()) {
            System.out.println("File not found. Try again.");
            System.out.print("Enter the name of the input file: ");
            inFileName = keyboard.nextLine();
            f = new File(inFileName);
        }
        Scanner infile = new Scanner(f);
        return infile;
    }


    /**
     * openOutputFile -- open output file
     * @param keyboard -- Scanner object to read in file name
     * @return PrintStream object opened on output file
     * @throws FileNotFoundException
     * pre: user is prepared to enter file name at the keyboard
     * post: file have been opened
     */
    private static PrintStream openOutputFile (Scanner keyboard) throws FileNotFoundException {
        // open output data file
        String outFileName;
        System.out.print("Enter the name of the output file: ");
        outFileName = keyboard.nextLine();
        File f2 = new File(outFileName);
        PrintStream outfile = new PrintStream(f2);
        return outfile;
    }


}