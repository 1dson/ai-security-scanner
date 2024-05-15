import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

import builders.MessageRequest;
import builders.Message;
import io.restassured.response.ValidatableResponse;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import utils.RestVerbs;

public class AI {
    private String openAPIKey;
    private String openAIOrgId;
    private String openAPIProject;
    private String URL = "https://api.openai.com/v1/chat/completions";
    private String AI_MODEL = "gpt-4o-2024-05-13";
    private String QUERY = "Scan for security vulnerabilities on following ";

    public String scan(String body) {
        Document doc = Jsoup.parse(body);
        Map<String, String> headers = new HashMap<>();
        headers.put("Authorization", "Bearer " + getOpenAPIKey());
        headers.put("OpenAI-Organization", getOpenAIOrgId());
        headers.put("OpenAI-Project", getOpenAPIProject());
        Message message = new Message().withRole("user").withContent(QUERY + " " + doc);
        MessageRequest createMessage = new MessageRequest().withModel(AI_MODEL).withMessage(Collections.singletonList(message));
        ValidatableResponse response = RestVerbs.post(URL,createMessage,headers);
        return response.extract().body()
                .jsonPath().get("choices.message.content").toString();
    }

    public String getOpenAPIKey() {
        return openAPIKey;
    }

    public void setOpenAPIKey(String openAPIKey) {
        this.openAPIKey = openAPIKey;
    }

    public String getOpenAIOrgId() {
        return openAIOrgId;
    }

    public void setOpenAIOrgId(String openAIOrgId) {
        this.openAIOrgId = openAIOrgId;
    }

    public String getOpenAPIProject() {
        return openAPIProject;
    }

    public void setOpenAPIProject(String openAPIProject) {
        this.openAPIProject = openAPIProject;
    }
}