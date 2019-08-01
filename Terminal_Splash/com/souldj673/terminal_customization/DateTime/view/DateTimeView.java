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
package com.souldj673.terminal_customization.DateTime.view;

/**
 *
 * @author souldj673
 */
public class DateTimeView {

    public void displayDateTime(String dateTime, char bannerBorder) {
        banner(dateTime, Character.toString(bannerBorder));
    }

    private void banner(String content, String borderMaterial) {
        // Create border from specified char
        String border = "";
        for (int i = 0; i < content.length() + 8 ; i++ ) {
            border = border + borderMaterial;
        }

        // Border sides
        String borderLeft = "";
        String borderRight = "";
        for(int i = 0; i < 4; i++) {
            if(i == 0) {
                borderRight = borderRight + " ";
                borderLeft = borderLeft + borderMaterial;
            } else if(i == 3) {
                borderLeft = borderLeft + " ";
                borderRight = borderRight + borderMaterial;
            } else {
                borderRight = borderRight + borderMaterial;
                borderLeft = borderLeft + borderMaterial;
            }
        }

        System.out.println(border);
        System.out.println(borderLeft + content + borderRight);
        System.out.println(border);
    }
}
