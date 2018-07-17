package cn.hassan.webfluxcrud.router;

import cn.hassan.webfluxcrud.handler.CityHandler;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.web.reactive.function.server.RequestPredicates;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.RouterFunctions;
import org.springframework.web.reactive.function.server.ServerResponse;

/**
 * Created with idea
 * Author: hss
 * Date: 2018/7/17 9:31
 * Description:
 */
@Configuration
public class CityRouter {
	@Bean
	public RouterFunction<ServerResponse> routerCity(CityHandler cityHandler) {
		return RouterFunctions.route(RequestPredicates.GET("/hello").and(RequestPredicates.accept(MediaType.TEXT_PLAIN)),cityHandler::helloCity);
	}
}
