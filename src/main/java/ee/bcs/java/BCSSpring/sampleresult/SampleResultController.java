package ee.bcs.java.BCSSpring.sampleresult;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SampleResultController {

    @GetMapping("SampleResult")
    public SampleResult sampleResultLesson() {
        SampleResult a = new SampleResult();
        a.setStatus("OK");
        a.setMessage("I like Metallica");
        return a;
    }
    //выведет в формате json
    //{"status":"OK","message":"I like Metallica"}

}
