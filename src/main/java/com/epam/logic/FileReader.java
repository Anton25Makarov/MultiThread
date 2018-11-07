package com.epam.logic;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class FileReader {

    public List<String> readLines(String filePath) {
        List<String> stringList = new ArrayList<>();
        try (Scanner scanner = new Scanner(Paths.get(filePath), String.valueOf(StandardCharsets.UTF_8))) {
            while (scanner.hasNextLine()) {
                stringList.add(scanner.nextLine());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return stringList;
    }
}
