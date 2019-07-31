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
import com.souldj673.terminal_customization.textintro.dao.TextIntroDAO;
import com.souldj673.terminal_customization.textintro.dao.TextIntroDAOImpl;
import com.souldj673.terminal_customization.textintro.service.TextIntroService;
import com.souldj673.terminal_customization.textintro.view.TextIntroView;

/**
 *
 * @author souldj673
 */
public class TextIntroApp {

    private static final TextIntroView VIEW = new TextIntroView();
    private static final TextIntroDAO DAO = new TextIntroDAOImpl("TextIntro.txt");
    private static final TextIntroService SERVICE = new TextIntroService(DAO);
    private static final TextIntroController CONTROLLER = new TextIntroController(VIEW, SERVICE);

    public static void main(String[] args) {
        CONTROLLER.run();
    }
}
