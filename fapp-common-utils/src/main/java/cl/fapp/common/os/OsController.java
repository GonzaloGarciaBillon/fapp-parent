package cl.fapp.common.os;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class OsController {

    @GetMapping("/os")
    public String getOperatingSystem() {
        String osName = System.getProperty("os.name").toLowerCase();
        if (osName.contains("windows")) {
            return "Windows";
        } else if (osName.contains("linux")) {
            return "Linux";
        } else {
            return "Desconocido";
        }
    }
}
