package com.geekmere;

import java.util.ArrayList;

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

}
