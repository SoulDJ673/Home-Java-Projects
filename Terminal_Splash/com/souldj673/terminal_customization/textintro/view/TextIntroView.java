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

    //Initialized in displayText
    char decorChar;

    public void displayText(String text, char borderChar) {

        decorChar = borderChar;

        //Create border decor (customizable via borderChar)
        String decor = borderCreate();

        //Separate text into displayable lines based from length
        List<String> tokens = new ArrayList<>();
        if (text.length() >= 72) {
            int i = 0;

            division:
            do {
                if(i == 0) {
                    tokens.add(text.substring(0, 72));
                } else {
                    try {
                        try {
                            tokens.add(text.substring((i * 72), ((i + 1) * 72)));
                        } catch(StringIndexOutOfBoundsException e) {
                            tokens.add(text.substring(i * 72, text.length()));
                        }
                    } catch(Exception e) {
                        break division;
                    }
                }
                i++;
            } while (!tokens.get(i - 1).isEmpty());
        } else {
            tokens.add(text);
        }

        System.out.println(decor);
        for (String currentLine : tokens) {
            if (currentLine.length() == 72) {
                System.out.println(centerText(currentLine, 1));
            } else if (currentLine.length() % 2 == 0) {
                System.out.println(centerText(currentLine, 2));
            } else {
                System.out.println(centerText(currentLine, 3));
            }
        }
        System.out.println(decor);
    }

    private String centerText(String token, int type) {
        // Make the border side out of specified char
        String borderLeft = "";
        String borderRight = "";
        for(int i = 0; i < 4; i++) {
            if(i == 0) {
                borderRight = borderRight + " ";
                borderLeft = borderLeft + Character.toString(decorChar);
            } else if(i==3) {
                borderLeft = borderLeft + " ";
                borderRight = borderRight + Character.toString(decorChar);
            } else {
                borderRight=borderRight+Character.toString(decorChar);
                borderLeft=borderLeft+Character.toString(decorChar);
            }
        }

        //Centers text based on whether the count of letters in the String is even/odd
        switch (type) {
        case 1:
            return new String(borderLeft + token + borderRight);
        case 2:
            int space = ((72 / 2) - (token.length() / 2));
            String spaceS = "";
            for (int i = 0; i < space; i++) {
                spaceS = spaceS + " ";
            }
            return new String(borderLeft + spaceS + token + spaceS + borderRight);
        case 3:
            int space2 = ((72 / 2) - (token.length() / 2) - 1);
            String space2S = "";
            for (int i = 0; i < space2; i++) {
                space2S = space2S + " ";
            }
            return new String(borderLeft + space2S + " " + token + space2S + borderRight);
        default:
            return token;
        }
    }

    private String borderCreate() {
        //This method just repeats a char 80 times and returns the resulting string.  Preparation for custom border.
        String border = "";
        for (int i = 0; i < 80 ; i++ ) {
            border = border + Character.toString(decorChar);
        }
        return border;
    }

    public void fileError() {
        System.out.println("Check to ensure the existence of the text file");
    }
}
