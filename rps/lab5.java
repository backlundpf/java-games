import java.io.*;
import gnu.io.CommPortIdentifier; 
import gnu.io.SerialPort;
import gnu.io.SerialPortEvent; 
import gnu.io.SerialPortEventListener; 
import java.util.Enumeration;
import java.util.Scanner;

public class lab5 implements SerialPortEventListener {
	SerialPort serialPort;
	
        /** The port we're normally going to use. You need to change these to match your system*/
	private static final String PORT_NAMES[] = { 
			"/dev/tty.usbserial-A9007UX1", // Mac OS X
			"/dev/ttyUSB0", // Linux
			"COM60", // Windows
			"COM214", // Windows
			
			};
	
	/** Buffered input stream from the port */
	private InputStream input;
	
	/** The output stream to the port */
	private OutputStream output;
	
	/** Milliseconds to block while waiting for port open */
	private static final int TIME_OUT = 2000;
	
	/** Default bits per second for COM port. */
	private static final int DATA_RATE = 9600;

	public void initialize() {
		CommPortIdentifier portId = null;
		Enumeration portEnum = CommPortIdentifier.getPortIdentifiers();

		// iterate through, looking for the port
		while (portEnum.hasMoreElements()) { // Looking through all available ports for one that matches the one we want.
			CommPortIdentifier currPortId = (CommPortIdentifier) portEnum.nextElement(); // Make a new port
			for (String portName : PORT_NAMES) {
				if (currPortId.getName().equals(portName)) { // Is the current port name the same as one of the names in our list?
					portId = currPortId; //if so, use this port.
					break;
				}
			}
		}

		if (portId == null) { // We never found the port!
			System.out.println("Could not find COM port.");
			return;
		}

		try { // We think we know the port so lets TRY to open it. It might not work though so we are only TRYing it.
			// open serial port, and use class name for the appName.
			serialPort = (SerialPort) portId.open(this.getClass().getName(),
					TIME_OUT);

			// set port parameters
			serialPort.setSerialPortParams(DATA_RATE,
					SerialPort.DATABITS_8,
					SerialPort.STOPBITS_1,
					SerialPort.PARITY_NONE);

			// open the streams
			output = serialPort.getOutputStream();
			input = serialPort.getInputStream();
			
		} catch (Exception e) {
			System.err.println(e.toString());
		}
	System.out.println("Port opened successfully.");			
	}

	/**
	 * This should be called when you stop using the port.
	 * This will prevent port locking on platforms like Linux.
	 */
	public synchronized void close() {
		if (serialPort != null) {
			serialPort.removeEventListener();
			serialPort.close();
		}
	}

	public String getUARTLine(){
			String inputLine = null;

			try{
				BufferedReader input = new BufferedReader(new InputStreamReader(serialPort.getInputStream()));
				inputLine = input.readLine();
				if (inputLine.length() == 0)
					return null;
				} catch (IOException e){
					//System.out.println("IOException: " + e);
					return null;
				}
			return inputLine;
		}
	
	public char readUART(){
			int temp = '.';
			
			try{
				if (input.available() > 0)
					temp = input.read();
				if (temp == -1)
					return 0;
				} catch (IOException e){
					//System.out.println("IOException: " + e);
					return 0;
				}
		return (char)(byte)temp;
		}
	
	public int writeUART(char b){
			try{
				output.write((char)(byte)b);
				} catch (IOException e){
					//System.out.println("IOException: " + e);
					return -1;
				}
		return 1;
		}
	
	/**
	 * Handle an event on the serial port. Read the data and print it.
	 */
	public synchronized void serialEvent(SerialPortEvent oEvent) {
		if (oEvent.getEventType() == SerialPortEvent.DATA_AVAILABLE) {
			try {
				int available = input.available();
				byte chunk[] = new byte[available];
				input.read(chunk, 0, available);

				// Displayed results are codepage dependent
				System.out.print(new String(chunk));
			} catch (Exception e) {
				System.err.println(e.toString());
			}
		}
		// Ignore all the other eventTypes, but you should consider the other ones.
	}


	public static void main(String[] args) throws Exception {
		BufferedReader is = new BufferedReader(new InputStreamReader(System.in));
				
		System.out.println("Started");	
		lab5 main = new lab5();
		main.initialize();

		/** Your code should go here **/
		while (true){
		String temp = main.getUARTLine();
		if (temp != null)
			System.out.println(temp);
		if (is.ready()){
			String inputLine = is.readLine();
			System.out.println(inputLine);
			break;
			}
		}
		
		
		/*		

		while (true){
		String temp = main.getUARTLine();
		if (temp != null)
			System.out.println(temp);
		}*/

	}
}


