package cn.hassan.webfluxmongo.domain;

import lombok.Data;

/**
 * Created with idea
 * Author: hss
 * Date: 2018/7/17 9:55
 * Description:
 */
@Data
public class City {

	private Long id;
	private Long provinceId;
	private String cityName;
	private String description;

}
