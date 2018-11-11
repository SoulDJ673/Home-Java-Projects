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

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 *
 * @author souldj673
 */
public class ComptonToggleDaoImpl implements ComptonToggleDao {

    Map<String, Process> processes = new HashMap<>();

    @Override
    public void loadFromFile() throws FileNotFoundException {
        Scanner scanner = new Scanner(new BufferedReader(
                new FileReader("processes.log")));

        while (scanner.hasNextLine()) {
            String currentLine = scanner.nextLine();
            
        }
    }
    
    private Process unmarshallProcess(String marshalledProcess) {
        /**
         * 
         */
    }

    @Override
    public Process readProcess(String cmd) {
        return processes.get(cmd);
    }

    @Override
    public void writeToFile() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
