package com.example.zoo.service;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import java.sql.*;
import java.util.List;

import com.example.zoo.models.animal;


@Component
public class zooService {

    private Statement statement = null;
    private Connection connection = null;

    private final JdbcTemplate jdbcTemplate;

    public zooService(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }


    public String connectionOpen() {
        try {
            // Загрузка драйвера JDBC для MySQL
            Class.forName("org.postgresql.Driver");

            // Создание соединения с базой данных
            connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/ZooDB","postgres", "1");
            if (connection != null)
            {return ("Connection OK");}
            else
            {return ("Connection FAIL");}
        }
        catch (Exception e) {e.printStackTrace();
            return "Connection ERROR";}
    }


    // Закрытие соединения с базой данных
    public String connectionClose() {
        try{
            connection.close();
            return "Connection closed";
        }
        catch (Exception e) {e.printStackTrace();
            return "Connection ERROR";}
    }


    public void sqlRequest() {
        try {
            // Создание объекта Statement для выполнения SQL-запросов
            statement = connection.createStatement();

            // Выполнение SQL-запроса
            ResultSet resultSet = statement.executeQuery("SELECT * FROM mytable");

            // Обработка результатов запроса
            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String name = resultSet.getString("name");
                System.out.println("id: " + id + ", name: " + name);
            }
        } catch (Exception e) {e.printStackTrace();}
    }


    // Запрос 1
    public String getAllWorkers() {
        try {
            statement = connection.createStatement();
            ResultSet rs = statement.executeQuery("SELECT man_name FROM man;");
            String allwork = "Список всех работников:";
            while (rs.next()) {
                allwork = allwork + "\n" + rs.getString("man_name");
            }
            return allwork;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }


    // Запрос 2-3
    public String getWorkersByAT(String animaltype) {
        try {
            statement = connection.createStatement();
            String req1;
            String req2;
            req1 = String.format("SELECT man.man_name, vet.animal_type " +
                    "FROM man " +
                    "INNER JOIN vet " +
                    "ON man.id_man = vet.id_man " +
                    "WHERE vet.animal_type = '%s'", animaltype);

            req2 = String.format("SELECT man.man_name, trainer.animal_type " +
                    "FROM man " +
                    "INNER JOIN trainer " +
                    "ON man.id_man = trainer.id_man " +
                    "WHERE trainer.animal_type = '%s'", animaltype);

            ResultSet rs = statement.executeQuery(req1);

            String allwork = "Список всех работников, ответственных за указанный вид животных:";
            while (rs.next()) {
                allwork = allwork + "\n" + rs.getString("man_name");
            }

            statement = connection.createStatement();
            ResultSet rs2 = statement.executeQuery(req2);
            while (rs2.next()) {
                allwork = allwork + "\n" + rs2.getString("man_name");
            }
            return allwork;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }


    // Запрос 4
    public String getAnimalsByWeight(String Weight) {
        try {
            statement = connection.createStatement();
            int weight = Integer.valueOf(Weight);
            String request = ("SELECT animal.animal_name, animal.weight " +
                    "FROM animal_type " +
                    "INNER JOIN animal " +
                    "ON animal_type.id_animal_type = animal.id_animal_type " +
                    "WHERE animal_type.id_animal_type = animal.id_animal_type and animal.weight > " + weight);

            ResultSet rs = statement.executeQuery(request);
            String animal = "Список всех животных, больше указанного веса:";
            while (rs.next()) {
                animal = animal + "\n" + rs.getString("animal_name");
            }


            return animal;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }


    // Запрос 5
    public String getAnimalsByWarmPlace() {
        try {
            statement = connection.createStatement();
            ResultSet rs = statement.executeQuery("SELECT animal_type.animal_type_name " +
                    "FROM animal_type " +
                    "WHERE animal_type.warm_place = true");
            String animal = "Список всех видов животных, которым нужно тёплое помещение:";
            while (rs.next()) {
                animal = animal + "\n" + rs.getString("animal_type_name");
            }
            return animal;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }


    // Запрос 6
    public String getAnimalsByVac(String vac) {
        try {
            statement = connection.createStatement();
            String request;
            request = String.format("SELECT animal.animal_name, vaccination.vaccination_name " +
                    "FROM animal " +
                    "INNER JOIN vaccination " +
                    "ON animal.id_animal = vaccination.id_animal " +
                    "WHERE vaccination.vaccination_name = '%s'", vac);
            ResultSet rs = statement.executeQuery(request);
            String animal = "Список всех видов животных, которым ставили указанную прививку:";
            while (rs.next()) {
                animal = animal + "\n" + rs.getString("animal_name");
            }
            return animal;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }


    // Запрос 7
    public String getAnimalsByCompatibility(String type) {
        try {
            statement = connection.createStatement();
            String request;
            request = String.format("SELECT animal_type.animal_type_name " +
                    "FROM animal_type " +
                    "WHERE '%s' = ANY (animal_type.compatibility)", type);
            ResultSet rs = statement.executeQuery(request);
            String animal = "Список всех видов животных, которые совместимы с указанным видом:";
            while (rs.next()) {
                animal = animal + "\n" + rs.getString("animal_type_name");
            }
            return animal;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }


    // Запрос 8
    public String getFeed() {
        try {
            statement = connection.createStatement();
            String request;
            request = String.format("SELECT animal_menu.provider, animal_menu.since " +
                    "FROM animal_menu " +
                    "GROUP BY animal_menu.provider, animal_menu.since");
            ResultSet rs = statement.executeQuery(request);
            String feed = "Список всех поставщиков кормов:";
            while (rs.next()) {
                feed = feed + "\n" + rs.getString(1) + "     " + rs.getString(2);
            }
            return feed;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }


    // Запрос 9
    public String getFeedZoo() {
        try {
            statement = connection.createStatement();
            String request;
            request = String.format("SELECT feed_norm.name, animal_menu.amount_tpy " +
                    "FROM animal_menu " +
                    "INNER JOIN feed_norm " +
                    "ON animal_menu.id_feed_norm = feed_norm.id_feed_norm " +
                    "WHERE animal_menu.provider = 'Zoo'");
            ResultSet rs = statement.executeQuery(request);
            String feed = "Список всех кормов, которыми себя обеспечивает зоопарк, и их количество в тоннах/год:";
            while (rs.next()) {
                feed = feed + "\n" + rs.getString(1) + "     " + rs.getString(2);
            }
            return feed;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }


    // Запрос 10
    public String getAnimalsByFeed() {
        try {
            statement = connection.createStatement();
            String request;
            request = String.format("");
            ResultSet rs = statement.executeQuery(request);
            String feed = "Список всех животных, которые едят определённый корм:";
            while (rs.next()) {
                feed = feed + "\n" + rs.getString(1) + "     " + rs.getString(2);
            }
            return feed;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }


    // Запрос 11
    public String getAnimal() {
        try {
            statement = connection.createStatement();
            String request;
            request = String.format("SELECT animal.animal_name, animal_type.animal_type_name, animal.health_state, animal.weight, animal.height " +
                    "FROM animal " +
                    "INNER JOIN animal_type " +
                    "ON animal_type.id_animal_type = animal.id_animal_type");
            ResultSet rs = statement.executeQuery(request);
            String feed = "Список всех животных, их вид, состояние здоровья, вес и рост:";
            while (rs.next()) {
                feed = feed + "\n" + rs.getString(1)
                        + "     " + rs.getString(2)
                        + "     " + rs.getString(3)
                        + "     " + rs.getString(4)
                        + "     " + rs.getString(5);
            }
            return feed;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }











}

