import java.io.*;
import java.net.*;

class Server{
  public static void main(String[] args) {
    try{
      System.out.println("Starting server ..............");

      ServerSocket ss = new ServerSocket(1201); //1201 adalah port yang akan digunakan
      Socket s = ss.accept();

      DataInputStream din = new DataInputStream(s.getInputStream());
      DataOutputStream dout = new DataOutputStream(s.getOutputStream());

      BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

      System.out.println("Status OK !");

      String msgin="",msgout="";
      while(!msgin.equals("end")){
        msgin = din.readUTF();
        System.out.println(msgin); //menampilkan pesan dari client
        msgout = br.readLine();
        dout.writeUTF("Server : "+msgout);
        dout.flush();

      }

      s.close();

    }catch(Exception e){
      //error handling
    }
  }
}
