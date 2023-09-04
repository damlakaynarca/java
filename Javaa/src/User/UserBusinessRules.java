package User;

import FileOperations.FileManager;
import FileOperations.FileService;

import java.util.Scanner;

public class UserBusinessRules {

    private final FileService fileService;

    public UserBusinessRules() {
        this.fileService = new FileManager();
    }

    public void Login(){


        Scanner scanner= new Scanner(System.in);

        int tryingNumber=0;
        while (tryingNumber<UserLogin.WRONG_NUMBER_OF_ENTRIES || !UserLogin.IS_LOGIN){
            System.out.println("Kullanıcı adı giriniz: ");
            String userName= scanner.nextLine();

            System.out.println("Kullanıcı şifresi giriniz: ");
            String password= scanner.nextLine();
          boolean check=checkPasswordAndUserName(userName,password);

          if (check ==true){
              UserLogin.IS_LOGIN=true;
              dataEntry(scanner);
              this.fileService.fileReaderData();
              return;
          }else {
              tryingNumber++;
              this.fileService.fileWriterDenemeData(UserLogin.WRONG_NUMBER_OF_ENTRIES-tryingNumber);
              this.fileService.fileReaderDenemeData();
              if (tryingNumber==4) break;
          }
        }

    }

         private boolean checkPasswordAndUserName(String userName, String password)  {
        if (userName.equals(UserLogin.USERNAME)  && password.equals(UserLogin.PASSWORD)){
            return true;
        }else {
            return false;
        }
    }

    private void dataEntry(Scanner scanner){
        System.out.println("Herhangi bir data giriniz.");
        String data=scanner.nextLine();
        this.fileService.fileWriterData(data);
    }


}
