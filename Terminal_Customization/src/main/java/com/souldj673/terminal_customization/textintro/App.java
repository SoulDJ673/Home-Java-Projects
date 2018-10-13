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
package com.souldj673.terminal_customization.textintro;

import com.souldj673.terminal_customization.textintro.controller.TextIntroController;
import com.souldj673.terminal_customization.textintro.view.TextIntroView;

/**
 *
 * @author souldj673
 */
public class App {

    private static final TextIntroView VIEW = new TextIntroView();
    private static final TextIntroController CONTROLLER = new TextIntroController(VIEW);

    public static void main(String[] args) {
        CONTROLLER.run();
    }
}