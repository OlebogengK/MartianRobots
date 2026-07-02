package com.mars.grid;

import com.mars.model.Position;

import java.util.HashSet;
import java.util.Set;

public class ScentManager
{
    private final Set<Position> scents = new HashSet<>();

    public void addScent(Position position)
    {
        scents.add(position);
    }

    public boolean hasScent(Position position)
    {
        return scents.contains(position);
    }
}
