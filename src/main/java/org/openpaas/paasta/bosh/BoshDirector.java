package org.openpaas.paasta.bosh;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.openpaas.paasta.bosh.util.SSLUtils;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.security.oauth2.common.OAuth2AccessToken;
import org.springframework.web.client.RestTemplate;

import java.security.KeyManagementException;
import java.security.NoSuchAlgorithmException;
import java.util.List;
import java.util.Map;


public class BoshDirector {

    private String client_id;

    private String client_secret;

    private String bosh_url;

    private OAuth2AccessToken oAuth2AccessToken;

    private int expiresIn;

    private String oauth_url;

    ObjectMapper objectMapper = new ObjectMapper();

    final RestTemplate restTemplate = new RestTemplate();

    public BoshDirector(String client_id, String client_secret, String bosh_url, String oauth_url) {
        this.client_id = client_id;
        this.client_secret = client_secret;
        this.bosh_url = bosh_url;
        this.oauth_url = oauth_url;
        try {
            SSLUtils.turnOffSslChecking();
            oAuth2AccessToken = this.getAccessToken();
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        } catch (KeyManagementException e) {
            e.printStackTrace();
        }
    }

    private OAuth2AccessToken getAccessToken() {
        return restTemplate.exchange(oauth_url + "/oauth/token?client_id=" + client_id + "&client_secret=" + client_secret + "&grant_type=client_credentials", HttpMethod.POST, null, OAuth2AccessToken.class).getBody();
    }


    private HttpEntity<Object> getHeader(String Header_Name, String param) {
        if (oAuth2AccessToken.getExpiresIn() <= 180) {
            oAuth2AccessToken = this.getAccessToken();
        }
        HttpHeaders reqHeaders = new HttpHeaders();
        reqHeaders.add(Header_Name, oAuth2AccessToken.getTokenType() + " " + oAuth2AccessToken.getValue());
        reqHeaders.add("Content-Type", "application/json");
        HttpEntity httpEntity = null;
        if (param != null) {
            httpEntity = new HttpEntity<>(param, reqHeaders);
        } else {
            httpEntity = new HttpEntity<>(reqHeaders);
        }
        return httpEntity;
    }

    private List<Map> resEntityList(String endpoint, HttpMethod method, String Headername, String param) {
        String json = "";
        if (param != null) {
            json = restTemplate.exchange(bosh_url + endpoint, method, getHeader(Headername, param), String.class).getBody();
        } else {
            json = restTemplate.exchange(bosh_url + endpoint, method, getHeader(Headername, null), String.class).getBody();
        }
        try {
            return objectMapper.readValue(json, new TypeReference<List<Map>>() {
            });
        } catch (Exception e) {
            e.printStackTrace();
            new Exception();

        }
        return null;
    }

    private Map resEntityMap(String endpoint, HttpMethod method, String Headername, String param) {
        String json = "";
        if (param != null) {
            json = restTemplate.exchange(bosh_url + endpoint, method, getHeader(Headername, param), String.class).getBody();
        }
        json = restTemplate.exchange(bosh_url + endpoint, method, getHeader(Headername, null), String.class).getBody();

        try {
            return objectMapper.readValue(json, Map.class);
        } catch (Exception e) {
            e.printStackTrace();
            new Exception();
        }
        return null;
    }


    private String resEntityS(String endpoint, HttpMethod method, String Headername, String param) {
        if (param != null) {
            return restTemplate.exchange(bosh_url + endpoint, method, getHeader(Headername, param), String.class).getBody();
        }
        return restTemplate.exchange(bosh_url + endpoint, method, getHeader(Headername, null), String.class).getBody();
    }

    private Map resEntityM(String endpoint, HttpMethod method, String Headername, String param) {
        if (param != null) {
            return restTemplate.exchange(bosh_url + endpoint, method, getHeader(Headername, param), Map.class).getBody();
        }
        return restTemplate.exchange(bosh_url + endpoint, method, getHeader(Headername, null), Map.class).getBody();
    }

    ///// get /////

    //Info
    public Map getInfo() {
        return resEntityM("/info", HttpMethod.GET, "Authorization", null);
    }

    //List configs
    public String getConfigs(String name, String type, boolean latest) {
        String request_body = "?";
        if (!(type == null || type.equals(""))) {
            request_body += "type=" + type;
            request_body += "&";
        }
        if (!(name != null || !name.equals(""))) {
            request_body += "name=" + name;
            request_body += "&";
        }
        request_body += latest ? "latest=true" : "latest=false";
        return resEntityS("/configs" + request_body, HttpMethod.GET, "Authorization", null);
    }


    //List all tasks
    public List<Map> getListTasks() {
        return resEntityList("/tasks", HttpMethod.GET, "Authorization", null);
    }

    //List currently running tasks
    public List<Map> getListRunningTasks() {
        return resEntityList("/tasks?state=queued,processing,cancelling", HttpMethod.GET, "Authorization", null);
    }

    //List tasks associated with a deployment
    public List<Map> getListDeploymentAssociatedWithTasks(String deployment_name) {
        return resEntityList("/tasks?deployment=" + deployment_name, HttpMethod.GET, "Authorization", null);
    }

