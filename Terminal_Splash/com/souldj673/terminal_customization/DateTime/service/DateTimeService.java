/*
 * Copyright (C) 2019 souldj673
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
package com.souldj673.terminal_customization.DateTime.service;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 *
 * @author souldj673
 */
public class DateTimeService {

    public DateTimeService() {}

    public String getDateTime() {
        LocalDateTime dateTime = LocalDateTime.now();
        DateTimeFormatter simple = DateTimeFormatter.ofPattern("EEEE MMMM dd, yyyy");

        return dateTime.format(simple);
    }

    public char extractBorderChar(String[] args) {

        // Make sure args isn't null or empty
        if(args.length == 0 || args == null) {
            return ">".charAt(0);
        }
        // Cycle through args to find --borderChar=, extract char
        for(String arg : args) {
            if(arg.contains("--borderChar=")) {
                try {
                    return arg.replace("--borderChar=", "").charAt(0);
                } catch(StringIndexOutOfBoundsException e) {
                    // This will happen when someone uses --borderChar= but doesn't specify a char
                    return ">".charAt(0);
                }
            }
        }
        // Defaults to ">" if char isn't specified
        return ">".charAt(0);
    }
}
