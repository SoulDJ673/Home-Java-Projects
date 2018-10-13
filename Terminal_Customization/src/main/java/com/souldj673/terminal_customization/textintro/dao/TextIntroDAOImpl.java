package com.souldj673.terminal_customization.textintro.dao;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author souldj673
 */
public class TextIntroDAOImpl implements TextIntroDAO {

    private final String TEXTINTRO;

    public TextIntroDAOImpl(String TextIntro) {
        this.TEXTINTRO = TextIntro;
    }

    //Item Inventory
    private List<String> textIntro = new ArrayList<>();

    @Override
    public void loadAllStrings() throws FileNotFoundException {

        Scanner scanner;

        try {
            scanner = new Scanner(
                    new BufferedReader(
                            new FileReader(TEXTINTRO)));

        } catch (FileNotFoundException ex) {
            throw new FileNotFoundException("Couldn't find the text intro "
                    + "file!");
        }

        String currentLine;

        while (scanner.hasNextLine()) {
            currentLine = scanner.nextLine();
            textIntro.add(currentLine);
        }
        scanner.close();
    }

    @Override
    public void saveAllChanges() throws FileNotFoundException {
        PrintWriter save;
        try {
            save = new PrintWriter(new FileWriter(TEXTINTRO));
        } catch (IOException e) {
            throw new FileNotFoundException("Uh oh! The inventory is "
                    + "nowhere to be found! Unable to write to inventory.");
        }

        List<String> allStrings = textIntro;

        for (String currentString : allStrings) {
            save.println(currentString);
            save.flush();
        }

        save.close();
    }

    @Override
    public String getAString(int i) {
        return textIntro.get(i);
    }

    @Override
    public List<String> getAllStrings() {
        return textIntro;
    }

}
