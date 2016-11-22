package com.example.controller;

import com.example.entity.Project;
import com.sun.corba.se.impl.protocol.giopmsgheaders.Message;
import net.sf.json.JSONObject;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * Created by Administrator on 2016/10/24.
 */
@Controller("restController")
@RequestMapping("/rest")
public class RestController {
    @ResponseBody
    @RequestMapping(value = "/result/{str}", method = RequestMethod.GET,produces = MediaType.APPLICATION_JSON_VALUE)
    public MVCResult getResult(@PathVariable String str) {
        System.out.println(str);
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("key",str);
        return new MVCResult(MVCResult.Type.OK,str);
    }

    @ResponseBody
    @RequestMapping(value = "/json/{json}", method = RequestMethod.GET,produces = MediaType.APPLICATION_JSON_VALUE)
    public MVCResult getjson(@PathVariable String json) {
        System.out.println(json);
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("key",json);
        return new MVCResult(MVCResult.Type.OK,jsonObject);
    }

    @RequestMapping(value = "/getProjects/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public
    @ResponseBody
    List<Project> getProjects(@PathVariable String id) {
        System.out.println(id);
        List<Project> projects = new ArrayList<Project>();
        Project project;
        for(int i=0;i<10;i++){
            project = new Project();
            project.setName("name"+i);
            project.setCode("code"+i);
            projects.add(project);
        }
        return projects;
    }

    @RequestMapping(value = "/getProject/{code}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public
    @ResponseBody
    Project getProject(@PathVariable  String code) {
        if (!StringUtils.hasText(code)) {
            return null;
        }
        Project project = new Project();
        project.setName("project");
        project.setCode("code");
        return project;
    }

    @RequestMapping(value = "/showProject", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    public @ResponseBody
    MVCResult showProject(){
        Project project = new Project();
        project.setCode("code");
        project.setName("name");
        return new MVCResult(MVCResult.Type.OK,project);
    }

    @RequestMapping(value = "/showProject1", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    public @ResponseBody
    MVCResult showProject1(@RequestBody String id){
        System.out.println(id);
        Project project = new Project();
        project.setCode("code");
        project.setName("name");
        return new MVCResult(MVCResult.Type.OK,project);
    }

    @RequestMapping(value = "/saveProject", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    public @ResponseBody
    MVCResult saveProject(@RequestBody Map<String,String> map){
        System.out.println(map.get("code"));
        Project project = new Project();
        project.setCode("code");
        project.setName("name");
        return new MVCResult(MVCResult.Type.OK,project);
    }
    @RequestMapping(value = "/deleteProject/{id}", method = RequestMethod.DELETE, produces = MediaType.APPLICATION_JSON_VALUE)
    public @ResponseBody
    MVCResult deleteProject(@PathVariable  String id){
        System.out.println(id);
        return new MVCResult(MVCResult.Type.OK,null);
    }

}
