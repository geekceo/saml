package com.geekmere;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Scanner;

public class Item
{
    public static String getContent(String itemTag, ArrayList<String> groupItems) //метод для поиска контента в тегах объхектов группы
    {
        String content = "";
        for (int i = 0; i < groupItems.size(); i++)
        {
            if (groupItems.get(i).contains(itemTag))
            {

                content = groupItems.get(i).substring(groupItems.get(i).indexOf(">")+1, groupItems.get(i).lastIndexOf("<"));
            }
        }
        return content;
    }

    public static void editContent(String itemTag, String content, String path)
    {

        try {
            FileReader fr = new FileReader(path);
            Scanner scan = new Scanner(fr);

            String allText = "";

            while (scan.hasNextLine())
            {
                allText += scan.nextLine() + "\n";
            }

            fr.close();

            FileWriter fw = new FileWriter(path);

            String[] stringsText = allText.split("\n");

            for (String string: stringsText)
            {
                if (!string.contains(itemTag))
                {
                    fw.write(string + "\n");
                }
                else
                {
                    fw.write("<" + itemTag + ">" + content + "</" + itemTag + ">\n");
                }
            }

            fw.close();


        } catch (IOException e) {
            System.out.println("SALM.ERROR - File not found\"");
        }
    }

}
