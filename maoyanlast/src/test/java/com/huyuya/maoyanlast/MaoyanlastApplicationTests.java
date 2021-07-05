package com.huyuya.maoyanlast;

import com.huyuya.maoyanlast.entity.Cinema;
import com.huyuya.maoyanlast.mapper.CinemaMapper;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;
import java.util.List;

@SpringBootTest
class MaoyanlastApplicationTests {
    @Resource
    CinemaMapper cinemaMapper;
    @Test
    void contextLoads() {
//        List<Cinema> cinemas = cinemaMapper.selectCinemas();
//        cinemas.forEach(System.out::println);
    }

}
