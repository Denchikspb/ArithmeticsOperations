package com.cherepanovd.Reader;


import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FileReader {

    public static List<String[]> readFile(String filepath){
        final List<String[]> dataList = new ArrayList<String[]>();

        BufferedReader reader;
        String line;

        try{
            reader = new BufferedReader(new java.io.FileReader(filepath));
            while((line = reader.readLine()) != null){
                String[] str = line.split(";");

                dataList.add(str);
            }
        }catch (FileNotFoundException ex){
            ex.printStackTrace();
        }catch (IOException e){
            e.printStackTrace();
        }

        return dataList;
    }

//    public static void main(String[] args) {
//        List<String[]> data = FileReader.readFile("src/main/resources/datafile");
//        for (String[] s: data){
//            if("+".equals(s[2]))
//                System.out.println(Arrays.toString(s));
//        }
//    }


}
