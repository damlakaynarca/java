package FileOperations;

import java.io.*;

public class FileManager implements  FileService{
    @Override
    public void fileWriterDenemeData(int deneme) {

        try (BufferedWriter bw = new BufferedWriter(new FileWriter(FileStatic.DENEME_PATH, true))){
                bw.write(Integer.toString(deneme));

        } catch (IOException e) {
            System.err.println("Dosya yazma hatası: " + e.getMessage());
        }

    }

    @Override
    public void fileReaderDenemeData() {
        try (BufferedReader br = new BufferedReader(new FileReader(FileStatic.DENEME_PATH))) {
            String satir = br.readLine();

            if (satir != null) {
                int sayi = Integer.parseInt(satir);
                int sonSayi = sayi % 10;
                System.out.println("Deneme Hakkı : " + sonSayi);
            } else {
                System.out.println("Dosya boş.");
            }
        } catch (IOException e) {
            System.err.println("Dosya okuma hatası: " + e.getMessage());
        }
    }

    @Override
    public void fileWriterData(String data) {

        try (BufferedWriter bw = new BufferedWriter(new FileWriter(FileStatic.PARALEL_PATH))) {
            bw.write(data);
        } catch (IOException e) {
            System.err.println("Dosya yazma hatası: " + e.getMessage());
        }
    }

    @Override
    public void fileReaderData() {
        try (BufferedReader br = new BufferedReader(new FileReader(FileStatic.PARALEL_PATH))) {
            String satir;

            while ((satir = br.readLine()) != null) {
                System.out.println("Girilen data: "+satir);
            }
        } catch (IOException e) {
            System.err.println("Dosya okuma hatası: " + e.getMessage());
        }
    }
}
