package io.camunda.MQTT.dto;

import io.camunda.connector.generator.java.annotation.TemplateProperty;
import io.camunda.connector.generator.java.annotation.TemplateProperty.PropertyType;
import jakarta.validation.constraints.NotEmpty;

public record MQTTOutboundConnectorRequest(
        @NotEmpty @TemplateProperty(group = "compose", type = PropertyType.Text)
        String serverurl,
        String Topic,
        String clientId,
        String message) {}
