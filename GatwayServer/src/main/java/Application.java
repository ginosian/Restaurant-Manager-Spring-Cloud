import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;

/**
 * Created by Martha on 2/26/2017.
 */
@SpringBootApplication
@EnableDiscoveryClient
@EnableZuulProxy
public class Application {
    public static void main(String[] args){
        SpringApplication.run(Application.class, args);
    }
}
