package builders;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import java.util.List;

@JsonInclude(JsonInclude.Include.NON_NULL)

public class MessageRequest {

    @JsonProperty("model")
    private String model;
    @JsonProperty("messages")
    private List<Message> messages;

    // Constructor, getters, and setters
    public MessageRequest() {}

    @JsonProperty("model")
    public String getModel() {
        return model;
    }
    @JsonProperty("messages")
    public List<Message> getMessages() {
        return messages;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public void setMessages(List<Message> messages) {
        this.messages = messages;
    }

    public MessageRequest withModel(String model) {
        this.model = model;
        return this;
    }

    public MessageRequest withMessage(List<Message> messages) {
        this.messages = messages;
        return this;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(ToStringStyle.JSON_STYLE)
                .append("model", getModel())
                .append("messages", messages)
                .toString();
    }
}