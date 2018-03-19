package nl.jchmb.netspace.network;

public class SimpleConnector implements Connector {
	private static final int DEFAULT_TIMEOUT = 5000;
	
	private final String host;
	private final int timeout;
	private final int tcpPort;
	private final int udpPort;
	
	public SimpleConnector(
			final int timeout,
			final String host,
			final int tcpPort,
			final int udpPort
	) {
		this.host = host;
		this.timeout = timeout;
		this.tcpPort = tcpPort;
		this.udpPort = udpPort;
	}
	
	public SimpleConnector(
			final int timeout,
			final String host,
			final int tcpPort
	) {
		this(timeout, host, tcpPort, -1);
	}
	
	public SimpleConnector(
			final String host,
			final int tcpPort
	) {
		this(DEFAULT_TIMEOUT, host, tcpPort);
	}
	
	public SimpleConnector(
			final String host,
			final int tcpPort,
			final int udpPort
	) {
		this(DEFAULT_TIMEOUT, host, tcpPort, udpPort);
	}
	
	@Override
	public final String getHost() {
		return this.host;
	}

	@Override
	public final int getTCPPort() {
		return this.tcpPort;
	}

	@Override
	public final int getUDPPort() {
		return this.udpPort;
	}

	@Override
	public final boolean supportsUDP() {
		return this.udpPort > 0;
	}

	@Override
	public final int getTimeout() {
		return this.timeout;
	}
	
}
