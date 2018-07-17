package cn.hassan.webfluxcrud.controller;

import cn.hassan.webfluxcrud.domain.City;
import cn.hassan.webfluxcrud.handler.CityHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

/**
 * Created with idea
 * Author: hss
 * Date: 2018/7/17 10:18
 * Description:
 */
@RestController
@RequestMapping(value = "/city")
public class CityWebFluxController {

	@Autowired
	private CityHandler cityHandler;

	@GetMapping(value = "/{id}")
	public Mono<City> findCityById(@PathVariable("id") Long id) {
		return cityHandler.findCityById(id);
	}

	@GetMapping()
	public Flux<City> findAllCity() {
		return cityHandler.findAllCity();
	}

	@PostMapping()
	public Mono<Long> saveCity(@RequestBody City city) {
		return cityHandler.save(city);
	}

	@PutMapping()
	public Mono<Long> modifyCity(@RequestBody City city) {
		return cityHandler.modifyCity(city);
	}

	@DeleteMapping(value = "/{id}")
	public Mono<Long> deleteCity(@PathVariable("id") Long id) {
		return cityHandler.deleteCity(id);
	}
}
