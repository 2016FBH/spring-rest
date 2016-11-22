package com.example.client;

import com.example.entity.Project;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.util.StringUtils;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by Administrator on 2016/10/25.
 */

public class RestClientTest{

    private RestClient restClient = new RestClient();

    @Test
    public void testGetResult(){
        String result = restClient.getResult();
        Assert.assertNotNull(result);
    }

    @Test
    public void testGetProject(){
        Project project = restClient.getProject("code");
        Assert.assertNotNull(project);
    }
    @Test
    public void testGetJson(){
        JSONObject jsonObject = JSONObject.fromObject(restClient.getJson("json"));
        Assert.assertNotNull(jsonObject);
    }
    @Test
    public void testUrl(){
        try {
            URL url = new URL("http://localhost:8080/springdemo/rest/result/{json}");
            InputStream inputStream = url.openStream();
            InputStreamReader inputReader = new InputStreamReader(inputStream);
            BufferedReader reader = new BufferedReader(inputReader);
            String results=reader.readLine();
            if(StringUtils.hasText(results)){
                System.out.print(results);
            }
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
   /* @Test
    public void testGetArt(){
        String jsonObject = restClient.getArt();
        Assert.assertNotNull(jsonObject);
    }*/

    @Test
    public void testSave(){
        Map<String,String> map = new HashMap<String, String>();
        map.put("code","code");
        map.put("name","name");
        String jsonObject = restClient.save(map);
        JSONObject jsonObject1 = JSONObject.fromObject(jsonObject);
        Assert.assertNotNull(jsonObject1);
    }

    @Test
    public void testShow(){
        String jsonObject = restClient.show();
        JSONObject jsonObject1 = JSONObject.fromObject(jsonObject);
        Assert.assertNotNull(jsonObject1);
    }

    @Test
    public void testShow1(){
        String jsonObject = restClient.show1("1");
        JSONObject jsonObject1 = JSONObject.fromObject(jsonObject);
        Assert.assertNotNull(jsonObject1);
    }

    @Test
    public void testGetProjects(){
        String jsonObject = restClient.getProjects("1");
        JSONArray jsonArray = JSONArray.fromObject(jsonObject);
        Assert.assertNotNull(jsonArray);
    }

    @Test
    public void testDeleteProject(){
        String jsonObject = restClient.removeProject("1");
        Assert.assertNotNull(jsonObject);
    }
}
