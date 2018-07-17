package cn.hassan.webfluxmongo.dao;

import cn.hassan.webfluxmongo.domain.City;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Repository;

/**
 * Created with idea
 * Author: hss
 * Date: 2018/7/17 14:22
 * Description:
 */
@Repository
public interface CityRepository extends ReactiveMongoRepository<City, Long> {
}
