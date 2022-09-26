package com.company;

import java.io.*;
import java.util.Scanner;

public class Main{
    public static void main(String[] args) throws IOException {
        Scanner in = new Scanner(System.in);
        System.out.println("Введите путь к файлу с текстом");
        String filename = in.nextLine();
        getWordCount(filename);
    }

    public static void getWordCount(String filename) throws IOException {
        File file = new File(filename);
        Scanner scanner = new Scanner(file);
        int words = 0;
        int length = (int) file.length();
        String text = "";
        while (scanner.hasNextLine()) {
            String[] array = scanner.nextLine().split(" ");
            words = words + array.length;
        }
        BufferedReader reader = new BufferedReader(new FileReader(filename));

        String line;
        while ((line = reader.readLine()) != null) {
            text += line;
        }
        System.out.println("Количество слов: " + words);
        System.out.println("Количетсво символов: " + length);
        System.out.println("Количетсов символов без пробела: "+ text.replaceAll(" ","").length());
        scanner.close();

        try(BufferedWriter bw = new BufferedWriter(new FileWriter("output.txt"))){
            bw.write("Количество слов: "+words+"\n");
            bw.write("Количетсво символов: "+length+"\n");
            bw.write("Количетсов символов без пробела: "+text.replaceAll(" ","").length());
        }
        catch(IOException ex){
            System.out.println(ex.getMessage());
        }
    }
}