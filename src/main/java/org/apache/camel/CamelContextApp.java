package org.apache.camel;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.util.Assert;


public class CamelContextApp {

	private AbstractApplicationContext parentApplicationContext;
	private AbstractApplicationContext childApplicationContext;

	public static void main(String[] args) {

		final CamelContextApp app = new CamelContextApp();
		app.init();
		app.shutdownChildContext();
		app.validateCamelContext();
	}

	public void init() {
		parentApplicationContext = new ClassPathXmlApplicationContext("camelTestContext.xml");
		childApplicationContext = new ClassPathXmlApplicationContext(new String[] { "childContext.xml" }, parentApplicationContext);

	}

	public void shutdownChildContext() {
		childApplicationContext.close();
	}

	public void validateCamelContext() {

		final CamelContext camelContext = (CamelContext) parentApplicationContext.getBean("myCoolRoutes");

		Assert.notNull(camelContext, "Camel Context came back Null from Parent Application Context");

		final ServiceStatus routeCoolServiceStatus = camelContext.getRouteStatus("cool");

		Assert.isTrue(routeCoolServiceStatus.isStopped(), "Route 'cool' has not been stopped");

		final ServiceStatus routeBarServiceStatus = camelContext.getRouteStatus("cool");

		Assert.isTrue(routeBarServiceStatus.isStopped(), "Route 'bar' has not been stopped");
	}

}
