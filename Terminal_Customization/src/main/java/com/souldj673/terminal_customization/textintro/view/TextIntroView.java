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
package com.souldj673.terminal_customization.textintro.view;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author souldj673
 */
public class TextIntroView {

    public void displayText(String text) {
        String decor = ">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>"
                + ">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>"
                + ">>>>>>>>>>>>>>>>";
        List<String> tokens = new ArrayList<>();
        if (text.length() >= 72) {
            int i = 0;
            do {
                tokens.add(text.substring((i * 72), ((i * 71) + (i * 1))));
                i++;
            } while (!tokens.get(i).isEmpty());
        } else {
            tokens.add(text);
        }
        String decorTrim = decor.substring(0, (tokens.get(0).length() + 8));

        System.out.println(decorTrim);
        for (String currentLine : tokens) {
            if (currentLine.length() == 72) {
                System.out.println(">>> " + tokens + " >>>");
            } else if (currentLine.length() % 2 == 0) {
                System.out.println(centerText(currentLine, 1));
            } else {
                System.out.println(centerText(currentLine, 2));
            }
        }
    }

    private String centerText(String token, int type) {
        switch (type) {
            case 1:
                int space = ((72 / 2) - (token.length() / 2));
                String spaceS = "";
                for (int i = 0; i < space; i++) {
                    spaceS = spaceS + " ";
                }
                return new String(">>> " + spaceS + token + spaceS + " >>>");
            case 2:
                int space2 = ((72 / 2) - (token.length() / 2));
                String space2S = "";
                for (int i = 0; i < space2; i++) {
                    space2S = space2S + " ";
                }
                return new String(">>> " + space2S + " " + token + space2S + " >>>");
            default:
                return token;
        }
    }
}
