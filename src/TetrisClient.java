import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.UUID;

public class TetrisClient extends Thread {
	private String host;
	private int port;
	private  BufferedReader  i;
    private  PrintWriter     o;
    private TetrisNetworkCanvas netCanvas;
    private TetrisCanvas tetrisCanvas;
    private String key;
    public TetrisClient(TetrisCanvas tetrisCanvas, TetrisNetworkCanvas netCanvas, String host, int port) {
    	this.tetrisCanvas = tetrisCanvas;
    	this.netCanvas = netCanvas;
    	this.host = host;
    	this.port = port;
    	
    	UUID uuid = UUID.randomUUID();
		key = uuid.toString()+";";
		System.out.println("My key: "+key);
    }
    
    public void send() {
    	String data = tetrisCanvas.getData().saveNetworkData();
		System.out.println("send: "+data);
		o.println(key+data);
    }
    
	public void run() {
		System.out.println("client start!");
		Socket s;
		try {
			s = new Socket(host, port);
			InputStream ins = s.getInputStream();
			OutputStream os = s.getOutputStream();
			i = new BufferedReader(new InputStreamReader(ins));
			o = new PrintWriter(new OutputStreamWriter(os), true);
			
			while (true) {
				String line = i.readLine();
				if(line.length() != 0)
				{
					String[] parsedData = line.split(";");
					String checkKey = parsedData[0]+";";
					if(!checkKey.equals(key)) {
						netCanvas.getData().loadNetworkData(parsedData[1]);
					}
				}
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
