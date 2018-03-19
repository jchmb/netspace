package nl.jchmb.netspace.space.factory;

import nl.jchmb.netspace.entity.manager.factory.EntityManagerFactory;
import nl.jchmb.netspace.message.registry.factory.MessageRegistryFactory;
import nl.jchmb.netspace.space.ClientNetSpace;
import nl.jchmb.netspace.system.manager.factory.SystemManagerFactory;

public class ClientNetSpaceFactory extends BaseNetSpaceFactory<ClientNetSpace> {

	public ClientNetSpaceFactory(
			EntityManagerFactory entityManagerFactory,
			SystemManagerFactory systemManagerFactory,
			MessageRegistryFactory messageRegistryFactory
	) {
		super(entityManagerFactory, systemManagerFactory, messageRegistryFactory);
	}

	@Override
	public final ClientNetSpace create() {
		return new ClientNetSpace(
			this.entityManagerFactory,
			this.systemManagerFactory,
			this.messageRegistryFactory
		);
	}
	
}
