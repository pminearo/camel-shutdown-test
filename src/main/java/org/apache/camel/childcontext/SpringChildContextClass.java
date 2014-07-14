package org.apache.camel.childcontext;

import org.springframework.beans.factory.InitializingBean;
import org.springframework.util.Assert;

public class SpringChildContextClass implements InitializingBean {

	private String someProperty;

	public String getSomeProperty() {
		return someProperty;
	}

	public void setSomeProperty(String someProperty) {
		this.someProperty = someProperty;
	}

	@Override
	public void afterPropertiesSet() throws Exception {

		Assert.hasText(someProperty, "The Property was not set");
	}


}
