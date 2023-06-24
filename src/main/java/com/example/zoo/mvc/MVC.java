package com.example.zoo.mvc;

import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.example.zoo.service.zooService;


import java.sql.SQLException;
import java.util.List;
import java.util.Map;


@RestController
@RequestMapping("/")
@AllArgsConstructor
public class MVC {


    @Autowired
    private JdbcTemplate jdbcTemplate;

    private final zooService zs;


    @GetMapping("/table")
    public String showTable(Model model) {
        List<Map<String, Object>> rows = jdbcTemplate.queryForList("SELECT * FROM animal");
        model.addAttribute("rows", rows);
        return "table";
    }

    @GetMapping("/connectionOpen")
    public String connectionOpen() throws Exception {
        try{
            return zs.connectionOpen();}
        catch (Exception e) {
            return null;
        }}

    @GetMapping("/connectionClose")
    public String connectionClose() throws Exception {
        try{
            return zs.connectionClose();}
        catch (Exception e) {
            return null;
        }}



    @GetMapping("/getAllWorkers")
    public String getAllWorkers() throws Exception {
        try{
            return zs.getAllWorkers();}
        catch (Exception e) {
            return null;
        }}


    @GetMapping("/getWorkersByAT/{at}")
    public String getWorkersByAT(@PathVariable("at") String at) throws Exception {
        try{
            return zs.getWorkersByAT(at);}
        catch (Exception e) {
            return null;
        }}


    @GetMapping("/getAnimalsByWeight/{weight}")
    public String getAnimalsByWeight(@PathVariable("weight") String weight) throws Exception {
        try{
            return zs.getAnimalsByWeight(weight);}
        catch (Exception e) {
            return null;
        }}


    @GetMapping("/getAnimalsByWarmPlace")
    public String getAnimalsByWarmPlace() throws Exception {
        try{
            return zs.getAnimalsByWarmPlace();}
        catch (Exception e) {
            return null;
        }}


    @GetMapping("/getAnimalsByVac/{vac}")
    public String getAnimalsByVac(@PathVariable("vac") String vac) throws Exception {
        try{
            return zs.getAnimalsByVac(vac);}
        catch (Exception e) {
            return null;
        }}


    @GetMapping("/getAnimalsByCompatibility/{type}")
    public String getAnimalsByCompatibility(@PathVariable("type") String type) throws Exception {
        try{
            return zs.getAnimalsByCompatibility(type);}
        catch (Exception e) {
            return null;
        }}

    @GetMapping("/getFeed")
    public String getFeed() throws Exception {
        try{
            return zs.getFeed();}
        catch (Exception e) {
            return null;
        }}


    @GetMapping("/getFeedZoo")
    public String getFeedZoo() throws Exception {
        try{
            return zs.getFeedZoo();}
        catch (Exception e) {
            return null;
        }}


    @GetMapping("/getAnimal")
    public String getAnimal() throws Exception {
        try{
            return zs.getAnimal();}
        catch (Exception e) {
            return null;
        }}


    @GetMapping("/hw")
    public String hw() throws Exception {
        try{
            return "hello world";}
        catch (Exception e) {
            return null;
        }}


    @GetMapping("/com/example/zoo/visual")
    public String example(Model model) {
        model.addAttribute("message", "Hello, Thymeleaf!");
        return "example";
    }







}










