package Managers;

import ClassModel.Organization;
import Utils.Console;
import java.io.*;
import java.util.Collection;
import java.util.Stack;
import au.com.bytecode.opencsv.*;

/**
 * Класс DumpManager. Отвечает за работу с файлами.
 * @author DenisLukash
 */
public class DumpManager {
    private final String fileName;
    private final Console console;

    public DumpManager(String fileName, Console console) {
        this.fileName = fileName;
        this.console = console;
    }


    /**
     * Переводит коллекцию в строку для загрузки в csv файл.
     */
    private String collectionToCSV(Collection<Organization> collection) {
        try {
            StringWriter sw = new StringWriter();
            CSVWriter csvWriter = new CSVWriter(sw, ';');
            for (Organization o : collection) {
                csvWriter.writeNext(Organization.toArray(o));
            }
            String csv = sw.toString();
            return csv;
        } catch (Exception e) {
            console.printError("Ошибка сериализации");
            return null;
        }
    }

    /**
     * Записывает коллекцию в csv файл.
     */
    public void writeCollection(Collection<Organization> collection) {
        try (FileOutputStream writer = new FileOutputStream(fileName)) {
            String csv = collectionToCSV(collection);
            if (csv == null) return;
            try {
                for(int i=0; i<csv.length(); i++){
                    writer.write(csv.charAt(i));
                }
                console.println("Коллекция успешна сохранена в файл!");
            } catch (IOException e) {
                console.printError("Неожиданная ошибка сохранения");
            }
        } catch (FileNotFoundException | NullPointerException e) {
            console.printError("Файл не найден");
        } catch (IOException e) {
            console.printError("Ошибка при записи файла");
        }
    }

    /**
     * Преобразует строку, полученную от csv файла в коллекцию.
     */
    private Stack<Organization> CSVToСollection(String s) {
        try {
            StringReader sr = new StringReader(s);
            CSVReader csvReader = new CSVReader(sr, ';');
            Stack<Organization> stack = new Stack<>();
            String[] record;
            while ((record = csvReader.readNext()) != null) {
                Organization o = Organization.fromArray(record);
                if (o.validate()) stack.add(o);
                else{
                    console.printError("Файл с колекцией содержит не действительные данные");
                    System.exit(1);
                }
            }
            csvReader.close();
            return stack;
        } catch (Exception e) {
            console.printError("Ошибка десериализации");
            System.exit(1);
            return null;
        }
    }

    /**
     * Считывает данные из csv файла.
     */
    public void readCollection(Collection<Organization> collection) {
        if (fileName != null && !fileName.isEmpty()) {
            try (FileInputStream inputStream = new FileInputStream(new File(fileName));
                 InputStreamReader inputStreamReader = new InputStreamReader(inputStream);
            ) {
                StringBuilder s = new StringBuilder();
                int c;
                while ((c=inputStreamReader.read())!=-1) {
                    s.append((char) c);
                }
                collection.clear();
                for (Organization o: CSVToСollection(s.toString()))
                    collection.add(o);
                if (collection != null) {
                    console.println("Коллекция успешна загружена!");
                    return;
                } else
                    console.printError("В загрузочном файле не обнаружена необходимая коллекция!");
                    System.exit(1);
            } catch (FileNotFoundException exception) {
                console.printError("Загрузочный файл не найден!");
                System.exit(1);
            } catch (Exception exception){
                System.exit(1);
            }
        } else {
            console.printError("Аргумент командной строки с загрузочным файлом не найден!");
            System.exit(1);
        }
        collection = new Stack<Organization>();
    }
}