package nl.jchmb.netspace.network;

public interface Connector {
	public String getHost();
	public int getTimeout();
	public int getTCPPort();
	public int getUDPPort();
	public boolean supportsUDP();
}
