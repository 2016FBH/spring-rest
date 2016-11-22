package com.example.client;

import com.example.entity.Project;
import org.springframework.http.client.SimpleClientHttpRequestFactory;
import org.springframework.web.client.RestTemplate;

import java.util.Map;

/**
 * Created by Administrator on 2016/10/25.
 */


public class RestClient {


    private RestTemplate template;

    private final static String url = "http://localhost:8080/springdemo/rest";
    //private final static String url = "http://localhost:8080/qqsl/user";

    public RestClient() {
        SimpleClientHttpRequestFactory requestFactory = new SimpleClientHttpRequestFactory();
        requestFactory.setConnectTimeout(1000);
        requestFactory.setReadTimeout(1000);
        template = new RestTemplate(requestFactory);

    }

    public String getResult() {
        return template.getForObject(url + "/result/{str}", String.class,"haha");
    }

    public Project getProject(String code) {
        return template.getForObject(url + "/getProject/{code}", Project.class, code);
    }

    public String getProjects(String id) {
        return template.getForObject(url + "/getProjects/{id}", String.class, id);
    }

    public String getJson(String json) {
        return template.getForObject(url + "/json/{json}",String.class, json);
    }

    public String save(Map<String,String> map) {
      //  return template.postForObject(url + "/createProject", HttpEntity.EMPTY, String.class);
        return template.postForObject(url + "/saveProject", map, String.class,map);
    }

    public String show() {
        return template.postForObject(url + "/showProject", null, String.class);
    }

    public String show1(String id) {
        return template.postForObject(url + "/showProject1", id, String.class);
    }

    /*public String getArt(){
        return template.getForObject(url + "/queryArticles",String.class);
    }*/

    public String removeProject(String id) {
        template.delete(url + "/deleteProject/{id}",id,String.class);
        return id;
    }
}
