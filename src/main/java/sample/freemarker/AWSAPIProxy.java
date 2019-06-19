package sample.freemarker;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collections;

@RestController
public class AWSAPIProxy {

    @GetMapping("/v2/metadata")
    public String metadata() {

        return getString("/v2/metadata");
    }

    @GetMapping("/v2/metadata/{containerId}")
    public String containerIdMetaData(@PathVariable String containerId) {

        return getString("/v2/metadata/"+containerId);
    }


    @GetMapping("/v2/stats")
    public String stats() {

        return getString("/v2/metadata");
    }


    @GetMapping("/v2/stats/{containerId}")
    public String containerIdStats(@PathVariable String containerId) {

        return getString("/v2/metadata/"+containerId);
    }



    private String getString(String url) {
        String jsonResponse = "";

        try {
            HttpRequest httpRequest = new HttpRequest();
            jsonResponse = httpRequest.requestDataFromUrl("http://169.254.169.254/"+url);
        }
        catch(Exception e){
            e.printStackTrace();
            }


        return jsonResponse;
    }


}
