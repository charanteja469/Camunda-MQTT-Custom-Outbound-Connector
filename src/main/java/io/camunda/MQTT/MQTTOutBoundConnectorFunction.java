package io.camunda.MQTT;

import io.camunda.connector.api.annotation.OutboundConnector;
import io.camunda.connector.api.outbound.OutboundConnectorContext;
import io.camunda.connector.api.outbound.OutboundConnectorFunction;
import io.camunda.connector.generator.java.annotation.ElementTemplate;
import io.camunda.MQTT.dto.MQTT;
import io.camunda.MQTT.dto.MQTTOutboundConnectorRequest;
import io.camunda.MQTT.dto.MQTTOutboundConnectorResult;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@OutboundConnector(
        name = "MQTT OutBound Connector",
        inputVariables = {"serverurl", "Topic", "clientId","message"},
        type = "io.camunda:template:1")
@ElementTemplate(
        id = "0b29c841-96bd-4af6-9485-143905dc4eea",
        name = "MQTT OutBound Connector",
        version = 1,
        description = "This custom connector links Camunda 8 to MQTT, allowing workflows to publish and consume messages for real-time, event-driven process automation.",
        inputDataClass = MQTTOutboundConnectorRequest.class)
public class MQTTOutBoundConnectorFunction implements OutboundConnectorFunction {

  private static final Logger LOGGER = LoggerFactory.getLogger(MQTTOutBoundConnectorFunction.class);

  @Override
  public Object execute(OutboundConnectorContext context) {
    final var connectorRequest = context.bindVariables(MQTTOutboundConnectorRequest.class);
    return executeConnector(connectorRequest);
  }

  private MQTTOutboundConnectorResult executeConnector(final MQTTOutboundConnectorRequest connectorRequest) {

    String ServerURL = connectorRequest.serverurl();
    System.out.println("ServerURL : "+ServerURL);
    String MQTTTopic =  connectorRequest.Topic();
    String ClientId = connectorRequest.clientId();
    String Message = connectorRequest.message();
    MQTT mqtt = new MQTT();
    String result=mqtt.messagePublish(ServerURL,MQTTTopic,ClientId,Message);

    System.out.println("ServerURL : "+ServerURL);
    System.out.println("MQTTTopic : "+MQTTTopic);
    System.out.println("ClientId : "+ClientId);
    System.out.println("Message : "+Message);
    System.out.println("Message Published Status : " +result);

    return new MQTTOutboundConnectorResult("Message Published Status : " +result);
  }
}
