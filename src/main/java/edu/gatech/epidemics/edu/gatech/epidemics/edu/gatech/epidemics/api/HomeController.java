package edu.gatech.epidemics.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;


@RestController
public class HomeController {

    @Autowired
    Environment environment;

    @RequestMapping("/")
    public String Hello() throws UnknownHostException {
        String datePattern = "MM/dd/yyyy HH:mm:ss";
        DateTimeFormatter df = DateTimeFormatter.ofPattern(datePattern);
        LocalDateTime now = LocalDateTime.now();

        String hostName = InetAddress.getLocalHost().getHostName();
        String port = environment.getProperty("local.server.port");

        return "Do you speak whale? - Web server @ " + df.format(now) + ". <br/><br/><br/><b>Host:</b> " + hostName + " <span style=\"color:red;\">:</span> " + port;
    }
}