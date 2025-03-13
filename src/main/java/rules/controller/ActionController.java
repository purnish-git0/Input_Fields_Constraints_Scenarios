package rules.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import rules.request.ActionFieldDTO;

@RestController
@RequestMapping("/api/v1/action")
public class ActionController {

    public ActionController()
    public ResponseEntity<String> createActionOnFieldWithScenario(@RequestBody ActionFieldDTO actionFieldDTO) {

    }
}
