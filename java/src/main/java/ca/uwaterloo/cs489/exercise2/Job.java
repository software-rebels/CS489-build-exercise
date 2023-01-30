package ca.uwaterloo.cs489.exercise2;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.*;

public class Job {
  private File file;
  private int input;

  public Job(File file) throws IOException, FileNotFoundException {
    this.file = file;

    BufferedReader br = new BufferedReader(new FileReader(file));
    this.input = Integer.parseInt(br.readLine());
  }

  public int processJob() {
    int rtn = input;

    if (input == 0 || input == 1) {
      return 1;
    }

    for (int i = input-1; i > 1; i--) {
      rtn *= i;
    }

    return rtn;
  }

  public int getInput() {
    return this.input;
  }
  
  public void deleteFile(Job job) {
    if (job.delete()) {
            System.out.println("File deleted successfully");
        }
        else {
            System.out.println("Failed to delete the file");
        }
  }

  public void deleteDirectoryRecursion(Path path) throws IOException {
    if (Files.isDirectory(path, LinkOption.NOFOLLOW_LINKS)) {
      try (DirectoryStream<Path> entries = Files.newDirectoryStream(path)) {
        for (Path entry : entries) {
          deleteDirectoryRecursion(entry);
        }
      }
    }
    Files.delete(path);
    System.out.println("Directory deleted");
  }
}
