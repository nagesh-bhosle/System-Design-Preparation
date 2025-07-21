/**
 * Composite Design Pattern Example
 * This example demonstrates the Composite Design Pattern
 * where files and directories can be treated uniformly.
 * Files can be individual files or directories that can contain other files or directories.
 * The pattern allows for a tree structure where both leaves (files) and composites (directories) can be treated uniformly.
 * This code defines a simple file system structure with files and directories.
 * The `File` interface defines the common operations,
 * `FileLeaf` represents individual files,
 * and `DirectoryComposite` represents directories that can contain files or other directories.
 * The `showDetails` method is used to display the structure of files and directories.
 * 
 */

import java.util.*;
import java.io.*;
import java.lang.*;

interface File
{
    void showDetails();
    void addFile(File file);
}

class FileLeaf implements File
{
    private String name;

    public FileLeaf(String name)
    {
        this.name = name;
    }

    @Override
    public void showDetails()
    {
        System.out.println("File: " + name);
    }

    @Override
    public void addFile(File file)
    {
        // Leaf nodes cannot add files
        throw new UnsupportedOperationException("Cannot add file to a leaf node");
    }
}

class DirectoryComposite implements File
{
    private String name;
    private List<File> files = new ArrayList<>();

    public DirectoryComposite(String name)
    {
        this.name = name;
    }

    @Override
    public void showDetails()
    {
        System.out.println("Directory: " + name);
        for (File file : files)
        {
            file.showDetails();
        }
    }

    @Override
    public void addFile(File file)
    {
        files.add(file);
    }
}

public class CompositeDP
{
    public static void main(String[] args)
    {
        // Create files
        File file1 = new FileLeaf("File1.txt");
        File file2 = new FileLeaf("File2.txt");

        // Create a directory and add files to it
        DirectoryComposite directory = new DirectoryComposite("MyDirectory");
        directory.addFile(file1);
        directory.addFile(file2);

        // Create a subdirectory and add it to the main directory
        DirectoryComposite subDirectory = new DirectoryComposite("SubDirectory");
        subDirectory.addFile(new FileLeaf("SubFile1.txt"));
        directory.addFile(subDirectory);

        // Show details of the directory structure
        directory.showDetails();
    }
}
