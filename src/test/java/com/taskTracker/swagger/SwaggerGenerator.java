package com.taskTracker.swagger;

import com.taskTracker.AbstractTest;
import com.taskTracker.TaskTrackerApplication;
import org.json.JSONObject;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.yaml.snakeyaml.Yaml;

import java.io.File;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;

@SpringBootTest(classes = {TaskTrackerApplication.class})
public class SwaggerGenerator extends AbstractTest {

    @Test
    public void generateSwagger() throws Exception {
        Yaml yaml = new Yaml();
        mockMvc.perform(MockMvcRequestBuilders.get("/v3/api-docs").accept(MediaType.APPLICATION_JSON))
                .andDo((result) -> {
                    JSONObject jsonObject = new JSONObject(result.getResponse().getContentAsString(StandardCharsets.UTF_8));
                    String forWrite = yaml.dump(yaml.load(jsonObject.toString(4)));
                    Files.writeString(new File("../openapi.yaml").toPath(), forWrite, StandardCharsets.UTF_8);
                });
    }

}
