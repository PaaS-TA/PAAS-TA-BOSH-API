package org.openpaas.paasta.bosh;


import org.openpaas.paasta.bosh.director.BoshDirector;

import java.util.*;

public class BoshApplication {
    public static void main(String[] args) {
        BoshDirector boshDirector = new BoshDirector("admin", "idg3k30h72zq61yvg7nz", "https://localhost:25555", "https://localhost:8443");
//
//        System.out.println("1::::::::::::::::::::::::::::::::::::::::::::::::");
//        Map result1 = boshDirector.getInfo();
//        System.out.println(result1);
//        System.out.println(":::::::::::::::::::::::::::::::::::::::::::::::::");
//        System.out.println("");
//        System.out.println("2::::::::::::::::::::::::::::::::::::::::::::::::");
//
//        List<Map> result2 = boshDirector.getListDeployments();
//        for (Map map : result2) {
//            System.out.println(map.toString());
//            System.out.println("==================================================");
//        }
//        System.out.println(":::::::::::::::::::::::::::::::::::::::::::::::::");
//        System.out.println("");
//        System.out.println("3::::::::::::::::::::::::::::::::::::::::::::::::");
//
//        Map result3 = boshDirector.getDeployments("webide-broker-service");
//        System.out.println(result3.get("manifest").toString());
//
//        System.out.println(":::::::::::::::::::::::::::::::::::::::::::::::::");
//        System.out.println("");
//        System.out.println("4::::::::::::::::::::::::::::::::::::::::::::::::");
//        List<Map> result4 = boshDirector.getListEvents();
//        for (Map map : result4) {
//            System.out.println(map.toString());
//            System.out.println("==================================================");
//        }
//
//        System.out.println(":::::::::::::::::::::::::::::::::::::::::::::::::");
//        System.out.println("");
//        System.out.println("5::::::::::::::::::::::::::::::::::::::::::::::::");
//        Map result5 = boshDirector.getEvents("2830");
//        System.out.println(result5);
//        System.out.println(":::::::::::::::::::::::::::::::::::::::::::::::::");
//        System.out.println("");
//        System.out.println("6::::::::::::::::::::::::::::::::::::::::::::::::");
//        List<Map> result6 = boshDirector.getListTasks();
//        for (Map map : result6) {
//            System.out.println(map.toString());
//            System.out.println("==================================================");
//        }
//        System.out.println(":::::::::::::::::::::::::::::::::::::::::::::::::");
//        System.out.println("");
//        System.out.println("7::::::::::::::::::::::::::::::::::::::::::::::::");
//        Map result7 = boshDirector.getTask("1");
//        System.out.println(result7);
//        System.out.println(":::::::::::::::::::::::::::::::::::::::::::::::::");
//        System.out.println("");
//        System.out.println("8::::::::::::::::::::::::::::::::::::::::::::::::");
//        List<Map> result8 = boshDirector.getListStemcells();
//        for (Map map : result8) {
//            System.out.println(map.toString());
//            System.out.println("==================================================");
//        }
//        System.out.println(":::::::::::::::::::::::::::::::::::::::::::::::::");
//        System.out.println("");
//        System.out.println("9::::::::::::::::::::::::::::::::::::::::::::::::");
//        List<Map> result9 = boshDirector.getListInstances("paasta");
//        for (Map map : result9) {
//            System.out.println(map.toString());
//            System.out.println("==================================================");
//        }
//        System.out.println(":::::::::::::::::::::::::::::::::::::::::::::::::");
//        System.out.println("");
//        System.out.println("10::::::::::::::::::::::::::::::::::::::::::::::::");
//        List<Map> result10 = boshDirector.getListDetailDeploymentsVMS("paasta");
//        for (Map map : result10) {
//            System.out.println(map.toString());
//            System.out.println("==================================================");
//        }
//        System.out.println(":::::::::::::::::::::::::::::::::::::::::::::::::");
//        System.out.println("");
//        System.out.println("11::::::::::::::::::::::::::::::::::::::::::::::::");
//        List<Map> result11 = boshDirector.getListDeploymentsVMS("paasta");
//        for (Map map : result11) {
//            System.out.println(map.toString());
//            System.out.println("==================================================");
//        }
//        System.out.println(":::::::::::::::::::::::::::::::::::::::::::::::::");
//        System.out.println("");
//        System.out.println("12::::::::::::::::::::::::::::::::::::::::::::::::");
//        List<Map> result12 = boshDirector.getListDeploymentAssociatedWithTasks("paasta");
//        for (Map map : result12) {
//            System.out.println(map.toString());
//            System.out.println("==================================================");
//        }
//        System.out.println(":::::::::::::::::::::::::::::::::::::::::::::::::");
//        System.out.println("");
//        System.out.println("13::::::::::::::::::::::::::::::::::::::::::::::::");
//
//        boolean processing = true;
//        while (processing) {
//            List<Map> result13 = boshDirector.getListRunningTasks();
//
//            if (result13.size() > 0) {
//                for (Map map : result13) {
//                    System.out.println(map.toString());
//                    System.out.println("==================================================");
//                }
//                try {
//                    Thread.sleep(10000);
//                } catch (Exception e) {
//
//                }
//            } else {
//                System.out.println("END");
//                processing = false;
//            }
//        }

//        System.out.println(":::::::::::::::::::::::::::::::::::::::::::::::::");
//        System.out.println("");
//        System.out.println("14::::::::::::::::::::::::::::::::::::::::::::::::");
//        List<Map> result14 = boshDirector.getListContextIDAssociatedWithTasks();
//        for (Map map : result14) {
//            System.out.println(map.toString());
//            System.out.println("==================================================");
//        }
//        System.out.println(":::::::::::::::::::::::::::::::::::::::::::::::::");
//        System.out.println("");
//        System.out.println("15::::::::::::::::::::::::::::::::::::::::::::::::");
//        List<Map> result15 = boshDirector.getListDeploymentsWithoutCRS();
//        for (Map map : result15) {
//            System.out.println(map.toString());
//            System.out.println("==================================================");
//        }
//
//        System.out.println(":::::::::::::::::::::::::::::::::::::::::::::::::");
//        System.out.println("");
//        System.out.println("16::::::::::::::::::::::::::::::::::::::::::::::::");
//        List<Map> result16 = boshDirector.getUploadReleases();
//        for (Map map : result16) {
//            System.out.println(map.toString());
//            System.out.println("==================================================");
//        }
//
//
//        System.out.println(":::::::::::::::::::::::::::::::::::::::::::::::::");
//        System.out.println("");
//        System.out.println("17::::::::::::::::::::::::::::::::::::::::::::::::");
//        Map result17 = boshDirector.getRetrieveTasksLog("1","event");
//        System.out.println(result17.toString());

//        System.out.println(":::::::::::::::::::::::::::::::::::::::::::::::::");
//        System.out.println("");
//        System.out.println("17::::::::::::::::::::::::::::::::::::::::::::::::");
//        System.out.println(result3.get("manifest"));
///       String man = "name: paasta-mysql-service                              \n" + "\n" + "releases:\n" + "- name: paasta-mysql                                    \n" + "  version: \"2.0\"                                        \n" + "\n" + "stemcells:\n" + "- alias: default\n" + "  os: ubuntu-trusty\n" + "  version: \"3309\"\n" + "\n" + "update:\n" + "  canaries: 1                            \n" + "  canary_watch_time: 30000-600000        \n" + "  max_in_flight: 1                       \n" + "  update_watch_time: 30000-600000        \n" + "\n" + "instance_groups:\n" + "- name: mysql\n" + "  azs:\n" + "  - z5\n" + "  instances: 2\n" + "  vm_type: minimal\n" + "  stemcell: default\n" + "  persistent_disk_type: 8GB\n" + "  networks:\n" + "  - name: service_private\n" + "    ip:\n" + "    - 10.30.50.32\n" + "  properties:\n" + "    admin_password: admin                \n" + "    cluster_ips:                         \n" + "    - 10.30.50.32\n" + "    - 10.30.50.31\n" + "    network_name: service_private\n" + "    seeded_databases: null\n" + "    syslog_aggregator: null\n" + "    collation_server: utf8_unicode_ci    \n" + "    character_set_server: utf8\n" + "  release: paasta-mysql\n" + "  template: mysql\n" + "\n" + "- name: proxy\n" + "  azs:\n" + "  - z5\n" + "  instances: 0\n" + "  vm_type: minimal\n" + "  stemcell: default\n" + "  networks:\n" + "  - name: service_private\n" + "    ip:\n" + "    - 10.30.50.33\n" + "  properties:\n" + "    cluster_ips:\n" + "    - 10.30.50.32\n" + "    external_host: 115.68.46.188.xip.io       \n" + "    nats:                                    \n" + "      machines:\n" + "      - 10.30.50.34 \n" + "      password: \"fxaqRErYZ1TD8296u9HdMg8ol8dJ0G\"\n" + "      port: 4222\n" + "      user: nats\n" + "    network_name: service_private\n" + "    proxy:                                   \n" + "      api_password: admin\n" + "      api_username: api\n" + "      api_force_https: false\n" + "    syslog_aggregator: null\n" + "  release: paasta-mysql\n" + "  template: proxy\n" + "\n" + "- name: paasta-mysql-java-broker\n" + "  azs:\n" + "  - z5\n" + "  instances: 1\n" + "  vm_type: minimal\n" + "  stemcell: default\n" + "  networks:\n" + "  - name: service_private\n" + "    ip:\n" + "    - 10.30.50.35\n" + "  properties:                                \n" + "    jdbc_ip: 10.30.50.32\n" + "    jdbc_pwd: admin\n" + "    jdbc_port: 3306\n" + "    log_dir: paasta-mysql-java-broker\n" + "    log_file: paasta-mysql-java-broker\n" + "    log_level: INFO\n" + "  release: paasta-mysql\n" + "  template: op-mysql-java-broker\n" + "\n" + "- name: broker-registrar\n" + "  lifecycle: errand                          \n" + "  azs:\n" + "  - z5\n" + "  instances: 1\n" + "  vm_type: minimal\n" + "  stemcell: default\n" + "  networks:\n" + "  - name: service_private\n" + "  properties:\n" + "    broker:\n" + "      host: 10.30.50.35\n" + "      name: mysql-service-broker\n" + "      password: cloudfoundry\n" + "      username: admin\n" + "      protocol: http\n" + "      port: 8080\n" + "    cf:\n" + "      admin_password: admin\n" + "      admin_username: admin_test\n" + "      api_url: https://api.115.68.46.188.xip.io\n" + "      skip_ssl_validation: true\n" + "  release: paasta-mysql\n" + "  template: broker-registrar\n" + "\n" + "- name: broker-deregistrar\n" + "  lifecycle: errand                          \n" + "  azs:\n" + "  - z5\n" + "  instances: 1\n" + "  vm_type: minimal\n" + "  stemcell: default\n" + "  networks:\n" + "  - name: service_private\n" + "  properties:\n" + "    broker:\n" + "      name: mysql-service-broker\n" + "    cf:\n" + "      admin_password: admin\n" + "      admin_username: admin_test\n" + "      api_url: https://api.115.68.46.188.xip.io\n" + "      skip_ssl_validation: true\n" + "  release: paasta-mysql\n" + "  template: broker-deregistrar\n" + "\n" + "\n" + "meta:\n" + "  apps_domain: 115.68.46.188.xip.io\n" + "  environment: null\n" + "  external_domain: 115.68.46.188.xip.io\n" + "  nats:\n" + "    machines:\n" + "    - 10.30.50.34 \n" + "    password: \"fxaqRErYZ1TD8296u9HdMg8ol8dJ0G\"\n" + "    port: 4222\n" + "    user: nats\n" + "  syslog_aggregator: null";
//        System.out.println(boshDirector.postCreateAndUpdateDeployment(man));

//        String instance = "instance_groups:\n" +
//                "- azs:\n" +
//                "  - z3\n" +
//                "  instances: 3\n" +
//                "  name: mariadb\n" +
//                "  networks:\n" +
//                "  - name: service_private\n" +
//                "  persistent_disk_type: 10GB\n" +
//                "  stemcell: default\n" +
//                "  syslog_aggregator: null\n" +
//                "  templates:\n" +
//                "  - name: mariadb\n" +
//                "    release: webide-broker-release\n" +
//                "  vm_type: small\n" +
//                "- azs:\n" +
//                "  - z3\n" +
//                "  instances: 1\n" +
//                "  name: webide-broker\n" +
//                "  networks:\n" +
//                "  - name: service_private\n" +
//                "  properties:\n" +
//                "    datasource:\n" +
//                "      password: Paasta@2018\n" +
//                "    server:\n" +
//                "      port: 8080\n" +
//                "    serviceDefinition:\n" +
//                "      id: af86588c-6212-11e7-907b-b6006ad3webide0\n" +
//                "      plan1:\n" +
//                "        id: a5930564-6212-11e7-907b-b6006ad3webide1\n" +
//                "    webide:\n" +
//                "      servers:\n" +
//                "      - http://115.68.47.184:8080/dashboard\n" +
//                "      - http://115.68.47.185:8080/dashboard\n" +
//                "  stemcell: default\n" +
//                "  syslog_aggregator: null\n" +
//                "  templates:\n" +
//                "  - name: web-ide-broker\n" +
//                "    release: webide-broker-release\n" +
//                "  vm_type: medium\n" +
//                "name: webide-broker-service\n" +
//                "properties:\n" +
//                "  mariadb:\n" +
//                "    admin_user:\n" +
//                "      password: Paasta@2018\n" +
//                "    host_names:\n" +
//                "    - mariadb0\n" +
//                "    port: 3306\n" +
//                "releases:\n" +
//                "- name: webide-broker-release\n" +
//                "  version: \"2.0\"\n" +
//                "stemcells:\n" +
//                "- alias: default\n" +
//                "  os: ubuntu-trusty\n" +
//                "  version: 3586.25\n" +
//                "update:\n" +
//                "  canaries: 1\n" +
//                "  canary_watch_time: 5000-120000\n" +
//                "  max_in_flight: 1\n" +
//                "  serial: false\n" +
//                "  update_watch_time: 5000-120000";
//        boshDirector.postCreateAndUpdateDeployment(instance);
//        System.out.println(boshDirector.getListInstances("webide-broker-service").toString());

//        try {
//            if (boshDirector.deploy("webide-broker-service", "mariadb", "3")) {
//                System.out.println("Deploy Complate");
//            } else {
//                System.out.println("Deploy Fails");
//            }
//        } catch (Exception e) {
//            e.printStackTrace();
//        }

//        boshDirector.updateIgnoreInstance("webide-broker-service", "mariadb", "7b7612ad-de00-460f-839a-3ddc2e77f074", false);

//        List<Map> maps = boshDirector.getListInstances("webide-broker-service");
//        for (Map map : maps) {
//            System.out.println(map.get("job") + " " + map.get("id") + "  " + map.get("expects_vm"));
//            System.out.println(map.toString());
//            System.out.println("==================================================");
//        }
//        System.out.println("");
//        System.out.println(":::::::::::::::::::::::::::::::::::::::::::::::::");
//        Map map = boshDirector.getIgnore("webide-broker-service");
//        System.out.println(map);


//        boolean processing = true;
//        System.out.println("Deploy Process Check...");
//        int i = 1;
//        try {
//            while (processing) {
//                List<Map> deployTask = boshDirector.getListRunningTasks();
//                int cnt = 0;
//                for (Map map : deployTask) {
//
//                    System.out.println(map.toString());
//                    System.out.println("==================================================");
//
//                }
//                System.out.println("::::::::::::::::::::::::: " + i++);
//                Thread.sleep(10000);
//            }
//        } catch (Exception e) {
//            e.printStackTrace();
//        }

        boshDirector.updateInstanceState("paasta-mysql-service","mysql","a0855749-0994-4d4d-b9ce-77a85f797b57",BoshDirector.INSTANCE_STATE_DETACHED);

    }


}
