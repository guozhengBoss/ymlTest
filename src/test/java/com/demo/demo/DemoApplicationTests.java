package com.demo.demo;

import com.demo.demo.dto.JacksonDateTest;
import com.fasterxml.jackson.databind.*;
import org.ehcache.CacheManager;
import org.ehcache.UserManagedCache;
import org.ehcache.config.Configuration;
import org.ehcache.config.builders.CacheManagerBuilder;
import org.ehcache.config.builders.UserManagedCacheBuilder;
import org.ehcache.xml.XmlConfiguration;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.io.IOException;
import java.net.URL;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.concurrent.TimeUnit;

@RunWith(SpringRunner.class)
@SpringBootTest
public class DemoApplicationTests {
	/**
	 *
	 */


	/*	@ResponseBody
		public JacksonDateTest getUser(@RequestBody JacksonDateTest user) {
			System.out.println(user.getDate());
			return user;
		}
*/
	@Test
	public void jacksonDate() throws ParseException, IOException {
		JacksonDateTest dto = new JacksonDateTest();
		dto.setDate(new Date());
		dto.setName("aaa");
		ObjectMapper mapper =new ObjectMapper();
		mapper.disable(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS);
		mapper.disable(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES);
//		    mapper.setDateFormat(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss"));
		//使用上方或注解
		String s = mapper.writeValueAsString(dto);
		System.out.println(s);
//		s="{\"name\":\"aaa\",\"d1ate\":\"2019-01-21 09:43:49\"}";
		JacksonDateTest jacksonDateTest = mapper.readValue(s, JacksonDateTest.class);

//			getUser(dto);
		System.out.println(jacksonDateTest.getDate());

	}




	@Test
	public void ehcacheLoads() {


////		CacheManager cacheManager = CacheManagerBuilder.newCacheManager().;
////		CacheConfigurationBuilder<Long, String> longStringCacheConfigurationBuilder = CacheConfigurationBuilder
////				.newCacheConfigurationBuilder(Long.class, String.class, ResourcePoolsBuilder.heap(10));
		UserManagedCacheBuilder<Integer, String, UserManagedCache<Integer, String>> integerStringUserManagedCacheUserManagedCacheBuilder
				= UserManagedCacheBuilder.newUserManagedCacheBuilder(Integer.class, String.class);
		UserManagedCache<Integer, String> userManagedCache = integerStringUserManagedCacheUserManagedCacheBuilder.build(false);
		userManagedCache.init();
		for (int i=0;i<=20;i++){
			//写
			userManagedCache.put(i, "#"+i);
			//读
			String value = userManagedCache.get(i);
			System.out.println("get at "+i+":"+value);
		}
		for (int i=0;i<=20;i++){
			//写
			userManagedCache.put(i, "#"+i);
			//读
			String value = userManagedCache.get(i);
			System.out.println("get at "+i+":"+value);
		}

		userManagedCache.close();
	}
	@Test
	public void dateFormat() throws ParseException {
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		Date nowDate = new Date();
		System.out.println(dateFormat.parse("2019-1-30" + " 23:59:59").compareTo(nowDate));
	}

	@Test
	public void cache2(){
		URL myUrl = getClass().getResource("/ehcache3.xml");
		XmlConfiguration xmlConfiguration = new XmlConfiguration(myUrl);
		Configuration xmlConfig = xmlConfiguration;
		CacheManager myCacheManager = CacheManagerBuilder.newCacheManager(xmlConfig);

	}

	@Test
	public void jacksonTest(){
		List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9);
		numbers.parallelStream().forEach(a-> System.out.println(a));
		Integer[] intArray = {1, 2, 3, 4, 5, 6, 7, 8};
		List<Integer> listOfIntegers =
				new ArrayList<>(Arrays.asList(intArray));
		List<Integer> parallelStorage = new ArrayList<>();//Collections.synchronizedList(new ArrayList<>());
		listOfIntegers
				.parallelStream()
				// Don't do this! It uses a stateful lambda expression.
				.map(e -> {
					parallelStorage.add(e);
					return e;
				})
				.forEach(e -> System.out.print(e + " "));
		System.out.println();
		parallelStorage
				.stream()
				.forEachOrdered(e -> System.out.print(e + " "));
		System.out.println();
		System.out.println("Sleep 5 sec");
		try {
			TimeUnit.SECONDS.sleep(5);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		parallelStorage
				.stream()
				.forEachOrdered(e -> System.out.print(e + " "));

			}

	}

