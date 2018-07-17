package cn.hassan.webfluxcrud.handler;

import cn.hassan.webfluxcrud.dao.CityRepository;
import cn.hassan.webfluxcrud.domain.City;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.BodyInserters;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

/**
 * Created with idea
 * Author: hss
 * Date: 2018/7/17 9:25
 * Description:
 */
@Component
public class CityHandler {

	@Autowired
	private CityRepository repository;

	public Mono<ServerResponse> helloCity(ServerRequest request) {
		return ServerResponse.ok().contentType(MediaType.TEXT_PLAIN).body(BodyInserters.fromObject("hello,city!"));
	}

	public Mono<Long> save(City city) {
		return Mono.create(cityMonoSink -> cityMonoSink.success(repository.save(city)));
	}

	public Mono<City> findCityById(Long id) {
		return Mono.justOrEmpty(repository.findCityById(id));
	}

	public Flux<City> findAllCity() {
		return Flux.fromIterable(repository.findAll());
	}

	public Mono<Long> modifyCity(City city) {
		return Mono.create(citySink -> citySink.success(repository.updateCity(city)));
	}

	public Mono<Long> deleteCity(Long id) {
		return Mono.create(citySink -> citySink.success(repository.deleteCity(id)));
	}
}
