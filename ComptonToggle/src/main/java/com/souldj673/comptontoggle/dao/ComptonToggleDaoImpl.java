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

import com.souldj673.comptontoggle.dto.RunningProcess;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 *
 * @author souldj673
 */
public class ComptonToggleDaoImpl implements ComptonToggleDao {

    Map<String, RunningProcess> processes = new HashMap<>();
    private final String DELIMITER = " ";

    @Override
    public void loadFromFile() throws FileNotFoundException {
        Scanner scanner = new Scanner(new BufferedReader(
                new FileReader("processes.log")));

        String currentLine;

        while (scanner.hasNextLine()) {
            currentLine = scanner.nextLine();
            RunningProcess currentProcess = unmarshallProcess(currentLine);

            /**
             * Make sure different processes with the same names don't overwrite
             * each other
             */
            int x = 1;
            if (processes.containsKey(currentProcess.getCmd())) {
                currentProcess.setCmd(currentProcess.getCmd() + x);
                x++;
            }

            processes.put(currentProcess.getCmd(), currentProcess);
        }
        scanner.close();
    }

    private RunningProcess unmarshallProcess(String marshalledProcess) {
        String[] pieces = marshalledProcess.split(DELIMITER);
        String[] cherryPickedPieces = new String[4];

        /**
         * Check for empty Strings, remove
         */
        int i = 0;
        for (String piece : pieces) {
            if (!piece.trim().isEmpty()) {
                cherryPickedPieces[i] = piece;
            }
        }
        RunningProcess currentProcess = new RunningProcess(cherryPickedPieces[3]);
        currentProcess.setPid(Integer.parseInt(cherryPickedPieces[0]));
        currentProcess.setTty(cherryPickedPieces[1]);

        /**
         * Convert String to DateTime
         */
        DateTimeFormatter simple = DateTimeFormatter.ofPattern("hh:mm:ss");
        LocalDateTime runtime = LocalDateTime.parse(cherryPickedPieces[2], simple);
        currentProcess.setTime(runtime);

        return currentProcess;
    }

    @Override
    public RunningProcess readProcess(String cmd) {
        return processes.get(cmd);
    }

    @Override
    public void writeToFile() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
