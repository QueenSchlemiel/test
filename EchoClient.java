import javax.net.SocketFactory;
import javax.net.ssl.SSLSocketFactory;
import java.net.ServerSocket;
import java.net.Socket;

public class echoClient
{
 public static void main( String[] args ) throws Exception{
  String hostname = "localhost";
  if(args.length > 0)
     hostname = args[0];

  SocketFactory sf = SSLSocketFactory.getDefault();
  Socket socket = sf.createSocket(hostname,2950);
  System.out.println("Connection established.");
//  SocketUtil.printSocketInfo(socket, " --> ");

  java.io.InputStream is = socket.getInputStream();
  java.io.OutputStream os = socket.getOutputStream();
  byte[] buf = new byte[1024];
  java.io.BufferedReader br = new java.io.BufferedReader( new java.io.InputStreamReader(System.in));

  while (true) 
  {
    System.out.print("Enter message (Type \"Quit\" to exit): ");

    System.out.flush();

    String inp = br.readLine();
    if( inp.equalsIgnoreCase("quit"))
      break;

    os.write(inp.getBytes());

    int n = is.read(buf);
    System.out.println("Server Returned: " + new String(buf, 0, n));
  }
  socket.close();
  System.out.println("Connection closed.");
 }
}
