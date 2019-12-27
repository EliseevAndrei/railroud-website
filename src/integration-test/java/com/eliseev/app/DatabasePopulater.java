package com.eliseev.app;

import org.springframework.jdbc.core.JdbcTemplate;

public class DatabasePopulater {


    private JdbcTemplate jdbcTemplate;

    public DatabasePopulater(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public void populateDb() {
        jdbcTemplate.update("INSERT INTO `user` VALUES (6,'eliseev.andrei345@mail.ru','vera','Елисеев','38640dd365f92cd6fd79c38ca20024bab2f7d8ecec887e189787f5023dbfa0e8ac765a238f83dfb8','Андрей'),(9,'asdf@mail.ru','dron','Козловская','133128846b27674be4917143b46c6bbf9fc1303c66d8e98a8abb750b070934aa98befda901d99aca','Вероника');");
        jdbcTemplate.update("INSERT INTO `role` VALUES (1,'USER'),(2,'ADMIN'),(3,'ANONYMOUS');");
        jdbcTemplate.update("INSERT INTO `user_role` VALUES (6,1),(9,2),(9,1);");
        jdbcTemplate.update("INSERT INTO `train` VALUES (23,'222B'),(25,'745GH');");
        jdbcTemplate.update("INSERT INTO `carriage` VALUES (57,1,'Купе',23),(62,2,'Плацкарт',23), (78,3,'Плацкарт',25),(82,4,'Общий',25);");
        jdbcTemplate.update("INSERT INTO `place` VALUES (967,1,'Купе',57),(968,2,'Купе',57),(969,3,'Купе',57),(970,4,'Купе',57),(1167,2,'Верхнее',62),(1168,4,'Верхнее',62),(1169,6,'Верхнее',62),(1170,8,'Верхнее',62),(2207,2,'Верхнее',78),(2208,4,'Верхнее',78),(2209,6,'Верхнее',78),(2210,8,'Верхнее',78),(2367,1,'Сидячее',82),(2368,2,'Сидячее',82),(2369,3,'Сидячее',82),(2370,4,'Сидячее',82);");
        jdbcTemplate.update("INSERT INTO `station` VALUES (1,'Брест'),(2,'Жлобин'),(3,'Витебск'),(4,'Минск'),(5,'Гродно'),(8,'Пинск'),(9,'Слуцк'),(10,'Мозырь'),(11,'Лунинец'),(12,'Могилев'),(13,'Бобруйск'),(14,'Барановичи'),(15,'Борисов'),(16,'Орша'),(17,'Солигорск'),(18,'Лида'),(19,'Новополоцк'),(20,'Молодечно'),(21,'Полоцк'),(22,'Речица'),(23,'Жодино');");
        jdbcTemplate.update("INSERT INTO `train_route_piece` VALUES (31,150,1,13,4,23),(32,100,2,22,13,23),(37,70,1,8,1,25),(38,40,2,11,8,25),(39,80,3,22,11,25),(40,100,4,4,22,25),(41,30,5,15,4,25),(42,120,6,16,15,25);");
        jdbcTemplate.update("INSERT INTO `train_date` VALUES (33,23),(34,23),(35,23),(31,25),(32,25);");
        jdbcTemplate.update("INSERT INTO `station_stop_time` VALUES (73,'2019-12-29 09:11:00.000000','2019-12-29 08:11:00.000000',31,37),(74,'2019-12-29 11:21:00.000000','2019-12-29 10:13:00.000000',31,38),(75,'2019-12-29 12:41:00.000000','2019-12-29 11:29:00.000000',31,39),(76,'2019-12-29 14:41:00.000000','2019-12-29 13:11:00.000000',31,40),(77,'2019-12-29 16:11:00.000000','2019-12-29 15:14:00.000000',31,41),(78,'2019-12-29 18:21:00.000000','2019-12-29 17:11:00.000000',31,42),(79,'2019-11-11 08:12:00.000000','2019-11-11 08:11:00.000000',32,37),(80,'2019-11-11 08:15:00.000000','2019-11-11 08:13:00.000000',32,38),(81,'2019-11-11 08:17:00.000000','2019-11-11 08:16:00.000000',32,39),(82,'2019-11-11 08:19:00.000000','2019-11-11 08:18:00.000000',32,40),(83,'2019-11-11 08:30:00.000000','2019-11-11 08:20:00.000000',32,41),(84,'2019-11-11 18:12:00.000000','2019-11-11 08:50:00.000000',32,42),(85,'2019-11-11 08:12:00.000000','2019-11-11 08:11:00.000000',33,31),(86,'2019-11-11 20:11:00.000000','2019-11-11 08:14:00.000000',33,32),(87,'2019-12-11 08:15:00.000000','2019-12-11 08:11:00.000000',34,31),(88,'2019-12-11 20:11:00.000000','2019-12-11 08:17:00.000000',34,32);");
        jdbcTemplate.update("INSERT INTO `ticket` VALUES (1,'2019-12-29 08:19:00.000000','2019-12-29 08:11:00.000000','Андрей','HB2512123','Козловская',40,37,2208,32,9),(2,'2019-12-29 08:19:00.000000','2019-12-29 08:18:00.000000','Вероника','HB2512123','Козловская',40,40,2210,32,9),(3,'2019-12-29 18:12:00.000000','2019-12-29 08:20:00.000000','Андрей','HB2512123','Козловская',42,41,2208,32,6);");
    }

    public void cleanDb() {

        jdbcTemplate.update("delete from user_role");
        jdbcTemplate.update("delete from role");
        jdbcTemplate.update("delete from ticket");
        jdbcTemplate.update("delete from place");
        jdbcTemplate.update("delete from carriage");
        jdbcTemplate.update("delete from station_stop_time");
        jdbcTemplate.update("delete from train_date");
        jdbcTemplate.update("delete from user");
        jdbcTemplate.update("delete from train_route_piece");
        jdbcTemplate.update("delete from train");
        jdbcTemplate.update("delete from station");



    }
}