    //List tasks associated with a context ID
    public List<Map> getListContextIDAssociatedWithTasks(String context_id) {
        return resEntityList("/tasks?context_id=" + context_id, HttpMethod.GET, "Authorization", null);
    }

    //Retrieve single task
    public Map getTask(String task_id) {
        return resEntityMap("/tasks/" + task_id, HttpMethod.GET, "Authorization", null);
    }

    //Retrieve task's log(tpye ex.. debug, event, result)
    public Map getRetrieveTasksLog(String task_id, String type) {
        return resEntityMap("/tasks/" + task_id + "/output?type=" + type, HttpMethod.GET, "Authorization", null);
    }

    //List all uploaded stemcells
    public List<Map> getListStemcells() {
        return resEntityList("/stemcells", HttpMethod.GET, "Authorization", null);
    }

    //List all uploaded stemcells
    public List<Map> getUploadReleases() {
        return resEntityList("/releases", HttpMethod.GET, "Authorization", null);
    }

    //List all deployments
    public List<Map> getListDeployments() {
        return resEntityList("/deployments", HttpMethod.GET, "Authorization", null);
    }

    //List all deployments without configs, releases, and stemcells
    public List<Map> getListDeploymentsWithoutCRS() {
        return resEntityList("/deployments?exclude_configs=true&exclude_releases=true&exclude_stemcells=true", HttpMethod.GET, "Authorization", null);
    }

    //Retrieve single deployment
    public Map getDeployments(String deployment_name) {
        return resEntityMap("/deployments/" + deployment_name, HttpMethod.GET, "Authorization", null);
    }

    //List all instances
    public List<Map> getListInstances(String deployment_name) {
        return resEntityList("/deployments/" + deployment_name + "/instances", HttpMethod.GET, "Authorization", null);
    }

    //List details of instances
    public List<Map> getListDetailOfInstances(String deployment_name) {
        return resEntityList("/deployments/" + deployment_name + "/instances?format=full", HttpMethod.GET, "Authorization", null);
    }

    //List all VMs
    public List<Map> getListDeploymentsVMS(String deployment_name) {
        return resEntityList("/deployments/" + deployment_name + "/vms", HttpMethod.GET, "Authorization", null);
    }

    //List VM details
    public List<Map> getListDetailDeploymentsVMS(String deployment_name) {
        return resEntityList("/deployments/" + deployment_name + "/vms?format=full", HttpMethod.GET, "Authorization", null);
    }

    //List events
    public List<Map> getListEvents() {
        return resEntityList("/events", HttpMethod.GET, "Authorization", null);
    }

    //List events
    public Map getEvents(String event_id) {
        return resEntityMap("/events/" + event_id, HttpMethod.GET, "Authorization", null);
    }

    ///// post /////

    //Create config
    public String postCreateConfigs(String name, String type, String content) {
        String param = "{\"name\": \"" + name + "\", \"type\": \"" + type + "\", \"content\": \"" + content + "\"}";
        return resEntityS("/configs", HttpMethod.POST, "Authorization", param);
    }

    //Diff config
    public String postDiffConfig(String name, String type, String content) {
        String param = "{\"name\": \"" + name + "\", \"type\": \"" + type + "\", \"content\": \"" + content + "\"}";
        return resEntityS("/configs/diff", HttpMethod.POST, "Authorization", param);
    }

    public String postCreateAndUpdateDeployment(String param) {
        if (oAuth2AccessToken.getExpiresIn() <= 180) {
            oAuth2AccessToken = this.getAccessToken();
        }
        HttpHeaders reqHeaders = new HttpHeaders();
        reqHeaders.add("Authorization", oAuth2AccessToken.getTokenType() + " " + oAuth2AccessToken.getValue());
        reqHeaders.add("Content-Type", "text/yaml");
        //reqHeaders.add("X-Bosh-Context-Id", "01492223-2351-4ef2-a1ac-51a05d1b2e1c");
        //return resEntityS("/deployments?recreate=true", HttpMethod.POST, "Authorization", param);
        return restTemplate.exchange(bosh_url + "/deployments", HttpMethod.POST, new HttpEntity<>(param, reqHeaders), String.class).getBody();
    }

    ///// put /////
    public List<Map> updateIgnoreInstance(String deployment_name, String instance_name, String instance_id, boolean ignore) {
        String param = "{\"ignore\":" + ignore + "}";
        return resEntityList("/deployments/" + deployment_name + "/instance_groups/" + instance_name + "/" + instance_id + "/ignore", HttpMethod.PUT, "Authorization", param);
    }


    ///// delete /////

    //Marks configs as deleted
    public String deleteConfig(String name, String type) throws Exception {
        if (name == null || name.equals("")) {
            throw new Exception("not setting name");
        }
        if (type == null || name.equals("")) {
            throw new Exception("not setting type");
        }
        return resEntityS("/configs?type=" + type + "&name=" + name, HttpMethod.DELETE, "Authorization", null);
    }

    public String deleteDeployment(String deployment_name) {
        return resEntityS("/deployments/" + deployment_name, HttpMethod.DELETE, "Authorization", null);
    }

}
