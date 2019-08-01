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
package com.souldj673.terminal_customization.DateTime.controller;

import com.souldj673.terminal_customization.DateTime.view.*;
import com.souldj673.terminal_customization.DateTime.service.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 *
 * @author souldj673
 */
public class DateTimeController {

    DateTimeView view;
    DateTimeService service;

    public DateTimeController(DateTimeView view, DateTimeService service) {
        this.view = view;
        this.service = service;
    }

    public void run(String[] args) {
        String dateTime = service.getDateTime();
        view.displayDateTime(dateTime, service.extractBorderChar(args));
    }
}
