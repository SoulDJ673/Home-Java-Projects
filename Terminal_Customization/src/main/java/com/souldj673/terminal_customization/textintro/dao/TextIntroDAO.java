package com.souldj673.terminal_customization.textintro.dao;

import java.io.FileNotFoundException;
import java.util.List;

/**
 *
 * @author souldj673
 */
public interface TextIntroDAO {

    public void loadAllStrings()
            throws FileNotFoundException;

    public void saveAllChanges()
            throws FileNotFoundException;

    public String getAString(int i);
    
    public List<String> getAllStrings();

}
