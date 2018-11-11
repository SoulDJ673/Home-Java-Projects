/*
 * Copyright (C) 2018 souldj673
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */
package com.souldj673.comptontoggle.dao;

import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author souldj673
 */
public interface ComptonToggleDao {

    Map<String, RunningProcess> processes = new HashMap<>();

    /**
     * This will be used to load the process list into memory, stripping
     * unneeded information
     */
    public void loadFromFile() throws FileNotFoundException;

    /**
     * This will be used to write the stop cmd to a file (with compton pid)
     */
    public void writeToFile();

    /**
     * This will be used to read keys loaded into memory from LoadFromFile()
     */
    public RunningProcess readProcess(String cmd);
}
