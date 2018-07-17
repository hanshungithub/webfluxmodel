package cn.hassan.webfluxmongo.controller;

import cn.hassan.webfluxmongo.domain.City;
import cn.hassan.webfluxmongo.handler.CityHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

/**
 * Created with idea
 * Author: hss
 * Date: 2018/7/17 14:28
 * Description:
 */
@Controller
@RequestMapping(value = "/city")
public class CityController {

	private static final String CITY_LIST_PATH_NAME = "cityList";

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
	public Mono<City> saveCity(@RequestBody City city) {
		return cityHandler.save(city);
	}

	@PutMapping()
	public Mono<City> modifyCity(@RequestBody City city) {
		return cityHandler.modifyCity(city);
	}

	@DeleteMapping(value = "/{id}")
	public Mono<Long> deleteCity(@PathVariable("id") Long id) {
		return cityHandler.deleteCity(id);
	}

	@GetMapping("/hello")
	public Mono<String> hello(final Model model) {
		model.addAttribute("name", "hassan");
		model.addAttribute("city", "杭州");
		String path = "hello";
		return Mono.create(monoSink -> monoSink.success(path));
	}

	@GetMapping("/page/list")
	public String listPage(final Model model) {
		final Flux<City> cityFluxList = cityHandler.findAllCity();
		model.addAttribute("cityList", cityFluxList);
		return CITY_LIST_PATH_NAME;
	}
}
