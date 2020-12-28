
package Vibes.pk;

import java.io.File;
import javax.swing.filechooser.FileFilter;

public class FileTypeFilter extends FileFilter{
    
  
    private final String extension;

    private final String description;
    
    // Constructor Method
    public FileTypeFilter(String extension, String description){
        // Contructor Values
        this.extension = extension;
        this.description = description;
    }
    
    @Override
    public boolean accept(File file) {
        // If File Is Returning Directory
        if(file.isDirectory()){
            return true;
        }
        // Return File Name with Extension
        return file.getName().endsWith(extension);
    }

    @Override
    public String getDescription() {
        // Return  Display File Type and Description
        return description + String.format(" (*%s)", extension);
    }
    
}
