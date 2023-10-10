package Tetris;
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
	private BufferedReader  i;
    private PrintWriter     o;
    private TetrisNetworkCanvas netCanvas;
    private TetrisNetworkPreview netPreview;
    private TetrisCanvas tetrisCanvas;
    private String key;
    
    public TetrisClient(TetrisCanvas tetrisCanvas, TetrisNetworkCanvas netCanvas, TetrisNetworkPreview netPreview, String host, int port) {
    	this.tetrisCanvas = tetrisCanvas;
    	this.netCanvas = netCanvas;
    	this.netPreview = netPreview;
    	this.host = host;
    	this.port = port;
    	
    	UUID uuid = UUID.randomUUID();
		key = uuid.toString()+";";
		System.out.println("My key: "+key);
    }
    
    public void send() {
    	String data = tetrisCanvas.getData().saveNetworkData();
    	int newBlock = tetrisCanvas.getNewBlock().getType();
    	String current = tetrisCanvas.current.extractor();
		o.println(key+data+";"+newBlock+";"+current);
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
					if(!checkKey.equals(key) && parsedData.length > 1) {
						netCanvas.getData().loadNetworkData(parsedData[1]);
						switch(Integer.parseInt(parsedData[2])){
						case 1: //Bar
							netPreview.setNewBlock(new Bar(new TetrisData()));
							break;
						case 2: //Tee
							netPreview.setNewBlock(new Tee(new TetrisData()));
							break;
						case 3: //El
							netPreview.setNewBlock(new El(new TetrisData()));
							break;
						case 4: //Er
							netPreview.setNewBlock(new Er(new TetrisData()));
							break;
						case 5: //Square
							netPreview.setNewBlock(new Square(new TetrisData()));
							break;
						case 6: //Kl
							netPreview.setNewBlock(new Kl(new TetrisData()));
							break;
						case 7: //Kr
							netPreview.setNewBlock(new Kr(new TetrisData()));
							break;
						default:
							netPreview.setNewBlock(null);
							break;
						}
						
						Piece tmpP = new Bar(new TetrisData());
						tmpP.combinator(parsedData[3]); //currentPiece
						netCanvas.setCurrent(tmpP);
					}
				}
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
