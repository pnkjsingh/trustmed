package com.trustMed.apigateway.config;

import java.util.function.Function;

import org.springframework.cloud.gateway.route.Route;
import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.Buildable;
import org.springframework.cloud.gateway.route.builder.PredicateSpec;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ApiGatewayConfiguration {
	
	@Bean
	public RouteLocator getewayRouter(RouteLocatorBuilder builder) {
		
//		return Simple when not customized the route
//		return builder.routes().build();

//		if customized then it will be as below
/*		Function<PredicateSpec, Buildable<Route>> routeFunction=
				p ->p.path("/get")
				.filters(f-> f.addRequestHeader("MyHeader", "MyURI")
						.addRequestParameter("Param", "MyValue"))
				.uri("http://httpbin.org:80");
		return builder.routes()
				.route(routeFunction)
				.build();
*/
		//inline the above code using right click select refecter chose inline option
		return builder.routes()
				.route(p ->p.path("/get")
				.filters(f-> f.addRequestHeader("MyHeader", "MyURI")
						.addRequestParameter("Param", "MyValue"))
				.uri("http://httpbin.org:80"))
				.build();
	}

}
