import java.io.*;
import java.net.*;

class Client{
  public static void main(String[] args) {
    try{
      BufferedReader client_name = new BufferedReader(new InputStreamReader(System.in));
      System.out.println("Anda adalah client !");
      System.out.print("Silahkan masukkan nickname : ");
      String nama = client_name.readLine();

      System.out.println();
      System.out.println();
      System.out.println();
      System.out.println("Starting Client ............");

      Socket s = new Socket("127.0.0.1",1201); //parameter yang digunakan adalah IP server dan port yang digunakan
      DataInputStream din = new DataInputStream(s.getInputStream());
      DataOutputStream dout = new DataOutputStream(s.getOutputStream());

      BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
      String msgin="",msgout="";

      System.out.println("Status OK !");
      System.out.println();
      System.out.println();

      while(!msgin.equals("end")){
        msgout = br.readLine();
        dout.writeUTF(nama+" : "+msgout);
        msgin = din.readUTF();
        System.out.println(msgin);
      }

      s.close();
    }catch(Exception e){
      //error handling
    }
  }
}
