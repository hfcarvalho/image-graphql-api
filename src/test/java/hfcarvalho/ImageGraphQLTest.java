package hfcarvalho;

import static junit.framework.TestCase.assertTrue;

import java.io.IOException;
import java.util.List;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.graphql.spring.boot.test.GraphQLResponse;
import com.graphql.spring.boot.test.GraphQLTestTemplate;

import hfcarvalho.image.domain.Image;
import lombok.extern.java.Log;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@Log
public class ImageGraphQLTest extends GraphQLTestTemplate {

    @Test
    public void testGetFolders() throws IOException, JSONException {

        GraphQLResponse response = perform("folder.graphql", null);

        assertTrue(response.isOk());

        String json = response.getRawResponse().getBody();
        log.info("Body: " + json);

        JSONArray jsonArray = new JSONObject(json).getJSONObject("data").getJSONArray("images");
        log.info("Array: "+jsonArray);

        ObjectMapper mapper = new ObjectMapper();

        List<Image> folders = mapper.readValue(jsonArray.toString(), new TypeReference<List<Image>>(){});

        folders.forEach(f -> log.info(f.getName()));
    }
}
