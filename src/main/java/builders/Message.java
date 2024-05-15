package builders;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import java.util.List;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class Message {

    @JsonProperty("role")
    private String role;
    @JsonProperty("content")
    private String content;
    @JsonProperty("role")
    public String getRole() {
        return role;
    }
    @JsonProperty("content")
    public String getContent() {
        return content;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Message withRole(String role) {
        this.role = role;
        return this;
    }

    public Message withContent(String content) {
        this.content = content;
        return this;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(ToStringStyle.JSON_STYLE)
                .append("role", getRole())
                .append("content", getContent())
                .toString();
    }
}