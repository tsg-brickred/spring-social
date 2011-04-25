package org.brickred.socialauth.spring;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.springframework.social.connect.ServiceProviderConnectionFactory;
import org.springframework.social.connect.ServiceProviderConnectionFactoryLocator;

public class SocialAuthMapServiceProviderConnectionFactoryRegistry implements ServiceProviderConnectionFactoryLocator {

	private final Map<String, ServiceProviderConnectionFactory<?>> connectionFactories = new HashMap<String, ServiceProviderConnectionFactory<?>>();

	private final Map<Class<?>, String> serviceApiTypeIndex = new HashMap<Class<?>, String>();

	public void setConnectionFactories(List<ServiceProviderConnectionFactory<?>> connectionFactories) {
		for (ServiceProviderConnectionFactory<?> connectionFactory : connectionFactories) {
			addConnectionFactory(connectionFactory);
		}
	}
	
	public void addConnectionFactory(ServiceProviderConnectionFactory<?> connectionFactory) {
		if (connectionFactories.containsKey(connectionFactory.getProviderId())) {
			throw new IllegalArgumentException("A ConnectionFactory for provider '" + connectionFactory.getProviderId() + "' has already been registered");
		}
		/*
		Class<?> serviceApiType = GenericTypeResolver.resolveTypeArgument(connectionFactory.getClass(), ServiceProviderConnectionFactory.class);
		if (serviceApiTypeIndex.containsKey(serviceApiType)) {
			throw new IllegalArgumentException("A ConnectionFactory for service API [" + serviceApiType.getName() + "] has already been registered");
		}*/
		connectionFactories.put(connectionFactory.getProviderId(), connectionFactory);
		//serviceApiTypeIndex.put(serviceApiType, connectionFactory.getProviderId());
	}
	
	public ServiceProviderConnectionFactory<?> getConnectionFactory(String providerId) {
		ServiceProviderConnectionFactory<?> connectionFactory = connectionFactories.get(providerId);
		if (connectionFactory == null) {
			throw new IllegalArgumentException("No connection factory for ServiceProvider '" + providerId + "' is registered");
		}
		return connectionFactory;
	}

	@SuppressWarnings("unchecked")
	public <S> ServiceProviderConnectionFactory<S> getConnectionFactory(Class<S> serviceApiType) {
		String providerId = serviceApiTypeIndex.get(serviceApiType);
		if (providerId == null) {
			throw new IllegalArgumentException("No connection factory for ServiceProvider API [" + serviceApiType.getName() + "] is registered");
		}
		return (ServiceProviderConnectionFactory<S>) getConnectionFactory(providerId);
	}

	public Set<String> registeredProviderIds() {
		return connectionFactories.keySet();
	}

}
