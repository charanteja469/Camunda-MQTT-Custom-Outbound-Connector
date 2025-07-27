# Camunda 8 Eclipse Mosquitto Custom Outbound Connector

Camunda 8 Eclipse Mosquitto Custom Outbound Connector is a custom connector (built using the Camunda Connector SDK, usually in Java) designed to integrate Camunda 8 workflows with MQTT brokers such as Eclipse Mosquitto. It enables service tasks in BPMN processes to publish messages to specified MQTT topics, supporting asynchronous, event-driven communication between Camunda processes and IoT or messaging systems. Developers can configure MQTT broker address, topic, QoS, and message content directly within their BPMN models—facilitating seamless process automation and connectivity to MQTT-enabled devices and applications.


<img width="940" height="348" alt="image" src="https://github.com/user-attachments/assets/20e7e3ad-dc9f-4aa2-8e55-f1e7352a13d4" />


### Eclipse 

Eclipse Mosquitto is a small, open-source MQTT broker designed for fast and efficient messaging between devices and applications. It is ideal for IoT scenarios requiring real-time, topic-based communication. Easy to deploy and use, Mosquitto supports persistence, security, and cross-platform operation

1. Implements the MQTT protocol for lightweight, real-time publish/subscribe messaging.
2. Supports message persistence and offline delivery with proper QoS settings.
3. Enables secure communication with support for authentication and access control.
4. Can bridge with other brokers for distributed messaging across networks.
5. Runs efficiently on both embedded devices and servers (cross-platform: Windows, Linux, macOS).

you can download and host MQTT from here   👉🏻 (https://mosquitto.org/download/)

after downloding Eclipse Mosquitto follow below commands to run

1. Terminal 1:   mosquitto.exe -v



## Test with SaaS and Self-Managed

#### Setting Up the Saas Environment:

1. Navigate to Camunda [SaaS](https://console.camunda.io).
2. Create a cluster using the latest version available.
3. Select your cluster, then go to the `API` section and click `Create new Client`.
4. Ensure the `zeebe` checkbox is selected, then click `Create`.
5. Copy the configuration details displayed under the `Spring Boot` tab.
6. Paste the copied configuration into your `application.properties` file within your project.

#### Setting Up the Self-Managed Environment:

1. Set up the Camunda 8 Self-Managed(https://docs.camunda.io/docs/self-managed/setup/deploy/local/docker-compose/).
2. Cluster endpoint is http://localhost:26500
3. uncomment the properties in test resource folder

   (camunda.client.zeebe.grpc-address=http://localhost:26500)
   
   (camunda.client.zeebe.rest-address=http://localhost:8088)
5. download desktop modeler if requires (https://camunda.com/download/modeler/)


### Launching Your Connector

1. Start your connector by executing `io.camunda.MQTT.LocalConnectorRuntime` in your development environment.
2. Access the Web Modeler or Desktop Modeler and create a new project.
3. Click on `Create new`, then select `Upload files`. Upload the connector template from the repository you have((https://github.com/charanteja469/Camunda-MQTT-Custom-Outbound-Connector/blob/master/element-templates/Eclipse%20Mosquitto%20Outbound%20Connector.json))

 NOTE: if your using Desktop modeler--> go to modeler folder-->resources-->element-templates-->Past the above downloaded Eclipse mosquitto Connector Template

4. In the same folder, create a new BPMN diagram.
5. Design and start a process that incorporates your new connector.

# STEP BY STEP Process to Configure and Use Eclipse mosquitto Outbound Connector

1. Create a workflow with Start event, Task, End Event
2. select the task and click on element change type and search for Eclipse mosquitto Outbound Connector

<img width="940" height="374" alt="image" src="https://github.com/user-attachments/assets/6a7b6ad9-6a31-45e0-810f-00426c49c06e" />



3. Configure the Input like (Connection, Topic, ClientId, Message)

   <img width="940" height="379" alt="image" src="https://github.com/user-attachments/assets/158b4a43-65a0-40d9-a2af-71657a3f8066" />


   #### Input :

    serverURL : tcp://localhost:1883
   
    Topic : Order

    clientId : charan26
   
    Message : your order delivered successfully...

5. Configure the output Result Expression

   <img width="940" height="372" alt="image" src="https://github.com/user-attachments/assets/e950f9c4-132a-4248-87ec-d846892f7b9d" />


   #### Result Expression :

   {"Status":result}

6. Deploy the process and Start the Process
7. Start the Connector Runtime

<img width="940" height="457" alt="image" src="https://github.com/user-attachments/assets/b4c13877-47f3-4583-a895-66a521e45833" />
<img width="940" height="434" alt="image" src="https://github.com/user-attachments/assets/6cfc99e0-72ad-4b75-92da-56c4fe2f3441" />


 7. Eclipse mosquitto Outbound Connector successfully published the message.
    
    <img width="940" height="425" alt="image" src="https://github.com/user-attachments/assets/ee09fdd3-fa83-45a8-8124-e9344a34ee4d" />
    <img width="940" height="430" alt="image" src="https://github.com/user-attachments/assets/207dc44f-0b4a-437d-a8e5-0b89df777b5e" />

    <img width="940" height="246" alt="image" src="https://github.com/user-attachments/assets/ddc5f6c7-52aa-421c-9a93-cf1e09e476ea" />


    

8. Now you can open the Eclipse Mosquitto consumer application and consume the message.

   here i'm using Eclipse Mosquitto Consumer CLI. Run this Command and consume the message

   👉🏻  mosquitto_sub.exe -t order

   <img width="940" height="188" alt="image" src="https://github.com/user-attachments/assets/c077c9fd-4c17-46c0-b735-9a9616f725b8" />


## Refer Camunda BPMN File

you can refer the Camunda BPMN file here 👉🏻 https://github.com/charanteja469/Camunda-MQTT-Custom-Outbound-Connector/blob/master/src/main/resources/META-INF/services/MQTT.bpmn

    












