package com.geekmere;

import java.nio.file.Path;
import java.util.ArrayList;

public class GroupParser
{
    private Path path;

    public GroupParser(Path path)
    {
        this.path = path;
    }

    public Path getPath()
    {
        return this.path;
    }


}
