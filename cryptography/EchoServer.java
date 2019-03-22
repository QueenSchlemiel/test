// Program to accept SSL connections and
// read/write data-bytes. Obtained from
// J2EE security by Pankaj Kumar, page 165.


import javax.net.ServerSocketFactory;
import javax.net.ssl.SSLServerSocketFactory;
import javax.net.ssl.SSLServerSocket;
import java.net.ServerSocket;
import java.net.Socket;

public class EchoServer
{
  public static void main( String[] args) throws 	Exception{
	  ServerSocketFactory ssf =   SSLServerSocketFactory.getDefault();
	  ServerSocket ss = 	ssf.createServerSocket(2950);

 // Placeholder for additional code

  while( true )
  {
     System.out.print("Waiting for connection... ");
     System.out.flush();
     Socket socket = ss.accept();
     System.out.println("...connection accepted.");
   //  SocketUtil.printSocketInfo(socket, " <--- ");

     java.io.InputStream is = socket.getInputStream();
     java.io.OutputStream os = socket.getOutputStream();
     int nread = 0;
     byte[] buf = new byte[1024];

     while( (nread = is.read(buf)) != -1)
     {
        System.out.println("Read " + nread + " 		bytes.");
        os.write(buf, 0, nread);
        System.out.println("Wrote " + nread + " 		bytes.");
     } // inner while
   } // while (true)
  } // main()

}
