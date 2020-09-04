package com.geekmere;

import java.io.FileReader;
import java.util.ArrayList;
import java.util.Scanner;

public class Group
{
    private String path; //сохранение пути к файлу .saml
    public static ArrayList<String> groupItems = new ArrayList<>(); //динамический массив для сохранения объектов группы с тегами

    public Group(String path) //констурктор класса, принимающий путь к файлу .saml
    {
        this.path = path;
    }

    public void getGroup(String groupTag) //поиск группы объектов из файла .saml, принимающий тег объекта группы
    {
        groupItems.clear();
        String text = getText();
        String[] blocks = text.split("\n");
        for (String block: blocks)
        {
            if(block.contains("</" + groupTag + ">"))
            {
                break;
            }
            if (!block.contains("<" + groupTag + ">"))
            {
                groupItems.add(block.trim());
            }
        }

    }

    private String getText() //метод для взятия разметки из файла .saml
    {
        String text = "";
        try
        {
            FileReader fr = new FileReader(this.path);
            Scanner scan = new Scanner(fr);

            while (scan.hasNextLine())
            {
                text += scan.nextLine() + "\n";
            }
            fr.close();
        }
        catch(Exception e)
        {
            System.out.println("SALM.ERROR - File not found");
        }
        return text;
    }


}
