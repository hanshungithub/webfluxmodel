package cn.hassan.webfluxmongo.handler;

import cn.hassan.webfluxmongo.dao.CityRepository;
import cn.hassan.webfluxmongo.domain.City;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

/**
 * Created with idea
 * Author: hss
 * Date: 2018/7/17 14:30
 * Description:
 */
@Service
public class CityHandler {

	@Autowired
	private CityRepository cityRepository;

	public Mono<City> save(City city) {
		return cityRepository.save(city);
	}

	public Mono<City> findCityById(Long id) {

		return cityRepository.findById(id);
	}

	public Flux<City> findAllCity() {

		return cityRepository.findAll();
	}

	public Mono<City> modifyCity(City city) {

		return cityRepository.save(city);
	}

	public Mono<Long> deleteCity(Long id) {
		cityRepository.deleteById(id);
		return Mono.create(cityMonoSink -> cityMonoSink.success(id));
	}
}
