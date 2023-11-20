package home_task_23_11_16.task_2.listFilesAndFolders;

import java.io.File;

public class ListFilesAndFolders {
    public static void listFilesAndFolders(String directoryPath) {
        //абсолютный путь к указанной директории
        File directory = new File(directoryPath);

        //пока не достигнут корень диска
        while (directory != null) {
            System.out.println("Path: " + directory.getAbsolutePath());
            System.out.println("Files: ");
            File[] files = directory.listFiles();
            if (files != null) {
                for (File file : files) {
                    if (file.isFile()) {
                        System.out.println("  " + file.getName());
                    }
                }
            }

            System.out.println("Folders: ");
            if (files != null) {
                for (File file : files) {
                    if (file.isDirectory()) {
                        System.out.println("  " + file.getName());
                    }
                }
            }

            System.out.println("\n");

            //получаю родительский каталог
            directory = directory.getParentFile();
        }
    }

    public static void main(String[] args) {
        //запрашиваю у пользователя путь к директории
        java.util.Scanner scanner = new java.util.Scanner(System.in);
        System.out.print("Enter the path to folder: ");
        String userDirectory = scanner.nextLine();

        //вызываю метод для отображения файлов и папок
        listFilesAndFolders(userDirectory);
    }
}
